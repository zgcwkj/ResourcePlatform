/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.53 : Database - resourceplatform
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`resourceplatform` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `resourceplatform`;

/*Table structure for table `bigallery` */

DROP TABLE IF EXISTS `bigallery`;

CREATE TABLE `bigallery` (
  `galleryid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图库ID',
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `galleryname` text NOT NULL COMMENT '图库名称',
  `isprivate` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否私有',
  PRIMARY KEY (`galleryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bigallery` */

/*Table structure for table `biimage` */

DROP TABLE IF EXISTS `biimage`;

CREATE TABLE `biimage` (
  `imageid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片ID',
  `galleryid` int(11) NOT NULL COMMENT '图库ID',
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `imagename` text NOT NULL COMMENT '图片名称',
  `imageremark` text NOT NULL COMMENT '图片备注',
  `uploadtime` datetime NOT NULL COMMENT '上传时间',
  `path` text NOT NULL COMMENT '图片路径',
  `isprivate` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否私有',
  PRIMARY KEY (`imageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `biimage` */

/*Table structure for table `biimagetag` */

DROP TABLE IF EXISTS `biimagetag`;

CREATE TABLE `biimagetag` (
  `imagetagid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片标签ID',
  `imageid` int(11) NOT NULL COMMENT '图片ID',
  `tagid` int(11) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`imagetagid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `biimagetag` */

/*Table structure for table `btag` */

DROP TABLE IF EXISTS `btag`;

CREATE TABLE `btag` (
  `tagid` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tagname` text NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`tagid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `btag` */

/*Table structure for table `buser` */

DROP TABLE IF EXISTS `buser`;

CREATE TABLE `buser` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `roleid` text NOT NULL COMMENT '角色ID',
  `accounts` text NOT NULL COMMENT '用户账号',
  `password` text NOT NULL COMMENT '用户密码',
  `name` text NOT NULL COMMENT '用户名称',
  `mail` text NOT NULL COMMENT '用户邮箱',
  `phone` text NOT NULL COMMENT '用户手机号',
  `address` text NOT NULL COMMENT '用户地址',
  `registrartime` datetime NOT NULL COMMENT '用户注册时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `buser` */

/*Table structure for table `sconfig` */

DROP TABLE IF EXISTS `sconfig`;

CREATE TABLE `sconfig` (
  `configid` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置ID',
  `configname` text NOT NULL COMMENT '配置名称',
  `configinfo` text NOT NULL COMMENT '配置信息',
  PRIMARY KEY (`configid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sconfig` */

/*Table structure for table `slog` */

DROP TABLE IF EXISTS `slog`;

CREATE TABLE `slog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `url` text NOT NULL COMMENT '地址',
  `parameter` text NOT NULL COMMENT '参数',
  `operattime` datetime NOT NULL COMMENT '时间',
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slog` */

/*Table structure for table `smenu` */

DROP TABLE IF EXISTS `smenu`;

CREATE TABLE `smenu` (
  `menuid` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `parentid` int(11) NOT NULL COMMENT '父ID',
  `menuname` text NOT NULL COMMENT '菜单名称',
  `icon` text NOT NULL COMMENT '图标Url',
  `url` text NOT NULL COMMENT '链接Url',
  `sort` text NOT NULL COMMENT '排序',
  `behavior` text NOT NULL COMMENT '行为',
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `smenu` */

insert  into `smenu`(`menuid`,`parentid`,`menuname`,`icon`,`url`,`sort`,`behavior`) values (1,0,'系统设置','fa fa-gear','','999','show'),(2,1,'用户管理','fa fa-user','/admin/suser','1','index,inquire,insert,update,delete,print'),(3,1,'角色管理','fa fa-users','/admin/srole','2','index,inquire,insert,update,delete,print'),(4,1,'程序配置','fa fa-gear','/admin/sconfig','3','index,inquire,insert,update,delete,print'),(5,1,'系统日志','fa fa-leaf','/admin/slog','4','index,inquire,delete,print');

/*Table structure for table `srole` */

DROP TABLE IF EXISTS `srole`;

CREATE TABLE `srole` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `rolename` text NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `srole` */

insert  into `srole`(`roleid`,`rolename`) values (1,'超级管理员'),(2,'普通管理员');

/*Table structure for table `sroledetail` */

DROP TABLE IF EXISTS `sroledetail`;

CREATE TABLE `sroledetail` (
  `roledetailid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色明细ID',
  `roleid` int(11) NOT NULL COMMENT '角色ID',
  `menuid` int(11) NOT NULL COMMENT '菜单ID',
  `behavior` text NOT NULL COMMENT '行为',
  PRIMARY KEY (`roledetailid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sroledetail` */

insert  into `sroledetail`(`roledetailid`,`roleid`,`menuid`,`behavior`) values (1,1,1,'show'),(2,1,2,'index,inquire,insert,update,delete,print'),(3,1,3,'index,inquire,insert,update,delete,print'),(4,1,4,'index,inquire,insert,update,delete,print'),(5,1,5,'index,inquire,delete,print');

/*Table structure for table `suser` */

DROP TABLE IF EXISTS `suser`;

CREATE TABLE `suser` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `roleid` text NOT NULL COMMENT '角色ID',
  `accounts` text NOT NULL COMMENT '用户账号',
  `password` text NOT NULL COMMENT '用户密码',
  `name` text NOT NULL COMMENT '用户名称',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `suser` */

insert  into `suser`(`userid`,`roleid`,`accounts`,`password`,`name`) values (1,'1','admin','21232f297a57a5a743894a0e4a801fc3','Admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
