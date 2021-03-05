package com.codewithsouma.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity : AppCompatActivity() {
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    private val validMobileNumber = "8768454982"
    private val validPassword = arrayOf("tony","steve","bruce","thanos","Admin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegisterYourself)

        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString().trim()
            val password = etPassword.text.toString().trim()
            validateAndLogin(mobileNumber, password)
        }
    }

    private fun validateAndLogin(mobileNumber: String, password: String) {
        var nameOfAvenger = "Avenger"
        if ((validMobileNumber == mobileNumber)) {
            val intent = Intent(this@NewActivity, MainActivity::class.java)

            when (password) {
                validPassword[0] -> {
                    nameOfAvenger = "Iron Man"
                    intent.putExtra("nameOfAvenger", nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[1] -> {
                    nameOfAvenger = "Captain America"
                    intent.putExtra("nameOfAvenger", nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[2] -> {
                    nameOfAvenger = "The Hulk"
                    intent.putExtra("nameOfAvenger", nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[3] -> {
                    nameOfAvenger = "The Avengers"
                    intent.putExtra("nameOfAvenger", nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[4] -> {
                    nameOfAvenger = "Admin"
                    intent.putExtra("nameOfAvenger", nameOfAvenger)
                    startActivity(intent)
                }
                else -> Toast.makeText(this@NewActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }
        } else Toast.makeText(this@NewActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
    }
}