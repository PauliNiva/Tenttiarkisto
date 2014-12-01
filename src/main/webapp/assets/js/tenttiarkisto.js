// haitari
$('.collapse').collapse();

// lomakkeen kurssihaku
$(document).ready(function() { $("#kurssihaku").select2({minimumInputLength: 2, placeholder: "Valitse kurssi"}); });

// animaatio ylhäältä lomakkeelle
$('.lisaauusi').click(function(){
    $('html, body').animate({
        scrollTop: $( $.attr(this, 'href') ).offset().top
    }, 500);
    return false;
});

// haku
$("#haku").on("keyup change", function() {
   var hakusana = this.value.toLowerCase();
   $("div.panel-heading").each(function() {
        var kurssinnimi = $(this).find('.kurssilinkki').text().toLowerCase();
        if (kurssinnimi.indexOf(hakusana) < 0) {
            $(this).hide();
        } else {
            $(this).show();
        }
   });
});

// datepicker
$(function() {
    $("#datepicker").datepicker({ dateFormat: "dd.mm.yy" }).val();
});

$('#lomakeform').parsley(options);
