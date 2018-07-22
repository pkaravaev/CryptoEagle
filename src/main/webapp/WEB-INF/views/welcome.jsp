<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>


<div class="container">
    <div class="row">
        <%--<div class="col-sm">--%>
        <%--One of three columns--%>
        <%--</div>--%>
        <div class="col-md-10">


            <c:forEach items="${items}" var="item" varStatus="i">

                <c:choose>

                    <c:when test="${i.count < 7}">

                    </c:when>

                    <c:when test="${i.count > 10}">
                        <div class="card h-30 border border-white">
                            <div class="card-body">
                                <img src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" width="110" height="80"
                                     class="rounded float-left"
                                     alt="Cannnot load picture!" hspace="5">
                                <a href="${item.link}"><h5 class="card-title">${item.title}</h5></a>
                                <h5 class="blockquote-footer">${item.publishDate}</h5>
                                <p class="card-text">${item.description}</p>
                            </div>
                        </div>

                    </c:when>
                </c:choose>
            </c:forEach>


        </div>
        <div class="col-sm">

            <nav>
                <div class="nav nav-tabs border-white" id="nav-tab" role="tablist">
                    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab"
                       aria-controls="nav-home" aria-selected="true">Home</a>
                    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab"
                       aria-controls="nav-profile" aria-selected="false">Profile</a>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">NAME</th>
                            <th scope="col">SYMBOL</th>
                            <th scope="col">PRICE</th>
                            <th scope="col">%7D</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${topcoins}" var="coin">
                            <tr>
                                <td>${coin.name}</td>
                                <td>${coin.symbol}</td>
                                <td>${coin.price}$</td>
                                <td> <c:choose>
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
                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">


                </div>
            </div>


        </div>
    </div>
</div>
<jsp:include page="template/footer.jsp"/>