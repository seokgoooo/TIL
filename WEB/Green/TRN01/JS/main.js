// document.querySelector('.header').style.display = 'none';
// $('.header').hide().show();
// 같은 말이다

$(function () {
    $('.main_slider').slick({
        arrows: false,
        autoplay: true,
        autoplaySpeed: 1000,
        vertical: true,
        dots: true,
    })

    $('.icon').click(function () {
        $('.gnb').toggleClass('on');
        $('.icon').toggleClass('on');
        $('.icon01').toggleClass('on');
    })

    $('.icon01').click(function () {
        $('.gnb').toggleClass('on');
        $('.icon').toggleClass('on');
        $('.icon01').toggleClass('on');
    })
});

