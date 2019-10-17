# GestionTournoisJeuxVideos

script sql :

CREATE DATABASE `DB`;
CREATE TABLE `users` (
  `NAME` varchar(30) DEFAULT NULL,
  `LASTNAME` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `BIRTH` date DEFAULT NULL,
  `CITY` varchar(30) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`EMAIL`)
);
DELIMITER $$

DROP PROCEDURE IF EXISTS `getUser` $$

CREATE PROCEDURE `getUser` (
  vuser_email VARCHAR (50),
  vuser_pass VARCHAR (30),
  OUT msg VARCHAR (100)
) 
BEGIN
  DECLARE CONTINUE HANDLER FOR 1329 #
  SET msg = "Sorry ! Invalid email and password..." ;
  SELECT 
    name INTO msg 
  FROM
    users
  WHERE email = vuser_email 
    AND password = vuser_pass ;
END $$

DELIMITER ;