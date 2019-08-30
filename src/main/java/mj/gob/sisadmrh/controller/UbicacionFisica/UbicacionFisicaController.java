/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.UbicacionFisica;
import java.util.logging.Level;
import java.util.logging.Logger;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadoubicacionfisica;
import mj.gob.sisadmrh.model.EmpleadoubicacionfisicaPK;


import mj.gob.sisadmrh.model.Ubicacionfisica;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.EmpleadoUbicacionfisicaService;


import mj.gob.sisadmrh.service.UbicacionFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author jorge
 */
@Controller
@RequestMapping(value = "ubicacionfisicas")
public class UbicacionFisicaController extends UtilsController{
    
    @Autowired
    private UbicacionFisicaService ubicacionFisicaService;
     @Autowired
    private EmpleadoUbicacionfisicaService empleadoUbicacionfisicaService;
    @Autowired
    private EmpleadoService empleadoService;

  
    private final String PREFIX = "fragments/ubicacionfisica/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("ubicacionfisicas", ubicacionFisicaService.listAllActivos());
        return PREFIX + "ubicacionfisicas";
    }
    
     @RequestMapping("edit/{id}/{idemp}")
    public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("ubicacionfisica", ubicacionFisicaService.getUbicacionFisicaById(id));
        return PREFIX + "ubicacionfisicaform";
    }
    
    @RequestMapping("edit/ubicacionfisica/{id}")
    public String editcontacto(Ubicacionfisica ubicacionFisica,@PathVariable Integer id, Model model,SessionStatus status) {
        ubicacionFisica.setEstadoubicacion(1);
        ubicacionFisicaService.saveUbicacionFisica(ubicacionFisica);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico una Ubicacion Fisica",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
//        return "redirect:/empleados/show/"+id;
model.addAttribute("msg", 2);
         model.addAttribute("empleado",id);
          return PREFIX +"ubicacionfisicas";
    }
    
    @RequestMapping("new/{id}")
    public String newUbicacionFisica(Model model,@PathVariable Integer id) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
         model.addAttribute("ubicacionfisica", new Ubicacionfisica());
        
         
        return PREFIX + "ubicacionfisicaform";
    }
    
    @RequestMapping(value = "ubicacionfisica/{id}")
    public String saveUbicacionFisica(Ubicacionfisica ubicacionFisica,Model model,@PathVariable Integer id,SessionStatus status) {
        try{
            ubicacionFisica.setEstadoubicacion(1);
            ubicacionFisica.setCodigoempleado(id);
           ubicacionFisicaService.saveUbicacionFisica(ubicacionFisica);
           status.setComplete();
           Empleadoubicacionfisica emcon = new  Empleadoubicacionfisica();
//        emcon.setUbicacionfisica(ubicacionFisica);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadoubicacionfisicaPK emconpk = new EmpleadoubicacionfisicaPK();
        emconpk.setCodigoubicacion(ubicacionFisica.getCodigoubicacion());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadoubicacionfisicaPK(emconpk);
        empleadoUbicacionfisicaService.saveEmpleadoubicacionfisica(emcon);
         bitacoraService.BitacoraRegistry("se Creo una Ubiscaion Fisica",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
           model.addAttribute("msg", 0);model.addAttribute("empleado",id);
        }
        catch(Exception e){
           model.addAttribute("msg", 1);
            Logger.getLogger(UbicacionFisicaController.class.getName()).log(Level.SEVERE, null, e);
             System.out.println("Error on Ubicacion fisica Instance{");
                StackTraceElement[] elementRaster=e.getStackTrace();
                for (int i=0;i<elementRaster.length;i++){
                    StackTraceElement elementSTD=elementRaster[i];
                    System.out.print("   "+ i +"- getClassName= "+elementSTD.getClassName());
                    System.out.print("   getMethodName="+elementSTD.getMethodName());
                    System.out.print("   getLineNumber="+elementSTD.getLineNumber());
                    System.out.println("   errorMSG="+e.getMessage());
                }
                System.out.println("}");
        }
//       return "redirect:/empleados/show/"+id;
 return PREFIX +"ubicacionfisicas";
       
        //return "redirect:./show/" + capacitacion.getCodigocapacitacion();
    }
    
     @RequestMapping("show/{id}/{idemp}") 
    public String showUbicacionFisica(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        
        model.addAttribute("ubicacionfisica", ubicacionFisicaService.getUbicacionFisicaById(id).get());
        
        return PREFIX +"ubicacionfisicashow";
    }
     @RequestMapping("delete/{id}/{idemp}")  
    public String delete(@PathVariable Integer id,@PathVariable Integer idemp,Model model) {
        try{
       Ubicacionfisica ubicacionfisica = ubicacionFisicaService.getUbicacionFisicaById(id).get();
       ubicacionfisica.setEstadoubicacion(0);
        ubicacionFisicaService.saveUbicacionFisica(ubicacionfisica);
          Integer cod=empleadoService.getEmpleadoById(idemp).get().getCodigoempleado();
          bitacoraService.BitacoraRegistry("se Elimino una Ubicacion Fisica",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
          model.addAttribute("empleado",cod);
         model.addAttribute("msg", 3);
//          model.addAttribute("ubicacionfisica",ubicacionfisica);
        }
        catch(Exception e)
        {
        model.addAttribute("msg", 4);
        }
//    return "redirect:/empleados/";
//        return "redirect:/ubicacionfisicas/";
        return PREFIX +"ubicacionfisicas";
    }
    

    
}
