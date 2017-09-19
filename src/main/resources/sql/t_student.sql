use linux;
/*
navicat mysql data transfer

source server         : localhost_3306
source server version : 50718
source host           : localhost:3306
source database       : zfw

target server type    : mysql
target server version : 50718
file encoding         : 65001

date: 2017-07-24 09:12:49
*/

set foreign_key_checks=0;

-- ----------------------------
-- table structure for t_student
-- ----------------------------
drop table if exists `t_student`;
create table `t_student` (
  `s_id` int(11) not null auto_increment,
  `s_age` int(11) default null,
  `s_name` varchar(255) default null,
  `s_score` double default null,
  primary key (`s_id`)
) engine=innodb auto_increment=56 default charset=utf8;

-- ----------------------------
-- records of t_student
-- ----------------------------
insert into `t_student` values ('21', '21', '张三', '66');
insert into `t_student` values ('22', '21', '张三', '66');
insert into `t_student` values ('23', '21', '张三', '66');
insert into `t_student` values ('24', '21', '张三', '66');
insert into `t_student` values ('25', '21', '张三', '66');
insert into `t_student` values ('26', '21', '张三', '66');
insert into `t_student` values ('27', '21', '张三', '66');
insert into `t_student` values ('28', '21', '张三', '66');
insert into `t_student` values ('29', '21', '张三', '66');
insert into `t_student` values ('30', '21', '张三', '66');
insert into `t_student` values ('31', '21', '张三', '66');
insert into `t_student` values ('32', '32', '王五', '43');
insert into `t_student` values ('33', '21', '张三', '66');
insert into `t_student` values ('34', '12', 'zhangsan', '23');
insert into `t_student` values ('35', '12', 'zhangsan', '23');
insert into `t_student` values ('36', '12', 'zhangsan', '23');
insert into `t_student` values ('37', '12', 'zhangsan', '23');
insert into `t_student` values ('38', '12', 'zhangsan', '23');
insert into `t_student` values ('39', '12', 'zhangsan', '23');
insert into `t_student` values ('40', '12', 'zhangsan', '23');
insert into `t_student` values ('41', '12', 'zhangsan', '23');
insert into `t_student` values ('42', '12', 'zhangsan', '23');
insert into `t_student` values ('43', '12', 'zhangsan', '23');
insert into `t_student` values ('44', '12', 'zhangsan', '23');
insert into `t_student` values ('45', '12', 'zhangsan', '23');
insert into `t_student` values ('46', '12', 'zhangsan', '23');
insert into `t_student` values ('47', '12', 'zhangsan', '23');
insert into `t_student` values ('48', '12', 'zhangsan', '23');
insert into `t_student` values ('49', '12', 'zhangsan', '23');
insert into `t_student` values ('50', '12', 'zhangsan', '23');
insert into `t_student` values ('51', '12', 'zhangsan', '23');
insert into `t_student` values ('52', '12', 'zhangsan', '23');
insert into `t_student` values ('53', '12', 'zhangsan', '23');
insert into `t_student` values ('54', '12', 'zhangsan', '23');
insert into `t_student` values ('55', '32', '王五', '43');
set foreign_key_checks=1;
