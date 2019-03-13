<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-2-15
  Time: 下午6:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form enctype="multipart/form-data" action="inserthouse.action" method="post">
    <input type="text" name="tatolprice" value="${allhouse.tatolprice}">
    <input type="text" name="location">
    <input type="text" name="deposit">
    <input type="text" name="userphone">
    <input type="text" name="style">
    <img src="/pic/${allhouse.img}" name="img">
    <input type="file" name="pic_house">
    <input type="submit">
</form>
</body>
</html>
