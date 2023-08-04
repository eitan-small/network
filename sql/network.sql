/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL_MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : network

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 04/08/2023 18:22:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for combo
-- ----------------------------
DROP TABLE IF EXISTS `combo`;
CREATE TABLE `combo`  (
  `id` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL COMMENT '一个 Combo 的唯一标识，必须是 string 类型，必须唯一',
  `type` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT 'circle' COMMENT '指定该 Combo 的类型，可以是内置 Combo 的类型名，也可以是自定义 Combo 的类型名。默认是 \"circle\"',
  `parentId` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT '该 Combo 的父 Combo 的 ID',
  `size` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT 'Combo 的最小尺寸（非固定尺寸），默认 \"circle\" 类型 Combo 的 size 为 20，\"rect\" 类型的为 \"[20, 5]\"',
  `fixSize` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT '固定该 Combo 的尺寸，不指定时 Combo 大小由内部元素的分布和大小来决定。若指定了 fixSize 而没有指定 fixCollapseSize，则即使该 Combo 在收起状态下仍然保持 fixSize 指定的尺寸',
  `fixCollapseSize` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT '固定该 Combo 收起时的尺寸，不指定时，若未指定 fixSize 则由 size 决定收起时的尺寸，否则统一为 fixSize 尺寸',
  `padding` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT '该 Combo 内边距，默认 \"circle\" 类型 Combo 的 padding 为 \"[25, 25, 25, 25]\"，\"rect\" 类型的为 \"[25, 20, 15, 20]\"',
  `style` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL COMMENT '该 Combo 的样式配置项',
  `label` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT '该 Combo 的文本标签',
  `labelCfg` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL COMMENT '该 Combo 的文本标签样式配置项',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of combo
-- ----------------------------

-- ----------------------------
-- Table structure for device_connections
-- ----------------------------
DROP TABLE IF EXISTS `device_connections`;
CREATE TABLE `device_connections`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '连接ID，主键',
  `source_device_id` int NULL DEFAULT NULL COMMENT '源设备ID',
  `destination_device_id` int NULL DEFAULT NULL COMMENT '目标设备ID',
  `link_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链路类型，表示其是万兆光纤链路、千兆光纤链路、千兆铜缆链路',
  `source_interface_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '源设备接口名',
  `destination_interface_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '目标设备接口名',
  `created_at` datetime NULL DEFAULT NULL COMMENT '记录创建时间，在插入新连接记录时自动设置为当前时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '记录更新时间，在更新连接记录时自动更新为当前时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '设备连接信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_connections
-- ----------------------------
INSERT INTO `device_connections` VALUES (1, 1, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (2, 1, 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (3, 1, 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (4, 2, 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (5, 2, 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (6, 3, 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (7, 1, 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (8, 1, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (9, 2, 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (10, 2, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (11, 1, 11, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (12, 2, 12, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (13, 11, 9, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (14, 11, 12, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (15, 12, 10, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (16, 9, 10, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (17, 9, 7, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (18, 10, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (19, 7, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (20, 1, 13, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (21, 2, 14, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (22, 13, 14, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (23, 1, 15, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (24, 1, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (25, 15, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (26, 1, 17, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (27, 2, 18, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (28, 17, 18, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (29, 1, 19, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (30, 2, 20, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (31, 19, 20, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (32, 1, 21, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (33, 2, 22, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (34, 21, 22, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (35, 1, 23, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (36, 2, 24, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (37, 23, 24, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (38, 1, 29, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (39, 2, 29, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (40, 1, 30, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (41, 2, 30, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (42, 1, 31, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (43, 2, 31, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (44, 27, 29, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (45, 28, 30, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (46, 27, 28, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (47, 1, 25, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (48, 2, 26, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (49, 25, 26, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (50, 1, 32, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (51, 2, 33, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (52, 32, 33, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (53, 32, 34, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (54, 32, 36, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (55, 33, 35, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (56, 33, 36, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (57, 34, 35, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (58, 34, 37, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (59, 35, 38, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (60, 36, 39, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (61, 37, 38, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (62, 37, 40, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (63, 38, 41, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (64, 39, 42, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (65, 40, 41, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (66, 34, 43, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (67, 34, 44, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (68, 34, 45, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (69, 35, 44, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `device_connections` VALUES (70, 35, 45, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for edge
-- ----------------------------
DROP TABLE IF EXISTS `edge`;
CREATE TABLE `edge`  (
  `id` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL COMMENT '边唯一 ID，必须是唯一的字符串',
  `source` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL COMMENT '起始点 id',
  `target` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL COMMENT '结束点 id',
  `type` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT 'line' COMMENT '指定边的类型，可以是内置边的类型名称，也可以是自定义边的名称。默认为 \"line\"',
  `sourceAnchor` int NULL DEFAULT NULL COMMENT '边的起始节点上的锚点的索引值',
  `targetAnchor` int NULL DEFAULT NULL COMMENT '边的终止节点上的锚点的索引值',
  `style` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL COMMENT '边的样式属性',
  `label` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT '文本文字，如果没有则不会显示',
  `labelCfg` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL COMMENT '文本配置项',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edge
-- ----------------------------

-- ----------------------------
-- Table structure for network_devices
-- ----------------------------
DROP TABLE IF EXISTS `network_devices`;
CREATE TABLE `network_devices`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '设备ID，主键',
  `serial_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备序列号，唯一标识设备的字符串',
  `device_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备名称，简短地描述设备',
  `device_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备类型，表示设备的分类，比如路由器、交换机、防火墙等',
  `created_at` datetime NULL DEFAULT NULL COMMENT '记录创建时间，在插入新设备记录时自动设置为当前时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '记录更新时间，在更新设备记录时自动更新为当前时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '网络设备信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of network_devices
-- ----------------------------
INSERT INTO `network_devices` VALUES (1, 'HW-CORE-SW-1', 'HW-CORE-SW-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (2, 'HW-CORE-SW-2', 'HW-CORE-SW-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (3, 'HW-CORE-FW-1', 'HW-CORE-FW-1', '防火墙', NULL, NULL);
INSERT INTO `network_devices` VALUES (4, 'HW-CORE-FW-2', 'HW-CORE-FW-2', '防火墙', NULL, NULL);
INSERT INTO `network_devices` VALUES (5, 'HW-WAN-HQ-RT-1', 'HW-WAN-HQ-RT-1', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (6, 'HW-WAN-HQ-RT-2', 'HW-WAN-HQ-RT-2', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (7, 'WH-EXT-RT-1', 'WH-EXT-RT-1', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (8, 'WH-EXT-RT-2', 'WH-EXT-RT-2', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (9, 'WH-EXT-SW-1', 'WH-EXT-SW-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (10, 'WH-EXT-SW-2', 'WH-EXT-SW-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (11, 'WH-EXT-FW-1', 'WH-EXT-FW-1', '防火墙', NULL, NULL);
INSERT INTO `network_devices` VALUES (12, 'WH-EXT-FW-2', 'WH-EXT-FW-2', '防火墙', NULL, NULL);
INSERT INTO `network_devices` VALUES (13, 'WH-SC-SERVER-DL-1', 'WH-SC-SERVER-DL-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (14, 'WH-SC-SERVER-DL-2', 'WH-SC-SERVER-DL-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (15, 'WH-OA-SERVER-DL-1', 'WH-OA-SERVER-DL-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (16, 'WH-OA-SERVER-DL-2', 'WH-OA-SERVER-DL-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (17, 'WH-ADMIN-DL-1', 'WH-ADMIN-DL-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (18, 'WH-ADMIN-DL-2', 'WH-ADMIN-DL-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (19, 'WH-OAUSER-DL-1', 'WH-OAUSER-DL-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (20, 'WH-OAUSER-DL-2', 'WH-OAUSER-DL-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (21, 'WH-APPUSER-DL-1', 'WH-APPUSER-DL-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (22, 'WH-APPUSER-DL-2', 'WH-APPUSER-DL-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (23, 'WHIDC-TEST-DL-SW-1', 'WHIDC-TEST-DL-SW-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (24, 'WHIDC-TEST-DL-SW-2', 'WHIDC-TEST-DL-SW-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (25, 'WHIDC-DMZ-DL-SW-1', 'WHIDC-DMZ-DL-SW-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (26, 'WHIDC-DMZ-DL-SW-2', 'WHIDC-DMZ-DL-SW-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (27, 'WH-YYB-SW-1', 'WH-YYB-SW-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (28, 'WH-YYB-SW-2', 'WH-YYB-SW-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (29, 'WH-BRANCONN-RT-1', 'WH-BRANCONN-RT-1', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (30, 'WH-BRANCONN-RT-2', 'WH-BRANCONN-RT-2', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (31, 'WH-BRANCONN-RT-3', 'WH-BRANCONN-RT-3', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (32, 'WH-ZB-SW-1', 'WH-ZB-SW-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (33, 'WH-ZB-SW-2', 'WH-ZB-SW-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (34, '3G-FW-1', '3G-FW-1', '防火墙', NULL, NULL);
INSERT INTO `network_devices` VALUES (35, '3G-FW-2', '3G-FW-2', '防火墙', NULL, NULL);
INSERT INTO `network_devices` VALUES (36, 'EXI-FW', 'EXI-FW', '防火墙', NULL, NULL);
INSERT INTO `network_devices` VALUES (37, '3G-SW-1', '3G-SW-1', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (38, '3G-SW-2', '3G-SW-2', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (39, 'EXI-SW', 'EXI-SW', '交换机', NULL, NULL);
INSERT INTO `network_devices` VALUES (40, '3G-RT-1', '3G-RT-1', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (41, '3G-RT-2', '3G-RT-2', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (42, 'EXI-RT', 'EXI-RT', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (43, 'WH-ZB-SL-RT-1', 'WH-ZB-SL-RT-1', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (44, 'WH-ZB-SL-RT-2', 'WH-ZB-SL-RT-2', '路由器', NULL, NULL);
INSERT INTO `network_devices` VALUES (45, 'WH-ZB-SL-RT-3', 'WH-ZB-SL-RT-3', '路由器', NULL, NULL);

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node`  (
  `id` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL COMMENT '节点唯一ID，必须是唯一的字符串',
  `x` double NULL DEFAULT NULL COMMENT 'x坐标',
  `y` double NULL DEFAULT NULL COMMENT 'y坐标',
  `type` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT 'circle' COMMENT '指定节点类型，内置节点类型名称或自定义节点的名称。默认为 \"circle\"',
  `size` double NULL DEFAULT NULL COMMENT '节点的大小',
  `anchorPoints` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL COMMENT '指定边连入节点的连接点的位置（相对于该节点而言），可以为空',
  `style` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL COMMENT '节点的样式属性',
  `label` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL COMMENT '文本文字',
  `labelCfg` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL COMMENT '文本配置项',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
