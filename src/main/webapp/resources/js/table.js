$(document).ready(function () {


    tt();


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

// function card() {
//
//     $(".card").click(function () {
//
//         var title =  $(this).find(".title").text();
//         var description =  $(this).find(".description").text();
//
//         var name = $(this).find(".href").text();
//
//
//         var date =  $(this).find(".date").text();
//         var href =  $(this).find(".href").text();
//
//         var contain = $(".card-img-overlay").hasClass("animated bounceInUp");
//
//         if(contain){
//             $(".card-img-overlay").removeClass("animated bounceInUp")
//             $(".card-img-overlay").addClass("animated zoomOutUp")
//          }
//
//     })
//
//     $(".card").contextmenu(function () {
//
//         var url = $(this).find("p").text();
//         window.location.href = url;
//
//
//     })
//
//     $(".card").mouseleave(function () {
//
//         var contain = $(".card-img-overlay").hasClass("animated bounceInUp");
//
//         $(this).find(".card-img-overlay").removeClass("animated bounceInUp").addClass("animated fadeOutDown");
//         // $(this).find(".card-img-overlay").addClass("animated fadeOutDown")
//         $(this).removeClass("animated shake");
//     })
// }