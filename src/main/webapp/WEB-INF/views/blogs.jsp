<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>


<jsp:include page="template/header.jsp"/>


<!-- Nav tabs -->
<ul class="nav nav-tabs">
    <c:forEach items="${blogs}" var="blog">
        <li><a href="#blog_${blog.id}" data-toggle="tab">${blog.name}</a></li>
    </c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <c:forEach items="${blogs}" var="blog">

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
                        <%--<td>${item.publishedDate}</td>--%>
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


<jsp:include page="template/footer.jsp"/>