/*数据库开始*/
CREATE DATABASE `resourceplatform`;
USE `resourceplatform`;

/*表开始*/
DROP TABLE IF EXISTS `sconfig`;
CREATE TABLE `sconfig` (
`configid` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置ID',
`configname` text NOT NULL COMMENT '配置名称',
`configinfo` text NOT NULL COMMENT '配置信息',
PRIMARY KEY (`configid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `smenu`;
CREATE TABLE `smenu` (
`menuid` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
`parentid` int(11) NOT NULL COMMENT '父ID',
`menuname` text NOT NULL COMMENT '菜单名称',
`icon` text NOT NULL COMMENT '图标Url',
`url` text NOT NULL COMMENT '链接Url',
`sort` text NOT NULL COMMENT '排序',
`behavior` text NOT NULL COMMENT '行为',
PRIMARY KEY (`menuid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `suser`;
CREATE TABLE `suser` (
`userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`roleid` text NOT NULL COMMENT '角色ID',
`accounts` text NOT NULL COMMENT '用户账号',
`password` text NOT NULL COMMENT '用户密码',
`name` text NOT NULL COMMENT '用户名称',
PRIMARY KEY (`userid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `srole`;
CREATE TABLE `srole` (
`roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
`rolename` text NOT NULL COMMENT '角色名称',
PRIMARY KEY (`roleid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `sroledetail`;
CREATE TABLE `sroledetail` (
`roledetailid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色明细ID',
`roleid` int(11) NOT NULL COMMENT '角色ID',
`behavior` text NOT NULL COMMENT '行为',
PRIMARY KEY (`roledetailid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `slog`;
CREATE TABLE `slog` (
`logid` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
`url` text NOT NULL COMMENT '地址',
`parameter` text NOT NULL COMMENT '参数',
`operattime` datetime NOT NULL COMMENT'时间',
PRIMARY KEY (`logid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
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
`registrartime` datetime NOT NULL COMMENT'用户注册时间',
PRIMARY KEY (`userid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `btag`;
CREATE TABLE `btag` (
`tagid` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
`tagname` text NOT NULL COMMENT '标签名称',
PRIMARY KEY (`tagid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `bigallery`;
CREATE TABLE `bigallery` (
`galleryid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图库ID',
`userid` int(11) NOT NULL COMMENT '用户ID',
`galleryname` text NOT NULL COMMENT '图库名称',
`isprivate` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否私有',
PRIMARY KEY (`galleryid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `biimage`;
CREATE TABLE `biimage` (
`imageid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片ID',
`galleryid` int(11) NOT NULL COMMENT '图库ID',
`userid` int(11) NOT NULL COMMENT '用户ID',
`imagename` text NOT NULL COMMENT '图片名称',
`imageremark` text NOT NULL COMMENT '图片备注',
`uploadtime` datetime NOT NULL COMMENT'上传时间',
`path` text NOT NULL COMMENT '图片路径',
`isprivate` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否私有',
PRIMARY KEY (`imageid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*表开始*/
DROP TABLE IF EXISTS `biimagetag`;
CREATE TABLE `biimagetag` (
`imagetagid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片标签ID',
`imageid` int(11) NOT NULL COMMENT '图片ID',
`tagid` int(11) NOT NULL COMMENT '标签ID',
PRIMARY KEY (`imagetagid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
