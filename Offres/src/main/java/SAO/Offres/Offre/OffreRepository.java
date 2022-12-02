package SAO.Offres.Offre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OffreRepository extends JpaRepository<Offre, Long> {

    Optional<List<Offre>> findAllByTitle(String title);
    Optional<List<Offre>> findAllByIdEmployer(Long idE);
    Optional<List<Offre>> findAllByLocation(String location);
    Optional<List<Offre>> findAllByPeriod(String period);
    Optional<List<Offre>> findAllByEmailEmployer(String email);


    @Transactional
    @Modifying
    @Query("UPDATE Offre o " +
            "SET o.isAvailable = false WHERE o.id = ?1"
    )

    int disableOffre(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Offre o " +
            "SET o.nbCandidates = o.nbCandidates-1 WHERE o.id = ?1"
    )

    int acceptedOne(Long id);


}
