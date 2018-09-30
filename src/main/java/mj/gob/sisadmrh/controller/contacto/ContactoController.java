package mj.gob.sisadmrh.controller.contacto;

import mj.gob.sisadmrh.controller.contacto.*;
import mj.gob.sisadmrh.controller.contacto.*;
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
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadocontacto;
import mj.gob.sisadmrh.model.EmpleadocontactoPK;
import mj.gob.sisadmrh.service.ContactoService;
import mj.gob.sisadmrh.service.ContactoService;
import mj.gob.sisadmrh.service.EmpleadoContactoService;
import mj.gob.sisadmrh.service.EmpleadoService;
//import mj.gob.sisadmrh.service.EmpleadoContactoService;
//import mj.gob.sisadmrh.service.ContactoContactoService;
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
@RequestMapping(value = "contactos")
public class ContactoController extends UtilsController{
    
    private ContactoService contactoService;
    @Autowired
    private EmpleadoContactoService empleadoContactoService;
    @Autowired
    private EmpleadoService empleadoService;
//    private ContactoContactoService contactoContactoService;
    
//     private EmpleadoContactoService  empleadocontacto ;
//    @Autowired
//    public void setEmpleadoContactoService(EmpleadoContactoService empleadocontacto){
//    this.empleadocontacto=empleadocontacto;
//    }
    


    
    @Autowired
    public void setContactoService(ContactoService contactoService) {
        this.contactoService = contactoService;
    }
    
    private final String PREFIX = "fragments/contacto/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("contactos", contactoService.listAllContacto());
        return PREFIX + "contactos";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contacto", contactoService.getContactoById(id));
        return PREFIX + "contactoform";
    }

    @RequestMapping("new/{id}") 
    public String newContacto(Model model,@PathVariable Integer id) {
//        EmpleadocontactoPK empCto = new EmpleadocontactoPK();
//        empCto.setCodigoempleado(id);
//        model.addAttribute("empleadoContacto", empCto );
        model.addAttribute("contacto", new Contacto());
        return PREFIX + "contactoform";
    }

    @RequestMapping(value = "contacto/{id}")
    public String saveContacto(Contacto contacto,Model model,@PathVariable Integer id) {
       try{
          
        
        contactoService.saveContacto(contacto);
        Empleadocontacto emcon = new  Empleadocontacto();
        emcon.setContacto(contacto);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadocontactoPK emconpk = new EmpleadocontactoPK();
        emconpk.setCodigocontacto(contacto.getCodigocontacto());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadocontactoPK(emconpk);
        empleadoContactoService.saveEmpleadocontacto(emcon);
        model.addAttribute("msg", 0);
         }
        catch(Exception e){
         model.addAttribute("msg", 1);
         Logger.getLogger(ContactoController.class.getName()).log(Level.SEVERE, null, e);
        }
//        emp.setCodigocontacto(contacto.getCodigocontacto()); 
//        emp.setCodigoempleado(contacto.getCodigocontacto());
//        empleadocontactoPK.saveEmpleadoContacto(emp);
        return "redirect:./show/" + contacto.getCodigocontacto();
    }
    
    @RequestMapping("show/{id}")    
    public String showContacto(@PathVariable Integer id, Model model) {
        model.addAttribute("contacto", contactoService.getContactoById(id).get());
        return PREFIX +"contactoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
       
         try{
         contactoService.deleteContacto(id);
          model.addAttribute("msg", 3);
        }
        catch(Exception e){
         model.addAttribute("msg", 4);
        }
        return "redirect:/contactos/";
    }
    
 
//    @RequestMapping("empleado/contacto/{id}")
//        public String findContactoByEmpladoId(@PathVariable Integer id, Model model) {
//        model.addAttribute("costocapacitacion", contactoService.findByDato(id));
//        return "redirect:/contacto/";
//    }
}
