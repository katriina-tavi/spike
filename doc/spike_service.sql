/*
 Navicat Premium Data Transfer

 Source Server         : 我的腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 81.68.248.166:3306
 Source Schema         : spike_service

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 14/09/2022 16:16:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_code` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '商品编码',
  `product_name` varchar(32) NOT NULL COMMENT '商品名称',
  `del_flag` char(1) CHARACTER SET utf8 DEFAULT '0' COMMENT '逻辑删除标记(0--正常 1--删除)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '创建人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product_info
-- ----------------------------
BEGIN;
INSERT INTO `product_info` VALUES (1, 'P000001', '洗衣机', '0', '2022-09-13 13:36:08', '0', '2022-09-13 13:36:08', '0', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
