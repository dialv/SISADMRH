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
     
     var URLactual = window.location.href;
     
     if(URLactual.includes("edit")){
        document.title= titulo.replace("Crear","Editar");
        document.getElementById('titulopantalla').innerHTML = titulo.replace("Crear","Editar");
     }

}
//function Textheader(texto,titulo){
//     titulo=titulo.replace("SISADMRH-", "");
//     document.getElementById('nombrepantalla').innerHTML = texto;
//     document.getElementById('titulopantalla').innerHTML = titulo;
//
//}
function fecha_formatmisiones() {
   
    var msg = '';
    var formularios = document.forms;
    var valuearray=new Array();
    var idarray=new Array();
    var typearray=new Array();
    var disablearray=new Array();
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
                        var value = formularios[i].elements[j].id;
                        var value2= formularios[i].elements[j].value;
                        var value3= formularios[i].elements[j].type;
                         var value4= formularios[i].elements[j].disabled;
                        valuearray.push(value2);
                        idarray.push(value);
                        typearray.push(value3);
//                        alert(value4);
                         disablearray.push(value4);
//                        if(value.includes("fecha") || value.includes("fdesde") || value.includes("fhasta") ){
//                           
//                                   var val= formularios[i].elements[j].value
//                                    
//                                    
//                                    if(val!=""){
//                                        val=nufecha(val)
//                                        formularios[i].elements[j].value=val
//                                        }
//                                   
//                                    }
                    }
    }
    
     var flag1=false;
//                    
                     for(var i=0;i<idarray.length;i++)
                        {
                            
                            if (typearray[i].toString().includes("reset") || typearray[i].toString().includes("submit") || typearray[i].toString().includes("hidden") | typearray[i].toString().includes("file")){
                                        }else{
                                           var val= valuearray[i].toString()
                                           var val2= disablearray[i].toString()
//                                            alert("valor:"+val)
                                            if(val=="" && val2==false){
                                               flag1=true; 
                                            } 
                                        }

                         }
//                    alert(flag1);
                    if(flag1==false){
                    for(var i=0;i<idarray.length;i++)
                    {
                        
                        if(idarray[i].toString().includes("fecha") || idarray[i].toString().includes("fdesde") || idarray[i].toString().includes("fhasta") ){
                           
                                   var val= valuearray[i].toString();
                                    if(val!=""){
                                        val=nufecha(val)
//                                        formularios[i].elements[j].value=val
//                                        alert("id:"+idarray[i].toString()+" val:"+val);
                                       
                                            for (var k=0; k<formularios.length;k++){
                                                 for (var j=0; j<formularios[k].elements.length; j++){
                                                     var idvalue = formularios[k].elements[j].id;
                                                     if(idarray[i].toString()==idvalue){
                                                        
                                                        formularios[k].elements[j].value=val;     
//                                                         alert("id:"+idarray[i].toString()+" idvalue:"+idvalue+" val:"+val);
                                                     }
                                                 }
                                             }
                                        
                                        }
                                   
                                    }
                    }  
                    }

}

function fecha_format() {
   
    var msg = '';
    var formularios = document.forms;
    var valuearray=new Array();
    var idarray=new Array();
    var typearray=new Array();
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
                        var value = formularios[i].elements[j].id;
                        var value2= formularios[i].elements[j].value;
                        var value3= formularios[i].elements[j].type;
                        valuearray.push(value2);
                        idarray.push(value);
                        typearray.push(value3);
//                        if(value.includes("fecha") || value.includes("fdesde") || value.includes("fhasta") ){
//                           
//                                   var val= formularios[i].elements[j].value
//                                    
//                                    
//                                    if(val!=""){
//                                        val=nufecha(val)
//                                        formularios[i].elements[j].value=val
//                                        }
//                                   
//                                    }
                    }
    }
    
     var flag1=false;
//                    
                     for(var i=0;i<idarray.length;i++)
                        {
                            
                            if (typearray[i].toString().includes("reset") || typearray[i].toString().includes("submit") || typearray[i].toString().includes("hidden") | typearray[i].toString().includes("file")){
                                        }else{
                                           var val= valuearray[i].toString()
//                                            alert("valor:"+val)
                                            if(val==""){
                                               flag1=true; 
                                            } 
                                        }

                         }
//                    alert(flag1);
                    if(flag1==false){
                    for(var i=0;i<idarray.length;i++)
                    {
                        
                        if(idarray[i].toString().includes("fecha") || idarray[i].toString().includes("fdesde") || idarray[i].toString().includes("fhasta") ){
                           
                                   var val= valuearray[i].toString();
                                    if(val!=""){
                                        val=nufecha(val)
//                                        formularios[i].elements[j].value=val
//                                        alert("id:"+idarray[i].toString()+" val:"+val);
                                       
                                            for (var k=0; k<formularios.length;k++){
                                                 for (var j=0; j<formularios[k].elements.length; j++){
                                                     var idvalue = formularios[k].elements[j].id;
                                                     if(idarray[i].toString()==idvalue){
                                                        
                                                        formularios[k].elements[j].value=val;     
//                                                         alert("id:"+idarray[i].toString()+" idvalue:"+idvalue+" val:"+val);
                                                     }
                                                 }
                                             }
                                        
                                        }
                                   
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
function required_field_select(){
    var formularios = document.forms;
    var flag= false;
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
//                        var value = formularios[i].elements[j].setAttribute();
                        var value2 = formularios[i].elements[j].value;
                        var value3 = formularios[i].elements[j].type;
                        if(value3.includes("select") && value2==("") ){
                            formularios[i].elements[j].setAttribute("required","required");;
//                            formularios[i].elements[j].setAttribute("aria-required", "true");;
//                            alert(value2+ " "+value3);
                        }
                         if(value3.includes("select") && value2==("0") ){
                            formularios[i].elements[j].setAttribute("required","required");;
//                            formularios[i].elements[j].setAttribute("aria-required", "true");;
//                            alert(value2+ " "+value3);
//                            formularios[i].elements[j].value="";
                        }
						
			if(value3.includes("select") && value2==("-1") ){
                            formularios[i].elements[j].setAttribute("required","required");;
//                            formularios[i].elements[j].setAttribute("aria-required", "true");;
//                            alert(value2+ " "+value3);
//                            formularios[i].elements[j].value="";
                        }

                }            
            }
            return flag;
          }
function validate_value_field(){
    var formularios = document.forms;
    var flag= false;
    var valuearray=new Array();
    var typearray=new Array();
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
//                        var value = formularios[i].elements[j].setAttribute();
                        var value2 = formularios[i].elements[j].value;
                        var value3 = formularios[i].elements[j].type;
//                        var value4 = formularios[i].elements[j].id;
//                        if(value3.includes("select") && value2==("")){
////                            formularios[i].elements[j].setAttribute("required", "true");;
//                            formularios[i].elements[j].setAttribute("aria-required", "true");;
//                            alert(value2+ " "+value3);
//                        }
                        if (value3.includes("reset") || value3.includes("submit") || value3.includes("hidden")|| value3.includes("file")){
                        }else{ 
                             valuearray.push(value2);
                              typearray.push(value3);
                             if(value3.includes("select") && value2==("0") ){
                            formularios[i].elements[j].setAttribute("required","required");;
//                            formularios[i].elements[j].setAttribute("aria-required", "true");;
//                            alert(value2+ " "+value3);
                            formularios[i].elements[j].value="";
                            value2="";
                        }
						
			if(value3.includes("select") && value2==("-1") ){
                            formularios[i].elements[j].setAttribute("required","required");;
//                            formularios[i].elements[j].setAttribute("aria-required", "true");;
//                            alert(value2+ " "+value3);
                            formularios[i].elements[j].value="";
                            value2="";
                        }
                        
                        
//                            if(value2==("") ){
////                                alert(value2+ " "+value3);
//                                flag=true;
////                                alert(flag+ " flag");
//                                }
                                
                            }
                }
                
                
                
            }
            
//             alert("tamaño "+valuearray.length);
                 
                for(var i=0;i<valuearray.length;i++)
                    {
                         if(valuearray[i].toString()==("") ){
                             flag=true; 
//                             alert(valuearray[i].toString()+" "+typearray[i].toString());
                         }//else{flag=false;}
                    }
//                    alert(flag);
//                fecha_format();
                if (flag==false){
//                    alert(" No debe Entrar");
//                     onclik_validate_value_field();
                      $("#loader").addClass("loader");
                }
            return flag;
          }

//function onclik_validate_value_field(){
//        $("#loader").addClass("loader");
//            }

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
          
          function format_numbers() {
   
    var msg = '';
    var formularios = document.forms;
    var valuearray=new Array();
    var idarray=new Array();
    var typearray=new Array();
    var disablearray=new Array();
    for (var i=0; i<formularios.length;i++){
                    for (var j=0; j<formularios[i].elements.length; j++){
                        var value = formularios[i].elements[j].id;
                        var value2= formularios[i].elements[j].getElementsByClassName('num_decimal3');
                        var value3= formularios[i].elements[j].type;
                         var value4= formularios[i].elements[j].disabled;
//                        valuearray.push(value2);
//                        idarray.push(value);
//                        typearray.push(value3);
                        alert(value2);
//                         disablearray.push(value4);
                    }
    }
    }
            



