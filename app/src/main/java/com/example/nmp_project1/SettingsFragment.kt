package com.example.nmp_project1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtProfileName = view.findViewById<TextView>(R.id.txtProfileName)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        // AMBIL DATA USER DARI SHARED PREFERENCES
        val sharedPreferences = requireActivity().getSharedPreferences("AppSession", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("USERNAME", "Unknown")
        txtProfileName.text = "Nama: $username"

        // FUNGSI LOGOUT
        btnLogout.setOnClickListener {
            // 1. Hapus data sesi
            val editor = sharedPreferences.edit()
            editor.clear() // Menghapus semua data di preference ini
            editor.apply()

            // 2. Kembali ke LoginActivity
            val intent = Intent(requireContext(), LoginActivity::class.java)
            // Membersihkan back stack agar user tidak bisa back ke halaman settings setelah logout
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }
    }
}