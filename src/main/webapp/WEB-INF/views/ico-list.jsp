<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<style>

</style>

<script>

    $(document).ready(function () {

        document.oncontextmenu = function() {return false;};

        $(".card").mouseenter(function () {
            $(this).css("cursor", "hand");
        })
        $(".card").mouseleave(function () {
            $(this).css("cursor", "point");
        })

        $(".card").click(function () {

            var name = $(this).find(".href").text();;
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

        <div class="col-md-4">

            <h2 class="text-center font-weight-bold">ACTIVE</h2>

            <c:forEach items="${activeIco}" var="ico">
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
                                    <small>End ${ico.todayMinusIcoEnd()} d</small>
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
            <h2 class="text-center font-weight-bold">UPCOMING</h2>
            <c:forEach items="${upcoming}" var="ico">
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
                                    <small>Starts ${ico.todayMinusIcoStart()}d</small>
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
            <h2 class="text-center font-weight-bold brown-darken-2 ">ENDED</h2>
            <c:forEach items="${finished}" var="ico">
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