-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 16, 2017 at 10:11 AM
-- Server version: 5.5.53
-- PHP Version: 5.3.10-1ubuntu3.25

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dutinfopw201629`
--

-- --------------------------------------------------------

--
-- Table structure for table `Agents`
--

CREATE TABLE IF NOT EXISTS `Agents` (
  `nom_agent` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `id_agent` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(256) NOT NULL,
  `mdp` varchar(256) NOT NULL,
  PRIMARY KEY (`id_agent`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Agents`
--

INSERT INTO `Agents` (`nom_agent`, `prenom`, `id_agent`, `login`, `mdp`) VALUES
('lamy', 'raf', 1, 'rlamy', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `Association`
--

CREATE TABLE IF NOT EXISTS `Association` (
  `nom_association` varchar(25) NOT NULL,
  `adresse` varchar(25) DEFAULT NULL,
  `theme_sportif` varchar(25) DEFAULT NULL,
  `nbr_adherents` int(11) DEFAULT NULL,
  `nbr_filles` int(11) DEFAULT NULL,
  `nbr_de_garcon` int(11) DEFAULT NULL,
  `id_encadrant` int(11) NOT NULL,
  PRIMARY KEY (`nom_association`),
  KEY `FK_Association_id_encadrant` (`id_encadrant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Association`
--

INSERT INTO `Association` (`nom_association`, `adresse`, `theme_sportif`, `nbr_adherents`, `nbr_filles`, `nbr_de_garcon`, `id_encadrant`) VALUES
('RSCM Badminton', NULL, 'Badminton', 20, 10, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Composer`
--

CREATE TABLE IF NOT EXISTS `Composer` (
  `nom_gymnase` varchar(50) NOT NULL,
  `nom_equipement` varchar(50) NOT NULL,
  PRIMARY KEY (`nom_gymnase`,`nom_equipement`),
  KEY `FK_Composer_nom_equipement` (`nom_equipement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Composer`
--

INSERT INTO `Composer` (`nom_gymnase`, `nom_equipement`) VALUES
('Auguste-Delaune', 'Auguste-Delaune'),
('Marcelin-Berthelot', 'Berthelot'),
('Berthie-Albrecht', 'Berthie-Albrecht'),
('Boissière', 'Boissière'),
('Daniel-Renoult', 'Daniel-Renoult'),
('Diderot', 'Diderot 1'),
('Diderot', 'Diderot 2'),
('Didier-Lefèvre', 'Didier Lefèvre'),
('Estienne-d’Orves', 'Estienne-d’Orves'),
('Gds Pêchers Jean-Delbert', 'Gds Pêchers Jean Delbert Athlétisme'),
('Gds Pêchers Jean-Delbert', 'Gds Pêchers Jean Delbert Football'),
('Gds Pêchers Robert-Legros', 'Gds Pêchers Robert-Legros'),
('Henri-Wallon', 'Henri Wallon'),
('Jean Moulin', 'Jean Moulin Lutte'),
('Jean Moulin', 'Jean Moulin Omnisports'),
('Joliot-Curie', 'Joliot-Curie'),
('Jules-Verne', 'Jules Verne'),
('Montreau', 'Montreau'),
('Paul-Bert', 'Paul-Bert'),
('René-Doriant', 'René-Doriant Gymnastique'),
('René-Doriant', 'René-Doriant Judo'),
('René-Doriant', 'René-Doriant Omnisports'),
('Robert-Barran', 'Robert Barran'),
('Robert Beckrich', 'Robert Beckrich'),
('Robespierre', 'Robespierre'),
('Romain-Rolland', 'Romain-Rolland Judo'),
('Romain-Rolland', 'Romain-Rolland omnisports'),
('Stade des Guillands', 'Stade des Guillands');

-- --------------------------------------------------------

--
-- Table structure for table `Encadrant`
--

CREATE TABLE IF NOT EXISTS `Encadrant` (
  `nom_encadrant` varchar(125) DEFAULT NULL,
  `fonction` varchar(125) DEFAULT NULL,
  `signature` varchar(25) DEFAULT NULL,
  `id_encadrant` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_encadrant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Encadrant`
--

INSERT INTO `Encadrant` (`nom_encadrant`, `fonction`, `signature`, `id_encadrant`) VALUES
('Jean', 'Gardien', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `equipement`
--

CREATE TABLE IF NOT EXISTS `equipement` (
  `nom_equipement` varchar(50) NOT NULL,
  `n__serie` int(11) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`nom_equipement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipement`
--

INSERT INTO `equipement` (`nom_equipement`, `n__serie`, `status`) VALUES
('Auguste-Delaune', 27, 'RAS'),
('Berthelot', 13, 'RAS'),
('Berthie-Albrecht', 7, 'RAS'),
('Boissière', 26, 'RAS'),
('Daniel-Renoult', 20, 'RAS'),
('Diderot 1', 1, 'RAS'),
('Diderot 2', 2, 'RAS'),
('Didier Lefèvre', 18, 'RAS'),
('Estienne-d’Orves', 19, 'RAS'),
('Gds Pêchers Jean Delbert Athlétisme', 14, 'RAS'),
('Gds Pêchers Jean Delbert Football', 15, 'RAS'),
('Gds Pêchers Robert-Legros', 16, 'RAS'),
('Henri Wallon', 17, 'RAS'),
('Jean Moulin Lutte', 3, 'RAS'),
('Jean Moulin Omnisports', 4, 'RAS'),
('Joliot-Curie', 6, 'RAS'),
('Jules Verne', 29, 'RAS'),
('Montreau', 21, 'RAS'),
('Paul-Bert', 10, 'RAS'),
('René-Doriant Gymnastique', 11, 'RAS'),
('René-Doriant Judo', 9, 'RAS'),
('René-Doriant Omnisports', 8, 'RAS'),
('Robert Barran', 28, 'RAS'),
('Robert Beckrich', 25, 'RAS'),
('Robespierre', 12, 'RAS'),
('Romain-Rolland Judo', 23, 'RAS'),
('Romain-Rolland omnisports', 22, 'RAS'),
('Romain-Rolland terrain', 24, 'RAS'),
('Stade des Guillands', 5, 'RAS');

-- --------------------------------------------------------

--
-- Table structure for table `Gymnase`
--

CREATE TABLE IF NOT EXISTS `Gymnase` (
  `nom_gymnase` varchar(25) NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `equipements` int(11) DEFAULT NULL,
  PRIMARY KEY (`nom_gymnase`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Gymnase`
--

INSERT INTO `Gymnase` (`nom_gymnase`, `adresse`, `equipements`) VALUES
('Auguste-Delaune', '2 rue de Nanteuil', 1),
('Berthie-Albrecht', '14 rue Gaston-Lauriau', 1),
('Boissière', '171 boulevard Aristide-Briand', 1),
('Daniel-Renoult', 'Rue de la Côte-du-Nord', 1),
('Diderot', '15 avenue Walwein', 1),
('Didier-Lefèvre', '11 rue Henri-Schmitt', 1),
('Estienne-d’Orves', '16 rue des Hanots', 1),
('Gds Pêchers Jean-Delbert', '75 rue Lenain-de-Tillemont', 2),
('Gds Pêchers Robert-Legros', '21 rue des Grands Pêchers', 1),
('Henri-Wallon', '5 rue Henri-Wallon', 1),
('Jean Moulin', '16 avenue Jean Moulin', 2),
('Joliot-Curie', '6-10 rue Irène-et-Frédéric-Joliot-Curie', 1),
('Jules-Verne', '78-80 rue Édouard-Branly', 1),
('Marcelin-Berthelot', 'Rue Marcelin-Berthelot', 1),
('Montreau', 'Entrée au 31 boulevard Théophile-Sueur', 1),
('Paul-Bert', 'Avenue de la République', 1),
('René-Doriant', '6 rue du Colonel-Raynal', 3),
('Robert Beckrich', 'Allee Suzanne Martorell', 1),
('Robert-Barran', '21 rue des Roches', 1),
('Robespierre', '1 rue Paul-Éluard', 1),
('Romain-Rolland', 'Rue Charles-Delavacquerie', 3),
('Stade des Guillands', 'Rue de l''Épine', 1);

-- --------------------------------------------------------

--
-- Table structure for table `releve`
--

CREATE TABLE IF NOT EXISTS `releve` (
  `jour` date DEFAULT NULL,
  `heure_de_passage` time DEFAULT NULL,
  `observation` varchar(168) DEFAULT NULL,
  `image` varchar(168) DEFAULT NULL,
  `heure_arriver` time DEFAULT NULL,
  `heure_depart` time DEFAULT NULL,
  `effectif_releve` int(11) DEFAULT NULL,
  `signature` varchar(25) DEFAULT NULL,
  `lvl_observation` varchar(125) DEFAULT NULL,
  `id_agent` int(11) NOT NULL,
  `nom_equipement` varchar(25) NOT NULL,
  PRIMARY KEY (`id_agent`,`nom_equipement`),
  KEY `FK_releve_nom_equipement` (`nom_equipement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reserver`
--

CREATE TABLE IF NOT EXISTS `reserver` (
  `date_reservation` date DEFAULT NULL,
  `heure_reservation` time DEFAULT NULL,
  `nbre_de_participants_theorique` int(11) DEFAULT NULL,
  `nom_association` varchar(25) NOT NULL,
  `nom_equipement` varchar(25) NOT NULL,
  PRIMARY KEY (`nom_association`,`nom_equipement`),
  KEY `FK_reserver_nom_equipement` (`nom_equipement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Association`
--
ALTER TABLE `Association`
  ADD CONSTRAINT `FK_Association_id_encadrant` FOREIGN KEY (`id_encadrant`) REFERENCES `Encadrant` (`id_encadrant`);

--
-- Constraints for table `Composer`
--
ALTER TABLE `Composer`
  ADD CONSTRAINT `FK_Composer_nom_equipement` FOREIGN KEY (`nom_equipement`) REFERENCES `equipement` (`nom_equipement`),
  ADD CONSTRAINT `FK_Composer_nom_gymnase` FOREIGN KEY (`nom_gymnase`) REFERENCES `Gymnase` (`nom_gymnase`);

--
-- Constraints for table `releve`
--
ALTER TABLE `releve`
  ADD CONSTRAINT `FK_releve_id_agent` FOREIGN KEY (`id_agent`) REFERENCES `Agents` (`id_agent`),
  ADD CONSTRAINT `FK_releve_nom_equipement` FOREIGN KEY (`nom_equipement`) REFERENCES `equipement` (`nom_equipement`);

--
-- Constraints for table `reserver`
--
ALTER TABLE `reserver`
  ADD CONSTRAINT `FK_reserver_nom_association` FOREIGN KEY (`nom_association`) REFERENCES `Association` (`nom_association`),
  ADD CONSTRAINT `FK_reserver_nom_equipement` FOREIGN KEY (`nom_equipement`) REFERENCES `equipement` (`nom_equipement`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
