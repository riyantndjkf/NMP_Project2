package com.example.nmp_project1

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nmp_project1.databinding.MyfriendCardBinding
import com.squareup.picasso.Picasso

class MyFriendAdapter(val friendList: ArrayList<Mahasiswa>) : RecyclerView.Adapter<MyFriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(val binding: MyfriendCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = MyfriendCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val mhs = friendList[position]
        holder.binding.txtFriendNama.text = mhs.nama
        holder.binding.txtFriendNRP.text = mhs.nrp
        holder.binding.txtFriendProgram.text = mhs.program
        if (mhs.photoUrl.isNotEmpty()) {
            var url = mhs.photoUrl
            if (!url.startsWith("http")) {
                url = "http://10.0.2.2/nmp_uas/images/$url"
            }
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(holder.binding.imgFriend)
        }
        holder.binding.btnEmail.setOnClickListener {
            val emailTujuan = mhs.email
            if (emailTujuan.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(emailTujuan))
                    putExtra(Intent.EXTRA_SUBJECT, "Halo dari Aplikasi NMP")
                    putExtra(Intent.EXTRA_TEXT, "Halo ${mhs.nama}, ...")
                }

                try {
                    holder.itemView.context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(holder.itemView.context, "Tidak ada aplikasi email terinstall", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(holder.itemView.context, "Email mahasiswa ini tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }
    }
}