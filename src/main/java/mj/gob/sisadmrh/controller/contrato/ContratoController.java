package mj.gob.sisadmrh.controller.contrato;

import mj.gob.sisadmrh.controller.contrato.*;
import mj.gob.sisadmrh.controller.contrato.*;
import mj.gob.sisadmrh.controller.contrato.*;
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
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.service.ContratoService;
import mj.gob.sisadmrh.service.ContratoService;
import mj.gob.sisadmrh.service.EmpleadoService;
//import mj.gob.sisadmrh.service.ContratoContratoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "contratos")
public class ContratoController extends UtilsController{
    
    private ContratoService contratoService;
//    private ContratoContratoService contratoContratoService;
    
 @Autowired
    private EmpleadoService empleadoService;

    
    @Autowired
    public void setContratoService(ContratoService contratoService) {
        this.contratoService = contratoService;
    }
    
    private final String PREFIX = "fragments/contrato/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("contratos", contratoService.listAllActivos());
        return PREFIX + "contratos";
    }
    
    @RequestMapping("edit/{id}/{idemp}")
    public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
         model.addAttribute("contrato", contratoService.getContratoById(id));
        return PREFIX + "contratoform";
    }
    
     @RequestMapping("edit/contrato/{id}")
    public String editcontacto(Contrato contrato,@PathVariable Integer id, Model model,SessionStatus status) {
        contrato.setEstadocontrato(1);
        contratoService.saveContrato(contrato);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico un contrato",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        return "redirect:/empleados/show/"+id;
    }

    @RequestMapping("new/{id}")
    public String newContrato(Model model,@PathVariable Integer id) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        model.addAttribute("contrato", new Contrato());
        return PREFIX + "contratoform";
    }

    @RequestMapping(value = "contrato/{id}")
    public String saveContrato(Contrato contrato,Model model,@PathVariable Integer id,SessionStatus status) {
        try{
            contrato.setEstadocontrato(1);
            contratoService.saveContrato(contrato);
             status.setComplete();
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
        
//        return "redirect:./show/" + contrato.getCodigocontrato();
 return "redirect:/empleados/show/"+id;
    }
    
    @RequestMapping("show/{id}/{idemp}")    
    public String showContrato(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("contrato", contratoService.getContratoById(id).get());
        return PREFIX +"contratoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
         try{
             Contrato contrato = contratoService.getContratoById(id).get();
             contrato.setEstadocontrato(0);
            contratoService.deleteContrato(id);
            model.addAttribute("contrato",contrato);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        
//        return "redirect:/contratos/";
        return PREFIX +"contratoshow";
    }
    
                  @RequestMapping(value = "contrato1")
    public String saveRol(Contrato contrato, Model model, SessionStatus status) {
        try{
        contratoService.saveContrato(contrato);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se cambio un contrato ",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
        return "redirect:/empleados/";
    }
    
}
