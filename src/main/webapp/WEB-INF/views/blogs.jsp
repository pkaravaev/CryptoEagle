<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<%--<div class="container">--%>
<%--<div class="row">--%>
<%--<div class="col-sm">--%>

<%--</div>--%>
<%--<div class="col-11 align-self-center ">--%>


<%--</div>--%>
<%--<div class="col-sm">--%>

<%--<ul class="nav nav-tabs " id="myTab">--%>

<%--<c:forEach items="${blogs}" var="blog">--%>

<%--<li class="nav-item">--%>
<%--<a class="nav-link  active " href="#">${blog.name}</a>--%>
<%--&lt;%&ndash;<table class="table">&ndash;%&gt;--%>
<%--&lt;%&ndash;<thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th scope="col">#</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th scope="col">First</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th scope="col">Last</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th scope="col">Handle</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;</thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th scope="row">1</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>Mark</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>Otto</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>@mdo</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;</table>&ndash;%&gt;--%>
<%--</li>--%>


<%--</c:forEach>--%>

<%--</ul>--%>

<%--<script>--%>
<%--$('#myTab ').on('click', function (e) {--%>
<%--e.preventDefault()--%>
<%--$(this).tab('show')--%>
<%--})--%>
<%--</script>--%>

<%--</div>--%>
<%--</div>--%>
<%--</div>--%>


<div class="container">

    <ul class="nav nav-pills" role="tablist">
        <c:forEach items="${blogs}" var="blog">
            <li class="nav-item">
                <a class="nav-link " data-toggle="pill" href="#${blog.name}">${blog.name}</a>
            </li>
        </c:forEach>
    </ul>

<c:forEach items="${blogs}" var="blog">

</c:forEach>
    <!-- Tab panes -->
    <div class="tab-content">


        <c:forEach items="${blogs}" var="blog">


        <div id="home" class="container tab-pane active"><br>
            <h3>HOME</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua.</p>
        </div>
        </c:forEach>



        <div id="menu1" class="container tab-pane fade"><br>
            <h3>Menu 1</h3>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                consequat.</p>
        </div>
        <div id="menu2" class="container tab-pane fade"><br>
            <h3>Menu 2</h3>
            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam
                rem aperiam.</p>
        </div>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>