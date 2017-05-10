package com.miku.web.entity;

import java.util.Date;

/**
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
 * Created by henrybit on 2017/3/30.
 * @version 1.0
 */
public class JoinGame {
    protected long id;
    protected String wechatId;
    protected String name;
    protected String job;
    protected String phone;
    protected String refereeWechatId;
    protected String refereeWechat;
    protected int sex;
    protected String corporation;
    protected Date registerTime;
    protected int corporationPeopleNum;
    protected String projectName;
    protected String projectDesc;
    protected int tpFinancing;
    protected int tpPrice;
    protected int tpContacts;
    protected int tpPinTui;
    protected int tpStudy;
    protected Date createTime;
    protected String headPic;
    //推荐别人了多少次
    protected int tjtimes;
    protected long registerTimeLong;
    protected String sexDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRefereeWechatId() {
        return refereeWechatId;
    }

    public void setRefereeWechatId(String refereeWechatId) {
        this.refereeWechatId = refereeWechatId;
    }

    public String getRefereeWechat() {
        return refereeWechat;
    }

    public void setRefereeWechat(String refereeWechat) {
        this.refereeWechat = refereeWechat;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public int getCorporationPeopleNum() {
        return corporationPeopleNum;
    }

    public void setCorporationPeopleNum(int corporationPeopleNum) {
        this.corporationPeopleNum = corporationPeopleNum;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public int getTpFinancing() {
        return tpFinancing;
    }

    public void setTpFinancing(int tpFinancing) {
        this.tpFinancing = tpFinancing;
    }

    public int getTpPrice() {
        return tpPrice;
    }

    public void setTpPrice(int tpPrice) {
        this.tpPrice = tpPrice;
    }

    public int getTpContacts() {
        return tpContacts;
    }

    public void setTpContacts(int tpContacts) {
        this.tpContacts = tpContacts;
    }

    public int getTpPinTui() {
        return tpPinTui;
    }

    public void setTpPinTui(int tpPinTui) {
        this.tpPinTui = tpPinTui;
    }

    public int getTpStudy() {
        return tpStudy;
    }

    public void setTpStudy(int tpStudy) {
        this.tpStudy = tpStudy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTjtimes() {
        return tjtimes;
    }

    public void setTjtimes(int tjtimes) {
        this.tjtimes = tjtimes;
    }

    public long getRegisterTimeLong() {
        return registerTimeLong;
    }

    public void setRegisterTimeLong(long registerTimeLong) {
        this.registerTimeLong = registerTimeLong;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }
}
