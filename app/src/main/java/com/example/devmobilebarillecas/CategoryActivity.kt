package com.example.devmobilebarillecas

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_category)

    val backButton = findViewById<ImageButton>(R.id.back_button)
    backButton.setOnClickListener {
        finish()
        }
    }

}