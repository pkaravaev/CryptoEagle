$(document).ready(function () {

    $("button").click(function () {


        var coins = $.getJSON("/ajax/coins");


        coins.forEach(function (element) {
            $('#table tr:last').after('<tr> element </tr><tr> element</tr>');
        });


    });
});