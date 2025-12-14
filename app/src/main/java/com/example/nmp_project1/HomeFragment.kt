package com.example.nmp_project1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class HomeFragment : Fragment() {
    // Global variable agar bisa diakses di function update
    var mhsList = ArrayList<Mahasiswa>() // Pastikan Class Mahasiswa sudah ada
    lateinit var v: View
    lateinit var adapter: MahasiswaAdapter // Pastikan Class MahasiswaAdapter sudah ada

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_home, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        val recView = v.findViewById<RecyclerView>(R.id.recyclerViewHome)
        recView.layoutManager = LinearLayoutManager(requireContext())

        // Siapkan Adapter kosong dulu
        adapter = MahasiswaAdapter(mhsList)
        recView.adapter = adapter

        // Panggil fungsi ambil data
        updateList()
    }

    fun updateList() {
        val queue = Volley.newRequestQueue(requireContext())
        // Ganti URL sesuai IP Komputer Anda (jangan pakai localhost jika di HP fisik)
        // Jika pakai Emulator Android Studio gunakan 10.0.2.2
        val url = "http://10.0.2.2/nmp_uas/get_all_students.php"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    val jsonArray = obj.getJSONArray("data") // Sesuaikan key JSON Anda (misal 'data')
                    mhsList.clear()

                    for (i in 0 until jsonArray.length()) {
                        val mhsObj = jsonArray.getJSONObject(i)
                        // Pastikan constructor Mahasiswa sesuai dengan model Anda
                        val mhs = Mahasiswa(
                            mhsObj.getString("nrp"),
                            mhsObj.getString("nama"),
                            mhsObj.getString("email"),
                            mhsObj.getString("program"),
                            mhsObj.getString("foto_url"),
                            // Tambahkan field lain sesuai class Mahasiswa.kt
                        )
                        mhsList.add(mhs)
                    }
                    adapter.notifyDataSetChanged() // Refresh tampilan
                } catch (e: Exception) {
                    Log.e("ErrorJSON", e.message.toString())
                }
            },
            { error ->
                Log.e("VolleyError", error.toString())
            }
        )
        queue.add(stringRequest)
    }
}