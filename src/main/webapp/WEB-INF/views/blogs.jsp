<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="template/header.jsp"/>


<div class="container">
    <div class="row">

        <div class="col align-self-start">

        </div>

        <div class="col-11 align-self-center ">

            <script type="text/javascript">

                $(document).ready(function () {
                    $('.nav-tabs a:first').tab('show'); // Select first tab
                    $('.triggerRemove').click(function (e) {
                        e.preventDefault();
                        $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
                        $("#modalRemove").modal();
                    });
                });

            </script>

            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <c:forEach items="${user.blogs}" var="blog">
                    <li class="nav-item">
                        <a class="nav" href="#blog_${blog.id}" data-toggle="tab">${blog.name}</a>
                    </li>
                </c:forEach>
            </ul>


            <!-- Tab panes -->
            <div class="tab-content">
                <h2>Navigation Tabs</h2>
                <p>Turn the nav menu into navigation tabs with the .nav nav-tabs class. Add the active class to the active/current link. If you want the tabs to be togglable, see the last example on the tutorial page.</p>
                <c:forEach items="${user.blogs}" var="blog">
                    <div class="tab-pane" id="blog_${blog.id}">
                        <h1>${blog.name}</h1>
                        <p>
                            <a href="<sping:url value="/blog/remove/${blog.id}"/> "
                               class="btn btn-danger triggerRemove">remove blog</a>
                                ${blog.url}</p>
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Title</th>
                                <th>Link</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${blog.items}" var="item">
                                <tr>
                                    <td>${item.title}</td>
                                    <td>${item.link}</td>
                                    <td><a class="btn btn-primary btn-warning" href="/item/edit/${item.id}" role="button">edit</a></td>
                                    <td><a class="btn btn-primary btn-warning" href="/item/delete/${item.id}" role="button">delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:forEach>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Remove blog</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Really remove?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <a href="" class="btn btn-danger removeBtn">Remove</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script>
            $(function () {
                $('#myTab li:last-child a').tab('show')
            })
        </script>


        <div class="col align-self-end">

        </div>


    </div>
</div>


<jsp:include page="template/footer.jsp"/>