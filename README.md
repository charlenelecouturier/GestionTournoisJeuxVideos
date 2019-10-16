# GestionTournoisJeuxVideos

script sql 

CREATE DATABASE `DB`;
CREATE TABLE `users` (
  `NAME` varchar(30) DEFAULT NULL,
  `LASTNAME` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `BIRTH` date DEFAULT NULL,
  `CITY` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`EMAIL`)
)
