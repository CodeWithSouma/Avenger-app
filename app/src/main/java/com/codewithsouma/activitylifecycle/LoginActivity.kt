package com.codewithsouma.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    private val validMobileNumber = "8768454982"
    private val validPassword = arrayOf("tony","steve","bruce","thanos","Admin")
    lateinit var sharedPreference : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreference = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreference.getBoolean("isLoggedIn",false)
        if (isLoggedIn){
            val intent = Intent(this@LoginActivity,AvengersActivity::class.java)

            startActivity(intent)
            finish()
        }


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
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            when (password) {
                validPassword[0] -> {
                    nameOfAvenger = "Iron Man"
                    savePreference(nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[1] -> {
                    nameOfAvenger = "Captain America"
                    savePreference(nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[2] -> {
                    nameOfAvenger = "The Hulk"
                    savePreference(nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[3] -> {
                    nameOfAvenger = "The Avengers"
                    savePreference(nameOfAvenger)
                    startActivity(intent)
                }
                validPassword[4] -> {
                    nameOfAvenger = "Admin"
                    savePreference(nameOfAvenger)
                    startActivity(intent)
                }
                else -> Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }
        } else Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
    }


    override fun onPause() {
        super.onPause()
        finish()
    }

    private fun savePreference(title:String){
        sharedPreference.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreference.edit().putString("title",title).apply()
    }
}