package SAO.Offres.Offre;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OffreService{

    private final OffreRepository offreRepository;

    public OffreService(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public List<Offre> AllOffersByIdE(Long idE) throws Exception {
        return offreRepository.findAllByIdEmployer(idE)
                .orElseThrow(() -> new Exception());
    }
    public List<Offre> loadAllOffersByTitle(String title) throws Exception {
        return offreRepository.findAllByTitle(title)
                .orElseThrow(() -> new Exception(String.format(title)));
    }

    public List<Offre> loadAllOffersOfEmployer(String email) throws Exception {
        return offreRepository.findAllByEmailEmployer(email)
                .orElseThrow(() -> new Exception(String.format(email)));
    }

    public List<Offre> getAllOffers(){
        return offreRepository.findAll();
    }

    public String addOffer(Offre offre){
        System.out.println(offre);
        offreRepository.save(offre);
        return "done" ;
    }

    public String candidateAccepted(Long idO){
        offreRepository.acceptedOne(idO);
        return "done";
    }

    public String offerFull(Long idO){
        offreRepository.disableOffre(idO);
        return "done";
    }
}
