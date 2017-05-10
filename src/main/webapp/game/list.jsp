<%--
  Created by IntelliJ IDEA.
  User: qipenghui
  Date: 2017/4/13
  Time: 上午12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>米库创服大赛-参赛情况</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../demo.css">
    <script type="text/javascript" src="../jquery.min.js"></script>
    <script type="text/javascript" src="../jquery.easyui.min.js"></script>
</head>
<body>
<h2>参赛情况</h2>
<div style="margin:20px 0;"></div>

<table id="dg_check" class="easyui-datagrid" url="list.json" style="width:100%;height:auto;min-height:500px" rownumbers="true" pagination="false" iconCls="icon-save">
    <thead>
    <tr>
        <th field="wechatId" width="80">微信ID</th>
        <th field="name" width="80">昵称</th>
        <th field="job" width="80">职位</th>
        <th field="phone" width="80">手机号</th>
        <th field="refereeWechat" width="80">推荐人</th>
        <th field="sexDesc" width="80">性别</th>
        <th field="corporation" width="80">公司</th>
        <th field="corporationPeopleNum" width="80">公司人数</th>
        <th field="tpFinancing" width="80">融资投票</th>
        <th field="tpPrice" width="80">奖金投票</th>
        <th field="tpContacts" width="80">人脉投票</th>
        <th field="tpPinTui" width="80">品推投票</th>
        <th field="tpStudy" width="80">学习投票</th>
        <th field="projectName" width="80">项目名称</th>
        <th field="projectDesc" width="280">项目描述</th>
        <th field="registerTime" width="180">注册时间</th>
    </tr>
    </thead>
</table>

</body>
</html>
