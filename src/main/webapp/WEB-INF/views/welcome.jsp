<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md ">

        </div>

        <c:forEach items="${itemslist}" var="item">

        <%--<div class="col-md-8">--%>

            <div class="card" style="width: 50rem; height: 10rem">
                <%--<img class="card-img-right" src=".../10px180/" alt="Card image cap">--%>
                    <%--<img src="..." class="rounded float-right" alt="...">--%>
                <div class="card-body">
                    <h5 class="card-title" >${item.title}</h5>
                    <p class="card-text">${item.description}</p>
                    <a href="#" class="btn btn-primary">more...</a>
                </div>
            </div>
        <%--</div>--%>
        </c:forEach>

        <div class="col-md ">


        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>