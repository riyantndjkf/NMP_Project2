package com.example.nmp_project1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MyFriendsFragment : Fragment() {
    var friendsList = ArrayList<Mahasiswa>()
    lateinit var v: View
    lateinit var adapter: MahasiswaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_my_friends, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recView = v.findViewById<RecyclerView>(R.id.recyclerViewFriends)
        recView.layoutManager = LinearLayoutManager(requireContext())

        adapter = MahasiswaAdapter(friendsList)
        recView.adapter = adapter

        updateFriends()
    }

    fun updateFriends() {
        // Logika sama dengan Home, tapi arahkan ke get_my_friends.php
        val q = Volley.newRequestQueue(requireContext())
        val url = "http://10.0.2.2/nmp_uas/get_my_friends.php"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    val arr = obj.getJSONArray("data")
                    friendsList.clear()
                    for(i in 0 until arr.length()){
                        val data = arr.getJSONObject(i)
                        // Sesuaikan parsing dengan JSON response
                        val mhs = Mahasiswa(
                            data.getString("nrp"),
                            data.getString("nama"),
                            data.getString("email"),
                            data.getString("program"),
                            data.getString("foto_url"),
                            data.getString("about"),
                            data.getString("interests"),
                            data.getString("achievements"),
                        )
                        friendsList.add(mhs)
                    }
                    adapter.notifyDataSetChanged()
                } catch (e: Exception) {
                    Log.e("FriendsError", e.message.toString())
                }
            },
            { error -> Log.e("VolleyError", error.toString()) }
        )
        q.add(stringRequest)
    }
}