# MySQL-Front 3.2  (Build 13.16)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;

/*!40101 SET NAMES latin1 */;
/*!40103 SET TIME_ZONE='SYSTEM' */;

# Host: localhost    Database: pm
# ------------------------------------------------------
# Server version 4.1.8-nt

DROP DATABASE IF EXISTS `pm`;
CREATE DATABASE `pm` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `pm`;

/*!40101 SET NAMES gbk */;

#
# Table structure for table accept_reports
#

CREATE TABLE `accept_reports` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `project_summarize` varchar(255) default NULL,
  `workload_plan` int(11) default NULL,
  `workload_fact` int(11) default NULL,
  `estimate_size` int(11) default NULL,
  `estimate_remark` varchar(255) default NULL,
  `risk1` varchar(255) default NULL,
  `risk2` varchar(255) default NULL,
  `risk3` varchar(255) default NULL,
  `experience` varchar(255) default NULL,
  `accept_commment` varchar(255) default NULL,
  `accept_by` varchar(255) default NULL,
  `accept_date` date default NULL,
  `accept_result` char(1) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table accept_reports
#


#
# Table structure for table constants
#

CREATE TABLE `constants` (
  `id` bigint(20) NOT NULL default '0',
  `constant_type` varchar(50) default NULL,
  `constant_label` varchar(200) default NULL,
  `constant_value` varchar(3) default NULL,
  `constant_order` int(11) default NULL,
  `property1` varchar(50) default NULL,
  `property2` varchar(50) default NULL,
  `property3` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table constants
#

INSERT INTO `constants` VALUES (1000,'ProjectStatus','��ʼ��','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1001,'ProjectStatus','������','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1002,'ProjectStatus','�ѽ���','003',3,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1003,'Sex','��','1',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1004,'Sex','Ů','0',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1005,'TargetStatus','��ʼ��','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1006,'TargetStatus','�ѷ���','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1007,'TargetStatus','�����','003',3,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1008,'TargetStatus','ȡ��','003',4,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1009,'ProductStatus','������','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1010,'ProductStatus','���ύ','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1011,'ProductStatus','����ͨ��','003',3,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1012,'ProductStatus','������ͨ��','004',4,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1013,'ProductUnit','ҳ','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1014,'ProductUnit','M','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1015,'RiskLevel','��','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1016,'RiskLevel','��','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1017,'RiskLevel','��','003',3,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1018,'RiskPro','��','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1019,'RiskPro','��','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1020,'RiskPro','��','003',3,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1021,'RiskStatus','δ����','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1022,'RiskStatus','�ѷ���','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1023,'ProblemStatus','�ر�','004',4,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1024,'ProblemStatus','�����','003',3,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1025,'ProblemStatus','�ѻ���','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1026,'ProblemStatus','������','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1027,'ProblemStatus','ȡ��','005',5,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1028,'ProblemLevel','*','001',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1029,'ProblemLevel','**','002',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1030,'ProblemLevel','***','003',3,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1031,'ProblemLevel','****','004',4,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1032,'ProblemLevel','*****','005',5,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1033,'ReportAccept','ͨ��','1',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1034,'ReportAccept','��ͨ��','0',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1035,'IsDeleted','��','0',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1036,'IsDeleted','��','1',2,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1037,'IsAdmin','��','0',1,NULL,NULL,NULL);
INSERT INTO `constants` VALUES (1038,'IsAdmin','��','1',2,NULL,NULL,NULL);

#
# Table structure for table example
#

CREATE TABLE `example` (
  `id` bigint(20) NOT NULL default '0',
  `column_2` date default NULL,
  `column_3` double default NULL,
  `column_4` text,
  `column_5` int(11) default NULL,
  `column_6` varchar(20) default NULL,
  `is_deleted` char(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table example
#


#
# Table structure for table payouts
#

CREATE TABLE `payouts` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `start_date` date default NULL,
  `end_date` date default NULL,
  `pay_plan` double default NULL,
  `pay_fact` double default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table payouts
#

INSERT INTO `payouts` VALUES (1000,1000,'2006-11-11','2006-12-12',1000,900,'��ʡ100Ԫ');
INSERT INTO `payouts` VALUES (1002,1000,'2006-12-15','2007-01-15',2500,3000,'�����Խ���');
INSERT INTO `payouts` VALUES (1003,1000,'2006-12-12','2007-01-17',100,300,'����');

#
# Table structure for table permissions
#

CREATE TABLE `permissions` (
  `id` bigint(20) NOT NULL default '0',
  `parent_id` bigint(20) default NULL,
  `permission_name` varchar(100) default NULL,
  `permission_level` int(11) default NULL,
  `permission_url` varchar(100) default NULL,
  `permission_order` int(10) default NULL,
  `image_name` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table permissions
#

INSERT INTO `permissions` VALUES (1000,0,'��ʼ����Ŀ',0,'projectListAction.do',1000,'0001.gif');
INSERT INTO `permissions` VALUES (1001,0,'�鿴��֯��Դ',0,'projectListAction.do',1001,'0002.gif');
INSERT INTO `permissions` VALUES (1002,0,'�鿴��Ŀ��չ',0,'projectListAction.do',1002,'0003.gif');
INSERT INTO `permissions` VALUES (10000,0,'��Ŀ�ſ�',1,'projectListAction.do',10000,'0004.gif');
INSERT INTO `permissions` VALUES (10100,10000,'��Ŀ��Ϣ',2,'projectInforPreAction.do',10100,'0005.gif');
INSERT INTO `permissions` VALUES (10101,10100,'������Ŀ��Ϣ',3,NULL,10101,NULL);
INSERT INTO `permissions` VALUES (10200,10000,'����������',2,'weekListAction.do',10200,'0006.gif');
INSERT INTO `permissions` VALUES (10201,10200,'�½�������',3,NULL,10201,NULL);
INSERT INTO `permissions` VALUES (10202,10200,'�༭������',3,NULL,10202,NULL);
INSERT INTO `permissions` VALUES (10203,10200,'ɾ��������',3,NULL,10203,NULL);
INSERT INTO `permissions` VALUES (10300,10000,'��Ŀ��Ա����',2,'teamModifyPreAction.do',10300,'0007.gif');
INSERT INTO `permissions` VALUES (20000,0,'��Ŀ�ƻ�',1,'projectListAction.do',20000,'0008.gif');
INSERT INTO `permissions` VALUES (20100,20000,'����ͼ',2,'gantt.do',20100,'0009.gif');
INSERT INTO `permissions` VALUES (20200,20000,'������Ϣ��ѯ',2,'targetSearchPreAction.do',20200,'0010.gif');
INSERT INTO `permissions` VALUES (20300,20000,'�ɱ�����',2,'payoutListAction.do',20300,'0011.gif');
INSERT INTO `permissions` VALUES (30000,0,'��Ŀ����',1,'projectListAction.do',30000,'0012.gif');
INSERT INTO `permissions` VALUES (30200,30000,'��д��Ŀ����',2,'projectReportListAction.do',30200,'0014.gif');
INSERT INTO `permissions` VALUES (30300,30000,'������Ʒ�б�',2,'productSearchPreAction.do',30300,'0015.gif');
INSERT INTO `permissions` VALUES (30400,30000,'�������ֲ�',2,'workloadPicPreAction.do',30400,'0016.gif');
INSERT INTO `permissions` VALUES (30600,30000,'�������ձ���',2,'acceptReportCreatePreAction.do',30600,'0018.gif');
INSERT INTO `permissions` VALUES (40000,0,'��������',1,'projectListAction.do',40000,'0019.gif');
INSERT INTO `permissions` VALUES (40100,40000,'�����б�',2,'riskListAction.do',40100,'0020.gif');
INSERT INTO `permissions` VALUES (40101,40100,'�½�����',3,NULL,40101,NULL);
INSERT INTO `permissions` VALUES (40102,40100,'�༭����',3,NULL,40102,NULL);
INSERT INTO `permissions` VALUES (40103,40100,'ɾ������',3,NULL,40103,NULL);
INSERT INTO `permissions` VALUES (40200,40000,'�����б�',2,'problemListAction.do',40200,'0021.gif');
INSERT INTO `permissions` VALUES (40201,40200,'�½�����',3,NULL,40201,NULL);
INSERT INTO `permissions` VALUES (40202,40200,'�༭�ѻ�������',3,NULL,40202,NULL);
INSERT INTO `permissions` VALUES (40203,40200,'ɾ���ѻ�������',3,NULL,40203,NULL);
INSERT INTO `permissions` VALUES (40204,40200,'��������',3,NULL,40204,NULL);
INSERT INTO `permissions` VALUES (40205,40200,'ɾ������������',3,NULL,40205,NULL);
INSERT INTO `permissions` VALUES (50000,0,'������Ϣ',1,'projectListAction.do',50000,'0022.gif');
INSERT INTO `permissions` VALUES (50100,50000,'�鿴����',2,'targetPersonPreAction.do',50100,'0023.gif');
INSERT INTO `permissions` VALUES (50200,50000,'��д�ܱ�',2,'targetListPreAction.do',50200,'0024.gif');
INSERT INTO `permissions` VALUES (60000,0,'��Ŀ����',1,'projectListAction.do',60000,'0025.gif');
INSERT INTO `permissions` VALUES (60100,60000,'�鿴���ձ���',2,'acceptReportViewAction.do',60100,'0026.gif');
INSERT INTO `permissions` VALUES (60200,60000,'�鿴��Ŀ����',2,'projectReportViewListAction.do',60200,'0027.gif');

#
# Table structure for table problems
#

CREATE TABLE `problems` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `submit_by_id` bigint(20) default NULL,
  `submit_date` date default NULL,
  `problem_description` varchar(255) default NULL,
  `problem_level` varchar(3) default NULL,
  `correct_measure` varchar(255) default NULL,
  `solve_by_id` bigint(20) default NULL,
  `validate_by_id` bigint(20) default NULL,
  `status` varchar(3) default NULL,
  `close_date` date default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`),
  KEY `submit_by_id` (`submit_by_id`),
  KEY `solve_by_id` (`solve_by_id`),
  KEY `validate_by_id` (`validate_by_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table problems
#

INSERT INTO `problems` VALUES (1000,1000,1000,'2006-11-12','����ʹ�ò�����','002','��ǿѵ����',1001,1000,'002',NULL);
INSERT INTO `problems` VALUES (1002,1000,1000,'2006-12-14','û�а�',NULL,NULL,NULL,NULL,'001',NULL);
INSERT INTO `problems` VALUES (1003,1000,1000,'2006-12-14','�����',NULL,NULL,NULL,NULL,'001',NULL);

#
# Table structure for table products
#

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL default '0',
  `target_id` bigint(20) default NULL,
  `product_name` varchar(255) default NULL,
  `product_size_plan` int(11) default NULL,
  `product_size_fact` int(11) default NULL,
  `product_unit` varchar(3) default NULL,
  `refer_by_id` bigint(20) default NULL,
  `refer_date` date default NULL,
  `status` varchar(3) default NULL,
  `audit_by_id` bigint(20) default NULL,
  `audit_date` date default NULL,
  `audit_remark` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `target_id` (`target_id`),
  KEY `refer_by_id` (`refer_by_id`),
  KEY `audit_by_id` (`audit_by_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table products
#

INSERT INTO `products` VALUES (1000,1000,'�����ĵ�',100,25,'001',1001,'2006-11-12','003',1000,'2006-12-11','��ɵĲ���');

#
# Table structure for table project_reports
#

CREATE TABLE `project_reports` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `report_date` date default NULL,
  `report_name` varchar(50) default NULL,
  `excute_status` varchar(255) default NULL,
  `problem` varchar(255) default NULL,
  `risk` varchar(255) default NULL,
  `next_plan` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table project_reports
#

INSERT INTO `project_reports` VALUES (1000,1000,'2006-12-12','��ʼ����','����','������','�޷���','ִ�в���');
INSERT INTO `project_reports` VALUES (1001,1000,'2006-11-13','��Ŀ����2','���ڿ�չ','��Ա���̶�','�ʽ���','�����ʽ�');
INSERT INTO `project_reports` VALUES (1002,1000,'2006-12-12','��Ŀ����3','','','','');
INSERT INTO `project_reports` VALUES (1003,1000,'2007-11-06','ff ������','��ķ�','','','');

#
# Table structure for table projects
#

CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL default '0',
  `project_code` varchar(50) default NULL,
  `project_name` varchar(50) default NULL,
  `project_goal` varchar(255) default NULL,
  `pm_id` bigint(20) default NULL,
  `start_date` date default NULL,
  `close_date` date default NULL,
  `budget` double default NULL,
  `person_cost` double default NULL,
  `team_size` int(11) default NULL,
  `develop_roof` varchar(255) default NULL,
  `develop_language` varchar(50) default NULL,
  `status` varchar(3) default NULL,
  `is_deleted` char(1) default NULL,
  PRIMARY KEY  (`id`),
  KEY `pm_id` (`pm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table projects
#

INSERT INTO `projects` VALUES (1000,'code','������Ŀ','sadfasadfa��ɪ���dsf',999,'2006-07-13','2007-01-16',200000,100,302,'windows','java','001','0');
INSERT INTO `projects` VALUES (1001,'�½���Ŀ','����2','',1002,NULL,NULL,NULL,NULL,NULL,'','','','');

#
# Table structure for table risks
#

CREATE TABLE `risks` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `risk_description` varchar(255) default NULL,
  `risk_level` varchar(3) default NULL,
  `probability` varchar(3) default NULL,
  `submit_by_id` bigint(20) default NULL,
  `submit_date` date default NULL,
  `influence` varchar(255) default NULL,
  `keep_away_measure` varchar(255) default NULL,
  `status` varchar(3) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`),
  KEY `submit_by_id` (`submit_by_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table risks
#

INSERT INTO `risks` VALUES (1,1000,'��Ա����','001','001',1003,NULL,'Ӱ�첻����','��ʩ������','001');

#
# Table structure for table role_permission
#

CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL default '0',
  `role_id` bigint(20) default NULL,
  `permission_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table role_permission
#

INSERT INTO `role_permission` VALUES (1000,1000,1000);
INSERT INTO `role_permission` VALUES (1001,1000,1001);
INSERT INTO `role_permission` VALUES (1002,1000,1002);
INSERT INTO `role_permission` VALUES (2000,1000,10000);
INSERT INTO `role_permission` VALUES (2001,1000,10200);
INSERT INTO `role_permission` VALUES (2002,1000,10300);
INSERT INTO `role_permission` VALUES (2003,1000,10100);
INSERT INTO `role_permission` VALUES (2004,1000,20000);
INSERT INTO `role_permission` VALUES (2005,1000,20100);
INSERT INTO `role_permission` VALUES (2006,1000,20200);
INSERT INTO `role_permission` VALUES (2007,1000,20300);
INSERT INTO `role_permission` VALUES (2008,1000,30000);
INSERT INTO `role_permission` VALUES (2010,1000,30200);
INSERT INTO `role_permission` VALUES (2011,1000,30300);
INSERT INTO `role_permission` VALUES (2012,1000,30400);
INSERT INTO `role_permission` VALUES (2014,1000,30600);
INSERT INTO `role_permission` VALUES (2015,1000,40000);
INSERT INTO `role_permission` VALUES (2016,1000,40100);
INSERT INTO `role_permission` VALUES (2017,1000,40200);
INSERT INTO `role_permission` VALUES (2018,1000,50000);
INSERT INTO `role_permission` VALUES (2019,1000,50100);
INSERT INTO `role_permission` VALUES (2020,1000,50200);
INSERT INTO `role_permission` VALUES (2021,1000,60000);
INSERT INTO `role_permission` VALUES (2022,1000,60100);
INSERT INTO `role_permission` VALUES (2023,1000,60200);
INSERT INTO `role_permission` VALUES (2024,1000,10101);
INSERT INTO `role_permission` VALUES (2025,1000,10203);
INSERT INTO `role_permission` VALUES (2026,1000,10202);
INSERT INTO `role_permission` VALUES (2027,1000,10201);
INSERT INTO `role_permission` VALUES (2028,1000,40101);
INSERT INTO `role_permission` VALUES (2029,1000,40102);
INSERT INTO `role_permission` VALUES (2030,1000,40103);
INSERT INTO `role_permission` VALUES (2031,1000,40201);
INSERT INTO `role_permission` VALUES (2032,1000,40202);
INSERT INTO `role_permission` VALUES (2033,1000,40203);
INSERT INTO `role_permission` VALUES (2034,1000,40204);
INSERT INTO `role_permission` VALUES (2035,1000,40205);

#
# Table structure for table roles
#

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL default '0',
  `role` varchar(20) default NULL,
  `remark` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table roles
#

INSERT INTO `roles` VALUES (999,'portal','�Ż��û�');
INSERT INTO `roles` VALUES (1000,'pm','��Ŀ����');
INSERT INTO `roles` VALUES (1001,'se','������Ա');
INSERT INTO `roles` VALUES (1002,'manager','�߼�����');

#
# Table structure for table targets
#

CREATE TABLE `targets` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `is_parent` char(1) default NULL,
  `parent_id` bigint(20) default NULL,
  `target_level` int(11) default NULL,
  `target_order` varchar(48) default NULL,
  `se_id` bigint(20) default NULL,
  `pl_id` bigint(20) default NULL,
  `target_name` varchar(50) default NULL,
  `remark` varchar(255) default NULL,
  `is_milestone` char(1) default NULL,
  `start_date_plan` date default NULL,
  `end_date_plan` date default NULL,
  `start_date_fact` date default NULL,
  `end_date_fact` date default NULL,
  `workload_fact` int(11) default NULL,
  `workload_plan` int(11) default NULL,
  `display_color` varchar(20) default NULL,
  `status` varchar(3) default NULL,
  `excute_status` varchar(255) default NULL,
  `is_deleted` char(1) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`),
  KEY `pl_id` (`pl_id`),
  KEY `se_id` (`se_id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table targets
#

INSERT INTO `targets` VALUES (1,1000,'1',NULL,1,'01',NULL,NULL,'01',NULL,NULL,'2006-11-03','2006-12-12',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (2,1000,'1',NULL,1,'02',NULL,NULL,'02',NULL,NULL,'2006-11-01','2006-12-09',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (3,1000,'1',NULL,1,'03',NULL,NULL,'03',NULL,NULL,'2006-11-25','2006-12-31',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (4,1000,'0',1,2,'0101',NULL,NULL,'0101',NULL,NULL,'2006-11-03','2006-11-20',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (6,1000,'1',2,2,'0201',NULL,NULL,'0201',NULL,NULL,'2006-11-01','2006-11-26',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (7,1000,'0',2,2,'0202',NULL,NULL,'0202',NULL,NULL,'2006-11-12','2006-12-09',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (8,1000,'1',3,2,'0301',1001,NULL,'0301',NULL,NULL,'2006-11-01','2006-11-15',NULL,NULL,3,30,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (9,1000,'0',3,2,'0302',1001,NULL,'0302',NULL,NULL,'2006-10-20','2006-11-10',NULL,NULL,4,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (10,1000,'0',3,2,'0303',NULL,NULL,'0303',NULL,NULL,'2006-11-30','2006-12-30',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (11,1000,'0',6,3,'020101',1000,NULL,'020101',NULL,NULL,'2006-11-01','2006-11-26',NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (12,NULL,NULL,NULL,NULL,'',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,10,40,NULL,NULL,NULL,NULL);
INSERT INTO `targets` VALUES (1000,1000,'0',NULL,1,'1101',1000,NULL,'1101','��������',NULL,'2006-11-01','2006-11-14','2006-11-02','2006-11-13',10,20,'','001','ִ������','');
INSERT INTO `targets` VALUES (1001,1000,'0',NULL,1,'1102',1000,NULL,'1102','��������2',NULL,'2006-10-28','2006-11-10',NULL,NULL,6,50,NULL,'001',NULL,NULL);
INSERT INTO `targets` VALUES (1002,1000,'0',8,3,'030101',NULL,NULL,'030101',NULL,NULL,'2006-11-25','2006-12-15',NULL,NULL,10,40,NULL,'001',NULL,'0');
INSERT INTO `targets` VALUES (1004,1000,'0',1,2,'0102',NULL,NULL,'0102',NULL,NULL,'2006-11-12','2006-12-12',NULL,NULL,10,40,NULL,'001',NULL,'0');

#
# Table structure for table user_role
#

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `user_id` bigint(20) default NULL,
  `role_id` bigint(20) default NULL,
  `is_working` char(1) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table user_role
#

INSERT INTO `user_role` VALUES (1017,1000,1003,1002,'1');
INSERT INTO `user_role` VALUES (1019,1000,1003,999,'1');
INSERT INTO `user_role` VALUES (1021,1000,999,1000,'1');
INSERT INTO `user_role` VALUES (1025,1000,1000,1001,'1');
INSERT INTO `user_role` VALUES (1026,1001,1002,1000,'1');
INSERT INTO `user_role` VALUES (1027,1001,1002,1001,'1');
INSERT INTO `user_role` VALUES (1028,1001,1003,1001,'1');
INSERT INTO `user_role` VALUES (1029,1000,1001,1001,'1');
INSERT INTO `user_role` VALUES (1030,1000,1003,1001,'1');
INSERT INTO `user_role` VALUES (1031,1000,1002,1001,'1');
INSERT INTO `user_role` VALUES (1032,1000,999,1001,'1');

#
# Table structure for table users
#

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL default '0',
  `login_name` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `user_name` varchar(20) default NULL,
  `sex` char(1) default NULL,
  `email` varchar(50) default NULL,
  `address` varchar(100) default NULL,
  `phone` varchar(20) default NULL,
  `handset` varchar(20) default NULL,
  `is_deleted` char(1) default NULL,
  `is_admin` char(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table users
#

INSERT INTO `users` VALUES (999,'person','person','�Ż��û�','1','guobird@dlmu.edu.cn','���´�ѧ',NULL,'12345678901','0','1');
INSERT INTO `users` VALUES (1000,'a','','ƽƽ','0','guoguo1982_2001@163.com','���´�ѧ','','13591345023','0','1');
INSERT INTO `users` VALUES (1001,'b','','����','1','dangdang@167.com','','','','0','0');
INSERT INTO `users` VALUES (1002,'c','111','�տ�','1',NULL,NULL,NULL,NULL,'0','0');
INSERT INTO `users` VALUES (1003,'d',NULL,' ����','1',NULL,NULL,NULL,NULL,'0','0');

#
# Table structure for table week_reports
#

CREATE TABLE `week_reports` (
  `id` bigint(20) NOT NULL default '0',
  `target_id` bigint(20) default NULL,
  `week_id` bigint(20) default NULL,
  `submit_by_id` bigint(20) default NULL,
  `submit_date` date default NULL,
  `start_date_fact` date default NULL,
  `end_date_fact` date default NULL,
  `workload_thisweek` int(11) default NULL,
  `excute_status` varchar(255) default NULL,
  `problem` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `target_id` (`target_id`),
  KEY `submit_by_id` (`submit_by_id`),
  KEY `week_id` (`week_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table week_reports
#

INSERT INTO `week_reports` VALUES (1000,1000,1002,1000,NULL,NULL,NULL,7,NULL,NULL);
INSERT INTO `week_reports` VALUES (1001,1001,1002,1000,NULL,NULL,NULL,10,NULL,NULL);
INSERT INTO `week_reports` VALUES (1002,8,1002,1000,NULL,NULL,NULL,8,NULL,NULL);
INSERT INTO `week_reports` VALUES (1003,9,1002,1000,NULL,NULL,NULL,12,NULL,NULL);
INSERT INTO `week_reports` VALUES (1004,1000,1003,1000,'2006-12-14','2006-11-02','2006-12-13',20,'����','û��');
INSERT INTO `week_reports` VALUES (1005,1000,1001,1000,'2006-12-14','2006-11-01','2006-11-02',25,'�ܺ�','û�а�');
INSERT INTO `week_reports` VALUES (1006,1001,1001,1000,'2006-12-14','2006-10-29','2006-11-10',100,'�õ�','�����');
INSERT INTO `week_reports` VALUES (1007,11,1002,1000,'2006-12-14','2006-12-03','2006-12-16',NULL,'','');

#
# Table structure for table weeks
#

CREATE TABLE `weeks` (
  `id` bigint(20) NOT NULL default '0',
  `project_id` bigint(20) default NULL,
  `start_date` date default NULL,
  `end_date` date default NULL,
  `workload_per_day` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table weeks
#

INSERT INTO `weeks` VALUES (1001,1000,'2006-10-30','2006-11-03',8);
INSERT INTO `weeks` VALUES (1002,1000,'2006-11-06','2006-11-10',8);
INSERT INTO `weeks` VALUES (1003,1000,'2006-11-13','2006-11-17',8);
INSERT INTO `weeks` VALUES (1004,1000,'2006-11-20','2006-11-24',8);
INSERT INTO `weeks` VALUES (1007,1000,'2006-12-04','2006-12-08',8);
INSERT INTO `weeks` VALUES (1010,1000,'2006-12-11','2006-12-16',8);
INSERT INTO `weeks` VALUES (1011,1000,'2007-01-04','2007-01-05',8);
INSERT INTO `weeks` VALUES (1012,1000,'2007-01-08','2007-01-12',8);
INSERT INTO `weeks` VALUES (1013,1000,'2007-01-15','2007-01-19',8);
INSERT INTO `weeks` VALUES (1014,1000,'2007-01-22','2007-01-24',8);
INSERT INTO `weeks` VALUES (1015,1000,'2006-09-04','2006-09-08',8);
INSERT INTO `weeks` VALUES (1016,1000,'2006-09-11','2006-09-15',8);
INSERT INTO `weeks` VALUES (1017,1000,'2006-09-18','2006-09-22',8);
INSERT INTO `weeks` VALUES (1018,1000,'2006-09-25','2006-09-29',8);
INSERT INTO `weeks` VALUES (1019,1000,'2007-02-06','2007-02-09',8);
INSERT INTO `weeks` VALUES (1020,1000,'2007-02-12','2007-02-16',8);
INSERT INTO `weeks` VALUES (1021,1000,'2007-02-19','2007-02-23',8);
INSERT INTO `weeks` VALUES (1022,1000,'2007-02-26','2007-03-02',8);
INSERT INTO `weeks` VALUES (1023,1000,'2007-03-05','2007-03-09',8);
INSERT INTO `weeks` VALUES (1024,1000,'2007-03-12','2007-03-16',8);
INSERT INTO `weeks` VALUES (1025,1000,'2007-03-19','2007-03-23',8);
INSERT INTO `weeks` VALUES (1026,1000,'2007-03-26','2007-03-30',8);
INSERT INTO `weeks` VALUES (1028,1000,'2007-04-09','2007-04-13',8);

#
#  Foreign keys for table accept_reports
#

ALTER TABLE `accept_reports`
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

#
#  Foreign keys for table payouts
#

ALTER TABLE `payouts`
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

#
#  Foreign keys for table problems
#

ALTER TABLE `problems`
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD FOREIGN KEY (`submit_by_id`) REFERENCES `users` (`id`),
  ADD FOREIGN KEY (`solve_by_id`) REFERENCES `users` (`id`),
  ADD FOREIGN KEY (`validate_by_id`) REFERENCES `users` (`id`);

#
#  Foreign keys for table products
#

ALTER TABLE `products`
  ADD FOREIGN KEY (`target_id`) REFERENCES `targets` (`id`),
  ADD FOREIGN KEY (`refer_by_id`) REFERENCES `users` (`id`),
  ADD FOREIGN KEY (`audit_by_id`) REFERENCES `users` (`id`);

#
#  Foreign keys for table project_reports
#

ALTER TABLE `project_reports`
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

#
#  Foreign keys for table projects
#

ALTER TABLE `projects`
  ADD FOREIGN KEY (`pm_id`) REFERENCES `users` (`id`);

#
#  Foreign keys for table risks
#

ALTER TABLE `risks`
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD FOREIGN KEY (`submit_by_id`) REFERENCES `users` (`id`);

#
#  Foreign keys for table role_permission
#

ALTER TABLE `role_permission`
  ADD FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`);

#
#  Foreign keys for table targets
#

ALTER TABLE `targets`
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD FOREIGN KEY (`pl_id`) REFERENCES `users` (`id`),
  ADD FOREIGN KEY (`se_id`) REFERENCES `users` (`id`),
  ADD FOREIGN KEY (`parent_id`) REFERENCES `targets` (`id`);

#
#  Foreign keys for table user_role
#

ALTER TABLE `user_role`
  ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

#
#  Foreign keys for table week_reports
#

ALTER TABLE `week_reports`
  ADD FOREIGN KEY (`week_id`) REFERENCES `weeks` (`id`),
  ADD FOREIGN KEY (`target_id`) REFERENCES `targets` (`id`),
  ADD FOREIGN KEY (`submit_by_id`) REFERENCES `users` (`id`);

#
#  Foreign keys for table weeks
#

ALTER TABLE `weeks`
  ADD FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);


/*!40101 SET NAMES latin1 */;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
