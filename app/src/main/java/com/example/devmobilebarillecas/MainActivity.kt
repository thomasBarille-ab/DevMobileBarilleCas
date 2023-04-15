package com.example.devmobilebarillecas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

    private lateinit var splashImage: ImageView
    private lateinit var buttonInfo: Button
    private lateinit var buttonProducts: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashImage = findViewById(R.id.splash_image)
        buttonInfo = findViewById(R.id.buttonInfo)
        buttonProducts = findViewById(R.id.buttonProducts)

        // Cacher les boutons
        buttonInfo.visibility = View.GONE
        buttonProducts.visibility = View.GONE

        // Faire disparaître l'image de splash après 2 secondes
        Handler().postDelayed({
            splashImage.animate().alpha(0f).setDuration(1000).withEndAction {
                splashImage.visibility = View.GONE
                // Afficher les boutons après la disparition de l'image de splash
                buttonInfo.visibility = View.VISIBLE
                buttonProducts.visibility = View.VISIBLE
            }
        }, 3000)

        // Ajouter les listeners pour les clics sur les boutons
        buttonInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
        buttonProducts.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)        }
        }


}
