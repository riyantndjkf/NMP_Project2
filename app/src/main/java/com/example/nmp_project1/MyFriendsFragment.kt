package com.example.nmp_project1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.nmp_project1.databinding.FragmentMyFriendsBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class MyFriendsFragment : Fragment() {
    private lateinit var binding: FragmentMyFriendsBinding
    private val friends = ArrayList<Mahasiswa>()
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyFriendsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MahasiswaAdapter(friends)
        binding.recViewFriends.layoutManager = LinearLayoutManager(context)
        binding.recViewFriends.adapter = adapter

        loadFriends()
    }

    // Agar saat pindah tab data ter-refresh otomatis
    override fun onResume() {
        super.onResume()
        loadFriends()
    }

    private fun loadFriends() {
        val url = "http://10.0.2.2/nmp_uas/get_my_friends.php"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                val obj = JSONObject(response)
                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val sType = object : TypeToken<List<Mahasiswa>>() {}.type
                    val newFriends = Gson().fromJson<ArrayList<Mahasiswa>>(data.toString(), sType)

                    friends.clear()
                    friends.addAll(newFriends)
                    adapter.notifyDataSetChanged()
                }
            },
            { error -> Log.e("MyFriends", error.toString()) }
        )
        Volley.newRequestQueue(context).add(stringRequest)
    }
}