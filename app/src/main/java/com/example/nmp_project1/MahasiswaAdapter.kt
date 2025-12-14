package com.example.nmp_project1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        if (mhs.photoUrl.isNotEmpty()) {
            var url = mhs.photoUrl
            if (!url.startsWith("http")) {
                url = "http://10.0.2.2/nmp_uas/images/$url"
            }

            Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(holder.binding.imgMahasiswa)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MahasiswaDetailActivity::class.java)
            intent.putExtra("MAHASISWA_NRP", mhs.nrp)
            holder.itemView.context.startActivity(intent)
        }
    }
}