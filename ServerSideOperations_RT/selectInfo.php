<?php
require "conn.php";
$param = $_POST["gym"];
$heureactuelle = /*date('H:i:s')*/'20:00:00';
$datejour=/*	'2017-03-27';	*/date("Y-m-d");

if(strtotime($heureactuelle) < strtotime("21:00:00") && strtotime($heureactuelle) >= strtotime("19:00:00")){
	$heuredebut='19:00:00';
	$heurefin='21:00:00';
}
elseif(strtotime($heureactuelle) < strtotime("23:00:00") && strtotime($heureactuelle) >= strtotime("21:00:00")){
	$heuredebut='21:00:00';
	$heurefin='23:00:00';
}


$mysql_qry = "Select nom_association,nbr_adherents from reserver inner join association using(nom_association) where date_reservation = '".$datejour."' and heure_reservation<'21:00:00' and heure_reservation>='00:00:00' and nom_equipement='".$param."'";
$result = mysqli_query($conn ,$mysql_qry);
//$heureActuelle=date("H:i:s");

$creneau="";

if($heureactuelle < '21:00:00' && $heureactuelle >='19:00:00'){
	$creneau="19h - 21h";
}
elseif($heureactuelle < '23:00:00' && $heureactuelle >='21:00:00'){
		$creneau="21h - 23h";

}


while($row = $result->fetch_array(MYSQLI_NUM)){
	printf ("%s,%s,%s,%s,%s",  $datejour, $heureactuelle, $row[0], $creneau, $row[1]);
}
?> 