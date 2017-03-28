<?php
require "conn.php";
$effH = $_POST["effH"];
$effF = $_POST["effF"];
$lvl = $_POST["lvl"];
$retardStr = $_POST["retard"];
$obs = $_POST["obs"];
$idagent=$_POST["idAgent"];
$equipement=$_POST["gyms"]; 
$datejour=date("Y-m-d");
$heurepsg='20:00:00';//date("H:i:s");
if($retardStr="true"){
	$retard="1";
}else{
	$retard="0";
}
$mysql_qry = "INSERT INTO `releve`(`jour`, `heure_de_passage`, `observation`, `effectif_releve_homme`,
 `effectif_releve_femme`, `lvl_observation`, `id_agent`, `nom_equipement`, `retard`) VALUES ('".$datejour."', '".$heurepsg."', '".$obs."', ".$effH.", ".$effF.", '".$lvl."', ".$idagent.", '".$equipement."',".$retard.")";
//echo($datejour.", ".$heurepsg.", ".$obs.", ".$effH.", ".$effF.", ".$lvl.", ".$idagent.", ".$equipement.",".$retard);
 $result = mysqli_query($conn ,$mysql_qry);

?> 