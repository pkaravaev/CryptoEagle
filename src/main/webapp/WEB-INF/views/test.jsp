<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>


<table>
    <thead>
    <tr>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${items}" var="item">
    <tr>
        <td>${item.title}</td>
        <td>${item.publishDate}</td>
        <td>${item.link}</td>
    </tr>
    </tbody>

    </c:forEach>
</table>


<jsp:include page="template/footer.jsp"/>
