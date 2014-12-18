package tenttiarkisto.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tentti extends AbstractPersistable<Long> implements Comparable<Tentti> {

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

    @NotNull
    @ManyToOne
    private Kieli kieli;
    
    @OneToMany(cascade=CascadeType.REMOVE, mappedBy = "kommentoituTentti")
    private List<Kommentti> tentinKommentit;
    
    private String fileURL;
    
    @OneToMany
    private List<Mallivastaus> tentinMallivastaukset;

    public Tentti() {
    }

    public Tentti(Date pvm, String pitaja, Kurssi kurssi, Tyyppi tyyppi, Kieli kieli, String fileURL) {
        this.pvm = pvm;
        this.pitaja = pitaja;
        this.kurssi = kurssi;
        this.tyyppi = tyyppi;
        this.kieli = kieli;
        this.fileURL = fileURL;
        this.tentinKommentit = new ArrayList<>();
        this.tentinMallivastaukset = new ArrayList<>();
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

    public Kieli getKieli() {
        return kieli;
    }

    public void setKieli(Kieli kieli) {
        this.kieli = kieli;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public List<Kommentti> getTentinKommentit() {
        return tentinKommentit;
    }

    public void setTentinKommentit(List<Kommentti> tentinKommentit) {
        this.tentinKommentit = tentinKommentit;
    }

    @Override
    public int compareTo(Tentti that) {
        return this.getPvm().compareTo(that.getPvm());
    }
    
    public List<Mallivastaus> getTentinMallivastaukset() {
        return tentinMallivastaukset;
    }
    
    public void setTentinMallivastaus(List<Mallivastaus> tentinMallivastaukset) {
        this.tentinMallivastaukset = tentinMallivastaukset;
    }
}
