$(document).ready(function () {


    modal();


})


function modal() {

    $(".r").click(function () {
        var name = $(this).find("#name").text();
        window.location.href = "/ico-page/" + name;
    })

    $(".team").click(function () {
        var url = $(this).find("a").attr('href');
        window.open(url);
    })

    $(".r").dblclick(function () {
        var t = $(this).find(".href");
        window.location.href = "/ico-page/" + name;
    })

    $(".r").mouseleave(function () {
        $(this).removeClass("animated shake");
    })


    $(".r").mouseenter(function () {
        $(this).css('cursor', 'pointer');
        $(this).addClass("animated shake")
        $(".container").addClass("animated shake")
    })


    $(".btn").click(function () {
        var url = $(this).val();
        // window.location.href = "http://stackoverflow.com";
        window.location.href = url;
    })

    $("#ico-card").click(function () {

        var name = $(this).find(".href").text();
        if (name != 0)
            window.location.href = "/ico-page/" + name;

    })


    $("#modal").click(function () {

        $("#modalLRForm").modal('show');
    })

    $("#log").click(function () {
        var x = $(this).parent().parent().find("input");

        var e = x[0].value;
        var p = x[1].value;

        var suc = function () {

            alert("success");
            $("#modalLRForm").modal('hide');
        }

        $.ajax({
            url: "/login",
            type: 'POST',
            data: {email: e, password: p},
            success: suc()
        })

    })

    $("#reg").click(function () {
        var x = $(this).parent().parent().find("input");

        var n = x[0].value;
        var e = x[1].value;
        var p = x[2].value;
        var r = x[3].value;

        var er = function () {

            alert("Error")
            $(this).hide();
        }


        $.ajax({
            url: "/register",
            type: 'POST',
            data: {name: n, email: e, password: p, password_again: r},
            error: er()
        })

    })

}

