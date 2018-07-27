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


<style>

   @import url(http://fonts.googleapis.com/css?family=Open+Sans);
   body {
      font-family: "Open Sans", sans-serif;
   }
   table {
      border: 1px solid #ccc;
      border-collapse: collapse;
      margin:0;
      padding:0;
      width: 100%;
   }
   table tr {
      border: 1px solid #ddd;
      padding: 5px;
   }
   table th, table td {
      padding: 10px;
      text-align: center;
   }
   table th {
      font-size: 14px;
      letter-spacing: 1px;
      text-transform: uppercase;
   }
   @media screen and (max-width: 600px) {
      table {
         border: 0;
      }
      table thead {
         display: none;
      }
      table tr {
         border-bottom: 2px solid #ddd;
         display: block;
         margin-bottom: 10px;
      }
      table td {
         border-bottom: 1px dotted #ccc;
         display: block;
         font-size: 13px;
         text-align: right;
      }
      table td:last-child {
         border-bottom: 0;
      }
      table td:before {
         content: attr(data-label);
         float: left;
         font-weight: bold;
         text-transform: uppercase;
      }
   }

</style>

<table>
   <thead>
   <tr>
      <th>Payment</th>
      <th>Issue Date</th>
      <th>Amount</th>
      <th>Period</th>
   </tr>
   </thead>
   <tbody>
   <tr>
      <td data-label="Payment">Payment #1</td>
      <td data-label="Issue Date">02/01/2015</td>
      <td data-label="Amount">$2,311</td>
      <td data-label="Period">01/01/2015 - 01/31/2015</td>
   </tr>
   <tr>
      <td data-label="Payment">Payment #2</td>
      <td data-label="Issue Date">03/01/2015</td>
      <td data-label="Amount">$3,211</td>
      <td data-label="Period">02/01/2015 - 02/28/2015</td>
   </tr>
   </tbody>
</table>



</body>

<jsp:include page="template/footer.jsp"/>