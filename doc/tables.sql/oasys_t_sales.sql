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
-- Table structure for table `t_sales`
--

DROP TABLE IF EXISTS `t_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_sales` (
  `sales_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '营业id',
  `employee_site_id` int(11) DEFAULT NULL COMMENT '员工现场记录id'',',
  `expect_entery_date1` varchar(255) DEFAULT NULL COMMENT '希望入场日1',
  `expect_entery_date2` varchar(255) DEFAULT NULL COMMENT '希望入场日2',
  ` first_project` varchar(50) DEFAULT NULL COMMENT '优先项目1',
  `second_project` varchar(50) DEFAULT NULL COMMENT '优先项目2',
  `third_project` varchar(50) DEFAULT NULL COMMENT '优先项目3',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`sales_id`),
  KEY `fk_employee_site_sales_employeesiteid` (`employee_site_id`),
  CONSTRAINT `fk_employee_site_sales_employeesiteid` FOREIGN KEY (`employee_site_id`) REFERENCES `t_employee_site` (`employee_site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='营业-员工信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sales`
--

LOCK TABLES `t_sales` WRITE;
/*!40000 ALTER TABLE `t_sales` DISABLE KEYS */;
INSERT INTO `t_sales` VALUES (1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-05-29 20:08:02',NULL,NULL);
/*!40000 ALTER TABLE `t_sales` ENABLE KEYS */;
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
