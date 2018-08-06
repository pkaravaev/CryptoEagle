$(document).ready(function () {


    tt();
    card();

    $("#login").click(function () {
        var href = $(this).attr('href');
        $(href).modal('show')
    })

})

function tt() {

    $(".btn").click(function () {
        var url = $(this).val();
        $(location).attr("href", url);
    })
}

function card() {

    $(".card").click(function () {

        var title =  $(this).find(".title").text();
        var description =  $(this).find(".description").text();
        var date =  $(this).find(".date").text();
        var href =  $(this).find(".href").text();

    })

}