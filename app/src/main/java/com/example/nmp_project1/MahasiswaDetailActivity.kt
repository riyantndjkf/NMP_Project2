package com.example.nmp_project1

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nmp_project1.databinding.ActivityMahasiswaDetailBinding
import com.example.nmp_project1.databinding.ActivityMahasiswaListBinding
import com.squareup.picasso.Picasso
import kotlin.collections.indexOf

class MahasiswaDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMahasiswaDetailBinding

    companion object{
        var jumFriends = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMahasiswaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(com.example.nmp_project1.R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Dpt posisi mahasiswa
        val pos = intent.getIntExtra("mahasiswa", -1)

        // Handle gambar (pakai URL atau drawable)
        if (!MahasiswaData.mahasiswas[pos].url.isNullOrEmpty()) {
            Picasso.get().load(MahasiswaData.mahasiswas[pos].url).into(binding.imgMahasiswaDetail)
        } else {
            binding.imgMahasiswaDetail.setImageResource(MahasiswaData.mahasiswas[pos].imagedId)
        }
        binding.txtNamaLengkap.setText(MahasiswaData.mahasiswas[pos].nama)
        binding.txtNRPDetail.setText("NRP " + MahasiswaData.mahasiswas[pos].nrp)

        // Handle Spinner
        val spinnerItems = arrayOf("About Me", "My Courses", "My Experiences")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMenu.adapter = adapter

        binding.spinnerMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        binding.labelProgram.visibility = View.VISIBLE
                        binding.radioProgram.visibility = View.VISIBLE

                        binding.txtDescription.text = MahasiswaData.mahasiswas[pos].aboutMe
                        // checked radio button sesuai program mahasiswa
                        when (MahasiswaData.mahasiswas[pos].program?.uppercase()) {
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
                        // tampilkan daftar course dalam bentuk list teks
                        val text =
                            MahasiswaData.mahasiswas[pos].courses?.joinToString(separator = "\n") { "• $it" }
                                ?: "No courses"
                        binding.txtDescription.text = text
                    }

                    2 -> {
                        binding.labelProgram.visibility = View.GONE
                        binding.radioProgram.visibility = View.GONE
                        // tampilkan daftar pengalaman
                        val text =
                            MahasiswaData.mahasiswas[pos].experiences?.joinToString(separator = "\n") { "• $it" }
                                ?: "No experiences"
                        binding.txtDescription.text = text
                    }
                }
            }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

            if(MahasiswaData.mahasiswas[pos].isFriend){
                binding.btnReqFriend.isEnabled = false
                binding.btnReqFriend.text = "Already Friends"
            } else{
                binding.btnReqFriend.isEnabled = true
                binding.btnReqFriend.text = "Request Friend"

                // btn Request Friends
                binding.btnReqFriend.setOnClickListener {
                    jumFriends++
                    MahasiswaData.mahasiswas[pos].isFriend = true

                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Friend Requests")
                    builder.setMessage("Sukses tambah ${MahasiswaData.mahasiswas[pos].nama} sebagai friend.\n" +
                            "Friends anda sekarang adalah ${jumFriends}.")

                    builder.setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }

                    val dialog = builder.create()
                    dialog.show()

                    binding.btnReqFriend.isEnabled = false
                    binding.btnReqFriend.text = "Already Friends"
            }
        }
    }
}