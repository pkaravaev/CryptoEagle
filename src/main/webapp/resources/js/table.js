$(document).ready(function () {


    modal();

    var contain = $("div:has(p)");

    $("#login").click(function () {
        var href = $(this).attr('href');
        $(href).modal('show')
    })

})

function tt() {

    $("button").click(function () {
        var url = $(this).val();
        $(location).attr("href", url);
    })
}

function modal() {

    $("#log").click(function () {
        var x = $(this).parent().parent().find("input");
        var p = x[0].value;
        var e = x[1].value;

        $.ajax({
            url: "/login",
            type: 'POST',
            data: {email: e, password: p}
        })

    })

    $("#reg").click(function () {
        var x = $(this).parent().parent().find("input");

        var n = x[0].value;
        var e = x[1].value;
        var p = x[2].value;
        var r = x[3].value;

        $.ajax({
            url: "/register",
            type: 'POST',
            data: {name:n, email: e, password: p, password_again:r}
        })

    })

}

