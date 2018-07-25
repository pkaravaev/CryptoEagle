<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<div class="container ">


    <div class="row">
        <div class="col-sm  border-right">
            <h2>ACTIVE ICO</h2>
            <br>
            <hr>
            <c:forEach items="${aico}" var="ico">
                <div class="card h-30 border border-bottom">
                    <div class="card-body">
                        <img src="${ico.image}" width="220" height="70" class="rounded float-left"
                             alt="Error"
                             hspace="5">
                            ${status.count}
                            <%--<h5 class="card-title">${ico.name}</h5>--%>
                        <h5 class="blockquote-footer">${ico.start_time}</h5>
                    </div>
                </div>
            </c:forEach>

        </div>
        <div class="col-sm  border-right ">
            <h2>UPCOMING</h2>
            <br>
            <hr>
            <c:forEach items="${uico}" var="ico">
                <%--<div class="card h-30 border border-bottom">--%>
                    <%--<div class="card-body">--%>
                        <%--<img src="${ico.image}" width="220" height="70" class="rounded float-left"--%>
                             <%--alt="Error"--%>
                             <%--hspace="5">--%>
                            <%--${status.count}--%>
                            <%--&lt;%&ndash;<h5 class="card-title">${ico.name}</h5>&ndash;%&gt;--%>
                        <%--<h5 class="blockquote-footer">${ico.start_time}</h5>--%>
                    <%--</div>--%>
                <%--</div>--%>


                <div class="card" style="width:430px;">
                    <img class="card-img-top" src="${ico.image}" alt="Card image cap" style="width: 200px">
                    <div class="card-body">
                        <h5 class="card-title">${ico.title}</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                </div>

            </c:forEach>
        </div>
        <div class="col-sm ">
            <h2>ENDED ICO</h2>
            <br>
            <hr>
            <c:forEach items="${eico}" var="ico">
                <div class="card h-30 border border-bottom">
                    <div class="card-body">
                        <img src="${ico.image}" width="120" height="70" class="rounded float-left"
                             alt="Error"
                             hspace="5">
                            ${status.count}
                        <h5 class="card-title">${ico.name}</h5>

                    </div>
                    <div class="card-footer">
                        <h6>ROI</h6>
                        <h6>${ico.all_time_roi}</h6>
                    </div>
                </div>


            </c:forEach>

        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>