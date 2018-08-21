<jsp:include page="template/header.jsp"/>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript">
        window.onload = function () {

            var dataPoints = [];
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2", // "light1", "dark1", "dark2"
                animationEnabled: true,
                exportEnabled: true,
                zoomEnabled: true,
                title: {
                    text: "Bitcoin"
                },
                subtitles: [{
                    text: "2012 - 2017"
                }],
                axisX: {
                    valueFormatString: "YYYY"
                },
                axisY: {
                    title: "Price (in USD)",
                    prefix: "$",
                    includeZero: false
                },
                data: [{
                    type: "candlestick",
                    xValueType: "dateTime",
                    xValueFormatString: "MMM YYYY",
                    yValueFormatString: "$#,##0.00",
                    dataPoints: dataPoints
                }]
            });

            $.getJSON("http://localhost:8080/restfull-service/starbucks-corporation-stock-price.json", parseData);

            function parseData(result) {
                for (var i = 0; i < result.length; i++) {
                    dataPoints.push({
                        x: result[i].x,
                        y: result[i].y
                    });
                }
                chart.render();
            }

        }
    </script>
</head>
<body>


<br/>
<div class="container">


    <div class="row">

        <div class="col">

        </div>




        <div class="col-8">

            <div class="row">

                <div class="col">

                    <div class="row">

                        <div class="col">
                            <!-- Hoverable -->
                            <img src="${coin.image}" class="img-fluid rounded-circle hoverable" alt="hoverable">

                            <h4>${coin.name}</h4>
                        </div>

                    </div>



                </div>

                <div class="col">

                    <h6 class="font-weight-bold text-center">market cap</h6>
                    <h4>${coin.market_cap}$</h4>
                </div>

                <div class="col">

                    <h6 class="font-weight-bold text-center">change 1h</h6>
                    <h4 class="text-center">${coin.percent_change_1h}%</h4>
                </div>

                <div class="col">
                    <h6 class="font-weight-bold text-center">chnage 7d</h6>
                    <h4 class="text-center">${coin.percent_change_7d}%</h4>
                </div>

                <div class="col">
                    <h6 class="font-weight-bold text-center">change 24h</h6>
                    <h4 class="text-center">${coin.percent_change_24h}%</h4>
                </div>

            </div>


            <div id="chartContainer" style="height: 370px; width: 100%;"></div>

        </div>



        <div class="col">

        </div>


    </div>


</div>


<br/>

<br/>
<br/>


    <script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>


<jsp:include page="template/footer.jsp"/>