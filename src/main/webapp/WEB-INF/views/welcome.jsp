<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>
    $(document).ready(function () {
        $(".tbody").click(function () {
            var url = "coin-list";
            $(location).attr("href", url);
        })
        $("#card").click(function () {
            var h = $(this).children();
            var url = h.children()[1].href;
            $(location).attr("href", url);
        })
        $(".card").mouseenter(function () {
            $(this).css('cursor', 'pointer');
            $(this).removeClass("bg-white");
            $(this).addClass("bg-light")
        })
        $(".card").mouseleave(function () {
            $(this).removeClass("bg-light");
            $(this).addClass("bg-white")
        })

        $(function () {
            $(".sticky").sticky({
                topSpacing: 90
                , zIndex: 2
                , stopper: "#YourStopperId"
            });
        });
    })
</script>

<div class="container bg-white">

    <div class="row">
        <div class="col-">

        </div>

        <div class="col">
            <img src="/resources/pic/big/big-1.png" class="img-fluid example hoverable  border border-secondary"
                 alt="Responsive image">
            <br/>
            <!- Projects section v.1 -->
            <section class="text-center my-5">
                <!-- Grid row -->
                <div class="row text-center">
                    <div class="card-columns">
                    <c:forEach items="${middle}" var="item">

                            <!-- Card Wider -->
                            <div class="card card-cascade wider">

                                <!-- Card image -->
                                <div class="view view-cascade overlay">
                                    <img class="card-img-top" src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" alt="Card image cap">
                                    <a href="#!">
                                        <div class="mask rgba-white-slight"></div>
                                    </a>
                                </div>
                                <!-- Card content -->
                                <div class="card-body card-body-cascade text-center">
                                    <!-- Subtitle -->
                                    <h6 class="black-text pb-2 font-italic"><strong>${item.title}</strong></h6>
                                    <h6 class=" font-italic text-right">${item.publishDate}</h6>
                                </div>

                            </div>

                            <!-- Card Wider -->
                    </c:forEach>
                </div>
                <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </section>
            <!-- Projects section v.1 -->
        </div>

        <div class="col-4 ">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs nav-justified " role="tablist">
                <li class="nav-item">
                    <a class="nav-link active  brown darken-2" data-toggle="tab" href="#panel5" role="tab">
                        <i class="fa fa-user"></i> TOP GAINS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link  brown darken-2" data-toggle="tab" href="#panel6" role="tab">
                        <i class="fa fa-heart"></i> TOP LOOSERS</a>
                </li>
            </ul>
            <!-- Nav tabs -->
            <!-- Tab panels -->
            <div class="tab-content font-weight-bold">
                <!--Panel 1-->
                <div class="tab-pane fade  in show active" id="panel5" role="tabpanel">
                    <table class="table">
                        <%--<thead>--%>
                        <%--<tr>--%>
                        <%--<th scope="col">symbol</th>--%>
                        <%--<th scope="col">price</th>--%>
                        <%--<th scope="col">7D%</th>--%>

                        <%--</tr>--%>
                        <%--</thead>--%>
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
                            <%--<thead>--%>
                            <%--<tr>--%>
                            <%--<th scope="col"><p class="font-weight-normal">SYMBOL</p></th>--%>
                            <%--<th scope="col"><p class="font-weight-normal">PRICe</p></th>--%>
                            <%--<th scope="col"><p class="font-weight-normal">7D%</p>%</th>--%>

                            <%--</tr>--%>
                            <%--</thead>--%>
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
<div class="row">
    <div class="col">

    </div>
    <div class="col-7">

        <!-- Card deck -->
        <div class="card-deck">

            <!-- Card -->
            <div class="card mb-4">

                <!--Card image-->
                <div class="view overlay">
                    <img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/images/16.jpg" alt="Card image cap">
                    <a href="#!">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <!--Card content-->
                <div class="card-body">
                    <!--Title-->
                    <h4 class="card-title">Card title</h4>
                    <!--Text-->
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                    <button type="button" class="btn btn-light-blue btn-md">Read more</button>
                </div>

            </div>
            <!-- Card -->

            <!-- Card -->
            <div class="card mb-4">
                <!--Card image-->
                <div class="view overlay">
                    <img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/images/14.jpg" alt="Card image cap">
                    <a href="#!">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <!--Card content-->
                <div class="card-body">
                    <!--Title-->
                    <h4 class="card-title">Card title</h4>
                    <!--Text-->
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                    <button type="button" class="btn btn-light-blue btn-md">Read more</button>

                </div>

            </div>
            <!-- Card -->

            <!-- Card -->
            <div class="card mb-4">
                <!--Card image-->
                <div class="view overlay">
                    <img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/images/14.jpg" alt="Card image cap">
                    <a href="#!">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <!--Card content-->
                <div class="card-body">
                    <!--Title-->
                    <h4 class="card-title">Card title</h4>
                    <!--Text-->
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                    <button type="button" class="btn btn-light-blue btn-md">Read more</button>

                </div>

            </div>
            <!-- Card -->


            <!-- Card -->
            <div class="card mb-4">

                <!--Card image-->
                <div class="view overlay">
                    <img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/images/15.jpg" alt="Card image cap">
                    <a href="#!">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <!--Card content-->
                <div class="card-body">
                    <!--Title-->
                    <h4 class="card-title">Card title</h4>
                    <!--Text-->
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                    <button type="button" class="btn btn-light-blue btn-md">Read more</button>
                </div>

            </div>
            <!-- Card -->

        </div>
        <!-- Card deck -->
    </div>

    <div class="col">

    </div>
</div>

<jsp:include page="template/footer.jsp"/>