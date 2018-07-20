<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
            integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.js"></script>


    <title>Test page</title>
</head>

<body>


<script>

    $(document).ready(function () {
        $('#myTable').DataTable();
    });
</script>


<div class="container">
    <div class="row">
        <div class="col-sm">
            <h1>blablalbla</h1>
        </div>

        <div class="col-11 align-self-center">

            <table id="myTable" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th></th>
                    <th>PROJECT</th>
                    <th>SYMBOL</th>

                    <th>MARKET PRICE</th>
                    <th>START TIME</th>
                    <th>END TIME</th>
                    <th>ROI</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${icos}" var="ico">
                    <tr>
                        <td><img src="${ico.image} "></td>
                        <td>${ico.name}</td>
                        <td>${ico.coin_symbol}</td>

                        <td>${ico.price_usd}</td>
                        <td>${ico.start_time}</td>
                        <td>${ico.end_time}</td>
                        <td>${ico.all_time_roi}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>


        <div class="col-sm">
            <h1>blablalbla</h1>
        </div>
    </div>
</div>


</body>











