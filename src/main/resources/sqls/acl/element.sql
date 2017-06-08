/*
Navicat MySQL Data Transfer

Source Server         : 165
Source Server Version : 50718
Source Host           : ngrok.irskj.com:62952
Source Database       : chemistry

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-09 00:04:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `element`
-- ----------------------------
DROP TABLE IF EXISTS `element`;
CREATE TABLE `element` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '中文名称',
  `c_name_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '英文名称',
  `c_symbol` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '符号',
  `c_atom` int(11) DEFAULT NULL COMMENT '原子',
  `c_sn` int(11) DEFAULT NULL COMMENT '序号',
  `c_ram` double DEFAULT NULL COMMENT '相对原子质量',
  `j_ar` double DEFAULT NULL COMMENT '原子半径',
  `j_atomic_volume` double DEFAULT NULL COMMENT '原子体积',
  `j_covalent_radius` double DEFAULT NULL COMMENT '共价半径',
  `j_electronic_configuration` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电子构型',
  `j_ion_radius` double DEFAULT NULL COMMENT '离子半径',
  `j_oxidation_state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '氧化态',
  `c_find` text COLLATE utf8_unicode_ci COMMENT '发现',
  `c_source` text COLLATE utf8_unicode_ci COMMENT '来源',
  `c_use` text COLLATE utf8_unicode_ci COMMENT '用途',
  `p_status` text COLLATE utf8_unicode_ci COMMENT '状态',
  `p_melting_point` double DEFAULT NULL COMMENT '熔点',
  `p_boiling_point` double DEFAULT NULL COMMENT '沸点',
  `p_density` double DEFAULT NULL COMMENT '密度',
  `p_spontaneous_point` double DEFAULT NULL COMMENT '自燃点',
  `p_specific_heat` double DEFAULT NULL COMMENT '比热',
  `p_evaporative_heat` double DEFAULT NULL COMMENT '蒸发热',
  `p_heat_of_melting` double DEFAULT NULL COMMENT '熔化热',
  `p_flash_point` double DEFAULT NULL COMMENT '闪点',
  `p_conductivity` double DEFAULT NULL COMMENT '导电率',
  `p_thermal_conductivity` double DEFAULT NULL COMMENT '导热系数',
  `c_electronic_model` text COLLATE utf8_unicode_ci COMMENT '电子模型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of element
-- ----------------------------
INSERT INTO `element` VALUES ('1', '测试', 'test', 'h', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `element` VALUES ('2', '答复', 'ddd', 'h2o', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
