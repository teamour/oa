-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: oasys
-- ------------------------------------------------------
-- Server version	5.7.27-log

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
-- Table structure for table `t_mailing_customer`
--

DROP TABLE IF EXISTS `t_mailing_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mailing_customer` (
  `mailing_id` int(11) NOT NULL COMMENT '群发id',
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `send_time` datetime DEFAULT NULL COMMENT '实际发送时间',
  `send_result` bit(1) DEFAULT b'0' COMMENT '发送结果(0:失败 1:成功)',
  `send_MailAddress` varchar(45) DEFAULT NULL,
  `send_CustomerName` varchar(45) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  KEY `fk_mailing_mailing_customer_mailingid` (`mailing_id`),
  CONSTRAINT `fk_mailing_mailing_customer_mailingid` FOREIGN KEY (`mailing_id`) REFERENCES `t_mailing` (`mailing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件发送客户记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mailing_customer`
--

LOCK TABLES `t_mailing_customer` WRITE;
/*!40000 ALTER TABLE `t_mailing_customer` DISABLE KEYS */;
INSERT INTO `t_mailing_customer` VALUES (43,1,'2019-08-13 16:19:49',_binary '','tigerhu33@gmail.com','胡然','世嘉'),(44,1,'2019-08-14 11:35:01',_binary '','tigerhu33@gmail.com','胡然','世嘉'),(44,5,'2019-08-14 11:35:04',_binary '','tangjie094@gmail.com','汤杰','TES'),(44,6,'2019-08-14 11:35:07',_binary '','tangjie094@gmail.com','汤杰','our'),(44,8,'2019-08-14 11:35:10',_binary '','kinmh@te-system.com','金桑','任天堂株式会社'),(44,8,'2019-08-14 11:35:13',_binary '','kinmh@te-system.com','候桑','任天堂株式会社'),(44,8,'2019-08-14 11:35:16',_binary '','kinmh@te-system.com','胡然','任天堂株式会社'),(45,6,'2019-08-14 20:09:38',_binary '','kinmh@te-system.com','金桑','our'),(45,8,'2019-08-14 20:09:41',_binary '','kinmh@te-system.com','杨桑','任天堂株式会社'),(46,1,'2019-08-14 20:13:11',_binary '','tigerhu33@gmail.com','胡然','世嘉'),(46,6,'2019-08-14 20:13:15',_binary '','tangjie094@gmail.com','汤杰','our'),(46,8,'2019-08-14 20:13:19',_binary '','kinmh@te-system.com','金桑','任天堂株式会社'),(46,8,'2019-08-14 20:13:23',_binary '','kinmh@te-system.com','候桑','任天堂株式会社'),(46,8,'2019-08-14 20:13:26',_binary '','kinmh@te-system.com','胡然','任天堂株式会社'),(47,5,'2019-08-14 20:36:27',_binary '','kinmh@te-system.com','金桑','TES'),(47,6,'2019-08-14 20:36:30',_binary '','kinmh@te-system.com','金桑','our'),(47,8,'2019-08-14 20:36:33',_binary '','kinmh@te-system.com','杨桑','任天堂株式会社'),(47,11,'2019-08-14 20:36:37',_binary '','hantouyou@hotmail.com','HAN','HUAWEI'),(48,1,'2019-08-14 20:39:38',_binary '','tigerhu33@gmail.com','胡然','世嘉'),(48,5,'2019-08-14 20:39:43',_binary '','tangjie094@gmail.com','汤杰','TES'),(48,6,'2019-08-14 20:39:48',_binary '','tangjie094@gmail.com','汤杰','our'),(48,8,'2019-08-14 20:39:52',_binary '','kinmh@te-system.com','金桑','任天堂株式会社'),(48,8,'2019-08-14 20:39:56',_binary '','kinmh@te-system.com','候桑','任天堂株式会社'),(48,8,'2019-08-14 20:40:01',_binary '','kinmh@te-system.com','胡然','任天堂株式会社'),(48,10,'2019-08-14 20:40:05',_binary '','355829242@qq.com','HAN','HIMACS'),(48,10,'2019-08-14 20:40:10',_binary '','355829242@qq.com','ANDY','HIMACS'),(48,11,'2019-08-14 20:40:15',_binary '','hantouyou@hotmail.com','WANG','HUAWEI'),(48,13,'2019-08-14 20:40:19',_binary '','xx@sony.com','sony','SONY'),(48,17,'2019-08-14 20:40:24',_binary '','tangjie094@gmail.com','汤杰','CANNO'),(48,17,'2019-08-14 20:40:28',_binary '','tangjie094@gmail.com','候','CANNO'),(49,1,'2019-08-15 15:09:40',_binary '\0','tigerhu33@gmail.com','胡然','世嘉'),(50,1,'2019-08-15 15:13:24',_binary '','tigerhu33@gmail.com','胡然','世嘉'),(51,1,'2019-08-15 16:26:03',_binary '','tigerhu33@gmail.com','胡然','世嘉'),(52,6,'2019-08-16 16:38:03',_binary '','tangjie094@gmail.com','汤杰','our');
/*!40000 ALTER TABLE `t_mailing_customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:30
