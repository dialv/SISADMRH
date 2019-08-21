/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.Capacitador;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Estado;
import mj.gob.sisadmrh.service.CapacitadorService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("capacitador")
@RequestMapping(value = "capacitadores")
public class CapacitadorController extends UtilsController{
    
    private CapacitadorService capacitadorService;
    @Autowired
    public void SetCapacitadorService(CapacitadorService capacitadorService){
    this.capacitadorService=capacitadorService;
   
    }
    //se invoca el servie para traer los empleados
     private EmpleadoService empleadoService;
    @Autowired
    public void SetEmpleadoService(EmpleadoService empleadoService){
    this.empleadoService=empleadoService;
    }
    
    @Autowired
    private EstadoService estadoService;

    
    private final String PREFIX="fragments/capacitador/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
    model.addAttribute("capacitadores", capacitadorService.listAllCapacitador());
    return PREFIX + "capacitadores";
    }
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("capacitador", capacitadorService.getCapacitadorById(id));
         Iterable<Empleado> empleados = empleadoService.listAllActivosPensionados();
         Iterable<Estado> tinst = estadoService.findBySuperior(712);
       Iterable<Estado> dominio = estadoService.findBySuperior(1406);
        Iterable<Estado> tipoCapacitador = estadoService.findBySuperior(1422);
         Iterable<Estado> tipoAgrupacion = estadoService.findBySuperior(1432);
//         
      model.addAttribute("empleados", empleados);
      model.addAttribute("tinst", tinst);
       model.addAttribute("dominio", dominio);
        model.addAttribute("tipoCapacitador", tipoCapacitador);
         model.addAttribute("tipoAgrupacion", tipoAgrupacion);
      model.addAttribute("empleados", empleados);
        return PREFIX + "capacitadorform";
    }
     @RequestMapping("new/capacitador")
    public String newCapacitador(Model model) {
        model.addAttribute("capacitador", new Capacitador());
        
        // -----------Manda a la vista los empleados
       Iterable<Empleado> empleados = empleadoService.listAllActivosPensionados();//mostrara empleados activos y pensionados
       Iterable<Estado> tinst = estadoService.findBySuperior(712);
       Iterable<Estado> dominio = estadoService.findBySuperior(1406);
        Iterable<Estado> tipoCapacitador = estadoService.findBySuperior(1422);
         Iterable<Estado> tipoAgrupacion = estadoService.findBySuperior(1432);
//         
      model.addAttribute("empleados", empleados);
      model.addAttribute("tinst", tinst);
       model.addAttribute("dominio", dominio);
        model.addAttribute("tipoCapacitador", tipoCapacitador);
         model.addAttribute("tipoAgrupacion", tipoAgrupacion);
       
        return PREFIX + "capacitadorform";
       //   model.addAttribute("capacitador", new Capacitador());
      //   return PREFIX + "capacitadorform";
    }
    
    
     @RequestMapping(value = "capacitador")
    public String saveCapacitador(@Valid Capacitador capacitador, BindingResult result, Model model,SessionStatus status) {
try{
    capacitador.setEstadocapacitador(1);
 capacitadorService.saveCapacitador(capacitador);
 status.setComplete();//MAANEJA LA SESION PARA EDITAR LOS FORMULARIOS
  bitacoraService.BitacoraRegistry("se  creo un Capacitador",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
  model.addAttribute("msg", 0);
} catch(Exception e){
  model.addAttribute("msg", 1);
}

        return PREFIX + "capacitadores";

        }
  


      
       // return "redirect:./show/" + capacitador.getCodigocapacitador();

    
   // }

     @RequestMapping("show/{id}")
    public String showCapacitador(@PathVariable Integer id, Model model) {
        model.addAttribute("capacitador", capacitadorService.getCapacitadorById(id).get());
        return PREFIX +"capacitadorshow";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        try{} catch(Exception e){}
         Capacitador capacitador =capacitadorService.getCapacitadorById(id).get();
        capacitador.setEstadocapacitador(0);
        capacitadorService.saveCapacitador(capacitador);
         bitacoraService.BitacoraRegistry("se elimino un Capacitador",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        return "redirect:/capacitadores/";
    }
    
     
    @RequestMapping(value = "pdf/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response, HttpServletRequest request) throws Exception {
                Map<String, Object> params = new HashMap<>();
                /*capturando el usuario*/
                params.put("USUARIO",  getRequest().getUserPrincipal().getName());
                
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("capacitadores", "rpt_capacitadores", params, download,response);
    }
    
     @RequestMapping("buscar/")
    public String buscar() {
             
        return PREFIX +"buscar";
    }
    
//    para buscar capacaitadores con jquery
      @RequestMapping(value="buscar/listar/{dato}",method = { RequestMethod.GET})
    public ModelAndView listCapacitador(@PathVariable("dato") String dato) {
        
          ModelAndView mv = new ModelAndView(PREFIX +"listCapacitador");
          
       Iterable<Capacitador> lista =  capacitadorService.findByCapacitador(dato);
          
          
           mv.addObject("capacitadores", lista);
           mv.addObject("dato", dato);
        return mv;
    }
    
}
