<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<style>

    .card {

        height: 10rem;
        width: 25rem;

    }

    .img-fluid {

        margin-left: 1rem;
        margin-top: 1rem;
    }

    .card-title{
        margin-left:2.2rem;
        margin-top: 0.5rem;
    }



</style>


<div class="container ">

    <div class="row">

        <div class="col-md-4">

            <h1>ACTIVE</h1>

            <c:forEach  items="${activeIco}" var="ico">

                <div class="card">
                    <div class="row no-gutters">
                        <div class="col-auto">
                            <img src="${ico.logolink}" class="img-fluid" alt="">
                        </div>
                        <div class="col">
                            <div class="card-block px-1">
                                <h4 class="card-title">${ico.name}</h4>
                                <%--<p class="card-text">${ico.description}</p>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>


        <div class="col-md-4">
            <h1>UPCOMING</h1>
            <c:forEach  items="${upcoming}" var="ico">

                <div class="card">
                    <div class="row no-gutters">
                        <div class="col-auto">
                            <img src="${ico.logolink}" class="img-fluid" alt="">
                        </div>
                        <div class="col">
                            <div class="card-block px-1">
                                <h4 class="card-title">${ico.name}</h4>
                                <%--<p class="card-text">${ico.description}</p>--%>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer bg-transparent ">

                        <p class="text-right">Starts in  ${ico.icoStart}</p>
                    </div>

                </div>
            </c:forEach>

        </div>

        <div class="col-md-4">
            <h1>ENDED</h1>

            <c:forEach  items="${finished}" var="ico">

                <div class="card">
                    <div class="row no-gutters">
                        <div class="col-auto">
                            <img src="${ico.logolink}" class="img-fluid" alt="">
                        </div>
                        <div class="col">
                            <div class="card-block px-1">
                                <h4 class="card-title">${ico.name}</h4>
                                <%--<p class="card-text">${ico.description}</p>--%>
                            </div>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </div>








    </div>

</div>


<jsp:include page="template/footer.jsp"/>