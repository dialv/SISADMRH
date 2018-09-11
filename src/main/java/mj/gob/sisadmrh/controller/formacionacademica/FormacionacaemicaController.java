package mj.gob.sisadmrh.controller.formacionacademica;

import mj.gob.sisadmrh.controller.formacionacademica.*;
import mj.gob.sisadmrh.controller.formacionacademica.*;
import mj.gob.sisadmrh.controller.formacionacademica.*;
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
import mj.gob.sisadmrh.model.Formacionacademica;
import mj.gob.sisadmrh.model.Formacionacademica;
import mj.gob.sisadmrh.service.FormacionacademicaService;
import mj.gob.sisadmrh.service.FormacionacademicaService;
//import mj.gob.sisadmrh.service.FormacionacademicaFormacionacademicaService;
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
@RequestMapping(value = "formacionacademicas")
public class FormacionacaemicaController extends UtilsController{
    
    private FormacionacademicaService formacionacademicaService;
//    private FormacionacademicaFormacionacademicaService formacionacademicaFormacionacademicaService;
    


    
    @Autowired
    public void setFormacionacademicaService(FormacionacademicaService formacionacademicaService) {
        this.formacionacademicaService = formacionacademicaService;
    }
    
    private final String PREFIX = "fragments/empleado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("formacionacademicas", formacionacademicaService.listAllFormacionacademica());
        return PREFIX + "formacionacademicas";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("formacionacademica", formacionacademicaService.getFormacionacademicaById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/formacionacademica")
    public String newFormacionacademica(Model model) {
        model.addAttribute("formacionacademica", new Formacionacademica());
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "formacionacademica")
    public String saveFormacionacademica(Formacionacademica formacionacademica) {
        formacionacademicaService.saveFormacionacademica(formacionacademica);
        return "redirect:./show/" + formacionacademica.getCodigoformacionacademica();
    }
    
    @RequestMapping("show/{id}")    
    public String showFormacionacademica(@PathVariable Integer id, Model model) {
        model.addAttribute("formacionacademica", formacionacademicaService.getFormacionacademicaById(id).get());
        return PREFIX +"empleadoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        formacionacademicaService.deleteFormacionacademica(id);
        return "redirect:/empleado/";
    }
    
    
    
}