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
-- Table structure for table `sys_module`
--

DROP TABLE IF EXISTS `sys_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块的id',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `module_path` varchar(255) DEFAULT NULL COMMENT '模块的路径（对应controller里的mapping路径）',
  `module_icon` varchar(255) DEFAULT NULL COMMENT '模块的图标',
  `app_id` int(11) DEFAULT NULL COMMENT '所属app',
  `parent_module_id` int(11) DEFAULT NULL COMMENT '父模块的id',
  `sort_order` int(11) DEFAULT NULL COMMENT '模块排序',
  `status` bit(1) DEFAULT b'1' COMMENT '模块状态(0:禁用 1:可用)',
  PRIMARY KEY (`module_id`),
  KEY `fk_app_module_appid` (`app_id`),
  CONSTRAINT `fk_app_module_appid` FOREIGN KEY (`app_id`) REFERENCES `sys_app` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_module`
--

LOCK TABLES `sys_module` WRITE;
/*!40000 ALTER TABLE `sys_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_module` ENABLE KEYS */;
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
