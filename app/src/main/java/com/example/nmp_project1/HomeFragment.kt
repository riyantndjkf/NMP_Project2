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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.content.Context
import android.content.SharedPreferences

class HomeFragment : Fragment() {

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
        // 1. AMBIL NAMA USER YANG SEDANG LOGIN
        val sharedPreferences = requireActivity().getSharedPreferences("AppSession", Context.MODE_PRIVATE)
        val currentUserName = sharedPreferences.getString("USERNAME", "")

        val queue = Volley.newRequestQueue(requireContext())

        // 2. KIRIM NAMA TERSEBUT SEBAGAI PARAMETER 'current_user'
        // Jika currentUserName mengandung spasi, sebaiknya di-encode (tapi untuk simpel begini string biasa seringkali cukup di volley)
        val url = "http://10.0.2.2/nmp_uas/get_all_students.php?current_user=$currentUserName"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val data = obj.getJSONArray("data")

                        val sType = object : TypeToken<ArrayList<Mahasiswa>>() { }.type
                        mhsList = Gson().fromJson(data.toString(), sType)

                        adapter = MahasiswaAdapter(mhsList)
                        val recView = v.findViewById<RecyclerView>(R.id.recyclerViewHome)
                        recView.adapter = adapter
                        adapter.notifyDataSetChanged()

                        Log.d("CekData", "Data masuk: ${mhsList.size}")
                    }
                } catch (e: Exception) {
                    Log.e("ErrorJSON", "Gagal parsing: ${e.message}")
                }
            },
            { error ->
                Log.e("VolleyError", "Gagal koneksi: ${error.message}")
            }
        )
        queue.add(stringRequest)
    }
}