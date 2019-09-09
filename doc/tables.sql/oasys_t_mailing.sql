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
-- Table structure for table `t_mailing`
--

DROP TABLE IF EXISTS `t_mailing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mailing` (
  `mailing_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '群发id',
  `mailing_aim_summary` varchar(255) DEFAULT NULL COMMENT '群发的目的或原因的概述',
  `mailing_templete_content` text COMMENT '群发的邮件模板内容',
  `begin_time` varchar(30) DEFAULT NULL COMMENT '群发的开始时间',
  `end_time` varchar(30) DEFAULT NULL COMMENT '群发结束时间',
  `operator` int(11) DEFAULT NULL COMMENT '操作人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  `mailstats` int(1) DEFAULT NULL COMMENT '邮件状态',
  `mailnumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`mailing_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='群发邮件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mailing`
--

LOCK TABLES `t_mailing` WRITE;
/*!40000 ALTER TABLE `t_mailing` DISABLE KEYS */;
INSERT INTO `t_mailing` VALUES (43,'tangjie094@gmail.com','22222','2019-08-13 16:19:45356','2019-08-13 16:19:49159',NULL,NULL,'2019-08-13 16:19:49',NULL,NULL,1,NULL),(44,'tangjie094@gmail.com','邮箱test','2019-08-14 11:34:55426','2019-08-14 11:35:15971',NULL,NULL,'2019-08-14 11:35:16',NULL,NULL,1,NULL),(45,'tangjie094@gmail.com','Java要員のご提案','2019-08-14 20:09:34153','2019-08-14 20:09:40665',NULL,NULL,'2019-08-14 20:09:41',NULL,NULL,1,NULL),(46,'tangjie094@gmail.com','PHP要員','2019-08-14 20:13:07178','2019-08-14 20:13:26259',NULL,NULL,'2019-08-14 20:13:26',NULL,NULL,1,NULL),(47,'tangjie094@gmail.com','test2035','2019-08-14 20:36:23589','2019-08-14 20:36:36670',NULL,NULL,'2019-08-14 20:36:37',NULL,NULL,1,NULL),(48,'tangjie094@gmail.com','test2039','2019-08-14 20:39:33572','2019-08-14 20:40:28242',NULL,NULL,'2019-08-14 20:40:28',NULL,NULL,1,NULL),(49,'tangjie094@gmail.com','','2019-08-15 15:09:23981','2019-08-15 15:09:40223',NULL,NULL,'2019-08-15 15:09:40',NULL,NULL,1,NULL),(50,'tangjie094@gmail.com','1','2019-08-15 15:13:19728','2019-08-15 15:13:24376',NULL,NULL,'2019-08-15 15:13:24',NULL,NULL,1,NULL),(51,'tangjie094@gmail.com','11','2019-08-15 16:24:40823','2019-08-15 16:26:14945',NULL,NULL,'2019-08-15 16:26:15',NULL,NULL,1,NULL),(52,'tangjie094@gmail.com','test邮箱的标题','2019-08-16 16:37:5360','2019-08-16 16:38:02937',NULL,NULL,'2019-08-16 16:38:03',NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `t_mailing` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:34
