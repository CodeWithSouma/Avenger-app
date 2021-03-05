package com.codewithsouma.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AvengersActivity : AppCompatActivity() {
    var titleName:String? = "Avengers"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_avengers)
        if (intent != null){
            titleName = intent.getStringExtra("nameOfAvenger")
        }

        title = titleName
    }
}