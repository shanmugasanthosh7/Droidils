package com.aptus.droidils

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.aptus.droidils.utils.*

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val jsonObject = User("Droidils","25") // Object
        val jsonString = jsonObject.toJson() // Object to Json
        Log.d("Droidils", jsonString)
    }
}
