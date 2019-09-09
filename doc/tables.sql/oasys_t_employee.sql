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
-- Table structure for table `t_employee`
--

DROP TABLE IF EXISTS `t_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `marital_status` int(4) DEFAULT NULL COMMENT '婚姻状况',
  `company_id` int(11) DEFAULT NULL COMMENT '所属公司',
  `dept_id` int(11) DEFAULT NULL COMMENT '所属部门',
  `enter_date` date DEFAULT NULL COMMENT '入社日期',
  `position` int(11) DEFAULT NULL COMMENT '职位（对应字典表中的detailid）',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `the_nearest_station` varchar(255) DEFAULT NULL COMMENT '最寄り駅',
  `telephone` varchar(255) DEFAULT NULL COMMENT '電話番号',
  `working_years` tinyint(4) DEFAULT NULL COMMENT '总经验年数',
  `skill1` int(11) DEFAULT NULL COMMENT '技术1（对应字典详细表里的id）',
  `skill1_years` tinyint(4) DEFAULT NULL COMMENT '技术1的工作年数',
  `skill2` int(11) DEFAULT NULL,
  `skill2_years` tinyint(4) DEFAULT NULL,
  `skill3` int(11) DEFAULT NULL,
  `skill3_years` tinyint(4) DEFAULT NULL,
  `skill_score` tinyint(4) DEFAULT NULL COMMENT '技术评价（1-5星）',
  `skill_analysis` text COMMENT '技术分析',
  `skill_growth` text COMMENT '技术发展',
  `skill_level` int(11) DEFAULT NULL COMMENT '技术level（对应字典表）',
  `japanese_level` int(11) DEFAULT NULL COMMENT '日语level（对应字典表）',
  `salary` int(11) DEFAULT NULL COMMENT '給料',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '口座銀行',
  `branch_bank` varchar(255) DEFAULT NULL COMMENT '口座支店',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '口座番号',
  `bank_desc` varchar(255) DEFAULT NULL COMMENT '口座備考',
  `domestic_address` varchar(255) DEFAULT NULL COMMENT '国内住所',
  `family_support` tinyint(4) DEFAULT NULL COMMENT '扶養家族人数',
  `contract_format` int(11) DEFAULT NULL COMMENT '契約形式(对应字典表)',
  `employment_insurance` bit(1) DEFAULT b'0' COMMENT '雇用保険加入(0:未加入 1:加入)',
  `annuity` bit(1) DEFAULT b'0' COMMENT '年金加入(0:未加入 1:加入)',
  `health_insurance` bit(1) DEFAULT b'0' COMMENT '健康保険加入(0:未加入 1:加入)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`employee_id`),
  KEY `fk_company_employee_companyid` (`company_id`),
  KEY `fk_dept_employee_deptid` (`dept_id`),
  CONSTRAINT `fk_company_employee_companyid` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`company_id`),
  CONSTRAINT `fk_dept_employee_deptid` FOREIGN KEY (`dept_id`) REFERENCES `sys_department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='员工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_employee`
--

LOCK TABLES `t_employee` WRITE;
/*!40000 ALTER TABLE `t_employee` DISABLE KEYS */;
INSERT INTO `t_employee` VALUES (1,'李老大',NULL,99,NULL,NULL,NULL,NULL,NULL,NULL,'不远','神泉','666 6666 6666',4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','1',4,2,NULL,'6666666','6666666',',,,','6666666','大连',5,NULL,_binary '\0',_binary '\0',_binary '\0','2019-05-27 16:49:07',NULL,NULL,_binary '\0'),(2,'王小二',NULL,23,NULL,NULL,NULL,NULL,NULL,NULL,'下北泽','下北泽','777 7777 777',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','4',NULL,NULL,NULL,'123123123123','12312312','123123123,123123123,123123123,123123123','123123','',5,NULL,_binary '\0',_binary '\0',_binary '\0','2019-05-27 17:03:16',NULL,NULL,_binary '\0'),(3,'胡悍三',NULL,99,NULL,NULL,NULL,NULL,NULL,NULL,'下北泽','下北泽','166 6666 6666',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','3',NULL,NULL,NULL,'mizuho','123','123123','123123','天津',2,NULL,_binary '\0',_binary '\0',_binary '\0','2019-05-27 17:16:23',NULL,NULL,_binary '\0'),(4,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','1',NULL,NULL,NULL,'','','','','',1,NULL,NULL,NULL,NULL,'2019-05-29 20:08:02',NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `t_employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:35
