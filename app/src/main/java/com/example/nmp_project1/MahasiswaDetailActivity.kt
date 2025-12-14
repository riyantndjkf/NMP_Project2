package com.example.nmp_project1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.nmp_project1.databinding.ActivityMahasiswaDetailBinding
import com.squareup.picasso.Picasso
import org.json.JSONObject

class MahasiswaDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMahasiswaDetailBinding
    private var studentNrp: String = ""
    private var dbAbout: String = ""
    private var dbCourses: String = ""
    private var dbProgram: String = ""
    private var dbExperiences: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMahasiswaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nrp = intent.getStringExtra("MAHASISWA_NRP")
        if (nrp != null) {
            studentNrp = nrp
            loadDetail(nrp)
            checkIfFriend(nrp)
        }

        val spinnerItems = arrayOf("About Me", "My Courses", "My Experiences")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMenu.adapter = adapter

        binding.spinnerMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateContent(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // 4. Button Add Friend
        binding.btnReqFriend.setOnClickListener {
            addFriend(studentNrp)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateContent(position: Int) {
        when (position) {
            0 -> {
                binding.labelProgram.visibility = View.VISIBLE
                binding.radioProgram.visibility = View.VISIBLE
                binding.txtDescription.text = dbAbout.ifEmpty { "-" }
                binding.radioProgram.clearCheck()
                when (dbProgram.uppercase()) {
                    "DSAI" -> binding.radioDSAI.isChecked = true
                    "NCS" -> binding.radioNCS.isChecked = true
                    "IMES" -> binding.radioIMES.isChecked = true
                    "DMT" -> binding.radioDMT.isChecked = true
                    "GD" -> binding.radioGD.isChecked = true
                }
            }
            1 -> {
                binding.labelProgram.visibility = View.GONE
                binding.radioProgram.visibility = View.GONE

                if (dbCourses.isNotEmpty()) {
                    val list = dbCourses.split(",").map { it.trim() }
                    binding.txtDescription.text = list.joinToString(separator = "\n") { "• $it" }
                } else {
                    binding.txtDescription.text = "No courses"
                }
            }
            2 -> {
                binding.labelProgram.visibility = View.GONE
                binding.radioProgram.visibility = View.GONE

                if (dbExperiences.isNotEmpty()) {
                    val list = dbExperiences.split(",").map { it.trim() }
                    binding.txtDescription.text = list.joinToString(separator = "\n") { "• $it" }
                } else {
                    binding.txtDescription.text = "No experiences"
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadDetail(nrp: String) {
        val url = "http://10.0.2.2/nmp_uas/get_student_id.php?nrp=$nrp"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val data = obj.getJSONArray("data")
                        if (data.length() > 0) {
                            val mhsObj = data.getJSONObject(0)

                            binding.txtNamaLengkap.text = mhsObj.getString("nama")
                            binding.txtNRPDetail.text = "NRP ${mhsObj.getString("nrp")}"

                            dbProgram = mhsObj.optString("program", "")
                            dbAbout = mhsObj.optString("about_me", "")       // SEBELUMNYA: "about"
                            dbCourses = mhsObj.optString("my_course", "")    // SEBELUMNYA: "courses"
                            dbExperiences = mhsObj.optString("my_experience", "") // SEBELUMNYA: "experiences"

                            val photoUrl = mhsObj.optString("foto_url", "")  // SEBELUMNYA: "foto"

                            if (photoUrl.isNotEmpty()) {
                                var fullUrl = photoUrl
                                if (!fullUrl.startsWith("http")) {
                                    fullUrl = "http://10.0.2.2/nmp_uas/images/$fullUrl"
                                }
                                Picasso.get().load(fullUrl).into(binding.imgMahasiswaDetail)
                            }

                            updateContent(binding.spinnerMenu.selectedItemPosition)
                        }
                    }
                } catch (e: Exception) {
                    Log.e("DetailError", e.toString())
                }
            },
            { error -> Log.e("VolleyError", error.toString()) }
        )
        Volley.newRequestQueue(this).add(stringRequest)
    }

    @SuppressLint("SetTextI18n")
    private fun checkIfFriend(nrp: String) {
        val url = "http://10.0.2.2/nmp_uas/get_friends.php"
        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val data = obj.getJSONArray("data")
                        for (i in 0 until data.length()) {
                            val friend = data.getJSONObject(i)
                            if (friend.getString("nrp") == nrp) {
                                binding.btnReqFriend.isEnabled = false
                                binding.btnReqFriend.text = "Sudah Berteman"
                                break
                            }
                        }
                    }
                } catch (e: Exception) { e.printStackTrace() }
            }, {}
        )
        Volley.newRequestQueue(this).add(stringRequest)
    }

    private fun addFriend(nrp: String) {
        val url = "http://10.0.2.2/nmp_uas/insert_friend.php"
        val stringRequest = @SuppressLint("SetTextI18n")
        object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                try {
                    val obj = JSONObject(response)
                    if (obj.getString("result") == "OK") {
                        val nama = binding.txtNamaLengkap.text.toString()
                        val totalFriends = obj.getInt("total_friends")
                        val pesan = "Sukses tambah $nama sebagai friend.\nFriends anda sekarang adalah $totalFriends."

                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("Friend Requests")
                        builder.setMessage(pesan)
                        builder.setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                        }
                        builder.create().show()
                        binding.btnReqFriend.isEnabled = false
                        binding.btnReqFriend.text = "Already Friends"

                    } else {
                        Toast.makeText(this, "Gagal: ${obj.getString("message")}", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error parsing response", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["nrp"] = nrp
                return params
            }
        }
        Volley.newRequestQueue(this).add(stringRequest)
    }
}