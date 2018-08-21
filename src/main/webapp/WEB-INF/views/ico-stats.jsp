<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="template/header.jsp"/>



<script>

   $(document).ready(function () {
       $('#dtMaterialDesignExample').DataTable();

       // $(".r").mouseenter(function () {
       //     $(this).css('cursor', 'pointer');
       //     $(this).addClass("animated shake")
       //     $(".container").addClass("animated shake")
       // })
       //
       // $(".r").mouseleave(function () {
       //     $(this).removeClass("animated shake");
       // })
       //
       // $(".r").click(function () {
       //     alert("xxxx");
       // })
   });

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
                    <th class="th-sm ">
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
                    <tr class="r hoverable">

                        <td><img  class="rounded-circle" src="${ico.logolink} "></td>

                        <td id="name" class="font-weight-bold text-center">${ico.name}</td>

                        <td class="font-weight-bold text-center">${ico.description}</td>

                        <fmt:parseDate value="${ico.icoStart}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime1"
                                       type="both"/>
                        <fmt:formatDate pattern="dd.MM.yyyy" value="${parsedDateTime1}" var="icoStart"/>



                        <fmt:parseDate value="${ico.icoEnd}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime2"
                                       type="both"/>

                        <fmt:formatDate pattern="dd.MM.yyyy" value="${parsedDateTime2}" var="icoEnd"/>

                        <td  class="font-weight-bold">${icoStart}</td>

                        <td class="font-weight-bold">${icoEnd}</td>

                        <c:choose>

                            <c:when test="${ico.rating > 3 && ico.rating <  4}">
                                <td style="color: #ffbb33" class="font-weight-bold ">${ico.rating}</td>
                            </c:when>

                            <c:when test="${ico.rating > 4 && ico.rating  <  4.5}">
                                <td  style="color: #FF8800" class="font-weight-bold">${ico.rating}</td>
                            </c:when>

                            <c:when test="${ico.rating > 4.5 }">
                                <td  style="color: #00695c" class="font-weight-bold">${ico.rating}</td>
                            </c:when>

                        </c:choose>

                    </tr>

                </c:forEach>

                </tbody>

                <tfoot>
                <tr>
                    <th></i>
                    </th>
                    <th class="font-weight-bold">Name</i>
                    </th>
                    <th class="font-weight-bold">Description</i>
                    </th>
                    <th class="font-weight-bold">Start date</i>
                    </th>
                    <th class="font-weight-bold">End date</i>
                    </th>
                    <th class="font-weight-bold">Rating</i>
                    </th>
                </tr>
                </tfoot>
            </table>
        </div>

    </div>

</div>



<jsp:include page="template/footer.jsp"/>