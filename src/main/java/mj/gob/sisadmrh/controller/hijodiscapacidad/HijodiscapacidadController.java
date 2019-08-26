package mj.gob.sisadmrh.controller.hijodiscapacidad;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadohijodiscapacidad;
import mj.gob.sisadmrh.model.EmpleadohijodiscapacidadPK;
import mj.gob.sisadmrh.model.Hijodiscapacidad;
import mj.gob.sisadmrh.service.EmpleadoHijosdiscapacidadService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.HijosdiscapacidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "hijodiscapacidades")
public class HijodiscapacidadController extends UtilsController{
    
    private HijosdiscapacidadService hijodiscapacidadService ;
    @Autowired
    private EmpleadoHijosdiscapacidadService empleadoHijosdiscapacidadService;
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    public void setHijodiscapacidadService(HijosdiscapacidadService hijodiscapacidadService) {
        this.hijodiscapacidadService = hijodiscapacidadService;
    }
    
    private final String PREFIX = "fragments/hijodiscapacidad/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("hijodiscapacidades", hijodiscapacidadService.listAllActivos());
        return PREFIX + "hijodiscapacidades";
    }
    
    @RequestMapping("edit/{id}/{idemp}")
    public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("hijodiscapacidad", hijodiscapacidadService.getHijodiscapacidadById(id));
        return PREFIX + "hijodiscapacidadform";
    }
    
     @RequestMapping("edit/hijodiscapacidad/{id}")
    public String editcontacto(Hijodiscapacidad hijodiscapacidad,@PathVariable Integer id, Model model,SessionStatus status) {
        hijodiscapacidad.setEstadohijos(1);
        hijodiscapacidadService.saveHijodiscapacidad(hijodiscapacidad);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico un hijo con discapacidad",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 2);
         model.addAttribute("empleado",id);
          return PREFIX +"hijodiscapacidads";
    }

    @RequestMapping("new/{id}")
    public String newHijodiscapacidad(Model model,@PathVariable Integer id) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        model.addAttribute("hijodiscapacidad", new Hijodiscapacidad());
        return PREFIX + "hijodiscapacidadform";
    }

    @RequestMapping(value = "hijodiscapacidad/{id}")
    public String saveHijodiscapacidad(Hijodiscapacidad hijodiscapacidad,Model model,@PathVariable Integer id,SessionStatus status) {
        try{
            hijodiscapacidad.setEstadohijos(1);
            hijodiscapacidad=hijodiscapacidadService.saveHijodiscapacidad(hijodiscapacidad);
            status.setComplete();
            Empleadohijodiscapacidad emcon = new  Empleadohijodiscapacidad();
        emcon.setHijodiscapacidad(hijodiscapacidad);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadohijodiscapacidadPK emconpk = new EmpleadohijodiscapacidadPK();
        emconpk.setCodigohijodiscapacidad(hijodiscapacidad.getCodigohijodiscapacidad());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadohijodiscapacidadPK(emconpk);
        empleadoHijosdiscapacidadService.saveEmpleadohijodiscapacidad(emcon);
        hijodiscapacidadService.findIntegrity(hijodiscapacidad);
        model.addAttribute("msg", 0);model.addAttribute("empleado",id);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
    return PREFIX +"hijodiscapacidads";
    }
    
    @RequestMapping("show/{id}/{idemp}")    
    public String showHijodiscapacidad(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
         model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("hijodiscapacidad", hijodiscapacidadService.getHijodiscapacidadById(id).get());
        return PREFIX +"hijodiscapacidadshow";
    }

    @RequestMapping("delete/{id}/{idemp}")
    public String delete(@PathVariable Integer id,@PathVariable Integer idemp,Model model) {
        try{
            Hijodiscapacidad hijodiscapacidad = hijodiscapacidadService.getHijodiscapacidadById(id).get();
            hijodiscapacidad.setEstadohijos(0);
            hijodiscapacidadService.saveHijodiscapacidad(hijodiscapacidad);
            Integer cod=empleadoService.getEmpleadoById(idemp).get().getCodigoempleado();
            model.addAttribute("empleado",cod);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        return PREFIX +"hijodiscapacidads";
    }
    
     @RequestMapping(value = "hijodiscapacidad")
    public String saveRol(Hijodiscapacidad hijodiscapacidad, Model model, SessionStatus status) {
        try{
        hijodiscapacidadService.saveHijodiscapacidad(hijodiscapacidad);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se cambio registro de hijos con disc ",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
            return "redirect:/empleados/";
    }
}