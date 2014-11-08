package tenttiarkisto.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kurssi extends AbstractPersistable<Long> {

    @NotBlank
    private String nimi;

    @OneToMany
    private List<Tentti> kurssinTentit;

    public Kurssi() {
    }

    public Kurssi(String nimi) {
        this.nimi = nimi;
        kurssinTentit = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public List<Tentti> getKurssinTentit() {
        return kurssinTentit;
    }

    public void setKurssinTentit(List<Tentti> kurssinTentit) {
        this.kurssinTentit = kurssinTentit;
    }

}
