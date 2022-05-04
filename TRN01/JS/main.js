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

    $('.mopen').on('click', function () {
        $('.gnb').toggleClass('on')
    })
})