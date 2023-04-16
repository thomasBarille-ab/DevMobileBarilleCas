package com.example.devmobilebarillecas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_view)

        fun setHeaderTitle( title:String?){
            val textViewTitle= findViewById<TextView>(R.id.textViewTitle)
            textViewTitle.setText(title)
        }
        val backButton = findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }



        // Retrieve the extras from the intent
        val pictureUrl = intent.getStringExtra("picture_url")
        val description = intent.getStringExtra("description")
        val name = intent.getStringExtra("name")

        setHeaderTitle(name)

        // Find the UI elements
        val productImage: ImageView = findViewById(R.id.product_image)
        val productDescription: TextView = findViewById(R.id.product_description)

        // Load the image using Picasso
        Picasso.get().load(pictureUrl).into(productImage)

        // Set the text for the TextViews
        productDescription.text = description
    }
}