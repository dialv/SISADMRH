package mj.gob.sisadmrh.controller.mision;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadomision;
import mj.gob.sisadmrh.model.Mision;
import mj.gob.sisadmrh.service.EmpleadoMisionService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.MisionService;
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
@RequestMapping(value = "misiones")
public class MisionController extends UtilsController {

    private MisionService misionService;
      private EmpleadoService empleadoService;
      private EmpleadoMisionService empleadomisionService;

    @Autowired
    public void setMisionService(MisionService misionService) {
        this.misionService = misionService;
    }
    @Autowired
    public void setEmpleadoService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    
    @Autowired
    public void setEmpleadoMisionService(EmpleadoMisionService empleadomisionService) {
        this.empleadomisionService = empleadomisionService;
    }

    private final String PREFIX = "fragments/mision/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("misiones", misionService.listAllActivos());
        return PREFIX + "misiones";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("mision", misionService.getMisionById(id));
        return PREFIX + "misionform";
    }
    
     @RequestMapping("editlist/{id}")
    public String editlist(@PathVariable Integer id, Model model) {
          model.addAttribute("mision", misionService.getMisionById(id).get());
          model.addAttribute("empleados", empleadoService.listAllActivos());
        return PREFIX + "asignarmisionform1";
    }

    @RequestMapping("new/mision")
    public String newMision(Model model) {
        model.addAttribute("mision", new Mision());
        return PREFIX + "misionform";
    }
    
    
     @RequestMapping("asignar/mision")
    public String asignarMision(Model model) {;
        model.addAttribute("mision", new Mision());
        model.addAttribute("empleado", new Mision());
        model.addAttribute("misiones", misionService.listAllActivos());
        model.addAttribute("empleados", empleadoService.listAllActivos());
        return PREFIX + "asignarmisionform";
    }
    
    
    @RequestMapping("list/mision")
    public String alistMision(Model model) {;
         model.addAttribute("misioneslist", empleadoService.findByMisionesAsignadas());
        return PREFIX + "misionesasignadas";
    }
    
     @RequestMapping(value = "mision/asignar/{id}/{codigo}")
    public String saveEmpleadoMision(Empleado empleado,Model model,@PathVariable Integer id,@PathVariable Integer codigo) {
        try{
         Empleadomision emmis = new  Empleadomision(); 
         emmis.setCodigomision(id);
         emmis.setCodigoempleado(codigo);
         
        empleadomisionService.saveEmpleadomision(emmis);
        model.addAttribute("mision", new Mision());
        model.addAttribute("empleado", new Mision());
        model.addAttribute("misiones", misionService.listAllActivos());
        model.addAttribute("empleados", empleadoService.listAllActivos());
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
          Logger.getLogger(MisionController.class.getName()).log(Level.SEVERE, null, e);
        }
     return PREFIX + "asignarmisionform";
        
       // return "redirect:./show/" + beneficio.getCodigobeneficio();
    }

    @RequestMapping(value = "mision")
    public String saveMision(Mision mision, Model model, @RequestParam("file") MultipartFile file) {
        try {
            mision.setDocacuerdo(file.getBytes());
            mision.setEstadomision(1);
            misionService.saveMision(mision);

            model.addAttribute("msg", 0);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "misionform";
    }

    @RequestMapping("show/{id}")
    public String showMision(@PathVariable Integer id, Model model) {
        model.addAttribute("mision", misionService.getMisionById(id).get());
        return PREFIX + "misionshow";
    }
    
     @RequestMapping("showmisionesemp/{id}")
    public String showMisionEmp(@PathVariable Integer id, Model model) {
//        model.addAttribute("mision", misionService.getMisionById(id).get());
        model.addAttribute("misionemps", empleadoService.findByMisionesEmpleados(id));
        return PREFIX + "misionempshow";
    }
    
     @RequestMapping("showmisionesemp1/{id}")
    public String showMisionEmp1(@PathVariable Integer id, Model model) {
//        model.addAttribute("mision", misionService.getMisionById(id).get());
        model.addAttribute("misionemps", empleadoService.findByMisionesEmpleados(id));
        return PREFIX + "misionempshow1";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            Mision mision = misionService.getMisionById(id).get();
            mision.setEstadomision(0);
            misionService.saveMision(mision);
             bitacoraService.BitacoraRegistry("se elimino una Mision", getRequest().getRemoteAddr(),
            getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);

        }
        return PREFIX + "misiones";
    }

    
    @RequestMapping("deletemisionesemp/{id}")
    public String deletemisionesemp(@PathVariable Integer id, Model model) {
        try {
//            Mision mision = misionService.getMisionById(id).get();
//            mision.setEstadomision(0);
            empleadomisionService.deleteEmpleadomision(id);
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);

        }
         return "redirect:/misiones/list/mision";
    }
    
    @RequestMapping("deletelistado/{id}")
    public String deletelistado(@PathVariable Integer id, Model model) {
        try {

            empleadoService.DeleteListadoMision(id);
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);

        }
         return "redirect:/misiones/list/mision";
    }
}
