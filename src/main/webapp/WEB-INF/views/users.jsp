<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<div class="container">
    <div class="row">
        <div class="col-md ">

        </div>
        <div class="col-md-8">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Blogs</th>
                    <th scope="col">Admin</th>
                    <th scope="col">Enable</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="appUser">
                    <tr>
                        <td>${appUser.id}</td>
                        <td>${appUser.name}</td>
                        <td>${appUser.email}</td>
                        <td>${appUser.blogs.size()}</td>
                        <td>${appUser.admin}</td>
                        <td>${appUser.enable}</td>
                        <td><a class="btn btn-primary btn-warning" href="/users/edit/${appUser.id}" role="button">edit</a></td>
                        <td><a class="btn btn-primary btn-danger" href="/users/delete/${appUser.id}" role="button">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md ">


        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>