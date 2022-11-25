package SAO.Offres.Offre;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter

@EqualsAndHashCode

@Entity
@Table(name = "offres")
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idEmployer")
    private Long idEmployer;

    @Column(name = "emailEmployer")
    private String emailEmployer;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "period")
    private String period;

    @Column(name = "location")
    private String location;

    @Column(name = "nbCandidates")
    private int nbCandidates;

    @Column(name = "availability")
    private boolean isAvailable;

    public Offre(Long idEmployer, String emailEmployer, String title, String description, String period, String location, int nbCandidates, boolean isAvailable) {
        this.idEmployer = idEmployer;
        this.emailEmployer = emailEmployer;
        this.title = title;
        this.description = description;
        this.period = period;
        this.location = location;
        this.nbCandidates = nbCandidates;
        this.isAvailable = isAvailable;
    }

    public Offre() {
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public Long getIdEmployer() {
        return idEmployer;
    }

    public String getEmailEmployer() {
        return emailEmployer;
    }

    public String getDescription() {
        return description;
    }

    public String getPeriod() {
        return period;
    }

    public String getLocation() {
        return location;
    }

    public int getNbCandidates() {
        return nbCandidates;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
