
package OsnovneKlase;
import java.util.ArrayList;
import java.util.List;


public class Nalaz {
    
    List<Pretraga> odradenePretrage = new ArrayList<>();
    private int idNalaza;
    private String datum;
    private String naziv;
    private Pacijent pacZaNalaz; 
    private int pacijentId;

 
    public Nalaz(  String naziv,String datum, int pacijentId ) {
        this.datum = datum;
        this.naziv = naziv;
        this.pacijentId=pacijentId;
 
    }
    
    public void dodajPretragu(Pretraga p) {
    odradenePretrage.add(p);
}

      public int getPacijentId() {
        return pacijentId;
    }
    public String getDatum() {
        return datum;
    }

    public int getIdNalaza() {
        return idNalaza;
    }

    public Pacijent getPacZaNalaz() {
        return pacZaNalaz;
    }
    
    public Pretraga getOdradenePretrage() {
        return (Pretraga) odradenePretrage;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setIdNalaza(int idNalaza) {
        this.idNalaza = idNalaza;
    }
    
    
    
}

