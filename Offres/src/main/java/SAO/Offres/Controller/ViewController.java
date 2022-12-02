package SAO.Offres.Controller;

import SAO.Offres.Offre.Offre;
import SAO.Offres.Offre.OffreController;
import SAO.Offres.Offre.OffreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/offres")
public class ViewController {
    private final OffreController offreController ;

    public ViewController(OffreController offreController, OffreService offreService) {
        this.offreController = offreController;
    }

    @GetMapping
    public String showAllOffers(Model model) throws Exception {
        List<Offre> allOffers = offreController.getAll();
        System.out.println(allOffers);
        //model.addAttribute("notification", )
        model.addAttribute("allOffers", allOffers);
        return "offres";
    }

    @GetMapping("search")
    public String showFoundOffers(Model model, @RequestParam("title") String title) throws Exception {
        List<Offre> allOffers = offreController.getBytTitle(title);
        System.out.println(allOffers);
        model.addAttribute("allOffers", allOffers);
        return "offres";
    }

    @GetMapping("employer")
    public String showOffersByEmployer(Model model, @RequestParam("email") String email) throws Exception {
        List<Offre> allOffers = offreController.getByEmailEmployer(email);
        System.out.println(allOffers);
        model.addAttribute("allOffers", allOffers);
        return "offres";
    }

    @GetMapping({"/index", "/"})
    public String home() {
        return "index";
    }


}
