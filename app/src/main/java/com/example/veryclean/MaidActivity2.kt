package com.example.veryclean

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MaidActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_maid2)

        val maid1: ImageView = findViewById(R.id.imageView10)

        // ตั้งค่า onClickListener ให้กับ maid1 (ถ้าใช่)
        maid1.setOnClickListener {
            val intent = Intent(this, MaidMainActivity::class.java)
            startActivity(intent)
        }
    }
}