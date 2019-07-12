function mostrarAyuda(idelement)
{
	document.getElementById(idelement).style.visibility = "visible";
        var popup = document.getElementById(idelement);
       popup.classList.toggle("show");
}
function ocultarAyuda(idelement)
{
	document.getElementById(idelement).style.visibility = "hidden";
}
function ValidarFecha(fechainicio,fechafin,idinicial,idfinal){
    var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    var messages="";
     if(fechainicio.length != 0 && fechafin.length == 0){
          msj="FormatoValido";
            messages=msj+","+msj1+","+msj2;
           return  messages;
     }
      else if(fechafin.length != 0){
//            alert("fecha inicio="+fechainicio+" final="+fechafin);
            //Formato MES/DIA/AÑO
            var inicio = Date.parse(convertDateFormat(fechainicio)); //01 de Octubre del 2013
            var final = Date.parse(convertDateFormat(fechafin)); //03 de Octubre del 2013

//            alert("inicio="+inicio+" final="+final);
                if (inicio > final) {
            //        alert("La Fecha de inicio no puede ser mayor que Fecha Final");
                    msj="La Fecha de inicio no debe ser mayor a la Fecha Final";
                    messages=msj+","+msj1+","+msj2;
//                    document.getElementById(idinicial).focus();
            //         document.getElementById(idinicial).value=" ";
//                     document.getElementById(idfinal).value=" ";
                    return messages; 
                } if (inicio === final ) {
//                    alert("entro2");
            //        alert("La Fecha de inicio no puede ser mayor que Fecha Final");
                    msj="La Fecha de inicio no debe ser igual a la Fecha Final";
                    messages=msj+","+msj1+","+msj2;
            //         document.getElementById(idinicial).value=" ";
//                     document.getElementById(idfinal).value=" ";
                    return messages; 
                }else{
                    msj="FormatoValido";
                    messages=msj+","+msj1+","+msj2;
                   return  messages;
                }
         }
    
}


// When the user clicks on div, open the popup
function myFunction(id) {
    var popup = document.getElementById(id);
     popup.classList.toggle("show");
}





function ExisteFecha(fecha,id){
     var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    var messages="";
        var fecha_aux = fecha.split("/");
        var date = new Date();
        var mm=fecha_aux[1];
        var dd=fecha_aux[0];
        var yy=fecha_aux[2];
        var currentYear = date.getFullYear();
 	var Fecha1 = new Date(fecha_aux[2],fecha_aux[1]-1,fecha_aux[0]);
	if (dd>31 || dd<0 || mm>12 || mm<0 || yy>(currentYear+5) || yy<(currentYear-100)){
		msj="Fecha introducida es incorrecta";
//                 document.getElementById(id).value=" ";
		return messages=msj+","+msj1+","+msj2;;
	}
	else{
		   msj="FormatoValido";
                    messages=msj+","+msj1+","+msj2;
                    return  messages;
	}
}


function FechaActual(fecha,id){
     var date = new Date();
}

function FechaActualMenor(fecha){
    
    var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    var messages="";
    var date = new Date();
    var inicio = Date.parse(convertDateFormat(fecha));
     var d = new Date(inicio);
//     alert(d+" # "+date)
     if (d<date)
     {
          msj="La Fecha  ingresada no debe ser menor a la Fecha Actual";
           messages=msj+","+msj1+","+msj2;
           return  messages;
     }
     
}

function FechaActualMayor(fecha){
    
    var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    var messages="";
    var date = new Date();
    var inicio = Date.parse(convertDateFormat(fecha));
     var d = new Date(inicio);
//     alert(d+" # "+date)
     if (d>date)
     {
          msj="La Fecha  ingresada no debe ser mayor a la Fecha Actual";
           messages=msj+","+msj1+","+msj2;
           return  messages;
     }
     
}


function FechaNacimiento(fecha,id){
     var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    var messages="";
        var fecha_aux = fecha.split("/");
        var date = new Date();
        var mm=fecha_aux[1];
        var dd=fecha_aux[0];
        var yy=fecha_aux[2];
        var currentYear = date.getFullYear();
//        alert(dd+"-"+mm+"-"+currentYear);
 	var Fecha1 = new Date(fecha_aux[2],fecha_aux[1]-1,fecha_aux[0]);
 
 	//Comprobamos si existe la fecha
        
	if (dd>31 || dd<0 || mm>12 || mm<0 || yy>(currentYear-16) || yy<(currentYear-100)){
		msj="Fecha introducida es incorrecta";
//                 document.getElementById(id).value=" ";
		return messages=msj+","+msj1+","+msj2;;
	}
	else{
		   msj="FormatoValido";
                    messages=msj+","+msj1+","+msj2;
                    return  messages;
	}
}

function FechaNacimientoh(fecha,id){
     var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    var messages="";
        var fecha_aux = fecha.split("/");
        var date = new Date();
        var mm=fecha_aux[1];
        var dd=fecha_aux[0];
        var yy=fecha_aux[2];
        var currentYear = date.getFullYear();
        var currentMonth = date.getMonth()+1;
        var currentday = date.getDay();
        
        var mmm= parseInt(mm);
//        alert("mes "+currentMonth +" mesm "+mmm +"dd "+currentday+" ddm "+dd);
 	var Fecha1 = new Date(fecha_aux[2],fecha_aux[1]-1,fecha_aux[0]);
 
 	//Comprobamos si existe la fecha
        
	if ( dd>31 || dd<0 || mm>12  || mm<0 || yy>(currentYear) || yy<(currentYear-100)){
		msj="Fecha introducida es incorrecta";
//                 document.getElementById(id).value=" ";
		return messages=msj+","+msj1+","+msj2;;
	}
        if (  dd>(currentday)  && mmm>(currentMonth) && yy>(currentYear)){
		msj="Fecha introducida es incorrecta";
//                 document.getElementById(id).value=" ";
		return messages=msj+","+msj1+","+msj2;;
	} if (  dd>(currentday)  && mmm==(currentMonth) && yy==(currentYear)){
		msj="Fecha introducida es incorrecta";
//                 document.getElementById(id).value=" ";
		return messages=msj+","+msj1+","+msj2;;
	}
	else{
		   msj="FormatoValido";
                    messages=msj+","+msj1+","+msj2;
                    return  messages;
	}
}

function ValidarFechaReporteh(fechainicio,fechafin,idinicial,idfinal){
    var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    
    var messages="";
     if(fechainicio.length != 0 && fechafin.length == 0){
          msj="FormatoValido";
            messages=msj+","+msj1+","+msj2;
           return  messages;
     }
      else 
          if(fechafin.length != 0){
        //    alert("fecha inicio="+fechainicio+" final="+fechafin);
            //Formato MES/DIA/AÑO
            var inicio = Date.parse(convertDateFormat(fechainicio)); //01 de Octubre del 2013
            var final = Date.parse(convertDateFormat(fechafin)); //03 de Octubre del 2013

//            alert("inicio="+inicio+" final="+final);
                if (inicio > final) {
            //        alert("La Fecha de inicio no puede ser mayor que Fecha Final");
                    msj="La Fecha de inicio no debe ser mayor a la Fecha Final";
                    messages=msj+","+msj1+","+msj2;
            //         document.getElementById(idinicial).value=" ";
//                     document.getElementById(idfinal).value=" ";
                    return messages; 
                }else{
                    msj="FormatoValido";
                    messages=msj+","+msj1+","+msj2;
                   return  messages;
                }
         }
    
}
function ValidarFechaReporte(fechainicio,fechafin,idinicial,idfinal){
    var msj="";
    var msj1="Mensaje de Validacion de Fecha!";
    var msj2="FormatoValido";
    
    var messages="";
     if(fechainicio.length != 0 && fechafin.length == 0){
          msj="FormatoValido";
            messages=msj+","+msj1+","+msj2;
           return  messages;
     }
      else 
          if(fechafin.length != 0){
        //    alert("fecha inicio="+fechainicio+" final="+fechafin);
            //Formato MES/DIA/AÑO
            var inicio = Date.parse(convertDateFormat(fechainicio)); //01 de Octubre del 2013
            var final = Date.parse(convertDateFormat(fechafin)); //03 de Octubre del 2013

//            alert("inicio="+inicio+" final="+final);
                if (inicio > final) {
            //        alert("La Fecha de inicio no puede ser mayor que Fecha Final");
                    msj="La Fecha de inicio no debe ser mayor a la Fecha Final";
                    messages=msj+","+msj1+","+msj2;
            //         document.getElementById(idinicial).value=" ";
//                     document.getElementById(idfinal).value=" ";
                    return messages; 
                }else{
                    msj="FormatoValido";
                    messages=msj+","+msj1+","+msj2;
                   return  messages;
                }
         }
    
}

 function convertDateFormat(string) {
        var info = string.split('/').reverse().join('/');
        return info;
   }

function Textheader(texto,titulo){
     titulo=titulo.replace("SISADMRH-", "");
     document.getElementById('nombrepantalla').innerHTML = texto;
     document.getElementById('titulopantalla').innerHTML = titulo;

}

function fecha_format() {
    var msg = '';
    var formularios = document.forms;
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
                        var value = formularios[i].elements[j].id;
                        if(value.includes("fecha") || value.includes("fdesde") || value.includes("fhasta") ){
//                            alert("id:"+value)
                                   var val= formularios[i].elements[j].value
                                   val=nufecha(val)
                                   formularios[i].elements[j].value=val
                                    }
                    }
    }

}

 function nufecha(val){
        arreglo = val.split("/")
        val = arreglo[1]+"/"+arreglo[0]+"/"+arreglo[2];
        return val;
    }
    
     function format_fechaedit(val){
//          alert(val);
        var fecha = val.replace(new RegExp('-', 'g'), '');
//        alert("fecha:"+fecha);
        var yy=fecha.substring(0,4)
        var mm=fecha.substring(4,6)
        var dd=fecha.substring(6,8)
//        alert(dd+"/"+mm+"/"+yy);
        fecha=dd+"/"+mm+"/"+yy;
        return fecha;
    }


function edit_fecha_format() {
    var URLactual = window.location.href;
     var formularios = document.forms;
    if (URLactual.includes("edit")){
//        alert(formularios.length);
        for (var i=0; i<formularios.length;i++){
                        for (var j=0; j<formularios[i].elements.length; j++){
                            var value = formularios[i].elements[j].id;
                            if(value.includes("fecha") || value.includes("fdesde") || value.includes("fhasta") ){
//                                alert("id:"+value)
                                       var val= formularios[i].elements[j].value
                                       val=format_fechaedit(val)
                                       formularios[i].elements[j].value=val
                                        }
                        }
        }
            
    }

}

function pdffile(){
    var formularios = document.forms;
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
                        var value = formularios[i].elements[j].name;
                        var value2 = formularios[i].elements[j].value;
                        var value3 = formularios[i].elements[j].value.split(".");
                        if(value.includes("file") ){
                             if(!value2.includes("pdf")){
                             formularios[i].elements[j].value="";
                              swal({
                title: "Error! en la extension del archivo:" +value3[1],
                text: "El formato del Archivo debe ser PDF",
                type: "error",
                icon: "error"
       });
                        }

                    }
                    else if(value.includes("archivo") ){
                        if(!value2.includes("csv")){
                             formularios[i].elements[j].value="";
                              swal({
                title: "Error! en la extension del archivo:" +value3[1],
                text: "El formato del Archivo debe ser CSV",
                type: "error",
                icon: "error"
       });
                        }
                    }
                }
            }
          }
          
          function pdffile_event(){
    var formularios = document.forms;
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
                        var value = formularios[i].elements[j].name;
                        var value2 = formularios[i].elements[j].value;
                        if(value.includes("file") ){
                            formularios[i].elements[j].setAttribute("accept", "application/pdf");
                              formularios[i].elements[j].setAttribute("onchange", "pdffile()");
                    }
                    else if(value.includes("archivo") ){
                            formularios[i].elements[j].setAttribute("accept", ".csv");
                              formularios[i].elements[j].setAttribute("onchange", "pdffile()");
                    }
                }
            }
          }
            



