package mj.gob.sisadmrh.controller.beneficios;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.controller.otherreport.BeneficioView;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadobeneficio;
import mj.gob.sisadmrh.model.EmpleadobeneficioPK;
import mj.gob.sisadmrh.service.BeneficioService;
import mj.gob.sisadmrh.service.EmpleadoBeneficioService;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author dialv
 *
 */
@Controller
@RequestMapping(value = "beneficios")
public class BeneficioController extends UtilsController {

    private BeneficioService beneficioService;
    @Autowired
    private EmpleadoBeneficioService empleadoBeneficioService;
    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    public void setBeneficioService(BeneficioService beneficioService) {
        this.beneficioService = beneficioService;
    }

    private final String PREFIX = "fragments/beneficio/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("beneficios", beneficioService.listAllActivos());
        return PREFIX + "beneficios";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("beneficio", beneficioService.getBeneficioById(id));
        return PREFIX + "beneficioform";
    }

    @RequestMapping("new/{id}")
    public String newBeneficio(Model model) {
        model.addAttribute("beneficio", new Beneficio());
        return PREFIX + "beneficioform";
    }

    @RequestMapping(value = "beneficio")
    public String saveBeneficio(Beneficio beneficio, Model model) {
        try {
            beneficio.setEstadobeneficio(1);
            beneficioService.saveBeneficio(beneficio);
            bitacoraService.BitacoraRegistry("se guardo un beneficio", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 0);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "beneficioform";
    }

    @RequestMapping("show/{id}")
    public String showBeneficio(@PathVariable Integer id, Model model) {
        model.addAttribute("beneficio", beneficioService.getBeneficioById(id).get());
        return PREFIX + "beneficioshow";
    }

    @RequestMapping("show2/{id}/{idemp}")
    public String showBeneficio2(@PathVariable Integer id, @PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("beneficio", beneficioService.getBeneficioById(id).get());
        return PREFIX + "beneficioshow2";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            Beneficio beneficio = beneficioService.getBeneficioById(id).get();
            beneficio.setEstadobeneficio(0);
            beneficioService.saveBeneficio(beneficio);
            bitacoraService.BitacoraRegistry("se elimino un Beneficio", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        return PREFIX + "beneficios";
    }

    @RequestMapping("delete2/{id}/{idemp}")
    public String delete2(@PathVariable Integer id, @PathVariable Integer idemp, Model model) {
        try {
            EmpleadobeneficioPK llavemp = new EmpleadobeneficioPK();
            llavemp.setCodigobeneficio(id);
            llavemp.setCodigoempleado(idemp);
            Empleadobeneficio emp = new Empleadobeneficio();
            emp.setEmpleadobeneficioPK(llavemp);
            empleadoBeneficioService.deleteEmpleadobeneficio(emp);
            bitacoraService.BitacoraRegistry("se elimino un beneficio a un empleado", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
        } catch (Exception ex) {
            System.out.println("deletebenefcioempleado {");
            StackTraceElement[] elementRaster3 = ex.getStackTrace();
            for (int in3 = 0; in3 < elementRaster3.length; in3++) {
                final StackTraceElement elementSTD = elementRaster3[in3];
                System.out.println("   " + in3 + " - getClassName=" + elementSTD.getClassName());
                System.out.println("   getMethodName=" + elementSTD.getMethodName());
                System.out.println("   getLineNumber=" + elementSTD.getLineNumber());
                System.out.println("   errorMSG=" + ex.getMessage());
            }
            System.out.println("}");
            model.addAttribute("msg", 4);
        }
        return "redirect:/empleados/show/" + idemp;
    }

    @RequestMapping("asignar/{id}")
    public String newEmpleadoBeneficio(Model model, @PathVariable Integer id) {
        model.addAttribute("beneficio", new Beneficio());
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        Iterable<Beneficio> beneficio = beneficioService.listAllActivos();
        model.addAttribute("beneficios", beneficio);
        return PREFIX + "beneficioempleadoform";
    }

    @RequestMapping("edit2/{id}/{idemp}")
    public String asignar2(@PathVariable Integer id, @PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("beneficio", new Beneficio());
        Iterable<Beneficio> beneficio = beneficioService.listAllBeneficios();
        model.addAttribute("beneficios", beneficio);
        return PREFIX + "beneficioempleadoform";
    }

    @RequestMapping(value = "edit2/beneficio/asignar/{id}")
    public String save2EmpleadoBeneficio(Beneficio beneficio, Model model, @PathVariable Integer id) {
        try {
            Empleadobeneficio emben = new Empleadobeneficio();
            emben.setBeneficio(beneficio);
            Empleado em = empleadoService.getEmpleadoById(id).get();
            emben.setEmpleado(empleadoService.getEmpleadoById(id).get());
            EmpleadobeneficioPK embenpk = new EmpleadobeneficioPK();
            embenpk.setCodigobeneficio(beneficio.getCodigobeneficio());
            embenpk.setCodigoempleado(em.getCodigoempleado());
            emben.setEmpleadobeneficioPK(embenpk);
            emben.setFechabeneficio(new Date());
            empleadoBeneficioService.saveEmpleadobeneficio(emben);
            model.addAttribute("msg", 0);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
            Logger.getLogger(BeneficioController.class.getName()).log(Level.SEVERE, null, e);
        }
        return "redirect:/empleados/show/" + id;
    }

    @RequestMapping(value = "beneficio/asignar/{id}")
    public String saveEmpleadoBeneficio(Beneficio beneficio, Model model, @PathVariable Integer id) {
        try {
            Empleadobeneficio emben = new Empleadobeneficio();
            emben.setBeneficio(beneficio);
            Empleado em = empleadoService.getEmpleadoById(id).get();
            emben.setEmpleado(empleadoService.getEmpleadoById(id).get());
            EmpleadobeneficioPK embenpk = new EmpleadobeneficioPK();
            embenpk.setCodigobeneficio(beneficio.getCodigobeneficio());
            embenpk.setCodigoempleado(em.getCodigoempleado());
            emben.setEmpleadobeneficioPK(embenpk);
            emben.setFechabeneficio(new Date());
            empleadoBeneficioService.saveEmpleadobeneficio(emben);
            model.addAttribute("msg", 0);
            model.addAttribute("empleado", id);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
            Logger.getLogger(BeneficioController.class.getName()).log(Level.SEVERE, null, e);
        }
        return "redirect:/empleados/show/" + id;
    }

    @RequestMapping("report/")
    public String reporte(Model model) {
        model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "beneficiosreport";
    }

    @RequestMapping(value = "pdf/{indice}", method = {RequestMethod.POST, RequestMethod.GET})
    public void pdf(@PathVariable("indice") Long indice,
            @RequestParam(required = false) Boolean download,
            @RequestParam(value = "fechainicial", required = false) String fechainicio,
            @RequestParam(value = "fechafinal", required = false) String fechafin,
            HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("USUARIO", getRequest().getUserPrincipal().getName());
        params.put("CODIGO", indice.toString());
        params.put("FECHAINICIO", fechainicio);
        params.put("FECHAFIN", fechafin);
        generatePdf("beneficios", "rpt_beneficios", params, download, response);
    }

    @RequestMapping("/beneficiosexel")
    public ModelAndView beneficiosexel(
            @RequestParam(value = "fechainicial", required = false) String fechainicio,
            @RequestParam(value = "fechafinal", required = false) String fechafin,
            @RequestParam(value = "codigo", required = false) String codigo) {
        List<Object[]> beneList = beneficioService.beneficiosExcel(fechainicio, fechafin, codigo);
        return new ModelAndView(new BeneficioView(), "beneList", beneList);
    }
}
