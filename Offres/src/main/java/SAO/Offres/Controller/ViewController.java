package SAO.Offres.Controller;

import SAO.Offres.Offre.Offre;
import SAO.Offres.Offre.OffreController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/offres")
public class ViewController {
    private final OffreController offreController ;

    public ViewController(OffreController offreController) {
        this.offreController = offreController;
    }

    @GetMapping
    public String showAllOffers(Model model) throws Exception {
        List<Offre> allOffers = offreController.getAll();
        System.out.println(allOffers);
        model.addAttribute("allOffers", allOffers);
        return "offres";
    }

    @GetMapping({"/index", "/"})
    public String home() {
        return "index";
    }


}
