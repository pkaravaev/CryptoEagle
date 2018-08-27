<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglib.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.9/css/mdb.min.css" rel="stylesheet">
    <!-- MDBootstrap Datatables  -->
    <link href="/resources/css/addons/datatables.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">

    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.9/js/mdb.min.js"></script>
    <!-- MDBootstrap Datatables  -->
    <script type="text/javascript" src="/resources/js/addons/datatables.min.js"></script>


    <script src="/resources/js/table.js"></script>
    <script src="/resources/js/coins.js"></script>

    <title>Welcome</title>

</head>


<script src="js/form-validation.js"></script>

<script>
    $(document).ready(function () {
        $("#eagle").click(function () {
            window.location.href = "/";
        })
        // $("#loginForm").validate();
    })
</script>


<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark brown ">

    <div class="container ">
        <!-- Collapse button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
                aria-controls="basicExampleNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Collapsible content -->
        <div class="collapse navbar-collapse justify-content-center font-weight-bold " id="basicExampleNav">

            <!-- Links -->
            <ul class="navbar-nav ">
                <li class="nav-item">
                    <a class="nav-link" href="/beginners">BEGINERS GUIDE</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/news">NEWS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/coin-list">COINS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ico-list">LIST</a>
                </li>
            </ul>
            <!-- Links -->
            <!-- Navbar brand -->
            <a class="navbar-brand px-lg-4 mr-0" href="#">
                <img id="eagle" class="animated bounce infinite" src="/resources/pic/eagle.png" width="120" height="80"
                     alt="">
            </a>
            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/ico-stats">STATS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/whitelist">WHITELIST</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/events">EVENTS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/analitics">ANALITICS</a>
                </li>


                <li class="nav-item">
                    <a id="account" class="nav-link" href="/user-profile">My account</a>
                </li>
                <li class="nav-item">
                    <a id="modal" class="nav-link">Login / Register</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>
                <%--<c:choose>--%>

                    <%--<c:when test="${sessionScope.containsKey(user) == true}">--%>
                        <%--<li class="nav-item">--%>
                            <%--<a id="account" class="nav-link" href="#modalLRForm">My account</a>--%>
                        <%--</li>--%>

                    <%--</c:when>--%>

                    <%--<c:when test="${sessionScope.get(user).toString() == null}">--%>
                        <%--<li class="nav-item">--%>
                            <%--<a id="modal" class="nav-link">Login / Register</a>--%>
                        <%--</li>--%>

                    <%--</c:when>--%>

                <%--</c:choose>--%>

            </ul>
            <!-- Links -->
        </div>
    </div>

</nav>

<!--Navbar-->
<ul class="nav justify-content-center font-weight-bold brown darken-2">
    <li class="nav-item">
        <a id="BTC" class="nav-link" href="/coin-list"><p class="red-text"></p></a>
    </li>
    <li class="nav-item">
        <a id="ETH" class="nav-link" href="/coin-list"><p class="white-text"></p></a>
    </li>
    <li class="nav-item">
        <a id="NEO" class="nav-link" href="/coin-list"><p class="white-text"></p></a>
    </li>
    <li class="nav-item">
        <a id="XRP" class="nav-link " href="/coin-list"><p class="white-text"></p></a>
    </li>
    <li class="nav-item">
        <a id="EOS" class="nav-link " href="/coin-list"><p class="white-text"></p></a>
    </li>

</ul>

<jsp:include page="login.jsp"/>
</div>
<!--Modal: Login / Register Form-->


