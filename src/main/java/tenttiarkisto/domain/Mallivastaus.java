package tenttiarkisto.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Mallivastaus extends AbstractPersistable<Long>{
    
    @ManyToOne
    private Tentti tentti;
    
    @OneToMany(cascade=CascadeType.REMOVE, mappedBy = "kommentoituMallivastaus")
    private List<Kommentti> mallivastauksenKommentit;
    
    private String fileURL;
    
    public Mallivastaus() { 
    }
    
    public Mallivastaus(Tentti tentti, String fileURL) {
        this.tentti = tentti;
        this.fileURL = fileURL;
    }
    
    public Tentti getTentti() {
        return tentti;
    }

    public void setTentti(Tentti tentti) {
        this.tentti = tentti;
    }
    
    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }
    
    public List<Kommentti> getMallivastauksenKommentit() {
        return mallivastauksenKommentit;
    }

    public void setMallivastauksenKommentit(List<Kommentti> mallivastauksenKommentit) {
        this.mallivastauksenKommentit = mallivastauksenKommentit;
    }
}
