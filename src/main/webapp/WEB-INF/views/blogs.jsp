<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<div class="container">
    <div class="row">
        <div class="col-sm">

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
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${userList}" var="user">

                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.blogs.size()}</td>
                        <td>${user.admin}</td>
                        <td>${user.enable}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="col-sm">


        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>