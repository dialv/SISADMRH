package mj.gob.sisadmrh.controller.dependiente;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadodependiente;
import mj.gob.sisadmrh.model.EmpleadodependientePK;
import mj.gob.sisadmrh.service.DependienteService;
import mj.gob.sisadmrh.service.EmpleadoDependienteService;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dialv
 *
 */
@Controller
@RequestMapping(value = "dependientes")
public class DependienteController extends UtilsController {

    private DependienteService dependienteService;
    @Autowired
    private EmpleadoDependienteService empleadoDependienteService;
    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    public void setDependienteService(DependienteService dependienteService) {
        this.dependienteService = dependienteService;
    }

    private final String PREFIX = "fragments/dependiente/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("dependientes", dependienteService.listAllDependiente());
        return PREFIX + "dependientes";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("dependiente", dependienteService.getDependienteById(id));
        return PREFIX + "dependienteform";
    }

    @RequestMapping("new/{id}")
    public String newDependiente(Model model) {
        model.addAttribute("dependiente", new Dependiente());
        return PREFIX + "dependienteform";
    }

    @RequestMapping(value = "dependiente/{id}")
    public String saveDependiente(Dependiente dependiente, Model model, @PathVariable Integer id) {

        try {
            dependiente.setEstadodependiente(1);
            dependienteService.saveDependiente(dependiente);
            Empleadodependiente emcon = new Empleadodependiente();
            emcon.setDependiente(dependiente);
            Empleado em = empleadoService.getEmpleadoById(id).get();
            EmpleadodependientePK emconpk = new EmpleadodependientePK();
            emconpk.setCodigodependiente(dependiente.getCodigodependiente());
            emconpk.setCodigoempleado(em.getCodigoempleado());
            emcon.setEmpleadodependientePK(emconpk);
            empleadoDependienteService.saveEmpleadodependiente(emcon);
            model.addAttribute("msg", 0);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "dependienteform";
    }

    @RequestMapping("show/{id}")
    public String showDependiente(@PathVariable Integer id, Model model) {
        model.addAttribute("dependiente", dependienteService.getDependienteById(id).get());
        return PREFIX + "dependienteshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {

        try {
            Dependiente dependiente = dependienteService.getDependienteById(id).get();
            dependiente.setEstadodependiente(0);
            dependienteService.saveDependiente(dependiente);
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        return PREFIX + "dependientes";
    }

}
