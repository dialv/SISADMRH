package mj.gob.sisadmrh.controller.EvaluacionCapacitacion;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.EvaluacionCapacitacion;
import mj.gob.sisadmrh.service.CapacitacionService;

import mj.gob.sisadmrh.service.EvaluacionCapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author jorge
 */
@Controller
@SessionAttributes("evaluacioncapacitacion")
@RequestMapping(value = "evaluacioncapacitaciones")
public class EvaluacionCapacitacionController extends UtilsController {

    private EvaluacionCapacitacionService evaluacionCapacitacionService;

    @Autowired
    public void SetEvaluacionCapacitacionService(EvaluacionCapacitacionService evaluacionCapacitacionService) {
        this.evaluacionCapacitacionService = evaluacionCapacitacionService;
    }

    @Autowired
    private CapacitacionService capacitacionService;

    private final String PREFIX = "fragments/evaluacioncapacitacion/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("evaluacioncapacitaciones", evaluacionCapacitacionService.listAllEvaluacionCapacitacion());
        return PREFIX + "evaluacioncapacitaciones";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("evaluacioncapacitacion", evaluacionCapacitacionService.getEvualuacionCapacitacionById(id));
        Iterable<Capacitacion> capacitaciones = capacitacionService.listAllCapacitacion();
        model.addAttribute("capacitaciones", capacitaciones);
        return PREFIX + "evaluacioncapacitacionform";
    }

    @RequestMapping("new/evaluacioncapacitacion")
    public String newEvaluacionCapacitacion(Model model) {
        model.addAttribute("evaluacioncapacitacion", new EvaluacionCapacitacion());
        Iterable<Capacitacion> capacitaciones = capacitacionService.listAllCapacitacion();
        model.addAttribute("capacitaciones", capacitaciones);
        return PREFIX + "evaluacioncapacitacionform";
    }

    @RequestMapping(value = "evaluacioncapacitacion")
    public String saveEvaluacionCapacitacion(EvaluacionCapacitacion evaluacionCapacitacion, Model model, SessionStatus status) {
        try {
            evaluacionCapacitacionService.saveEvualuacionCapacitacion(evaluacionCapacitacion);
            status.setComplete();
            bitacoraService.BitacoraRegistry("se creo una Evaluacion Capacitacion", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 0);
            //  return PREFIX + "evaluacioncapacitaciones";

        } catch (Exception e) {
            model.addAttribute("msg", 1);
            // return PREFIX + "evaluacioncapacitacionform";
        }
        return PREFIX + "evaluacioncapacitaciones";

        //return "redirect:./show/" + capacitacion.getCodigocapacitacion();
        //return "redirect:./show/" + evaluacionCapacitacion.getCodigoevaluacioncapacitacion();
    }

    @RequestMapping("show/{id}")
    public String showEvaluacionCapacitacion(@PathVariable Integer id, Model model) {

        model.addAttribute("evaluacioncapacitacion", evaluacionCapacitacionService.getEvualuacionCapacitacionById(id).get());

        return PREFIX + "evaluacioncapacitacionshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            EvaluacionCapacitacion evaluacionCapacitacion = evaluacionCapacitacionService.getEvualuacionCapacitacionById(id).get();
            evaluacionCapacitacion.setEstadoevaluacion(0);
            evaluacionCapacitacionService.saveEvualuacionCapacitacion(evaluacionCapacitacion);
            bitacoraService.BitacoraRegistry("se elimino una  Evaluacion Capacitacion", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        return "redirect:/evaluacioncapacitaciones/";
    }

    @RequestMapping("report/")
    public String reporte(Model model) {
        model.addAttribute("evaluacioncapacitaciones", evaluacionCapacitacionService.listAllEvaluacionCapacitacion());
        return PREFIX + "evaluacioncapacitacionesreport";
    }

    @RequestMapping(value = "pdf/{indice}", method = {RequestMethod.POST, RequestMethod.GET})
    public void pdf(@PathVariable("indice") Long indice,
            @RequestParam(required = false) Boolean download,
            @RequestParam(value = "fechainicial", required = false) String fechainicio,
            @RequestParam(value = "fechafinal", required = false) String fechafin,
            HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("CODIGO", indice.toString());
        params.put("FECHAINICIO", fechainicio);
        params.put("FECHAFIN", fechafin);
        generatePdf("evaluacioncapacitaciones", "rpt_evaluacioncapacitaciones", params, download, response);
    }

}
