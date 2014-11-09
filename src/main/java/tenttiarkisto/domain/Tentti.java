package tenttiarkisto.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tentti extends AbstractPersistable<Long> {

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date pvm;

    private String pitaja;

    @NotNull
    @ManyToOne
    private Kurssi kurssi;

    @NotNull
    @ManyToOne
    private Tyyppi tyyppi;

    @NotBlank
    private String kieli;
    
    private String fileURL;

    public Tentti() {
    }

    public Tentti(Date pvm, String pitaja, Kurssi kurssi, Tyyppi tyyppi, String kieli, String fileURL) {
        this.pvm = pvm;
        this.pitaja = pitaja;
        this.kurssi = kurssi;
        this.tyyppi = tyyppi;
        this.kieli = kieli;
        this.fileURL = fileURL;
    }

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

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

}
