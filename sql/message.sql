/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50148
Source Host           : localhost:3306
Source Database       : diancan

Target Server Type    : MYSQL
Target Server Version : 50148
File Encoding         : 65001

Date: 2012-08-06 09:07:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sendId` int(11) DEFAULT NULL,
  `recvId` int(11) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `isRead` bit(1) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
