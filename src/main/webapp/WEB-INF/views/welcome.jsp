<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>


    $(document).ready(function () {

        $(".table").click(function () {
            var url = "coin-list";
            $(location).attr("href", url);
        })

        $(".card").click(function () {

            var h = $(this).children();
            var url = h.children()[1].href;
            $(location).attr("href", url);
        })

        $(".nav-item").mouseleave(function () {
            $(this).css("font-size",17);
        })

        $(".nav-item").mouseenter(function () {
            $(this).css("font-size",25);
        })

        $(".card").mouseenter(function () {

           $(this).addClass("shadow p-3 mb-5 bg-white rounded");
        })

        $(".card").mouseleave(function () {

            $(this).removeClass("shadow p-3 mb-5 bg-white rounded");
        })

    })

</script>

<div class="container">
    <div class="row">
        <%--<div class="col-sm">--%>
        <%--One of three columns--%>
        <%--</div>--%>
        <div class="col-8">
            <c:forEach items="${items}" var="item" varStatus="i">
                <c:choose>
                    <c:when test="${i.count < 7}">
                    </c:when>
                    <c:when test="${i.count > 10}">
                        <div class="card border-white">
                            <div class="card-body">
                                <img src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" width="170" height="130"
                                     class="rounded float-left"
                                     alt="Cannnot load picture!" hspace="5">
                                <a class="link" href="${item.link}"><h5 class="card-title">${item.title}</h5></a>
                                <p class="card-text rounded float-center">${item.description}</p>
                                <p class="card-text rounded float-center">${item.publishDate}</p>
                                    <%--<h5 class="blockquote-footer">${item.publishDate}</h5>--%>

                            </div>
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>
        </div>
        <div class="col-1">

            <p class="font-weight-bold" style="width: 250px">TOP 10 GAINS</p>
            <table class="table  table-sm" >
                <thead>
                <tr>
                    <th scope="col">SYMBOL</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">%7D</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${topcoins}" var="coin">
                    <tr>
                        <td>${coin.symbol}</td>
                        <td>${coin.price}$</td>
                        <td>
                            <c:choose>
                            <c:when test="${coin.percent_change_7d > 0}">
                        <td style="color: lawngreen">  ${coin.percent_change_7d}%</td>
                        </c:when>
                        <c:when test="${coin.percent_change_7d < 0}">
                            <td style="color: red">  ${coin.percent_change_7d}%</td>
                        </c:when>
                        </c:choose></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <p class="font-weight-bold" style="width: 250px">TOP 10 LOOSERS</p>
            <table  class="table  table-sm ">
                <thead>
                <tr>
                    <th scope="col">SYMBOL</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">%7D</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${losercoins}" var="coin">
                    <tr>
                        <td>${coin.symbol}</td>
                        <td>${coin.price}$</td>
                        <td>
                            <c:choose>
                            <c:when test="${coin.percent_change_7d > 0}">
                        <td style="color: lawngreen">  ${coin.percent_change_7d}%</td>
                        </c:when>
                        <c:when test="${coin.percent_change_7d < 0}">
                            <td style="color: red">  ${coin.percent_change_7d}%</td>
                        </c:when>
                        </c:choose></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>


    </div>
</div>
</div>
<jsp:include page="template/footer.jsp"/>