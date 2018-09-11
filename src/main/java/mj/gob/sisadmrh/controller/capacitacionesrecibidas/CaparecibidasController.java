package mj.gob.sisadmrh.controller.capacitacionesrecibidas;

import mj.gob.sisadmrh.controller.capacitacionesrecibidas.*;
import mj.gob.sisadmrh.controller.capacitacionesrecibidas.*;
import mj.gob.sisadmrh.controller.capacitacionesrecibidas.*;
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
import mj.gob.sisadmrh.model.Caparecibidas;
import mj.gob.sisadmrh.model.Caparecibidas;
import mj.gob.sisadmrh.service.CaparecibidasService;
import mj.gob.sisadmrh.service.CaparecibidasService;
//import mj.gob.sisadmrh.service.CaparecibidasCaparecibidasService;
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
@RequestMapping(value = "caparecibidas")
public class CaparecibidasController extends UtilsController{
    
    private CaparecibidasService caparecibidasService;
//    private CaparecibidasCaparecibidasService caparecibidasCaparecibidasService;
    


    
    @Autowired
    public void setCaparecibidasService(CaparecibidasService caparecibidasService) {
        this.caparecibidasService = caparecibidasService;
    }
    
    private final String PREFIX = "fragments/empleado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("caparecibidas", caparecibidasService.listAllCaparecibidas());
        return PREFIX + "caparecibidass";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("caparecibidas", caparecibidasService.getCaparecibidasById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/caparecibidas")
    public String newCaparecibidas(Model model) {
        model.addAttribute("caparecibidas", new Caparecibidas());
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "caparecibidas")
    public String saveCaparecibidas(Caparecibidas caparecibidas) {
        caparecibidasService.saveCaparecibidas(caparecibidas);
        return "redirect:./show/" + caparecibidas.getCodigocaparecibidas();
    }
    
    @RequestMapping("show/{id}")    
    public String showCaparecibidas(@PathVariable Integer id, Model model) {
        model.addAttribute("caparecibidas", caparecibidasService.getCaparecibidasById(id).get());
        return PREFIX +"empleadoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        caparecibidasService.deleteCaparecibidas(id);
        return "redirect:/empleado/";
    }
    
    
    
}