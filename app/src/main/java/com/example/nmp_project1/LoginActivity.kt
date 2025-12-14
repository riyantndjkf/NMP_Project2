package com.example.nmp_project1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences("AppSession", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("USERNAME", "")
        if (username != "") {
            // Jika sudah login, langsung ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val txtInputName = findViewById<TextInputEditText>(R.id.txtInputName)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val nama = txtInputName.text.toString().trim()
            if (nama.isNotEmpty()) {
                cekLogin(nama)
            } else {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun cekLogin(nama: String) {
        val q = Volley.newRequestQueue(this)
        val url = "http://10.0.2.2/nmp_uas/get_all_students.php?q=$nama"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val data = obj.getJSONArray("data")
                        val sType = object : TypeToken<ArrayList<Mahasiswa>>() {}.type
                        val mhsList: ArrayList<Mahasiswa> = Gson().fromJson(data.toString(), sType)

                        // Cek apakah ada nama yang PERSIS sama (case insensitive)
                        // Karena pencarian di PHP menggunakan LIKE, "Budi" bisa match dengan "Budi Santoso"
                        // Kita validasi lagi di sini agar login lebih tepat.
                        var isFound = false
                        var loggedInName = ""

                        for (mhs in mhsList) {
                            if (mhs.nama.equals(nama, ignoreCase = true)) {
                                isFound = true
                                loggedInName = mhs.nama
                                break
                            }
                        }

                        if (isFound) {
                            // SIMPAN SESI LOGIN
                            val editor = sharedPreferences.edit()
                            editor.putString("USERNAME", loggedInName)
                            editor.apply()

                            // PINDAH KE MAIN ACTIVITY
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Nama tidak ditemukan / Salah", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "Error parsing data", Toast.LENGTH_SHORT).show()
                }
            },
            {
                Toast.makeText(this, "Gagal koneksi ke server", Toast.LENGTH_SHORT).show()
            }
        )
        q.add(stringRequest)
    }
}