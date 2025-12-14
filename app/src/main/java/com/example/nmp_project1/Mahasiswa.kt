package com.example.nmp_project1

import com.google.gson.annotations.SerializedName

data class Mahasiswa(
    val nrp: String,
    val nama: String,
    val email: String,
    val program: String,
    @SerializedName("foto") val photoUrl: String, // Mengambil field 'foto' dari JSON
    val about: String?,
    val interests: String?,
    val achievements: String?
)