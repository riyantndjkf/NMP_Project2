package com.example.nmp_project1

import android.annotation.SuppressLint
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

class MyFriendsFragment : Fragment() {
    var friends = ArrayList<Mahasiswa>()
    lateinit var adapter: MyFriendAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recView = view.findViewById<RecyclerView>(R.id.recyclerViewFriends)
        recView.layoutManager = LinearLayoutManager(context)

        adapter = MyFriendAdapter(friends)
        recView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList() {
        val url = "http://10.0.2.2/nmp_uas/get_friends.php"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val data = obj.getJSONArray("data")
                        friends.clear()
                        for (i in 0 until data.length()) {
                            val mhsObj = data.getJSONObject(i)
                            val nama = mhsObj.getString("nama")
                            val nrp = mhsObj.getString("nrp")
                            val email = mhsObj.getString("email")
                            val program = mhsObj.optString("program", "-")
                            val foto = mhsObj.optString("foto_url", "")

                            val mhs = Mahasiswa(
                                nrp = nrp,
                                nama = nama,
                                email = email,
                                program = program,
                                photoUrl = foto,
                                about = null,
                                interests = null,
                                achievements = null
                            )
                            friends.add(mhs)
                        }
                        adapter.notifyDataSetChanged()
                        Log.d("MyFriends", "Data loaded: ${friends.size}")
                    }
                } catch (e: Exception) {
                    Log.e("ErrorFriends", "Parsing Error: ${e.message}")
                }
            },
            { error -> Log.e("ErrorVolley", error.toString()) }
        )
        Volley.newRequestQueue(context).add(stringRequest)
    }
}