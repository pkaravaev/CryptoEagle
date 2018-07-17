<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
            integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
            crossorigin="anonymous"></script>
</head>
<body>


<div class="container">
    <h2>${user.name} account.</h2>


    <br>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">

        <c:forEach items="${user.blogs}" var="blog">
            <li class="nav-item">
                <a class="nav-link " data-toggle="tab" href="#${blog.name}">${blog.name}</a>
            </li>
        </c:forEach>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">

        <c:forEach items="${user.blogs}" var="blog">

            <div id="${blog.name}" class="container tab-pane active"><br>
                <h3>HOME</h3>
                <p>${blog.id}</p>
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
                            <td><a class="btn btn-primary btn-warning " href="/item/edit/${item.id}"
                                   role="button">edit</a></td>
                            <td><a class="btn btn-primary btn-error" href="/item/delete/${item.id}" role="button">delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>

        </c:forEach>

    </div>
</div>


<script>


</script>


</body>

