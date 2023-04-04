package com.example.devmobilebarillecas

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val button1 = findViewById<Button>(R.id.buttonBarilleThomas)
        val button2 = findViewById<Button>(R.id.buttonCasMarcOlivier)

        button1.setOnClickListener {
            // Action à effectuer lorsque le bouton 1 est cliqué
        }

        button2.setOnClickListener {
            // Action à effectuer lorsque le bouton 2 est cliqué
        }
    }
}