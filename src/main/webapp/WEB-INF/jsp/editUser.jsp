<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2021/12/8
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加界面</title>

</head>
<body>
<form action="/shiroSSM/user/doEdit" method="post">
    <input type="hidden" name="userid" value="${u.userid}"/>
    用户名：<input type="text" name="username" value="${u.username}"/><br/>
    密码：<input type="password" name="password" value="${u.password}"/><br/>
    <input type="submit"/>
</form>
</body>
</html>
