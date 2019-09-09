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
-- Table structure for table `sys_dictionary`
--

DROP TABLE IF EXISTS `sys_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dictionary` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `dict_name` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述/备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='字典表(保存枚举的项目，供页面选择用)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dictionary`
--

LOCK TABLES `sys_dictionary` WRITE;
/*!40000 ALTER TABLE `sys_dictionary` DISABLE KEYS */;
INSERT INTO `sys_dictionary` VALUES (1,'公司性质','客户',NULL,NULL,NULL,_binary '\0'),(2,'合作意向','客户',NULL,NULL,NULL,_binary '\0'),(3,'上场或者非上场','客户',NULL,NULL,NULL,_binary '\0'),(4,'面情结果','hr',NULL,NULL,NULL,_binary '\0'),(5,'学历','hr',NULL,NULL,NULL,_binary '\0'),(6,'マナー','hr',NULL,NULL,NULL,_binary '\0'),(7,'在职情况','hr',NULL,NULL,NULL,_binary '\0'),(8,'婚姻情况','hr',NULL,NULL,NULL,_binary '\0'),(9,'工作意向','hr',NULL,NULL,NULL,_binary '\0'),(10,'是否已删除','hr',NULL,NULL,NULL,_binary '\0'),(11,'材料准备情况','visa',NULL,NULL,NULL,_binary '\0'),(12,'邮寄情况','visa',NULL,NULL,NULL,_binary '\0'),(13,'申请材料','visa',NULL,NULL,NULL,_binary '\0'),(14,'自译日历简历','visa',NULL,NULL,NULL,_binary '\0'),(15,'简历翻译检查','visa',NULL,NULL,NULL,_binary '\0'),(16,'技术评星','employee',NULL,NULL,NULL,_binary '\0'),(17,'日语等级','employee',NULL,NULL,NULL,_binary '\0'),(18,'技术等级','employee',NULL,NULL,NULL,_binary '\0'),(19,'职位','employee',NULL,NULL,NULL,_binary '\0'),(20,'自社','company',NULL,NULL,NULL,_binary '\0'),(21,'请求书模板','document_invoice',NULL,NULL,NULL,_binary '\0'),(22,'发注书模板','document_purchase',NULL,NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `sys_dictionary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:29
