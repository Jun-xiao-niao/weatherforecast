/*
 Navicat Premium Data Transfer

 Source Server         : junxiaoniao
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : weather_report

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 18/01/2022 11:19:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int NOT NULL COMMENT '城市ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '城市名',
  `lon` varchar(255) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '城市经度',
  `lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (101010100, '北京', '116.40528', '39.90498');
INSERT INTO `city` VALUES (101020100, '上海', '121.47264', '31.23170');
INSERT INTO `city` VALUES (101230101, '福州', '119.30623', '26.07530');

-- ----------------------------
-- Table structure for weather
-- ----------------------------
DROP TABLE IF EXISTS `weather`;
CREATE TABLE `weather`  (
  `id` int NOT NULL COMMENT '城市ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '城市名',
  `fxData` varchar(255) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '当日日期',
  `tempMax` varchar(255) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '当日最高气温',
  `tempMin` varchar(255) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '当日最低气温',
  `textDay` varchar(255) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '白天天气情况',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of weather
-- ----------------------------
INSERT INTO `weather` VALUES (100, '北京', '2022-01-18', '3', '-7', '晴');
INSERT INTO `weather` VALUES (101, '北京', '2022-01-19', '0', '-8', '多云');
INSERT INTO `weather` VALUES (102, '北京', '2022-01-20', '0', '-7', '多云');
INSERT INTO `weather` VALUES (200, '上海', '2022-01-18', '11', '5', '晴');
INSERT INTO `weather` VALUES (201, '上海', '2022-01-19', '14', '5', '多云');
INSERT INTO `weather` VALUES (202, '上海', '2022-01-20', '10', '4', '多云');
INSERT INTO `weather` VALUES (300, '福州', '2022-01-18', '13', '11', '小雨');
INSERT INTO `weather` VALUES (301, '福州', '2022-01-19', '18', '11', '多云');
INSERT INTO `weather` VALUES (302, '福州', '2022-01-20', '16', '11', '阴');

SET FOREIGN_KEY_CHECKS = 1;
