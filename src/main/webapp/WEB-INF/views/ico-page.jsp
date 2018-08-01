<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<style>

    .card {
        padding-top: 20px;
        margin: 10px 0 20px 0;
        background-color: rgba(214, 224, 226, 0.2);
        border-top-width: 0;
        border-bottom-width: 2px;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        border-radius: 3px;
        -webkit-box-shadow: none;
        -moz-box-shadow: none;
        box-shadow: none;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }

    .card .card-heading {
        padding: 0 20px;
        margin: 0;
    }

    .card .card-heading.simple {
        font-size: 20px;
        font-weight: 300;
        color: #777;
        border-bottom: 1px solid #e5e5e5;
    }

    .card .card-heading.image img {
        display: inline-block;
        width: 46px;
        height: 46px;
        margin-right: 15px;
        vertical-align: top;
        border: 0;
        -webkit-border-radius: 50%;
        -moz-border-radius: 50%;
        border-radius: 50%;
    }

    .card .card-heading.image .card-heading-header {
        display: inline-block;
        vertical-align: top;
    }

    .card .card-heading.image .card-heading-header h3 {
        margin: 0;
        font-size: 14px;
        line-height: 16px;
        color: #262626;
    }

    .card .card-heading.image .card-heading-header span {
        font-size: 12px;
        color: #999999;
    }

    .card .card-body {
        padding: 0 20px;
        margin-top: 20px;
    }

    .card .card-media {
        padding: 0 20px;
        margin: 0 -14px;
    }

    .card .card-media img {
        max-width: 100%;
        max-height: 100%;
    }

    .card .card-actions {
        min-height: 30px;
        padding: 0 20px 20px 20px;
        margin: 20px 0 0 0;
    }

    .card .card-comments {
        padding: 20px;
        margin: 0;
        background-color: #f8f8f8;
    }

    .card .card-comments .comments-collapse-toggle {
        padding: 0;
        margin: 0 20px 12px 20px;
    }

    .card .card-comments .comments-collapse-toggle a,
    .card .card-comments .comments-collapse-toggle span {
        padding-right: 5px;
        overflow: hidden;
        font-size: 12px;
        color: #999;
        text-overflow: ellipsis;
        white-space: nowrap;
    }

    .card-comments .media-heading {
        font-size: 13px;
        font-weight: bold;
    }

    .card.people {
        position: relative;
        display: inline-block;
        width: 170px;
        height: 300px;
        padding-top: 0;
        margin-left: 20px;
        overflow: hidden;
        vertical-align: top;
    }

    .card.people:first-child {
        margin-left: 0;
    }

    .card.people .card-top {
        position: absolute;
        top: 0;
        left: 0;
        display: inline-block;
        width: 170px;
        height: 150px;
        background-color: #ffffff;
    }

    .card.people .card-top.green {
        background-color: #53a93f;
    }

    .card.people .card-top.blue {
        background-color: #427fed;
    }

    .card.people .card-info {
        position: absolute;
        top: 150px;
        display: inline-block;
        width: 100%;
        height: 101px;
        overflow: hidden;
        background: #ffffff;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }

    .card.people .card-info .title {
        display: block;
        margin: 8px 14px 0 14px;
        overflow: hidden;
        font-size: 16px;
        font-weight: bold;
        line-height: 18px;
        color: #404040;
    }

    .card.people .card-info .desc {
        display: block;
        margin: 8px 14px 0 14px;
        overflow: hidden;
        font-size: 12px;
        line-height: 16px;
        color: #737373;
        text-overflow: ellipsis;
    }

    .card.people .card-bottom {
        position: absolute;
        bottom: 0;
        left: 0;
        display: inline-block;
        width: 100%;
        padding: 10px 20px;
        line-height: 29px;
        text-align: center;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }

    .card.hovercard {
        position: relative;
        padding-top: 0;
        overflow: hidden;
        text-align: center;
        background-color: rgba(214, 224, 226, 0.2);
    }

    .card.hovercard .cardheader {
        background: url("http://lorempixel.com/850/280/nature/4/");
        background-size: cover;
        height: 135px;
    }

    .card.hovercard .avatar {
        position: relative;
        top: -50px;
        margin-bottom: -50px;
    }

    .card.hovercard .avatar img {
        width: 100px;
        height: 100px;
        max-width: 100px;
        max-height: 100px;
        -webkit-border-radius: 50%;
        -moz-border-radius: 50%;
        border-radius: 50%;
        border: 5px solid rgba(255,255,255,0.5);
    }

    .card.hovercard .info {
        padding: 4px 8px 10px;
    }

    .card.hovercard .info .title {
        margin-bottom: 4px;
        font-size: 24px;
        line-height: 1;
        color: #262626;
        vertical-align: middle;
    }

    .card.hovercard .info .desc {
        overflow: hidden;
        font-size: 12px;
        line-height: 20px;
        color: #737373;
        text-overflow: ellipsis;
    }

    .card.hovercard .bottom {
        padding: 0 20px;
        margin-bottom: 17px;
    }

    .btn{ border-radius: 50%; width:32px; height:32px; line-height:18px;  }

</style>


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
                                ${ico.description}</p>
                    </div>
                    <br/>

                </div>
                <br/>
                <hr/>
                <div class="row">

                    <div class="col-md-7">

                        <div class="embed-responsive embed-responsive-16by9">
                            <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0"
                                    allowfullscreen></iframe>
                        </div>

                    </div>

                    <div class="col-md">

                        <div class="card border-white text-center" style="width: 18rem;">

                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <h6>Toke sales : Ended</h6>
                                    <h6>Toke start sale : ${ico.icoStart}</h6>
                                    <h6>Toke end sale : ${ico.icoEnd}</h6>
                                    <h6>Raised : Ended</h6>

                                </li>

                                <li class="list-group-item">
                                    <button   value="${ico.data.getLink("whitepaper")}"  type="button" class="btn btn-secondary btn-sm">Web site</button>
                                </li>
                                <li class="list-group-item">
                                    <button   value="${ico.data.getLink("whitepaper")}"  type="button" class="btn btn-secondary btn-sm">White list</button>
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
                                <p class="font-weight-bold">token : ${ico.data.getFinance("token")} </p>
                                <p class="font-weight-bold">price : ${ico.data.getFinance("price")} </p>
                                <p class="font-weight-bold">tokens: ${ico.data.getFinance("tokens")}</p>
                                <p class="font-weight-bold">hard cap : ${ico.data.getFinance("hardcap")}</p>
                                <p class="font-weight-bold">soft cap : ${ico.data.getFinance("softcap")}</p>
                                <p class="font-weight-bold">raised: ${ico.data.getFinance("raised")}</p>

                            </div>

                            <div class="col info">

                                <p class="font-weight-bold">platform: ${ico.data.getFinance("platform")} </p>
                                <p class="font-weight-bold">accepting: ${ico.data.getFinance("accepting")} </p>
                                <p class="font-weight-bold">Bold text.</p>
                                <p class="font-weight-bold">Bold text.</p>
                                <p class="font-weight-bold">Bold text.</p>
                                <p class="font-weight-bold">Bold text.</p>
                            </div>
                        </div>

                    </div>

                    <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                        <ul class="list-group list-group-flush">

                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src=".../100px180/" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="btn btn-primary">Go somewhere</a>
                                </div>
                            </div>

                        </ul>
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