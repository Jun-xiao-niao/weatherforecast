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

 Date: 18/01/2022 11:24:03
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
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (101020100, '上海', '121.47264', '31.23170');
INSERT INTO `city` VALUES (101010100, '北京', '116.40528', '39.90498');
INSERT INTO `city` VALUES (101230101, '福州', '119.30623', '26.07530');

SET FOREIGN_KEY_CHECKS = 1;
