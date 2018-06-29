<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: karav
  Date: 26.06.2018
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h1>BLOG DETAIL</h1>

<c:if test="${true}">

    <label>id</label>
    ${blog.id}
    <label>name</label>
    ${blog.name}
    <label>id</label>
    ${blog.url}

</c:if>

</body>
</html>
