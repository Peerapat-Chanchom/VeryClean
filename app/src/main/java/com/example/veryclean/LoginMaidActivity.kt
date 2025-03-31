package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginMaidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.maidlogin)

        val btn = findViewById<TextView>(R.id.btn_login1)
        btn.setOnClickListener {
            val intent = Intent(this, MaidMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}