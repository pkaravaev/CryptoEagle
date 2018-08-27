<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>

    $(document).ready(function () {

        $("#blogButton").click(function () {
            $(".modal-content").find("input");
        })
    })
</script>


<br/>
<c:choose>


    <h1 class="text-center">WELCOME! ${sessionScope.get("user").name}</h1>


    <div class="container">


    <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header text-center">
    <h4 class="modal-title w-100 font-weight-bold">Blog add</h4>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
    <span aria-hidden="true">&times;</span>
    </button>
    </div>
    <div class="modal-body mx-3">
    <div class="md-form mb-5">
    <i class="fa fa-edit prefix grey-text"></i>
    <input type="text" id="defaultForm-name" class="form-control validate">
    <label data-error="wrong" data-success="right" for="defaultForm-name">Blog name</label>
    </div>

    <div class="md-form mb-4">
    <i class="fa fa-rss prefix grey-text"></i>
    <input type="text" id="defaultForm-url" class="form-control validate">
    <label data-error="wrong" data-success="right" for="defaultForm-url">Blog url</label>
    </div>

    </div>
    <div class="modal-footer d-flex justify-content-center">
    <button id="blogButton" class="btn btn-brown">Save</button>
    </div>
    </div>
    </div>
    </div>

    <div class="text-center">
    <a href="" class="btn btn-brown btn-rounded mb-4 hoverable" data-toggle="modal" data-target="#modalLoginForm">Blog add</a>
    </div>


    <c:forEach items="${blogs}" var="blog">

        <div class="card hoverable">
            <div class="card-body">
                    ${blog.name}
                    ${blog.url}
            </div>
        </div>


        <div class="card hoverable">
            <div class="card-body">
                    ${blog.name}
                    ${blog.url}
            </div>
        </div>

        <br/>

    </c:forEach>


    </div>


    <jsp:include page="template/footer.jsp"/>