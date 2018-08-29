<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>

    $(document).ready(function () {

        $(".card").mouseenter(function () {
            $(this).css('cursor', 'pointer');
            $(this).addClass("animated shake")
            $(".container").addClass("animated shake")
        })

        $(".card").mouseleave(function () {
            $(this).find(".card-img-overlay").removeClass("animated bounceInUp").removeClass("animated shake").addClass("animated fadeOutDown");
            $(this).removeClass("animated shake");
        })

        $("#exampleModalCenter").show();

    })
</script>


<br/>


<div class="container">

    <div class="row">

        <div class="col">
            <h1 class="text-right font-weight-normal"> Welcome ${name}</h1>
        </div>

        <div class="col">
            <div class="text-left">
                <a id="addBlogButton"  class="btn del btn-brown btn-rounded mb-4 hoverable" data-toggle="modal" data-target="#modalLoginForm">Add
                    Blog</a>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">

            <div class="modal-content">

                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Add blog</h4>
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

    <c:forEach items="${blogs}" var="blog">

        <div class="card hoverable">

            <div class="card-body">

                <div class="row">

                    <div class="col-lg-1">
                        <i style="color: #6f42c1" class="fas fa-rss fa-2x"></i>
                    </div>

                    <div class="col">
                        <p id="blogName" class="text-center font-weight-bold">${blog.name}</p>
                    </div>

                    <div class="col">
                        <h6 class="text-left font-weight-bold"> ${blog.url}</h6>
                    </div>

                    <div class="col">
                        <div class="float-right">
                            <button id="blogDelete" type="button-right" class="btn btn-brown">Delete</button>
                        </div>
                    </div>

                </div>

            </div>
        </div>

        <br/>

    </c:forEach>

</div>


<jsp:include page="template/footer.jsp"/>