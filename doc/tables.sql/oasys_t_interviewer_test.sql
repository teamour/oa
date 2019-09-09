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
-- Table structure for table `t_interviewer_test`
--

DROP TABLE IF EXISTS `t_interviewer_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_interviewer_test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试验id',
  `interviewer_id` int(11) DEFAULT NULL COMMENT '面试人员id',
  `handler1` int(11) DEFAULT NULL COMMENT '担当1',
  `handler2` int(11) DEFAULT NULL COMMENT '担当2',
  `test_score` int(11) DEFAULT NULL COMMENT '考试分数',
  `is_pass` bit(1) DEFAULT b'0' COMMENT '合格否（0:不合格 1:合格）',
  `japanese_certificate` varchar(255) DEFAULT NULL COMMENT '日语资格证',
  `english_certificate` varchar(255) DEFAULT NULL COMMENT '英语资格证',
  `computer_certificate` varchar(255) DEFAULT NULL COMMENT '计算机资格证书',
  `japanese_listen` int(11) DEFAULT NULL COMMENT '日语听力',
  `japanese_speak` int(11) DEFAULT NULL COMMENT '日语口语',
  `japanese_read` int(11) DEFAULT NULL COMMENT '日语文档阅读',
  `japanese_write` int(11) DEFAULT NULL COMMENT '日语文档书写',
  `english_listen` int(11) DEFAULT NULL COMMENT '英语听力',
  `english_speak` int(11) DEFAULT NULL COMMENT '英语口语',
  `english_read` int(11) DEFAULT NULL COMMENT '英语文档阅读',
  `english_write` int(11) DEFAULT NULL COMMENT '英语文档书写',
  `skill_ability` text COMMENT '技术能力',
  `description` text COMMENT '备考',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`test_id`),
  KEY `fk_interviewer_interviewer_test_interviewerid` (`interviewer_id`),
  CONSTRAINT `fk_interviewer_interviewer_test_interviewerid` FOREIGN KEY (`interviewer_id`) REFERENCES `t_interviewer` (`interviewer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='面试人员IT適性試験';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_interviewer_test`
--

LOCK TABLES `t_interviewer_test` WRITE;
/*!40000 ALTER TABLE `t_interviewer_test` DISABLE KEYS */;
INSERT INTO `t_interviewer_test` VALUES (1,1,1,1,11,_binary '\0','111','11','11',11,11,11,11,11,11,11,11,'11','11','2019-05-29 22:57:09','2019-05-29 22:57:13',NULL,_binary '\0');
/*!40000 ALTER TABLE `t_interviewer_test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:31
