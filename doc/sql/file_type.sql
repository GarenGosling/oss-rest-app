/*
Navicat MySQL Data Transfer

Source Server         : oss
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : oss

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-09-15 12:27:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file_type
-- ----------------------------
DROP TABLE IF EXISTS `file_type`;
CREATE TABLE `file_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
  `code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '编码',
  `type` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '分类，image、video、doc等',
  `max_size` int(11) NOT NULL COMMENT '最大允许的文件大小',
  `available` tinyint(1) NOT NULL COMMENT '是否使用',
  `operator_code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '操作人编码',
  `operator_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '操作人姓名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_name` (`name`) USING HASH,
  UNIQUE KEY `unique_code` (`code`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='文件类型表';
