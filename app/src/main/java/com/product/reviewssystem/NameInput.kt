package com.product.reviewssystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class NameInput : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var firstName: TextInputEditText
    private lateinit var lastName: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_input)

        btn = findViewById(R.id.btnNameNext)
        firstName = findViewById(R.id.firstnameET)
        lastName = findViewById(R.id.lastnameET)

// TODO: Try to implement a solution where we dynamically check if current input for first name or last name contains space and shows the error immediately.

//        firstName.addTextChangedListener(object: TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if (s?.get(s.length - 1)?:  == " ") {
//                    Toast.makeText(applicationContext, "Hello", Toast.LENGTH_LONG).show();
//                }
//            }
//
//        })
        btn.setOnClickListener {

            val firstNameString = firstName.text.toString()
            val lastNameString = lastName.text.toString()

            // If first or last name contains space or is empty this variable is set to false, which stops app from loading next page
            var canGoToNextPage = true

            if (firstNameString.contains(" ")) {
                firstName.error = "Space not allowed"
                canGoToNextPage = false
            }
            if (lastNameString.contains(" ")) {
                lastName.error = "Space not allowed"
                canGoToNextPage = false
            }
            if (firstNameString == "") {
                firstName.error = "Field is required"
                canGoToNextPage = false
            }
            if (lastNameString == "") {
                lastName.error = "Field is required"
                canGoToNextPage = false
            }
            if (canGoToNextPage) {
                startActivity(Intent(this, EmailInput::class.java))
            }
        }


    }
}