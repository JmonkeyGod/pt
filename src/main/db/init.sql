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

/*Data for the table `t_event_handle` */

/*Data for the table `t_event_regional` */

insert  into `t_event_regional`(`id`,`regionId`,`eventType`,`eventCounts`,`date`) values 
(1,'025','A',35,20180410),
(2,'025','B',36,20180410),
(3,'025','A',50,20180409),
(4,'025','B',66,20180406),
(5,'0513','A',67,20180411);

/*Data for the table `t_event_summary` */

insert  into `t_event_summary`(`date`,`stCounts`,`svCounts`) values 
(20180408,135,11),
(20180409,99,33),
(20180410,45,60),
(20180411,35,40);

/*Data for the table `t_event_terminal` */

insert  into `t_event_terminal`(`id`,`mdn`,`cmap`,`mm`,`sm`,`cm`,`updateTime`) values 
(1,'15852915090',272,278,264,223,'2018-04-12 09:40:13'),
(2,'15852915089',200,325,145,321,'2018-04-11 09:35:35'),
(3,'15852915090',100,150,160,NULL,'2018-04-11 09:40:13');

/*Data for the table `t_mdn_behavor` */

/*Data for the table `t_mdn_monitor` */

/*Data for the table `t_mdn_statistic` */

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

/*Data for the table `t_report_case` */

/*Data for the table `t_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
