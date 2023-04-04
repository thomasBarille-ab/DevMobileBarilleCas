package com.example.devmobilebarillecas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val buttonBarilleThomas = findViewById<Button>(R.id.buttonBarilleThomas)
        val buttonCasMarcOlivier = findViewById<Button>(R.id.buttonCasMarcOlivier)

        buttonBarilleThomas.setOnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            intent.putExtra("student_name", "BARILLE Thomas")
            intent.putExtra("student_infos", "Je suis étudiant à l'epsi en 3ème année, je suis un grand fan des Clippers")
            intent.putExtra("student_email", "thomas.barille@espi.fr")
            intent.putExtra("student_group", "Groupe : B3-Dev 1 spé IA")
            startActivity(intent)
        }

        buttonCasMarcOlivier.setOnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            intent.putExtra("student_name", "CAS Marc-Olivier")
            intent.putExtra("student_infos", "Je suis étudiant à l'epsi en 3ème année, je suis un grand fan des Bucks")
            intent.putExtra("student_email", "marcolivier.cas@espi.fr")
            intent.putExtra("student_group", "Groupe : B3-Dev 1 spé IA")
            startActivity(intent)
        }
    }
}