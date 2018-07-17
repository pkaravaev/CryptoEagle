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
    <h2>Toggleable Tabs</h2>
    <br>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#home">News</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu1">Ico</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="home" class="container tab-pane active"><br>

            <div class="col-11 align-self-center ">

                <c:forEach items="${items}" var="item">

                    <div class="card h-30 border  border-white" >
                        <div class="card-body">
                            <img src="/resources/pic/dollars.jpg" width="110" height="80" class="rounded float-left" alt="blablalal" hspace="5" >
                            <h5 class="card-title">${item.title}</h5>
                            <h5  class="blockquote-footer">2018.10.01 Ivan Ivanov</h5>
                            <p class="card-text">${item.description}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <div id="menu1" class="container tab-pane fade"><br>
            <h3>Menu 1</h3>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>

    </div>
</div>


<jsp:include page="template/footer.jsp"/>