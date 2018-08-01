<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<style>

    .card {
        height: 10rem;
        width: 23rem;
    }

    .img-fluid {

        margin-left: 1rem;
        margin-top: 1rem;
    }

    .card-title {
        margin-left: 2.2rem;
        margin-top: 0.5rem;
    }

    .container {

        width: 1500rem;
    }


</style>

<script>

    $(document).ready(function () {

        $(".card").click(function () {

            var xxx = $(this).get(0);
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

    })

</script>


<div class="container  bg-white">

    <div class="row">

        <div class="col-md-4">

            <h1 class="h1 text-center">ACTIVE</h1>

            <c:forEach items="${activeIco}" var="ico">
                <br/>
                <div class="card">
                    <div class="row ">
                        <div class="col-auto">
                            <img src="${ico.logolink}" class="img-fluid" alt="">
                        </div>
                        <div class="col">
                            <div class="card-block px-1">
                                <h4 class="card-title">${ico.name}</h4>
                            </div>
                        </div>
                    </div>

                    <div class="card-footer">

                        <p class="text-right">Starts in ${ico.icoStart}</p>
                        <p class="text-right">Ended in ${ico.icoEnd}</p>

                    </div>
                </div>
            </c:forEach>
        </div>


        <div class="col-md-4">
            <h1 class="text-center">UPCOMING</h1>
            <c:forEach items="${upcoming}" var="ico">
                <br/>
                <div class="card">
                    <div class="row ">
                        <div class="col">
                            <img src="${ico.logolink}" class="img-fluid" alt="">
                        </div>
                        <div class="col">
                            <div class="card-block px-1">
                                <h4 class="card-title center">${ico.name}</h4>
                            </div>
                        </div>
                    </div>

                    <div class="card-footer">

                        <p class="text-right">Starts in ${ico.icoStart}</p>

                    </div>
                </div>
            </c:forEach>

        </div>

        <div class="col-md-4">
            <h1 class="text-center">ENDED</h1>
            <c:forEach items="${finished}" var="ico">
                <br/>
                <div class="card">
                    <div class="row no-gutters">
                        <div class="col-auto">
                            <img src="${ico.logolink}" class="img-fluid" alt="">
                        </div>
                        <div class="col">
                            <div class="card-block px-1">
                                <h4 class="card-title">${ico.name}</h4>
                            </div>

                        </div>
                    </div>

                    <div class="card-footer">
                        <p class="text-right">Ended in ${ico.icoEnd}</p>
                    </div>

                </div>
            </c:forEach>
        </div>

    </div>

</div>


<jsp:include page="template/footer.jsp"/>