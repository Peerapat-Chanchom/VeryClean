package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class bankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_banking) // ใช้ layout ที่ถูกต้อง

        val buttonSUB: Button = findViewById(R.id.buttonsss)

        buttonSUB.setOnClickListener {
            val intent = Intent(this, qrActivity::class.java) // เปลี่ยนชื่อ Activity ตามต้องการ
            startActivity(intent)
            finish()
        }
    }
}