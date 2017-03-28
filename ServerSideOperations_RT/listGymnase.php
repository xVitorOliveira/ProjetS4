<?php
require "conn.php";
//$heuredebut='';
//$heurefin='';
$heureactuelle = /*date('H:i:s')*/'20:00:00';//'11:00:00';
$datejour=	'2017-03-28';	/*date("Y-m-d")*/;

if(strtotime($heureactuelle) < strtotime("21:00:00") && strtotime($heureactuelle) >= strtotime("19:00:00")){
	$heuredebut='19:00:00';
	$heurefin='21:00:00';
}
elseif(strtotime($heureactuelle) < strtotime("23:00:00") && strtotime($heureactuelle) >= strtotime("21:00:00")){
	$heuredebut='21:00:00';
	$heurefin='23:00:00';
}

$mysql_qry = "Select nom_equipement from reserver inner join composer using(nom_equipement) where date_reservation =
 '".$datejour."' and heure_reservation<'".$heurefin."' and heure_reservation>=
 '".$heuredebut."' and nom_equipement IN(select nom_equipement from releve where heure_de_passage<
 '".$heurefin."' and heure_de_passage>='".$heuredebut."' and jour= '".$datejour."')";
 
//$mysql_qry = "Select nom_equipement from reserver inner join composer using(nom_equipement) where date_reservation = '2017-03-27' and heure_reservation<'21:00:00' and heure_reservation>='00:00:00' and nom_equipement IN(select nom_equipement from releve where heure_de_passage<'21:00:00' and heure_de_passage>='00:00:00' and jour= '2017-03-27')";
$result = mysqli_query($conn ,$mysql_qry);
//if($result){
while($row = $result->fetch_array(MYSQLI_NUM)){
	printf ("%s,", $row[0]);
}
//}
//else{
	//echo "kek";
//}
/*
Select nom_equipement from reserver inner join composer using(nom_equipement) where date_reservation = '2017-03-27' and heure_reservation<'21:00:00' and heure_reservation>='00:00:00' and nom_equipement IN(select nom_equipement from releve where heure_de_passage<'21:00:00' and heure_de_passage>='00:00:00' and jour= '2017-03-27')
*/
?> 

