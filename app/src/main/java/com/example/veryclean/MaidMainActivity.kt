package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MaidMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summaid)

        // หา ImageView โดยตรง ไม่ต้องใช้ root
        val maid1: ImageView = findViewById(R.id.imageView6)

        // ตั้งค่า onClickListener ให้กับ maid1 (ถ้าใช่)
        maid1.setOnClickListener {
            val intent = Intent(this, MaidActivity2::class.java)
            startActivity(intent)
        }
    }
}
