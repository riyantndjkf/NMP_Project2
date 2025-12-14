<?php
include 'connection.php';

$sql = "SELECT * FROM student";

$result = $conn->query($sql);

$arr = array();
if ($result) {
    while($row = $result->fetch_assoc()) {
        array_push($arr, $row);
    }
}

echo json_encode(array("result" => "OK", "data" => $arr));
?>