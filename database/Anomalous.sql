-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: localhost    Database: anomalous
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `game_scores`
--

DROP TABLE IF EXISTS `game_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_scores` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `date_played` date DEFAULT NULL,
  `player_name` varchar(50) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `k_score` int DEFAULT '0',
  `s_score` int DEFAULT '0',
  `a_score` int DEFAULT '0',
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_scores`
--

LOCK TABLES `game_scores` WRITE;
/*!40000 ALTER TABLE `game_scores` DISABLE KEYS */;
INSERT INTO `game_scores` VALUES (1,'2021-12-02','Bubba Gump','KittyLuvr94',200,260,180),(2,'2021-12-04','nosferatu','nsync_luvr92',30,40,30),(5,'2021-12-04','cheese','puppy_hugz92',30,90,60),(7,'2021-12-04','coraluna','puppy_#1Fan84',10,10,80),(8,'2021-12-04','Sarah','booty_playa84',90,40,30),(9,'2021-12-04','Sydney','booty_#1Fan75',80,60,90),(10,'2021-12-04','sarah','xfiles_playa84',30,90,60),(11,'2021-12-04','asdf','muffin_chick75',30,40,30),(12,'2021-12-04','asdfsadf','muffin_chick75',90,40,30),(13,'2021-12-04','fhfdgs','kewl_bro78',30,40,30),(14,'2021-12-04','sdfg','xfiles_luvr78',10,10,80),(15,'2021-12-04','gadf','xfiles_playa75',30,90,60),(16,'2021-12-04','asdf','muffin_chick75',90,40,30),(17,'2021-12-04','ahfed','muffin_bro78',30,40,30),(18,'2021-12-04','jghfd','chbullz_babe83',80,60,90),(19,'2021-12-08','Jeebus','nsync_#1Fan85',60,0,0),(20,'2021-12-08','George Carlin','booty_#1Fan75',10,50,0),(21,'2021-12-08','d','kitty_playa84',30,0,30),(22,'2021-12-08','Batman','kewl_playa91',10,20,30),(23,'2021-12-08','BartSimpson','kewl_playa84',10,40,10),(24,'2021-12-08','Please Work','xfiles_bro79',30,10,20),(25,'2021-12-08','DidThisWork?','bsb_chick75',20,30,10),(26,'2021-12-08','Cam Rowe','xfiles_playa79',10,20,30),(27,'2021-12-08','Joe McMilla','nsync_#1Fan85',10,30,20),(28,'2021-12-08','GordonClark','booty_#1Fan84',30,10,20),(29,'2021-12-08','Donna Clark','bsb_#1Fan92',20,20,20),(30,'2021-12-08','Cher','xfiles_bro85',20,10,30),(31,'2021-12-08','Shakira','booty_bro94',20,0,40),(32,'2021-12-08','Prof_McG','bsb_bro75',40,10,10),(33,'2021-12-08','Zelda','kewl_#1Fan94',30,0,30),(34,'2021-12-08','Brutus','kewl_bro73',10,10,40),(35,'2021-12-08','Michelle','boombox_chick92',20,20,20),(36,'2021-12-08','Mario','boombox_playa84',20,30,10),(37,'2021-12-08','Cartman','xfiles_playa84',10,40,10),(38,'2021-12-08','Kenny','puppy_#1Fan92',40,10,10),(39,'2021-12-08','Marty','boombox_playa84',10,10,40),(40,'2021-12-08','Michelle','boombox_chick92',10,30,20),(41,'2021-12-08','Michelle','boombox_chick92',20,20,20),(42,'2021-12-09','Kermit','puppy_#1Fan84',50,0,10),(43,'2021-12-09','Prof Gordon','bsb_bro75',20,20,20);
/*!40000 ALTER TABLE `game_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story_parts`
--

DROP TABLE IF EXISTS `story_parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `story_parts` (
  `part_id` int NOT NULL AUTO_INCREMENT,
  `story_a` varchar(1500) DEFAULT NULL,
  `story_b` varchar(1500) DEFAULT NULL,
  `story_c` varchar(1500) DEFAULT NULL,
  `action_a` varchar(1500) DEFAULT NULL,
  `action_b` varchar(1500) DEFAULT NULL,
  `action_c` varchar(1500) DEFAULT NULL,
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_parts`
--

LOCK TABLES `story_parts` WRITE;
/*!40000 ALTER TABLE `story_parts` DISABLE KEYS */;
INSERT INTO `story_parts` VALUES (1,'this is version a of the story','this is version b of the story','this is version c of the story','this is action a','this is action b','this is action c'),(2,'this is version a2 of the story','this is version b2 of the story','this is version c2 of the story','this is action a2','this is action b2','this is action c2'),(3,'So this kind thing happened','so this mean thing happened','so this adventurous thing happened','so I did this nice thing','I did this mean thing','I did this funny thing'),(4,'So this kind2 thing happened','so this mean2 thing happened','so this adventurous2 thing happened','so I did this nice2 thing','I did this mean2 thing','I did this funny2 thing'),(5,'So this kind3 thing happened','so this mean3 thing happened','so this adventurous3 thing happened','so I did this nice3 thing','I did this mean3 thing','I did this funny3 thing');
/*!40000 ALTER TABLE `story_parts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-13 22:09:57
