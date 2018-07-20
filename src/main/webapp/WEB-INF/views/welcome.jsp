<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<%--<div class="container">--%>
<%--<div class="row">--%>

<%--<div class="col align-self-start">--%>

<%--</div>--%>

<%--<div class="col-11 align-self-center ">--%>

<%--<c:forEach items="${items}" var="item">--%>

<%--<div class="card h-30 border  border-white" >--%>
<%--<div class="card-body">--%>
<%--<img src="/resources/pic/dollars.jpg" width="110" height="80" class="rounded float-left" alt="blablalal" hspace="5" >--%>
<%--<h5 class="card-title">${item.title}</h5>--%>
<%--<h5  class="blockquote-footer">2018.10.01 Ivan Ivanov</h5>--%>
<%--<p class="card-text">${item.description}</p>--%>
<%--</div>--%>
<%--</div>--%>
<%--</c:forEach>--%>
<%--</div>--%>


<%--<div class="col align-self-end">--%>

<%--</div>--%>
<%--</div>--%>
<%--</div>--%>


<div class="container">

    <br>

    <c:forEach items="${items}" var="item">
    <div class="card h-30 border  border-white">
        <div class="card-body">
            <img src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" width="110" height="80"
                 class="rounded float-left"
                 alt="Cannnot load picture!" hspace="5">
            <a href="${item.link}"><h5 class="card-title">${item.title}</h5></a>
            <h5 class="blockquote-footer">${item.publishDate}</h5>
            <p class="card-text">${item.description}</p>
        </div>
    </div>

    </c:forEach>


    <jsp:include page="template/footer.jsp"/>

