<?php
require "conn.php";
$jour =$_POST["jour"];
$heure_passage =$_POST["heure_de_passage"];
$observation =$_POST["observation"];
$image =$_POST["image"];
$heure_arriver =$_POST["heure_arriver"];
$heure_depart =$_POST["heure_depart"];
$effectif_releve =$_POST["effectif_releve"];
$signature =$_POST["signature"];
$lvl_observation =$_POST["lvl_observation"];
$id_agent =1;
$nom_equipement=$_POST["nom_equipement"];

$mysql_qry = 'INSERT INTO `releve`(`jour`, `heure_de_passage`, `observation`, `image`, `heure_arriver`, `heure_depart`, `effectif_releve`, `signature`, `lvl_observation`, `id_agent`, `nom_equipement`) VALUES ($jour,$heure_passage,$observation,$image,$heure_arriver,$heure_depart,$effectif_releve,$signature,$lvl_observation,$id_agent,$nom_equipement)';
mysqli_query($conn ,$mysql_qry);

?>