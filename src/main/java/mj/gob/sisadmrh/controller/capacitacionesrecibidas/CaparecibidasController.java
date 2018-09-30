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
    
    private final String PREFIX = "fragments/caparecibidas/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("caparecibidas", caparecibidasService.listAllCaparecibidas());
        return PREFIX + "caparecibidas";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("caparecibida", caparecibidasService.getCaparecibidasById(id));
        return PREFIX + "caprecibidasform";
    }

    @RequestMapping("new/{id}")
    public String newCaparecibidas(Model model) {
        model.addAttribute("caparecibida", new Caparecibidas());
        return PREFIX + "caprecibidasform";
    }

    @RequestMapping(value = "caparecibida")
    public String saveCaparecibidas(Caparecibidas caparecibidas,Model model) {
        try{
            caparecibidasService.saveCaparecibidas(caparecibidas);
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
<<<<<<< HEAD
//        return PREFIX+"caprecibidasform";
        
=======
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
        return "redirect:./show/" + caparecibidas.getCodigocaparecibidas();
    }
    
    @RequestMapping("show/{id}")    
    public String showCaparecibidas(@PathVariable Integer id, Model model) {
        model.addAttribute("caparecibida", caparecibidasService.getCaparecibidasById(id).get());
        return PREFIX +"caprecibidashow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
         try{
            caparecibidasService.deleteCaparecibidas(id);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        return "redirect:/caparecibidas/";
    }
    
    
    
}
