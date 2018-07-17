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

                    <div class="card h-30 border  border-white">
                        <div class="card-body">
                            <img src="/resources/pic/dollars.jpg" width="110" height="80" class="rounded float-left"
                                 alt="blablalal" hspace="5">
                            <h5 class="card-title">${item.title}</h5>
                            <h5 class="blockquote-footer">2018.10.01 Ivan Ivanov</h5>
                            <p class="card-text">${item.description}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <div id="menu1" class="container tab-pane fade"><br>

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#active">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#upcoming">Upcoming</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#ended">Ended</a>
                </li>
            </ul>


            <!-- Tab panes -->
            <div class="tab-content">

                <div id="active" class="container tab-pane active"><br>
                    <div class="col-11 align-self-center ">
                        <c:forEach items="${actIco}" var="ico">

                            <div class="card h-30 border  border-white">
                                <div class="card-body">
                                    <img src="${ico.image}" width="200" height="50" class="rounded float-left" alt="blablalal"
                                         hspace="5">
                                    <h5 class="card-title">${ico.name}</h5>
                                    <h5 class="blockquote-footer">${ico.start_time}</h5>
                                    <p class="card-text">${ico.description}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div id="upcoming" class="container tab-pane active"><br>
                    <div class="col-11 align-self-center ">
                        <c:forEach items="${upIco}" var="ico">

                            <div class="card h-30 border  border-white">
                                <div class="card-body">
                                    <img src="${ico.image}" width="200" height="50" class="rounded float-left" alt="blablalal"
                                         hspace="5">
                                    <h5 class="card-title">${ico.name}</h5>
                                    <h5 class="blockquote-footer">${ico.start_time}</h5>
                                    <p class="card-text">${ico.description}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div id="ended" class="container tab-pane active"><br>
                    <div class="col-11 align-self-center ">
                        <c:forEach items="${finIco}" var="ico">

                            <div class="card h-30 border  border-white">
                                <div class="card-body">
                                    <img src="${ico.image}" width="200" height="50" class="rounded float-left" alt="blablalal"
                                         hspace="5">
                                    <h5 class="card-title">${ico.name}</h5>
                                    <h5 class="blockquote-footer">${ico.start_time}</h5>
                                    <p class="card-text">${ico.description}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>


        <jsp:include page="template/footer.jsp"/>
