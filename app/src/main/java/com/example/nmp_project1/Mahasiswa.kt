package com.example.nmp_project1

data class Mahasiswa(var nrp: String,
                     var nama: String,
                     var program: String,
                     var aboutMe: String,
                     var courses: List<String>,
                     var experiences: List<String>,
                     var imagedId: Int,
                     var url: String = "",
                     var isFriend: Boolean = false
)