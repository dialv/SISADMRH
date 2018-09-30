package mj.gob.sisadmrh.controller.formacionacademica;

import mj.gob.sisadmrh.controller.formacionacademica.*;
import mj.gob.sisadmrh.controller.formacionacademica.*;
import mj.gob.sisadmrh.controller.formacionacademica.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.springframework.web.multipart.MultipartFile;

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
    
    private final String PREFIX = "fragments/formacionacademica/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("formacionacademicas", formacionacademicaService.listAllFormacionacademica());
        return PREFIX + "formacionacademicas";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("formacionacademica", formacionacademicaService.getFormacionacademicaById(id));
        return PREFIX + "formacionacademicaform";
    }

    @RequestMapping("new/{id}")
    public String newFormacionacademica(Model model) {
        model.addAttribute("formacionacademica", new Formacionacademica());
        return PREFIX + "formacionacademicaform";
    }

    @RequestMapping(value = "descarga/{id}")
    public void verDocumento(HttpServletResponse response, @PathVariable(value = "id") Integer id) 
           throws IOException{ 
           streamReport(response, formacionacademicaService.getFormacionacademicaById(id).get().getDoctitulo(), "Titulo.pdf");
    }
    
    @RequestMapping(value = "formacionacademica")
    public String saveFormacionacademica(Formacionacademica formacionacademica,Model model, @RequestParam("file") MultipartFile file) {
        
        try {
            formacionacademica.setDoctitulo(file.getBytes());
<<<<<<< HEAD
             
        } catch (IOException ex) {
            Logger.getLogger(FormacionacaemicaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         try {
=======
        } catch (IOException ex) {
            Logger.getLogger(FormacionacaemicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
        formacionacademicaService.saveFormacionacademica(formacionacademica);
        model.addAttribute("msg", 0);
         }catch(Exception e){
            model.addAttribute("msg", 1);
        }
        
        return "redirect:./show/" + formacionacademica.getCodigoformacionacademica();
    }
    
    @RequestMapping("show/{id}")    
    public String showFormacionacademica(@PathVariable Integer id, Model model) {
        model.addAttribute("formacionacademica", formacionacademicaService.getFormacionacademicaById(id).get());
        return PREFIX +"formacionacademicashow";
    }

    @RequestMapping("delete/{id}")
<<<<<<< HEAD
    public String delete(@PathVariable Integer id,Model model) {
         try{
            formacionacademicaService.deleteFormacionacademica(id);;
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        
=======
    public String delete(@PathVariable Integer id) {
        formacionacademicaService.deleteFormacionacademica(id);
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
        return "redirect:/formacionacademicas/";
    }
    
    
    
}
