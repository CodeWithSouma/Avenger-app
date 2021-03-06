package com.codewithsouma.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class AvengersActivity : AppCompatActivity() {
    var titleName:String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_avengers)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        title = sharedPreferences.getString("title","The Avengers")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.avengers_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.logout -> {
                sharedPreferences.edit().clear().apply()
                val intent = Intent(this@AvengersActivity,LoginActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.exit -> {
                finish()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}