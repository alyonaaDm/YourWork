<%@ page import="ru.kpfu.itis.services.UsersService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Контекст сервлета
    </title>
</head>
<body>
<p>
    <%--Так напрямую обращаться через JSP нельзя, это пример получение данных из контекста--%>
    <%
        UsersService service = (UsersService) getServletConfig().getServletContext().getAttribute("usersService");
        out.print(service.toString());
    %>
</p>
</body>
</html>