/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 10.2.11-MariaDB : Database - pt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pt`;

/*Table structure for table `t_event_handle` */

DROP TABLE IF EXISTS `t_event_handle`;

CREATE TABLE `t_event_handle` (
  `date` int(8) NOT NULL COMMENT '日期',
  `confirmCounts` int(8) DEFAULT NULL COMMENT '事件确认次数',
  `handleCounts` int(8) DEFAULT NULL COMMENT '事件处理次数',
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_event_handle` */

/*Table structure for table `t_event_regional` */

DROP TABLE IF EXISTS `t_event_regional`;

CREATE TABLE `t_event_regional` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `regionId` char(6) DEFAULT NULL COMMENT '区域编号',
  `eventType` char(2) DEFAULT NULL COMMENT '事件类型',
  `eventCounts` int(8) DEFAULT NULL COMMENT '事件发生次数',
  `date` int(8) DEFAULT NULL COMMENT '事件发生日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_event_regional` */

insert  into `t_event_regional`(`id`,`regionId`,`eventType`,`eventCounts`,`date`) values 
(1,'025','A',35,20180410),
(2,'025','B',36,20180410),
(3,'025','A',50,20180409),
(4,'025','B',66,20180406),
(5,'0513','A',67,20180411);

/*Table structure for table `t_event_summary` */

DROP TABLE IF EXISTS `t_event_summary`;

CREATE TABLE `t_event_summary` (
  `date` int(8) NOT NULL COMMENT '日期',
  `stCounts` int(8) DEFAULT NULL COMMENT '疑似欺诈次数',
  `svCounts` int(8) DEFAULT NULL COMMENT '疑似受害次数',
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_event_summary` */

insert  into `t_event_summary`(`date`,`stCounts`,`svCounts`) values 
(20180408,135,11),
(20180409,99,33),
(20180410,45,60),
(20180411,35,40);

/*Table structure for table `t_event_terminal` */

DROP TABLE IF EXISTS `t_event_terminal`;

CREATE TABLE `t_event_terminal` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `mdn` char(16) DEFAULT NULL COMMENT '用户号码',
  `cmap` int(8) DEFAULT NULL COMMENT 'CMAP 漫游切换 数量',
  `mm` int(8) DEFAULT NULL COMMENT 'MM 位置更新 数量',
  `sm` int(8) DEFAULT NULL COMMENT 'SM 短信 数量',
  `cm` int(8) DEFAULT NULL COMMENT 'CM  通话 数量',
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间，默认值为当前时间',
  PRIMARY KEY (`id`),
  KEY `ET_MDN` (`mdn`) COMMENT '用户号码'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_event_terminal` */

insert  into `t_event_terminal`(`id`,`mdn`,`cmap`,`mm`,`sm`,`cm`,`updateTime`) values 
(1,'15852915090',272,278,264,223,'2018-04-12 09:40:13'),
(2,'15852915089',200,325,145,321,'2018-04-11 09:35:35'),
(3,'15852915090',100,150,160,NULL,'2018-04-11 09:40:13');

/*Table structure for table `t_mdn_behavor` */

DROP TABLE IF EXISTS `t_mdn_behavor`;

CREATE TABLE `t_mdn_behavor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mdn` char(14) DEFAULT NULL COMMENT '疑似号码',
  `hcode` char(15) DEFAULT NULL COMMENT '归属地',
  `type` char(4) DEFAULT NULL COMMENT '异常类型',
  `counts` int(11) DEFAULT NULL COMMENT '异常量',
  `status` int(2) DEFAULT NULL COMMENT '处理状态',
  `startTime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '发生时间',
  `caseTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '报案时间',
  `operation` char(2) DEFAULT NULL COMMENT '操作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_mdn_behavor` */

/*Table structure for table `t_mdn_monitor` */

DROP TABLE IF EXISTS `t_mdn_monitor`;

CREATE TABLE `t_mdn_monitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '识别时间',
  `mdn` char(14) DEFAULT NULL COMMENT '疑似号码',
  `imei` char(20) DEFAULT NULL COMMENT '终端串号',
  `terminalType` char(20) DEFAULT NULL COMMENT '终端类型',
  `sourceType` char(20) DEFAULT NULL COMMENT '识别源',
  `sourceArea` char(20) DEFAULT NULL COMMENT '识别地点',
  `hcode` char(15) DEFAULT NULL COMMENT '归属地',
  `note` char(40) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_mdn_monitor` */

/*Table structure for table `t_mdn_suspstats` */

DROP TABLE IF EXISTS `t_mdn_suspstats`;

CREATE TABLE `t_mdn_suspstats` (
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '识别时间',
  `mdn` varchar(14) NOT NULL COMMENT '疑似号码',
  `sourceType` varchar(20) DEFAULT NULL COMMENT '识别源',
  `sourceArea` varchar(20) DEFAULT NULL COMMENT '识别地点',
  `baseId` varchar(15) DEFAULT NULL COMMENT '归属地',
  `lastUpdateDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最近活跃时间',
  `activeness` int(11) DEFAULT NULL COMMENT '活跃度',
  `note` char(40) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`time`,`mdn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_mdn_suspstats` */

/*Table structure for table `t_region_info` */

DROP TABLE IF EXISTS `t_region_info`;

CREATE TABLE `t_region_info` (
  `regionId` char(4) NOT NULL COMMENT '区域编号',
  `regionName` char(16) DEFAULT NULL COMMENT '区域名称',
  PRIMARY KEY (`regionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_region_info` */

insert  into `t_region_info`(`regionId`,`regionName`) values 
('025','南京'),
('0510','无锡'),
('0511','镇江'),
('0512','苏州'),
('0513','南通'),
('0514','扬州'),
('0515','盐城'),
('0516','徐州'),
('0517','淮安'),
('0518','连云港'),
('0519','常州'),
('0523','泰州');

/*Table structure for table `t_report_case` */

DROP TABLE IF EXISTS `t_report_case`;

CREATE TABLE `t_report_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fraudMdn` char(14) DEFAULT NULL COMMENT '诈骗号码：07318893112',
  `fraudedMdn` char(14) DEFAULT NULL COMMENT '被骗用户：1893696364',
  `type` char(2) DEFAULT NULL COMMENT '诈骗类型：冒充银行',
  `occurTime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '发生时间： 2018-03-23',
  `reportTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '报案时间：2018-03-23',
  `loss` double DEFAULT NULL COMMENT '受骗金额：19000',
  `result` tinyint(1) DEFAULT NULL COMMENT '是否被骗：是',
  `callType` char(2) DEFAULT NULL COMMENT '主叫/被叫：主叫',
  `description` char(100) DEFAULT NULL COMMENT '诈骗过程描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_report_case` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `userId` char(16) DEFAULT NULL COMMENT '用户编号',
  `userName` char(32) DEFAULT NULL COMMENT '用户名',
  `password` char(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

/*Table structure for table `t_user_circle` */

DROP TABLE IF EXISTS `t_user_circle`;

CREATE TABLE `t_user_circle` (
  `mdn` varchar(16) NOT NULL COMMENT '用户号码',
  `time` varchar(14) NOT NULL COMMENT '时间',
  `cityCode` varchar(10) DEFAULT NULL COMMENT '城市编码',
  `note` varchar(60) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`mdn`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_circle` */

/*Table structure for table `t_user_commqty` */

DROP TABLE IF EXISTS `t_user_commqty`;

CREATE TABLE `t_user_commqty` (
  `mdn` varchar(16) NOT NULL COMMENT '用户号码',
  `date` varchar(12) NOT NULL COMMENT '日期',
  `callingNum` int(11) DEFAULT NULL COMMENT '主叫数量',
  `calledNum` int(11) DEFAULT NULL COMMENT '被叫数量',
  `mailingNum` int(11) DEFAULT NULL COMMENT '短信发数量',
  `mailedNum` int(11) DEFAULT NULL COMMENT '短信收数量',
  `note` varchar(60) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`mdn`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_commqty` */

/*Table structure for table `t_user_feature` */

DROP TABLE IF EXISTS `t_user_feature`;

CREATE TABLE `t_user_feature` (
  `mdn` varchar(16) DEFAULT NULL COMMENT '用户号码',
  `date` varchar(12) DEFAULT NULL COMMENT '日期',
  `balance` float DEFAULT NULL COMMENT '平衡性',
  `activeness` float DEFAULT NULL COMMENT '活跃度',
  `stability` float DEFAULT NULL COMMENT '稳定性',
  `socialCircle` float DEFAULT NULL COMMENT '交际圈',
  `baseId` varchar(12) DEFAULT NULL COMMENT '归属地',
  `permArea` varchar(12) DEFAULT NULL COMMENT '常驻地',
  `aperiod` varchar(12) DEFAULT NULL COMMENT '活跃时段',
  `croams` int(11) DEFAULT NULL COMMENT '市际漫游个数',
  `croamDu` int(11) DEFAULT NULL COMMENT '市际漫游时长',
  `proams` int(11) DEFAULT NULL COMMENT '省际漫游个数',
  `proamDu` int(11) DEFAULT NULL COMMENT '省际漫游时长'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_feature` */

/*Table structure for table `t_user_terminal` */

DROP TABLE IF EXISTS `t_user_terminal`;

CREATE TABLE `t_user_terminal` (
  `mdn` varchar(16) NOT NULL COMMENT '用户号码',
  `time` varchar(14) NOT NULL COMMENT '时间',
  `imei` varchar(16) DEFAULT NULL COMMENT '终端串号',
  `terminalType` varchar(20) DEFAULT NULL COMMENT '终端类型',
  `note` varchar(60) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`mdn`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_terminal` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
