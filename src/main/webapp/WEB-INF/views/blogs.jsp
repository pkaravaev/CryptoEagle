<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<div class="container">
    <div class="row">
        <div class="col-sm">

        </div>
        <div class="col-md-8">

            <div class="tab-content">
                <c:forEach items="${appUser.blogs}" var="blog">

                    <div class="tab-pane" id="blog_${blog.id}">
                        <h1>${blog.name}</h1>
                        <p>
                            <a href="<sping:url value="/blog/remove/${blog.id}.html"/> " class="btn btn-danger triggerRemove">remove
                                blog</a>
                                ${blog.url}</p>

                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>date</th>
                                <th>item</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${blog.items}" var="item">
                                <tr>
                                    <td>${item.publishedDate}</td>
                                    <td>
                                        <strong>
                                            <a href="<c:out value="${item.link}" />" target="_blank">
                                                <c:out value="${item.title}"/>
                                            </a>
                                        </strong>
                                        <br/>
                                            ${item.description}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:forEach>
            </div>


        </div>
        <div class="col-sm">


        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>