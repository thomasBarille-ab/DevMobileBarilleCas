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
            startActivity(intent)
        }

        buttonCasMarcOlivier.setOnClickListener {
            // Action à effectuer lorsque le bouton 2 est cliqué
        }
    }
}