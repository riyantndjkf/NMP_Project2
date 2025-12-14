package com.example.nmp_project1

import com.google.gson.annotations.SerializedName

data class Mahasiswa(
    val nrp: String,
    val nama: String,
    val email: String,
    val program: String,
    @SerializedName("foto_url")
    val fotoUrl: String,
    @SerializedName("about_me")
    val aboutMe: String,
    @SerializedName("my_course")
    val myCourse: String,
    @SerializedName("my_experience")
    val myExperience: String
) {
    fun getCourseList(): List<String> {
        return myCourse.split(",").map { it.trim() }
    }

    fun getExperienceList(): List<String> {
        return myExperience.split(",").map { it.trim() }
    }
}