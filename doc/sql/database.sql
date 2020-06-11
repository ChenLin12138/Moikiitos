-- MySQL dump 10.13  Distrib 8.0.18, for osx10.14 (x86_64)
--
-- Host: localhost    Database: moikiitos
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `feeds`
--

DROP TABLE IF EXISTS `feeds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feeds` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000007 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feeds`
--

LOCK TABLES `feeds` WRITE;
/*!40000 ALTER TABLE `feeds` DISABLE KEYS */;
INSERT INTO `feeds` VALUES (2,2,'I am Lucy.'),(3,3,'I am John.'),(14,1,'谢谢黄师傅，吃不是羊肉串'),(15,1,'谢谢黄师傅，吃不吃羊肉串'),(16,1,'周冬梅吃不吃羊肉串'),(17,1,'吃个球'),(18,9,'吃羊肉串不？'),(19,6,'哪里整？'),(20,7,'整'),(21,8,'你们吃，我要带娃娃'),(22,9,'@黄师傅 几点吃？'),(23,7,'今晚7点，不见不散'),(24,1,'我是tom哥'),(25,1,'sdfasf\nsfa\nfas\nf\nasd'),(1000000000,1,'PS'),(1000000001,1000000008,'喵喵'),(1000000002,1,'test'),(1000000003,1,'wang'),(1000000004,1000000015,'大家好，我是许褚'),(1000000005,1,'test'),(1000000006,1,'ok');
/*!40000 ALTER TABLE `feeds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `followrelationship`
--

DROP TABLE IF EXISTS `followrelationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `followrelationship` (
  `userid` int(10) unsigned NOT NULL,
  `followid` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `followrelationship`
--

LOCK TABLES `followrelationship` WRITE;
/*!40000 ALTER TABLE `followrelationship` DISABLE KEYS */;
INSERT INTO `followrelationship` VALUES (1,2,1),(1,3,1),(2,3,1),(3,1,1),(6,9,1),(9,6,1),(9,7,1),(9,8,1);
/*!40000 ALTER TABLE `followrelationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_admin'),(2,'ROLE_user'),(3,'ROLE_guest');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_follow`
--

DROP TABLE IF EXISTS `user_follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_follow` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `followid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_follow_UN` (`userid`,`followid`)
) ENGINE=InnoDB AUTO_INCREMENT=342 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_follow`
--

LOCK TABLES `user_follow` WRITE;
/*!40000 ALTER TABLE `user_follow` DISABLE KEYS */;
INSERT INTO `user_follow` VALUES (284,1,2),(28,2,3),(29,3,1),(30,6,9),(31,9,6),(32,9,7),(33,9,8),(285,1000000009,1000000008),(337,1000000015,1);
/*!40000 ALTER TABLE `user_follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,1),(5,3,2),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(199,1000000003,2),(200,1000000005,2),(201,1000000006,2),(202,1000000007,2),(203,1000000008,2),(204,1000000009,2),(205,1000000010,2),(274,1000000011,2),(275,1000000012,2),(276,1000000013,2),(277,1000000014,2),(278,1000000015,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `accountnonlocked` tinyint(1) NOT NULL,
  `accountnonexpired` tinyint(1) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_UN` (`email`),
  UNIQUE KEY `users_UN_username` (`username`),
  KEY `users_email_IDX` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000000016 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'tom','tom@test.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(2,'lucy','lucy@test.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(3,'john','john@test.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(4,'wang','wang@183.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(6,'王阿波','abo@test.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(7,'黄师傅','huang@test.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(8,'Felix','felix@test.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(9,'陈霖','lin@test.com','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',1,1,1),(1000000003,'zhaoyun','zhaoyun@173.com','$2a$10$g0LWo69mA5Cyf7uCXDC.LuGMCQEmiHsX4YIeFIKajz8tHe1FgVuU.',1,1,1),(1000000005,'zhaoyu','zhaoyu@173.com','$2a$10$bDZaI/B.dDSJ2B2bSHziC.Ha49J85Gh6C6hYQQNuwCKfC/.TVxJ3S',1,1,1),(1000000006,'guanyu','guanyu@173.com','$2a$10$iEElgNiJHYiLpqPqJQkLfOv1fVWmI5gsBpyBlAfoG2v3S0462uON2',1,1,1),(1000000007,'liubei','liubei@163.com','$2a$10$FbeV7Bpmpku47x7xY54GBurv0Git3tHm30qtvcbCos0bs1cn4mKHa',1,1,1),(1000000008,'狂大猫','kuang@173.com','$2a$10$QFOaTlq2eAamlhjnF4CrP.jKJw5PSU.kCdmSlHMN8fDvJKNfKphb.',1,1,1),(1000000009,'杂皮猫','zpm@maomao.com','$2a$10$5GAa/qIstg2npIYAMwS4QuW.yQ8uMUOsNLi8m/79GFxDN9MnFL0L6',1,1,1),(1000000010,'kevin','kevinhuang@163.com','$2a$10$.taabb0/bYbZhcuaazMmF.vj3itA9ZJqu3pZYSy8JqmxKKzkkWyPW',1,1,1),(1000000011,'kevinchen','kevinchen@163.com','$2a$10$N4YkbIt..FVWxPtVJn/oKOk57JVjNKeuV4GI8Jabp0iKtbDVhm9Ga',1,1,1),(1000000012,'cty','cty@163.com','$2a$10$4lxQB.UHbu8qMM4qg0XGguWBLoyUNC5dk/MKq72VwZld6OnXvf6ey',1,1,1),(1000000013,'曹操','caocao@163.com','$2a$10$kJcG1AwSlbwgO2U5skJYjuFfEQFVO/EJD8BLl5MnmLgh2SNkGON/K',1,1,1),(1000000014,'jack','jack@173.com','$2a$10$2iWWbC0G0YVA3fis23VWuualjYgjv8f5qvFNU0ULKzI.rIp1RA3wK',1,1,1),(1000000015,'许褚','xuchu@163.com','$2a$10$vI.CR9aXGK15KxbdI2fd6.8MKHhYgA8flGQgk/fOZqBGZOwIf5pJ.',1,1,1);
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

-- Dump completed on 2020-06-11 15:25:04
