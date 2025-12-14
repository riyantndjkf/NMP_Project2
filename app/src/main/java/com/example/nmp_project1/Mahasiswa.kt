package com.example.nmp_project1

import com.google.gson.annotations.SerializedName

data class Mahasiswa(
    val nrp: String,
    val nama: String,
    val email: String,
    val program: String,
    @SerializedName("foto_url") val photoUrl: String,
    @SerializedName("about_me") val about: String?,
    @SerializedName("my_course") val interests: String?,
    @SerializedName("my_experience") val achievements: String?
)