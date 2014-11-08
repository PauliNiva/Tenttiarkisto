$('a').click(function(){
    $('html, body').animate({
        scrollTop: $( $.attr(this, 'href') ).offset().top
    }, 500);
    return false;
});

$(function() {
               $("#datepicker").datepicker({ dateFormat: "dd.mm.yy" }).val();
});
