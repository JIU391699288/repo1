<%@ page import="com.zl.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //request.setAttribute("a",10);
    User user = null;
    request.setAttribute("u",user);

    User user1 = new User();
    request.setAttribute("u1",user1);

    List list = new ArrayList();
    request.setAttribute("l",list);

    List list02 = null;
    request.setAttribute("l2",list02);
%>

<%--a就是从域里面获得的a
    ${a+19}
    ${a>20}
--%>
<%--1.判断对象(user是)否为null--%>
${empty u} <%--true--%>
${empty u1} <%--false--%>

${not empty u}<%--false--%>
<hr/>
<%--2.判断一个集合的长度是否为0--%>
${empty l} <%--true--%>
${empty l2} <%--true--%>
</body>
</html>
