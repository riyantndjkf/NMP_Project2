package com.example.nmp_project1

object MahasiswaData {
    var mahasiswas = arrayOf(
        // ===== DATA SCIENCE & AI =====
        Mahasiswa(
            nrp = "160422001",
            nama = "Valerie Hartono",
            program = "DSAI",
            aboutMe = "Saya mahasiswa Data Science yang tertarik pada pemrosesan data besar, kecerdasan buatan, dan pembelajaran mesin. Saya senang menulis skrip analisis dengan Python, mengeksplorasi visualisasi data interaktif, serta membangun model prediksi yang bermanfaat untuk industri modern.",
            courses = listOf("Full-Stack Programming", "Native Mobile Programming", "Numerical Methods", "Hybrid Mobile Programming", "Machine Learning", "Intelligent Information Retrieval"),
            experiences = listOf("Asisten Peneliti AI di Laboratorium Kampus", "Finalis Lomba Data Science Nasional 2024", "Panitia Seminar AI Revolution"),
            imagedId = 0,
            url = "https://images.pexels.com/photos/5409662/pexels-photo-5409662.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422002",
            nama = "Michelle Wibowo",
            program = "DSAI",
            aboutMe = "Saya fokus pada analisis data berbasis statistik dan eksplorasi pola tersembunyi dari data besar. Saya percaya data dapat mengungkap insight penting untuk pengambilan keputusan bisnis yang lebih cerdas.",
            courses = listOf("Machine Learning", "Numerical Methods", "Data Visualization", "Database Management"),
            experiences = listOf("Anggota Komunitas Python dan R", "Peserta Workshop Deep Learning 2024", "Intern di PT DataVision sebagai Junior Data Analyst"),
            imagedId = R.drawable.michelle,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422003",
            nama = "Kevin Kusuma",
            program = "DSAI",
            aboutMe = "Saya antusias terhadap pengembangan model kecerdasan buatan yang efisien. Fokus saya pada machine learning, pengolahan bahasa alami, dan automasi berbasis data.",
            courses = listOf("Machine Learning", "Intelligent Information Retrieval", "Full-Stack Programming", "Hybrid Mobile Programming"),
            experiences = listOf("Ketua Tim Penelitian NLP 2024", "Developer Chatbot Kampus", "Peserta AI Bootcamp by Google"),
            imagedId = 0,
            url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4KoWXMFWTmf5fPfBDy9nlLktyPSqVaWbaVjwXxgbkJtBNlZh4LPSCGklv1vQpWAZNHQ8&usqp=CAU",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422004",
            nama = "Jonathan Liem",
            program = "DSAI",
            aboutMe = "Sebagai mahasiswa yang mencintai teknologi, saya ingin berkontribusi dalam menciptakan sistem AI yang etis dan transparan. Saya juga aktif dalam berbagai pelatihan AI untuk pemula.",
            courses = listOf("Machine Learning", "Numerical Methods", "Database Management", "Full-Stack Programming"),
            experiences = listOf("Mentor Data Science Club", "Panitia AI Fair 2025", "Peserta Hackathon Data Analytic"),
            imagedId = R.drawable.jonathan,
            url = "",
            isFriend = false
        ),

        // ===== GAME DEVELOPMENT =====
        Mahasiswa(
            nrp = "160422005",
            nama = "Chloe Wiryawan",
            program = "GD",
            aboutMe = "Saya suka menciptakan pengalaman bermain yang imersif melalui desain level dan gameplay yang seru. Saya percaya game dapat menjadi media edukasi sekaligus hiburan.",
            courses = listOf("Game Concept & Design", "3D Animation", "Digital Video", "Software Engineering"),
            experiences = listOf("Developer Game Indie 2025", "Anggota Unity Developer Club", "Peserta Game Jam Kampus"),
            imagedId = 0,
            url = "https://images.pexels.com/photos/2704261/pexels-photo-2704261.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422006",
            nama = "Felicia Salim",
            program = "GD",
            aboutMe = "Saya memiliki ketertarikan pada pengembangan game mobile dengan Unity. Saya sering mengerjakan proyek kecil yang menggabungkan fisika dan gameplay realistis.",
            courses = listOf("Full-Stack Programming", "Digital Video", "3D Animation", "Game Concept & Design"),
            experiences = listOf("Ketua Proyek Game Adventure Kampus", "Peserta Game Developer Conference 2024"),
            imagedId = R.drawable.felicia,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422007",
            nama = "Adrian Nugraha",
            program = "GD",
            aboutMe = "Saya berfokus pada visual dan animasi dalam game. Saya senang menggabungkan seni digital dengan pemrograman interaktif untuk menghasilkan pengalaman bermain yang estetis.",
            courses = listOf("Physically Based Animation", "Digital Video", "3D Animation", "Game Concept & Design"),
            experiences = listOf("Desainer Animasi 3D di Proyek Kampus", "Freelancer Animator", "Panitia Game Expo 2025"),
            imagedId = R.drawable.adrian,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422008",
            nama = "Matthew Sudarsono",
            program = "GD",
            aboutMe = "Saya suka menggabungkan musik dan storytelling dalam game. Fokus saya pada narasi interaktif dan efek visual yang memukau.",
            courses = listOf("Digital Video", "3D Animation", "Game Concept & Design", "Software Engineering"),
            experiences = listOf("Composer untuk Game Indie", "Panitia Multimedia Festival", "Sound Designer di Tim GameDev Kampus"),
            imagedId = 0,
            url = "https://i.pinimg.com/170x/8c/b5/e4/8cb5e483939ccd619d40205c804b8fa8.jpg",
            isFriend = false
        ),

        // ===== INFORMATION MANAGEMENT & ENTERPRISE SYSTEM =====
        Mahasiswa(
            nrp = "160422009",
            nama = "Gabriella Santoso",
            program = "IMES",
            aboutMe = "Saya mahasiswa Sistem Informasi yang fokus pada manajemen data dan proses bisnis perusahaan. Saya senang merancang sistem yang mendukung efisiensi kerja organisasi.",
            courses = listOf("Database", "Software Engineering", "Business Process Management", "Enterprise System Design"),
            experiences = listOf("Asisten Dosen Database", "Koordinator ERP Project Simulation", "Intern di Divisi IT Planning"),
            imagedId = 0,
            url = "https://images.pexels.com/photos/7707299/pexels-photo-7707299.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422010",
            nama = "Jasmine Widjaja",
            program = "IMES",
            aboutMe = "Saya suka menghubungkan antara kebutuhan bisnis dan solusi teknologi. Minat saya adalah sistem informasi akuntansi dan manajemen proyek TI.",
            courses = listOf("Database", "Information System Planning", "Software Engineering", "Business Intelligence"),
            experiences = listOf("Tutor Akademik", "Panitia Business Technology Forum", "Internship di PT IndoSys"),
            imagedId = R.drawable.jasmine,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422011",
            nama = "Brandon Halim",
            program = "IMES",
            aboutMe = "Saya fokus pada integrasi sistem informasi antar divisi. Saya percaya kolaborasi data adalah kunci dalam digitalisasi perusahaan.",
            courses = listOf("Database", "Enterprise Resource Planning", "Software Engineering", "Full-Stack Programming"),
            experiences = listOf("Asisten Penelitian Sistem ERP", "Peserta Business System Hackathon", "Anggota IT Consulting Group"),
            imagedId = R.drawable.brandon,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422012",
            nama = "Vincent Gozali",
            program = "IMES",
            aboutMe = "Saya menyukai bidang sistem enterprise yang mendukung manajemen organisasi besar. Saya ingin menjadi analis sistem profesional.",
            courses = listOf("Database", "Project Management", "Enterprise System", "Information Architecture"),
            experiences = listOf("Project Manager ERP Kampus", "Peserta Workshop SAP", "Panitia Seminar Digital Transformation"),
            imagedId = 0,
            url = "https://i.pinimg.com/736x/d8/29/15/d82915b9241fcbff1609ca37a9e2f34b.jpg",
            isFriend = false
        ),

        // ===== NETWORK & CYBER SECURITY =====
        Mahasiswa(
            nrp = "160422013",
            nama = "Audrey Tanuwijaya",
            program = "NCS",
            aboutMe = "Saya tertarik pada keamanan jaringan dan sistem. Saya menikmati menganalisis potensi serangan serta membangun pertahanan siber yang tangguh.",
            courses = listOf("Computer Network", "Cybersecurity", "Internet of Things", "Network Management"),
            experiences = listOf("Anggota Tim Keamanan Jaringan Kampus", "Peserta CTF Competition 2024", "Intern di PT SecureTech"),
            imagedId = 0,
            url = "https://images.pexels.com/photos/4995951/pexels-photo-4995951.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422014",
            nama = "Olivia Gunawan",
            program = "NCS",
            aboutMe = "Saya fokus pada keamanan data dan proteksi sistem. Saya tertarik mengembangkan solusi keamanan berbasis IoT dan cloud.",
            courses = listOf("Internet of Things", "Computer Network", "Cybersecurity", "Database"),
            experiences = listOf("Peneliti Junior di Lab Network Security", "Peserta CyberCamp Indonesia", "Tim IT Support Kampus"),
            imagedId = R.drawable.olivia,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422015",
            nama = "Christopher Susanto",
            program = "NCS",
            aboutMe = "Saya memiliki ketertarikan pada arsitektur jaringan skala besar. Saya sering bereksperimen dengan simulasi jaringan dan firewall konfigurasi.",
            courses = listOf("Computer Network", "Network Management", "Internet of Things", "Cybersecurity"),
            experiences = listOf("Network Engineer Intern di PT NetCore", "Peserta Workshop Ethical Hacking"),
            imagedId = R.drawable.christopher,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422016",
            nama = "Ethan Setiawan",
            program = "NCS",
            aboutMe = "Saya suka meneliti cara kerja serangan siber dan mengembangkan metode pertahanan baru. Saya berkomitmen untuk menjadi ahli keamanan jaringan yang andal.",
            courses = listOf("Cybersecurity", "Computer Network", "IoT Security", "Database"),
            experiences = listOf("Panitia Network Security Seminar", "Anggota Komunitas IT Defense", "Asisten Praktikum Jaringan"),
            imagedId = 0,
            url = "https://i.pinimg.com/originals/ea/20/15/ea2015441e5b4934c15d12b7250e0db2.jpg",
            isFriend = false
        ),

        // ===== DIGITAL MEDIA TECHNOLOGY =====
        Mahasiswa(
            nrp = "160422017",
            nama = "Isabelle Tjahjono",
            program = "DMT",
            aboutMe = "Saya menyukai pengembangan media digital yang interaktif dan estetis. Saya tertarik dengan desain UI/UX, animasi 3D, serta pengolahan video digital.",
            courses = listOf("Digital Video", "3D Animation", "Physically Based Animation", "Full-Stack Programming"),
            experiences = listOf("Desainer UI/UX Freelance", "Anggota Tim Multimedia KMM", "Finalis Lomba Desain Interaktif"),
            imagedId = 0,
            url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9yiY3-gsHMjS07MKkKWP_amyGEpMKMyHfIpRFjm8FUCfqmlQ_xTB45FskOWOz2KqczA4&usqp=CAU",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422018",
            nama = "Bianca Tirtayasa",
            program = "DMT",
            aboutMe = "Saya senang menciptakan karya visual digital yang ekspresif. Saya percaya teknologi bisa menjadi sarana kreativitas tanpa batas.",
            courses = listOf("3D Animation", "Digital Video", "Physically Based Animation", "UI/UX Design"),
            experiences = listOf("Anggota Studio Multimedia Kampus", "Peserta Lomba Animasi Nasional", "Freelancer Motion Graphics"),
            imagedId = R.drawable.bianca,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422019",
            nama = "Daniel Prakoso",
            program = "DMT",
            aboutMe = "Saya suka menggabungkan seni, desain, dan teknologi. Fokus saya adalah menciptakan media interaktif yang menyenangkan sekaligus edukatif.",
            courses = listOf("Full-Stack Programming", "Digital Video", "3D Animation", "Game Concept & Design"),
            experiences = listOf("Content Creator EduTech", "Panitia Festival Multimedia 2025", "Magang di Divisi Creative Tech"),
            imagedId = R.drawable.daniel,
            url = "",
            isFriend = false
        ),
        Mahasiswa(
            nrp = "160422020",
            nama = "Ryan Tjahjadi",
            program = "DMT",
            aboutMe = "Saya berfokus pada integrasi antara teknologi web dan multimedia interaktif. Saya ingin berkarier sebagai digital media developer yang inovatif.",
            courses = listOf("Physically Based Animation", "Digital Video", "Full-Stack Programming", "UI/UX Design"),
            experiences = listOf("Panitia Multimedia Expo", "Developer Website Interaktif Kampus", "Finalis Desain Web Competition 2024"),
            imagedId = 0,
            url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFsOnxkzIpkpiHXORPTA8iTl6GVO2F4T9XMA&s",
            isFriend = false
        )
    )
}