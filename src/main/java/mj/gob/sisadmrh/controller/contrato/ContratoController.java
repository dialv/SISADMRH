package mj.gob.sisadmrh.controller.contrato;

import mj.gob.sisadmrh.controller.contrato.*;
import mj.gob.sisadmrh.controller.contrato.*;
import mj.gob.sisadmrh.controller.contrato.*;
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
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadocontrato;
import mj.gob.sisadmrh.model.EmpleadocontratoPK;
import mj.gob.sisadmrh.model.Puesto;
import mj.gob.sisadmrh.service.ContratoService;
import mj.gob.sisadmrh.service.ContratoService;
import mj.gob.sisadmrh.service.EmpleadoContratoService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.PuestoService;
//import mj.gob.sisadmrh.service.ContratoContratoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

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
  private PuestoService puestoService;
 @Autowired
    private EmpleadoContratoService empleadoContratoService;
    
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
          model.addAttribute("puestos", puestoService.listAllActivos());
         model.addAttribute("contrato", contratoService.getContratoById(id));
        return PREFIX + "contratoform";
    }
    
     @RequestMapping("edit/contrato/{id}")
    public String editcontacto(Contrato contrato,@PathVariable Integer id, @RequestParam("file") MultipartFile file,Model model,SessionStatus status) {
        contrato.setEstadocontrato(1);
           try {
          contrato.setAcuerdonombramiento(file.getBytes());
           }  catch (Exception ex) {
                  
                     System.out.println("Multipart Edit{");
                     StackTraceElement[] elementRaster3 = ex.getStackTrace();
                     for (int in3=0;in3<elementRaster3.length;in3++) {
                         final StackTraceElement elementSTD=elementRaster3[in3];
                         System.out.println("   "+ in3 +" - getClassName="+elementSTD.getClassName());
                         System.out.println("   getMethodName="+elementSTD.getMethodName());
                         System.out.println("   getLineNumber="+elementSTD.getLineNumber());
                         System.out.println("   errorMSG="+ex.getMessage());
                     }
                     System.out.println("}");
              }
        contratoService.saveContrato(contrato);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico un contrato",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
//        return "redirect:/empleados/show/"+id;
model.addAttribute("msg", 2);
         model.addAttribute("empleado",id);
          return PREFIX +"contratos";
    }

    @RequestMapping("new/{id}")
    public String newContrato(Model model,@PathVariable Integer id) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        model.addAttribute("contrato", new Contrato());
        model.addAttribute("puestos", puestoService.listAllActivos());
        Integer idp=empleadoService.getEmpleadoById(id).get().getCodigopuesto();
        model.addAttribute("idpuesto", idp);
        model.addAttribute("salario", puestoService.getPuestoByIdEmpleado(idp).get().getSueldobase());
        model.addAttribute("sispago", puestoService.getPuestoByIdEmpleado(idp).get().getFormapago());
        model.addAttribute("linea", puestoService.getPuestoByIdEmpleado(idp).get().getSublinea());
        model.addAttribute("fechainicio", empleadoService.getEmpleadoById(id).get().getFechaingresoministerio());
        
        return PREFIX + "contratoform";
    }

    @RequestMapping(value = "contrato/{id}")
    public String saveContrato(Contrato contrato, @RequestParam("file") MultipartFile file,Model model,@PathVariable Integer id,SessionStatus status) {
        
        
        try {
            contrato.setAcuerdonombramiento(file.getBytes());
            contrato.setEstadocontrato(1);
             
        }  catch (Exception ex) {
                  
                     System.out.println("Multipart {");
                     StackTraceElement[] elementRaster3 = ex.getStackTrace();
                     for (int in3=0;in3<elementRaster3.length;in3++) {
                         final StackTraceElement elementSTD=elementRaster3[in3];
                         System.out.println("   "+ in3 +" - getClassName="+elementSTD.getClassName());
                         System.out.println("   getMethodName="+elementSTD.getMethodName());
                         System.out.println("   getLineNumber="+elementSTD.getLineNumber());
                         System.out.println("   errorMSG="+ex.getMessage());
                     }
                     System.out.println("}");
              }
        try{
        contrato.setEstadocontrato(1);
        contrato.setCodigopuesto(0);
        contrato = contratoService.saveContrato(contrato);
        status.setComplete();
        Empleadocontrato emcon = new  Empleadocontrato();
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadocontratoPK emconpk = new EmpleadocontratoPK();
        emconpk.setCodigocontrato(contrato.getCodigocontrato());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadocontratoPK(emconpk);
        empleadoContratoService.saveEmpleadocontrato(emcon);
        bitacoraService.BitacoraRegistry("se Creo un contrato",getRequest().getRemoteAddr(),getRequest().getUserPrincipal().getName());
        
        model.addAttribute("msg", 0);
            model.addAttribute("empleado",id);
        }
         catch (Exception ex) {
                  
                     System.out.println("Error {");
                     StackTraceElement[] elementRaster3 = ex.getStackTrace();
                     for (int in3=0;in3<elementRaster3.length;in3++) {
                         final StackTraceElement elementSTD=elementRaster3[in3];
                         System.out.println("   "+ in3 +" - getClassName="+elementSTD.getClassName());
                         System.out.println("   getMethodName="+elementSTD.getMethodName());
                         System.out.println("   getLineNumber="+elementSTD.getLineNumber());
                         System.out.println("   errorMSG="+ex.getMessage());
                     }
                     System.out.println("}");
                  model.addAttribute("msg", 1);
              }
        try{
            contratoService.findIntegry(contrato);
        }catch(Exception e){} 
        return PREFIX +"contratos";
//        return "redirect:./show/" + contrato.getCodigocontrato();
// return "redirect:/empleados/show/"+id;
    }
    
      @RequestMapping(value = "descarga/{id}")
    public void verDocumento(HttpServletResponse response, @PathVariable(value = "id") Integer id) 
           throws IOException{ 
           streamReport(response, contratoService.getContratoById(id).get().getAcuerdonombramiento(), "AcuerdoNombramiento.pdf");
    }
    
    @RequestMapping("show/{id}/{idemp}")    
    public String showContrato(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("contrato", contratoService.getContratoById(id).get());
        return PREFIX +"contratoshow";
    }

    @RequestMapping("delete/{id}/{idemp}")
    public String delete(@PathVariable Integer id,@PathVariable Integer idemp,Model model) {
         try{
             Contrato contrato = contratoService.getContratoById(id).get();
             contrato.setEstadocontrato(0);
            contratoService.saveContrato(contrato);
            Integer cod=empleadoService.getEmpleadoById(idemp).get().getCodigoempleado();
            bitacoraService.BitacoraRegistry("se Elimino un Contrato",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
          model.addAttribute("empleado",cod);
//            model.addAttribute("contrato",contrato);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        
//        return "redirect:/contratos/";
// return "redirect:/empleados/";
        return PREFIX +"contratos";
    }
    
//                  @RequestMapping(value = "contrato1")
//    public String saveRol(Contrato contrato, Model model, SessionStatus status) {
//        try{
//        contratoService.saveContrato(contrato);
//        status.setComplete();
//         bitacoraService.BitacoraRegistry("se cambio un contrato ",getRequest().getRemoteAddr(), 
//                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
//        model.addAttribute("msg", 0);
//        }
//        catch(Exception e){
//        model.addAttribute("msg", 1);
//        }
//        return "redirect:/empleados/";
//    }
    
//    @RequestMapping(value = "contrato/searchpuesto/{act}/{idemp}")
//    public String acteco(@PathVariable(value = "act") Integer act, Model model, @PathVariable(value = "idemp") Integer idem) throws Exception {
//        
//        model.addAttribute("empleado", empleadoService.getEmpleadoById(idem).get());
//        model.addAttribute("contrato", new Contrato());
//        model.addAttribute("puestos", puestoService.listAllActivos());
//        Integer idp=empleadoService.getEmpleadoById(idem).get().getCodigopuesto();
//        model.addAttribute("idpuesto1", idp);
//        model.addAttribute("salario1", puestoService.getPuestoByIdEmpleado(idp).get().getSueldobase());
//        model.addAttribute("sispago1", puestoService.getPuestoByIdEmpleado(idp).get().getFormapago());
//        model.addAttribute("linea1", puestoService.getPuestoByIdEmpleado(idp).get().getSublinea());
//        model.addAttribute("fechainicio1", empleadoService.getEmpleadoById(idem).get().getFechaingresoministerio());
//       
//       
//       System.out.println("salario:"+puestoService.getPuestoByIdEmpleado(idp).get().getSueldobase());
//       System.out.println("sispago"+ puestoService.getPuestoByIdEmpleado(idp).get().getFormapago());
//       String location= PREFIX + "contratoform";
////       location=location.replaceAll("contrato", "contratos");
//        System.out.println("location"+location);
//       return location;
//    }
    
    @RequestMapping("contrato/searchpuesto/{act}/{idemp}")
    public @ResponseBody
        Object[] llenacombo(@PathVariable(value = "act") Integer act, @PathVariable(value = "idemp") Integer idem, Model model) {
        System.out.println("idempleado"+idem);
            Integer idp=act;
        System.out.println("idpuesto"+idp);
            return puestoService.getPuestoByIdEmpleado2(idp,idem).get(0);
    }
    
    
    
}
