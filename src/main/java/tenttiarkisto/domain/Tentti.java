
package tenttiarkisto.domain;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Tentti extends AbstractPersistable<Long> {
    
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date pvm;
    private String pitaja;
    @NotBlank
    private Kurssi kurssi;
    @NotBlank
    @ManyToOne
    private Tyyppi tyyppi;
    @NotBlank
    private String kieli;

    public Date getPvm() {
        return pvm;
    }

    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }

    public String getPitaja() {
        return pitaja;
    }

    public void setPitaja(String pitaja) {
        this.pitaja = pitaja;
    }

    public Kurssi getKurssi() {
        return kurssi;
    }

    public void setKurssi(Kurssi kurssi) {
        this.kurssi = kurssi;
    }

    public Tyyppi getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(Tyyppi tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String getKieli() {
        return kieli;
    }

    public void setKieli(String kieli) {
        this.kieli = kieli;
    }
    
    
}
