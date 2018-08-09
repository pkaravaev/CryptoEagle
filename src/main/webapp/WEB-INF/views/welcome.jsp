<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<br/>

<script>

    $(document).ready(function () {
        $(".card").dblclick(function () {
            var href = $(this).find(".href").text();
            $(location).attr("href", href);
        })
        $(".card").mouseenter(function () {
            $(this).css('cursor', 'pointer');
            $(this).addClass("animated shake")
            $(".container").addClass("animated shake")
        })
    })

    $(document).ready(function () {

        new WOW().init();

        $(".card").click(function () {
            $(this).css('cursor', 'pointer');
            var title = $(this).find(".title").text();
            var description = $(this).find(".description").text();
            var date = $(this).find(".date").text();
            if ($(".card-img-overlay ").hasClass("animated bounceInUp")) {
                $(".card-img-overlay ").removeClass("animated bounceInUp")
                $(".card-img-overlay ").addClass("animated fadeOutUp")
            } else {

                $(this).append("<div class=\"card-img-overlay  animated bounceInUp\">\n" +
                    "                    <h4 class=\"card-title text-white brown darken-2\">" + title + " </h4>\n" +
                    "                    <p class=\"card-text text-white brown darken-2\"> " + description + " </p>\n" +
                    "                    <p class=\"card-text text-white brown darken-2\"> " + date + " </p>\n" +
                    "                </div>")
            }
        })
        $(".card").mouseleave(function () {
            $(this).find(".card-img-overlay").removeClass("animated bounceInUp").removeClass("animated shake").addClass("animated fadeOutDown");
            $(this).removeClass("animated shake");
        })
    })
</script>

<style>
    .timeline {
        list-style: none;
        padding: 20px 0 20px;
        position: relative;
    }

    .timeline:before {
        top: 0;
        bottom: 0;
        position: absolute;
        content: " ";
        width: 3px;
        background-color: #eeeeee;
        left: 50%;
        margin-left: -1.5px;
    }

    .timeline > li {
        margin-bottom: 20px;
        position: relative;
    }

    .timeline > li:before,
    .timeline > li:after {
        content: " ";
        display: table;
    }

    .timeline > li:after {
        clear: both;
    }

    .timeline > li:before,
    .timeline > li:after {
        content: " ";
        display: table;
    }

    .timeline > li:after {
        clear: both;
    }

    .timeline > li > .timeline-panel {
        width: 46%;
        float: left;
        border: 1px solid #d4d4d4;
        border-radius: 2px;
        padding: 20px;
        position: relative;
        -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
        box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
    }

    .timeline > li > .timeline-panel:before {
        position: absolute;
        top: 26px;
        right: -15px;
        display: inline-block;
        border-top: 15px solid transparent;
        border-left: 15px solid #ccc;
        border-right: 0 solid #ccc;
        border-bottom: 15px solid transparent;
        content: " ";
    }

    .timeline > li > .timeline-panel:after {
        position: absolute;
        top: 27px;
        right: -14px;
        display: inline-block;
        border-top: 14px solid transparent;
        border-left: 14px solid #fff;
        border-right: 0 solid #fff;
        border-bottom: 14px solid transparent;
        content: " ";
    }

    .timeline > li > .timeline-badge {
        color: #fff;
        width: 50px;
        height: 50px;
        line-height: 50px;
        font-size: 1.4em;
        text-align: center;
        position: absolute;
        top: 16px;
        left: 50%;
        margin-left: -25px;
        background-color: #999999;
        z-index: 100;
        border-top-right-radius: 50%;
        border-top-left-radius: 50%;
        border-bottom-right-radius: 50%;
        border-bottom-left-radius: 50%;
    }

    .timeline > li.timeline-inverted > .timeline-panel {
        float: right;
    }

    .timeline > li.timeline-inverted > .timeline-panel:before {
        border-left-width: 0;
        border-right-width: 15px;
        left: -15px;
        right: auto;
    }

    .timeline > li.timeline-inverted > .timeline-panel:after {
        border-left-width: 0;
        border-right-width: 14px;
        left: -14px;
        right: auto;
    }

    .timeline-badge.primary {
        background-color: #2e6da4 !important;
    }

    .timeline-badge.success {
        background-color: #3f903f !important;
    }

    .timeline-badge.warning {
        background-color: #f0ad4e !important;
    }

    .timeline-badge.danger {
        background-color: #d9534f !important;
    }

    .timeline-badge.info {
        background-color: #5bc0de !important;
    }

    .timeline-title {
        margin-top: 0;
        color: inherit;
    }

    .timeline-body > p,
    .timeline-body > ul {
        margin-bottom: 0;
    }

    .timeline-body > p + p {
        margin-top: 5px;
    }

    @media (max-width: 767px) {
        ul.timeline:before {
            left: 40px;
        }

        ul.timeline > li > .timeline-panel {
            width: calc(100% - 90px);
            width: -moz-calc(100% - 90px);
            width: -webkit-calc(100% - 90px);
        }

        ul.timeline > li > .timeline-badge {
            left: 15px;
            margin-left: 0;
            top: 16px;
        }

        ul.timeline > li > .timeline-panel {
            float: right;
        }

        ul.timeline > li > .timeline-panel:before {
            border-left-width: 0;
            border-right-width: 15px;
            left: -15px;
            right: auto;
        }

        ul.timeline > li > .timeline-panel:after {
            border-left-width: 0;
            border-right-width: 14px;
            left: -14px;
            right: auto;
        }
    }
</style>


<div class="container bg-white animated shake">

    <div class="row">
        <div class="col-">

        </div>

        <div class="col">

            <h4 class="font-weight-bold">CRYPTO NEWS</h4>
            <hr style="size: 4rem" color="#795548"/>

            <div id="bigCard" class="card hoverable rounded example job ">
                <img style="height: 15rem" alt="Card image cap" class="card-img-top img-fluid"
                     src="/resources/pic/l/l${main.getRandomPic(5)}.jpg">

                <div class="card-block">
                    <h4 class="card-title font-weight-bold ">${main.title}</h4>
                    <p class="date text-right font-weight-light">${item.publishDate}</p>
                </div>


                <p class="title" hidden>${main.title}</p>
                <p class="description" hidden>${main.description}</p>
                <p class="date" hidden>${main.publishDate}</p>
                <p class="href" hidden>${main.link}</p>
            </div>

            <br/>

            <div class="card-deck">
                <c:forEach items="${middle}" var="item">
                    <div style="height: 20rem;width: 20rem" class="card hoverable ">
                        <img style="width: 22rem;height: 12rem" alt="Card image cap" class="card-img-top img-fluid "
                             src="/resources/pic/m/m${item.getRandomPic(5)}.jpg">
                        <div class="card-block">
                            <h4 class="card-title font-weight-bold">${main.title}</h4>
                        </div>

                        <p class="title" hidden>${item.title}</p>
                        <p class="description" hidden>${item.description}</p>
                        <p class="href" hidden>${item.link}</p>

                        <div class="row">
                            <div class="col">
                                <p style="margin-left: 1rem" class="date text-left font-italic">by ${item.source}</p>
                            </div>
                            <div class="col">
                                <p style="margin-right: 1rem" class="date text-right font-italic">10 min ago</p>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>

        </div>

        <br/>
        <br/>

        <div class="col-4 ">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs nav-justified " role="tablist">
                <li class="nav-item">
                    <a class="nav-link active  brown " data-toggle="tab" href="#panel5" role="tab">
                        <i class="fa fa-sort-up"></i> TOP GAINS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link  brown " data-toggle="tab" href="#panel6" role="tab">
                        <i class="fa fa-sort-down"></i> TOP LOOSERS</a>
                </li>
            </ul>
            <!-- Nav tabs -->
            <!-- Tab panels -->
            <div class="tab-content font-weight-bold">
                <!--Panel 1-->
                <div class="tab-pane fade  in show active" id="panel5" role="tabpanel">
                    <table class="table h-50">
                        <tbody>
                        <c:forEach items="${topcoins}" var="coin">
                            <tr>
                                <th><p class="font-weight-bold">${coin.symbol}</p></th>
                                <td><p class="font-weight-bold">${coin.price}</p></td>
                                <c:if test="${coin.percent_change_7d > 0}">
                                    <td><p style="color: green" class="font-weight-bold">${coin.percent_change_7d}%</p>
                                    </td>
                                </c:if>
                                <c:if test="${coin.percent_change_7d < 0}">
                                    <td><p style="color: red" class="font-weight-bold">${coin.percent_change_7d}%</p>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!--/.Panel 1-->
                <!--Panel 2-->
                <div class="tab-pane fade " id="panel6" role="tabpanel">
                    <div class="tab-pane fade in show " id="panel" role="tabpanel">
                        <table class="table ">
                            <tbody>
                            <c:forEach items="${losercoins}" var="coin">
                                <tr>
                                    <th><p class="font-weight-bold">${coin.symbol}</p></th>
                                    <td><p class="font-weight-bold">${coin.price}</p></td>
                                    <c:if test="${coin.percent_change_7d > 0}">
                                        <td><p style="color: green"
                                               class="font-weight-bold">${coin.percent_change_7d}%</p></td>
                                    </c:if>
                                    <c:if test="${coin.percent_change_7d < 0}">
                                        <td><p style="color: red"
                                               class="font-weight-bold">${coin.percent_change_7d}%</p></td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--/.Panel 2-->
            </div>
            <!-- Tab panels -->
        </div>
    </div>

    <div class="row">
        <div class="col">
            <br/>
            <div class="card-columns">

                <c:forEach items="${items}" var="item" varStatus="i">
                    <!--Panel-->
                    <div style="height: 20rem;width: 22rem" class="card hoverable ">
                        <img style="width: 22rem;height: 12rem" alt="Card  image cap" class="card-img-top img-fluid"
                             src="/resources/pic/m/m${i.count}.jpg">
                        <div class="card-block ">
                            <h4 class="card-title font-weight-bold ">${item.title}</h4>
                        </div>
                        <p class="title" hidden>${item.title}</p>
                        <p class="description" hidden>${item.description}</p>
                        <p class="href" hidden>${item.link}</p>

                        <div class="row">
                            <div class="col">
                                <p style="margin-left: 1rem" class="date text-left font-italic">by ${item.source}</p>
                            </div>
                            <div class="col">
                                <p style="margin-right: 1rem" class="date text-right font-italic">10 min ago</p>
                            </div>
                        </div>
                    </div>
                    <!--Panel-->
                </c:forEach>
            </div>

            <h4 class="font-weight-bold wow fadeInUp hoverable">HOT ICO</h4>

            <hr style="size: 4rem" color="#795548"/>


            <div class="card-columns">

                <c:forEach items="${icos}" var="ico">
                    <!--Panel-->
                    <div class="card hoverable">
                        <div class="card-body">
                            <div class="row">
                                <div class="col">
                                    <br/>
                                    <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                                    <br/>
                                    <br/>
                                    <p class="text-left">
                                        <small>not rated</small>
                                    </p>
                                </div>
                                <div class="col">
                                    <h5 class="card-title text-center font-weight-bold">${ico.name}</h5>
                                    <h6 class="card-title text-center font-italic">${ico.data.getCategories("name")}</h6>
                                        <%--<h7 class="card-title text-center"><small>${ico.data.getFinance("raised")}/${ico.data.getFinance("hardcap")}</small></h7>--%>
                                </div>
                                <div class="col">
                                    <p class="text-right">
                                        <small>End10d</small>
                                    </p>
                                </div>
                            </div>
                            <p class="href" hidden>${ico.name}</p>


                        </div>
                    </div>
                    <!--/.Panel-->
                    <br/>
                </c:forEach>
            </div>

            <h4 class="font-weight-bold wow fadeInUp hoverable">UPCOMING EVENTS</h4>
            <hr style="size: 4rem" color="#795548"/>

        </div>

    </div>

</div>

<div class="container">
    <ul class="timeline">
        <c:forEach items="${events}" var="event" varStatus="i">
            <c:choose>
                <c:when test="${(i.count%2) ==0}">
                    <li class="timeline-inverted ">
                </c:when>
                <c:otherwise>
                    <li >
                </c:otherwise>
            </c:choose>
            <div class="timeline-badge brown wow "><i class="glyphicon glyphicon-check"></i></div>
            <div class="timeline-panel hoverable wow">
                <div class="timeline-heading">
                    <h4 class="timeline-title wow">${event.title}</h4>
                    <i style="color: red"
                                                                      class="fas fa-top fa-fire fa-2x"></i>
                    <p>
                        <small class="text-muted"><i class="glyphicon glyphicon-time"></i> ${event.date_event}
                        </small>
                    </p>
                </div>
                <div class="timeline-body wow">
                    <p>${event.description}</p>
                </div>
            </div>
            </li>

        </c:forEach>

    </ul>
</div>


<jsp:include page="template/footer.jsp"/>