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
-- Table structure for table `sys_dictionary_detail`
--

DROP TABLE IF EXISTS `sys_dictionary_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dictionary_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典子项目id',
  `detail_name` varchar(255) DEFAULT NULL COMMENT '字典子项目名称',
  `detail_code` varchar(255) DEFAULT NULL COMMENT '字典子项目code',
  `dict_id` int(11) DEFAULT NULL COMMENT '对应的字典id',
  `sort_order` int(11) DEFAULT NULL COMMENT '子项目显示排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`detail_id`),
  KEY `fk_dict_detail_dictid` (`dict_id`),
  CONSTRAINT `fk_dict_detail_dictid` FOREIGN KEY (`dict_id`) REFERENCES `sys_dictionary` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='字典子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dictionary_detail`
--

LOCK TABLES `sys_dictionary_detail` WRITE;
/*!40000 ALTER TABLE `sys_dictionary_detail` DISABLE KEYS */;
INSERT INTO `sys_dictionary_detail` VALUES (1,'日企',NULL,1,NULL,NULL,NULL,NULL,_binary '\0'),(2,'中国公司',NULL,1,NULL,NULL,NULL,NULL,_binary '\0'),(3,'无',NULL,2,NULL,NULL,NULL,NULL,_binary '\0'),(4,'低',NULL,2,NULL,NULL,NULL,NULL,_binary '\0'),(5,'中',NULL,2,NULL,NULL,NULL,NULL,_binary '\0'),(6,'高',NULL,2,NULL,NULL,NULL,NULL,_binary '\0'),(7,'合作过',NULL,2,NULL,NULL,NULL,NULL,_binary '\0'),(8,'合作中',NULL,2,NULL,NULL,NULL,NULL,_binary '\0'),(9,'上场',NULL,3,NULL,NULL,NULL,NULL,_binary '\0'),(10,'非上场',NULL,3,NULL,NULL,NULL,NULL,_binary '\0'),(11,'合格',NULL,4,NULL,NULL,NULL,NULL,_binary '\0'),(12,'不合格',NULL,4,NULL,NULL,NULL,NULL,_binary '\0'),(13,'大专',NULL,5,NULL,NULL,NULL,NULL,_binary '\0'),(14,'本科',NULL,5,NULL,NULL,NULL,NULL,_binary '\0'),(15,'硕士',NULL,5,NULL,NULL,NULL,NULL,_binary '\0'),(16,'博士',NULL,5,NULL,NULL,NULL,NULL,_binary '\0'),(17,'1',NULL,6,NULL,NULL,NULL,NULL,_binary '\0'),(18,'2',NULL,6,NULL,NULL,NULL,NULL,_binary '\0'),(19,'3',NULL,6,NULL,NULL,NULL,NULL,_binary '\0'),(20,'4',NULL,6,NULL,NULL,NULL,NULL,_binary '\0'),(21,'5',NULL,6,NULL,NULL,NULL,NULL,_binary '\0'),(22,'在职',NULL,7,NULL,NULL,NULL,NULL,_binary '\0'),(23,'离职',NULL,7,NULL,NULL,NULL,NULL,_binary '\0'),(24,'已婚',NULL,8,NULL,NULL,NULL,NULL,_binary '\0'),(25,'未婚',NULL,8,NULL,NULL,NULL,NULL,_binary '\0'),(26,'1',NULL,9,NULL,NULL,NULL,NULL,_binary '\0'),(27,'2',NULL,9,NULL,NULL,NULL,NULL,_binary '\0'),(28,'3',NULL,9,NULL,NULL,NULL,NULL,_binary '\0'),(29,'是',NULL,10,NULL,NULL,NULL,NULL,_binary '\0'),(30,'否',NULL,10,NULL,NULL,NULL,NULL,_binary '\0'),(31,'未准备',NULL,11,NULL,NULL,NULL,NULL,_binary '\0'),(32,'准备中',NULL,11,NULL,NULL,NULL,NULL,_binary '\0'),(33,'准备完成',NULL,11,NULL,NULL,NULL,NULL,_binary '\0'),(34,'未邮寄',NULL,12,NULL,NULL,NULL,NULL,_binary '\0'),(35,'邮寄中',NULL,12,NULL,NULL,NULL,NULL,_binary '\0'),(36,'已收到',NULL,12,NULL,NULL,NULL,NULL,_binary '\0'),(37,'是',NULL,13,NULL,NULL,NULL,NULL,_binary '\0'),(38,'否',NULL,13,NULL,NULL,NULL,NULL,_binary '\0'),(39,'有',NULL,14,NULL,NULL,NULL,NULL,_binary '\0'),(40,'无',NULL,14,NULL,NULL,NULL,NULL,_binary '\0'),(41,'未检查',NULL,15,NULL,NULL,NULL,NULL,_binary '\0'),(42,'已检查',NULL,15,NULL,NULL,NULL,NULL,_binary '\0'),(43,'いち',NULL,16,NULL,NULL,NULL,NULL,_binary '\0'),(44,'に',NULL,16,NULL,NULL,NULL,NULL,_binary '\0'),(45,'さん',NULL,16,NULL,NULL,NULL,NULL,_binary '\0'),(46,'よん',NULL,16,NULL,NULL,NULL,NULL,_binary '\0'),(47,'N1',NULL,17,NULL,NULL,NULL,NULL,_binary '\0'),(48,'N2',NULL,17,NULL,NULL,NULL,NULL,_binary '\0'),(49,'N3',NULL,17,NULL,NULL,NULL,NULL,_binary '\0'),(50,'N4',NULL,17,NULL,NULL,NULL,NULL,_binary '\0'),(51,'N5',NULL,17,NULL,NULL,NULL,NULL,_binary '\0'),(52,'大佬(比N1还厉害)',NULL,17,NULL,NULL,NULL,NULL,_binary '\0'),(53,'PT',NULL,18,NULL,NULL,NULL,NULL,_binary '\0'),(54,'PG',NULL,18,NULL,NULL,NULL,NULL,_binary '\0'),(55,'BSE',NULL,18,NULL,NULL,NULL,NULL,_binary '\0'),(56,'SE',NULL,18,NULL,NULL,NULL,NULL,_binary '\0'),(57,'TL',NULL,18,NULL,NULL,NULL,NULL,_binary '\0'),(58,'PM(Product Manager)产品经理',NULL,19,NULL,NULL,NULL,NULL,_binary '\0'),(59,'PL(Project Leader)项目组长 ',NULL,19,NULL,NULL,NULL,NULL,_binary '\0'),(60,'SE(System Engineer) 系统工程师',NULL,19,NULL,NULL,NULL,NULL,_binary '\0'),(61,'PG(开发人员)',NULL,19,NULL,NULL,NULL,NULL,_binary '\0'),(62,'PT(Project Test)',NULL,19,NULL,NULL,NULL,NULL,_binary '\0'),(63,'OUR',NULL,20,NULL,NULL,NULL,NULL,_binary '\0'),(64,'TES',NULL,20,NULL,NULL,NULL,NULL,_binary '\0'),(65,'请求书模板（默认）',NULL,21,NULL,NULL,NULL,NULL,_binary '\0'),(66,'请求书模板2（没东西）',NULL,21,NULL,NULL,NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `sys_dictionary_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:33
