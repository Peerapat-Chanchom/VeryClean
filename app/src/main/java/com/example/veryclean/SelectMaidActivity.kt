package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectMaidActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sl_maid)
        val next: Button = findViewById(R.id.next)

        next.setOnClickListener{
            val intent = Intent(this, payActivity::class.java) // เปลี่ยนชื่อ Activity ตามต้องการ
            startActivity(intent)
        }
    }
}