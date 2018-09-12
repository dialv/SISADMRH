package mj.gob.sisadmrh.controller.contacto;

import mj.gob.sisadmrh.controller.contacto.*;
import mj.gob.sisadmrh.controller.contacto.*;
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
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.service.ContactoService;
import mj.gob.sisadmrh.service.ContactoService;
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
//    private ContactoContactoService contactoContactoService;
    


    
    @Autowired
    public void setContactoService(ContactoService contactoService) {
        this.contactoService = contactoService;
    }
    
    private final String PREFIX = "fragments/empleado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("contactos", contactoService.listAllContacto());
        return PREFIX + "contactos";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contacto", contactoService.getContactoById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/contacto")
    public String newContacto(Model model) {
        model.addAttribute("contacto", new Contacto());
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "contacto")
    public String saveContacto(Contacto contacto) {
        contactoService.saveContacto(contacto);
        return "redirect:./show/" + contacto.getCodigocontacto();
    }
    
    @RequestMapping("show/{id}")    
    public String showContacto(@PathVariable Integer id, Model model) {
        model.addAttribute("contacto", contactoService.getContactoById(id).get());
        return PREFIX +"empleadoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        contactoService.deleteContacto(id);
        return "redirect:/empleado/";
    }
    
    
    
}
