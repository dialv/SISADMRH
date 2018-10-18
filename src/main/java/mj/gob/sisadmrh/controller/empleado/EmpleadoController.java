package mj.gob.sisadmrh.controller.empleado;

import mj.gob.sisadmrh.controller.empleado.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Caparecibidas;
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Experiencialaboral;
import mj.gob.sisadmrh.model.Formacionacademica;
import mj.gob.sisadmrh.model.Hijodiscapacidad;
import mj.gob.sisadmrh.model.Idioma;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.model.Puesto;
import mj.gob.sisadmrh.model.Ubicacionfisica;
import mj.gob.sisadmrh.service.BeneficioService;
import mj.gob.sisadmrh.service.CaparecibidasService;
import mj.gob.sisadmrh.service.ContactoService;
import mj.gob.sisadmrh.service.ContratoService;
import mj.gob.sisadmrh.service.DependienteService;
import mj.gob.sisadmrh.service.ExperiencialaboralService;
import mj.gob.sisadmrh.service.FormacionacademicaService;
import mj.gob.sisadmrh.service.HijosdiscapacidadService;
import mj.gob.sisadmrh.service.IdiomaService;
import mj.gob.sisadmrh.service.PuestoService;
import mj.gob.sisadmrh.service.UbicacionFisicaService;
//import mj.gob.sisadmrh.service.EmpleadoEmpleadoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "empleados")
public class EmpleadoController extends UtilsController{
    
    private EmpleadoService empleadoService;
//    private EmpleadoEmpleadoService empleadoEmpleadoService;
    


    private PuestoService puestoService ;
    @Autowired
    public void SetPuestoService(PuestoService puestoService){
    this.puestoService=puestoService;
    }
    
    private ContactoService contactoService ;
    @Autowired
    public void setContactoService(ContactoService contactoService){
    this.contactoService=contactoService;
    }
    
     private DependienteService dependienteRep ;
    @Autowired
    public void setDependienteService(DependienteService dependienteRep){
    this.dependienteRep=dependienteRep;
    }
    
     private CaparecibidasService caparecibidasRep ;
    @Autowired
    public void setCaparecibidasService(CaparecibidasService caparecibidasRep){
    this.caparecibidasRep=caparecibidasRep;
    }
    
    
     private FormacionacademicaService formacionacademicaRep ;
    @Autowired
    public void setDependienteService(FormacionacademicaService formacionacademicaRep){
    this.formacionacademicaRep=formacionacademicaRep;
    }
    
     private ExperiencialaboralService experiencialaboralRep ;
    @Autowired
    public void setExperiencialaboralService(ExperiencialaboralService experiencialaboralRep){
    this.experiencialaboralRep=experiencialaboralRep;
    }
    
     private UbicacionFisicaService ubicacionFisicaRep ;
    @Autowired
    public void setUbicacionFisicaService(UbicacionFisicaService ubicacionFisicaRep){
    this.ubicacionFisicaRep=ubicacionFisicaRep;
    }
    
    private ContratoService contratoRep ;
    @Autowired
    public void setContratoService(ContratoService contratoRep){
    this.contratoRep=contratoRep;
    }
    
    private HijosdiscapacidadService hijosdiscapacidadRep ;
    @Autowired
    public void setHijosdiscapacidadService(HijosdiscapacidadService hijosdiscapacidadRep){
    this.hijosdiscapacidadRep=hijosdiscapacidadRep;
    }
    
    private IdiomaService idiomaRep ;
    @Autowired
    public void setIdiomaService(IdiomaService idiomaRep){
    this.idiomaRep=idiomaRep;
    }
    
     private BeneficioService beneficioRep ;
    @Autowired
    public void setBeneficioService(BeneficioService beneficioRep){
    this.beneficioRep=beneficioRep;
    }
    
    
    @Autowired
    public void setEmpleadoService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    
    private final String PREFIX = "fragments/empleado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "empleados";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/empleado")
    public String newEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        
        Iterable<Puesto> puestos = puestoService.listAllPuestos();
//         
      model.addAttribute("puestos", puestos);
        return PREFIX + "empleadoform";
    }
    


    @RequestMapping(value = "empleado")
    public String saveEmpleado(@Valid Empleado empleado,BindingResult result, Model model,SessionStatus status)  {
      try {
          empleadoService.saveEmpleado(empleado);
         status.setComplete();
            model.addAttribute("msg", 0);
          } catch(Exception e){
            model.addAttribute("msg", 1);
          }

        return "redirect:./show/" + empleado.getCodigoempleado();
    }
    


    
    @RequestMapping("show/{id}")    
    public String showEmpleado(@PathVariable Integer id, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        System.out.print("IDEMPLEADO"+id);
        
      Iterable<Contacto> contacto = contactoService.findByDato(id);
      model.addAttribute("contactos", contacto);
      
      Iterable<Dependiente> dependiente = dependienteRep.findByDato(id);
      model.addAttribute("dependientes", dependiente);
      
      Iterable<Formacionacademica> formacionacademica = formacionacademicaRep.findByDato(id);
      model.addAttribute("formacionacademicas", formacionacademica);
      
      Iterable<Caparecibidas> caparecibida = caparecibidasRep.findByDato(id);
      model.addAttribute("caparecibidas", caparecibida);
      
      Iterable<Experiencialaboral> experiencialaboral = experiencialaboralRep.findByDato(id);
      model.addAttribute("experiencialaborales", experiencialaboral);
      
      Iterable<Ubicacionfisica> ubicacionfisica = ubicacionFisicaRep.findByDato(id);
      model.addAttribute("ubicacionfisicas", ubicacionfisica);
      
      Iterable<Contrato> contrato = contratoRep.findByDato(id);
      model.addAttribute("contratos", contrato);
      
      Iterable<Hijodiscapacidad> hijodiscapacidad = hijosdiscapacidadRep.findByDato(id);
      model.addAttribute("hijodiscapacidades", hijodiscapacidad);
      
       Iterable<Idioma> idioma = idiomaRep.findByDato(id);
      model.addAttribute("idiomas", idioma);
      
      Iterable<Beneficio> beneficio = beneficioRep.findByDato(id);
      model.addAttribute("beneficio", beneficio);
      
      
        
        return PREFIX +"empleadoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        empleadoService.deleteEmpleado(id);
        return "redirect:/empleados/";
    }
    
    @RequestMapping("reporte/contrataciones")
    public String reportecontrataciones() {
        return PREFIX + "contratacionesreporte";
    }
    
    @RequestMapping(value = "pdfcontrataciones/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcontrataciones(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("contrataciones", "rpt_contrataciones", params, download,response);
    }
    
    @RequestMapping("crear/empleados")
    public String newempleado() {
        return PREFIX + "empleadoform";
    }
    
    @RequestMapping("reporte/despidos")
    public String reportedespidos() {
        return PREFIX + "despidosreporte";
    }
    
    
    @RequestMapping(value = "pdfdespidos/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfdespidos(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("despidos", "rpt_despidos", params, download,response);
    }

     @RequestMapping("reporte/estadisticoactivo")
    public String reporteestadisticoactivo() {
        return PREFIX + "estadisticoactivoreporte";
    }
    
    @RequestMapping(value = "pdfestadisticoactivo/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfestadisticoactivo(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("estadisticoactivo", "rpt_estadisticoactivo", params, download,response);
    }
    
    
}
