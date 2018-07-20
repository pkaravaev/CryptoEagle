<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<%--<div class="container">--%>
<%--<div class="row">--%>

<%--<div class="col align-self-start">--%>

<%--</div>--%>

<%--<div class="col-11 align-self-center ">--%>

<%--<c:forEach items="${items}" var="item">--%>

<%--<div class="card h-30 border  border-white" >--%>
<%--<div class="card-body">--%>
<%--<img src="/resources/pic/dollars.jpg" width="110" height="80" class="rounded float-left" alt="blablalal" hspace="5" >--%>
<%--<h5 class="card-title">${item.title}</h5>--%>
<%--<h5  class="blockquote-footer">2018.10.01 Ivan Ivanov</h5>--%>
<%--<p class="card-text">${item.description}</p>--%>
<%--</div>--%>
<%--</div>--%>
<%--</c:forEach>--%>
<%--</div>--%>


<%--<div class="col align-self-end">--%>

<%--</div>--%>
<%--</div>--%>
<%--</div>--%>


<div class="container">

    <br>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#news"><p class="font-weight-normal">Crypto News</p></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#rss"><p class="font-weight-normal">Rss Crypto News</p></a>
        </li>

        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#ico"><p class="font-weight-normal">Upcoming Icos</p></a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="news" class="container tab-pane active"><br>
            <div class="col-11 align-self-center ">
                <c:forEach items="${items}" var="item">
                    <div class="card h-30 border  border-white">
                        <div class="card-body">
                            <img src="/resources/pic/cryptopic/${item.getRandomPic(20)}.jpg" width="110" height="80" class="rounded float-left"
                                 alt="Cannnot load picture!" hspace="5">
                             <a href="${item.link}"><h5 class="card-title">${item.title}</h5></a>
                            <h5 class="blockquote-footer">${item.publishDate}</h5>
                            <p class="card-text">${item.description}</p>
                        </div>
                    </div>

                </c:forEach>
            </div>

        </div>
        <div id="ico" class="container tab-pane fade"><br>

            <table>


                    <tr>
                        <c:forEach items="${icoList}" var="ico" varStatus="status">

                        <td>
                                <%--<c:forEach items="${actIco}" var="ico">--%>

                            <div class="card h-30 border  border-white">
                                <div class="card-body">
                                    <img src="${ico.image}" width="200" height="50" class="rounded float-left"
                                         alt="Error"
                                         hspace="5">
                                    ${status.count}
                                        <%--<h5 class="card-title">${ico.name}</h5>--%>
                                    <h5 class="blockquote-footer">${ico.start_time}</h5>
                                    <p class="card-text">${ico.description}</p>
                                </div>
                            </div>
                                <%--</c:forEach>--%>
                        </td>

                        </c:forEach>
                        <%--<td>--%>
                                <%--<c:forEach items="${upIco}" var="ico">--%>
                            <%--<div class="card h-30 border  border-white">--%>
                                <%--<div class="card-body">--%>
                                    <%--<img src="${ico.image}" width="200" height="50" class="rounded float-left"--%>
                                         <%--alt="Error"--%>
                                         <%--hspace="5">--%>
                                        <%--&lt;%&ndash;<h5 class="card-title">${ico.name}</h5>&ndash;%&gt;--%>
                                    <%--<h5 class="blockquote-footer">${ico.start_time}</h5>--%>
                                    <%--<p class="card-text">${ico.description}</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                                <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>

                        <%--</td>--%>
                        <%--<td>--%>
                                <%--&lt;%&ndash;<c:forEach items="${finIco}" var="ico">&ndash;%&gt;--%>

                            <%--<div class="card h-30 border  border-white">--%>
                                <%--<div class="card-body">--%>
                                    <%--<img src="${ico.image}" width="200" height="50" class="rounded float-left"--%>
                                         <%--alt="Error"--%>
                                         <%--hspace="5">--%>
                                        <%--&lt;%&ndash;<h5 class="card-title">${ico.name}</h5>&ndash;%&gt;--%>
                                    <%--<h5 class="blockquote-footer">${ico.start_time}</h5>--%>
                                    <%--<p class="card-text">${ico.description}</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                                <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                        <%--</td>--%>
                    </tr>

            </table>

        </div>
    </div>


    <jsp:include page="template/footer.jsp"/>

