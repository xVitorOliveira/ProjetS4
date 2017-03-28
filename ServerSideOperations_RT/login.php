<?php
require "conn.php";
$user_name = $_POST["user"];//"rlamy";
$user_password = $_POST["password"];//"password";
$mysql_qry = "select id_agent from reserterre.agents where login = '$user_name' and mdp = '$user_password';";
$result = mysqli_query($conn ,$mysql_qry);
$co="";
if(mysqli_num_rows($result) > 0){
	$co = "true";
}
else{
	$co = "false";
}
while($row = $result->fetch_array(MYSQLI_NUM)){
	printf ("%s,%s",  $co, $row[0]);
}
?>