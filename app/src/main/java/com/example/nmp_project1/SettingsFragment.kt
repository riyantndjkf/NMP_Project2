package com.example.nmp_project1

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switchDarkMode = view.findViewById<Switch>(R.id.switchDarkMode)
        val btnResetFriends = view.findViewById<Button>(R.id.btnResetFriends)

        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        switchDarkMode.isChecked = (currentNightMode == Configuration.UI_MODE_NIGHT_YES)

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        btnResetFriends.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Reset Friends")
            builder.setMessage("Apakah anda yakin ingin menghapus semua teman?")
            builder.setPositiveButton("Hapus") { dialog, _ ->
                performReset()
                dialog.dismiss()
            }
            builder.setNegativeButton("Batal") { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }
    }

    private fun performReset() {
        val url = "http://10.0.2.2/nmp_uas/reset_friends.php"

        val stringRequest = StringRequest(Request.Method.POST, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        Toast.makeText(context, "Berhasil! Semua data teman telah dihapus.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Gagal: ${obj.getString("message")}", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(context, "Error parsing response", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(context, "Koneksi Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )
        Volley.newRequestQueue(context).add(stringRequest)
    }
}