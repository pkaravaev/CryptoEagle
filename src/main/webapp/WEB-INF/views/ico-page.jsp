<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="template/header.jsp"/>


<style>
    .card {
        height: 13rem;
        width: 8rem;
    }

    .card-columns {
        column-count: 4;
    }

    strong {

        font-weight: bold;
    }

    i{
        color: #795548 ;
    }

</style>


<script>
    $(document).ready(function () {
        $(".card").mouseenter(function () {
            $(this).css('cursor', 'pointer');
            $(this).removeClass("bg-white");
            $(this).addClass("bg-light")
        })

        $(".card").mouseleave(function () {
            $(this).removeClass("bg-light");
            $(this).addClass("bg-white")
        })

        $(".card").click(function () {
            var name = $(this).find("a").text();
            window.location = name;
        })

    })
</script>

<br/>
<div class="container bg-white ">
    <br/>

    <div class="row">

        <div class="col-md">

        </div>

        <div class="col-md-10">

            <div class="row">

                <div class="col-md">
                    <img width="120rem" height="120rem" class="img" src="${ico.logolink}"
                         alt="error"/>
                </div>
                <div class="col-md-10">
                    <h5 class="title">${ico.name} (${ico.data.getCategories("name")})</h5>
                    <p class="text">${ico.data.intro}</p>
                </div>
                <br/>

            </div>
            <br/>
            <hr/>
            <div class="row">

                <div class="col-md-7">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="${ico.data.getLink("youtube")}"
                                allowfullscreen></iframe>
                    </div>
                </div>

                <div class="col-md">

                    <div class="card border-white text-center" style="width: 18rem;">

                        <ul class="list-group list-group-flush">

                            <li class="list-group-item">

                                <fmt:parseDate value="${ico.icoStart}" pattern="yyyy-MM-dd'T'HH:mm"
                                               var="parsIcoStart"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsIcoStart}" var="icoStart"/>


                                <fmt:parseDate value="${ico.icoEnd}" pattern="yyyy-MM-dd'T'HH:mm" var="parsIcoEnd"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsIcoEnd}" var="icoEnd"/>


                                <fmt:parseDate value="${ico.preIcoStart}" pattern="yyyy-MM-dd'T'HH:mm"
                                               var="parsPreIcoStart"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsPreIcoStart}"
                                                var="preIcoStart"/>


                                <fmt:parseDate value="${ico.preIcoEnd}" pattern="yyyy-MM-dd'T'HH:mm"
                                               var="parsPreIcoEnd"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsPreIcoEnd}"
                                                var="preIcoEnd"/>

                                <h6 class="text-left">Toke sales : Ended</h6>
                                <h6 class="text-left">Toke pre sale : <strong> ${preIcoStart}</strong></h6>
                                <h6 class="text-left">Toke end pre sale : <strong>${preIcoEnd}</strong></h6>
                                <h6 class="text-left">Toke start sale : <strong>${icoStart}</strong></h6>
                                <h6 class="text-left">Toke end sale : <strong>${icoEnd}</strong></h6>
                            </li>

                            <li class="list-group-item">
                                <button value="${ico.data.getLink("whitepaper")}" type="button"
                                        class="btn btn-brown btn-sm">Web site
                                </button>
                            </li>

                            <li class="list-group-item">
                                <button value="${ico.data.getLink("www")}" type="button"
                                        class="btn btn-brown btn-sm">White list
                                </button>
                            </li>

                            <li class="list-group-item  ">

                                <a href="${ico.data.getLink("twitter")}" class="icon-block">
                                    <i class="fab fa-twitter fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("slack")}" class="icon-block">
                                    <i class="fab fa-slack fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("facebook")}" class="icon-block">
                                    <i  class="fab fa-facebook fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("youtube")}" class="icon-block">
                                    <i class="fab fa-youtube fa-lg "></i>
                                </a>
                                <a href="${ico.data.getLink("telegram")}" class="icon-block">
                                    <i class="fab fa-telegram fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("github")}" class="icon-block">
                                    <i class="fab fa-github fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("reddit")}" class="icon-block">
                                    <i class="fab fa-reddit fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("medium")}" class="icon-block">
                                    <i class="fab fa-medium fa-lg"></i>
                                </a>

                            </li>

                        </ul>
                    </div>
                </div>
            </div>

            <br/>

            <ul class="nav nav-pills  justify-content-center mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link  active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab"
                       aria-controls="pills-home" aria-selected="true">Finance</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab"
                       aria-controls="pills-profile" aria-selected="false">Teams</a>
                </li>
            </ul>

            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                     aria-labelledby="pills-home-tab">
                    <div class="row">

                        <div class="col info">
                            <p class="font-weight">Token : <strong> ${ico.data.getFinance("token") } </strong></p>
                            <p class="font-weight">Price :<strong> ${ico.data.getFinance("price")}</strong></p>
                            <p class="font-weight">Tokens:<strong> ${ico.data.getFinance("tokens")}</strong></p>
                            <p class="font-weight">Hard cap :<strong> ${ico.data.getFinance("hardcap")}</strong></p>
                            <p class="font-weight">Soft cap :<strong> ${ico.data.getFinance("softcap")}</strong></p>
                            <p class="font-weight">raised: <strong> ${ico.data.getFinance("raised")}</strong></p>
                        </div>

                        <div class="col info">
                            <p class="font-weight">Platform: <strong>${ico.data.getFinance("platform")} </strong></p>
                            <p class="font-weight">Accepting: <strong> ${ico.data.getFinance("accepting")} </strong></p>
                            <p class="font-weight">Token type: <strong> ${ico.data.getFinance("tokentype")}</strong></p>
                        </div>
                    </div>

                </div>

                <div class="tab-pane " id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                    <%--<!-- Section: Team v.1 -->--%>
                    <section class="team-section text-center my-5">

                        <!-- Grid row -->
                            <div class="row">

                            <c:forEach items="${ico.data.getCrew()}" var="team">

                                <!-- Grid column -->
                                <div class="col-lg-3 col-md-6 mb-lg-0 mb-5 hoverable ">
                                    <div class="avatar mx-auto">
                                        <img style="margin-top: 1rem" src="${team.photo}"
                                             class="rounded-circle z-depth-1" alt="Sample avatar">
                                    </div>
                                    <p class="font-weight-bold">${team.name}</p>
                                    <p class="text brown-text">${team.title} <a href="${tem.links}"
                                                                                class="icon-linkedin">
                                        <i class="fab fa-linkedin fa-lg"></i>
                                    </a></p>

                                <!-- Grid column -->
                                </div>

                            </c:forEach>
                            </div>
                        <!-- Grid row -->
                    </section>

                </div>
            </div>

        </div>


        <div class="col-md">

        </div>

    </div>

    <br/>

</div>
<br/>
<br/>
</div>

<jsp:include page="template/footer.jsp"/>