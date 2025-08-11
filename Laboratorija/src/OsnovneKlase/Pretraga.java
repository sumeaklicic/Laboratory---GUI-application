package OsnovneKlase;


public class Pretraga {
    
    private String naziv;
    private double refVrijednosti;


    public Pretraga(String naziv, double refVrijednosti) {
        this.naziv = naziv;
        this.refVrijednosti = refVrijednosti;
    }

    public Pretraga(String naziv) {
        this.naziv = naziv;
        
    }

    public Pretraga() {
    }



    public double getRefVrijednosti() {
        return refVrijednosti;
    }



    @Override
    public String toString() {
        return "INFORMACIJE O ODRADENOJ PRETRAZI SU IDUCE: NAZIV: "+naziv+ " Referentne vrijednosti: "+refVrijednosti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setRefVrijednosti(double refVrijednosti) {
        this.refVrijednosti = refVrijednosti;
    }

    


    
    
    
}
