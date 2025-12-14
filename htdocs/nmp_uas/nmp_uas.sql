-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2025 at 05:33 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nmp_uas`
--

-- --------------------------------------------------------

--
-- Table structure for table `my_friends`
--

CREATE TABLE `my_friends` (
  `id` int(11) NOT NULL,
  `student_nrp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `my_friends`
--

INSERT INTO `my_friends` (`id`, `student_nrp`) VALUES
(9, '160422001'),
(8, '160422006');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `nrp` varchar(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `program` varchar(50) DEFAULT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  `about_me` text DEFAULT NULL,
  `my_course` text DEFAULT NULL,
  `my_experience` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`nrp`, `nama`, `email`, `program`, `foto_url`, `about_me`, `my_course`, `my_experience`) VALUES
('160422001', 'Valerie Hartono', 'valerie@gmail.com', 'DSAI', 'https://images.pexels.com/photos/5409662/pexels-photo-5409662.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 'Saya mahasiswa Data Science yang tertarik pada pemrosesan data besar, kecerdasan buatan, dan pembelajaran mesin.', 'Full-Stack Programming, Native Mobile Programming, Numerical Methods, Hybrid Mobile Programming, Machine Learning, Intelligent Information Retrieval', 'Asisten Peneliti AI di Laboratorium Kampus, Finalis Lomba Data Science Nasional 2024, Panitia Seminar AI Revolution'),
('160422002', 'Michelle Wibowo', 'michelle@gmail.com', 'DSAI', 'michelle.jpeg', 'Saya fokus pada analisis data berbasis statistik dan eksplorasi pola tersembunyi dari data besar.', 'Machine Learning, Numerical Methods, Data Visualization, Database Management', 'Anggota Komunitas Python dan R, Peserta Workshop Deep Learning 2024, Intern di PT DataVision sebagai Junior Data Analyst'),
('160422003', 'Kevin Kusuma', 'kevin@gmail.com', 'DSAI', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4KoWXMFWTmf5fPfBDy9nlLktyPSqVaWbaVjwXxgbkJtBNlZh4LPSCGklv1vQpWAZNHQ8&usqp=CAU', 'Saya antusias terhadap pengembangan model kecerdasan buatan yang efisien. Fokus saya pada machine learning dan NLP.', 'Machine Learning, Intelligent Information Retrieval, Full-Stack Programming, Hybrid Mobile Programming', 'Ketua Tim Penelitian NLP 2024, Developer Chatbot Kampus, Peserta AI Bootcamp by Google'),
('160422004', 'Jonathan Liem', 'jonathan@gmail.com', 'DSAI', 'jonathan.jpeg', 'Sebagai mahasiswa yang mencintai teknologi, saya ingin berkontribusi dalam menciptakan sistem AI yang etis dan transparan.', 'Machine Learning, Numerical Methods, Database Management, Full-Stack Programming', 'Mentor Data Science Club, Panitia AI Fair 2025, Peserta Hackathon Data Analytic'),
('160422005', 'Chloe Wiryawan', 'chloe@gmail.com', 'GD', 'https://images.pexels.com/photos/2704261/pexels-photo-2704261.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'Saya suka menciptakan pengalaman bermain yang imersif melalui desain level dan gameplay yang seru.', 'Game Concept & Design, 3D Animation, Digital Video, Software Engineering', 'Developer Game Indie 2025, Anggota Unity Developer Club, Peserta Game Jam Kampus'),
('160422006', 'Felicia Salim', 'felicia@gmail.com', 'GD', 'felicia.jpeg', 'Saya memiliki ketertarikan pada pengembangan game mobile dengan Unity.', 'Full-Stack Programming, Digital Video, 3D Animation, Game Concept & Design', 'Ketua Proyek Game Adventure Kampus, Peserta Game Developer Conference 2024'),
('160422007', 'Adrian Nugraha', 'adrian@gmail.com', 'GD', 'adrian.jpeg', 'Saya berfokus pada visual dan animasi dalam game. Saya senang menggabungkan seni digital dengan pemrograman interaktif.', 'Physically Based Animation, Digital Video, 3D Animation, Game Concept & Design', 'Desainer Animasi 3D di Proyek Kampus, Freelancer Animator, Panitia Game Expo 2025'),
('160422008', 'Matthew Sudarsono', 'matthew@gmail.com', 'GD', 'https://i.pinimg.com/170x/8c/b5/e4/8cb5e483939ccd619d40205c804b8fa8.jpg', 'Saya suka menggabungkan musik dan storytelling dalam game. Fokus saya pada narasi interaktif.', 'Digital Video, 3D Animation, Game Concept & Design, Software Engineering', 'Composer untuk Game Indie, Panitia Multimedia Festival, Sound Designer di Tim GameDev Kampus'),
('160422009', 'Gabriella Santoso', 'gabriella@gmail.com', 'IMES', 'https://images.pexels.com/photos/7707299/pexels-photo-7707299.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'Saya mahasiswa Sistem Informasi yang fokus pada manajemen data dan proses bisnis perusahaan.', 'Database, Software Engineering, Business Process Management, Enterprise System Design', 'Asisten Dosen Database, Koordinator ERP Project Simulation, Intern di Divisi IT Planning'),
('160422010', 'Jasmine Widjaja', 'jasmine@gmail.com', 'IMES', 'jasmine.jpg', 'Saya suka menghubungkan antara kebutuhan bisnis dan solusi teknologi.', 'Database, Information System Planning, Software Engineering, Business Intelligence', 'Tutor Akademik, Panitia Business Technology Forum, Internship di PT IndoSys'),
('160422011', 'Brandon Halim', 'brandon@gmail.com', 'IMES', 'brandon.jpeg', 'Saya fokus pada integrasi sistem informasi antar divisi. Kolaborasi data adalah kunci digitalisasi.', 'Database, Enterprise Resource Planning, Software Engineering, Full-Stack Programming', 'Asisten Penelitian Sistem ERP, Peserta Business System Hackathon, Anggota IT Consulting Group'),
('160422012', 'Vincent Gozali', 'vincent@gmail.com', 'IMES', 'https://i.pinimg.com/736x/d8/29/15/d82915b9241fcbff1609ca37a9e2f34b.jpg', 'Saya menyukai bidang sistem enterprise yang mendukung manajemen organisasi besar.', 'Database, Project Management, Enterprise System, Information Architecture', 'Project Manager ERP Kampus, Peserta Workshop SAP, Panitia Seminar Digital Transformation'),
('160422013', 'Audrey Tanuwijaya', 'audrey@gmail.com', 'NCS', 'https://images.pexels.com/photos/4995951/pexels-photo-4995951.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'Saya tertarik pada keamanan jaringan dan sistem. Saya menikmati menganalisis potensi serangan siber.', 'Computer Network, Cybersecurity, Internet of Things, Network Management', 'Anggota Tim Keamanan Jaringan Kampus, Peserta CTF Competition 2024, Intern di PT SecureTech'),
('160422014', 'Olivia Gunawan', 'olivia@gmail.com', 'NCS', 'olivia.jpeg', 'Saya fokus pada keamanan data dan proteksi sistem. Tertarik mengembangkan solusi keamanan berbasis IoT.', 'Internet of Things, Computer Network, Cybersecurity, Database', 'Peneliti Junior di Lab Network Security, Peserta CyberCamp Indonesia, Tim IT Support Kampus'),
('160422015', 'Christopher Susanto', 'christopher@gmail.com', 'NCS', 'christopher.jpg', 'Saya memiliki ketertarikan pada arsitektur jaringan skala besar dan firewall konfigurasi.', 'Computer Network, Network Management, Internet of Things, Cybersecurity', 'Network Engineer Intern di PT NetCore, Peserta Workshop Ethical Hacking'),
('160422016', 'Ethan Setiawan', 'ethan@gmail.com', 'NCS', 'https://i.pinimg.com/originals/ea/20/15/ea2015441e5b4934c15d12b7250e0db2.jpg', 'Saya suka meneliti cara kerja serangan siber dan mengembangkan metode pertahanan baru.', 'Cybersecurity, Computer Network, IoT Security, Database', 'Panitia Network Security Seminar, Anggota Komunitas IT Defense, Asisten Praktikum Jaringan'),
('160422017', 'Isabelle Tjahjono', 'isabelle@gmail.com', 'DMT', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9yiY3-gsHMjS07MKkKWP_amyGEpMKMyHfIpRFjm8FUCfqmlQ_xTB45FskOWOz2KqczA4&usqp=CAU', 'Saya menyukai pengembangan media digital yang interaktif dan estetis. Tertarik desain UI/UX.', 'Digital Video, 3D Animation, Physically Based Animation, Full-Stack Programming', 'Desainer UI/UX Freelance, Anggota Tim Multimedia KMM, Finalis Lomba Desain Interaktif'),
('160422018', 'Bianca Tirtayasa', 'bianca@gmail.com', 'DMT', 'bianca.jpeg', 'Saya senang menciptakan karya visual digital yang ekspresif. Teknologi adalah sarana kreativitas.', '3D Animation, Digital Video, Physically Based Animation, UI/UX Design', 'Anggota Studio Multimedia Kampus, Peserta Lomba Animasi Nasional, Freelancer Motion Graphics'),
('160422019', 'Daniel Prakoso', 'daniel@gmail.com', 'DMT', 'daniel.jpeg', 'Saya suka menggabungkan seni, desain, dan teknologi. Fokus menciptakan media interaktif.', 'Full-Stack Programming, Digital Video, 3D Animation, Game Concept & Design', 'Content Creator EduTech, Panitia Festival Multimedia 2025, Magang di Divisi Creative Tech'),
('160422020', 'Ryan Tjahjadi', 'ryan@gmail.com', 'DMT', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFsOnxkzIpkpiHXORPTA8iTl6GVO2F4T9XMA&s', 'Saya berfokus pada integrasi antara teknologi web dan multimedia interaktif.', 'Physically Based Animation, Digital Video, Full-Stack Programming, UI/UX Design', 'Panitia Multimedia Expo, Developer Website Interaktif Kampus, Finalis Desain Web Competition 2024');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `my_friends`
--
ALTER TABLE `my_friends`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_friend_student` (`student_nrp`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`nrp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `my_friends`
--
ALTER TABLE `my_friends`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `my_friends`
--
ALTER TABLE `my_friends`
  ADD CONSTRAINT `fk_friend_student` FOREIGN KEY (`student_nrp`) REFERENCES `student` (`nrp`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
