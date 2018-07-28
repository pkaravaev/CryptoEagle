
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:include page="template/header.jsp"/>


<div class="container ">
    <div class="row">
        <div class="col-sm ">

        </div>
        <div class="col-md-12">
            <table id="data-table" class="table" >
                <br/>
                <thead class="bg-light" >
                <tr>
                    <th></th>
                    <th>PROJECT</th>
                    <th>DESCRIPTION</th>
                    <th>START TIME</th>
                    <th>END TIME</th>
                    <th>RATING</th>


                </tr>
                </thead>
                <tbody>

                <c:forEach items="${icos}" var="ico">
                    <tr >
                        <td><img src="${ico.logolink} "></td>
                        <td>${ico.name}</td>
                        <td>${ico.description}</td>
                        <fmt:parseDate value="${icoEnd}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                        <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}" />
                        <td>${parsedDateTime}</td>
                        <td>${ico.icoEnd}</td>
                        <td>${ico.rating}</td>


                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <br/>
        </div>
        <div class="col-sm ">


        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>