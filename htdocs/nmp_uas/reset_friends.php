<?php
include 'connection.php';

$sql = "DELETE FROM my_friends";

if ($conn->query($sql) === TRUE) {
    echo json_encode(array("result" => "OK", "message" => "All friends deleted"));
} else {
    echo json_encode(array("result" => "ERROR", "message" => $conn->error));
}
?>