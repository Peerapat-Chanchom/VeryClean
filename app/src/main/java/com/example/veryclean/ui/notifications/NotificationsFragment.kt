package com.example.veryclean.ui.notifications

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment

import com.example.veryclean.databinding.FragmentNotificationsBinding
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.*

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    private val REQUEST_IMAGE_PICK = 1001

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        try {
            // โหลดข้อมูลที่เคยบันทึกไว้
            loadProfile()

            // ตั้งค่า DatePickerDialog สำหรับเลือกวันเกิด
            binding.etDateOfBirth.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear)
                    binding.etDateOfBirth.setText(selectedDate)
                }, year, month, day)

                datePickerDialog.show()
            }



            // บันทึกข้อมูลเมื่อกดปุ่ม Save
            binding.btnSave.setOnClickListener {
                saveProfile()
            }

            // ตั้งค่าปุ่มเปลี่ยนรูป
            binding.btnChangeProfilePic.setOnClickListener {
                openGallery()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }

        return root
    }

    private fun saveProfile() {
        val sharedPreferences = requireActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("name", binding.editTextText.text.toString())
        editor.putString("email", binding.editTextText2.text.toString())
        editor.putString("phone", binding.editTextNumber.text.toString())
        editor.putString("dob", binding.etDateOfBirth.text.toString())
        editor.putString("where", binding.editTextNumber2.text.toString())

        editor.apply()

        Toast.makeText(requireContext(), "Profile Saved!", Toast.LENGTH_SHORT).show()
    }

    private fun loadProfile() {
        val sharedPreferences = requireActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE)

        binding.editTextText.setText(sharedPreferences.getString("name", ""))
        binding.editTextText2.setText(sharedPreferences.getString("email", ""))
        binding.editTextNumber.setText(sharedPreferences.getString("phone", ""))
        binding.etDateOfBirth.setText(sharedPreferences.getString("dob", ""))
        binding.editTextNumber2.setText(sharedPreferences.getString("where", "")) // ✅ โหลดที่อยู่



        // โหลดรูปโปรไฟล์
        val profileImagePath = sharedPreferences.getString("profile_image", null)
        if (profileImagePath != null) {
            val bitmap = BitmapFactory.decodeFile(profileImagePath)
            binding.ivProfile.setImageBitmap(bitmap)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = data?.data
            if (imageUri != null) {
                binding.ivProfile.setImageURI(imageUri)
                saveImageToInternalStorage(imageUri)
            }
        }
    }

    private fun saveImageToInternalStorage(imageUri: Uri) {
        try {
            val inputStream: InputStream? = requireContext().contentResolver.openInputStream(imageUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val file = File(requireContext().filesDir, "profile_image.png")
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()

            // บันทึก Path ของรูปลง SharedPreferences
            val sharedPreferences = requireActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("profile_image", file.absolutePath).apply()

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Error saving image", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // ป้องกัน Memory Leak
    }
}