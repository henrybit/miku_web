# 米库创业大赛

数据库结构
```sql
create database miku;
use miku;
create table join_game
(
  id bigint auto_increment comment '主键ID',
  wechat_id comment '微信ID',
  name varchar(1024) comment '姓名',
  job varchar(1024) comment '工作',
  phone varchar(32) comment '电话',
  referee_wechat_id varchar(1024) comment '推荐人微信ID',
  referee_wechat varchar(1024) comment '推荐人微信名',
  sex int(2) default 1 comment '性别:1-男,2-女',
  corporation varchar(1024) comment '公司名',
  register_time TIMESTAMP comment '注册时间',
  corporation_people_num int(10) default 0 comment '公司员工数',
  project_name varchar(1024) comment '项目名称',
  project_desc text comment '项目简介',
  tp_financing int(2) default 0 comment '融资投票',
  tp_price int(2) default 0 comment '奖金投票',
  tp_contacts int(2) default 0 comment '人脉投票',
  tp_pin_tui int(2) default 0 comment '品推投票',
  tp_study int(2) default 0 comment '学习投票',
  create_time TIMESTAMP comment '创建时间',
  PRIMARY key(id)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
```