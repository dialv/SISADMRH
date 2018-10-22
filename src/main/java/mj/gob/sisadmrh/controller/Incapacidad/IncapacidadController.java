/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.Incapacidad;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Incapacidad;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.IncapacidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jorge
 */
@Controller
@SessionAttributes("incapacidad")
@RequestMapping(value = "incapacidades")
public class IncapacidadController extends UtilsController {

    @Autowired
    private IncapacidadService incapacidadService;
    @Autowired
    private EmpleadoService empleadoService;

    private final String PREFIX = "fragments/incapacidad/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("incapacidades", incapacidadService.listAllIncapacidad());
        return PREFIX + "incapacidades";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("incapacidad", incapacidadService.getIncapacidadById(id).get());
         Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
        model.addAttribute("empleados", empleados);
        return PREFIX + "incapacidadform";
    }

    @RequestMapping("new/incapacidad")
    public String newIncapacidad(Model model) {
        model.addAttribute("incapacidad", new Incapacidad());

        // -----------Manda a la vista los empleados
        Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
        model.addAttribute("empleados", empleados);
        return PREFIX + "incapacidadform";
    }
   @RequestMapping(value = "/descarga/{id}")
    public void verDocumento(HttpServletResponse response, @PathVariable(value = "id") Integer id) 
           throws IOException{ 
           streamReport(response, incapacidadService.getIncapacidadById(id).get().getDocumento1(), "Documento.pdf");// es el comprobante de la incapacidad
    }

    @RequestMapping(value = "incapacidad")
    public String saveIncapacidad(Incapacidad incapacidad, Model model,SessionStatus status,@RequestParam("file") MultipartFile file) {
        try {
             incapacidad.setDocumento1(file.getBytes());// es el documento o constancia de incapacidad
          //  incapacidad.setDocumento2(file.getBytes());
            incapacidadService.saveIIncapacidad(incapacidad);
            status.setComplete();
            model.addAttribute("msg", 0);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "incapacidades";
    }

    @RequestMapping("show/{id}")
    public String showIncapacidad(@PathVariable Integer id, Model model) {
        model.addAttribute("incapacidad", incapacidadService.getIncapacidadById(id).get());
        return PREFIX + "incapacidadshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            incapacidadService.deleteIncapacidad(id);
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        return "redirect:/incapacidades/";
    }
    
     @RequestMapping(value = "pdf/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("incapacidades", "rpt_incapacidades", params, download,response);
    }
}
