$(document).ready(function () {


    modal();


})

function modal() {


    $("#modal").click(function () {

        $("#modalLRForm").modal('show');
    })

    $("#log").click(function () {
        var x = $(this).parent().parent().find("input");

        var e = x[0].value;
        var p = x[1].value;

        var suc = function(){

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

        var er = function(){

            alert("Error")
            $(this).hide();
        }


        $.ajax({
            url: "/register",
            type: 'POST',
            data: {name:n, email: e, password: p, password_again:r},
            error : er()
        })

    })

}

