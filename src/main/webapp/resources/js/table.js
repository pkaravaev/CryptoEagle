$(document).ready(function () {
    modal();
})


function modal() {


    $(".card").mouseenter(function () {
        $(this).css('cursor', 'pointer');
        var title = $(this).find(".title").text();
        var description = $(this).find(".description").text();
        var date = $(this).find(".date").text();

        {
            $(this).append("<div class=\"card-img-overlay  animated bounceInUp\">\n" +
                "                    <p class=\"card-text text-white brown darken-2\"> " + description + " </p>\n" +
                "                </div>")
        }
    })

    $(".card").mouseenter(function () {
        $(this).css('cursor', 'pointer');

    })

    $(".card").mouseleave(function () {
        $(this).find(".card-img-overlay").removeClass("animated bounceInUp").removeClass("animated shake").addClass("animated fadeOutDown");
    })

    $(".coin").mouseenter(function () {
        $(this).css("cursor", "hand");
    })

    $(".coin").mouseleave(function () {
        $(this).css("cursor", "point");
    })

    $("#icoCard").dblclick(function () {
        var symbol = $(this).find("td")[1].innerText;
        window.location.href = "/coin-page/" + symbol;
    })

    $(".coin").click(function () {
        var symbol = $(this).find("td")[1].innerText;
        window.location.href = "/coin-page/" + symbol;
    })

    $(".r").click(function () {
        var name = $(this).find(".name").text();
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
    })

    $(".card").dblclick(function () {
        var href = $(this).find(".href").text();
        $(location).attr("href", href);
    })

    $("#ico-card").click(function () {
        var name = $(this).find(".href").text();
        if (name != 0)
            window.location.href = "/ico-page/" + name;
    })

    $("#blogDelete ").click(function () {
        var blogName = $("#blogName").text();
        $.ajax({
            url: "/blog/remove",
            type: 'GET',
            data: {name: blogName}
        })

        window.location.href = "/user-profile";
    })

    $("#blogButton").click(function () {
        var blogName = $("#defaultForm-name").val();
        var blogUrl = $("#defaultForm-url").val();

        $.ajax({
            url: "/blog/add",
            type: 'GET',
            data: {name: blogName, url: blogUrl},
            success: function () {
            }
        })

        window.location.href = "/user-profile";

        // $('#modalLoginForm').modal('hide')
    })

    $("#modal").click(function () {
        $("#modalLRForm").modal('show');
    })

    $("#log").click(function () {
        var x = $(this).parent().parent().find("input");
        var e = x[0].value;
        var p = x[1].value;

        var suc = function () {
            $("#modalLRForm").modal('hide');
        }

        $.ajax({
            url: "/login",
            type: 'POST',
            data: {username: e, password: p}
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
            data: {name: n, email: e, password: p, password_again: r}
        })

        $("#modalLRForm").modal('hide');

    })

    $("button").click(function () {
        var href = $(this).attr("value");

        if (href != null)
            window.location = href;

    })

}