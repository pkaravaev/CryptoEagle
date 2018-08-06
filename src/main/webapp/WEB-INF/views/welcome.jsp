<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>
    $(document).ready(function () {

        $(".card").click(function () {
            var href =  $(this).find(".href").text();
            $(location).attr("href", href);
        })
        $(".card").mouseenter(function () {
            $(this).css('cursor', 'pointer');
            $(this).addClass("animated shake")

            var title =  $(this).find(".title").text();
            var description =  $(this).find(".description").text();
            var date =  $(this).find(".date").text();


            $(this).append("<div class=\"card-img-overlay bg-black animated bounceInUp\">\n" +
                "                    <h4 class=\"card-title text-white brown darken-2\">" + title+ " </h4>\n" +
                "                    <p class=\"card-text text-white brown darken-2\"> " + description+ " </p>\n" +
                "                    <p class=\"card-text text-white brown darken-2\"> " + date+ " </p>\n" +
                "                </div>")

        })
        $(".card").mouseleave(function () {

            $(this).find(".card-img-overlay").removeClass("animated bounceInUp")
            $(this).find(".card-img-overlay").addClass("animated fadeOutDown")

        })

    })
</script>

<style>


</style>

<div class="container bg-white">

    <div class="row">
        <div class="col-">

        </div>

        <div class="col">

            <div class="card rounded example hoverable ">
                <img style="height: 15rem" alt="Card image cap" class="card-img-top img-fluid"
                     src="/resources/pic/l/l${main.getRandomPic(5)}.jpg">
                <div class="card-block">
                    <h4 class="card-title font-weight-bold ">${main.title}</h4>
                </div>
                <p class="date">${item.publishDate}</p>

                <p class="title" hidden>${main.title}</p>
                <p class="description" hidden>${main.description}</p>
                <p class="date" hidden>${main.publishDate}</p>
                <p class="href" hidden>${main.link}</p>
            </div>

            <br/>

            <div class="card-deck  ">
                <c:forEach items="${middle}" var="item">
                    <div style="width: 20rem;height: 20rem" class="card example hoverable">
                        <img  alt="Card image cap" class="card-img-top img-fluid "
                             src="/resources/pic/m/m${item.getRandomPic(5)}.jpg">
                        <div class="card-block">
                            <h4 class="card-title font-weight-bold">${main.title}</h4>
                        </div>
                        <p class="date">${item.publishDate}</p>

                        <p class="title" hidden>${item.title}</p>
                        <p class="description" hidden>${item.description}</p>
                        <p class="date" hidden>${item.publishDate}</p>
                        <p class="href" hidden>${item.link}</p>
                    </div>

                </c:forEach>
            </div>
        </div>

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
                                <th><p class="font-weight-normal">${coin.symbol}</p></th>
                                <td><p class="font-weight-normal">${coin.price}</p></td>
                                <td><p class="font-weight-normal">${coin.percent_change_7d}%</p></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!--/.Panel 1-->
                <!--Panel 2-->
                <div class="tab-pane fade " id="panel6" role="tabpanel">
                    <div class="tab-pane fade in show " id="panel" role="tabpanel">
                        <table class="table">
                            <tbody>
                            <c:forEach items="${losercoins}" var="coin">
                                <tr>
                                    <th><p class="font-weight-normal">${coin.symbol}</p></th>
                                    <td><p class="font-weight-normal">${coin.price}</p></td>
                                    <td><p class="font-weight-normal">${coin.percent_change_7d}%</p></td>
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


</div>

<div class="container">

    <div class="row">
        <%--<div class="col">--%>

        <%--</div>--%>
        <div class="col">
            <div class="card-columns">

                <c:forEach items="${items}" var="item" >
                    <!--Panel-->
                    <div style="width: 22rem;height: 22rem" class="card example hoverable">
                        <img alt="Card image cap" class="card-img-top img-fluid"
                             src="/resources/pic/m/m4.jpg">
                        <div class="card-block ">
                            <h4 class="card-title font-weight-bold ">${item.title}</h4>
                        </div>

                        <p class="date">${item.publishDate}</p>
                        <p class="title" hidden>${item.title}</p>
                        <p class="description" hidden>${item.description}</p>
                        <p class="date" hidden>${item.publishDate}</p>
                        <p class="href" hidden>${item.link}</p>
                    </div>

                    <!--/.Panel-->
                </c:forEach>
                <!--/.Panel-->
            </div>
        </div>
        <%--<div class="col">--%>

        <%--</div>--%>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>