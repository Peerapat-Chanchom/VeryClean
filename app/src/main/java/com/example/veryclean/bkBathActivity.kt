package com.example.veryclean

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class bkBathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathbook)

        // ปุ่มเลือกวันที่และเวลา
        val btnSelectDate1: Button = findViewById(R.id.btn_select_date1)
        val btnSelectTime1: Button = findViewById(R.id.btn_select_time1)
        val buttonBath: Button = findViewById(R.id.buttonBath)

        // TextView สำหรับแสดงวันที่และเวลา
        val txtSelectedDate1: TextView = findViewById(R.id.txt_selected_date1)
        val txtSelectedTime1: TextView = findViewById(R.id.txt_selected_time1)

        // 📅 เลือกวันที่
        btnSelectDate1.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                txtSelectedDate1.text = "วันที่ที่เลือก: $date"
            }, year, month, day)

            datePickerDialog.show()
        }

        // ⏰ เลือกเวลา
        btnSelectTime1.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val time = String.format("%02d:%02d", selectedHour, selectedMinute)
                txtSelectedTime1.text = "เวลาที่เลือก: $time"
            }, hour, minute, true)

            timePickerDialog.show()
        }
        buttonBath.setOnClickListener{
            val intent = Intent(this, SelectMaidActivity::class.java) // เปลี่ยนชื่อ Activity ตามต้องการ
            startActivity(intent)
        }
    }
}
