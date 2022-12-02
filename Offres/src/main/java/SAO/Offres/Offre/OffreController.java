package SAO.Offres.Offre;

import SAO.Offres.Controller.ViewController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/offre")

public class OffreController {
    private final OffreService offreService ;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }
    public ViewController viewController;

    @GetMapping("/byEmployer")
    public List<Offre> getByEmployer(@RequestParam("idEmployer") Long idE) throws Exception {
        return offreService.AllOffersByIdE(idE);
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
    public List<Offre> getBytTitle(@RequestParam("title") String Title) throws Exception {
        return offreService.loadAllOffersByTitle(Title);
    }

    @GetMapping("offerByEmployer")
    public List<Offre> getByEmailEmployer(@RequestParam("email") String email) throws Exception {
        return offreService.loadAllOffersOfEmployer(email);
    }

    @PostMapping("/apply")
    public String apply(@RequestParam("idOffer") Long idO) throws Exception {
        offreService.candidateAccepted(idO);
        return "Ok";
    }
/*
    @GetMapping("/idO")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> getId(@RequestParam("idO") Long idO){
        String email = userService.getUsername();
        System.out.println(userService.getEmployeurId(email));
        return new ResponseEntity<Long>(userService.getEmployeurId(email), HttpStatus.OK);
    }
*/
}
