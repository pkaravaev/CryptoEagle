<jsp:include page="taglib.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>

    <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>

    <script src="/resources/js/coins.js"></script>


    <title>Welcome</title>
</head>
<body>


<%--<nav class="navbar  ">--%>
    <%----%>

<%--</nav>--%>



<h6 id="h1" class=" text-center bg-secondary text-white "></h6>


<%--<nav class="navbar navbar-expand-lg bg-dark h-15   ">--%>

    <%--<p class="text-center">Center aligned text on all viewport sizes.</p>--%>


<%--</nav>--%>




<nav class="navbar navbar-expand-lg navbar-light bg-light ">
    <a class="navbar-brand" href="#">Crypto Eagle</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

            <img src="/resources/pic/eagle.png"width="80" height="50" alt="unavalible" class="img-thumbnail-light">
            <li class="nav-item">
                <a class="nav-link" href="/beginners">BEGINNERS GUIDE</a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="/">NEWS <span class="sr-only">(current)</span></a>
            </li>


            <li class="nav-item">
                <a class="nav-link" href="/blogs">MY ACCOUNT</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/login">LOGIN</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/logout">LOGOUT</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/register">REGISTER</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/users">USERS</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="/users">THE ICO LIST</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="/users">LANGUAGE</a>
            </li>

        </ul>
    </div>
</nav>