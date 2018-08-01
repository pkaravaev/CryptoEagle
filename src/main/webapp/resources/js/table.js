$(document).ready(function () {


    tt();

})

function tt() {

    $(".btn").click(function () {
        var url = $(this).val();
        $(location).attr("href", url);
    })
}