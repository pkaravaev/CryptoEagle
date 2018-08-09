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
                    <th class="th-sm">
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Name
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>

                    <th class="th-sm">Description
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Start date
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">End date
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Rating
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${icos}" var="ico">
                    <tr>
                        <td><img  class="rounded-circle" src="${ico.logolink} "></td>
                        <td>${ico.name}</td>
                        <td>${ico.description}</td>
                        <fmt:parseDate value="${ico.icoStart}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime1"
                                       type="both"/>
                        <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime1}" var="icoStart"/>
                        <fmt:parseDate value="${ico.icoEnd}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime2"
                                       type="both"/>
                        <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime2}" var="icoEnd"/>
                        <td>${icoStart}</td>
                        <td>${icoEnd}</td>
                        <td>${ico.rating}</td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <th></i>
                    </th>
                    <th>Name</i>
                    </th>
                    <th>Description</i>
                    </th>
                    <th>Start date</i>
                    </th>
                    <th>End date</i>
                    </th>
                    <th>Rating</i>
                    </th>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
    <div class="col-sm ">
    </div>
</div>
</div>


<jsp:include page="template/footer.jsp"/>