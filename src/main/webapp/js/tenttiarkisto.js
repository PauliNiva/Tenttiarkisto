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

// lomakevalidaatio
$(document).ready(function() {
    $('#lomakeform').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            kurssi: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Course name is required and cannot be empty'
                    }
                }
            },
            tyyppi: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Exam type is required and cannot be empty'
                    }
                }
            },
            kieli: {
                message: 'The language is not valid',
                validators: {
                    notEmpty: {
                        message: 'Language is required and cannot be empty'
                    }
                }
            },
            pvm: {
                validators: {
                    notEmpty: {
                        message: 'The date of the exam is required'
                    },
                    date: {
                        format: 'dd.mm.yy',
                        message: 'The date of the exam is not valid'
                    }
                }
            }
        }
    });
});
