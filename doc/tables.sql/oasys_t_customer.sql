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
-- Table structure for table `t_customer`
--

DROP TABLE IF EXISTS `t_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户公司名称',
  `website` varchar(255) DEFAULT NULL COMMENT '客户网址',
  `registered_capital` int(11) DEFAULT NULL COMMENT '资本金',
  `employee_number` int(11) DEFAULT NULL COMMENT '社员数',
  `establish_date` date DEFAULT NULL COMMENT '成立日',
  `company_type` int(11) DEFAULT NULL COMMENT '公司性质(对应字典表)',
  `address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `zip_code` varchar(50) DEFAULT NULL COMMENT '邮编',
  `ceo` varchar(50) DEFAULT NULL COMMENT '代表取缔役',
  `main_business` varchar(255) DEFAULT NULL COMMENT '主要业务',
  `cooperation_direction` varchar(255) DEFAULT NULL COMMENT '和本公司的合作方向',
  `cooperation_intention` int(11) DEFAULT NULL COMMENT '合作意向（对应字典表）',
  `is_upper` bit(1) DEFAULT NULL COMMENT '上场或者非上场（0:非上场 1:上场）',
  `contact_channel` varchar(255) DEFAULT NULL COMMENT '联系渠道',
  `sales_staff` varchar(255) DEFAULT NULL COMMENT '营业担当',
  `sales_telephone` varchar(255) DEFAULT NULL COMMENT '营业电话',
  `sales_email` varchar(255) DEFAULT NULL COMMENT '营业邮箱',
  `skill_require` varchar(255) DEFAULT NULL COMMENT '技术需求',
  `proposal1_email` varchar(255) DEFAULT NULL COMMENT '提案用邮箱1',
  `proposal1_handler` varchar(255) DEFAULT NULL COMMENT '提案用担当1',
  `proposal2_email` varchar(255) DEFAULT NULL COMMENT '提案用邮箱2',
  `proposal2_handler` varchar(255) DEFAULT NULL COMMENT '提案用担当2',
  `proposal3_email` varchar(255) DEFAULT NULL COMMENT '提案用邮箱3',
  `proposal3_handler` varchar(255) DEFAULT NULL COMMENT '提案用担当3',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='客户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
INSERT INTO `t_customer` VALUES (1,'世嘉','www.SEGA .com',300000,20,'2019-05-01',0,'新宿','SEGA＠gmail.com','David Rosen','游戏开发','永久',4,_binary '\0','网络','杨桑','133333333','','','tigerhu33@gmail.com','胡然','','','','',NULL,NULL,NULL,NULL),(5,'TES','www.tes.com',1000000,100,'2019-08-06',1,'东京','61000','不知道','IT服务','技术支持',5,_binary '\0','mail','金桑','123456789','kinmh@te-system.com','无','tangjie094@gmail.com','汤杰','','','','',NULL,NULL,NULL,NULL),(6,'our','www.our.com',100000,1000,'2019-08-13',0,'东京','123131','不知道','IT服务','技术支持',3,_binary '\0','mail','金桑','123456789','kinmh@te-system.com','无','tangjie094@gmail.com','汤杰','','','','',NULL,NULL,NULL,NULL),(8,'任天堂株式会社','www.rentiantang.com',300000000,3000,'1994-05-02',0,'东京','100000','不知道','主机游戏','技术支持',1,_binary '\0','mail','杨桑','07070707070','kinmh@te-system.com','c++高级工程师','kinmh@te-system.com','金桑','kym@te-system.com','候桑','tigerhu33@gmail.com','胡然',NULL,NULL,NULL,NULL),(9,'aaa','www.rentiantang.com',111,11,'2019-08-04',0,'','','','','',0,_binary '\0','','','','','','','','','','','',NULL,NULL,NULL,NULL),(10,'HIMACS','',NULL,NULL,NULL,0,'','','','','',5,_binary '\0','','','','','','355829242@qq.com','HAN','fan62922093@126.com','ANDY','','',NULL,NULL,NULL,NULL),(11,'HUAWEI','',NULL,NULL,NULL,1,'','','','','',1,_binary '\0','','HAN','','hantouyou@hotmail.com','','hantouyou@hotmail.com','WANG','','','','',NULL,NULL,NULL,NULL),(12,'NEC','',NULL,NULL,NULL,0,'','','','','',0,_binary '','','','','','','','','','','','',NULL,NULL,NULL,NULL),(13,'SONY','',NULL,NULL,NULL,0,'','','','','',1,_binary '\0','','','','','','xx@sony.com','sony','','','','',NULL,NULL,NULL,NULL),(14,'FUJI','',NULL,NULL,NULL,0,'','','','','',4,_binary '\0','','','','','','aaa@fuji.com','','','','','',NULL,NULL,NULL,NULL),(15,'JCOM','',NULL,NULL,NULL,0,'','','','','',0,_binary '\0','','','','','','','','hantouyou1985@gmail.com','HAN','','',NULL,NULL,NULL,NULL),(16,'NIKON','',NULL,NULL,NULL,0,'','','','','',4,_binary '\0','','','','','','','','','','','',NULL,NULL,NULL,NULL),(17,'CANNO','',NULL,NULL,NULL,0,'','','','','',3,_binary '\0','','','','','','tangjie094@gmail.com','汤杰','tangjie094@gmail.com','候','','',NULL,NULL,NULL,NULL),(18,'COCO','',NULL,NULL,NULL,1,'','','','','',4,_binary '','','','','','','','','','','','',NULL,NULL,NULL,NULL),(19,'NTT','',NULL,NULL,NULL,0,'','','','','',5,_binary '\0','','範東洋','','hantoyo@ouresouce.com','','hantoyo@ouresouce.com','範東洋','','','','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_customer` ENABLE KEYS */;
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
