<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md ">

        </div>

        <c:forEach items="${items}" var="item">



                <div class="col-md-6">
                    <div class="card flex-md-row mb-4 box-shadow h-md-250">
                        <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Card image cap">
                        <div class="card-body d-flex flex-column align-items-start">
                            <h3 class="mb-0">
                                <a class="text-dark" href="#">${item.title}</a>
                            </h3>
                            <div class="mb-1 text-muted">Nov 12</div>
                            <p class="card-text mb-auto">${item.description}</p>
                            <a href="${item.link}">Continue reading</a>
                        </div>

                    </div>
                </div>


        </c:forEach>











        <%--<div class="col-md-8">--%>

            <%--<div class="card" style="width: 50rem; height: 10rem">--%>
                <%--<img class="card-img-right" src=".../10px180/" alt="Card image cap">--%>
                    <%--<img src="..." class="rounded float-right" alt="...">--%>
                <%--<div class="card-body">--%>
                    <%--<h5 class="card-title" >${item.title}</h5>--%>
                    <%--<p class="card-text">${item.description}</p>--%>
                    <%--<a href="#" class="btn btn-primary">more...</a>--%>
                <%--</div>--%>
            <%--</div>--%>







        <div class="col-md ">


        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>