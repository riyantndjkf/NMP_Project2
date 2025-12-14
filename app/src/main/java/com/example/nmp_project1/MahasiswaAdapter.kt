package com.example.nmp_project1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nmp_project1.databinding.ActivityMahasiswaListBinding
import com.example.nmp_project1.databinding.MahasiswaCardBinding
import com.squareup.picasso.Picasso

class MahasiswaAdapter(): RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MahasiswaViewHolder {
        val binding = MahasiswaCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MahasiswaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MahasiswaViewHolder,
        position: Int
    ) {
        holder.binding.txtNama.text = MahasiswaData.mahasiswas[position].nama
        holder.binding.txtNRP.text = "NRP " + MahasiswaData.mahasiswas[position].nrp
        holder.binding.txtProgram.text = "Program " + MahasiswaData.mahasiswas[position].program
        // Tampilkan gambar
        if (MahasiswaData.mahasiswas[position].url.isNotEmpty()) {
            // Kalau URL ada → pakai Picasso
            Picasso.get().load(MahasiswaData.mahasiswas[position].url).into(holder.binding.imgMahasiswa)
        } else {
            // Kalau tidak → pakai gambar drawable bawaan
            holder.binding.imgMahasiswa.setImageResource(MahasiswaData.mahasiswas[position].imagedId)
        }

        // handle page detail mahasiswa
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, MahasiswaDetailActivity::class.java)
            // Kirim data mahasiswa
            intent.putExtra("mahasiswa", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = MahasiswaData.mahasiswas.size

    class  MahasiswaViewHolder(val binding: MahasiswaCardBinding): RecyclerView.ViewHolder(binding.root)
}