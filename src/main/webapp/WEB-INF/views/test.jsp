<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<div class="container">
    <div class="row">

        <div class="col align-self-start">

        </div>

        <div class="col-8 align-self-center ">

            <c:forEach items="${items}" var="item">

            <div class="card h-15 border border-white">
                <div class="card-body">
                    <img src="/resources/pic/dollars.jpg" class="rounded float-left" alt="...">
                    <h5 class="card-title">${item.title}</h5>
                    <p class="card-text">${item.description}</p>
                </div>
            </div>
            </c:forEach>
        </div>


        <div class="col align-self-end">

        </div>


    </div>
</div>

<jsp:include page="template/footer.jsp"/>