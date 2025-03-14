package com.example.veryclean.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.veryclean.R
import com.example.veryclean.bkBathActivity
import com.example.veryclean.bkRoomActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val clean1: ImageView = root.findViewById(R.id.clean1)
        val clean2: ImageView = root.findViewById(R.id.clean2)

        clean1.setOnClickListener {
            val intent = Intent(requireContext(), bkRoomActivity::class.java)
            startActivity(intent)
        }
        clean2.setOnClickListener {
            val intent = Intent(requireContext(), bkBathActivity::class.java)
            startActivity(intent)
        }

        return root
    }
}
