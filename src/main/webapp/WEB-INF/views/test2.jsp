
<jsp:include page="template/header.jsp"/>

<style>
    * {
        box-sizing: border-box;
        color: #666;
    }
    *:focus, *:active, *:focus:active {
        outline: none;
    }

    body {
        padding-bottom: 20px;
    }

    h4 {
        margin: 0 0 15px;
    }

    hr {
        border: none;
        border-top: 1px solid #ccc;
        margin: 20px auto;
        width: 90%;
    }

    section {
        padding: 0 15px;
        text-align: center;
    }
    section > div {
        margin-bottom: 20px;
        float: left;
        width: 50%;
    }
    section.simple [class*=rating-] {
        height: 20px;
        margin: 0 auto;
        position: relative;
        text-align: center;
        width: 94px;
    }
    section.simple [class*=rating-]:before, section.simple [class*=rating-]:after {
        color: #ccc;
        content: "";
        font-family: FontAwesome;
        font-size: 20px;
        left: 0;
        position: absolute;
        top: 0;
    }
    section.simple [class*=rating-]:after {
        color: orange;
    }
    section.simple [class*=rating-].rating-0:after {
        content: "";
    }
    section.simple [class*=rating-].rating-0_5:after {
        content: "";
    }
    section.simple [class*=rating-].rating-1:after {
        content: "";
    }
    section.simple [class*=rating-].rating-1_5:after {
        content: "";
    }
    section.simple [class*=rating-].rating-2:after {
        content: "";
    }
    section.simple [class*=rating-].rating-2_5:after {
        content: "";
    }
    section.simple [class*=rating-].rating-3:after {
        content: "";
    }
    section.simple [class*=rating-].rating-3_5:after {
        content: "";
    }
    section.simple [class*=rating-].rating-4:after {
        content: "";
    }
    section.simple [class*=rating-].rating-4_5:after {
        content: "";
    }
    section.simple [class*=rating-].rating-5:after {
        content: "";
    }
    section.simple .fill [class*=rating-]:before {
        content: "";
    }
    section.precise .slider {
        width: 100%;
    }
    section.precise .open,
    section.precise .fill {
        float: left;
        width: 50%;
    }
    section.precise .open .rating,
    section.precise .fill .rating {
        height: 20px;
        margin: 0 auto;
        position: relative;
        width: 94px;
    }
    section.precise .open .rating .bg,
    section.precise .open .rating .value,
    section.precise .fill .rating .bg,
    section.precise .fill .rating .value {
        height: 20px;
        position: absolute;
        text-align: center;
    }
    section.precise .open .rating .bg:before,
    section.precise .open .rating .value:before,
    section.precise .fill .rating .bg:before,
    section.precise .fill .rating .value:before {
        color: #ccc;
        content: "";
        font-family: FontAwesome;
        font-size: 20px;
    }
    section.precise .open .rating .value,
    section.precise .fill .rating .value {
        overflow: hidden;
        width: 50%;
    }
    section.precise .open .rating .value:before,
    section.precise .fill .rating .value:before {
        color: orange;
        content: "";
    }
    section.precise .fill .rating .bg:before {
        content: "";
    }

    input[type=range] {
        -webkit-appearance: none;
        width: 200px;
        margin: 20px auto;
    }

    input[type=range]:focus {
        outline: none;
    }

    input[type=range]::-webkit-slider-runnable-track {
        width: 100%;
        height: 1px;
        cursor: pointer;
        box-shadow: 0px 0px 0px #000000, 0px 0px 0px #0d0d0d;
        background: #666666;
        border-radius: 0px;
        border: 0px solid #666666;
    }

    input[type=range]::-webkit-slider-thumb {
        box-shadow: 0px 0px 0px #ffffff, 0px 0px 0px #ffffff;
        border: 1px solid #ffffff;
        height: 20px;
        width: 20px;
        border-radius: 10px;
        background: #ffa500;
        cursor: pointer;
        -webkit-appearance: none;
        margin-top: -9.5px;
    }

    input[type=range]:focus::-webkit-slider-runnable-track {
        background: #737373;
    }

    input[type=range]::-moz-range-track {
        width: 100%;
        height: 1px;
        cursor: pointer;
        box-shadow: 0px 0px 0px #000000, 0px 0px 0px #0d0d0d;
        background: #666666;
        border-radius: 0px;
        border: 0px solid #666666;
    }

    input[type=range]::-moz-range-thumb {
        box-shadow: 0px 0px 0px #ffffff, 0px 0px 0px #ffffff;
        border: 1px solid #ffffff;
        height: 20px;
        width: 20px;
        border-radius: 10px;
        background: #ffa500;
        cursor: pointer;
    }

    input[type=range]::-ms-track {
        width: 100%;
        height: 1px;
        cursor: pointer;
        background: transparent;
        border-color: transparent;
        color: transparent;
    }

    input[type=range]::-ms-fill-lower {
        background: #595959;
        border: 0px solid #666666;
        border-radius: 0px;
        box-shadow: 0px 0px 0px #000000, 0px 0px 0px #0d0d0d;
    }

    input[type=range]::-ms-fill-upper {
        background: #666666;
        border: 0px solid #666666;
        border-radius: 0px;
        box-shadow: 0px 0px 0px #000000, 0px 0px 0px #0d0d0d;
    }

    input[type=range]::-ms-thumb {
        box-shadow: 0px 0px 0px #ffffff, 0px 0px 0px #ffffff;
        border: 1px solid #ffffff;
        height: 20px;
        width: 20px;
        border-radius: 10px;
        background: #ffa500;
        cursor: pointer;
        height: 1px;
    }

    input[type=range]:focus::-ms-fill-lower {
        background: #666666;
    }

    input[type=range]:focus::-ms-fill-upper {
        background: #737373;
    }

</style>

<script>

    $(document).ready(function () {
        $('input').rating();
    })

</script>


<link href="dist/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="dist/js/jquery-1.10.2.js"></script>


<div class="container">

    <input type="hidden" class="rating"/>
    <input type="hidden" class="rating" value="2"/>

    <input type="hidden" class="rating" data-filled="glyphicon glyphicon-heart" data-empty="glyphicon glyphicon-heart-empty"/>

</div>

<jsp:include page="template/footer.jsp"/>
