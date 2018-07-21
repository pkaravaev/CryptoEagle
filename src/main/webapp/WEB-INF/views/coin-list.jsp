
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<div class="container ">
    <div class="row">
        <div class="col-sm ">

        </div>
        <div class="col-md-12">
            <table id="myTable" class="table" >
                <br/>
                <thead class="bg-light" >
                <tr>
                    <th>PROJECT</th>
                    <th>NAME</th>
                    <th>SYMBOL</th>
                    <th>ICO PRICE</th>
                    <th>MARKET PRICE</th>
                    <th>START TIME</th>
                    <th>END TIME</th>
                    <th>ROI</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${coins}" var="coin">
                    <tr >
                        <td><img src="${coin.image} "></td>
                        <td>${coin.name}</td>
                        <td>${coin.symbol}</td>
                        <td>${coin.fullname}</td>

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