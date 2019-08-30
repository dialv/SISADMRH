package mj.gob.sisadmrh.controller.empleado;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Caparecibidas;
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Estado;
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
import mj.gob.sisadmrh.service.EstadoService;
import mj.gob.sisadmrh.service.ExperiencialaboralService;
import mj.gob.sisadmrh.service.FormacionacademicaService;
import mj.gob.sisadmrh.service.HijosdiscapacidadService;
import mj.gob.sisadmrh.service.IdiomaService;
import mj.gob.sisadmrh.service.PuestoService;
import mj.gob.sisadmrh.service.UbicacionFisicaService;
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
public class EmpleadoController extends UtilsController {

    private EmpleadoService empleadoService;
    private PuestoService puestoService;
    @Autowired
    private EstadoService estadoService;

    @Autowired
    public void SetPuestoService(PuestoService puestoService) {
        this.puestoService = puestoService;
    }
    private ContactoService contactoService;

    @Autowired
    public void setContactoService(ContactoService contactoService) {
        this.contactoService = contactoService;
    }
    private DependienteService dependienteRep;

    @Autowired
    public void setDependienteService(DependienteService dependienteRep) {
        this.dependienteRep = dependienteRep;
    }
    private CaparecibidasService caparecibidasRep;

    @Autowired
    public void setCaparecibidasService(CaparecibidasService caparecibidasRep) {
        this.caparecibidasRep = caparecibidasRep;
    }

    private FormacionacademicaService formacionacademicaRep;

    @Autowired
    public void setDependienteService(FormacionacademicaService formacionacademicaRep) {
        this.formacionacademicaRep = formacionacademicaRep;
    }

    private ExperiencialaboralService experiencialaboralRep;

    @Autowired
    public void setExperiencialaboralService(ExperiencialaboralService experiencialaboralRep) {
        this.experiencialaboralRep = experiencialaboralRep;
    }

    private UbicacionFisicaService ubicacionFisicaRep;

    @Autowired
    public void setUbicacionFisicaService(UbicacionFisicaService ubicacionFisicaRep) {
        this.ubicacionFisicaRep = ubicacionFisicaRep;
    }

    private ContratoService contratoRep;

    @Autowired
    public void setContratoService(ContratoService contratoRep) {
        this.contratoRep = contratoRep;
    }

    private HijosdiscapacidadService hijosdiscapacidadRep;

    @Autowired
    public void setHijosdiscapacidadService(HijosdiscapacidadService hijosdiscapacidadRep) {
        this.hijosdiscapacidadRep = hijosdiscapacidadRep;
    }

    private IdiomaService idiomaRep;

    @Autowired
    public void setIdiomaService(IdiomaService idiomaRep) {
        this.idiomaRep = idiomaRep;
    }

    private BeneficioService beneficioRep;

    @Autowired
    public void setBeneficioService(BeneficioService beneficioRep) {
        this.beneficioRep = beneficioRep;
    }

    @Autowired
    public void setEmpleadoService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    private final String PREFIX = "fragments/empleado/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("empleados", empleadoService.listAllActivos());
        return PREFIX + "empleados";
    }

    @RequestMapping(value = "/consulta", method = RequestMethod.GET)
    public String listconsulta(Model model) {
        model.addAttribute("empleados", empleadoService.listAllActivos());
        return PREFIX + "empleadoscons";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Iterable<Puesto> puestos = puestoService.listAllActivos();
        model.addAttribute("puestos", puestos);
        model.addAttribute("departamentos", estadoService.findBySuperior(2562));
        model.addAttribute("departamentosres", estadoService.findBySuperior(2562));
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/empleado")
    public String newEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());

        Iterable<Puesto> puestos = puestoService.listAllActivos();
        model.addAttribute("departamentos", estadoService.findBySuperior(2562));
        model.addAttribute("departamentosres", estadoService.findBySuperior(2562));
        model.addAttribute("puestos", puestos);
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "/municipio/{act}/{idemp}")
    public String acteco(@PathVariable(value = "act") Integer act, Model model, @PathVariable(value = "idemp") Integer idem) throws Exception {
        model.addAttribute("empleado", (idem == 0) ? new Empleado() : empleadoService.getEmpleadoById(idem));
        Iterable<Puesto> puestos = puestoService.listAllActivos();
        model.addAttribute("departamentos", estadoService.findBySuperior(2562));
        model.addAttribute("departamentosres", estadoService.findBySuperior(2562));
        model.addAttribute("puestos", puestos);
        model.addAttribute("municipios", estadoService.findBySuperior(act));
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "/municipiore/{act}/{act2}/{act3}{idemp}")
    public String actecores(@PathVariable(value = "act") Integer act, @PathVariable(value = "act2") Integer act2, @PathVariable(value = "act3") Integer act3, Model model, @PathVariable(value = "idemp") Integer idem) throws Exception {
//        model.addAttribute("municipiosres", estadoService.findBySuperior(act));
        model.addAttribute("empleado", (idem == 0) ? new Empleado() : empleadoService.getEmpleadoById(idem));
        Iterable<Puesto> puestos = puestoService.listAllActivos();
        model.addAttribute("departamentos", estadoService.findBySuperior(2562));
        model.addAttribute("departamentosres", estadoService.findBySuperior(2562));
        model.addAttribute("puestos", puestos);
        model.addAttribute("municipios", estadoService.findBySuperior(act2));
        model.addAttribute("mun", act3);
        model.addAttribute("municipiores", estadoService.findBySuperior(act));
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "empleado")
    public String saveEmpleado(@Valid Empleado empleado, BindingResult result, Model model, SessionStatus status) {//,SessionStatus status
        try {
            try {
                Estado municipio = estadoService.getEstadoById(Integer.parseInt(empleado.getMunicipionacimiento())).get();
                Estado depto = estadoService.getEstadoById(Integer.parseInt(municipio.getCodigoestadosuperior())).get();
                empleado.setDepartamentonacimiento("" + depto.getCodigoestado());
                empleado.setMunicipionacimiento("" + municipio.getCodigoestado());
                modipuesto(empleado.getCodigopuesto());
                empleadoService.saveEmpleado(empleado);
                bitacoraService.BitacoraRegistry("se  creo un Empleado",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
                model.addAttribute("msg", 0);

            } catch (Exception e) {
                empleadoService.saveEmpleado(empleado);

                model.addAttribute("msg", 0);
            }
        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "empleadoform";
    }

    private void modipuesto(Integer idpuesto) {
        Puesto puesto = puestoService.getPuestoById(idpuesto).get();
        puesto.setEstadopuesto(2);
        puestoService.savePuesto(puesto);
    }

    @RequestMapping("show/{id}")
    public String showEmpleado(@PathVariable Integer id, Model model) {
        Empleado empleado = empleadoService.getEmpleadoById(id).get();
        Estado depto = estadoService.getEstadoById(Integer.parseInt(empleado.getDepartamentonacimiento())).get();
        Estado munic = estadoService.getEstadoById(Integer.parseInt(empleado.getMunicipionacimiento())).get();
        empleado.setDepartamentonacimiento(depto.getNombreestado());
        empleado.setMunicipionacimiento(munic.getNombreestado());
        model.addAttribute("empleado", empleado);
        model.addAttribute("nombrepuesto", puestoService.getPuestoByIdEmpleado(empleado.getCodigopuesto()).get().getNombrepuesto());
        System.out.print("IDEMPLEADO" + id);

//         model.addAttribute("departamentos", estadoService.getEstadoById(Integer.parseInt(empleadoService.getEmpleadoById(id).get().getDepartamentonacimiento())));
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

        return PREFIX + "empleadoshow";
    }

    @RequestMapping("showcons/{id}")
    public String showEmpleadocons(@PathVariable Integer id, Model model) {
        Empleado empleado = empleadoService.getEmpleadoById(id).get();
        Estado depto = estadoService.getEstadoById(Integer.parseInt(empleado.getDepartamentonacimiento())).get();
        Estado munic = estadoService.getEstadoById(Integer.parseInt(empleado.getMunicipionacimiento())).get();
        empleado.setDepartamentonacimiento(depto.getNombreestado());
        empleado.setMunicipionacimiento(munic.getNombreestado());
        model.addAttribute("empleado", empleado);
        Integer idp=empleadoService.getEmpleadoById(id).get().getCodigopuesto();
        model.addAttribute("nombrepuesto", puestoService.getPuestoByIdEmpleado(idp).get().getNombrepuesto());
        
        System.out.print("IDEMPLEADO" + id);

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

        return PREFIX + "empleadoshowcons";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            Empleado empleado = empleadoService.getEmpleadoById(id).get();
            empleado.setEstadoempleado(0);
            empleadoService.saveEmpleado(empleado);
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);

        }
        return PREFIX + "empleados";
    }

    @RequestMapping("reporte/contrataciones")
    public String reportecontrataciones() {
        return PREFIX + "contratacionesreporte";
    }

    @RequestMapping(value = "pdfcontrataciones/", method = {RequestMethod.POST, RequestMethod.GET})
    public void pdfcontrataciones(
            @RequestParam(required = false) Boolean download,
            @RequestParam(value = "fechainicial", required = false) String fechainicio,
            @RequestParam(value = "fechafinal", required = false) String fechafin,
            HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        generatePdf("contrataciones", "rpt_contrataciones", params, download, response);
    }

    @RequestMapping("crear/empleados")
    public String newempleado() {
        return PREFIX + "empleadoform";
    }

    @RequestMapping("reporte/despidos")
    public String reportedespidos() {
        return PREFIX + "despidosreporte";
    }

    @RequestMapping(value = "pdfdespidos/", method = {RequestMethod.POST, RequestMethod.GET})
    public void pdfdespidos(
            @RequestParam(required = false) Boolean download,
            @RequestParam(value = "fechainicial", required = false) String fechainicio,
            @RequestParam(value = "fechafinal", required = false) String fechafin,
            HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        generatePdf("despidos", "rpt_despidos", params, download, response);
    }

    @RequestMapping("reporte/estadisticoactivo")
    public String reporteestadisticoactivo() {
        return PREFIX + "estadisticoactivoreporte";
    }

    @RequestMapping(value = "pdfestadisticoactivo/", method = {RequestMethod.POST, RequestMethod.GET})
    public void pdfestadisticoactivo(
            @RequestParam(required = false) Boolean download,
            @RequestParam(value = "fechainicial", required = false) String fechainicio,
            @RequestParam(value = "fechafinal", required = false) String fechafin,
            HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        generatePdf("estadisticoactivo", "rpt_estadisticoactivo", params, download, response);
    }
}
