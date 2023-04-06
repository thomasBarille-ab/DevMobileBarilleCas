package com.example.devmobilebarillecas

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        val studentInfos = intent.getStringExtra("student_infos")
        val studentName = intent.getStringExtra("student_name")
        val studentEmail = intent.getStringExtra("student_email")
        val studentGroup = intent.getStringExtra("student_group")
        val studentAvatar = findViewById<ImageView>(R.id.avatar_student)


        when (intent.getStringExtra("student_name")) {
            "BARILLE Thomas" -> {
                val infosTextView = findViewById<TextView>(R.id.student_infos_textview)
                val nameTextView = findViewById<TextView>(R.id.student_name_textview)
                val emailTextView = findViewById<TextView>(R.id.student_email_textview)
                val groupTextView = findViewById<TextView>(R.id.student_group_textview)

                infosTextView.text = studentInfos
                nameTextView.text = studentName
                emailTextView.text = studentEmail
                groupTextView.text = studentGroup
                studentAvatar.setImageResource(R.drawable.avatar_thomas)
            }
            "CAS Marc-Olivier" -> {
                val infosTextView = findViewById<TextView>(R.id.student_infos_textview)
                val nameTextView = findViewById<TextView>(R.id.student_name_textview)
                val emailTextView = findViewById<TextView>(R.id.student_email_textview)
                val groupTextView = findViewById<TextView>(R.id.student_group_textview)

                infosTextView.text = studentInfos
                nameTextView.text = studentName
                emailTextView.text = studentEmail
                groupTextView.text = studentGroup
                studentAvatar.setImageResource(R.drawable.avatar_marco)
            }
        }
    }
}