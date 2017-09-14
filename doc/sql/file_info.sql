/*
Navicat MySQL Data Transfer

Source Server         : oss
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : oss

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-09-14 17:46:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL DEFAULT 'default' COMMENT '文件名',
  `md5` varchar(64) NOT NULL COMMENT '文件MD5值',
  `suffix` varchar(10) NOT NULL COMMENT '文件后缀',
  `size` bigint(20) NOT NULL COMMENT '文件大小',
  `preview` varchar(1024) NOT NULL COMMENT '文件下载路径',
  `min_md5` varchar(64) NOT NULL COMMENT '文件缩略图MD5值',
  `min_preview` varchar(1024) NOT NULL COMMENT '文件缩略图下载路径',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_md5` (`md5`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件信息表';
