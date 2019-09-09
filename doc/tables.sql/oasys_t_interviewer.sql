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
-- Table structure for table `t_interviewer`
--

DROP TABLE IF EXISTS `t_interviewer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_interviewer` (
  `interviewer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '面试人员id',
  `interviewer_code` varchar(255) DEFAULT NULL COMMENT '面试人员编号',
  `interviewer_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `interview_result` bit(1) DEFAULT NULL COMMENT '面情结果（1面，2面，3面任何一个为NG的时候，可以设置为不合格）',
  `interview1_time` datetime DEFAULT NULL COMMENT '1面的时间',
  `interview1_result` bit(1) DEFAULT NULL COMMENT '1面结果',
  `interview1_handler` varchar(255) DEFAULT NULL COMMENT '1面担当',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `japanese_socre` int(11) DEFAULT NULL COMMENT '日语分数（对应字典表）',
  `japanese_conversation_ability` text COMMENT '日语会话能力',
  `graduated_school` varchar(255) DEFAULT NULL COMMENT '毕业大学',
  `profession` varchar(255) DEFAULT NULL COMMENT '专业',
  `graduated_date` date DEFAULT NULL COMMENT '毕业日期',
  `education` int(11) DEFAULT NULL COMMENT '学历（ex：大专，大学...,对应字典表）',
  `certificate` varchar(255) DEFAULT NULL COMMENT '资格证书',
  `manner` tinyint(4) DEFAULT NULL COMMENT 'マナー （1-5分）',
  `personnel_dept_feedback` text COMMENT '人事部意见',
  `interview1_desc` text COMMENT '1面备注',
  `personal_situation` text COMMENT '个人情况',
  `family_situation` varchar(255) DEFAULT NULL COMMENT '家庭情况',
  `service_situation` int(11) DEFAULT NULL COMMENT '在职情况（对应字典表）',
  `nationality` varchar(50) DEFAULT NULL COMMENT '民    族',
  `birthplace` varchar(50) DEFAULT NULL COMMENT '籍    贯',
  `marital_status` int(4) DEFAULT NULL COMMENT '婚姻状况（对应字典表）',
  `expect_salary` int(11) DEFAULT NULL COMMENT '期望薪资',
  `friendship_situation_in_japan` varchar(255) DEFAULT NULL COMMENT '在日朋友关系情况',
  `interview2_time` datetime DEFAULT NULL COMMENT '2面时间',
  `interview2_result` bit(1) DEFAULT NULL COMMENT '2面结果',
  `interview2_handler` varchar(255) DEFAULT NULL COMMENT '2面担当',
  `working_situation` text COMMENT '实际工作年数以及经验能力',
  `internship_experience` varchar(255) DEFAULT NULL COMMENT '实习经验',
  `skill_score` int(11) DEFAULT NULL COMMENT '技术分数（对应字典表）',
  `interview2_desc` text COMMENT '2面备注',
  `technical_department_feedback` text COMMENT '技术部意见',
  `interview3_time` datetime DEFAULT NULL COMMENT '3面时间',
  `interview3_result` bit(1) DEFAULT NULL COMMENT '3面结果',
  `interview3_handler` varchar(255) DEFAULT NULL COMMENT '3面担当',
  `interview3_desc` text COMMENT '3面备注',
  `prev1_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司1',
  `prev2_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司2',
  `prev3_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司3',
  `prev4_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司4',
  `prev5_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司5',
  `work_intent` int(11) DEFAULT NULL COMMENT '工作意向(对应字典表，ex:后续联系（近期不赴日，但将来考虑赴日人员名单）)',
  `company_id` int(11) DEFAULT NULL COMMENT '招入公司id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`interviewer_id`),
  KEY `fk_company_interviewer_companyid` (`company_id`),
  CONSTRAINT `fk_company_interviewer_companyid` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='面试人员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_interviewer`
--

LOCK TABLES `t_interviewer` WRITE;
/*!40000 ALTER TABLE `t_interviewer` DISABLE KEYS */;
INSERT INTO `t_interviewer` VALUES (1,'20190501001','ZS',_binary '\0','2019-05-01 00:00:00',_binary '\0','1',1,20,NULL,80,NULL,NULL,NULL,'2010-06-01',1,NULL,2,NULL,NULL,NULL,NULL,1,NULL,NULL,1,1,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,50,NULL,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,NULL,NULL,NULL,NULL,0,1,'2019-01-01 00:00:00',NULL,NULL,_binary '\0'),(2,'20190501002','ZS',_binary '\0','2019-05-01 00:00:00',_binary '\0','1',1,20,NULL,80,NULL,NULL,NULL,'2010-06-01',1,NULL,2,NULL,NULL,NULL,NULL,1,NULL,NULL,1,1,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,50,NULL,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,NULL,NULL,NULL,NULL,0,1,'2019-01-01 00:00:00',NULL,NULL,_binary '\0'),(3,'20190501003','ZS',_binary '\0','2019-05-01 00:00:00',_binary '\0','1',1,20,NULL,80,NULL,NULL,NULL,'2010-06-01',1,NULL,2,NULL,NULL,NULL,NULL,1,NULL,NULL,1,1,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,50,NULL,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,NULL,NULL,NULL,NULL,0,1,'2019-01-01 00:00:00',NULL,NULL,_binary '\0'),(4,'20190501004','ZS',_binary '\0','2019-05-01 00:00:00',_binary '\0','1',1,20,NULL,80,NULL,NULL,NULL,'2010-06-01',1,NULL,2,NULL,NULL,NULL,NULL,1,NULL,NULL,1,1,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,50,NULL,NULL,'2019-05-05 00:00:00',_binary '','1',NULL,NULL,NULL,NULL,NULL,NULL,0,1,'2019-01-01 00:00:00',NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `t_interviewer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 21:11:28
