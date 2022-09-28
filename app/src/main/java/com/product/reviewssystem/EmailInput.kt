package com.product.reviewssystem

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class EmailInput : AppCompatActivity() {
    private lateinit var email: TextInputEditText
    private lateinit var emailString: String
    private lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_input)
        btn = findViewById(R.id.btnEmailNext)

        btn.setOnClickListener {
            email = findViewById(R.id.emailET)
            emailString = email.text.toString()
            btn.setOnClickListener {
                if(!TextUtils.isEmpty(emailString) && Patterns.EMAIL_ADDRESS.matcher(emailString).matches()) {
                   // Can go to the next page
                    Toast.makeText(applicationContext, "Valid", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(applicationContext, "Invalid", Toast.LENGTH_LONG).show()
                }
            }
        }



    }



}