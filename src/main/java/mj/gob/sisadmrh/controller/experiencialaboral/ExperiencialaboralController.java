package mj.gob.sisadmrh.controller.experiencialaboral;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadoexperiencialaboral;
import mj.gob.sisadmrh.model.EmpleadoexperiencialaboralPK;
import mj.gob.sisadmrh.model.Experiencialaboral;
import mj.gob.sisadmrh.service.ContratoService;
import mj.gob.sisadmrh.service.EmpleadoExperiencialaboralService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.ExperiencialaboralService;
import mj.gob.sisadmrh.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus ;
/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "experiencialaborales")
public class ExperiencialaboralController extends UtilsController{
    
    private ExperiencialaboralService experiencialaboralService;
//    private ExperiencialaboralExperiencialaboralService experiencialaboralExperiencialaboralService;
    @Autowired
    private EmpleadoExperiencialaboralService empleadoExperiencialaboralService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private PuestoService puestoService;
    @Autowired
    private ContratoService contratoService;
     @Autowired
    private ContratoService contratoRep;

    
    @Autowired
    public void setExperiencialaboralService(ExperiencialaboralService experiencialaboralService) {
        this.experiencialaboralService = experiencialaboralService;
    }
    
    private final String PREFIX = "fragments/experiencialaboral/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("experiencialaborales", experiencialaboralService.listAllActivos());
        return PREFIX + "experiencialaborales";
    }
    
     @RequestMapping("edit/{id}/{idemp}")
    public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
          Iterable<Contrato> contrato = contratoRep.findByDato(idemp);
             model.addAttribute("contratos", contrato);
                 model.addAttribute("experiencialaboral", experiencialaboralService.getExperiencialaboralById(id));
        return PREFIX + "experienciaform";
    }
    
    @RequestMapping("edit/experiencialaboral/{id}")
    public String editcontacto(Experiencialaboral experiencialaboral,@PathVariable Integer id, Model model,SessionStatus status) {
        experiencialaboral.setEstadoexp(1);
        experiencialaboralService.saveExperiencialaboral(experiencialaboral);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico una Experiencia laboral",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
//        return "redirect:/empleados/show/"+id;
model.addAttribute("msg", 2);
         model.addAttribute("empleado",id);
          return PREFIX +"experiencias";
    }

    @RequestMapping("new/{id}")
    public String newExperiencialaboral(Model model,@PathVariable Integer id) {
        try {
             model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
             Iterable<Contrato> contrato = contratoRep.findByDato(id);
             model.addAttribute("contratos", contrato);
             
             
//            Integer idp=empleadoService.getEmpleadoById(id).get().getCodigopuesto();
//            model.addAttribute("puesto", puestoService.getPuestoByIdEmpleado(idp).get().getNombrepuesto());
//            model.addAttribute("salario", puestoService.getPuestoByIdEmpleado(idp).get().getSueldobase());
            model.addAttribute("experiencialaboral", new Experiencialaboral());
            
        } catch (Exception ex) {
             System.out.println("Error new experiencia");
              System.out.println("Error on new experiencia Instance{");
                StackTraceElement[] elementRaster=ex.getStackTrace();
                for (int i=0;i<elementRaster.length;i++){
                    StackTraceElement elementSTD=elementRaster[i];
                    System.out.print("   "+ i +"- getClassName= "+elementSTD.getClassName());
                    System.out.print("   getMethodName="+elementSTD.getMethodName());
                    System.out.print("   getLineNumber="+elementSTD.getLineNumber());
                    System.out.println("   errorMSG="+ex.getMessage());
                }
                System.out.println("}");
        }
       
        return PREFIX + "experienciaform";
    }

    @RequestMapping(value = "experiencialaboral/{id}")
    public String saveExperiencialaboral(Experiencialaboral experiencialaboral,Model model,@PathVariable Integer id,SessionStatus status) {
         try{
             experiencialaboral.setEstadoexp(1);
             experiencialaboralService.saveExperiencialaboral(experiencialaboral);
             status.setComplete();
            Empleadoexperiencialaboral emcon = new  Empleadoexperiencialaboral();
//            emcon.setExperiencialaboral(experiencialaboral);
            Empleado em = empleadoService.getEmpleadoById(id).get();
            EmpleadoexperiencialaboralPK emconpk = new EmpleadoexperiencialaboralPK();
            emconpk.setCodigoexperiencialaboral(experiencialaboral.getCodigoexperiencialaboral());
            emconpk.setCodigoempleado(em.getCodigoempleado());
            emcon.setEmpleadoexperiencialaboralPK(emconpk);
            empleadoExperiencialaboralService.saveEmpleadoexperiencialaboral(emcon);
            status.setComplete();
           bitacoraService.BitacoraRegistry("se Creo una experiencia laboral ",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 0);
            model.addAttribute("empleado",id);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
       
//        return "redirect:./show/" + experiencialaboral.getCodigoexperiencialaboral();
//  return "redirect:/empleados/show/"+id;
   return PREFIX +"experiencias";
    }
    
    @RequestMapping("show/{id}/{idemp}")      
    public String showExperiencialaboral(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("experiencialaboral", experiencialaboralService.getExperiencialaboralById(id).get());
        return PREFIX +"experienciashow";
    }

    @RequestMapping("delete/{id}/{idemp}")
    public String delete(@PathVariable Integer id,@PathVariable Integer idemp,Model model) {
         try{
             Experiencialaboral experiencialaboral = experiencialaboralService.getExperiencialaboralById(id).get();
             experiencialaboral.setEstadoexp(0);
            experiencialaboralService.saveExperiencialaboral(experiencialaboral);
            Integer cod=empleadoService.getEmpleadoById(idemp).get().getCodigoempleado();
            bitacoraService.BitacoraRegistry("se Elimino una Experiencia laboral",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
          model.addAttribute("empleado",cod);
            model.addAttribute("msg", 3);
        model.addAttribute("experiencialaboral", experiencialaboral);
         }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
       
//        return "redirect:/experiencialaborales/";
        return PREFIX +"experiencias";
    }

    
     @RequestMapping("ex/searcontrato/{act}/{idemp}")
    public @ResponseBody
        Object[] llenacombo(@PathVariable(value = "act") Integer act, @PathVariable(value = "idemp") Integer idem, Model model) {
        System.out.println("idempleado"+idem);
            Integer idp=act;
        System.out.println("idpuesto"+idp);
            return contratoRep.getContratoByIdEmpleado(idp,idem).get(0);
    }
}
