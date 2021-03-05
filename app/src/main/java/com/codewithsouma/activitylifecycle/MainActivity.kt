package com.codewithsouma.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var titleName:String? = "Avengers"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_view_example_layout)
        if (intent != null){
            titleName = intent.getStringExtra("nameOfAvenger")
        }

        title = titleName
    }
}