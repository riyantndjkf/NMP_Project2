<?php
include 'connection.php';
$sql = "SELECT s.* FROM student s INNER JOIN my_friends f ON s.nrp = f.student_nrp";
$result = $conn->query($sql);
$arr = array();
while($row = $result->fetch_assoc()) {
    array_push($arr, $row);
}
echo json_encode(array("result" => "OK", "data" => $arr));
?>