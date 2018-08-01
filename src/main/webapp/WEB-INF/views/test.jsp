<head>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"/>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>

</head>

<body>


<style>


    .title {

        margin-right: 20rem;
    }

    .embed-responsive {

        margin-left: 1.3rem;
    }

    .img {

        margin-left: 1.3rem;
    }

    .info {

        margin-left: 1.3rem;
    }

    .card {

        width: 20rem;
        height: 20rem;
    }

    div.scrollup {
        position: fixed; /* фиксированная позиция */
        color: #fff; /* цвет текста */
        background-color: #286090; /* цвет заднего фона */
        right: 20px; /* расстояние от правого края */
        bottom: 0px; /* расстояние от нижнего края */
        padding: 4px 10px; /* отступы до содержимого блока */
        font-size: 20px; /* размер шрифта (иконки) */
        border-top-left-radius: 4px; /* скругление верхнего левого угла */
        border-top-right-radius: 4px; /* скругление верхнего правого угла */
        cursor: pointer; /* форма курсора */
        display: none; /* не отображать элемент */
        text-align: center; /*выравнивание содержимого элемента по центру */
    }

    div.scrollup:hover {
        background-color: #000; /* цвет заднего фона при наведении */
    }


</style>


<script>
    $(function () {
        // при нажатии на кнопку scrollup
        $('.scrollup').click(function () {
            // переместиться в верхнюю часть страницы
            $("html, body").animate({
                scrollTop: 0
            }, 1000);
        })
    })

    // при прокрутке окна (window)
    $(window).scroll(function () {
        // если пользователь прокрутил страницу более чем на 200px
        if ($(this).scrollTop() > 200) {
            // то сделать кнопку scrollup видимой
            $('.scrollup').fadeIn();
        }
        // иначе скрыть кнопку scrollup
        else {
            $('.scrollup').fadeOut();
        }
    });

</script>

<div class="container">

    <div class="row">
        <%--empty--%>
        <div class="col-md">


        </div>


        <div class="col-md-10">
            <br/>
            <hr/>
            <div class="row">

                <div class="col-md">
                    <img class="img" src="https://icobench.com/images/icos/icons/phoneum.jpg"
                         alt="https://icobench.com/images/icos/icons/phoneum.jpg"/>
                </div>
                <div class="col-md-10">

                    <h5 class="title">ICON (blockchain)</h5>
                    <p class="text">
                        Viberate is a crowdsourced live music ecosystem and a blockchain-br\nAccepted
                        currencies\r\nETH\r\n\r\n\r\nMinimum goal\</p>
                </div>
                <br/>

            </div>
            <br/>
            <hr/>
            <div class="row">

                <div class="col-md-7">

                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0"
                                allowfullscreen></iframe>
                    </div>

                </div>

                <div class="col-md">

                    <div class="card border-white text-center" style="width: 18rem;">

                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <h6>Toke sales : Ended</h6>
                                <h6>Toke start sale : Ended</h6>
                                <h6>Toke end sale : Ended</h6>
                                <h6>Raised : Ended</h6>

                            </li>

                            <li class="list-group-item">
                                <button type="button" class="btn btn-secondary btn-sm">Web site</button>
                            </li>
                            <li class="list-group-item">
                                <button type="button" class="btn btn-secondary btn-sm">White list</button>
                            </li>
                            <li class="list-group-item  ">

                                <i class="fab fa-bitcoin fa-lg fa-spin"></i>
                                <i class="fab fa-twitter fa-lg"></i>
                                <i class="fab fa-github fa-lg"></i>
                                <i class="fab fa-reddit fa-lg"></i>
                                <i class="fab fa-medium fa-lg"></i>
                                <i class="fab fa-bitcoin fa-lg"></i>

                            </li>

                        </ul>
                    </div>

                </div>

            </div>

            <hr/>

            <ul class="nav nav-pills justify-content-center mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab"
                       aria-controls="pills-home" aria-selected="true">Finance</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab"
                       aria-controls="pills-profile" aria-selected="false">Teams</a>
                </li>
            </ul>

            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="row">

                        <div class="col info">
                            <p class="font-weight-bold">token : VIB </p>
                            <p class="font-weight-bold">price : 1$</p>
                            <p class="font-weight-bold">tokens: 12000000</p>
                            <p class="font-weight-bold">hard cap : $12 500 000</p>
                            <p class="font-weight-bold">soft cap : $1 000 000</p>
                            <p class="font-weight-bold">raised: $ 12 000 000</p>

                        </div>

                        <div class="col info">

                            <p class="font-weight-bold">platform: Etherium</p>
                            <p class="font-weight-bold">accepting: ETH</p>
                            <p class="font-weight-bold">Bold text.</p>
                            <p class="font-weight-bold">Bold text.</p>
                            <p class="font-weight-bold">Bold text.</p>
                            <p class="font-weight-bold">Bold text.</p>
                        </div>
                    </div>


                </div>
                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                    <ul class="list-group list-group-flush">
                        <p class="font-weight-bold">Bold text.</p>
                        <p class="font-weight-bold">Bold text.</p>
                        <p class="font-weight-bold">Bold text.</p>
                        <p class="font-weight-bold">Bold text.</p>
                        <p class="font-weight-bold">Bold text.</p>
                        <p class="font-weight-bold">Bold text.</p>
                    </ul>
                </div>
            </div>

            <br/>
            <br/>
            <br/>

            <hr/>

        </div>

        <%--empty--%>
        <div class="col-md">



        </div>

    </div>

</div>

</body>

