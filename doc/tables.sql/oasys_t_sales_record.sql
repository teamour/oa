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
-- Table structure for table `t_sales_record`
--

DROP TABLE IF EXISTS `t_sales_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_sales_record` (
  `sales_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '营业记录id',
  `sales_id` int(11) DEFAULT NULL COMMENT '营业id',
  `sales_handler` int(11) DEFAULT NULL COMMENT '营业担当',
  `interview_date` date DEFAULT NULL COMMENT '面试日期',
  `interview_time` time DEFAULT NULL COMMENT '面试时间',
  `priority` tinyint(4) DEFAULT '0' COMMENT '优先度(1:低 2:中 3:高)',
  `interview_address` varchar(255) DEFAULT NULL COMMENT '面试地点',
  `interview_frequency` int(11) DEFAULT NULL COMMENT '面试次数（对应字典表）',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `enter_date` date DEFAULT NULL COMMENT '入场日',
  `notice1` varchar(255) DEFAULT NULL COMMENT '注意事项1',
  `notice2` varchar(255) DEFAULT NULL COMMENT '注意事项2',
  `is_done` bit(1) DEFAULT b'0' COMMENT '是否已经参加面试（0:未参加 1:已参加）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`sales_record_id`),
  KEY `fk_sales_sales_record_salesid` (`sales_id`),
  KEY `fk_project_sales_record_projectid` (`project_id`),
  CONSTRAINT `fk_project_sales_record_projectid` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`),
  CONSTRAINT `fk_sales_sales_record_salesid` FOREIGN KEY (`sales_id`) REFERENCES `t_sales` (`sales_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营业记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sales_record`
--

LOCK TABLES `t_sales_record` WRITE;
/*!40000 ALTER TABLE `t_sales_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sales_record` ENABLE KEYS */;
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
