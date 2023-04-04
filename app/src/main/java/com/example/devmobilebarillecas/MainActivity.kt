package com.example.devmobilebarillecas

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var splashImage: ImageView
    private lateinit var button1: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashImage = findViewById(R.id.splash_image)
        button1 = findViewById(R.id.buttonInfo)
        button2 = findViewById(R.id.buttonProducts)

        // Cacher les boutons
        button1.visibility = View.GONE
        button2.visibility = View.GONE

        // Faire disparaître l'image de splash après 2 secondes
        Handler().postDelayed({
            splashImage.animate().alpha(0f).setDuration(1000).withEndAction {
                splashImage.visibility = View.GONE
                // Afficher les boutons après la disparition de l'image de splash
                button1.visibility = View.VISIBLE
                button2.visibility = View.VISIBLE
            }
        }, 5000)

        // Ajouter les listeners pour les clics sur les boutons
        button1.setOnClickListener {
            Toast.makeText(this, "Clic sur le bouton 1", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            Toast.makeText(this, "Clic sur le bouton 2", Toast.LENGTH_SHORT).show()
        }
    }
}
