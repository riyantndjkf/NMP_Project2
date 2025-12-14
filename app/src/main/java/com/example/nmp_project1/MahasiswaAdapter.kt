package com.example.nmp_project1

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.nmp_project1.databinding.MahasiswaCardBinding
import com.squareup.picasso.Picasso

class MahasiswaAdapter(val mahasiswaList: ArrayList<Mahasiswa>) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    class MahasiswaViewHolder(val binding: MahasiswaCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val binding = MahasiswaCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MahasiswaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mahasiswaList.size
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mhs = mahasiswaList[position]

        holder.binding.txtNama.text = mhs.nama
        holder.binding.txtNRP.text = mhs.nrp

        // LOAD GAMBAR DARI URL (Gunakan Picasso)
        // Pastikan URL valid, jika kosong pakai placeholder
        if (mhs.photoUrl.isNotEmpty()) {
            Picasso.get().load(mhs.photoUrl).into(holder.binding.imgMahasiswa)
        }

        // Tombol Detail
        holder.binding.btnDetail.setOnClickListener {
            val intent = Intent(holder.itemView.context, MahasiswaDetailActivity::class.java)
            // Kirim NRP saja, nanti di DetailActivity ambil data lagi atau kirim via Parcelable
            intent.putExtra("MAHASISWA_NRP", mhs.nrp)
            holder.itemView.context.startActivity(intent)
        }

        // Tombol Add Friend
        holder.binding.btnAddFriend.setOnClickListener {
            val context = holder.itemView.context
            val url = "http://10.0.2.2/nmp_uas/add_friend.php"

            val request = object : StringRequest(Method.POST, url,
                Response.Listener { response ->
                    Toast.makeText(context, "Berhasil menambahkan teman!", Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    Toast.makeText(context, "Gagal: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            ) {
                override fun getParams(): MutableMap<String, String> {
                    val params = HashMap<String, String>()
                    params["nrp"] = mhs.nrp
                    return params
                }
            }
            Volley.newRequestQueue(context).add(request)
        }
    }
}