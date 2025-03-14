package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.veryclean.ui.home.HomeFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val signup = findViewById<TextView>(R.id.tv_signup3)
        val skip1 = findViewById<TextView>(R.id.skip)

        btnLogin.setOnClickListener {
            // ไปยัง MainActivity แทนการเปิด Fragment ตรง ๆ
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // ปิด LoginActivity เพื่อไม่ให้กลับมาหน้านี้อีก
        }
        signup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
        skip1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}