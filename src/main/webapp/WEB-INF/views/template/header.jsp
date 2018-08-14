<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglib.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">
    <!-- MDBootstrap Datatables  -->
    <link href="/resources/css/addons/datatables.min.css" rel="stylesheet">


    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/js/mdb.min.js"></script>
    <!-- MDBootstrap Datatables  -->
    <script type="text/javascript" src="/resources/js/addons/datatables.min.js"></script>



    <script src="/resources/js/table.js"></script>
    <script src="/resources/js/coins.js"></script>

    <title>Welcome</title>
</head>
<body class="body  ">


<script>
    $(document).ready(function () {
        $("#eagle").click(function () {
            window.location.href = "/";
        })
    })
</script>

<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark brown  ">

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
                    <a class="nav-link" href="/ico-list">ICO LIST</a>
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
                    <a class="nav-link" href="/ico-stats">ICO STATS</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/whitelists">WHITELIST</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/events">EVENTS</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">ANALITICS</a>
                </li>

                <li class="nav-item">
                    <a id="login" class="nav-link" href="#modalLRForm">Login</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>

            </ul>
            <!-- Links -->

        </div>
    </div>

</nav>

<ul class="nav justify-content-center font-weight-bold brown darken-2">
    <li class="nav-item">
        <a id="BTC" class="nav-link" href="/coin-list"><p class="red-text">active</p></a>
    </li>
    <li class="nav-item">
        <a id="ETH" class="nav-link" href="/coin-list"><p class="white-text">active</p></a>
    </li>
    <li class="nav-item">
        <a id="NEO" class="nav-link" href="/coin-list"><p class="white-text">active</p></a>
    </li>
    <li class="nav-item">
        <a id="XRP" class="nav-link " href="/coin-list"><p class="white-text">active</p></a>
    </li>
    <li class="nav-item">
        <a id="EOS" class="nav-link " href="/coin-list"><p class="white-text">active</p></a>
    </li>

</ul>


<!--Modal: Login / Register Form-->
<div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog cascading-modal" role="document">
        <!--Content-->
        <div class="modal-content">

            <!--Modal cascading tabs-->
            <div class="modal-c-tabs">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs tabs-2  brown darken-2" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#panel7" role="tab"><i
                                class="fa fa-user mr-1"></i> Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#panel8" role="tab"><i
                                class="fa fa-user-plus mr-1"></i> Register</a>
                    </li>
                </ul>

                <!-- Tab panels -->
                <div class="tab-content">
                    <!--Panel 7-->
                    <div class="tab-pane fade in show active" id="panel7" role="tabpanel">

                        <!--Body-->
                        <div class="modal-body mb-1">

                            <div class="md-form form-sm mb-5">
                                <i class="fa fa-envelope prefix"></i>
                                <input name="email" type="email" id="modalLRInput10" class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput10">Your email</label>
                            </div>


                            <div class="md-form form-sm mb-4">
                                <i class="fa fa-lock prefix"></i>
                                <input name="password" type="password" id="modalLRInput11"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput11">Your
                                    password</label>
                            </div>


                            <div class="text-center mt-2">
                                <button type="submit" id="log" formaction="/login" formmethod="post" class="btn  btn-brown">Log in <i class="fa fa-sign-in ml-1"></i></button>
                            </div>

                        </div>
                        <!--Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-brown waves-effect ml-auto"
                                    data-dismiss="modal">Close
                            </button>
                        </div>

                    </div>
                    <!--/.Panel 7-->

                    <!--Panel 8-->
                    <div class="tab-pane fade" id="panel8" role="tabpanel">

                        <!--Body-->
                        <div class="modal-body">

                            <div class="md-form form-sm mb-5">
                                <i class="fa fa-user prefix"></i>
                                <input name="name" type="text" id="modalLRInput16" class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput12">Your name</label>
                            </div>
                            <div class="md-form form-sm mb-5">
                                <i class="fa fa-envelope prefix"></i>
                                <input name="email" type="email" id="modalLRInput12" class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput12">Your email</label>
                            </div>

                            <div class="md-form form-sm mb-5">
                                <i class="fa fa-lock prefix"></i>
                                <input name="password" type="password" id="modalLRInput13"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput13">Your
                                    password</label>
                            </div>

                            <div class="md-form form-sm mb-4">
                                <i class="fa fa-lock prefix"></i>
                                <input name="repeatpassword" type="password" id="modalLRInput14"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput14">Repeat
                                    password</label>
                            </div>

                            <div class="text-center form-sm mt-2">
                                <button id="reg" class="btn btn-brown">Sign up <i class="fa fa-sign-in ml-1"></i></button>
                            </div>

                        </div>

                        <!--Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-brown waves-effect ml-auto"
                                    data-dismiss="modal">Close
                            </button>
                        </div>
                    </div>
                    <!--/.Panel 8-->
                </div>

            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
<!--Modal: Login / Register Form-->


