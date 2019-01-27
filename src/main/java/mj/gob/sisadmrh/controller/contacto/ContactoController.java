package mj.gob.sisadmrh.controller.contacto;

import java.util.logging.Level;
import java.util.logging.Logger;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadocontacto;
import mj.gob.sisadmrh.model.EmpleadocontactoPK;
import mj.gob.sisadmrh.service.ContactoService;
import mj.gob.sisadmrh.service.EmpleadoContactoService;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "contactos")
public class ContactoController extends UtilsController{
    
    private ContactoService contactoService ;
    @Autowired
    private EmpleadoContactoService empleadoContactoService;
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    public void setContactoService(ContactoService contactoService) {
        this.contactoService = contactoService;
    }
    
    private final String PREFIX = "fragments/contacto/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("contactos", contactoService.listAllActivos());
        return PREFIX + "contactos";
    }
    
    @RequestMapping("edit/{id}/{idemp}")
    public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("contacto", contactoService.getContactoById(id));
        return PREFIX + "contactoform";
    }
    
     @RequestMapping("edit/contacto/{id}")
    public String editcontacto(Contacto contacto,@PathVariable Integer id, Model model,SessionStatus status) {
        contacto.setEstadocontacto("1");
        contactoService.saveContacto(contacto);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico un contacto",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        return "redirect:/empleados/show/"+id;
    }

    @RequestMapping("new/{id}") 
    public String newContacto(Model model,@PathVariable Integer id) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        model.addAttribute("contacto", new Contacto());
        return PREFIX + "contactoform";
    }

    @RequestMapping(value = "contacto/{id}")
    public String saveContacto(Contacto contacto,Model model,@PathVariable Integer id,SessionStatus status) {
       try{
        contacto.setEstadocontacto("1");
        contactoService.saveContacto(contacto);
         status.setComplete();
        Empleadocontacto emcon = new  Empleadocontacto();
        emcon.setContacto(contacto);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadocontactoPK emconpk = new EmpleadocontactoPK();
        emconpk.setCodigocontacto(contacto.getCodigocontacto());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadocontactoPK(emconpk);
        empleadoContactoService.saveEmpleadocontacto(emcon);
        bitacoraService.BitacoraRegistry("se Creo un contacto",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
         }
        catch(Exception e){
         model.addAttribute("msg", 1);
         Logger.getLogger(ContactoController.class.getName()).log(Level.SEVERE, null, e);
        }
        return "redirect:/empleados/show/"+id;
//         return PREFIX + "contactoform";
    }
    
    @RequestMapping("show/{id}/{idemp}")    
    public String showContacto(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
         model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("contacto", contactoService.getContactoById(id).get());
        return PREFIX +"contactoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
       
         try{
             Contacto contacto = contactoService.getContactoById(id).get();
             contacto.setEstadocontacto("0");
             
         contactoService.saveContacto(contacto);
          model.addAttribute("msg", 3);
        }
        catch(Exception e){
         model.addAttribute("msg", 4);
        }
        return PREFIX + "contactos";
    }
    
     @RequestMapping(value = "contacto")
    public String saveRol(Contacto contacto, Model model, SessionStatus status) {
        try{
        contacto.setSexocontacto("masculino");
        contacto.setEstadocontacto("1");
        contactoService.saveContacto(contacto);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se Creo un contacto",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
        return "redirect:/empleados/";
    }
 }
