/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.costocapacitacion;

import mj.gob.sisadmrh.controller.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.CostoCapacitacion;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.service.CapacitacionService;
import mj.gob.sisadmrh.service.CostoCapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("costocapacitacion")
@RequestMapping(value = "costocapacitaciones")//plural
public class CostoCapacitacionController extends UtilsController{
    private CostoCapacitacionService costoCapacitacionService;
    @Autowired
    public void SetCostoCapasitacionService(CostoCapacitacionService costoCapacitacionService){
    this.costoCapacitacionService=costoCapacitacionService;
    }
     private CapacitacionService capacitacionService;
     @Autowired
    public void setCapacitacionService (CapacitacionService  capacitacionService) {
        this.capacitacionService = capacitacionService;
    }
    
    private final String PREFIX = "fragments/costocapacitacion/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("costocapacitaciones", costoCapacitacionService.listAllCostoCapacitacion());
        return PREFIX + "costocapacitaciones";
    }
    
     @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("costocapacitacion", costoCapacitacionService.getCostoCapacitacionById(id));
         Iterable<Capacitacion> capacitaciones = capacitacionService.listAllCapacitacion();
      model.addAttribute("capacitaciones", capacitaciones);
        return PREFIX + "costocapacitacionform";
    }
    
    @RequestMapping("new/costocapacitacion")
    public String newCostoCapacitacion(Model model) {
        model.addAttribute("costocapacitacion", new CostoCapacitacion());
//        manda a la vista las apacitaciones
         Iterable<Capacitacion> capacitaciones = capacitacionService.listAllCapacitacion();
      model.addAttribute("capacitaciones", capacitaciones);
     //   model.addAttribute("capacitacion", new Capacitacion());
        return PREFIX + "costocapacitacionform";
    }
    
    @RequestMapping(value = "costocapacitacion")
    public String saveCostoCapacitacion(CostoCapacitacion costoCapacitacion, Model model,SessionStatus status) {
        try{
         costoCapacitacionService.saveCostoCapacitacion(costoCapacitacion);
         status.setComplete();
          bitacoraService.BitacoraRegistry("se guardo Un cosot capacitacion",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
          model.addAttribute("msg", 0);
        model.addAttribute("costocapacitaciones", costoCapacitacionService.listAllCostoCapacitacion());
         ///return PREFIX + "costocapacitacionform";
         return PREFIX + "costocapacitaciones";
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
        return PREFIX + "costocapacitaciones";
       
       // return "redirect:./show/" + costoCapacitacion.getCodigocostocapacitacion();
    }
    
 
     @RequestMapping("show/{id}")
    public String showCostoCapacitacion(@PathVariable Integer id, Model model) {
        model.addAttribute("costocapacitacion", costoCapacitacionService.getCostoCapacitacionById(id).get());
        return PREFIX +"costocapacitacionshow";
    }
     @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
              costoCapacitacionService.deleteCostoCapacitacion(id);
              bitacoraService.BitacoraRegistry("se elimino un costo Capacitacion",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
                model.addAttribute("msg", 3);
        }
       
        catch(Exception e){
  model.addAttribute("msg", 4);
        }
          return "redirect:/costocapacitaciones/";
    }
    
    @RequestMapping("report/")
    public String reporte() {
        return PREFIX + "costocapacitacionesreport";
    }
    
    @RequestMapping(value = "pdf/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("costocapacitaciones", "rpt_costocapacitaciones", params, download,response);
    }
    

}
