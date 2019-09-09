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
-- Table structure for table `t_document_invoice`
--

DROP TABLE IF EXISTS `t_document_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_document_invoice` (
  `invoice_document_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求书id',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `customer_address` varchar(255) DEFAULT NULL COMMENT '客户地址',
  `customer_charge` varchar(255) DEFAULT NULL COMMENT '客户负责人姓名',
  `company_id` int(11) DEFAULT NULL COMMENT '自社id',
  `pay_deadline` varchar(255) DEFAULT NULL COMMENT '付款期限',
  `unit_price` int(11) DEFAULT NULL COMMENT '単価',
  `template_id` int(11) DEFAULT NULL COMMENT '文档模板id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`invoice_document_id`),
  KEY `fk_customer_document_invoice_customerid` (`customer_id`),
  KEY `fk_company_document_invoice_companyid` (`company_id`),
  KEY `fk_template_invoice_templateid` (`template_id`),
  CONSTRAINT `fk_company_document_invoice_companyid` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`company_id`),
  CONSTRAINT `fk_customer_document_invoice_customerid` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`customer_id`),
  CONSTRAINT `fk_template_invoice_templateid` FOREIGN KEY (`template_id`) REFERENCES `t_document_template` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请求书';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_document_invoice`
--

LOCK TABLES `t_document_invoice` WRITE;
/*!40000 ALTER TABLE `t_document_invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_document_invoice` ENABLE KEYS */;
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
