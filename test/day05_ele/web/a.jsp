<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("rKey","rrr");
    session.setAttribute("sKey","sss");
    /*application就是Servlet里面的ServletContext*/
    application.setAttribute("aKey","aaa");
%>

获得request里面存的数据:<br/>
老方式:<%=request.getAttribute("rKey")%><br/>
el方式:${requestScope.rKey}<br/>
<hr/>

获得session里面存的数据:<br/>
老方式:<%=session.getAttribute("sKey")%><br/>
el方式:${sessionScope.sKey}<br/>
<hr/>

获得application里面存的数据:<br/>
老方式:<%=application.getAttribute("aKey")%><br/>
el方式:${applicationScope.aKey}
<hr/>

简单方式的写法:<br/>
<%--${rKey}: 依次的从最小的域往最大的域找,能找到就返回--%>
获得request里面的数据:${rKey}<br/>
获得session里面的数据:${sKey}<br/>
获得servletContext里面的数据:${aKey}<br/>
</body>
</html>
