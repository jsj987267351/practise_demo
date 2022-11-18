<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2022/11/18
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


        <h1>Hello JSP</h1>

        <%
            System.out.println("Hello JSP");
            int i = 3;
        %>


<%--        直接打印在页面--%>
        <%="Hello"%>
        <%=i%>

        <%!
            void show(){}
        %>
</body>
</html>
