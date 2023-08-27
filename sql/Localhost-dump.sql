-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: network
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `combo`
--

DROP TABLE IF EXISTS `combo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `combo` (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '一个 Combo 的唯一标识，必须是 string 类型，必须唯一',
  `x` double DEFAULT NULL COMMENT 'x坐标',
  `y` double DEFAULT NULL COMMENT 'y坐标',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'circle' COMMENT '指定该 Combo 的类型，可以是内置 Combo 的类型名，也可以是自定义 Combo 的类型名。默认是 "circle"',
  `parentId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '该 Combo 的父 Combo 的 ID',
  `size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Combo 的最小尺寸（非固定尺寸），默认 "circle" 类型 Combo 的 size 为 20，"rect" 类型的为 "[20, 5]"',
  `fixSize` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '固定该 Combo 的尺寸，不指定时 Combo 大小由内部元素的分布和大小来决定。若指定了 fixSize 而没有指定 fixCollapseSize，则即使该 Combo 在收起状态下仍然保持 fixSize 指定的尺寸',
  `fixCollapseSize` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '固定该 Combo 收起时的尺寸，不指定时，若未指定 fixSize 则由 size 决定收起时的尺寸，否则统一为 fixSize 尺寸',
  `padding` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '该 Combo 内边距，默认 "circle" 类型 Combo 的 padding 为 "[25, 25, 25, 25]"，"rect" 类型的为 "[25, 20, 15, 20]"',
  `style` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '该 Combo 的样式配置项',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '该 Combo 的文本标签',
  `labelCfg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '该 Combo 的文本标签样式配置项',
  `children` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combo`
--

LOCK TABLES `combo` WRITE;
/*!40000 ALTER TABLE `combo` DISABLE KEYS */;
/*!40000 ALTER TABLE `combo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_connections`
--

DROP TABLE IF EXISTS `device_connections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_connections` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '连接ID，主键',
  `source_device_id` int DEFAULT NULL COMMENT '源设备ID',
  `destination_device_id` int DEFAULT NULL COMMENT '目标设备ID',
  `link_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '链路类型，表示其是万兆光纤链路、千兆光纤链路、千兆铜缆链路',
  `source_interface_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '源设备接口名',
  `destination_interface_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '目标设备接口名',
  `created_at` datetime DEFAULT NULL COMMENT '记录创建时间，在插入新连接记录时自动设置为当前时间',
  `updated_at` datetime DEFAULT NULL COMMENT '记录更新时间，在更新连接记录时自动更新为当前时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='设备连接信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_connections`
--

LOCK TABLES `device_connections` WRITE;
/*!40000 ALTER TABLE `device_connections` DISABLE KEYS */;
INSERT INTO `device_connections` VALUES (1,1,2,NULL,NULL,NULL,NULL,NULL),(2,1,3,NULL,NULL,NULL,NULL,NULL),(3,1,4,NULL,NULL,NULL,NULL,NULL),(4,2,3,NULL,NULL,NULL,NULL,NULL),(5,2,4,'万兆光纤链路',NULL,NULL,NULL,NULL),(6,3,4,NULL,NULL,NULL,NULL,NULL),(7,1,5,NULL,NULL,NULL,NULL,NULL),(8,1,6,NULL,NULL,NULL,NULL,NULL),(9,2,5,'千兆光纤链路',NULL,NULL,NULL,NULL),(10,2,6,NULL,NULL,NULL,NULL,NULL),(11,1,11,NULL,NULL,NULL,NULL,NULL),(12,2,12,NULL,NULL,NULL,NULL,NULL),(13,11,9,'千兆铜缆链路',NULL,NULL,NULL,NULL),(14,11,12,NULL,NULL,NULL,NULL,NULL),(15,12,10,NULL,NULL,NULL,NULL,NULL),(16,9,10,NULL,NULL,NULL,NULL,NULL),(17,9,7,NULL,NULL,NULL,NULL,NULL),(18,10,8,NULL,NULL,NULL,NULL,NULL),(19,7,8,NULL,NULL,NULL,NULL,NULL),(20,1,13,NULL,NULL,NULL,NULL,NULL),(21,2,14,NULL,NULL,NULL,NULL,NULL),(22,13,14,NULL,NULL,NULL,NULL,NULL),(23,1,15,NULL,NULL,NULL,NULL,NULL),(24,1,16,NULL,NULL,NULL,NULL,NULL),(25,15,16,NULL,NULL,NULL,NULL,NULL),(26,1,17,NULL,NULL,NULL,NULL,NULL),(27,2,18,NULL,NULL,NULL,NULL,NULL),(28,17,18,NULL,NULL,NULL,NULL,NULL),(29,1,19,NULL,NULL,NULL,NULL,NULL),(30,2,20,NULL,NULL,NULL,NULL,NULL),(31,19,20,NULL,NULL,NULL,NULL,NULL),(32,1,21,NULL,NULL,NULL,NULL,NULL),(33,2,22,NULL,NULL,NULL,NULL,NULL),(34,21,22,NULL,NULL,NULL,NULL,NULL),(35,1,23,NULL,NULL,NULL,NULL,NULL),(36,2,24,NULL,NULL,NULL,NULL,NULL),(37,23,24,NULL,NULL,NULL,NULL,NULL),(38,1,29,NULL,NULL,NULL,NULL,NULL),(39,2,29,NULL,NULL,NULL,NULL,NULL),(40,1,30,NULL,NULL,NULL,NULL,NULL),(41,2,30,NULL,NULL,NULL,NULL,NULL),(42,1,31,NULL,NULL,NULL,NULL,NULL),(43,2,31,NULL,NULL,NULL,NULL,NULL),(44,27,29,NULL,NULL,NULL,NULL,NULL),(45,28,30,NULL,NULL,NULL,NULL,NULL),(46,27,28,NULL,NULL,NULL,NULL,NULL),(47,1,25,NULL,NULL,NULL,NULL,NULL),(48,2,26,NULL,NULL,NULL,NULL,NULL),(49,25,26,NULL,NULL,NULL,NULL,NULL),(50,1,32,NULL,NULL,NULL,NULL,NULL),(51,2,33,'千兆铜缆链路',NULL,NULL,NULL,NULL),(52,32,33,NULL,NULL,NULL,NULL,NULL),(53,32,34,NULL,NULL,NULL,NULL,NULL),(54,32,36,NULL,NULL,NULL,NULL,NULL),(55,33,35,NULL,NULL,NULL,NULL,NULL),(56,33,36,NULL,NULL,NULL,NULL,NULL),(57,34,35,NULL,NULL,NULL,NULL,NULL),(58,34,37,NULL,NULL,NULL,NULL,NULL),(59,35,38,NULL,NULL,NULL,NULL,NULL),(60,36,39,NULL,NULL,NULL,NULL,NULL),(61,37,38,NULL,NULL,NULL,NULL,NULL),(62,37,40,NULL,NULL,NULL,NULL,NULL),(63,38,41,NULL,NULL,NULL,NULL,NULL),(64,39,42,NULL,NULL,NULL,NULL,NULL),(65,40,41,NULL,NULL,NULL,NULL,NULL),(66,34,43,NULL,NULL,NULL,NULL,NULL),(67,34,44,NULL,NULL,NULL,NULL,NULL),(68,34,45,NULL,NULL,NULL,NULL,NULL),(69,35,44,NULL,NULL,NULL,NULL,NULL),(70,35,45,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `device_connections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_table`
--

DROP TABLE IF EXISTS `dictionary_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dictionary_table` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `type` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型，用于区分不同的选择器',
  `label` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签，用于在 Select 中显示',
  `value` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文本，用于在 Select 中作为选项的文本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_table`
--

LOCK TABLES `dictionary_table` WRITE;
/*!40000 ALTER TABLE `dictionary_table` DISABLE KEYS */;
INSERT INTO `dictionary_table` VALUES (1,'link_type','万兆光纤链路','万兆光纤链路'),(2,'link_type','千兆光纤链路','千兆光纤链路'),(3,'link_type','千兆铜缆链路','千兆铜缆链路'),(4,'combo','核心区','核心区'),(5,'combo','上联子区','上联子区'),(6,'combo','外联区','外联区'),(7,'combo','办公用户区','办公用户区'),(8,'combo','测试环境','测试环境'),(9,'combo','DMZ区','DMZ区'),(10,'combo','营业部','营业部'),(11,'combo','下联子区','下联子区'),(12,'combo','灾备中心','灾备中心');
/*!40000 ALTER TABLE `dictionary_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_type`
--

DROP TABLE IF EXISTS `dictionary_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dictionary_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `type` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型，用于区分不同的选择器',
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_type`
--

LOCK TABLES `dictionary_type` WRITE;
/*!40000 ALTER TABLE `dictionary_type` DISABLE KEYS */;
INSERT INTO `dictionary_type` VALUES (1,'link_type','链路类型'),(2,'combo','节点分区');
/*!40000 ALTER TABLE `dictionary_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edge`
--

DROP TABLE IF EXISTS `edge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edge` (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '边唯一 ID，必须是唯一的字符串',
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '起始点 id',
  `target` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '结束点 id',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'line' COMMENT '指定边的类型，可以是内置边的类型名称，也可以是自定义边的名称。默认为 "line"',
  `sourceAnchor` int DEFAULT NULL COMMENT '边的起始节点上的锚点的索引值',
  `targetAnchor` int DEFAULT NULL COMMENT '边的终止节点上的锚点的索引值',
  `style` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '边的样式属性',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文本文字，如果没有则不会显示',
  `labelCfg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '文本配置项',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edge`
--

LOCK TABLES `edge` WRITE;
/*!40000 ALTER TABLE `edge` DISABLE KEYS */;
/*!40000 ALTER TABLE `edge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_devices`
--

DROP TABLE IF EXISTS `network_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `network_devices` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '设备ID，主键',
  `serial_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备序列号，唯一标识设备的字符串',
  `device_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备名称，简短地描述设备',
  `device_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备类型，表示设备的分类，比如路由器、交换机、防火墙等',
  `combo_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组id',
  `created_at` datetime DEFAULT NULL COMMENT '记录创建时间，在插入新设备记录时自动设置为当前时间',
  `updated_at` datetime DEFAULT NULL COMMENT '记录更新时间，在更新设备记录时自动更新为当前时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='网络设备信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_devices`
--

LOCK TABLES `network_devices` WRITE;
/*!40000 ALTER TABLE `network_devices` DISABLE KEYS */;
INSERT INTO `network_devices` VALUES (1,'HW-CORE-SW-1','HW-CORE-SW-1','switch','核心区',NULL,NULL),(2,'HW-CORE-SW-2','HW-CORE-SW-2','switch','核心区',NULL,NULL),(3,'HW-CORE-FW-1','HW-CORE-FW-1','firewall','核心区',NULL,NULL),(4,'HW-CORE-FW-2','HW-CORE-FW-2','firewall','核心区',NULL,NULL),(5,'HW-WAN-HQ-RT-1','HW-WAN-HQ-RT-1','router','上联子区',NULL,NULL),(6,'HW-WAN-HQ-RT-2','HW-WAN-HQ-RT-2','router','上联子区',NULL,NULL),(7,'WH-EXT-RT-1','WH-EXT-RT-1','router','外联区',NULL,NULL),(8,'WH-EXT-RT-2','WH-EXT-RT-2','router','外联区',NULL,NULL),(9,'WH-EXT-SW-1','WH-EXT-SW-1','switch','外联区',NULL,NULL),(10,'WH-EXT-SW-2','WH-EXT-SW-2','switch','外联区',NULL,NULL),(11,'WH-EXT-FW-1','WH-EXT-FW-1','firewall','外联区',NULL,NULL),(12,'WH-EXT-FW-2','WH-EXT-FW-2','firewall','外联区',NULL,NULL),(13,'WH-SC-SERVER-DL-1','WH-SC-SERVER-DL-1','switch',NULL,NULL,NULL),(14,'WH-SC-SERVER-DL-2','WH-SC-SERVER-DL-2','switch',NULL,NULL,NULL),(15,'WH-OA-SERVER-DL-1','WH-OA-SERVER-DL-1','switch',NULL,NULL,NULL),(16,'WH-OA-SERVER-DL-2','WH-OA-SERVER-DL-2','switch',NULL,NULL,NULL),(17,'WH-ADMIN-DL-1','WH-ADMIN-DL-1','switch',NULL,NULL,NULL),(18,'WH-ADMIN-DL-2','WH-ADMIN-DL-2','switch',NULL,NULL,NULL),(19,'WH-OAUSER-DL-1','WH-OAUSER-DL-1','switch','办公用户区',NULL,NULL),(20,'WH-OAUSER-DL-2','WH-OAUSER-DL-2','switch','办公用户区',NULL,NULL),(21,'WH-APPUSER-DL-1','WH-APPUSER-DL-1','switch','办公用户区',NULL,NULL),(22,'WH-APPUSER-DL-2','WH-APPUSER-DL-2','switch','办公用户区',NULL,NULL),(23,'WHIDC-TEST-DL-SW-1','WHIDC-TEST-DL-SW-1','switch','测试环境',NULL,NULL),(24,'WHIDC-TEST-DL-SW-2','WHIDC-TEST-DL-SW-2','switch','测试环境',NULL,NULL),(25,'WHIDC-DMZ-DL-SW-1','WHIDC-DMZ-DL-SW-1','switch','DMZ区',NULL,NULL),(26,'WHIDC-DMZ-DL-SW-2','WHIDC-DMZ-DL-SW-2','switch','DMZ区',NULL,NULL),(27,'WH-YYB-SW-1','WH-YYB-SW-1','switch','营业部',NULL,NULL),(28,'WH-YYB-SW-2','WH-YYB-SW-2','switch','营业部',NULL,NULL),(29,'WH-BRANCONN-RT-1','WH-BRANCONN-RT-1','router','下联子区',NULL,NULL),(30,'WH-BRANCONN-RT-2','WH-BRANCONN-RT-2','router','下联子区',NULL,NULL),(31,'WH-BRANCONN-RT-3','WH-BRANCONN-RT-3','router','下联子区',NULL,NULL),(32,'WH-ZB-SW-1','WH-ZB-SW-1','switch','灾备中心',NULL,NULL),(33,'WH-ZB-SW-2','WH-ZB-SW-2','switch','灾备中心',NULL,NULL),(34,'3G-FW-1','3G-FW-1','firewall','灾备中心',NULL,NULL),(35,'3G-FW-2','3G-FW-2','firewall','灾备中心',NULL,NULL),(36,'EXI-FW','EXI-FW','firewall','灾备中心',NULL,NULL),(37,'3G-SW-1','3G-SW-1','switch','灾备中心',NULL,NULL),(38,'3G-SW-2','3G-SW-2','switch','灾备中心',NULL,NULL),(39,'EXI-SW','EXI-SW','switch','灾备中心',NULL,NULL),(40,'3G-RT-1','3G-RT-1','router','灾备中心',NULL,NULL),(41,'3G-RT-2','3G-RT-2','router','灾备中心',NULL,NULL),(42,'EXI-RT','EXI-RT','router','灾备中心',NULL,NULL),(43,'WH-ZB-SL-RT-1','WH-ZB-SL-RT-1','router',NULL,NULL,NULL),(44,'WH-ZB-SL-RT-2','WH-ZB-SL-RT-2','router',NULL,NULL,NULL),(45,'WH-ZB-SL-RT-3','WH-ZB-SL-RT-3','router',NULL,NULL,NULL);
/*!40000 ALTER TABLE `network_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `node` (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '节点唯一ID，必须是唯一的字符串',
  `x` double DEFAULT NULL COMMENT 'x坐标',
  `y` double DEFAULT NULL COMMENT 'y坐标',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'circle' COMMENT '指定节点类型，内置节点类型名称或自定义节点的名称。默认为 "circle"',
  `size` double DEFAULT NULL COMMENT '节点的大小',
  `anchorPoints` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '指定边连入节点的连接点的位置（相对于该节点而言），可以为空',
  `style` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '节点的样式属性',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文本文字',
  `labelCfg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '文本配置项',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-27  9:46:32
