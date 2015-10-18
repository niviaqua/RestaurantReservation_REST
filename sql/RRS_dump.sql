-- MySQL dump 10.13  Distrib 5.6.27, for osx10.8 (x86_64)
--
-- Host: localhost    Database: restaurant_db
-- ------------------------------------------------------
-- Server version	5.6.27

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('nanking','nanking');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `CONFID` int(11) NOT NULL AUTO_INCREMENT,
  `HOST_NAME` varchar(80) DEFAULT NULL,
  `EMAIL` varchar(80) DEFAULT NULL,
  `PHONE` varchar(30) DEFAULT NULL,
  `PARTY_SIZE` int(11) DEFAULT NULL,
  `DATE` datetime NOT NULL,
  `TIME` time DEFAULT NULL,
  `TABLE_ASSIGNED` varchar(20) DEFAULT NULL,
  `TABLE_STATUS` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CONFID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,'DONALD GUINESS','PENELOPE.GUINESS@abc.com','2830338429',4,'2015-10-05 12:00:46',NULL,'A111','Cancelled'),(2,'MARTIN ASTOR','MARTIN@abc.com','4567643435',5,'2015-10-05 13:00:46',NULL,'A105','Unavailable'),(3,'GENELIA DSOUZA','GD@abc.com','3456543222',1,'2015-10-05 14:00:46',NULL,'A111','Available'),(4,'GIANCARLO CROCETTI','GIANCARLO@abc.com','234565432',21,'2015-10-05 15:00:46',NULL,'A131','Unavailable'),(5,'NIVEDITA JOSHI','nj25532n@pace.com','87654323456',12,'2015-10-06 12:00:46',NULL,'A165','Cancelled'),(6,'PRAVEEN SALITRA','PSALITRA@abc.com','6543254332',1,'2015-10-07 12:00:46',NULL,'A105','Unavailable'),(7,'KASHYAP MUKKAMALLA','KASHYAPM@abc.com','8768765433',6,'2015-10-08 12:00:46',NULL,'A173','Unavailable'),(8,'NITIKA KHANNA','NITIKAKHANNA@abc.com','2345676543',9,'2015-11-05 12:00:46',NULL,'A121','Available'),(9,'EASHA PINNAMANENI','EPINNA@abc.com','2830338429',4,'2015-11-05 12:00:46',NULL,'A201','Available'),(10,'Murli Dhar','md@me.com','12345677',10,'2015-10-05 13:00:46',NULL,'A111','Available'),(12,'Murli Dhar','md1@me.com','12345677',10,'2015-10-05 13:00:46',NULL,'A111','Cancel'),(13,'Tina123','tina@gmail.com','234536457',12,'2015-10-07 12:29:32',NULL,'A101','Waiting'),(14,'MARTIN ASTOR','MARTIN@abc.com','4567643435',5,'2015-10-04 00:00:00',NULL,'A105','Confirm'),(15,'MARTIN ASTOR','MARTIN@abc.com','4567643435',5,'2015-10-04 00:00:00','12:12:12','A111','Confirm');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantprofile`
--

DROP TABLE IF EXISTS `restaurantprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantprofile` (
  `RESTAURANT_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ADDRESS1` varchar(50) DEFAULT NULL,
  `ADDRESS2` varchar(50) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STATE` varchar(10) DEFAULT NULL,
  `ZIP` int(11) DEFAULT NULL,
  `CONTACT_NO` varchar(20) DEFAULT NULL,
  `TIMINGS` varchar(50) DEFAULT NULL,
  `AUTO_ASSIGN` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantprofile`
--

LOCK TABLES `restaurantprofile` WRITE;
/*!40000 ALTER TABLE `restaurantprofile` DISABLE KEYS */;
INSERT INTO `restaurantprofile` VALUES ('Nanking Restaurant','nanking@gmail.com','1634 Broadway','50st - 51st','New York','NY',10019,'212-586-3100','Weekdays 10AM to 11PM Weekends 9AM TO 12AM','1');
/*!40000 ALTER TABLE `restaurantprofile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-07 22:18:39
