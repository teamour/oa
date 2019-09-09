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
-- Table structure for table `t_mailing_attachment`
--

DROP TABLE IF EXISTS `t_mailing_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mailing_attachment` (
  `mailing_attachment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `mailing_id` int(11) DEFAULT NULL COMMENT '群发邮件id',
  `mailing_attachment_title` varchar(255) DEFAULT NULL COMMENT '附件文件名称',
  `mailing_attachment_file` varchar(255) DEFAULT NULL COMMENT '附件文件路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`mailing_attachment_id`),
  KEY `fk_mailing_mailing_attachment_mailingid` (`mailing_id`),
  CONSTRAINT `fk_mailing_mailing_attachment_mailingid` FOREIGN KEY (`mailing_id`) REFERENCES `t_mailing` (`mailing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群发邮件附件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mailing_attachment`
--

LOCK TABLES `t_mailing_attachment` WRITE;
/*!40000 ALTER TABLE `t_mailing_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_mailing_attachment` ENABLE KEYS */;
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
