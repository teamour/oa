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
-- Table structure for table `t_employee_site`
--

DROP TABLE IF EXISTS `t_employee_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_employee_site` (
  `employee_site_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工现场记录id',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `expect_enter_date` date DEFAULT NULL COMMENT '预定入场日期',
  `enter_date` date DEFAULT NULL COMMENT '入場日期',
  `end_date` date DEFAULT NULL COMMENT '現場終了日期',
  `sales_staff` varchar(255) DEFAULT NULL COMMENT '営業担当',
  `sales_contact` varchar(255) DEFAULT NULL COMMENT '営業連絡先',
  `sales_email` varchar(255) DEFAULT NULL COMMENT '営業メール',
  `office_clerk` varchar(255) DEFAULT NULL COMMENT '事務担当',
  `office_email` varchar(255) DEFAULT NULL COMMENT '事務メール',
  `settlement_range` varchar(255) DEFAULT NULL COMMENT '精算範囲',
  `unit_price` int(11) DEFAULT NULL COMMENT '単価',
  `is_need_sales_staff` bit(1) DEFAULT b'0' COMMENT '是否需要营业（0:否 1:是）',
  `purchase_order_file` varchar(255) DEFAULT NULL COMMENT '注文書(保存文件路径)',
  `invoice_file` varchar(255) DEFAULT NULL COMMENT '請求書',
  `payment_site` varchar(255) DEFAULT NULL COMMENT '支払いサイト',
  `head_office_clerk` varchar(255) DEFAULT '' COMMENT '本社事務担当',
  `enter_record` text COMMENT '现场入场相关记录',
  `enter_handler` int(255) DEFAULT NULL COMMENT '带入场担当',
  `is_end` bit(1) DEFAULT b'0' COMMENT '现场是否已经结束(0:未结束 1:已结束)',
  `description` text COMMENT '備考',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`employee_site_id`),
  KEY `fk_employee_employee_site_employeeid` (`employee_id`),
  KEY `fk_project_employee_site_projectid` (`project_id`),
  CONSTRAINT `fk_employee_employee_site_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `t_employee` (`employee_id`),
  CONSTRAINT `fk_project_employee_site_projectid` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='员工现场记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_employee_site`
--

LOCK TABLES `t_employee_site` WRITE;
/*!40000 ALTER TABLE `t_employee_site` DISABLE KEYS */;
INSERT INTO `t_employee_site` VALUES (1,1,NULL,NULL,NULL,NULL,'杨桑','~~','~~','~~','~~','12213',123123,_binary '','~~','~~','','','',NULL,NULL,'',NULL,'2019-05-29 19:58:56',NULL,_binary '\0'),(2,2,NULL,NULL,NULL,NULL,'赵桑','','23232','2332','322323','23',23,_binary '','','','','','',NULL,NULL,'',NULL,'2019-05-28 10:24:04',NULL,_binary '\0'),(3,3,NULL,NULL,NULL,NULL,'','','','','','',NULL,_binary '','','','','','',NULL,_binary '\0','',NULL,NULL,NULL,_binary '\0'),(4,4,NULL,NULL,NULL,NULL,'','','','','','',NULL,_binary '','','','','','',NULL,_binary '\0','',NULL,NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `t_employee_site` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:32
