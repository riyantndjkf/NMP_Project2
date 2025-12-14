<?php
$conn = new mysqli("localhost", "root", "", "nmp_uas");
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>