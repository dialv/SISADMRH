package mj.gob.sisadmrh.controller.dependiente;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadodependiente;
import mj.gob.sisadmrh.model.EmpleadodependientePK;
import mj.gob.sisadmrh.service.DependienteService;
import mj.gob.sisadmrh.service.EmpleadoDependienteService;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus ;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dialv
 *
 */
@Controller
@RequestMapping(value = "dependientes")
public class DependienteController extends UtilsController {

    private DependienteService dependienteService;
    @Autowired
    private EmpleadoDependienteService empleadoDependienteService;
    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    public void setDependienteService(DependienteService dependienteService) {
        this.dependienteService = dependienteService;
    }

    private final String PREFIX = "fragments/dependiente/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("dependientes", dependienteService.listAllActivos());
        return PREFIX + "dependientes";
    }

    @RequestMapping("edit/{id}/{idemp}")
     public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("dependiente", dependienteService.getDependienteById(id));
        return PREFIX + "dependienteform";
    }

    
    @RequestMapping("edit/dependiente/{id}")
    public String editdependiente(Dependiente dependiente,@PathVariable Integer id, Model model,SessionStatus status) {
        dependiente.setEstadodependiente(1);
        dependienteService.saveDependiente(dependiente);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico un dependiente",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
//        return "redirect:/empleados/show/"+id;
model.addAttribute("msg", 2);
         model.addAttribute("empleado",id);
          return PREFIX +"dependientes";
    }
    
     
    @RequestMapping("new/{id}")
    public String newDependiente(Model model,@PathVariable Integer id) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        model.addAttribute("dependiente", new Dependiente());
        return PREFIX + "dependienteform";
    }

    @RequestMapping(value = "dependiente/{id}")
    public String saveDependiente(Dependiente dependiente, Model model, @PathVariable Integer id,SessionStatus status) {

        try {
            dependiente.setEstadodependiente(1);
            dependiente = dependienteService.saveDependiente(dependiente);
             status.setComplete();
            Empleadodependiente emcon = new Empleadodependiente();
            emcon.setDependiente(dependiente);
            Empleado em = empleadoService.getEmpleadoById(id).get();
            EmpleadodependientePK emconpk = new EmpleadodependientePK();
            emconpk.setCodigodependiente(dependiente.getCodigodependiente());
            emconpk.setCodigoempleado(em.getCodigoempleado());
            emcon.setEmpleadodependientePK(emconpk);
            empleadoDependienteService.saveEmpleadodependiente(emcon);
            bitacoraService.BitacoraRegistry("se Creo un dependiente",getRequest().getRemoteAddr(), 
            getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            dependienteService.findIntegrity(dependiente);
            model.addAttribute("msg", 0);
            model.addAttribute("empleado",id);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
            Logger.getLogger(DependienteController.class.getName()).log(Level.SEVERE, null, e);
        }
//       return "redirect:/empleados/show/"+id;
 return PREFIX + "dependientes";
    }

    @RequestMapping("show/{id}/{idemp}") 
    public String showDependiente(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
         model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
         model.addAttribute("dependiente", dependienteService.getDependienteById(id).get());
        return PREFIX + "dependienteshow";
    }

    @RequestMapping("delete/{id}/{idemp}")
    public String delete(@PathVariable Integer id, @PathVariable Integer idemp,Model model) {

        try {
            Dependiente dependiente = dependienteService.getDependienteById(id).get();
            dependiente.setEstadodependiente(0);
            dependienteService.saveDependiente(dependiente);
            Integer cod=empleadoService.getEmpleadoById(idemp).get().getCodigoempleado();
          model.addAttribute("empleado",cod);
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        return PREFIX + "dependientes";
    }
     @RequestMapping(value = "dependiente")
    public String saveRol(Dependiente dependiente, Model model, SessionStatus status) {
        try{
        dependiente.setEstadodependiente(1);
        dependienteService.saveDependiente(dependiente);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se Creo un dependiente",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
        return "redirect:/empleados/";
    }
}
