<%@ page import="com.zl.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User("zs", "123456", 18);
    request.setAttribute("u",user);
%>

获得密码:<br/>
老方式:<%=((User)request.getAttribute("u")).getPassword()%><br/>
el方式:${u.password}  <br/>
el方式:${requestScope.u.password}  <br/>
<hr/>
</body>
</html>
