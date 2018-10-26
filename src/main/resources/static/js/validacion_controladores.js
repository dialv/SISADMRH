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

    function datepicked() {
        var fromDate = jQuery('#desde').datepicker('getDate');
        var toDate = jQuery('#hasta').datepicker('getDate');
        if (fromDate && toDate) {
            var difference_msec = toDate.getTime() - fromDate.getTime();
            var difference_days = difference_msec / 86400000;
            jQuery("#nights").val(Math.ceil(difference_days));
        }
    }
    jQuery('#desde').datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onSelect: function(dateSt) {
            var d1 = jQuery(this).datepicker("getDate");
            d1.setDate(d1.getDate() + 0); // change to + 1 if necessary
            var d2 = jQuery(this).datepicker("getDate");
            d2.setDate(d2.getDate() + 700); // change to + 29 if necessary
//            d2.setDate(d2.getDate() + 31); // change to + 29 if necessary
            jQuery("#hasta2").datepicker("setDate", null);
            jQuery("#hasta2").datepicker("option", "minDate", d1);
            jQuery("#hasta2").datepicker("option", "maxDate", d2);
            datepicked();
            jQuery('#desde2').focus();
        }
    });

    jQuery('#desde').click(function() {
        jQuery('#desde').datepicker("show");
    });

    jQuery('#hasta').datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onSelect: function(dateStr) {
            datepicked();
            jQuery('#hasta2').focus();
        }
    });

    jQuery('#desde3').datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S']

    });

    function datepicked2() {
        var fromDate = jQuery('#desde2').datepicker('getDate');
        var toDate = jQuery('#hasta2').datepicker('getDate');
        if (fromDate && toDate) {
            var difference_msec = toDate.getTime() - fromDate.getTime();
            var difference_days = difference_msec / 86400000;
            jQuery("#nights").val(Math.ceil(difference_days));
        }
    }


    jQuery('#desde2').datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onSelect: function(dateStr) {
            var d1 = jQuery(this).datepicker("getDate");
            d1.setDate(d1.getDate() + 0); // change to + 1 if necessary
            var d2 = jQuery(this).datepicker("getDate");
//            d2.setDate(d2.getDate() + 700); // change to + 29 if necessary
            d2.setDate(d2.getDate() + 31); // change to + 29 if necessary
            jQuery("#hasta2").datepicker("setDate", null);
            jQuery("#hasta2").datepicker("option", "minDate", d1);
            jQuery("#hasta2").datepicker("option", "maxDate", d2);
            datepicked2();
            jQuery("#desde2").focus();
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

    jQuery('#desde2').click(function() {
        jQuery('#desde2').datepicker("show");
    });

    jQuery('#hasta2').click(function() {
        jQuery('#hasta2').datepicker("show");
    });

    jQuery('#hasta2').datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onSelect: function(dateStr) {
            datepicked2();
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

    jQuery('#desde5').datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S']

    });

    jQuery('#desde5').click(function() {
        jQuery('#desde5').datepicker("show");
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
    jQuery('.num_decimal').mask('00.00');
//    jQuery('.moneda').mask('000000000000.00', {reverse: true});    

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
            jQuery("#iconalert").dialog("close");
        }, 5000);
    });
    NumTelefono();
    FechaOcho();
    NumDUI();
    Fechaformat();
    NumISSS();
    NumNUP();
    NumCuenta();
    NumNIT();
    Configfechas();
    DateRestrictBeforeYears();
    DateSimples();
    DateShowMonthYears();
    DateRanges();
    DesdeBefores();
    numerodecimal();
    onlyletters();
    fechaDiez();
    fechaSeis();
    fechaCinco();
    numberSerieEstravio();
    onlynumber();
    DateRestrictActuals();
    DateRestrictBeforeYearsD();
    DateRestrictBeforeYearsH();
    DateRestrictBeforeYearsZ();
    DatedesdeHoyRange();
    DatePeriodos();
    DatePeriodosH();
    InitRecalcReglas();
    //InitenvioRentaCasilla();
    InitDecimalMoneda();
    InitFormatporcent();
    separadorMiles();
    DecimalMonedas();
    formatdecimalNegativos();
    DateRangesCrit();
    formatporcents();
    numerodecimal();
    DateTodayBefores();
    DatePeriodosYear();
    DateSimpleAnts();
    DateRestrictActualsAnt();
    Spinners();
    DateSimples2();
    //reloadMethod();
    DatedesdeHoyOnes();
    deshabilitarIpt();
    DesdeBefores2();

});


function deshabilitarIpt() {
    jQuery(".deshabilitado").focus(function() {
        jQuery(this).blur();
    })
}
var Configfechas = function() {
    fechaCinco();
    fechaDiez();
    DateSimples();
    DatePeriodos();
    onlynumber();
};
var NumNIT = function() {
    jQuery('.num_nit').each(function() {
        NumNITs(this);
    });
};
var NumNITs = function(num_nit) {
    jQuery(num_nit).mask('0000-000000-000-0');
};
var NumDUI = function() {
    jQuery('.num_dui').each(function() {
        jQuery(this).mask('00000000-0');
    });
};
var NumISSS = function() {
    jQuery('.num_isss').each(function() {
        jQuery(this).mask('000000000');
    });
};
var Fechaformat = function() {
    jQuery('.fecha_format').each(function() {
        jQuery(this).mask('00/00/0000');
    });
};
var NumCuenta = function() {
    jQuery('.num_cuenta').each(function() {
        jQuery(this).mask('00000000000000000');
    });
};
var NumNUP = function() {
    jQuery('.num_nup').each(function() {
        jQuery(this).mask('000000000000');
    });
};
var FechaOcho = function() {
    jQuery('.fecha_ocho').each(function() {
        jQuery(this).mask('00/00/00');
    });
};
var NumTelefono = function() {
    jQuery('.num_telefono').each(function() {
        jQuery(this).mask('0000-0000');
    });
};
var Spinners = function() {
    jQuery(".Spinner").each(function() {
        Spinner(this);
    });
};
var Spinner = function(Obj) {
    jQuery(Obj).spinner({
        min: 0,
        max: 32
    });
};
function doValidarHora(pDato) {
    var dato = pDato.value;
    var hora = dato.substring(0, 2);
    var min = dato.substring(3, 5);
    if (eval(hora) < 0 || eval(hora) > 23 || eval(min) < 0 || eval(min) > 59) {
        alert('hora invalida');
        document.forms['dvresolucionivaform'].horaEmision.value = '';
    }
}
function horaMask(inputField) {
    var separator = ':';
    var horaPattern = new Array(2, 2);
    mask(inputField, separator, horaPattern, true);
}
function mask(inputField, separator, pattern, nums) {
    if (inputField.valant !== inputField.value) {
        val = inputField.value;
        largo = val.length;
        val = val.split(separator);
        val2 = '';
        for (r = 0; r < val.length; r++) {
            val2 += val[r];
        }
        if (nums) {
            for (z = 0; z < val2.length; z++) {
                if (isNaN(val2.charAt(z))) {
                    letra = new RegExp(val2.charAt(z), "g");
                    val2 = val2.replace(letra, "");
                }
            }
        }
        val = '';
        val3 = new Array();
        for (s = 0; s < pattern.length; s++) {
            val3[s] = val2.substring(0, pattern[s]);
            val2 = val2.substr(pattern[s]);
        }
        for (q = 0; q < val3.length; q++) {
            if (q === 0) {
                val = val3[q];
            }
            else {
                if (val3[q] !== "") {
                    val += separator + val3[q];
                }
            }
        }
        inputField.value = val;
        inputField.valant = val;
    }

}


var espere = function(element) {
    if (!isUndefinedOrNull(element) && !isUndefinedOrNull(jQuery(element).position())) {
        var width = 350;
        var height = 60;
        var offset = 30; // 22
        var outset = 6; // 22
        var vH = jQuery(element).height();
        if (vH == "0") {
            vH = "150"
        }
        var message = 'Espere por favor, actualizando...';
        var top = vH / 2 - height / 2;

        var left = jQuery(element).width() / 2 - width / 2;
        var divname = jQuery(element).attr('id');
        var divname = isUndefinedOrNull(divname) ? 'waitDiv' : divname + 'waitDiv';
        var newDiv = '<div id="' + divname + '" class="ui-overlay ui-corner-all"  style="opacity:0.85;background:#f0f0f0;margin-top: ' + jQuery(element).css('marginTop') + '; width:48px;height:48px;margin-left:' + jQuery(element).css('marginLeft') + '; margin-right:' + jQuery(element).css('marginRight') + '; margin-bottom:' + jQuery(element).css('marginBottom') + '; width: ' + jQuery(element).width() + 'px; height: ' + vH + 'px; position: absolute; left: ' + jQuery(element).position().left + 'px; top: ' + jQuery(element).position().top + 'px;">'
                + '<div class="ui-widget-overlay ui-corner-all"></div>'
                + '<div class="ui-widget-shadow ui-corner-all" style="position: absolute; width: ' + (width + outset) + 'px; height: ' + (height + outset) + 'px; left: ' + left + 'px; top: ' + top + 'px;"></div>'
                + '<div class="ui-widget ui-widget-content ui-corner-all" style="vertical-align:middle; position: absolute; width: ' + (width - offset) + 'px; height: ' + (height - offset) + 'px; left: ' + (left + offset / 5) + 'px; top: ' + (top + offset / 5) + 'px; padding: 10px;"><div class="w100" style="text-align:center"><img  style="border-radius:50px; paddin:0 0; margin: 0 0;" id="loadingIcon" src="/' + url_modulos + '/images/img_plantilla/loading.gif" title="' + message + '" /></div><div style="text-align:center" class="waitmessagetext">' + message + '</div></div></div>';
        jQuery(element).append(newDiv);

    }
};

var DateRestrictBeforeYears = function() {
    jQuery(".DateYearTwo").each(function() {
        DateRestrictBeforeYear(this);
//        BtnDateRestrictBeforeYear(this);
        afterShowCalendarTwo();
    });
};
var DateRestrictBeforeYear = function(Datapicker) {

    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: "-1m",
        minDate: '-25m',
        showButtonPanel: true,
        closeText: "Aceptar",
//        closeText: "Agregar",
        onSelect: function() {
            restrictAct(this);
        },
        onClose: function() {
            var iMonth = jQuery("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var iYear = jQuery("#ui-datepicker-div .ui-datepicker-year :selected").val();
            jQuery(this).datepicker('setDate', new Date(iYear, iMonth, 1));
            jQuery("#msgPeriodo").remove();
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

};
var DatePeriodos = function() {
    jQuery(".DatePeriodo").each(function() {
        DatePeriodo(this);
        afterShowCalendarTwo();
    });
};
var DatePeriodo = function(Datapicker) {
    var date = new Date();
    var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();

    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: new Date(y - 1, 11),
        minDate: new Date(2001, 0),
        yearRange: "c-14:c+10",
        showButtonPanel: true,
        closeText: "Aceptar",
        onClose: function() {
            var iMonth = jQuery("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var iYear = jQuery("#ui-datepicker-div .ui-datepicker-year :selected").val();
            jQuery(this).datepicker('setDate', new Date(iYear, iMonth, 1));
            restrictAct3(iMonth, iYear);
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

};



function restrictAct3(month, year) {
    jQuery(".DatePeriodoH").datepicker("option", "minDate", new Date(year, month));
    jQuery(".DatePeriodoH").datepicker("option", "maxDate", new Date(year, 11));
}
;
var DatePeriodosH = function() {
    jQuery(".DatePeriodoH").each(function() {
        DatePeriodoH(this);
        afterShowCalendarTwo();
    });
};
var DateTodayBefores = function() {
    jQuery(".DateTodayBefore").each(function() {
        DateTodayBefore(this);
        BtnDateTodayBefore(this);
    });
};
var BtnDateTodayBefore = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var DatePeriodoH = function(Datapicker) {
    var date = new Date();
    var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();

    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: new Date(y - 1, 11),
        minDate: new Date(2001, 0),
        yearRange: "c-14:c+10",
        showButtonPanel: true,
        closeText: "Aceptar",
        onClose: function() {
            var iMonth = jQuery("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var iYear = jQuery("#ui-datepicker-div .ui-datepicker-year :selected").val();
            jQuery(this).datepicker('setDate', new Date(iYear, iMonth, 1));
            jQuery(".DatePeriodoYear").datepicker('setDate', new Date(iYear, 0, 1));
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

};
var DateTodayBefore = function(Datapicker) {
    var date = new Date();
    var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        showOn: "button",
        dateFormat: 'dd/mm/yyyy',
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: "today"
    });

};
var afterShowCalendarTwo = function() {
    jQuery("#ui-datepicker-div").addClass("myclassdoesntgo");
};
var BtnDateRestrictBeforeYear = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var DateShowMonthYears = function() {
    jQuery(".DateMonthYears").each(function() {
        DateShowMonthYear(this);
        BtnShowMonthYear(this);
    });
};
var BtnShowMonthYear = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var DateSimples = function() {
    jQuery(".Datesimple").each(function() {
        DateSimple(this);
        BtnDate(this);
    });
};
var DateSimples2 = function() {
    jQuery(".Datesimple2").each(function() {
        DateSimple2(this);
        BtnDate(this);
    });
};
var DateSimpleAnts = function() {
    jQuery(".DatesimpleAnt").each(function() {
        DateSimpleAnt(this);
        BtnDateAnt(this);
    });
};
var BtnDateAnt = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var BtnDate = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var DateShowMonthYear = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        changeMonth: true,
        changeYear: true,
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DateSimple = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DateSimple2 = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: '0',
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DateSimpleAnt = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: '0',
        changeMonth: true,
        changeYear: true,
        onSelect: function() {
            restrictActAnt(this);
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DateDiez = function() {
    jQuery(".Datediez").each(function() {
        DateTen(this);
        BtnDateTen(this);
    });
};
var BtnDateTen = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var DateTen = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yyyy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};

var DesdeBefores = function() {
    jQuery(".DesdeBefore").each(function() {
        DesdeBefore(this);
        BtnDesdeBefore(this);
    });
};
var DesdeBefores2 = function() {
    jQuery(".DesdeBefore2").each(function() {
        DesdeBefore2(this);
        BtnDesdeBefore(this);
    });
};
var BtnDesdeBefore = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var DateRanges = function() {
    jQuery(".Datedesde").each(function() {
        Datedesde(this);
        BtnDateDesde(this);
    });
};
var DateRangesCrit = function() {
    jQuery(".DatedesdeCrit").each(function() {
        DatedesdeCrit(this);
        BtnDateDesde(this);
    });
};
var BtnDateDesde = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
function restrictAct(date) {
    var d1 = jQuery(date).datepicker("getDate");
    d1.setDate(d1.getDate() + 1);
    jQuery(".Datehasta").datepicker("setDate", null);
    jQuery(".Datehasta").datepicker("option", "minDate", d1);
}
var DesdeBefore = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        minDate: "today",
        changeMonth: true,
        changeYear: true,
        onSelect: function() {
            restrictAct(this);
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DesdeBefore2 = function(Datapicker) {
    var date = new Date();
    var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
    var dia = (d < 10) ? "0" + d : d;
    var mes = ((m + 1) < 10) ? "0" + (m + 1) : (m + 1);
    var title = "Solamente se permite seleccionar Fechas a partir del " + dia + "/" + mes + "/" + y + " hasta " + dia + "/" + mes + "/" + (y + 1);
    jQuery(Datapicker).attr("title", title);
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        minDate: "today",
        maxDate: new Date(y + 1, m, d),
        changeMonth: true,
        changeYear: true,
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

};
function restrictAct(date) {
    var d1 = jQuery(date).datepicker("getDate");
    d1.setDate(d1.getDate() + 1);
    jQuery(".Datehasta").datepicker("setDate", null);
    jQuery(".Datehasta").datepicker("option", "minDate", d1);
}
function restrictActAnt(date) {
    var d1 = jQuery(date).datepicker("getDate");
    d1.setDate(d1.getDate() + 1);
    jQuery(".DatehastaAnt").datepicker("setDate", null);
    jQuery(".DatehastaAnt").datepicker("option", "minDate", d1);
}
function restrictAct4(date) {
    var d1 = jQuery(date).datepicker("getDate");
    d1.setDate(d1.getDate());
    jQuery(".Datehasta").datepicker("setDate", null);
    jQuery(".Datehasta").datepicker("option", "minDate", d1);
}
var Datedesde = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onSelect: function() {
            restrictAct(this);
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DatedesdeCrit = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onSelect: function() {
            restrictAct4(this);
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DateRestrictActuals = function() {
    jQuery(".Datehasta").each(function() {
        Datehasta(this);
        BtnDatehasta(this);
    });
};
var BtnDatehasta = function(Datapicker) {
    jQuery(Datapicker).click(function() {
        jQuery(Datapicker).datepicker("show");
    });
};
var Datehasta = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DateRestrictActualsAnt = function() {
    jQuery(".DatehastaAnt").each(function() {
        DatehastaAnt(this);
        BtnDatehasta(this);
    });
};
var DatehastaAnt = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: 0,
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
function restrictAct2(month, year) {
    var d = new Date();
    var m = d.getMonth();
    var y = d.getFullYear();
    month++;
    var diff;
    if (y == year) {
        diff = m - month + 1;
    } else if ((y - year) == 1) {
        diff = m + (12 - month) + 1;
    } else if ((y - year) == 2) {
        diff = m + 12 + (12 - month) + 1;
    }
    jQuery(".DateYearTwoH").datepicker("option", "minDate", "-" + diff + "m");
}
;
var DateRestrictBeforeYearD = function(Datapicker) {

    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: "-1m",
        minDate: '-25m',
        showButtonPanel: true,
        closeText: "Aceptar",
//        onSelect: function() {
//            alert("Here!");
//            restrictAct2(this);
//        },
        onClose: function() {
            var iMonth = jQuery("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var iYear = jQuery("#ui-datepicker-div .ui-datepicker-year :selected").val();
            jQuery(this).datepicker('setDate', new Date(iYear, iMonth, 1));
            restrictAct2(iMonth, iYear);
            if (jQuery("#msgPeriodo").length)
                jQuery("#msgPeriodo").remove();
            if (jQuery("#msgPeriodoD").length)
                jQuery("#msgPeriodoD").remove();
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

};
var DateRestrictBeforeYearH = function(Datapicker) {

    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: "-1m",
        minDate: '-25m',
        closeText: "Aceptar",
        showButtonPanel: true,
        onClose: function() {
            var iMonth = jQuery("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var iYear = jQuery("#ui-datepicker-div .ui-datepicker-year :selected").val();
            jQuery(this).datepicker('setDate', new Date(iYear, iMonth, 1));
            if (jQuery("#msgPeriodoH").length)
                jQuery("#msgPeriodoH").remove();
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

};

var DateRestrictBeforeYearZ = function(Datapicker) {

    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: "0m",
        minDate: '-25m',
        closeText: "Aceptar",
        showButtonPanel: true,
        onClose: function() {
            var iMonth = jQuery("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var iYear = jQuery("#ui-datepicker-div .ui-datepicker-year :selected").val();
            jQuery(this).datepicker('setDate', new Date(iYear, iMonth, 1));
            if (jQuery("#msgPeriodoZ").length)
                jQuery("#msgPeriodoZ").remove();
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });

};

var DateRestrictBeforeYearsD = function() {
    jQuery(".DateYearTwoD").each(function() {
        DateRestrictBeforeYearD(this);
//        BtnDateRestrictBeforeYear(this);
        afterShowCalendarTwo();
    });
};
var DateRestrictBeforeYearsZ = function() {
    jQuery(".DateYearTree").each(function() {
        DateRestrictBeforeYearZ(this);
//        BtnDateRestrictBeforeYear(this);
        afterShowCalendarTwo();
    });
};
var DateRestrictBeforeYearsH = function() {
    jQuery(".DateYearTwoH").each(function() {
        DateRestrictBeforeYearH(this);
//        BtnDateRestrictBeforeYear(this);
        afterShowCalendarTwo();
    });
};
var DatedesdeHoyRange = function() {
    jQuery(".DatedesdeHoy").each(function() {
        DatedesdeHoy(this);
        BtnDateDesde(this);
    });
};
var DatedesdeHoy = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        minDate: '0',
        onSelect: function() {
            restrictAct(this);
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DatedesdeHoyOnes = function() {
    jQuery(".DatedesdeHoyOne").each(function() {
        DatedesdeHoyOne(this);
        BtnDateDesde(this);
        jQuery(this).attr("readonly", true);
    });
};
var DatedesdeHoyOne = function(Datapicker) {
    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        minDate: '0',
        maxDate: '12m',
        onSelect: function() {
            restrictAct(this);
        },
        onClose: function() {
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
var DateRestrictBeforeYearsDH = function() {
    DateRestrictBeforeYearsD();
    DateRestrictBeforeYearsH();
    validarPeriodoH();
    validarPeriodo();
    jQuery('.fecha_seis').mask('00/0000');
};
var numberSerieEstravio = function() {
    jQuery(".nSerieExtravio").each(function() {
        nSerieExtravio(this);
    });
};
// Focus Metodo
var DecimalMonedas = function() {
    jQuery(".DecimalMoneda").each(function() {
        DecimalMoneda(this);
        FocusDecimalMoneda(this);
    });

};
var numerodecimal = function() {
    jQuery(".numero_decimal").each(function() {
        formatdecimal(this);
    });
};
var formatdecimalNegativos = function() {
    jQuery(".numeroDecimalNega").each(function() {
        formatdecimalNegativo(this);
        FocusformatdecimalNegativo(this);
    });
};
// Focus Metodo
var formatporcents = function() {
    jQuery(".numeroPorcentaje").each(function() {
        formatporcent(this);
        FocusFormatporcent(this);
    });
};
var fechaSeis = function() {
    jQuery('.fecha_seis').each(function() {
        formatFechaSeis(this);
    });
};
var formatFechaSeis = function(objFechaSeis) {
    jQuery(objFechaSeis).mask('00/0000');
};
var fechaCinco = function() {
    jQuery('.fecha_cinco').each(function() {
        formatFechaCinco(this);
    });
};
var formatFechaCinco = function(objFechaCinco) {
    jQuery(objFechaCinco).mask('00/00');
};
var fechaDiez = function() {
    jQuery('.fecha_dies').each(function() {
        formatFechaDiez(this);
    });
};
var formatFechaDiez = function(objFechaDiez) {
    jQuery(objFechaDiez).mask('00/00/0000');
};
var onlyletters = function() {
    jQuery(".letras").each(function() {
        formatletters(this);
    });
};
var onlynumber = function() {
    jQuery(".numeros").not(".user_box .numeros").each(function() {
        formatnumber(this);
        Focusformatnumber(this);
    });
};
var formatletters = function(objletter) {
    jQuery(objletter).keypress(function(event) {
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
};
var formatdecimal = function(objdecimal) {
    jQuery(objdecimal).keypress(function(event) {
        var decim = "";
        var dec = "";
        var deci = "";
        var datosdeci = "";
        var codigo = getKeyCodes(event);
        if (codigo === 37 || codigo === 39) {
            return true;
        }
        if (codigo === 45 && objdecimal.selectionStart === 0) {
            return true;
        } else
        if ((jQuery(objdecimal).val().indexOf(".") > -1) || (jQuery(objdecimal).val() == "")) {
            if (codigo > 96 && codigo < 123) {
                return (codigo == 8);
            } else {
                deci = jQuery(objdecimal).val().split(".");
                dec = deci[1];
                if (isUndefinedOrNull(dec)) {
                    return (codigo > 47 && codigo < 58 || codigo === 8);
                } else {
                    decim = dec.toString().length;
                    datosdeci = jQuery(objdecimal).data("ndecimal");
                    if (!isUndefinedOrNull(datosdeci)) {
                        if (decim < datosdeci) {
                            return (codigo > 47 && codigo < 58 || codigo == 8);
                        } else {
                            return (codigo === 8);
                        }
                    } else {
                        return (codigo > 47 && codigo < 58 || codigo == 8);
                    }
                }
            }
        } else {
            return (codigo > 47 && codigo < 58 || codigo == 8 || codigo == 46);
        }

    });
    jQuery(objdecimal).on("paste", function() {
        var e = this;
        datosdeci = jQuery(objdecimal).data("ndecimal");
        setTimeout(function() {
            monto = e.value;
            if (isNaN(monto)) {
                e.value = "";
            } else {
//            var x = "", a = "", b = "";
                x = monto.split(".");
                if (x.length == 2) {
                    e.value = x[0] + "." + x[1].substring(0, 2);
                }
//            a = x[0];
//            b = x.length > 1 ? '.' + x[1] : '';
//            var rgx = /(\d+)(\d{3})/;
//            while (rgx.test(a)) {
//                a = a.replace(rgx, '$1' + ',' + '$2');
//            }
//                        e.value=a+b;
            }

        }, 200);
    });
};
var FocusformatdecimalNegativo = function(objdecimal) {
    var simbolo = "";
    jQuery(objdecimal).focusout(function() {
        if (jQuery.trim(jQuery(this).val()) === "") {
            jQuery(this).val("0");
        }
        ReglasJson(objdecimal);
    });
    jQuery(objdecimal).focusin(function() {
        var pausa = 0;
        simbolo = jQuery(this).val();
        var cont = "";
        for (var i = 0; i < simbolo.length; i++) {

            if (simbolo[i] === ")" || simbolo[i] === "(") {
                cont += "";
                pausa = 1;
            } else {
                cont += simbolo[i];
            }
        }
        jQuery(this).val("");
        if (pausa === 0) {
            if (parseFloat(cont) === 0) {
                jQuery(this).val("");
            } else {
                jQuery(this).val(cont);
            }
        } else {
            jQuery(this).val("-" + cont);
        }
    });

};
var formatdecimalNegativo = function(objdecimal) {

    var nDecimales = "";
    var flagPunto = "";
    var ret = "";
    var keynum = "";
    nDecimales = jQuery(objdecimal).data("ndecimalneg");
    jQuery(objdecimal).keypress(function(event) {
        var Code = getKeyCodes(event);
        var regreso = "";
        keynum = getKeyCodes(event);
        if (Code === 39 || Code === 37) {
            return true;
        }
        flagPunto = jQuery(this).val().split(".");
        if (Code === 45 && objdecimal.selectionStart === 0) {
            if (jQuery(this).val().indexOf("-") > -1) {
                regreso = (Code > 47 && Code < 58 || Code === 8 || Code === 9);
                return  (Code > 47 && Code < 58 || Code === 8 || Code === 9);
            } else {
                regreso = (Code > 47 && Code < 58 || Code === 8 || Code === 9 || Code === 45);
                return  (Code > 47 && Code < 58 || Code === 8 || Code === 9 || Code === 45);
            }
        }
        if (keynum > 47 && keynum < 58 || keynum == 0 || keynum == 8) {
            ret = true;
        } else if (keynum == 46 && flagPunto.length < 2) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    });

    jQuery(objdecimal).keyup(function(ev) {
        var Valor = jQuery(this).val();
        var a = Valor.split('.');
        var index;
        var limit;
        if (a.length == '2' && nDecimales > 0 && a[1].length > nDecimales)
        {
            index = parseFloat(jQuery(this).val().indexOf("."));
            if (index <= 9) {
                limit = index + parseFloat(nDecimales) + 1;
                jQuery(this).val(jQuery(this).val().substring(0, limit));
            }
        } else
        if (nDecimales == 0) {
            jQuery(this).val(jQuery(this).val().replace(".", ""));
        }
    });




//    
//    
//    
//    jQuery(objdecimal).keypress(function(event) {
//        var decim = "";
//        var dec = "";
//        var deci = "";
//        var datosdeci = "";
//        if (event.which) {
//            if (event.which === 45 && objdecimal.selectionStart === 0) {
//                return  (event.which > 47 && event.which < 58 || event.which === 8 || event.which === 45);
//            } else {
//                if ((jQuery(objdecimal).val().indexOf(".") > -1) || (jQuery(objdecimal).val() === "")) {
//
//                    if (event.which > 96 && event.which < 123) {
//                        return (event.which === 8);
//                    } else {
//                        deci = jQuery(objdecimal).val().split(".");
//                        dec = deci[1];
//                        if (isUndefinedOrNull(dec)) {
//                            return (event.which > 47 && event.which < 58 || event.which === 8);
//                        } else {
//                            decim = dec.toString().length;
//                            datosdeci = jQuery(objdecimal).data("ndecimalneg");
//                            if (!isUndefinedOrNull(datosdeci)) {
//                                if (decim < datosdeci) {
//                                    return (event.which > 47 && event.which < 58 || event.which === 8);
//                                } else {
//                                    return (event.which === 8);
//                                }
//                            } else {
//                                return (event.which > 47 && event.which < 58 || event.which === 8);
//                            }
//                        }
//                    }
//                } else {
//                    return (event.which > 47 && event.which < 58 || event.which === 8 || event.which === 46);
//                }
//            }
//        } else if (event.charCode) {
//            if (event.charCode === 45 && jQuery(this).val().length === 0) {
//                return  (event.charCode > 47 && event.charCode < 58 || event.charCode === 8 || event.charCode === 45);
//            } else {
//                if ((jQuery(objdecimal).val().indexOf(".") > -1) || (jQuery(objdecimal).val() === "")) {
//                    if (event.charCode > 96 && event.charCode < 123) {
//                        return (event.charCode === 8);
//                    } else {
//                        deci = jQuery(objdecimal).val().split(".");
//                        dec = deci[1];
//                        if (isUndefinedOrNull(dec)) {
//                            return (event.charCode > 47 && event.charCode < 58 || event.charCode === 8);
//                        } else {
//                            decim = dec.toString().length;
//                            datosdeci = jQuery(objdecimal).data("ndecimalneg");
//                            if (!isUndefinedOrNull(datosdeci)) {
//                                if (decim < datosdeci) {
//                                    return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8);
//                                } else {
//                                    return (event.charCode === 8);
//                                }
//                            } else {
//                                return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8);
//                            }
//                        }
//                    }
//                } else {
//                    return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8 || event.charCode == 46);
//                }
//            }
//        } else if (window.event.keyCode) {
//            if (window.event.keyCode === 45 && jQuery(this).val().length === 0) {
//                return  (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode === 8 || window.event.keyCode === 45);
//            } else {
//                if ((jQuery(objdecimal).val().indexOf(".") > -1) || (jQuery(objdecimal).val() == "")) {
//                    if (window.event.keyCode > 96 && window.event.keyCode < 123) {
//                        return (window.event.keyCode === 8);
//                    } else {
//                        deci = jQuery(objdecimal).val().split(".");
//                        dec = deci[1];
//                        if (isUndefinedOrNull(dec)) {
//                            return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode === 8);
//                        } else {
//                            decim = dec.toString().length;
//                            datosdeci = jQuery(objdecimal).data("ndecimalneg");
//                            if (!isUndefinedOrNull(datosdeci)) {
//                                if (decim < datosdeci) {
//                                    return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8);
//                                } else {
//                                    return (window.event.keyCode === 8);
//                                }
//                            } else {
//                                return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8);
//                            }
//                        }
//                    }
//                } else {
//                    return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8 || window.event.keyCode == 46);
//                }
//            }
//        }
//    });
};
var DeleteSigno = function() {
    DeleteMiles();
    DeleteSignoMoneda();
    DeleteSignoPorcent();
};

var DeleteSignoPorcent = function() {
    jQuery(".numeroPorcentaje").each(function() {
        var dat = "";
        var newString = "";
        dat = jQuery(this).val();
        for (var j = 0; j < dat.length; j++) {
            if (dat[j] !== "%") {
                newString += dat[j];
            } else {
                newString += "";
            }
        }
        jQuery(this).val("");
        jQuery(this).val(newString);
    });
};
var DeleteSignoMoneda = function() {
    jQuery(".DecimalMoneda").each(function() {
        var dat = "";
        var newString = "";
        dat = jQuery(this).val();
        for (var j = 0; j < dat.length; j++) {
            if (dat[j] !== "$") {
                if (dat[j] === "(") {
                    newString += "-";
                } else
                if (dat[j] === ")") {
                    newString += "";
                } else {
                    newString += dat[j];
                }
            } else {
                newString += "";
            }
        }
        jQuery(this).val("");
        jQuery(this).val(newString);
    });
};
//var Calculo30Porcent = function() {
//    var TreintaPorc = 0;
//    if (jQuery("td#10028 .DecimalMoneda").length > 0 && jQuery("td#10036 .DecimalMoneda").length > 0) {
//        var valorNeto = jQuery("td#10028 .DecimalMoneda").val();
//        TreintaPorc = parseFloat((valorNeto * 30) / 100);
//        jQuery("td#10036 .DecimalMoneda").val(TreintaPorc);
//        jQuery("td#10036 .DecimalMoneda").attr("value", TreintaPorc);
//    }
//};
var AddSigno = function() {
    DeleteSigno();
    separadorMiles();
    AddSignoMoneda();
    AddSignoPorcent();
};
var AddSignoPorcent = function() {
    jQuery(".numeroPorcentaje").each(function() {
        var Stringnew = "";
        var newString = "";
        var dat = "";
        dat = jQuery(this).val();
        for (var j = 0; j < dat.length; j++) {
            if (dat[j] !== "%") {
                newString += dat[j];
            } else {
                newString += "";
            }
        }
        jQuery(this).val("");
        Stringnew = newString + "%";
        jQuery(this).val(Stringnew);
    });
};
var dato1 = "", dato2 = "", est = 0;
var RentaNetaPerdidaFiscal = function() {

    if (est == 0) {
        dato1 = jQuery("td#10028 .DecimalMoneda").data("regla");
        dato2 = jQuery("td#10032 .DecimalMoneda").data("regla");
        est = 1;

    }
    var input1 = jQuery("td#10028 .DecimalMoneda");
    var input2 = jQuery("td#10032 .DecimalMoneda");
    if ((input1.length > 0) && (input2.length > 0)) {
        DeleteSignoMoneda();
        if (jQuery("td#10028 .DecimalMoneda").val().indexOf("-") > -1) {
            jQuery("td#10028 .DecimalMoneda").val("0");
            jQuery("td#10028 .DecimalMoneda").attr("value", "0");
            jQuery("td#10028 .DecimalMoneda").data('regla', '[{"tipo": "cxc","regla": "300000-500000"}]');
            jQuery("td#10032 .DecimalMoneda").data('regla', dato2);
        }
        if (jQuery("td#10032 .DecimalMoneda").val().indexOf("-") === -1) {
            jQuery("td#10032 .DecimalMoneda").val("0");
            jQuery("td#10032 .DecimalMoneda").attr("value", "0");
            jQuery("td#10032 .DecimalMoneda").data('regla', '[{"tipo": "cxc","regla": "300000-500000"}]');
            jQuery("td#10028 .DecimalMoneda").data('regla', dato1);
        }
        RecalculoReglas();
    }
};
var AddSignoMoneda = function() {
    jQuery(".DecimalMoneda").each(function() {
        var Stringnew = "";
        var newString = "";
        var dat = "";
        var pausa = 0;
        dat = jQuery(this).val();
        for (var j = 0; j < dat.length; j++) {
            if (dat[j] !== "$") {
                if (dat[j] === "-") {
                    newString += "";
                    pausa = 1;
                } else {
                    newString += dat[j];
                }
            } else {
                newString += "";
            }
        }
        jQuery(this).val("");
        if (pausa === 0) {
            Stringnew = "$" + newString;
        } else {
            Stringnew = "$(" + newString + ")";
        }
        jQuery(this).val(Stringnew);
    });
};
function separadorMiles() {
    jQuery(".DecimalMoneda,.numero_decimal").each(function() {
        var Monto = "";
        var NewMonto = "";
        Monto = jQuery(this);
        Monto = Monto.val().replace(/[\,]/g, "");
        NewMonto = Miles(Monto);
        jQuery(this).val(NewMonto);
    });
}
var DeleteMilesActual = function(objdecimal) {
    var Newvalor = "";
    Newvalor = jQuery(objdecimal).val().replace(/[\,]/g, "");
    jQuery(objdecimal).val(Newvalor);
};
var DeleteMiles = function() {
    jQuery(".DecimalMoneda").each(function() {
        var Newvalor = "";
        Newvalor = jQuery(this).val().replace(/[\,]/g, "");
        jQuery(this).val(Newvalor);
    });
};
function Miles(monto) {
    var x = "", a = "", b = "";
    x = monto.split(".");
    a = x[0];
    b = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(a)) {
        a = a.replace(rgx, '$1' + ',' + '$2');
    }
    return a + b;
}

var FocusDecimalMoneda = function(objdecimal) {
    var valor = "";
    var simbolo = "";

    jQuery(objdecimal).focusout(function() {
        if (jQuery(this).val() === "") {
            jQuery(this).val("0");
        }
        ReglasJson(objdecimal);
    });
    jQuery(objdecimal).focusin(function() {
        DeleteMilesActual(objdecimal);
        var pausa2 = 0;
        valor = jQuery(this).val();
        simbolo = jQuery(this).val();
        var cont = "";
        for (var i = 0; i < simbolo.length; i++) {
            if (simbolo[i] !== "$" && i === 0) {
                cont += valor;
            }
            if (simbolo[0] === "$" && i > 0) {
                if (simbolo[i] === "$") {
                    cont += "";
                } else
                if (simbolo[i] === ")" || simbolo[i] === "(") {
                    cont += "";
                    pausa2 = 1;
                } else {
                    cont += simbolo[i];
                }
            }
        }
        jQuery(this).val("");
        if (pausa2 === 0) {
            if (parseFloat(cont) === 0) {
                jQuery(this).val("");
            } else {
                jQuery(this).val(cont);
            }
        } else {
            jQuery(this).val("-" + cont);
        }
    });

};
var InitDecimalMoneda = function() {
    jQuery(".DecimalMoneda").each(function() {
        var initValor = "";
        initValor = "$" + jQuery(this).val();
        jQuery(this).val(initValor);
    });
};
var getKeyCodes = function(e) {
    var Cod = "";
    if (e.which) {
        Cod = e.which;
    } else
    if (e.keyCode) {
        Cod = e.keyCode;
    } else
    if (e.charCode) {
        Cod = e.charCode;
    }
    return Cod;
};
var DecimalMoneda = function(objdecimal) {
    var nDecimales = "";
    var flagPunto = "";
    var ret = "";
    var keynum = "";
    nDecimales = jQuery(objdecimal).data("ndecimalneg");
    jQuery(objdecimal).keypress(function(event) {
        var Code = getKeyCodes(event);
        var regreso = "";
        keynum = getKeyCodes(event);
        if (Code === 39 || Code === 37) {
            return true;
        }
        flagPunto = jQuery(this).val().split(".");
        if (Code === 45 && objdecimal.selectionStart === 0) {
            if (jQuery(this).val().indexOf("-") > -1) {
                regreso = (Code > 47 && Code < 58 || Code === 8 || Code === 9);
                return  (Code > 47 && Code < 58 || Code === 8 || Code === 9);
            } else {
                regreso = (Code > 47 && Code < 58 || Code === 8 || Code === 9 || Code === 45);
                return  (Code > 47 && Code < 58 || Code === 8 || Code === 9 || Code === 45);
            }
        }
        if (keynum > 47 && keynum < 58 || keynum == 0 || keynum == 8) {
            ret = true;
        } else if (keynum == 46 && flagPunto.length < 2) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    });

    jQuery(objdecimal).keyup(function(ev) {
        var Valor = jQuery(this).val();
        var a = Valor.split('.');
        var index;
        var limit;
        if (a.length == '2' && nDecimales > 0 && a[1].length > nDecimales)
        {
            index = parseFloat(jQuery(this).val().indexOf("."));
            if (index <= 9) {
                limit = index + parseFloat(nDecimales) + 1;
                jQuery(this).val(jQuery(this).val().substring(0, limit));
            }
        } else
        if (nDecimales == 0) {
            jQuery(this).val(jQuery(this).val().replace(".", ""));
        }
    });
};
var InitFormatporcent = function() {
    jQuery(".numeroPorcentaje").each(function() {
        var initValor = "";
        initValor = jQuery(this).val() + "%";
        jQuery(this).val(initValor);
    });
};
var FocusFormatporcent = function(objdecimal) {
    var simbolo = "";
    var newData = "";
    jQuery(objdecimal).focusout(function() {
        ReglasJson(objdecimal);
        RentaNetaPerdidaFiscal();
        var newValor = "";
        var datainput = "";
        var valorinput = "";
        valorinput = jQuery(this).val();
        for (var j = 0; j < valorinput.length; j++) {
            if (valorinput[j] === "%") {
                datainput += "";
            } else {
                datainput += valorinput[j];
            }
        }
        newData = (datainput === "") ? "0" : datainput;
        newValor = newData + "%";
        jQuery(this).val(newValor);
    });
    jQuery(objdecimal).focusin(function() {
        simbolo = jQuery(this).val();
        var cont = "";
        for (var i = 0; i < simbolo.length; i++) {
            if (simbolo[i] === "%") {
                cont += "";
            } else {
                cont += simbolo[i];
            }
        }
        (cont === "0") ? jQuery(this).val("") : jQuery(this).val(cont);
    });
};



var formatporcent = function(objdecimal) {
    jQuery(objdecimal).keypress(function(event) {
        var decim = "";
        var dec = "";
        var deci = "";
        var datosdeci = "";
        if (event.which) {
            if (event.which === 45 && objdecimal.selectionStart === 0) {
                if (jQuery(this).val().indexOf("-") > -1) {
                    return  (event.which > 47 && event.which < 58 || event.which === 8);
                } else {
                    return  (event.which > 47 && event.which < 58 || event.which === 8 || event.which === 45);
                }
            } else {
                if (jQuery(objdecimal).val().indexOf(".") > -1) {

                    if (event.which > 96 && event.which < 123) {
                        return (event.which === 8);
                    } else {
                        deci = jQuery(objdecimal).val().split(".");
                        dec = deci[1];
                        if (isUndefinedOrNull(dec)) {
                            return (event.which > 47 && event.which < 58 || event.which === 8);
                        } else {
                            decim = dec.toString().length;
                            datosdeci = jQuery(objdecimal).data("ndecimalneg");
                            if (!isUndefinedOrNull(datosdeci)) {
                                if (decim < datosdeci) {
                                    return (event.which > 47 && event.which < 58 || event.which === 8);
                                } else {
                                    return (event.which === 8);
                                }
                            } else {
                                return (event.which > 47 && event.which < 58 || event.which === 8);
                            }
                        }
                    }
                } else {
                    return (event.which > 47 && event.which < 58 || event.which === 8 || event.which === 46);
                }
            }
        } else if (event.charCode) {
            if (event.charCode === 45 && jQuery(this).val().length === 0) {
                if (jQuery(this).val().indexOf("-") > -1) {
                    return  (event.charCode > 47 && event.charCode < 58 || event.charCode === 8);
                } else {
                    return  (event.charCode > 47 && event.charCode < 58 || event.charCode === 8 || event.charCode === 45);
                }
            } else {
                if (jQuery(objdecimal).val().indexOf(".") > -1) {
                    if (event.charCode > 96 && event.charCode < 123) {
                        return (event.charCode === 8);
                    } else {
                        deci = jQuery(objdecimal).val().split(".");
                        dec = deci[1];
                        if (isUndefinedOrNull(dec)) {
                            return (event.charCode > 47 && event.charCode < 58 || event.charCode === 8);
                        } else {
                            decim = dec.toString().length;
                            datosdeci = jQuery(objdecimal).data("ndecimalneg");
                            if (!isUndefinedOrNull(datosdeci)) {
                                if (decim < datosdeci) {
                                    return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8);
                                } else {
                                    return (event.charCode === 8);
                                }
                            } else {
                                return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8);
                            }
                        }
                    }
                } else {
                    return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8 || event.charCode == 46);
                }
            }
        } else if (window.event.keyCode) {
            if (window.event.keyCode === 45 && jQuery(this).val().length === 0) {
                if (jQuery(this).val().indexOf("-") > -1) {
                    return  (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode === 8);
                } else {
                    return  (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode === 8 || window.event.keyCode === 45);
                }
            } else {
                if (jQuery(objdecimal).val().indexOf(".") > -1) {
                    if (window.event.keyCode > 96 && window.event.keyCode < 123) {
                        return (window.event.keyCode === 8);
                    } else {
                        deci = jQuery(objdecimal).val().split(".");
                        dec = deci[1];
                        if (isUndefinedOrNull(dec)) {
                            return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode === 8);
                        } else {
                            decim = dec.toString().length;
                            datosdeci = jQuery(objdecimal).data("ndecimalneg");
                            if (!isUndefinedOrNull(datosdeci)) {
                                if (decim < datosdeci) {
                                    return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8);
                                } else {
                                    return (window.event.keyCode === 8);
                                }
                            } else {
                                return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8);
                            }
                        }
                    }
                } else {
                    return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8 || window.event.keyCode == 46);
                }
            }
        }
    });
};
var Focusformatnumber = function(objdecimal) {
    jQuery(objdecimal).focusout(function() {
        if (jQuery.trim(jQuery(this).val()) == "") {
            jQuery(this).val("0");
        }
        ReglasJson(objdecimal);
    });
    jQuery(objdecimal).focusin(function() {
        if (parseFloat(jQuery(this).val()) === 0) {
            jQuery(this).val("");
        }
    });
};
var formatnumber = function(objnumber) {
    jQuery(objnumber).keypress(function(event) {

        if (event.which) {
            return (event.which > 47 && event.which < 58 || event.which == 8);
        } else if (event.charCode) {
            return (event.charCode > 47 && event.charCode < 58 || event.charCode == 8);
        } else if (window.event.keyCode) {
            return (window.event.keyCode > 47 && window.event.keyCode < 58 || window.event.keyCode == 8);
        }
    });
};
var nSerieExtravio = function(objserie) {
    jQuery(objserie).keypress(function(e) {
        if (e.which) {
            return (e.which > 47 && e.which < 58 || e.which === 8 || e.which > 43 && e.which < 46);
        } else if (e.charCode) {
            return (e.charCode > 47 && e.charCode < 58 || e.charCode == 8 || e.charCode > 43 && e.charCode < 46);
        } else if (window.e.keyCode) {
            return (window.e.keyCode > 47 && window.e.keyCode < 58 || window.e.keyCode == 8 || window.e.keyCode > 43 && window.e.keyCode < 46);
        }
    });
};
var DatePeriodosYear = function() {
    jQuery(".DatePeriodoYear").each(function() {
        DatePeriodoYear(this);
        afterShowCalendarThree();
    });
};
var DatePeriodoYear = function(Datapicker) {
    var date = new Date();
    var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
    jQuery(Datapicker).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'mm/yy',
        showOn: "button",
        buttonImage: "/" + url_modulos + "/images/img_plantilla/ico-calendario.png",
        buttonImageOnly: true,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        maxDate: new Date(y - 1, 11),
        minDate: new Date(2001, 0),
        yearRange: "c-14:c+10",
        showButtonPanel: true,
        closeText: "Aceptar",
        onClose: function() {
            var iYear = jQuery("#ui-datepicker-div .ui-datepicker-year :selected").val();
            jQuery(this).datepicker('setDate', new Date(iYear, 0, 1));
            restrictAct5(iYear);
            if (jQuery.trim(jQuery(this).val()) !== "") {
                hideRequired(this);
            } else {
                showRequired(this);
            }
        }
    });
};
function restrictAct5(year) {
    jQuery(".DatePeriodoH").datepicker("option", "minDate", new Date(year, 11));
    jQuery(".DatePeriodoH").datepicker("option", "maxDate", new Date(year, 11));
    jQuery(".DatePeriodoH").datepicker('setDate', new Date(year, 11, 1));
}
;
var afterShowCalendarThree = function() {
    jQuery("#ui-datepicker-div").addClass("myclassdoesntgo");
    jQuery("#ui-datepicker-div").addClass("removeMonthsAndDays");
};
var EvaluarRegla = function(campo, nfila, exclusiones) {
    var sumaFil = 0;
    var TotalFil = 0;
    var valCasilla = "";
    var arregloExcusiones = "";
    arregloExcusiones = new String(exclusiones).split(",");
    jQuery("table.TablaReglas tr").eq(nfila).find("td input").each(function() {
        valCasilla = jQuery(this).data("casilla");
        if (jQuery.inArray(valCasilla.toString(), arregloExcusiones) === -1) {
            if (jQuery(this).attr("id") !== jQuery("table.TablaReglas tr").eq(nfila).find(campo).attr("id") && jQuery(this).val() !== "") {
                sumaFil += Number(parseFloat(jQuery(this).val()));
            }
        }
    });
    TotalFil = parseFloat(sumaFil).toFixed(2);
    jQuery("table.TablaReglas tr#" + nfila).find(campo).val("");
    jQuery("table.TablaReglas tr#" + nfila).find(campo).val(TotalFil.toString());
    jQuery("table.TablaReglas tr#" + nfila).find(campo).attr("value", TotalFil.toString());
};
var convertCasillas = function(casilla) {
    var Casillas = "";
    for (var j = 0; j < casilla.length; j++) {
        Casillas += "C" + casilla[j].toString() + ",";
    }

    return Casillas;
};
var ConverCasillas = function(casilla, ReglaCxC) {
    var StringReglaCxC = "";
    var nu = 0;
    var StringReglaCxC = "";
    for (var j = 0; j < casilla.length; j++) {
        if (nu === 1) {
            StringReglaCxC = StringReglaCxC.replace(casilla[j].toString(), "C" + casilla[j].toString());
        } else {
            StringReglaCxC = ReglaCxC.replace(casilla[j].toString(), "C" + casilla[j].toString());
            nu = 1;
        }
    }

    return StringReglaCxC;
};
var CalculoCxC = function(objtotal, ReglaCxC) {
    var ArrayReglaCxC = "";
    var TotalCxC = 0;
    var arregloCasillas = "";
    var StringReglaCxC = "";
    var nu = 0;
    var n = 0;
    for (var i = 0; i < ReglaCxC.length; i++) {
        if (n === 1) {
            if ((ReglaCxC[i] === "-") || (ReglaCxC[i] === "+") || (ReglaCxC[i] === "/") || (ReglaCxC[i] === "*")) {
                ArrayReglaCxC = ArrayReglaCxC.replace(ReglaCxC[i], ",");
            }
        } else {
            if ((ReglaCxC[i] === "-") || (ReglaCxC[i] === "+") || (ReglaCxC[i] === "/") || (ReglaCxC[i] === "*")) {
                ArrayReglaCxC = ReglaCxC.replace(ReglaCxC[i], ",");
                n = 1;
            }
        }
    }
    arregloCasillas = ArrayReglaCxC.split(",");
    var ArraryC = convertCasillas(arregloCasillas);
    var ArrayTransformer = ConverCasillas(arregloCasillas, ReglaCxC);
    var ArraryCasillas = ArraryC.split(",");
    var Tcasilla = "";
    var cont = 0;
    var cas = "";
    jQuery("table.TablaReglas tr td input").each(function() {
        cas = jQuery(this).data("casilla");
        if (!isUndefinedOrNull(cas)) {
            cont += 1;
        }
    });

    for (var s = 0; s <= cont; s++) {
        var valorCasilla = "";
        valorCasilla = jQuery("table.TablaReglas tr td input").eq(s).data("casilla");
        if (!isUndefinedOrNull(valorCasilla)) {
            Tcasilla += "C" + valorCasilla + ",";
        }
    }
    var CasillasArray = Tcasilla.split(",");
    var flagPorcen = false;
    for (var j = 0; j < ArraryCasillas.length; j++) {
        var arregloMoneda = 0;
        var dataCelda = "";
        var casillaTable = ArraryCasillas[j].toString().split("C");
        if (jQuery.inArray(ArraryCasillas[j].toString(), CasillasArray) === -1) {
            dataCelda = ArraryCasillas[j].toString();
            var porcent = "";
            porcent = dataCelda.split("%");
            if (typeof porcent[1] !== "undefined") {
                var porcentaje = "0";
                porcentaje = porcent[0].replace("C", "");
                if (nu === 1) {
                    StringReglaCxC = StringReglaCxC.replace(dataCelda, porcentaje.toString());
                } else {
                    StringReglaCxC = ArrayTransformer.replace(dataCelda, porcentaje.toString());
                    nu = 1;
                }
                flagPorcen = true;
            } else {
                if (nu === 1) {
                    StringReglaCxC = StringReglaCxC.replace(dataCelda, "(0)");
                } else {
                    StringReglaCxC = ArrayTransformer.replace(dataCelda, "(0)");
                    nu = 1;
                }
            }
        } else {
            if (!isUndefinedOrNull(casillaTable[1])) {
                arregloMoneda = jQuery("table.TablaReglas tr").find("td input[data-casilla='" + casillaTable[1].toString() + "']").val();
                if (arregloMoneda === "") {
                    arregloMoneda = "0";
                }
                dataCelda = ArraryCasillas[j].toString();
                if (nu === 1) {
                    StringReglaCxC = StringReglaCxC.replace(dataCelda, "(" + arregloMoneda + ")");
                } else {
                    StringReglaCxC = ArrayTransformer.replace(dataCelda, "(" + arregloMoneda + ")");
                    nu = 1;
                }
            }
        }
    }
    var TotalCasillas = new String(StringReglaCxC);
    if (flagPorcen) {
        var evaluacion = "";
        var expresion = "";
        var exp1 = "";
        var exp2 = "";
        var ex = "";
        var e = "";
        var corteMultiplicacion = "";
        evaluacion = TotalCasillas.toString();
        corteMultiplicacion = evaluacion.split("/");
        if ((typeof corteMultiplicacion[1] !== "undefined") && (typeof corteMultiplicacion[0] !== "undefined")) {
            exp1 = corteMultiplicacion[0].toString();
            exp2 = corteMultiplicacion[1].toString().split("*");
            ex = evalDivisionPorcent(exp1, exp2[0]);
            expresion = ex.toString() + "*" + exp2[1].toString();
            e = parseFloat(eval(expresion.toString())).toFixed(2);

            if (!isNaN(e)) {
                if (isFinite(e)) {
                    jQuery("table.TablaReglas tr td").find(objtotal).val("");
                    jQuery("table.TablaReglas tr td").find(objtotal).val(e.toString());
                    jQuery("table.TablaReglas tr td").find(objtotal).attr("value", e.toString());
                } else {
                    jQuery("table.TablaReglas tr td").find(objtotal).val("0");
                }
            } else {
                jQuery("table.TablaReglas tr td").find(objtotal).val("0");
            }

        }
    } else {
        var TotalCalc = eval(TotalCasillas.toString());
        TotalCxC = parseFloat(TotalCalc).toFixed(2);
        if (!isNaN(TotalCalc)) {
            if (isFinite(TotalCalc)) {
                jQuery("table.TablaReglas tr td").find(objtotal).val("");
                jQuery("table.TablaReglas tr td").find(objtotal).val(TotalCxC.toString());
                jQuery("table.TablaReglas tr td").find(objtotal).attr("value", TotalCxC.toString());
            } else {
                jQuery("table.TablaReglas tr td").find(objtotal).val("0");
            }
        } else {
            jQuery("table.TablaReglas tr td").find(objtotal).val("0");
        }
    }
};
function DelParentesis(valor) {
    valor = valor.replace("(", "");
    valor = valor.replace(")", "");
    return valor;
}
var evalDivisionPorcent = function(e1, e2) {
    var res = "0";
    if (parseFloat(DelParentesis(e1)) > 0 && parseFloat(DelParentesis(e2)) === 0) {
        res = "1";
    } else
    if (parseFloat(DelParentesis(e1)) < 0 && parseFloat(DelParentesis(e2)) === 0) {
        res = "-1";
    } else
    if (parseFloat(DelParentesis(e1)) === 0 && parseFloat(DelParentesis(e2)) === 0) {
        res = "0";
    } else {
        res = eval(parseFloat(DelParentesis(e1)) + "/" + parseFloat(DelParentesis(e2)));
    }
    return parseFloat(res);
};
var RecalculoReglas = function() {
    DeleteSigno();
    jQuery("table.TablaReglas tr td input").each(function() {
        var total = "";
        var data = "";
        data = jQuery(this).data("regla");
        total = jQuery(this);
        if (!isUndefinedOrNull(data)) {
            if (typeof data !== "object") {
                data = jQuery.parseJSON(data);
            }
            jQuery.each(data, function(keytd, valtd) {
                if (valtd.tipo === "f") {
                    CalculoFilas();
                } else
                if (valtd.tipo === "c") {
                    CalculoColumnas(total, valtd.exclusiones, valtd.resta);
                } else
                if (valtd.tipo === "cxc") {
                    CalculoCxC(total, valtd.regla);
                }
            });
        }
    });
    AddSigno();
};
var InitRecalcReglas = function() {
    DeleteSigno();
    jQuery("table.TablaReglas tr td input").each(function() {
        var total = "";
        var data = "";
        data = jQuery(this).data("regla");
        total = jQuery(this);
        if (!isUndefinedOrNull(data)) {
            if (typeof data !== "object") {
                data = jQuery.parseJSON(data);
            }
            jQuery.each(data, function(keytd, valtd) {
                if (valtd.tipo === "f") {
                    CalculoFilas();
                } else
                if (valtd.tipo === "c") {
                    CalculoColumnas(total, valtd.exclusiones, valtd.resta);
                } else
                if (valtd.tipo === "cxc") {
                    CalculoCxC(total, valtd.regla);
                }
            });
        }
    });

    RentaNetaPerdidaFiscal();
    AddSigno();

};

var extraerTipoRegla = function(json) {
    var tipoRegla = "";
    jQuery.each(json, function(keytd, valtd) {
        tipoRegla = valtd.tipo;
    });
    return tipoRegla;
};
var extraerExclusiones = function(json) {
    var exclusiones = "";
    jQuery.each(json, function(keytd, valtd) {
        exclusiones = valtd.exclusiones;
    });
    return exclusiones;
};
var extraerResta = function(json) {
    var resta = "";
    jQuery.each(json, function(keytd, valtd) {
        resta = valtd.resta;
    });
    return resta;
};
var CalculoFilas = function() {
    jQuery("table.TablaReglas tr").each(function() {
        var IdFile = "";
        IdFile = jQuery("table.TablaReglas tr").index(jQuery(this));
        var recalSuma = 0;
        var Restaparam = 0;
        var TsumaFil = 0;
        var TotalFilas = 0;
        var idlasin = "";
        var valCasilla = "";
        var exclusiones = "";
        var resta = "";
        idlasin = jQuery("table.TablaReglas tr").eq(IdFile).find("td input").last().attr("id");
        if (!isUndefinedOrNull(jQuery("#" + idlasin).data("regla"))) {
            var arregloExcusiones = "";
            var arregloRestas = "";
            var tipoRegla = "";
            var reglaInput = jQuery("#" + idlasin).data("regla");
            if (typeof reglaInput !== "object") {
                reglaInput = jQuery.parseJSON(reglaInput);
            }
            tipoRegla = extraerTipoRegla(reglaInput);
            exclusiones = extraerExclusiones(reglaInput);
            resta = extraerResta(reglaInput);
            arregloExcusiones = isUndefinedOrNull(exclusiones) ? '' : new String(exclusiones).split(",");
            arregloRestas = isUndefinedOrNull(resta) ? '' : new String(resta).split(",");
            if (tipoRegla === "f") {
                jQuery("table.TablaReglas tr").eq(IdFile).find("td input").each(function() {
                    var valor = 0;
                    var idin = "";
                    valor = jQuery(this).val();
                    valCasilla = jQuery(this).data("casilla");
                    idin = jQuery(this).attr("id");
                    if (idin !== idlasin && valor !== "") {
                        if (jQuery.inArray(valCasilla.toString(), arregloExcusiones) === -1) {
                            recalSuma += Number(parseFloat(valor));
                        }
                        if (jQuery.inArray(valCasilla.toString(), arregloRestas) > -1) {
                            Restaparam += Number(parseFloat(valor));
                        }
                    }
                });
                TsumaFil = eval(recalSuma - Restaparam);
                TotalFilas = parseFloat(TsumaFil).toFixed(2);
                jQuery("#" + idlasin).val("");
                jQuery("#" + idlasin).val(TotalFilas.toString());
                jQuery("#" + idlasin).attr("value", TotalFilas.toString());
            }
        }
    });
};
var CalculoColumnas = function(objtotal, exclusiones, resta) {
    var valorDataTolal = "";
    var TotalColumnas = 0;
    var valCasilla = "";
    var TsumaCol = 0;
    var sumaCol = 0;
    var sumaColRestar = 0;
    var arregloExcusiones = "";
    var arregloRestas = "";
    arregloExcusiones = isUndefinedOrNull(exclusiones) ? '' : new String(exclusiones).split(",");
    arregloRestas = isUndefinedOrNull(resta) ? '' : new String(resta).split(",");
    valorDataTolal = jQuery(objtotal).data("identify");
    jQuery("table.TablaReglas tr td").find("input").each(function() {
        var valorData = "";
        if (jQuery(this).val() !== "undefined" && jQuery(this).val().length !== 0) {
            valorData = jQuery(this).data("identify");
            valCasilla = jQuery(this).data("casilla");
            if (jQuery.inArray(valCasilla.toString(), arregloExcusiones) === -1) {
                if (valorData === valorDataTolal && jQuery(this).attr("id") !== jQuery(objtotal).attr("id")) {
                    sumaCol += Number(parseFloat(jQuery(this).val()));
                }
            }
            if (jQuery.inArray(valCasilla.toString(), arregloRestas) > -1) {
                if (valorData === valorDataTolal && jQuery(this).attr("id") !== jQuery(objtotal).attr("id")) {
                    sumaColRestar += Number(parseFloat(jQuery(this).val()));
                }
            }
        }
    });

    TsumaCol = eval(sumaCol - sumaColRestar);
    TotalColumnas = parseFloat(TsumaCol).toFixed(2);
    jQuery("table.TablaReglas tr td").find(objtotal).val("");
    jQuery("table.TablaReglas tr td").find(objtotal).val(TotalColumnas);
    jQuery("table.TablaReglas tr td").find(objtotal).attr("value", TotalColumnas);
    CalculoFilas();
};

var ReglasJson = function(objInput) {
    DeleteSigno();
    isUndefinedOrNull(jQuery("#btnDicc")) ? '' : jQuery("#btnDicc").attr({"dir": "true"});
    jQuery("table.TablaReglas tr td input").each(function() {
        var total = "";
        var data = "";
        var valOld = "";
        var valNew = "";
        data = jQuery(this).data("regla");
        total = jQuery(this);
        if (!isUndefinedOrNull(data)) {
            valOld = jQuery(total).val();
            if (typeof data !== "object") {
                data = jQuery.parseJSON(data);
            }
            jQuery.each(data, function(keytd, valtd) {
                if (valtd.tipo === "f") {
                    CalculoFilas();
                } else
                if (valtd.tipo === "c") {
                    CalculoColumnas(total, valtd.exclusiones, valtd.resta);
                } else
                if (valtd.tipo === "cxc") {
                    CalculoCxC(total, valtd.regla);
                }
            });
            valNew = jQuery(this).val();
            verificarCalculoRenta(jQuery(this), valNew, valOld);
        }
    });
    RentaNetaPerdidaFiscal();
    AddSigno();

};
var afterBtnConsultaLibre = function() {
    afterRestablecer();
    //    hidenOptions();
    numerodecimal();
    DecimalMoneda();
    separadorMiles();

};
var afterRestablecer = function() {
    fechaDiez();
    NumNIT();
    onlynumber();
    DateSimples();
    DateSimpleAnts();
    DesdeBefores();
    DateShowMonthYears();
    numerodecimal();
    DecimalMonedas();
    separadorMiles();
    mascaraDecimales("inputDecimalMI", 2);
    obj = jQuery("#valorsujetocalculo");
    if (!isUndefinedOrNull(obj.val()))
    {
        obj.blur();
    }


};

var compDate = function(input) {
    //console.log(input);
    var input$ = jQuery(input);
    var valor = input$.val();
    //console.log(valor.length);
    if (valor.length > 9) {
        //console.log("mayor que 10: "+ valor);
        if (existeFecha(valor)) {
            input$.val(valor);
        }
        else {
            input$.val("");
        }

    }
    else {
        //console.log("menor que 10 "+valor);
    }


};



var existeFecha = function(fecha) {
    var fechaf = fecha.split("/");
    var day = fechaf[0];
    var month = fechaf[1];
    var year = fechaf[2];
    var date = new Date(year, month, '0');
    if ((day - 0) > (date.getDate() - 0)) {
        return false;
    }
    return true;
};