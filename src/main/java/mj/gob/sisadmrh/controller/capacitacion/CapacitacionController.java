/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.capacitacion;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.service.CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "capacitaciones")
public class CapacitacionController extends UtilsController{
    
    
    private CapacitacionService capacitacionService;
     
       @Autowired
    public void setCapacitacionService(CapacitacionService capacitacionService) {
        this.capacitacionService= capacitacionService;
    }
    
    
  
    private final String PREFIX = "fragments/capacitacion/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("capacitaciones", capacitacionService.listAllCapacitacion());
        return PREFIX + "capacitaciones";
    }
    
     @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("capacitacion", capacitacionService.getCapacitacionById(id));
        return PREFIX + "capacitacionform";
    }
    
    @RequestMapping("new/capacitacion")
    public String newCapacitacion(Model model) {
        model.addAttribute("capacitacion", new Capacitacion());
     //   model.addAttribute("capacitacion", new Capacitacion());
        return PREFIX + "capacitacionform";
    }
    
    @RequestMapping(value = "capacitacion")
    public String saveCapacitacion(Capacitacion capacitacion) {
        capacitacionService.saveCapacitacion(capacitacion);
       
        return "redirect:./show/" + capacitacion.getCodigocapacitacion();
    }
    
//      @RequestMapping(value = "comite",method=RequestMethod.POST)
//    public String saveComite(@Valid @ModelAttribute(name = "comite") Comite comite) {
//        comiteService.saveComite(comite);
//       
//        return "redirect:./show/" + comite.getCodigocomite();
//    }
//    
//    
     @RequestMapping("show/{id}")
    public String showCapacitacion(@PathVariable Integer id, Model model) {
        
        model.addAttribute("capacitacion", capacitacionService.getCapacitacionById(id).get());
        
        return PREFIX +"capacitacionshow";
    }
     @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        capacitacionService.deleteCapacitacion(id);
        return "redirect:/capacitaciones/";
    }
    
    @RequestMapping("report/")
    public String reporte() {
        return PREFIX + "capacitacionesreport";
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
        	generatePdf("capacitaciones", "rpt_capacitaciones", params, download,response);
    }
    
    
    
      @RequestMapping("buscar/")
    public String buscar() {
             
        return PREFIX +"buscar";
    }
    
    
      @RequestMapping(value="buscar/listar/{dato}",method = { RequestMethod.GET})
    public ModelAndView listCapacitacion(@PathVariable("dato") String dato) {
        
          ModelAndView mv = new ModelAndView(PREFIX +"listCapacitacion");
          
       Iterable<Capacitacion> lista =  capacitacionService.findByDato(dato);
          
          
           mv.addObject("capacitaciones", lista);
           mv.addObject("dato", dato);
        return mv;
    }
    
    
}
