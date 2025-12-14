package com.example.nmp_project1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.nmp_project1.databinding.FragmentHomeBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val students = ArrayList<Mahasiswa>()
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        adapter = MahasiswaAdapter(students)
        binding.recViewHome.layoutManager = LinearLayoutManager(context)
        binding.recViewHome.adapter = adapter

        // Load Data Pertama Kali
        updateList("")

        // Handle Tombol Search (Pastikan ada button atau listener di EditText)
        // Contoh jika menggunakan TextWatcher atau tombol search
        /* binding.btnSearch.setOnClickListener {
             val q = binding.txtSearch.text.toString()
             updateList(q)
        }
        */
    }

    private fun updateList(keyword: String) {
        // Ganti URL sesuai IP Localhost emulator (10.0.2.2)
        val url = "http://10.0.2.2/nmp_uas/get_all_students.php?q=$keyword"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val data = obj.getJSONArray("data")

                        // Parse JSON Array ke List<Mahasiswa> menggunakan Gson
                        val sType = object : TypeToken<List<Mahasiswa>>() {}.type
                        val newStudents = Gson().fromJson<ArrayList<Mahasiswa>>(data.toString(), sType)

                        students.clear()
                        students.addAll(newStudents)
                        adapter.notifyDataSetChanged()
                    }
                } catch (e: Exception) {
                    Log.e("HomeFragment", "Error parsing JSON", e)
                }
            },
            { error ->
                Log.e("HomeFragment", "Volley Error: ${error.message}")
            }
        )
        Volley.newRequestQueue(context).add(stringRequest)
    }
}