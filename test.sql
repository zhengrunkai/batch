/*
 Navicat MySQL Data Transfer

 Source Server         : mylocal
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 05/04/2022 10:17:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` bigint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, '老大', 10000);
INSERT INTO `person` VALUES (2, '老二', 20000);
INSERT INTO `person` VALUES (3, '老三', 30000);

SET FOREIGN_KEY_CHECKS = 1;
