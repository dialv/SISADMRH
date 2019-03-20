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
        //    alert("fecha inicio="+fechainicio+" final="+fechafin);
            //Formato MES/DIA/AÑO
            var inicio = Date.parse(fechainicio); //01 de Octubre del 2013
            var final = Date.parse(fechafin); //03 de Octubre del 2013

        //    alert("inicio="+inicio+" final="+final);
                if (inicio > final) {
            //        alert("La Fecha de inicio no puede ser mayor que Fecha Final");
                    msj="La Fecha de inicio no debe ser mayor a la Fecha Final";
                    messages=msj+","+msj1+","+msj2;
            //         document.getElementById(idinicial).value=" ";
                     document.getElementById(idfinal).value=" ";
                    return messages; 
                } if (inicio === final ) {
//                    alert("entro2");
            //        alert("La Fecha de inicio no puede ser mayor que Fecha Final");
                    msj="La Fecha de inicio no debe ser igual a la Fecha Final";
                    messages=msj+","+msj1+","+msj2;
            //         document.getElementById(idinicial).value=" ";
                     document.getElementById(idfinal).value=" ";
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
//        alert(dd+"-"+mm+"-"+currentYear);
 	var Fecha1 = new Date(fecha_aux[2],fecha_aux[1]-1,fecha_aux[0]);
 
 	//Comprobamos si existe la fecha
        
	if (dd>31 || dd<0 || mm>12 || mm<0 || yy>(currentYear+5) || yy<(currentYear-100)){
		msj="Fecha introducida es incorrecta";
                 document.getElementById(id).value=" ";
		return messages=msj+","+msj1+","+msj2;;
	}
	else{
		   msj="FormatoValido";
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
                 document.getElementById(id).value=" ";
		return messages=msj+","+msj1+","+msj2;;
	}
	else{
		   msj="FormatoValido";
                    messages=msj+","+msj1+","+msj2;
                    return  messages;
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
                     document.getElementById(idfinal).value=" ";
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


