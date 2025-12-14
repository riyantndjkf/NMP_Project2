<?php
include 'connection.php';

if(isset($_POST['nrp'])) {
    $nrp = $_POST['nrp'];
    
    $check = $conn->query("SELECT * FROM my_friends WHERE student_nrp = '$nrp'");
    
    if($check->num_rows > 0) {
        echo json_encode(array("result" => "ERROR", "message" => "Already friends"));
    } else {
        $sql = "INSERT INTO my_friends (student_nrp) VALUES ('$nrp')";
        if($conn->query($sql) === TRUE) {
            $countSql = "SELECT COUNT(*) as total FROM my_friends";
            $countResult = $conn->query($countSql);
            $row = $countResult->fetch_assoc();
            $totalFriends = $row['total'];
            
            echo json_encode(array(
                "result" => "OK", 
                "message" => "Success adding friend",
                "total_friends" => $totalFriends 
            ));
        } else {
            echo json_encode(array("result" => "ERROR", "message" => $conn->error));
        }
    }
} else {
    echo json_encode(array("result" => "ERROR", "message" => "NRP not provided"));
}
?>