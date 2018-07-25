<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>

<head>

   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.css"/>
   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.css.map"/>
   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css"/>



</head>

<body>

<script>

    $(document).ready(function () {

        $(".table").click(function () {

            var url = "coin-list";
            $(location).attr("href", url);
        })


        // $('#table1,#table2').dataTable( {
        //     "searching": false,
        //     "paging":false,
        //     "info": false,
        //     "autoWidth": true
        //
        // } );


        $(".card").click(function () {
            var h = $(this).children();
            var url = h.children()[1].href;
            $(location).attr("href", url);
        })


        $(".card").mouseenter(function () {
            $(this).addClass("shadow-sm p-3 mb-5 bg-white rounded");
        })

        $(".card").mouseleave(function () {
            $(this).removeClass("shadow-sm p-3 mb-5 bg-white rounded");
        })

    })


</script>



<div class="row mb-2">
   <div class="col-md-6">
      <div class="card flex-md-row mb-4 shadow-sm h-md-250">
         <div class="card-body d-flex flex-column align-items-start">
            <strong class="d-inline-block mb-2 text-primary">World</strong>
            <h3 class="mb-0">
               <a class="text-dark" href="#">Featured post</a>
            </h3>
            <div class="mb-1 text-muted">Nov 12</div>
            <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
            <a href="#">Continue reading</a>
         </div>
         <img class="card-img-left flex-auto d-none d-lg-block" src="https://icowatchlist.com/logos/trustedcars-flex.png" alt="Card  cap">
      </div>
   </div>
   <div class="col-md-6">
      <div class="card flex-md-row mb-4 shadow-sm h-md-250">
         <div class="card-body d-flex flex-column align-items-start">
            <strong class="d-inline-block mb-2 text-success">Design</strong>
            <h3 class="mb-0">
               <a class="text-dark" href="#">Post title</a>
            </h3>
            <div class="mb-1 text-muted">Nov 11</div>
            <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
            <a href="#">Continue reading</a>
         </div>
         <img class="card-img-right flex-auto d-none d-lg-block" data-src="https://icowatchlist.com/logos/kasko2go.png" alt="Card  cap">
      </div>
   </div>
</div>


</body>

<jsp:include page="template/footer.jsp"/>