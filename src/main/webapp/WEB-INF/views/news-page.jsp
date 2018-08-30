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
            $(".container").addClass("animated shake")
        })
    })

    $(document).ready(function () {

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
                    // "                    <h4 class=\"card-title text-white brown darken-2\">" + title + " </h4>\n" +
                    "                    <p class=\"card-text text-white brown darken-2\"> " + description + " </p>\n" +
                    // "                    <p class=\"card-text text-white brown darken-2\"> " + date + " </p>\n" +
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

    h4 {
        height: 5.2rem;
        overflow: hidden;
    }
</style>

<ul class="nav justify-content-center font-weight-bold brown lighten-5 ">

    <c:forEach items="${sources}" var="s">
        <li class="nav-item">
            <button value="/news/${s.toString()}" type="button" class="btn btn-brown btn-rounded">${s.toString()}</button>
        </li>
    </c:forEach>

</ul>

<div class="container">

    <div class="col">

    </div>

    <div class="col-12">

        <br/>

        <div class="card-columns">

            <c:forEach items="${items}" var="item" varStatus="i">

                <div style="height: 20rem;width: 22rem" class="card hoverable ">

                    <img style="width: 22rem;height: 12rem" alt="Card  image cap" class="card-img-top img-fluid"
                         src="/resources/pic/m/m${item.getRandomPic(9)}.jpg">
                    <div class="card-block ">
                        <h4 class="card-title font-weight-bold ">${item.title}</h4>
                    </div>

                    <p class="title" hidden>${item.title}</p>

                    <p class="description" hidden>${item.description}</p>

                    <p class="href" hidden>${item.link}</p>

                    <div class="row">
                        <div class="col">
                            <p style="margin-left: 1rem" class="date text-left font-italic">by ${item.source}</p>
                        </div>
                        <div class="col">
                            <c:choose>
                                <c:when test="${item.diffHours() == 0}" >
                                    <p style="margin-right: 1rem" class="date text-right font-italic">${ Math.abs(item.diffMinutes())} m ago </p>
                                </c:when>
                                <c:otherwise>
                                    <p style="margin-right: 1rem" class="date text-right font-italic">${Math.abs(item.diffHours())} h ago </p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <!--Panel-->
            </c:forEach>
        </div>
    </div>

    <div class="col">

    </div>

</div>

<jsp:include page="template/footer.jsp"/>