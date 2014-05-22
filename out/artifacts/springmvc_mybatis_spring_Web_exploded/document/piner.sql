drop database piner;
create database piner;

use piner;

drop table if exists unit;
create table unit(
unit_id int primary key auto_increment,
name varchar(50)
);

drop table if exists admin;
create table admin(
admin_id int primary key auto_increment,
username varchar(20),
password varchar(20),
realname varchar(20) comment '真实姓名',
status int comment '身份 0root 1校级 2院级',
unit_id int comment '单位',
FOREIGN KEY (unit_id) REFERENCES unit(unit_id)
);

drop table if exists teacher;
create table teacher(
teacher_id int primary key auto_increment,
username varchar(20),
password varchar(20),
realname varchar(20) comment '真实姓名',
status int,
unit_id int comment '单位',
FOREIGN KEY (unit_id) REFERENCES unit(unit_id)
);

/**
关于项目的相关信息如下：申报项目类别、项目名称、承担单位、主持人、持人手机、
申报日期、申请经费、开始日期、结束日期八项，
完成提供工作后项目的院系审核状态以及校审核状态均为“未审核”，项目进度状态为“立项提交”。
*/
drop table if exists project;
create table project(
project_id int primary key auto_increment,
type int comment '申报项目类别',
name varchar(255) comment '项目名称',
unit_id int comment '单位',
teacher_id int comment '申报人',
phone int comment '申报人手机',
apply_date datetime comment '申报日期',
apply_money int comment '申请经费',
start_date datetime comment '开始日期',
end_date datetime comment '结束日期',
college_check_state int comment '院系审核状态',
school_check_state int comment '校审核状态',
state int comment '项目进度状态',

FOREIGN KEY (unit_id) REFERENCES unit(unit_id),
FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);

/**
money_info 经费信息
数据库字段包括：院系、教师、项目名称、项目级别、评定时间、结项时间、
经费额度、划拨时间、经费来源、报销时期、报销摘要、报销金额、结余金额、备注
*/
drop table if exists money_info;
create table money_info(
money_info_id int primary key auto_increment,
unit_id int comment '院系',
teacher_id int comment '教师',
project_id int comment '项目',
judge_time datetime comment '评定时间',
end_timie datetime comment '结项时间',
money_limit int comment '经费额度',
give_time datetime comment '划拨时间',
money_from varchar(255) comment '经费来源',
reimburse_time datetime comment '报销时间',
reimburse_abstract varchar(255) comment '报销摘要',
reimburse_money int comment '报销金额',
remain_money int comment '结余金额',
description text comment '备注',

FOREIGN KEY (unit_id) REFERENCES unit(unit_id),
FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id),
FOREIGN KEY (project_id) REFERENCES project(project_id)
);



insert into admin(username,password) values('admin','admin');
insert into teacher(username,password) values('teacher','123');
