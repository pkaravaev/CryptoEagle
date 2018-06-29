<jsp:include page="template/header.jsp"/>

<form class="form-horizontal registrationForm" action="/register" method="post">

    <div class="alert alert-info">
        Didn't find your favourite blog? Register and submit a missing blog.
        Otherwise you don't have to register.
    </div>



    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name" value="" />

        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="email" name="email" value="" />

        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="password" value="" />

        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password again:</label>
        <div class="col-sm-10">
            <input type="password" name="password_again" id="password_again" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <input type="submit" value="Save" class="btn btn-lg btn-primary" />
        </div>
    </div>
</form>

<jsp:include page="template/footer.jsp"/>