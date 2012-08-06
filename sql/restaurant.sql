/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50148
Source Host           : localhost:3306
Source Database       : diancan

Target Server Type    : MYSQL
Target Server Version : 50148
File Encoding         : 65001

Date: 2012-08-06 09:07:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `restaurant`
-- ----------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `ser_grading` tinyint(4) DEFAULT NULL,
  `pri_grading` tinyint(4) DEFAULT NULL,
  `taste_grading` tinyint(4) DEFAULT NULL,
  `can_order` bit(1) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of restaurant
-- ----------------------------
INSERT INTO `restaurant` VALUES ('1', null, null, null, null, null, null, null, null, null);
INSERT INTO `restaurant` VALUES ('2', null, null, null, null, null, null, null, null, null);
INSERT INTO `restaurant` VALUES ('3', null, null, null, null, null, null, null, null, null);
INSERT INTO `restaurant` VALUES ('4', '凤飞飞', 'efefe', 'geggg', '21123123', '0', '0', '0', '', '1344071790568');
