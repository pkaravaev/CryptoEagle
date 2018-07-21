<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<div class="container">


    <div class="row">
        <div class="col-sm  border-right">
            <h2>ACTIVE ICO</h2>
            <br>
            <hr>
            <c:forEach items="${aico}" var="ico">
            <div class="card h-30 border  border-white">
            <div class="card-body">
            <img src="${ico.image}" width="200" height="50" class="rounded float-left"
            alt="Error"
            hspace="5">
            ${status.count}
            <%--<h5 class="card-title">${ico.name}</h5>--%>
            <h5 class="blockquote-footer">${ico.start_time}</h5>
            </div>
            </div>
            </c:forEach>

        </div>
        <div class="col-sm  border-right ">
            <h2>UPCOMING</h2>
            <br>
            <hr>
            <c:forEach items="${uico}" var="ico">
            <div class="card h-30 border  border-white">
            <div class="card-body">
            <img src="${ico.image}" width="200" height="50" class="rounded float-left"
            alt="Error"
            hspace="5">
            ${status.count}
            <%--<h5 class="card-title">${ico.name}</h5>--%>
            <h5 class="blockquote-footer">${ico.start_time}</h5>
            </div>
            </div>

            </c:forEach>
        </div>
        <div class="col-sm ">
            <h2>ENDED ICO</h2>
            <br>
            <hr>
            <c:forEach items="${eico}" var="ico">
            <div class="card h-30 border  border-white">
            <div class="card-body">
            <img src="${ico.image}" width="200" height="50" class="rounded float-left"
            alt="Error"
            hspace="5">
            ${status.count}
            <%--<h5 class="card-title">${ico.name}</h5>--%>
            <h5 class="blockquote-footer">${ico.start_time}</h5>
            </div>
            </div>
            </c:forEach>

        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>