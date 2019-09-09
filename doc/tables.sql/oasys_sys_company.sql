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
-- Table structure for table `sys_company`
--

DROP TABLE IF EXISTS `sys_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `company_code` varchar(255) DEFAULT NULL COMMENT '公司英文缩写',
  `address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `zip_code` varchar(50) DEFAULT NULL COMMENT '邮编',
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL COMMENT '公司电话号码',
  `website` varchar(255) DEFAULT NULL COMMENT '公司网址',
  `is_bp` bit(1) DEFAULT b'0' COMMENT '是否是bp公司 （0:否 1:是）',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '口座銀行',
  `branch_bank` varchar(255) DEFAULT NULL COMMENT '口座支店',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '口座番号',
  `bank_desc` varchar(255) DEFAULT NULL COMMENT '口座備考',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司表(包含bp)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_company`
--

LOCK TABLES `sys_company` WRITE;
/*!40000 ALTER TABLE `sys_company` DISABLE KEYS */;
INSERT INTO `sys_company` VALUES (1,'OUR株式会社','OUR','东京1 详细地址1','111-1111','our@111.com','111-1111-1111','our.com',_binary '\0','みずほ銀行','001','024','what this?',NULL,NULL,NULL,_binary '\0'),(2,'TES株式会社','TES','东京2 详细地址2','222-2222','tes@222.com','222-2222-2222','test.com',_binary '\0','みずほ銀行','002','021','gg',NULL,NULL,NULL,_binary '\0'),(3,'暂时不存在的测试会社','Nameless','unknownplace','000-0000','nl@000.com','000-0000-0000','un.com',_binary '\0','nobank','000','000',NULL,NULL,NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `sys_company` ENABLE KEYS */;
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
