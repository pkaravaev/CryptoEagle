$(document).ready(function () {

    getCoins();

});


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
            })

            var dataJSON = JSON.stringify([1, 'false', false]);
            $("#h1").text(summary);
        }

    });
}




