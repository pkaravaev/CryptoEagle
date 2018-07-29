<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>

<head>

   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.css"/>
   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.css.map"/>
   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css"/>



</head>

<body>

<div class="container">

   <div class="row">
      <div class="col-sm-3">

         <div class="rating-block">

            <h4>rating</h4>

            <h2 class="bold padding-bottom-7">4.3 <small>/ 5</small></h2>

            <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
               <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            </button>

            <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
               <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            </button>

            <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
               <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            </button>

            <button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
               <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            </button>

            <button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
               <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            </button>

         </div>

      </div>

   </div>

</div> <!-- /container -->



</body>

<jsp:include page="template/footer.jsp"/>