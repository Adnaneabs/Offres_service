package SAO.Offres.Offre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface OffreRepository extends JpaRepository<Offre, Long> {
    Optional<Offre> findByTitle(String title);

    @Transactional
    @Modifying
    @Query("UPDATE Offre o " +
            "SET o.isAvailable = false WHERE o.id = ?1"
    )

    int disableOffre(Long id);

}
