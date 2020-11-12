<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String[] array = {"aaa","bbb","ccc"};
    request.setAttribute("a",array);

    List<String> list = new ArrayList<String>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    session.setAttribute("l",list);

    Map<String,String> map = new HashMap<String,String>();
    map.put("akey","aaa");
    map.put("bkey","bbb");
    map.put("ckey","ccc");
    request.setAttribute("m",map);

%>

获得数组里面的第2个值:<br/>
老方式:<%=((String[])request.getAttribute("a"))[1]%><br/>
el方式:${requestScope.a[1]}<br/>
el方式:${a[1]}<br/>
<hr/>
获得list里面的第1个值:<br/>
老方式:<%=((List<String>)session.getAttribute("l")).get(0)%><br/>
el方式: ${sessionScope.l[0]} <br/>
el方式: ${l[0]} <br/>
<hr/>
获得map里面的akey对应值:<br/>
老方式:<%=((Map<String,String>)request.getAttribute("m")).get("akey")%><br/>
el方式: ${requestScope.m.akey }  <br/>
el方式: ${m.akey }  <br/>
</body>
</html>
