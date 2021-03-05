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
    private val validPassword = "Admin"

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

            if ((validMobileNumber == mobileNumber) && (validPassword == password)) {
                val intent = Intent(this@NewActivity, MainActivity::class.java)
                startActivity(intent)
            } else Toast.makeText(this@NewActivity, "Invalid Credentials", Toast.LENGTH_LONG).show()

        }
    }
}