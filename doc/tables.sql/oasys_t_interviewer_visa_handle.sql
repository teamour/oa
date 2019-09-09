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
-- Table structure for table `t_interviewer_visa_handle`
--

DROP TABLE IF EXISTS `t_interviewer_visa_handle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_interviewer_visa_handle` (
  `visa_handle_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '签证办理id',
  `interviewer_id` int(11) DEFAULT NULL COMMENT '面试人员id',
  `material_prepare_situation` tinyint(4) DEFAULT '0' COMMENT '材料准备情况（0:未准备，1:准备中，2:准备结束）',
  `mailing_situation` tinyint(4) DEFAULT '0' COMMENT '邮寄情况（0:未邮寄，1:邮寄中，2:已收到）',
  `application_material` bit(1) DEFAULT b'0' COMMENT '申请材料(是否已经准备好 0：否 1：是)',
  `self_japanese_resume` bit(1) DEFAULT b'0' COMMENT '自译日文简历(0：没有 1：有)',
  `check_resume` bit(1) DEFAULT NULL COMMENT '简历翻译检查(0:未检查 1:检查)',
  `expect_submit_date` date DEFAULT NULL COMMENT '预计递交日',
  `actual_submit_date` date DEFAULT NULL COMMENT '实际递交日',
  `visa_handle_handler` int(11) DEFAULT NULL COMMENT '签证办理担当',
  `notice_handler` int(11) DEFAULT NULL COMMENT '赴日通知担当',
  `other_handlerf` int(11) DEFAULT NULL COMMENT '其它担当',
  `description` text COMMENT '备考',
  `is_completed` bit(1) DEFAULT b'0' COMMENT '是否完成关闭(0:否 1:是)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`visa_handle_id`),
  KEY `fk_interviewer_interviewer_visa_handle_interviewerid` (`interviewer_id`),
  CONSTRAINT `fk_interviewer_interviewer_visa_handle_interviewerid` FOREIGN KEY (`interviewer_id`) REFERENCES `t_interviewer` (`interviewer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='签证办理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_interviewer_visa_handle`
--

LOCK TABLES `t_interviewer_visa_handle` WRITE;
/*!40000 ALTER TABLE `t_interviewer_visa_handle` DISABLE KEYS */;
INSERT INTO `t_interviewer_visa_handle` VALUES (1,1,0,0,_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\0',NULL,NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `t_interviewer_visa_handle` ENABLE KEYS */;
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
