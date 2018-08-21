<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="template/header.jsp"/>

<script>
    $(document).ready(function () {
        $('#dtMaterialDesignExample').DataTable();
    });


</script>



<div class="container bg-white">
    <div class="row">

        <div class="col-sm ">
        </div>

        <div class="col-md-12">


            <table id="dtMaterialDesignExample" class="table table-striped" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <%--<th class="th-sm">#--%>
                        <%--<i class="fa fa-sort float-right" aria-hidden="true"></i>--%>
                    <%--</th>--%>
                    <th class="th-sm">
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Name
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Price
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Market cap
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Volume(24h)
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Circulating supply
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Change(24h)
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${coins}" var="coin">
                    <tr class="hoverable">
                        <%--<td>${coin.rank}</td>--%>
                        <td><img class="rounded-circle" src="${coin.image}" width="60" height="60"></td>
                        <td class="font-weight-bold">${coin.name}</td>
                        <td class="font-weight-bold">${coin.price}$</td>
                        <td class="font-weight-bold">${coin.market_cap}$</td>
                        <td class="font-weight-bold">${coin.volume_24h}$</td>
                        <td class="font-weight-bold">${coin.circulating_supply}${coin.symbol}</td>
                        <c:choose>
                            <c:when test="${coin.percent_change_24h > 0}">
                                <td class="font-weight-bold" style="color: lawngreen">  ${coin.percent_change_24h}%</td>
                            </c:when>
                            <c:when test="${coin.percent_change_24h < 0}">
                                <td class="font-weight-bold"style="color: red">  ${coin.percent_change_24h}%</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <th></i>
                    </th>
                    <th>Name</i>
                    </th>
                    <th>Price</i>
                    </th>
                    <th>Market cap</i>
                    </th>
                    <th>Volume(24h)</i>
                    </th>
                    <th>Circulating supply</i>
                    </th>
                    <th>Cahnge(24h)</i>
                    </th>
                </tr>
                </tfoot>
            </table>
            <br/>
        </div>

        <div class="col-sm ">
        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>