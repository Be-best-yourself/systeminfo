use linux;
/*
navicat mysql data transfer

source server         : localhost_3306
source server version : 50718
source host           : localhost:3306
source database       : linux

target server type    : mysql
target server version : 50718
file encoding         : 65001

date: 2017-07-24 09:13:39
*/

set foreign_key_checks=0;

-- ----------------------------
-- table structure for t_file
-- ----------------------------
drop table if exists `t_file`;
create table `t_file` (
  `id` int(11) not null auto_increment,
  `file_code` varchar(255) default null comment '文件代号',
  `file_name` varchar(255) default '' comment '文件名',
  `file_path` varchar(255) default null comment '文件路径',
  `file_type` varchar(255) default null comment '文件类型',
  `file_size` double default null comment '文件大小',
  `modify_time` datetime default null on update current_timestamp comment '修改时间',
  `file_level` int(11) default null comment '文件层级',
  `is_directory` tinyint(4) default null comment '是否为目录,0(否)，1(是)，默认0',
  `parent_path` varchar(255) default null comment '父路径',
  `permission` varchar(255) default null comment '文件权限',
  `creat_time` datetime default null on update current_timestamp comment '创建时间',
  `oper_times` int(11) default null comment '操作次数',
  `visit_times` int(11) default null comment '访问次数',
  primary key (`id`)
) engine=innodb auto_increment=2 default charset=utf8;
