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


    public Offre loadOffreByTitle(String title) throws Exception {
        return offreRepository.findByTitle(title)
                .orElseThrow(() -> new Exception(String.format(title)));
    }

    public List<Offre> getAllOffers(){
        return offreRepository.findAll();
    }

    public String addOffer(Offre offre){
        System.out.println(offre);
        offreRepository.save(offre);
        return "done" ;
    }
}
