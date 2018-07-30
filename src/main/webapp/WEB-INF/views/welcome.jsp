<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>

    $(document).ready(function () {

        $(".tbody").click(function () {

            var url = "coin-list";
            $(location).attr("href", url);
        })


        // $('#table1,#table2').dataTable( {
        //     "searching": false,
        //     "paging":false,
        //     "info": false,
        //     "autoWidth": true
        //
        // } );


        $(".card").click(function () {
            var h = $(this).children();
            var url = h.children()[1].href;
            $(location).attr("href", url);
        })


        $(".card").mouseenter(function () {
           $(this).addClass("shadow-sm p-3 mb-5 bg-white rounded");
        })

        $(".card").mouseleave(function () {
            $(this).removeClass("shadow-sm p-3 mb-5 bg-white rounded");
        })

    })


</script>

<style>
    .body {

        color: green;
    }

    .a {

        margin-left: 5rem;
    }
</style>

<div class="container ">
    <div class="row bg-white">
        <%--<div class="col-sm">--%>
        <%--One of three columns--%>
        <%--</div>--%>
        <div class="col-8">
            <c:forEach items="${items}" var="item" varStatus="i">
                <c:choose>
                    <c:when test="${i.count < 2}">


                        <div class="card  text-white border-white">
                            <img class="card-img" src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" alt="Card image" width="300" height="250">
                            <div class="card-img-overlay">
                                <h5 class="card-title">"${item.title}"</h5>
                                <p class="card-text">"${item.description}"</p>
                            </div>
                        </div>


                    </c:when>

                    <c:when test="${i.count < 2}">


                        <div class="card  text-white border-white">
                            <img class="card-img" src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" alt="Card image" width="150" height="150">
                            <div class="card-img-overlay">
                                <h5 class="card-title">"${item.title}"</h5>
                                <p class="card-text">"${item.description}"</p>
                                <p class="card-text">Last updated 3 mins ago</p>
                            </div>
                        </div>


                    </c:when>

                    <c:when test="${i.count > 10}">
                        <div class="card border-white bg-white">
                            <div class="card-body border-bottom">
                                <img src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" width="190" height="150"
                                     class="rounded float-left"
                                     alt="Cannnot load picture!" hspace="5">
                                <a class="link" href="${item.link}"><h5 class="card-title">${item.title}</h5></a>
                                <%--<p class="card-text rounded float-center">${item.publishDate}</p>--%>
                                <p class="font-weight-light">${item.publishDate}</p>
                                <p class="card-text rounded float-center">${item.description}</p>

                                    <%--<h5 class="blockquote-footer">${item.publishDate}</h5>--%>
                            </div>
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>
        </div>



        <div class="col-1 bg-white" style="width: 30px">
            <p class="font-weight-bold bg-white " style="width: 250px">TOP 10 GAINS</p>
            <table  class="table" id="table2">
                <thead class="bg-light">
                <tr>
                    <th>SYMBOL</th>
                    <th>PRICE</th>
                    <th>7D%</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${topcoins}" var="coin">
                    <tr>
                        <td>${coin.symbol}</td>
                        <td>${coin.price}</td>
                        <c:choose>
                            <c:when test="${coin.percent_change_7d > 0}">
                                <td style="color: lawngreen">  ${coin.percent_change_7d}%</td>
                            </c:when>
                            <c:when test="${coin.percent_change_7d < 0}">
                                <td style="color: red">  ${coin.percent_change_7d}%</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <table class="table" id="table1">
                <br/>
                <thead class="bg-light">
                <tr>
                    <th>SYMBOL</th>
                    <th>PRICE</th>
                    <th>7D%</th>

                </tr>
                </thead>
                <tbody>

                <p class="font-weight-bold bg-white" style="width: 250px">TOP 10 LOOSERS</p>
                <c:forEach items="${losercoins}" var="coin">
                    <tr>
                        <td>${coin.symbol}</td>
                        <td>${coin.price}</td>
                        <c:choose>
                            <c:when test="${coin.percent_change_7d > 0}">
                                <td style="color: lawngreen">  ${coin.percent_change_7d}%</td>
                            </c:when>
                            <c:when test="${coin.percent_change_7d < 0}">
                                <td style="color: red">  ${coin.percent_change_7d}%</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

<jsp:include page="template/footer.jsp"/>