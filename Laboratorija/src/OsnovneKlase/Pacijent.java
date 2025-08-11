package OsnovneKlase;

public class Pacijent {
    
    private String ime;
    private String prezime;
    private String brojTelefona;
    private int id;

    public Pacijent(String ime, String prezime, String brojTelefona) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
    }

    public Pacijent() {
        
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return "PACIJENT IMA SLJEDECE INFORMACIJE: Ime: " + ime + " Prezime: " + prezime + " JMBG: " + id + " Broj telefona: " + brojTelefona;
    }
}
