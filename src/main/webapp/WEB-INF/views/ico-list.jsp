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


    /*.zoom:hover {*/
        /*transform: scale(1.1); !* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) *!*/
    /*}*/

</style>

<script>

    $(document).ready(function () {



    })

</script>


<div class="container  bg-white">

    <div class="row">

        <div class="col-md-4">

            <h1 class="h1 text-center">ACTIVE</h1>

            <c:forEach items="${activeIco}" var="ico">
                <!--Panel-->
                <div class="card hoverable">
                    <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <%--<img src="${ico.link}" class="float-left" alt="placeholder"/>--%>
                        </div>

                        <div class="col">
                            <h5 class="card-title text-cnter">${ico.name}</h5>
                            <%--<p class="card-text">${ico.description}</p>--%>

                        </div>

                        <div class="col">
                        </div>
                        <p class="card-text"><small class="text-muted"><p class="text-right">Starts in ${ico.icoStart}</p></small></p>
                    </div>

                        <%--<img class="float-left" src="${ico.link}"> --%>

                    </div>
                </div>
                <!--/.Panel-->
                <br/>
            </c:forEach>
        </div>


        <div class="col-md-4">
            <h1 class="text-center">UPCOMING</h1>
            <c:forEach items="${upcoming}" var="ico">
            <!--Panel-->
            <div class="card hoverable">
                <div class="card-body">
                    <h5 class="card-title text-cnter">${ico.name}</h5>
                    <%--<p class="card-text">${ico.description}</p>--%>
                    <p class="card-text"><small class="text-muted"><p class="text-right">Starts in ${ico.icoStart}</p></small></p>
                </div>
            </div>
            <!--/.Panel-->
                <br />
            </c:forEach>
        </div>

        <div class="col-md-4">
            <h1 class="text-center">ENDED</h1>
            <c:forEach items="${finished}" var="ico">
                <!--Panel-->
                <div class="card hoverable zoom">
                    <div class="card-body">
                        <h5 class="card-title text-cnter">${ico.name}</h5>
                        <%--<p class="card-text">${ico.description}</p>--%>
                        <p class="card-text"><small class="text-muted"><p class="text-right">Starts in ${ico.icoStart}</p></small></p>
                    </div>
                </div>
                <!--/.Panel-->
                <br/>
            </c:forEach>
        </div>

    </div>

</div>


<jsp:include page="template/footer.jsp"/>