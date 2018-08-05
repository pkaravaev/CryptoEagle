<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="template/header.jsp"/>

<script>
    $(document).ready(function () {
        $('#dtMaterialDesignExample').DataTable();
        // $('#dtMaterialDesignExample_wrapper').find('label').each(function () {
        //     $(this).parent().append($(this).children());
        // });
        // $('#dtMaterialDesignExample_wrapper .dataTables_filter').find('input').each(function () {
        //     $('input').attr("placeholder", "Search");
        //     $('input').removeClass('form-control-sm');
        // });
        // $('#dtMaterialDesignExample_wrapper .dataTables_length').addClass('d-flex flex-row');
        // $('#dtMaterialDesignExample_wrapper .dataTables_filter').addClass('md-form');
        // $('#dtMaterialDesignExample_wrapper select').removeClass('custom-select custom-select-sm form-control form-control-sm');
        // $('#dtMaterialDesignExample_wrapper select').addClass('mdb-select');
        // $('#dtMaterialDesignExample_wrapper .mdb-select').material_select();
        // $('#dtMaterialDesignExample_wrapper .dataTables_filter').find('label').remove();
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
                    <th class="th-sm">NAME
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">PRICE
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">MARKET CAP
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">VOLUME(24h
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">CIRCULATING SUPPLY
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">CHANGE(24h)
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${coins}" var="coin">
                    <tr>
                        <%--<td>${coin.rank}</td>--%>
                        <td><img src="${coin.image}" width="60" height="60"></td>
                        <td>${coin.name}</td>
                        <td>${coin.price}$</td>
                        <td>${coin.market_cap}$</td>
                        <td>${coin.volume_24h}$</td>
                        <td>${coin.circulating_supply}${coin.symbol}</td>
                        <c:choose>
                            <c:when test="${coin.percent_change_24h > 0}">
                                <td style="color: lawngreen">  ${coin.percent_change_24h}%</td>
                            </c:when>
                            <c:when test="${coin.percent_change_24h < 0}">
                                <td style="color: red">  ${coin.percent_change_24h}%</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <%--<th>#</i>--%>
                    <%--</th>--%>
                    <th></i>
                    </th>
                    <th>NAME</i>
                    </th>
                    <th>PRICE</i>
                    </th>
                    <th>MARKET CAP</i>
                    </th>
                    <th>VOLUME(24h)</i>
                    </th>
                    <th>CIRCULATING SUPPLY</i>
                    </th>
                    <th>CHANGE(24h)</i>
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