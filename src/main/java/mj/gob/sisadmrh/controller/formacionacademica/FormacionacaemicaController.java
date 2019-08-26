package mj.gob.sisadmrh.controller.formacionacademica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadoformacion;
import mj.gob.sisadmrh.model.EmpleadoformacionPK;
import mj.gob.sisadmrh.model.Formacionacademica;
import mj.gob.sisadmrh.service.EmpleadoFormacionacademicaService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.FormacionacademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
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
     @Autowired
    private EmpleadoFormacionacademicaService empleadoFormacionaademicaService;
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    public void setFormacionacademicaService(FormacionacademicaService formacionacademicaService) {
        this.formacionacademicaService = formacionacademicaService;
    }
    
    private final String PREFIX = "fragments/formacionacademica/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("formacionacademicas", formacionacademicaService.listAllActivos());
        return PREFIX + "formacionacademicas";
    }
    
     @RequestMapping("edit/{id}/{idemp}")
    public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("formacionacademica", formacionacademicaService.getFormacionacademicaById(id));
        return PREFIX + "formacionacademicaform";
    }
    
    @RequestMapping("edit/formacionacademica/{id}")
    public String editformacion(Formacionacademica formacionacademica,@RequestParam("file") MultipartFile file,@PathVariable Integer id, Model model,SessionStatus status) {
        
          try {
            formacionacademica.setDoctitulo(file.getBytes());
            formacionacademica.setEstadoformacion(1);
             
        } catch (IOException ex) {
            Logger.getLogger(FormacionacaemicaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        formacionacademicaService.saveFormacionacademica(formacionacademica);
        status.setComplete();
        bitacoraService.BitacoraRegistry("se Modifico una formacion academica",getRequest().getRemoteAddr(), 
        getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 2);
        model.addAttribute("empleado",id);
        return PREFIX +"formacionacademicas";
    }

    @RequestMapping("new/{id}")
    public String newFormacionacademica(Model model,@PathVariable Integer id) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        model.addAttribute("formacionacademica", new Formacionacademica());
        return PREFIX + "formacionacademicaform";
    }

    @RequestMapping(value = "descarga/{id}")
    public void verDocumento(HttpServletResponse response, @PathVariable(value = "id") Integer id) 
        throws IOException{ 
        streamReport(response, formacionacademicaService.getFormacionacademicaById(id).get().getDoctitulo(), "Titulo.pdf");
    }
    
    @RequestMapping(value = "formacionacademica/{id}")
    public String saveFormacionacademica(Formacionacademica formacionacademica,Model model, @RequestParam("file") MultipartFile file,@PathVariable Integer id,SessionStatus status) {
        
        try {
            formacionacademica.setDoctitulo(file.getBytes());
            formacionacademica.setEstadoformacion(1);
             
        } catch (IOException ex) {
            Logger.getLogger(FormacionacaemicaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         try {
        
        formacionacademica=formacionacademicaService.saveFormacionacademica(formacionacademica);
        Empleadoformacion emcon = new  Empleadoformacion();
        emcon.setFormacionacademica(formacionacademica);
        status.setComplete();
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadoformacionPK emconpk = new EmpleadoformacionPK();
        emconpk.setCodigoformacionacademica(formacionacademica.getCodigoformacionacademica());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadoformacionPK(emconpk);
        empleadoFormacionaademicaService.saveEmpleadoformacionacademica(emcon);
        formacionacademicaService.findIntegrity(formacionacademica);
        model.addAttribute("msg", 0);
        model.addAttribute("empleado",id);
        }catch(Exception e){
        model.addAttribute("msg", 1);
        }
         
        return PREFIX +"formacionacademicas";
    }
    
    @RequestMapping("show/{id}/{idemp}")    
    public String showFormacionacademica(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("formacionacademica", formacionacademicaService.getFormacionacademicaById(id).get());
        return PREFIX +"formacionacademicashow";
    }

    @RequestMapping("delete/{id}/{idemp}")
    public String delete(@PathVariable Integer id,@PathVariable Integer idemp,Model model) {
         try{
            Formacionacademica formacionacademica = formacionacademicaService.getFormacionacademicaById(id).get();
            formacionacademica.setEstadoformacion(0);
            formacionacademicaService.saveFormacionacademica(formacionacademica);
              Integer cod=empleadoService.getEmpleadoById(idemp).get().getCodigoempleado();
          model.addAttribute("empleado",cod);
            model.addAttribute("msg", 3);
            model.addAttribute("formacionacademica", formacionacademica);
         }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        return PREFIX +"formacionacademicas";
    }
    
    
    
  @RequestMapping(value = "formacionacademica")
    public String saveRol(Formacionacademica formacionacademica, Model model, SessionStatus status, @RequestParam("file") MultipartFile file) {
        try{
            formacionacademica.setDoctitulo(file.getBytes());
            formacionacademica.setEstadoformacion(1);
            
        formacionacademicaService.saveFormacionacademica(formacionacademica);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se Creo una formacionacademica",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
          return "redirect:/empleados/";
    }    
}
