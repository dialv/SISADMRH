var url_modulos = "";
url_modulos = obtener_url(window.location.href);
function obtener_url(url) {
    url_vector = url.split("/");
    proyecto = url_vector["3"];
    return proyecto;

}
jQuery(document).ready(function() {

    jQuery("#captcha").keyup(function() {
        jQuery("#captcha").val(jQuery(this).val().toUpperCase());
    });

    jQuery(".numeros").keypress(function(event) {

        if (event.which) {
            return (event.which > 47 && event.which < 58 || event.which == 8);
        } else if (event.charCode) {
            return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8);
        } else if (window.event.keyCode) {
            return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8);
        }


    });



    jQuery(".alfanumerico").keypress(function(event) {

        if (event.which) {
            if (event.which > 64 && event.which < 91 || event.which == 8 || event.which == 32) {
                return true;
            } else
            if (event.which > 96 && event.which < 123 || event.which == 8 || event.which == 32) {
                return true;
            } else
            if (event.which > 47 && event.which < 58 || event.which == 8 || event.which == 32) {
                return true;
            } else {
                return false;
            }

        }



        if (event.charCode) {
            if (event.charCode > 64 && event.charCode < 91 || event.charCode == 8 || event.charCode == 32) {
                return true;
            } else
            if (event.charCode > 96 && event.charCode < 123 || event.charCode == 8 || event.charCode == 32) {
                return true;
            } else
            if (event.charCode > 47 && event.charCode < 58 || event.charCode == 8 || event.charCode == 32) {
                return true;
            } else {
                return false;
            }
        }
        if (window.event.keyCode) {

            if (window.event.keyCode > 64 && window.event.keyCode < 91 || window.event.keyCode == 8 || window.event.keyCode == 32) {
                return true;
            } else
            if (window.event.keyCode > 96 && window.event.keyCode < 123 || window.event.keyCode == 8 || window.event.keyCode == 32) {
                return true;
            } else
            if (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8 || window.event.keyCode == 32) {
                return true;
            } else {
                return false;
            }





        }


    });




    jQuery(".alfa_mayus").keypress(function(event) {

        if (event.which) {
            if (event.which > 64 && event.which < 91 || event.which == 8 || event.which == 32) {
                return true;
            } else
            if (event.which > 47 && event.which < 58 || event.which == 8 || event.which == 32) {
                return true;
            } else {
                return false;
            }

        }



        if (event.charCode) {
            if (event.charCode > 64 && event.charCode < 91 || event.charCode == 8 || event.charCode == 32) {
                return true;
            } else
            if (event.charCode > 47 && event.charCode < 58 || event.charCode == 8 || event.charCode == 32) {
                return true;
            } else {
                return false;
            }
        }
        if (window.event.keyCode) {

            if (window.event.keyCode > 64 && window.event.keyCode < 91 || window.event.keyCode == 8 || window.event.keyCode == 32) {
                return true;
            } else
            if (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8 || window.event.keyCode == 32) {
                return true;
            } else {
                return false;
            }





        }


    });




    jQuery(".letras").keypress(function(event) {

        if (event.which) {
            if (event.which > 64 && event.which < 91 || event.which == 8 || event.which == 32) {
                return true;
            } else
            if (event.which > 96 && event.which < 123 || event.which == 8 || event.which == 32) {
                return true;
            } else {
                return false;
            }

        }

        if (event.charCode) {
            if (event.charCode > 64 && event.charCode < 91 || event.charCode == 8 || event.charCode == 32) {
                return true;
            } else
            if (event.charCode > 96 && event.charCode < 123 || event.charCode == 8 || event.charCode == 32) {
                return true;
            } else {
                return false;
            }
        }
        if (window.event.keyCode) {

            if (window.event.keyCode > 64 && window.event.keyCode < 91 || window.event.keyCode == 8 || window.event.keyCode == 32) {
                return true;
            } else
            if (window.event.keyCode > 96 && window.event.keyCode < 123 || window.event.keyCode == 8 || window.event.keyCode == 32) {
                return true;
            } else {
                return false;
            }
        }


    });


    jQuery('.fecha_ocho').mask('00/00/00');
     jQuery('.fecha_datetime').mask('00/00/0000 00:00:00');
    jQuery('.num_nit').mask('0000-000000-000-0');
    jQuery('.num_telefono').mask('0000-0000');
    jQuery('.num_dui').mask('00000000-0');
    jQuery('.num_decimal2').mask('000.00');
    jQuery('.num_decimal3').mask('0000000.00', {reverse: true});
    jQuery('.fecha_dies').mask('00/00/0000');

});

jQuery(function() {
    jQuery("#iconalert").dialog({
        autoOpen: false,
        show: {
            effect: "clip",
            duration: 500
        },
        hide: {
            effect: "blind",
            duration: 600
        },
        buttons: {
            "Cerrar": function() {
                jQuery(this).dialog("close");
            }
        }
    });

    jQuery("div.alerticons").click(function() {
        jQuery("#iconalert").dialog("open");
            setTimeout(function() {
        jQuery("#dialog").dialog("close");
    }, 5000);
    });
});


	