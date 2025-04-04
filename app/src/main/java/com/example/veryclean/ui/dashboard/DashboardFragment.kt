package com.example.veryclean.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.veryclean.cancelActivity
import com.example.veryclean.reviewActivity
import com.example.veryclean.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // ใช้ binding เพื่อเข้าถึง TextView
        binding.textVe.setOnClickListener {
            val intent = Intent(requireContext(), reviewActivity::class.java)
            startActivity(intent)
        }
        binding.textView38.setOnClickListener {
            val intent = Intent(requireContext(), cancelActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
