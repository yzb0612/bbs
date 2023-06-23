/*
Navicat MySQL Data Transfer

Source Server         : testconn
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2023-06-23 17:22:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `account_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `bio` varchar(256) DEFAULT NULL,
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `gmt_create` bigint DEFAULT NULL,
  `gmt_modified` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, 'null', null, '33abb137-9fdc-4182-a1c1-b12f986fb850', '1687337835558', '1687337835558');
INSERT INTO `user` VALUES ('2', null, 'null', null, '6e51712b-91f1-4f72-a311-9f6862775e48', '1687337934540', '1687337934540');
INSERT INTO `user` VALUES ('3', 'aibo', '121016178', null, '61167c13-e7e8-4d25-a408-596043783494', '1687509071791', '1687509071791');
