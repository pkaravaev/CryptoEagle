<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="/resources/css/core-style.css">
    <link rel="stylesheet" href="/resources/css/style.css">

    <!-- Responsive CSS -->
    <link href="/resources/css/css/responsive.css" rel="stylesheet">

</head>

<body>


<header class="header-area">
    <div class="top-header">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <!-- Breaking News Area -->
                <div class="col-12 col-md-6">
                    <div class="breaking-news-area">
                        <h5 class="breaking-news-title">Breaking news</h5>

                    </div>
                </div>
                <!-- Stock News Area -->
                <div class="col-12 col-md-6">
                    <div class="stock-news-area">
                        <div id="stockNewsTicker" class="ticker">
                            <ul>
                                <li>
                                    <div class="single-stock-report">
                                        <div class="stock-values">
                                            <span>eur/usd</span>
                                            <span>1.1862</span>
                                        </div>
                                        <div class="stock-index minus-index">
                                            <h4>%0.18</h4>
                                        </div>
                                    </div>
                                    <div class="single-stock-report">
                                        <div class="stock-values">
                                            <span>BTC/usd</span>
                                            <span>15.674.99</span>
                                        </div>
                                        <div class="stock-index plus-index">
                                            <h4>8.60</h4>
                                        </div>
                                    </div>
                                    <div class="single-stock-report">
                                        <div class="stock-values">
                                            <span>ETH/usd</span>
                                            <span>674.99</span>
                                        </div>
                                        <div class="stock-index minus-index">
                                            <h4>13.60</h4>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>


<!-- jQuery (Necessary for All JavaScript Plugins) -->
<script src="/resources/js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="/resources/js/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="/resources/js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="/resources/js/plugins.js"></script>
<!-- Active js -->
<script src="/resources/js/active.js"></script>

</body>