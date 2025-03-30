package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class cancelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_cancel) // ใช้ layout ที่ถูกต้อง

        val cancel: Button = findViewById(R.id.cancel)

        cancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // เปลี่ยนชื่อ Activity ตามต้องการ
            startActivity(intent)
            finish()
        }
    }
}