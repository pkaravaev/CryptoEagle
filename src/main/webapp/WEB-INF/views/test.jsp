<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/js/mdb.min.js"></script>

</head>

<style>
    .wowBack {
        background:#222;
        position:relative; overflow:hidden;
    }
    .wowWrap div {
        background:#27ae60;
        display:block;
        width:100%;
        margin:5% 0;
        text-align:center;
        padding-top:20%;
        padding-bottom:20%;
    }

    .wowWrap {
        width:16.66%;
        float:left;
        padding: 0 .5%;
    }

    .wowWrap h4{
        position:fixed;
        z-index:200;
        width:100%;
        padding:1% 0% 1% 0%;
        margin:0;
        color:white;
        font-size:1.35vw;
        background:rgba(22,22,22,.3)
    }

    .wowWrap div:first-of-type{
        margin-top:25%; }

    /*I've assigned class wHighlight to all the animate.css classes that add elements onto the page with delay.  */
    .wHighlight {background:#28a !important}

</style>

<script>

    $(document).ready(function () {
        new WOW().init();
    })



</script>




<main class="wowBack clearfix">
    <section class="wowWrap">
        <h4>Wow.js & Animate.css</h4>
        <div class="wow bounce">bounce</div>
        <div class="wow flash">flash</div>
        <div class="wow pulse">pulse</div>
        <div class="wow rubberBand">rubberBand</div>
        <div class="wow shake">shake</div>
        <div class="wow swing">swing</div>
        <div class="wow tada">tada</div>
        <div class="wow wobble">wobble</div>
        <div class="wow bounceIn">bounceIn</div>
        <div class="wow bounceInDown">bounceInDown</div>
        <div class="wow bounceInLeft">bounceInLeft</div>
        <div class="wow bounceInRight">bounceInRight</div>
        <div class="wow bounceInUp">bounceInUp</div>
        <div class="wow bounceOut">bounceOut</div>
        <div class="wow bounceOutDown">bounceOutDown</div>
        <div class="wow bounceOutLeft">bounceOutLeft</div>
        <div class="wow bounceOutRight">bounceOutRight</div>
        <div class="wow bounceOutUp">bounceOutUp</div>
        <div class="wow fadeIn">fadeIn</div>
        <div class="wow fadeInDown">fadeInDown</div>
        <div class="wow fadeInDownBig">fadeInDownBig</div>
        <div class="wow fadeInLeft">fadeInLeft</div>
        <div class="wow fadeInLeftBig">fadeInLeftBig</div>
        <div class="wow fadeInRight">fadeInRight</div>
        <div class="wow fadeInRightBig">fadeInRightBig</div>
        <div class="wow fadeInUp">fadeInUp</div>
        <div class="wow fadeInUpBig">fadeInUpBig</div>
        <div class="wow fadeOut">fadeOut</div>
        <div class="wow fadeOutDown">fadeOutDown</div>
        <div class="wow fadeOutDownBig">fadeOutDownBig</div>
        <div class="wow fadeOutLeft">fadeOutLeft</div>
        <div class="wow fadeOutLeftBig">fadeOutLeftBig</div>
        <div class="wow fadeOutRight">fadeOutRight</div>
        <div class="wow fadeOutRightBig">fadeOutRightBig</div>
        <div class="wow fadeOutUp">fadeOutUp</div>
        <div class="wow fadeOutUpBig">fadeOutUpBig</div>
        <div class="wow flip">flip</div>
        <div class="wow flipInX">flipInX</div>
        <div class="wow flipInY">flipInY</div>
        <div class="wow flipOutX">flipOutX</div>
        <div class="wow flipOutY">flipOutY</div>
        <div class="wow lightSpeedIn">lightSpeedIn</div>
        <div class="wow lightSpeedOut">lightSpeedOut</div>
        <div class="wow rotateIn">rotateIn</div>
        <div class="wow rotateInDownLeft">rotateInDownLeft</div>
        <div class="wow rotateInDownRight">rotateInDownRight</div>
        <div class="wow rotateInUpLeft">rotateInUpLeft</div>
        <div class="wow rotateInUpRight">rotateInUpRight</div>
        <div class="wow rotateOut">rotateOut</div>
        <div class="wow rotateOutDownLeft">rotateOutDownLeft</div>
        <div class="wow rotateOutDownRight">rotateOutDownRight</div>
        <div class="wow rotateOutUpLeft">rotateOutUpLeft</div>
        <div class="wow rotateOutUpRight">rotateOutUpRight</div>
        <div class="wow hinge">hinge</div>
        <div class="wow rollIn">rollIn</div>
        <div class="wow rollOut">rollOut</div>
        <div class="wow zoomIn">zoomIn</div>
        <div class="wow zoomInDown">zoomInDown</div>
        <div class="wow zoomInLeft">zoomInLeft</div>
        <div class="wow zoomInRight">zoomInRight</div>
        <div class="wow zoomInUp">zoomInUp</div>
        <div class="wow zoomOut">zoomOut</div>
        <div class="wow zoomOutDown">zoomOutDown</div>
        <div class="wow zoomOutLeft">zoomOutLeft</div>
        <div class="wow zoomOutRight">zoomOutRight</div>
        <div class="wow zoomOutUp">zoomOutUp</div>
    </section><!--


--><section class="wowWrap">
    <h4>data-wow-delay=".25s"</h4>

    <div data-wow-delay=".25s" class="wow bounce">bounce</div>
    <div data-wow-delay=".25s" class="wow flash">flash</div>
    <div data-wow-delay=".25s" class="wow pulse">pulse</div>
    <div data-wow-delay=".25s" class="wow rubberBand">rubberBand</div>
    <div data-wow-delay=".25s" class="wow shake">shake</div>
    <div data-wow-delay=".25s" class="wow swing">swing</div>
    <div data-wow-delay=".25s" class="wow tada">tada</div>
    <div data-wow-delay=".25s" class="wow wobble">wobble</div>

    <div data-wow-delay=".25s" class="wow flip">flip</div>
    <div data-wow-delay=".25s" class="wow flipOutX">flipOutX</div>
    <div data-wow-delay=".25s" class="wow flipOutY">flipOutY</div>
    <div data-wow-delay=".25s" class="wow rotateOut">rotateOut</div>
    <div data-wow-delay=".25s" class="wow rotateOutDownLeft">rotateOutDownLeft</div>
    <div data-wow-delay=".25s" class="wow rotateOutDownRight">rotateOutDownRight</div>
    <div data-wow-delay=".25s" class="wow rotateOutUpLeft">rotateOutUpLeft</div>
    <div data-wow-delay=".25s" class="wow rotateOutUpRight">rotateOutUpRight</div>
    <div data-wow-delay=".25s" class="wow bounceOut">bounceOut</div>
    <div data-wow-delay=".25s" class="wow bounceOutDown">bounceOutDown</div>
    <div data-wow-delay=".25s" class="wow bounceOutLeft">bounceOutLeft</div>
    <div data-wow-delay=".25s" class="wow bounceOutRight">bounceOutRight</div>
    <div data-wow-delay=".25s" class="wow bounceOutUp">bounceOutUp</div>
    <div data-wow-delay=".25s" class="wow fadeOut">fadeOut</div>
    <div data-wow-delay=".25s" class="wow fadeOutDown">fadeOutDown</div>
    <div data-wow-delay=".25s" class="wow fadeOutDownBig">fadeOutDownBig</div>
    <div data-wow-delay=".25s" class="wow fadeOutLeft">fadeOutLeft</div>
    <div data-wow-delay=".25s" class="wow fadeOutLeftBig">fadeOutLeftBig</div>
    <div data-wow-delay=".25s" class="wow fadeOutRight">fadeOutRight</div>
    <div data-wow-delay=".25s" class="wow fadeOutRightBig">fadeOutRightBig</div>
    <div data-wow-delay=".25s" class="wow fadeOutUp">fadeOutUp</div>
    <div data-wow-delay=".25s" class="wow fadeOutUpBig">fadeOutUpBig</div>
    <div data-wow-delay=".25s" class="wow hinge">hinge</div>
    <div data-wow-delay=".25s" class="wow rollOut">rollOut</div>
    <div data-wow-delay=".25s" class="wow zoomOut ">zoomOut</div>
    <div data-wow-delay=".25s" class="wow zoomOutDown">zoomOutDown</div>
    <div data-wow-delay=".25s" class="wow zoomOutLeft">zoomOutLeft</div>
    <div data-wow-delay=".25s" class="wow zoomOutRight">zoomOutRight</div>
    <div data-wow-delay=".25s" class="wow zoomOutUp">zoomOutUp</div>
</section><!--

--><section class="wowWrap">
    <h4>data-wow-delay=".25s"</h4>


    <div data-wow-delay=".25s" class="wow bounceIn wHighlight">bounceIn</div>
    <div data-wow-delay=".25s" class="wow bounceInDown wHighlight">bounceInDown</div>
    <div data-wow-delay=".25s" class="wow bounceInLeft wHighlight">bounceInLeft</div>
    <div data-wow-delay=".25s" class="wow bounceInRight wHighlight">bounceInRight</div>
    <div data-wow-delay=".25s" class="wow bounceInUp wHighlight">bounceInUp</div>
    <div data-wow-delay=".25s" class="wow fadeIn wHighlight">fadeIn</div>
    <div data-wow-delay=".25s" class="wow fadeInDown wHighlight">fadeInDown</div>
    <div data-wow-delay=".25s" class="wow fadeInDownBig wHighlight">fadeInDownBig</div>
    <div data-wow-delay=".25s" class="wow fadeInLeft wHighlight">fadeInLeft</div>
    <div data-wow-delay=".25s" class="wow fadeInLeftBig wHighlight">fadeInLeftBig</div>
    <div data-wow-delay=".25s" class="wow fadeInRight wHighlight">fadeInRight</div>
    <div data-wow-delay=".25s" class="wow fadeInRightBig wHighlight">fadeInRightBig</div>
    <div data-wow-delay=".25s" class="wow fadeInUp wHighlight">fadeInUp</div>
    <div data-wow-delay=".25s" class="wow fadeInUpBig wHighlight">fadeInUpBig</div>
    <div data-wow-delay=".25s" class="wow flipInX wHighlight">flipInX</div>
    <div data-wow-delay=".25s" class="wow flipInY wHighlight">flipInY</div>
    <div data-wow-delay=".25s" class="wow lightSpeedIn wHighlight">lightSpeedIn</div>
    <div data-wow-delay=".25s" class="wow rotateIn wHighlight">rotateIn</div>
    <div data-wow-delay=".25s" class="wow rotateInDownLeft wHighlight">rotateInDownLeft</div>
    <div data-wow-delay=".25s" class="wow rotateInDownRight wHighlight">rotateInDownRight</div>
    <div data-wow-delay=".25s" class="wow rotateInUpLeft wHighlight">rotateInUpLeft</div>
    <div data-wow-delay=".25s" class="wow rotateInUpRight wHighlight">rotateInUpRight</div>
    <div data-wow-delay=".25s" class="wow rollIn wHighlight">rollIn</div>
    <div data-wow-delay=".25s" class="wow zoomIn wHighlight">zoomIn</div>
    <div data-wow-delay=".25s" class="wow zoomInDown wHighlight">zoomInDown</div>
    <div data-wow-delay=".25s" class="wow zoomInLeft wHighlight">zoomInLeft</div>
    <div data-wow-delay=".25s" class="wow zoomInRight wHighlight">zoomInRight</div>
    <div data-wow-delay=".25s" class="wow zoomInUp wHighlight">zoomInUp</div>
</section><!-- --><section class="wowWrap">
    <h4>data-wow-duration="2s"<br> data-wow-iteration="100"</h4>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounce">bounce</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow flash">flash</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow pulse">pulse</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rubberBand">rubberBand</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow shake">shake</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow swing">swing</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow tada">tada</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow wobble">wobble</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceIn">bounceIn</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceInDown">bounceInDown</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceInLeft">bounceInLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceInRight">bounceInRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceInUp">bounceInUp</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceOut">bounceOut</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceOutDown">bounceOutDown</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceOutLeft">bounceOutLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceOutRight">bounceOutRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow bounceOutUp">bounceOutUp</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeIn">fadeIn</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInDown">fadeInDown</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInDownBig">fadeInDownBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInLeft">fadeInLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInLeftBig">fadeInLeftBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInRight">fadeInRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInRightBig">fadeInRightBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInUp">fadeInUp</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeInUpBig">fadeInUpBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOut">fadeOut</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutDown">fadeOutDown</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutDownBig">fadeOutDownBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutLeft">fadeOutLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutLeftBig">fadeOutLeftBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutRight">fadeOutRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutRightBig">fadeOutRightBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutUp">fadeOutUp</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow fadeOutUpBig">fadeOutUpBig</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow flip">flip</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow flipInX">flipInX</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow flipInY">flipInY</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow flipOutX">flipOutX</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow flipOutY">flipOutY</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow lightSpeedIn">lightSpeedIn</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow lightSpeedOut">lightSpeedOut</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateIn">rotateIn</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateInDownLeft">rotateInDownLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateInDownRight">rotateInDownRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateInUpLeft">rotateInUpLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateInUpRight">rotateInUpRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateOut">rotateOut</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateOutDownLeft">rotateOutDownLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateOutDownRight">rotateOutDownRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateOutUpLeft">rotateOutUpLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rotateOutUpRight">rotateOutUpRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow hinge">hinge</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rollIn">rollIn</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow rollOut">rollOut</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomIn">zoomIn</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomInDown">zoomInDown</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomInLeft">zoomInLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomInRight">zoomInRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomInUp">zoomInUp</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomOut">zoomOut</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomOutDown">zoomOutDown</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomOutLeft">zoomOutLeft</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomOutRight">zoomOutRight</div>
    <div data-wow-duration="2s" data-wow-iteration="100" class="wow zoomOutUp">zoomOutUp</div>
</section><!--


--><!--


--><section class="wowWrap">
    <h4>data-wow-iteration="100"</h4>
    <div data-wow-iteration="100" class="wow bounce">bounce</div>
    <div data-wow-iteration="100" class="wow flash">flash</div>
    <div data-wow-iteration="100" class="wow pulse">pulse</div>
    <div data-wow-iteration="100" class="wow rubberBand">rubberBand</div>
    <div data-wow-iteration="100" class="wow shake">shake</div>
    <div data-wow-iteration="100" class="wow swing">swing</div>
    <div data-wow-iteration="100" class="wow tada">tada</div>
    <div data-wow-iteration="100" class="wow wobble">wobble</div>
    <div data-wow-iteration="100" class="wow bounceIn">bounceIn</div>
    <div data-wow-iteration="100" class="wow bounceInDown">bounceInDown</div>
    <div data-wow-iteration="100" class="wow bounceInLeft">bounceInLeft</div>
    <div data-wow-iteration="100" class="wow bounceInRight">bounceInRight</div>
    <div data-wow-iteration="100" class="wow bounceInUp">bounceInUp</div>
    <div data-wow-iteration="100" class="wow bounceOut">bounceOut</div>
    <div data-wow-iteration="100" class="wow bounceOutDown">bounceOutDown</div>
    <div data-wow-iteration="100" class="wow bounceOutLeft">bounceOutLeft</div>
    <div data-wow-iteration="100" class="wow bounceOutRight">bounceOutRight</div>
    <div data-wow-iteration="100" class="wow bounceOutUp">bounceOutUp</div>
    <div data-wow-iteration="100" class="wow fadeIn">fadeIn</div>
    <div data-wow-iteration="100" class="wow fadeInDown">fadeInDown</div>
    <div data-wow-iteration="100" class="wow fadeInDownBig">fadeInDownBig</div>
    <div data-wow-iteration="100" class="wow fadeInLeft">fadeInLeft</div>
    <div data-wow-iteration="100" class="wow fadeInLeftBig">fadeInLeftBig</div>
    <div data-wow-iteration="100" class="wow fadeInRight">fadeInRight</div>
    <div data-wow-iteration="100" class="wow fadeInRightBig">fadeInRightBig</div>
    <div data-wow-iteration="100" class="wow fadeInUp">fadeInUp</div>
    <div data-wow-iteration="100" class="wow fadeInUpBig">fadeInUpBig</div>
    <div data-wow-iteration="100" class="wow fadeOut">fadeOut</div>
    <div data-wow-iteration="100" class="wow fadeOutDown">fadeOutDown</div>
    <div data-wow-iteration="100" class="wow fadeOutDownBig">fadeOutDownBig</div>
    <div data-wow-iteration="100" class="wow fadeOutLeft">fadeOutLeft</div>
    <div data-wow-iteration="100" class="wow fadeOutLeftBig">fadeOutLeftBig</div>
    <div data-wow-iteration="100" class="wow fadeOutRight">fadeOutRight</div>
    <div data-wow-iteration="100" class="wow fadeOutRightBig">fadeOutRightBig</div>
    <div data-wow-iteration="100" class="wow fadeOutUp">fadeOutUp</div>
    <div data-wow-iteration="100" class="wow fadeOutUpBig">fadeOutUpBig</div>
    <div data-wow-iteration="100" class="wow flip">flip</div>
    <div data-wow-iteration="100" class="wow flipInX">flipInX</div>
    <div data-wow-iteration="100" class="wow flipInY">flipInY</div>
    <div data-wow-iteration="100" class="wow flipOutX">flipOutX</div>
    <div data-wow-iteration="100" class="wow flipOutY">flipOutY</div>

    <div data-wow-iteration="100" class="wow lightSpeedIn">lightSpeedIn</div>
    <div data-wow-iteration="100" class="wow lightSpeedOut">lightSpeedOut</div>
    <div data-wow-iteration="100" class="wow rotateIn">rotateIn</div>
    <div data-wow-iteration="100" class="wow rotateInDownLeft">rotateInDownLeft</div>
    <div data-wow-iteration="100" class="wow rotateInDownRight">rotateInDownRight</div>
    <div data-wow-iteration="100" class="wow rotateInUpLeft">rotateInUpLeft</div>
    <div data-wow-iteration="100" class="wow rotateInUpRight">rotateInUpRight</div>
    <div data-wow-iteration="100" class="wow rotateOut">rotateOut</div>
    <div data-wow-iteration="100" class="wow rotateOutDownLeft">rotateOutDownLeft</div>
    <div data-wow-iteration="100" class="wow rotateOutDownRight">rotateOutDownRight</div>
    <div data-wow-iteration="100" class="wow rotateOutUpLeft">rotateOutUpLeft</div>
    <div data-wow-iteration="100" class="wow rotateOutUpRight">rotateOutUpRight</div>
    <div data-wow-iteration="100" class="wow hinge">hinge</div>
    <div data-wow-iteration="100" class="wow rollIn">rollIn</div>
    <div data-wow-iteration="100" class="wow rollOut">rollOut</div>
    <div data-wow-iteration="100" class="wow zoomIn">zoomIn</div>
    <div data-wow-iteration="100" class="wow zoomInDown">zoomInDown</div>
    <div data-wow-iteration="100" class="wow zoomInLeft">zoomInLeft</div>
    <div data-wow-iteration="100" class="wow zoomInRight">zoomInRight</div>
    <div data-wow-iteration="100" class="wow zoomInUp">zoomInUp</div>
    <div data-wow-iteration="100" class="wow zoomOut">zoomOut</div>
    <div data-wow-iteration="100" class="wow zoomOutDown">zoomOutDown</div>
    <div data-wow-iteration="100" class="wow zoomOutLeft">zoomOutLeft</div>
    <div data-wow-iteration="100" class="wow zoomOutRight">zoomOutRight</div>
    <div data-wow-iteration="100" class="wow zoomOutUp">zoomOutUp</div>
</section><!--

--><section class="wowWrap">
    <h4>wow-data-offset="200"</h4>
    <div data-wow-offset="200" class="wow bounce">bounce</div>
    <div data-wow-offset="200" class="wow flash">flash</div>
    <div data-wow-offset="200" class="wow pulse">pulse</div>
    <div data-wow-offset="200" class="wow rubberBand">rubberBand</div>
    <div data-wow-offset="200" class="wow shake">shake</div>
    <div data-wow-offset="200" class="wow swing">swing</div>
    <div data-wow-offset="200" class="wow tada">tada</div>
    <div data-wow-offset="200" class="wow wobble">wobble</div>
    <div data-wow-offset="200" class="wow bounceIn">bounceIn</div>
    <div data-wow-offset="200" class="wow bounceInDown">bounceInDown</div>
    <div data-wow-offset="200" class="wow bounceInLeft">bounceInLeft</div>
    <div data-wow-offset="200" class="wow bounceInRight">bounceInRight</div>
    <div data-wow-offset="200" class="wow bounceInUp">bounceInUp</div>
    <div data-wow-offset="200" class="wow bounceOut">bounceOut</div>
    <div data-wow-offset="200" class="wow bounceOutDown">bounceOutDown</div>
    <div data-wow-offset="200" class="wow bounceOutLeft">bounceOutLeft</div>
    <div data-wow-offset="200" class="wow bounceOutRight">bounceOutRight</div>
    <div data-wow-offset="200" class="wow bounceOutUp">bounceOutUp</div>
    <div data-wow-offset="200" class="wow fadeIn">fadeIn</div>
    <div data-wow-offset="200" class="wow fadeInDown">fadeInDown</div>
    <div data-wow-offset="200" class="wow fadeInDownBig">fadeInDownBig</div>
    <div data-wow-offset="200" class="wow fadeInLeft">fadeInLeft</div>
    <div data-wow-offset="200" class="wow fadeInLeftBig">fadeInLeftBig</div>
    <div data-wow-offset="200" class="wow fadeInRight">fadeInRight</div>
    <div data-wow-offset="200" class="wow fadeInRightBig">fadeInRightBig</div>
    <div data-wow-offset="200" class="wow fadeInUp">fadeInUp</div>
    <div data-wow-offset="200" class="wow fadeInUpBig">fadeInUpBig</div>
    <div data-wow-offset="200" class="wow fadeOut">fadeOut</div>
    <div data-wow-offset="200" class="wow fadeOutDown">fadeOutDown</div>
    <div data-wow-offset="200" class="wow fadeOutDownBig">fadeOutDownBig</div>
    <div data-wow-offset="200" class="wow fadeOutLeft">fadeOutLeft</div>
    <div data-wow-offset="200" class="wow fadeOutLeftBig">fadeOutLeftBig</div>
    <div data-wow-offset="200" class="wow fadeOutRight">fadeOutRight</div>
    <div data-wow-offset="200" class="wow fadeOutRightBig">fadeOutRightBig</div>
    <div data-wow-offset="200" class="wow fadeOutUp">fadeOutUp</div>
    <div data-wow-offset="200" class="wow fadeOutUpBig">fadeOutUpBig</div>
    <div data-wow-offset="200" class="wow flip">flip</div>
    <div data-wow-offset="200" class="wow flipInX">flipInX</div>
    <div data-wow-offset="200" class="wow flipInY">flipInY</div>
    <div data-wow-offset="200" class="wow flipOutX">flipOutX</div>
    <div data-wow-offset="200" class="wow flipOutY">flipOutY</div>
    <div data-wow-offset="200" class="wow lightSpeedIn">lightSpeedIn</div>
    <div data-wow-offset="200" class="wow lightSpeedOut">lightSpeedOut</div>
    <div data-wow-offset="200" class="wow rotateIn">rotateIn</div>
    <div data-wow-offset="200" class="wow rotateInDownLeft">rotateInDownLeft</div>
    <div data-wow-offset="200" class="wow rotateInDownRight">rotateInDownRight</div>
    <div data-wow-offset="200" class="wow rotateInUpLeft">rotateInUpLeft</div>
    <div data-wow-offset="200" class="wow rotateInUpRight">rotateInUpRight</div>
    <div data-wow-offset="200" class="wow rotateOut">rotateOut</div>
    <div data-wow-offset="200" class="wow rotateOutDownLeft">rotateOutDownLeft</div>
    <div data-wow-offset="200" class="wow rotateOutDownRight">rotateOutDownRight</div>
    <div data-wow-offset="200" class="wow rotateOutUpLeft">rotateOutUpLeft</div>
    <div data-wow-offset="200" class="wow rotateOutUpRight">rotateOutUpRight</div>
    <div data-wow-offset="200" class="wow hinge">hinge</div>
    <div data-wow-offset="200" class="wow rollIn">rollIn</div>
    <div data-wow-offset="200" class="wow rollOut">rollOut</div>
    <div data-wow-offset="200" class="wow zoomIn">zoomIn</div>
    <div data-wow-offset="200" class="wow zoomInDown">zoomInDown</div>
    <div data-wow-offset="200" class="wow zoomInLeft">zoomInLeft</div>
    <div data-wow-offset="200" class="wow zoomInRight">zoomInRight</div>
    <div data-wow-offset="200" class="wow zoomInUp">zoomInUp</div>
    <div data-wow-offset="200" class="wow zoomOut">zoomOut</div>
    <div data-wow-offset="200" class="wow zoomOutDown">zoomOutDown</div>
    <div data-wow-offset="200" class="wow zoomOutLeft">zoomOutLeft</div>
    <div data-wow-offset="200" class="wow zoomOutRight">zoomOutRight</div>
    <div data-wow-offset="200" class="wow zoomOutUp">zoomOutUp</div>
</section><!--
--></main>




<!--
ALL CHOICES
bounce
flash
pulse
rubberBand
shake
swing
tada
wobble
bounceIn
bounceInDown
bounceInLeft
bounceInRight
bounceInUp
bounceOut
bounceOutDown
bounceOutLeft
bounceOutRight
bounceOutUp
fadeIn
fadeInDown
fadeInDownBig
fadeInLeft
fadeInLeftBig
fadeInRight
fadeInRightBig
fadeInUp
fadeInUpBig
fadeOut
fadeOutDown
fadeOutDownBig
fadeOutLeft
fadeOutLeftBig
fadeOutRight
fadeOutRightBig
fadeOutUp
fadeOutUpBig
flip
flipInX
flipInY
flipOutX
flipOutY
lightSpeedIn
lightSpeedOut
rotateIn
rotateInDownLeft
rotateInDownRight
rotateInUpLeft
rotateInUpRight
rotateOut
rotateOutDownLeft
rotateOutDownRight
rotateOutUpLeft
rotateOutUpRight
hinge
rollIn
rollOut
zoomIn
zoomInDown
zoomInLeft
zoomInRight
zoomInUp
zoomOut
zoomOutDown
zoomOutLeft
zoomOutRight
zoomOutUp


-->