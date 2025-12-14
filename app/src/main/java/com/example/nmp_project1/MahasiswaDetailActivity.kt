package com.example.nmp_project1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nmp_project1.databinding.ActivityMahasiswaDetailBinding
import com.squareup.picasso.Picasso
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MahasiswaDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMahasiswaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMahasiswaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nrp = intent.getStringExtra("MAHASISWA_NRP")

        // Panggil API untuk ambil detail spesifik mahasiswa berdasarkan NRP
        // (Atau kamu bisa kirim semua data via Intent Parcelable dari Adapter)
        if (nrp != null) {
            loadDetail(nrp)
        }
    }

    private fun loadDetail(nrp: String) {
        // Tips: Kamu bisa reuse 'get_all_students.php?q=NRP' karena di PHP sudah pakai LIKE
        val url = "http://10.0.2.2/nmp_uas/get_all_students.php?q=$nrp"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                val obj = JSONObject(response)
                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    if (data.length() > 0) {
                        val mhsObj = data.getJSONObject(0)

                        binding.txtNamaDetail.text = mhsObj.getString("nama")
                        binding.txtNrpDetail.text = mhsObj.getString("nrp")
                        binding.txtEmailDetail.text = mhsObj.getString("email")
                        binding.txtAboutDetail.text = mhsObj.getString("about")

                        val photoUrl = mhsObj.getString("foto")
                        if (photoUrl.isNotEmpty()) {
                            Picasso.get().load(photoUrl).into(binding.imgDetailProfile)
                        }
                    }
                }
            },
            { error -> }
        )
        Volley.newRequestQueue(this).add(stringRequest)
    }
}