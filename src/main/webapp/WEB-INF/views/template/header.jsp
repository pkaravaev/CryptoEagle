<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglib.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">


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

    <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.js"></script>


    <script src="/resources/js/table.js"></script>
    <script src="/resources/js/coins.js"></script>


    <title>Welcome</title>
</head>
<body class="body bg-light">

<script>

    $(document).ready(function () {

        $('#data-table').DataTable();
        //
        // $('#table1,#table2').dataTable( {
        //     "searching": false,
        //     "paging":false,
        //     "info": false,
        //     "autoWidth": true
        //
        // } );


        $(".nav-item").mouseleave(function () {
            $(this).removeClass("font-weight-bold");
        })

        $(".nav-item").mouseenter(function () {
            $(this).addClass("font-weight-bold");
        })

    });

</script>


<nav style="height: 6rem" class="navbar navbar-expand-lg navbar-light bg-light ">
    <div style="margin-left: 17rem">
        <a class="navbar-brand" href="/">CRYPTO EAGLE</a>
        <img src="/resources/pic/eagle.png" width="120" height="90" alt="unavalible" class="img-thumbnail-light">
    </div>

    <div style="margin-left: 10rem" class="row">

        <div class="col-md">
            <h6 id="symbolb"></h6>
            <h6 id="priceb"></h6>
            <h6 id="changeb"></h6>
        </div>
        <br>

        <div class="col-md">
            <h6 id="symbole"></h6>
            <h6 id="pricee"></h6>
            <h6 id="changee"></h6>
        </div>

        <div class="col-md">
            <h6 id="symboln"></h6>
            <h6 id="pricen"></h6>
            <h6 id="changen"></h6>
        </div>

        <div class="col-md">
            <h6 id="symbolxr"></h6>
            <h6 id="pricexr"></h6>
            <h6 id="changexr"></h6>
        </div>

        <div class="col-md">
            <h6 id="symboleo"></h6>
            <h6 id="priceeo"></h6>
            <h6 id="changeeo"></h6>
        </div>


    </div>


</nav>

<hr/>

<nav style="height: 0.7rem" class="navbar navbar-expand-lg navbar-light bg-light ">

    <div style="margin-left: 22rem" class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

            <li class="nav-item">
                <a class="nav-link" href="/beginners">BEGINNERS GUIDE</a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="/">NEWS <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/coin-list">COINS LIST</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="/ico-list">ICO LIST</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="/ico-stats">ICO STATS</a>
            </li>

            <c:choose>
                <c:when test="${sessionScope.user !=null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/blogs">MY ACCOUNT</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="/logout">LOGOUT</a>
                    </li>

                </c:when>

                <c:when test="${sessionScope.user.admin ==true}">
                    <li class="nav-item">
                        <a class="nav-link " href="/users">USERS</a>
                    </li>
                </c:when>

                <c:when test="${sessionScope.user ==null}">
                    <li class="nav-item ">
                        <a class="nav-link " href="/login">LOGIN</a>
                    </li>


                    <li class="nav-item">
                        <a class="nav-link " href="/register">REGISTER</a>
                    </li>


                </c:when>

            </c:choose>
        </ul>
    </div>
</nav>


<hr>