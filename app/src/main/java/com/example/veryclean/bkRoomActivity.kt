package com.example.veryclean

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class bkRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roombook)

        // ปุ่มเลือกวันที่และเวลา
        val btnSelectDate: Button = findViewById(R.id.btn_select_date)
        val btnSelectTime: Button = findViewById(R.id.btn_select_time)
        val buttonRoom: Button = findViewById(R.id.buttonRoom)

        // TextView สำหรับแสดงวันที่และเวลา
        val txtSelectedDate: TextView = findViewById(R.id.txt_selected_date)
        val txtSelectedTime: TextView = findViewById(R.id.txt_selected_time)

        // 📅 เลือกวันที่
        btnSelectDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                txtSelectedDate.text = "วันที่ที่เลือก: $date"
            }, year, month, day)

            datePickerDialog.show()
        }

        // ⏰ เลือกเวลา
        btnSelectTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val time = String.format("%02d:%02d", selectedHour, selectedMinute)
                txtSelectedTime.text = "เวลาที่เลือก: $time"
            }, hour, minute, true)

            timePickerDialog.show()
        }
     buttonRoom.setOnClickListener{
         val intent = Intent(this, payActivity::class.java) // เปลี่ยนชื่อ Activity ตามต้องการ
         startActivity(intent)
     }
    }
}
