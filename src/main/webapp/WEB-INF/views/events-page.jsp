<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

<script>

    $(document).ready(function () {

        $(".button").click(function () {
            var url = $(this).val();
            $(this).location.href = url;
        })
    })
</script>


<div class="container">
    <div class="page-header">
        <h1 id="text-center font-weight-bold timeline">EVENTS</h1>
    </div>
    <ul class="timeline">


        <c:forEach items="${events}" var="event" varStatus="i">

            <c:choose>
                <c:when test="${(i.count%2) ==0}">
                    <li class="timeline-inverted">
                </c:when>
                <c:otherwise>
                    <li>
                </c:otherwise>

            </c:choose>
            <div class="timeline-badge brown"><i class="glyphicon glyphicon-check"></i></div>
            <div class="timeline-panel">
                <div class="timeline-heading">

                    <div class="row">
                        <div class="col">
                            <h4 class="timeline-title">${event.title}</h4>
                            <h3 class="timeline-title">${event.name}</h3>
                            <h3 class="timeline-title">${event.coinName}</h3>
                            <button value="${event.proof}" type="button" class="btn btn-brown btn-rounded">Proof
                            </button>
                            <button value="${event.source}" type="button" class="btn btn-brown btn-rounded">Source
                            </button>
                        </div>
                        <div class="col">
                            <i style="color: red" class="fas fa-top fa-fire fa-2x"></i>
                        </div>
                        <div class="col">
                            <i style="color: orange;alignment: right" class="far fa-clock fa-4x"></i>
                        </div>

                    </div>

                    <p>
                        <small class="text-muted"><i class="glyphicon glyphicon-time"></i> ${event.date_event}
                        </small>
                    </p>
                </div>
                <div class="timeline-body">
                    <p>${event.description}</p>
                </div>
            </div>
            </li>

        </c:forEach>


        <%--<li class="timeline-inverted">--%>
        <%--<div class="timeline-panel">--%>
        <%--<div class="timeline-heading">--%>
        <%--<h4 class="timeline-title">Mussum ipsum cacilds</h4>--%>
        <%--</div>--%>
        <%--<div class="timeline-body">--%>
        <%--<p>Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.</p>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</li>--%>
        <%--<li>--%>
        <%--<div class="timeline-badge info"><i class="glyphicon glyphicon-floppy-disk"></i></div>--%>
        <%--<div class="timeline-panel">--%>
        <%--<div class="timeline-heading">--%>
        <%--<h4 class="timeline-title">Mussum ipsum cacilds</h4>--%>
        <%--</div>--%>
        <%--<div class="timeline-body">--%>
        <%--<p>Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.</p>--%>
        <%--<hr>--%>
        <%--<div class="btn-group">--%>
        <%--<button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">--%>
        <%--<i class="glyphicon glyphicon-cog"></i> <span class="caret"></span>--%>
        <%--</button>--%>
        <%--<ul class="dropdown-menu" role="menu">--%>
        <%--<li><a href="#">Action</a></li>--%>
        <%--<li><a href="#">Another action</a></li>--%>
        <%--<li><a href="#">Something else here</a></li>--%>
        <%--<li class="divider"></li>--%>
        <%--<li><a href="#">Separated link</a></li>--%>
        <%--</ul>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</li>--%>
        <%--<li>--%>
        <%--<div class="timeline-panel">--%>
        <%--<div class="timeline-heading">--%>
        <%--<h4 class="timeline-title">Mussum ipsum cacilds</h4>--%>
        <%--</div>--%>
        <%--<div class="timeline-body">--%>
        <%--<p>Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.</p>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</li>--%>
        <%--<li class="timeline-inverted">--%>
        <%--<div class="timeline-badge success"><i class="glyphicon glyphicon-thumbs-up"></i></div>--%>
        <%--<div class="timeline-panel">--%>
        <%--<div class="timeline-heading">--%>
        <%--<h4 class="timeline-title">Mussum ipsum cacilds</h4>--%>
        <%--</div>--%>
        <%--<div class="timeline-body">--%>
        <%--<p>Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.</p>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</li>--%>
    </ul>
</div>

<jsp:include page="template/footer.jsp"/>
