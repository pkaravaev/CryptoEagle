<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<script>

    $(document).ready(function () {


        $(".card").mouseenter(function () {
            $(this).css("cursor", "hand");
        })

        $(".card").mouseleave(function () {
            $(this).css("cursor", "point");
        })

        $(".card").dblclick(function () {

            var name = $(this).find(".href").text();
            window.location.href = "/ico-page/" + name;

        })

        $(".card").contextmenu(function () {

        })

        $("#button").click(function () {

            window.location.href = "/ico-stats";
        })
    })

</script>


<div class="container  bg-white">

    <div class="row">

        <br/>

        <div class="col-md-4">
            <br/>
            <h3 class="text-center font-weight-bold">ACTIVE</h3>


            <c:forEach items="${activeIco}" var="ico">
                <!--Panel-->
                <div style="width: 22rem; height: 10rem" class="card hoverable">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <br/>
                                <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                                <br/>
                                <br/>
                                <p class="text-left">

                                    <c:choose>
                                        <c:when test="${ico.rating < 4} ">
                                            <small style="color: orangered">rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating > 4 && ico.rating < 4.5}">
                                            <small style="color: orange">rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating > 4.5}">
                                            <small style="color: green">rating ${ico.rating}</small>
                                        </c:when>

                                    </c:choose>

                                </p>
                            </div>
                            <div class="col">
                                <h5 class="card-title text-center font-weight-bold">${ico.name}</h5>
                                <h6 class="card-title text-center font-italic">${ico.data.getCategories("name")}</h6>
                                <%--<h6 class="card-title text-center">--%>
                                    <%--<small>${ico.data.getFinance("raised")}/${ico.data.getFinance("hardcap")}</small>--%>
                                <%--</h6>--%>
                            </div>
                            <div class="col">
                                <p class="text-right">
                                    <small>${ Math.abs(ico.todayMinusIcoEnd())}d left</small>
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

        <div class="col-md-4">
            <br/>
            <h3 class="text-center font-weight-bold">UPCOMING</h3>
            <c:forEach items="${upcoming}" var="ico">
                <!--Panel-->
                <div style="width: 22rem; height: 10rem" class="card hoverable">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <br/>
                                <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                                <br/>
                                <br/>
                                <p class="text-left">
                                    <small>rating ${ico.rating}</small>
                                </p>
                            </div>
                            <div class="col">
                                <h5 class="card-title text-center font-weight-bold">${ico.name}</h5>
                                <h6 class="card-title text-center font-italic">${ico.data.getCategories("name")}</h6>
                                <%--<h6 class="card-title text-center">--%>
                                    <%--<small>${ico.data.getFinance("raised")}/${ico.data.getFinance("hardcap")}</small>--%>
                                <%--</h6>--%>
                            </div>
                            <div class="col">
                                <p class="text-right">
                                    <small>Starts ${ Math.abs(ico.todayMinusIcoStart())}d</small>
                                </p>
                            </div>
                            <p hidden>${ico.website_link}</p>
                            <p class="href" hidden>${ico.name}</p>
                        </div>
                    </div>
                </div>
                <!--/.Panel-->
                <br/>
            </c:forEach>
        </div>

        <div class="col-md-4">
            <br/>
            <h3 class="text-center font-weight-bold brown-darken-2 ">ENDED</h3>
            <c:forEach items="${finished}" var="ico">
                <!--Panel-->
                <div style="width: 22rem; height: 10rem" class="card hoverable">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <br/>
                                <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                                <br/>
                                <br/>
                                <p class="text-left">
                                    <small>rating ${ico.rating}</small>
                                </p>
                            </div>
                            <div class="col">
                                <h5 class="card-title text-center font-weight-bold">${ico.name}</h5>
                                <h6 class="card-title text-center font-italic">${ico.data.getCategories("name")}</h6>
                                <%--<h6 class="card-title text-center">--%>
                                    <%--<small>${ico.data.getFinance("raised")}/${ico.data.getFinance("hardcap")}</small>--%>
                                <%--</h6>--%>
                            </div>
                            <div class="col">
                                <p class="text-right">
                                    <small>Ended ${ico.todayMinusIcoEnd()}d</small>
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

    </div>

    <button id="button" style="width: 71rem" type="button" class="btn btn-brown btn-lg btn-block">GO MORE ICO</button>

    <br/>

</div>


<jsp:include page="template/footer.jsp"/>