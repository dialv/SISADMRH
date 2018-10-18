package mj.gob.sisadmrh.controller.dependiente;

import mj.gob.sisadmrh.controller.dependiente.*;
import mj.gob.sisadmrh.controller.dependiente.*;
import mj.gob.sisadmrh.controller.dependiente.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.EmpleadocontactoPK;
import mj.gob.sisadmrh.model.Empleadodependiente;
import mj.gob.sisadmrh.model.EmpleadodependientePK;
import mj.gob.sisadmrh.service.DependienteService;
import mj.gob.sisadmrh.service.DependienteService;
import mj.gob.sisadmrh.service.EmpleadoDependienteService;
import mj.gob.sisadmrh.service.EmpleadoService;
//import mj.gob.sisadmrh.service.DependienteDependienteService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "dependientes")
public class DependienteController extends UtilsController{
    
    private DependienteService dependienteService;
//    private DependienteDependienteService dependienteDependienteService;
     @Autowired
    private EmpleadoDependienteService empleadoDependienteService;
    @Autowired
    private EmpleadoService empleadoService;


    
    @Autowired
    public void setDependienteService(DependienteService dependienteService) {
        this.dependienteService = dependienteService;
    }
    
    private final String PREFIX = "fragments/dependiente/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("dependientes", dependienteService.listAllDependiente());
        return PREFIX + "dependientes";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("dependiente", dependienteService.getDependienteById(id));
        return PREFIX + "dependienteform";
    }

    @RequestMapping("new/{id}")
    public String newDependiente(Model model) {
        model.addAttribute("dependiente", new Dependiente());
        return PREFIX + "dependienteform";
    }

//    @RequestMapping(value = "dependiente/{id}")
    @RequestMapping(value = "dependiente/{id}")
    public String saveDependiente(Dependiente dependiente,Model model,@PathVariable Integer id) {
        
        
         try{
            dependienteService.saveDependiente(dependiente);
            
        Empleadodependiente emcon = new  Empleadodependiente();
        emcon.setDependiente(dependiente);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadodependientePK emconpk = new EmpleadodependientePK();
        emconpk.setCodigodependiente(dependiente.getCodigodependiente());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadodependientePK(emconpk);
        empleadoDependienteService.saveEmpleadodependiente(emcon);
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
//        return "redirect:./show/" + dependiente.getCodigodependiente();
           return PREFIX + "dependienteform";
    }
    
    @RequestMapping("show/{id}")    
    public String showDependiente(@PathVariable Integer id, Model model) {
        model.addAttribute("dependiente", dependienteService.getDependienteById(id).get());
        return PREFIX +"dependienteshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        
         try{
            dependienteService.deleteDependiente(id);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
//        return "redirect:/dependientes/";
        return PREFIX + "dependientes";
    }
    
    
    
}
