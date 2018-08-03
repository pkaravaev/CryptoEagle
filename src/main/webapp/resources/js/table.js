$(document).ready(function () {


    tt();
    card();

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
    $(".card").click(function () {

        var name =  $(this).find("a").text();
        window.location = name;
    })


}