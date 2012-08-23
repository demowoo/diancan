/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50148
Source Host           : localhost:3306
Source Database       : diancan

Target Server Type    : MYSQL
Target Server Version : 50148
File Encoding         : 65001

Date: 2012-08-23 14:56:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `restId` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `taste_grading` tinyint(4) DEFAULT NULL,
  `hot` bit(1) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `can_order` bit(1) DEFAULT NULL,
  `order_day_start` bigint(20) DEFAULT NULL,
  `order_day_end` bigint(20) DEFAULT NULL,
  `order_day_week` varchar(255) DEFAULT NULL,
  `book_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
