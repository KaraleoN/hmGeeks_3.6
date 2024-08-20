package com.geeks.hmgeeks_36

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var messageContainer: LinearLayout
    private var state = false // Состояние для управления цветом

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageContainer = findViewById(R.id.messageContainer)
        val buttonAddMessage: Button = findViewById(R.id.buttonAddMessage)

        buttonAddMessage.setOnClickListener {
            addMessage()
        }
    }

    private fun addMessage() {
        // Создаем новое TextView для сообщения
        val messageTextView = TextView(this).apply {
            text = if (state) "Синее сообщение" else "Зеленое сообщение"
            setPadding(16, 16, 16, 16)
            gravity = Gravity.START
            setTextColor(Color.WHITE)
            setBackgroundColor(if (state) Color.BLUE else Color.GREEN)
        }

        // Добавляем TextView в контейнер
        messageContainer.addView(messageTextView)

        // Меняем состояние для следующего сообщения
        state = !state
    }
}