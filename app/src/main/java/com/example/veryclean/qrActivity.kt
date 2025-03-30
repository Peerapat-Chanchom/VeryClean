package com.example.veryclean

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class qrActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_qr)

        imageView = findViewById(R.id.imageViewSlip)
        val buttonNext3: Button = findViewById(R.id.slip)
        val buttonNEXT: Button = findViewById(R.id.buttonNEXT2)
        buttonNext3.setOnClickListener {
            openGallery()
        }
        buttonNEXT.setOnClickListener {
            val intent = Intent(this, finishActivity::class.java) // เปลี่ยนชื่อ Activity ตามต้องการ
            startActivity(intent)
            finish()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            imageView.setImageURI(imageUri)
        }
    }
}