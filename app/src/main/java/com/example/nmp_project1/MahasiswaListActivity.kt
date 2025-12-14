package com.example.nmp_project1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nmp_project1.databinding.ActivityMahasiswaListBinding

class MahasiswaListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMahasiswaListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMahasiswaListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lm = LinearLayoutManager(this)
        lm.orientation = LinearLayoutManager.VERTICAL

        val gm = GridLayoutManager(this, 2)

        binding.recMahasiswa.layoutManager = lm
        binding.recMahasiswa.setHasFixedSize(true)
        binding.recMahasiswa.adapter = MahasiswaAdapter()
    }
}