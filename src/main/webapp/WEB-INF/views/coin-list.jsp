
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
                    <th></th>
                    <th>NAME</th>
                    <th>MARKET CAP</th>
                    <th>PRICe</th>
                    <th>VOLUME(24h)</th>
                    <th>CIRCULATING SUPPLY</th>
                    <th>CHANGE(24h)</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${coins}" var="coin">
                    <tr >
                        <td><img src="${coin.image}" width="50" height="50"></td>
                        <td>${coin.name}</td>
                        <td>${coin.market_cap}</td>
                        <td>${coin.price}</td>
                        <td>${coin.volume_24h}</td>
                        <td>${coin.circulating_supply}</td>
                        <td>${percent_change_24h}</td>
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