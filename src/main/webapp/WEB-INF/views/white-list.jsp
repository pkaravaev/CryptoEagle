<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>



<script>

    $(".table").click(function () {
        alert("xxxxx");
    })

</script>
<div class="container">

    <div class="col">


    </div>

    <div class="col-12">

        <h2 class="font-weight-bold text-center">WHITELIST</h2>
        <h6 class="font-weight-bold text-center">Current list of ICOs where Whitelist is active. Registration is required for participation.</h6>

        <!--Table-->
        <table class="table table-striped w-auto">

            <!--Table body-->
            <tbody>

            <c:forEach items="${whiteLists}" var="item">
            <tr class="table">
                <td><img width="60" src="${item.logo}" class="rounded-circle"></td>
                <td class="font-weight-bold">${item.name}</td>
                <td class="font-weight-bold">${item.category}</td>
                <td class="font-weight-bold"><span>white lsit + kyc</span></td>
                <td class="font-weight-bold">${item.status}</td>
            </tr>
            </c:forEach>
            </tbody>
            <!--Table body-->

        </table>
        <!--Table-->

    </div>

    <div class="col">


    </div>

</div>

<jsp:include page="template/footer.jsp"/>