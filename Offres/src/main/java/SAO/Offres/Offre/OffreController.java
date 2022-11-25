package SAO.Offres.Offre;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/offre")

public class OffreController {
    private final OffreService offreService ;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }

    @PostMapping
    public String addOffer(
            @RequestParam("title") String Title,
            @RequestParam("description") String description,
            @RequestParam("nbCandidates") int nbCandidates,
            @RequestParam("isAvailable") Boolean isAvailable,
            @RequestParam("emailEmployer") String emailEmployer,
            @RequestParam("location") String location,
            @RequestParam("period") String period
            ){
            Offre newOffer = new Offre(null, emailEmployer, Title, description, period, location, nbCandidates, isAvailable);
            offreService.addOffer(newOffer);
        return "done";
    }

    @GetMapping
    public List<Offre> getAll() throws Exception {
        List<Offre> allOffers= new ArrayList<Offre>();
        allOffers = offreService.getAllOffers();
        return allOffers;
    }

    @GetMapping("search")
    public Offre getBytTitle(@RequestParam("title") String Title) throws Exception {
        System.out.println(offreService.loadOffreByTitle(Title).getDescription());
        return offreService.loadOffreByTitle(Title);
    }
}
