package mj.gob.sisadmrh.controller.mision;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Mision;
import mj.gob.sisadmrh.service.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dialv
 *
 */
@Controller
@RequestMapping(value = "misiones")
public class MisionController extends UtilsController {

    private MisionService misionService;

    @Autowired
    public void setMisionService(MisionService misionService) {
        this.misionService = misionService;
    }

    private final String PREFIX = "fragments/mision/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("misiones", misionService.listAllActivos());
        return PREFIX + "misiones";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("mision", misionService.getMisionById(id));
        return PREFIX + "misionform";
    }

    @RequestMapping("new/mision")
    public String newMision(Model model) {
        model.addAttribute("mision", new Mision());
        return PREFIX + "misionform";
    }

    @RequestMapping(value = "mision")
    public String saveComision(Mision mision, Model model, @RequestParam("file") MultipartFile file) {
        try {
            mision.setDocacuerdo(file.getBytes());
            mision.setEstadomision(1);
            misionService.saveMision(mision);

            model.addAttribute("msg", 0);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "misionform";
    }

    @RequestMapping("show/{id}")
    public String showMision(@PathVariable Integer id, Model model) {
        model.addAttribute("mision", misionService.getMisionById(id).get());
        return PREFIX + "misionshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            Mision mision = misionService.getMisionById(id).get();
            mision.setEstadomision(0);
            misionService.saveMision(mision);
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);

        }
        return PREFIX + "misiones";
    }

}
