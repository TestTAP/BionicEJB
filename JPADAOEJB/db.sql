CREATE DATABASE  IF NOT EXISTS `movieplex` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `movieplex`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: movieplex
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinemas` (
  `cinemaID` int(11) NOT NULL AUTO_INCREMENT,
  `cinemaName` varchar(255) NOT NULL,
  `cinemaCapacity` int(11) NOT NULL,
  PRIMARY KEY (`cinemaID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (1,'Dark',33),(2,'New Cinema',22),(3,'someCinema',11),(4,'Vasya',22),(5,'sdfg',55);
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieinfo`
--

DROP TABLE IF EXISTS `movieinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movieinfo` (
  `movieInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `movieID` int(11) DEFAULT NULL,
  `movieYear` int(11) DEFAULT NULL,
  `movieCountry` varchar(45) DEFAULT NULL,
  `movieGenre` varchar(45) DEFAULT NULL,
  `movieDirector` varchar(45) DEFAULT NULL,
  `movieCast` varchar(45) DEFAULT NULL,
  `movieStoryline` varchar(45) DEFAULT NULL,
  `movieDuration` int(11) DEFAULT NULL,
  PRIMARY KEY (`movieInfoID`),
  KEY `fk_movieinfo_movies1` (`movieID`),
  CONSTRAINT `fkMovieID` FOREIGN KEY (`movieID`) REFERENCES `movies` (`movieID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieinfo`
--

LOCK TABLES `movieinfo` WRITE;
/*!40000 ALTER TABLE `movieinfo` DISABLE KEYS */;
INSERT INTO `movieinfo` VALUES (1,1,2012,'USA','genre','IMA','DI','dfflk',120),(10,10,0,'t','t','t','t','t',22);
/*!40000 ALTER TABLE `movieinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `movieID` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(255) NOT NULL,
  `movieShowTime` datetime DEFAULT NULL,
  PRIMARY KEY (`movieID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Inception','2014-12-04 11:22:00'),(10,'tt','1970-01-02 00:21:00');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moviescinemas`
--

DROP TABLE IF EXISTS `moviescinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moviescinemas` (
  `movieID` int(11) NOT NULL,
  `cinemaID` int(11) NOT NULL,
  PRIMARY KEY (`movieID`,`cinemaID`),
  KEY `fk_moviescinemas_cinemas1_idx` (`cinemaID`),
  KEY `fk_moviescinemas_movies1_idx` (`movieID`),
  CONSTRAINT `fk_movieid` FOREIGN KEY (`movieID`) REFERENCES `movies` (`movieID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_cinameid` FOREIGN KEY (`cinemaID`) REFERENCES `cinemas` (`cinemaID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviescinemas`
--

LOCK TABLES `moviescinemas` WRITE;
/*!40000 ALTER TABLE `moviescinemas` DISABLE KEYS */;
INSERT INTO `moviescinemas` VALUES (1,1);
/*!40000 ALTER TABLE `moviescinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `orderUser` int(11) NOT NULL,
  `orderMovie` int(11) NOT NULL,
  `orderCinema` int(11) NOT NULL,
  PRIMARY KEY (`orderID`),
  KEY `fk_bookings_movies1_idx` (`orderMovie`),
  KEY `cinemaID_idx` (`orderCinema`),
  KEY `userID_idx` (`orderUser`),
  CONSTRAINT `orderMovieID` FOREIGN KEY (`orderMovie`) REFERENCES `movies` (`movieID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderCinemaID` FOREIGN KEY (`orderCinema`) REFERENCES `cinemas` (`cinemaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderUserID` FOREIGN KEY (`orderUser`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userLogin` varchar(45) NOT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userType` varchar(35) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `userType` (`userType`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'root','root','admin','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-04 17:13:08
