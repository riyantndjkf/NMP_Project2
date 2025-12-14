<?php
include 'connection.php';

$nrp = isset($_GET['nrp']) ? $_GET['nrp'] : '';

$sql = "SELECT * FROM student WHERE nrp = '$nrp'";
$result = $conn->query($sql);

$arr = array();
if($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        array_push($arr, $row);
    }
    echo json_encode(array("result" => "OK", "data" => $arr));
} else {
    echo json_encode(array("result" => "ERROR", "message" => "Student not found"));
}
?>