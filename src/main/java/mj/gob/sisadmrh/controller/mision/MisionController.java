package mj.gob.sisadmrh.controller.mision;

import mj.gob.sisadmrh.controller.mision.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Mision;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "misiones")
public class MisionController extends UtilsController{
    
    @Autowired
    private EmpleadoService empleadoService;
//    @Autowired
    
    private MisionService misionService;
    


    
    @Autowired
    public void setMisionService(MisionService misionService) {
        this.misionService = misionService;
    }
    
    private final String PREFIX = "fragments/mision/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("misiones", misionService.listAllMisiones());
        return PREFIX + "misiones";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("mision", misionService.getMisionById(id));
        return PREFIX + "misionform";
    }

    @RequestMapping("new/mision")
    public String newMision(Model model) {
        model.addAttribute("mision", new Mision());
        Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
        model.addAttribute("empleados", empleados);
        return PREFIX + "misionform";
    }


//  @RequestMapping(value = "/descarga/{id}")
//    public void verDocumento(HttpServletResponse response, @PathVariable(value = "id") Integer id) 
//           throws IOException{ 
//           streamReport(response, misionService.getMisionById(id).get().getDocacuerdo(), "acuerdo.pdf");
//    }
    
    @RequestMapping(value = "mision" )
    public String saveMision(Mision mision,Model model, @RequestParam("file") MultipartFile file) {
//    public String saveMision(Mision mision,Model model) {    
          try {
           mision.setDocacuerdo(file.getBytes());
             
        } catch (IOException ex) {
            Logger.getLogger(MisionController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        try{
        
        misionService.saveMision(mision);
        
        model.addAttribute("msg", 0);
//        model.addAttribute("misiones", misionService.listAllMisiones());
        
//        return PREFIX+"misiones";
        }
        catch(Exception e){
          model.addAttribute("msg", 1);
        }
//         return PREFIX+"misionform";
       return "redirect:./show/" + mision.getCodigomision();
    }
    
    @RequestMapping("show/{id}")
    public String showMision(@PathVariable Integer id, Model model) {
        model.addAttribute("mision", misionService.getMisionById(id).get());
        return PREFIX +"misionshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
        misionService.deleteMision(id);
         model.addAttribute("msg", 3);
        }
        catch(Exception e){
        model.addAttribute("msg", 4);
         
        }
//         return PREFIX + "misiones";
        return "redirect:/misiones/";
    }
    
    

    
}
