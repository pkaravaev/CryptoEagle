<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>

    $(document).ready(function () {

        $(".card").dblclick(function () {
            var href =  $(this).find(".href").text();
            $(location).attr("href", href);
        })

        $(".card").mouseenter(function () {
            $(this).css('cursor', 'pointer');
            $(this).addClass("animated shake")

        })

        $(".card").click(function () {
            $(this).css('cursor', 'pointer');
            // $(this).addClass("animated shake")

            var title =  $(this).find(".title").text();
            var description =  $(this).find(".description").text();
            var date =  $(this).find(".date").text();

             if($(".card-img-overlay ").hasClass("animated bounceInUp")){
                 $(".card-img-overlay ").removeClass("animated bounceInUp")
                 $(".card-img-overlay ").addClass("animated fadeOutUp")
             }else {

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



</style>

<div class="container bg-white">

    <div class="row">
        <div class="col-">

        </div>

        <div class="col">

            <h4 class="font-weight-bold">Crypto news</h4>

            <hr  style="size: 4rem" color="#795548"/>

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
                    <div style="height: 20rem;width: 20rem"  class="card hoverable ">
                        <img style="width: 22rem;height: 12rem"  alt="Card image cap" class="card-img-top img-fluid "
                             src="/resources/pic/m/m${item.getRandomPic(5)}.jpg">
                        <div class="card-block">
                            <h4 class="card-title font-weight-bold">${main.title}</h4>
                        </div>

                        <p class="date text-center">${item.publishDate}</p>
                        <p class="title" hidden>${item.title}</p>
                        <p class="description" hidden>${item.description}</p>
                        <p class="href" hidden>${item.link}</p>
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
                                    <td ><p  style="color: green" class="font-weight-bold">${coin.percent_change_7d}%</p></td>
                                </c:if>
                                <c:if test="${coin.percent_change_7d < 0}">
                                    <td><p  style="color: red" class="font-weight-bold">${coin.percent_change_7d}%</p></td>
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
                                <tr >
                                    <th><p class="font-weight-bold">${coin.symbol}</p></th>
                                    <td><p class="font-weight-bold">${coin.price}</p></td>
                                    <c:if test="${coin.percent_change_7d > 0}">
                                        <td ><p  style="color: green" class="font-weight-bold">${coin.percent_change_7d}%</p></td>
                                    </c:if>
                                    <c:if test="${coin.percent_change_7d < 0}">
                                        <td><p  style="color: red" class="font-weight-bold">${coin.percent_change_7d}%</p></td>
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

                <c:forEach items="${items}" var="item" varStatus="i" >
                    <!--Panel-->
                    <div style="height: 20rem;width: 22rem"  class="card hoverable ">
                        <img  style="width: 22rem;height: 12rem" alt="Card  image cap" class="card-img-top img-fluid"
                              src="/resources/pic/m/m${i.count}.jpg">
                        <div class="card-block ">
                            <h4 class="card-title font-weight-bold ">${item.title}</h4>
                        </div>
                        <p class="date text-center">${item.publishDate}</p>
                        <p class="title" hidden>${item.title}</p>
                        <p class="description" hidden>${item.description}</p>
                        <p class="href" hidden>${item.link}</p>
                    </div>
                    <!--Panel-->
                </c:forEach>
            </div>

            <h4 class="font-weight-bold">Ico news</h4>

            <hr  style="size: 4rem" color="#795548"/>

        </div>

    </div>

</div>




<jsp:include page="template/footer.jsp"/>