<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("a.b.c.d","rrr");

    Map<String,String> map = new HashMap<String,String>();
    map.put("a.akey","aaa");
    map.put("bkey","bbb");
    map.put("ckey","ccc");
    request.setAttribute("m",map);
%>
${requestScope['a.b.c.d']}<hr/>
<%--${a.b.c.d}--%>
${requestScope['a.b.c.d']}<br/>
${requestScope.m['a.akey']}<hr/>
${m['a.akey']}

<br/>
</body>
</html>
