package mj.gob.sisadmrh.controller.capacitacion;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.Estado;
import mj.gob.sisadmrh.service.CapacitacionService;
import mj.gob.sisadmrh.service.CapacitadorService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("capacitacion")
@RequestMapping(value = "capacitaciones")
public class CapacitacionController extends UtilsController{
     private EmpleadoService empleadoService;
    @Autowired
    public void SetEmpleadoService(EmpleadoService empleadoService){
    this.empleadoService=empleadoService;
    }
    
    @Autowired
    private EstadoService estadoService;
    private CapacitacionService capacitacionService;
     
       @Autowired
    public void setCapacitacionService(CapacitacionService capacitacionService) {
        this.capacitacionService= capacitacionService;
    }
    
    
    private CapacitadorService capacitadorService;
    @Autowired
    public void SetCapacitadorService(CapacitadorService capacitadorService){
    this.capacitadorService=capacitadorService;
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
         Iterable<Capacitador> capacitadores = capacitadorService.listAllCapacitador();
         // System.out.println("numero:"+capacitadores);
        model.addAttribute("capacitadores", capacitadores);
        return PREFIX + "capacitacionform";
    }
    
    @RequestMapping("new/capacitacion")
    public String newCapacitacion(Model model) {
        model.addAttribute("capacitacion", new Capacitacion());
        
          Iterable<Capacitador> capacitadores = capacitadorService.listAllCapacitador();
          Iterable<Estado> catCap = estadoService.findBySuperior(1674);
           Iterable<Estado> deptoResponsalbe = estadoService.findBySuperior(1684);
           Iterable<Estado> estadoCap = estadoService.findBySuperior(1694);
         // System.out.println("numero:"+capacitadores);
        model.addAttribute("capacitadores", capacitadores);//pasa los datos a la vista
        model.addAttribute("catCap", catCap);
         
         model.addAttribute("deptoResponsalbe", deptoResponsalbe);
         model.addAttribute("estadoCap", estadoCap);
        return PREFIX + "capacitacionform";//retorna a la vista
    }
    
    @RequestMapping(value = "capacitacion")
    public String saveCapacitacion(Capacitacion capacitacion,Model model,SessionStatus status) {
        try{
           capacitacionService.saveCapacitacion(capacitacion);
           status.setComplete();
            bitacoraService.BitacoraRegistry("se guardo una Capacitacion",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
           model.addAttribute("msg", 0);
        }
        catch(Exception e){
           model.addAttribute("msg", 1);
        }
       return PREFIX + "capacitacionform";
       
        //return "redirect:./show/" + capacitacion.getCodigocapacitacion();
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
    public String delete(@PathVariable Integer id,Model model) {
        try{
       
        capacitacionService.deleteCapacitacion(id);
        bitacoraService.BitacoraRegistry("se elimino una Capacitacion",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 3);
        }
        catch(Exception e)
        {
        model.addAttribute("msg", 4);
        }
   
        return "redirect:/capacitaciones/";
    }
    
    @RequestMapping("report/")
    public String reporte(Model model) {
         model.addAttribute("capacitaciones", capacitacionService.listAllCapacitacion());
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
