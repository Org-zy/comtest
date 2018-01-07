
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/commons/common.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <center>
        <br><br>
        <form action="userServlet" method="post">
            username:<input type="text" name="username"/>
            <input type="submit" value="Submit">
        </form>
    </center>
</body>
</html>
