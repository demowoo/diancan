/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50148
Source Host           : localhost:3306
Source Database       : diancan

Target Server Type    : MYSQL
Target Server Version : 50148
File Encoding         : 65001

Date: 2012-08-23 14:56:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `restId` int(11) DEFAULT NULL,
  `foodId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `dayOrderId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `foodName` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
