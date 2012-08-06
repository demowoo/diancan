/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50148
Source Host           : localhost:3306
Source Database       : diancan

Target Server Type    : MYSQL
Target Server Version : 50148
File Encoding         : 65001

Date: 2012-08-06 09:07:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dayorder`
-- ----------------------------
DROP TABLE IF EXISTS `dayorder`;
CREATE TABLE `dayorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open` bit(1) DEFAULT NULL,
  `restId` int(11) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dayorder
-- ----------------------------
