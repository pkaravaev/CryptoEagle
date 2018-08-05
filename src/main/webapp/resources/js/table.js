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

        // var x = $(this).childElementCount.get;
       var name =  $(this).find(".card-title").text();
        window.location ='/ico-page/' + name;
    })

}