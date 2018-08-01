<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="template/header.jsp"/>


<jsp:useBean id="icoc" class="com.cryptoeagle.entity.Ico">
    <div class="container bg-white">

        <div class="row">
                <%--empty--%>
            <div class="col-md">


            </div>

            <div class="col-md-10">

                <br/>
                <hr/>
                <div class="row">

                    <div class="col-md">
                        <img class="img" src="${ico.logolink}"
                             alt="error"/>
                    </div>
                    <div class="col-md-10">

                        <h5 class="title">${ico.name} (${ico.data.getCategories("name")})</h5>
                        <p class="text">
                                ${ico.data.intro}</p>
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
                                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime1}"
                                                    var="preIcoEnd"/>


                                    <h6>Toke sales : Ended</h6>
                                    <h6>Toke pre sale : ${preIcoStart}</h6>
                                    <h6>Toke end pre sale : ${preIcoEnd}</h6>
                                    <h6>Toke start sale : ${icoStart}</h6>
                                    <h6>Toke end sale : ${icoEnd}</h6>
                                    <h6>Raised : Ended</h6>

                                </li>

                                <li class="list-group-item">
                                    <button value="${ico.data.getLink("whitepaper")}" type="button"
                                            class="btn btn-secondary btn-sm">Web site
                                    </button>
                                </li>
                                <li class="list-group-item">
                                    <button value="${ico.data.getLink("whitepaper")}" type="button"
                                            class="btn btn-secondary btn-sm">White list
                                    </button>
                                </li>
                                <li class="list-group-item  ">

                                    <a href="google.com">
                                        <i class="fab fa-bitcoin fa-lg fa-spin"></i>
                                    </a>

                                    <i class="fab fa-twitter fa-lg"></i>
                                    <i class="fab fa-github fa-lg"></i>
                                    <i class="fab fa-reddit fa-lg"></i>
                                    <i class="fab fa-medium fa-lg"></i>
                                    <i class="fab fa-bitcoin fa-lg"></i>

                                </li>

                            </ul>
                        </div>


                    </div>

                </div>

                <hr/>

                <ul class="nav nav-pills justify-content-center mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab"
                           aria-controls="pills-home" aria-selected="true">Finance</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab"
                           aria-controls="pills-profile" aria-selected="false">Teams</a>
                    </li>
                </ul>

                <div class="tab-content" id="pills-tabContent">
                    <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                         aria-labelledby="pills-home-tab">
                        <div class="row">

                            <div class="col info">
                                <p class="font-weight-bold">Token : ${ico.data.getFinance("token")} </p>
                                <p class="font-weight-bold">Price : ${ico.data.getFinance("price")} </p>
                                <p class="font-weight-bold">Tokens: ${ico.data.getFinance("tokens")}</p>
                                <p class="font-weight-bold">Hard cap : ${ico.data.getFinance("hardcap")}</p>
                                <p class="font-weight-bold">Soft cap : ${ico.data.getFinance("softcap")}</p>
                                <p class="font-weight-bold">raised: ${ico.data.getFinance("raised")}</p>

                            </div>

                            <div class="col info">
                                <p class="font-weight-bold">Platform: ${ico.data.getFinance("platform")} </p>
                                <p class="font-weight-bold">Accepting: ${ico.data.getFinance("accepting")} </p>
                                <p class="font-weight-bold">Token type: ${ico.data.getFinance("tokentype")}</p>
                            </div>
                        </div>

                    </div>

                    <div class="tab-pane " id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">


                    </div>
                </div>

                <br/>
                <br/>
                <br/>

                <hr/>

            </div>
                <%--empty--%>
            <div class="col-md">

            </div>

        </div>

    </div>
</jsp:useBean>
<jsp:include page="template/footer.jsp"/>