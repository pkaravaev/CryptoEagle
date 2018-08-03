$(document).ready(function () {

    getCoins();


})
function getCoins() {
    $.ajax({
        url: '/ajax/coins',
        dataType: 'json',
        type: 'get',
        cache: true,
        success: function (data) {
            var summary = " ";
            data.forEach(function (element, index) {
                var name = element.name;
                var symbol = element.symbol;
                var price = element.price;
                var change = element.percent_change_24h;


                summary += " " + symbol + "  " + price + "$  ";
                if(symbol == 'BTC') {
                    $("#symbolb").text(symbol);
                    $("#priceb").text(price.toFixed(2) + '$');

                    if (change > 0)
                    {
                        $("#changeb").css('color','green');
                    }
                    else {
                        $("#changeb").css('color','red');

                    }
                    $("#changeb").text(change + '%');
                }

                if(symbol == 'ETH') {
                    $("#symbole").text(symbol);
                    $("#pricee").text(price.toFixed(2) + '$');
                    if (change > 0)
                    {
                        $("#changee").css('color','green');
                    }
                    else {
                        $("#changee").css('color','red');

                    }
                    $("#changee").text(change + '%');
                }

                if(symbol == 'NEO') {
                    $("#symboln").text(symbol);
                    $("#pricen").text(price.toFixed(2) + '$');
                    if (change > 0) {
                        $("#changen").css('color', 'green');
                    }
                    else {
                        $("#changen").css('color', 'red');

                    }
                    $("#changen").text(change + '%');
                }

                    if(symbol == 'EOS') {
                        $("#symboleo").text(symbol);
                        $("#priceeo").text(price.toFixed(2) + '$');
                        if (change > 0)
                        {
                            $("#changeeo").css('color','green');
                        }
                        else {
                            $("#changeeo").css('color','red');

                        }
                        $("#changeeo").text(change + '%');
                }

                if(symbol == 'XRP') {
                    $("#symbolxr").text(symbol);
                    $("#pricexr").text(price.toFixed(2) + '$');
                    if (change > 0)
                    {
                        $("#changexr").css('color','green');
                    }
                    else {
                        $("#changexr").css('color','red');

                    }
                    $("#changexr").text(change + '%');
                }

            })

            var dataJSON = JSON.stringify([1, 'false', false]);

        }

    });
}



function getPrice() {
    $.ajax({

        type:"POST",
        url: "/ajax/price",
        success :function (data) {
            $(".h1").text(data.price);
        }

    });
}

