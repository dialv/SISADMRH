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
import mj.gob.sisadmrh.service.DependienteService;
import mj.gob.sisadmrh.service.DependienteService;
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
    public void setDependienteService(DependienteService dependienteService) {
        this.dependienteService = dependienteService;
    }
    
    private final String PREFIX = "fragments/empleado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("dependientes", dependienteService.listAllDependiente());
        return PREFIX + "dependientes";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("dependiente", dependienteService.getDependienteById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/dependiente")
    public String newDependiente(Model model) {
        model.addAttribute("dependiente", new Dependiente());
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "dependiente")
    public String saveDependiente(Dependiente dependiente) {
        dependienteService.saveDependiente(dependiente);
        return "redirect:./show/" + dependiente.getCodigodependiente();
    }
    
    @RequestMapping("show/{id}")    
    public String showDependiente(@PathVariable Integer id, Model model) {
        model.addAttribute("dependiente", dependienteService.getDependienteById(id).get());
        return PREFIX +"empleadoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        dependienteService.deleteDependiente(id);
        return "redirect:/empleado/";
    }
    
    
    
}
