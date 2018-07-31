package com.aptus.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.aptus.droidils.utils.setImeActionListener

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imeActionEdit.setImeActionListener { _, _ ->
            Toast.makeText(this, "Droidils Utils library", Toast.LENGTH_SHORT).show()
            true
        }
    }
}