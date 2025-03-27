package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class payActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_payment) // ใช้ layout ที่ถูกต้อง

        val buttonNEXT: Button = findViewById(R.id.buttonNEXT)

        buttonNEXT.setOnClickListener {
            val intent = Intent(this, bankActivity::class.java) // เปลี่ยนชื่อ Activity ตามต้องการ
            startActivity(intent)
        }
    }
}
