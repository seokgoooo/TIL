$(function () {
    ///////////////////////////////////////////
    $('.top_banner i').on('click', function () {
        $('.top_banner').slideUp();
    })

    $('.main_slider').on('init reInit afterChange', function () {
        let current = $('.slick-current');
        current.addClass('on').siblings().removeClass('on');
    })

    $('.main_slider').slick({
        arrows: false,
        autoplay: true,
        autoplaySpeed: 3000,
        dots: true,
        pauseOnHover: false,
        pauseOnFocus: false,
    })

    $('.movie01 .dec i:nth-of-type(1)').on('click', function () {
        $('.movie01 video').trigger('play');
    })

    $('.movie01 .dec i:nth-of-type(2)').on('click', function () {
        $('.movie01 video').trigger('pause');
    })

    $('.player').YTPlayer({
        videoURL: 'https://youtu.be/z9Ug-3qhrwY',
        containment: '.movie02',
        autoPlay: true,
        mute: true,
        startAt: 0,
        opacity: 1,
        showControls: false,
    })

    $('.movie02 i:nth-of-type(1)').on('click', function () {
        $('#bgndVideo').YTPPlay();
    })

    $('.movie02 i:nth-of-type(2)').on('click', function () {
        $('#bgndVideo').YTPPause();
    })

    $('.product_slider').slick({
        arrows: false,
        autoplay: true,
        autoplaySpeed: 1000,
        dots: true,
        slidesToShow: 5,
        centerMode: true,
    })

    $('.product .s_left').on('click', function () {
        $('.product_slider').slick('slickPrev');
    })

    $('.product .s_right').on('click', function () {
        $('.product_slider').slick('slickNext');
    })

    $('.tab_menu>li').on('click', function () {
        var idx = $(this).index();
        $(this).addClass('on').siblings().removeClass('on');
        $('.tab_content>li').addClass('on').siblings().removeClass('on');
    })

    $('.footer #link').on('change', function () {
        var lik = $(this).val();
        if (lik) window.open(lik);
    })
    ///////////////////////////////////////////
})