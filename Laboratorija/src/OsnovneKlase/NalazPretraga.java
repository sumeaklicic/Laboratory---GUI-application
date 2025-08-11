/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OsnovneKlase;


public class NalazPretraga {
    private int id; 
    private int nalazId;
    private int pretragaId;
    private String izmjereneVrijednosti;

    public NalazPretraga() {
    }

    public NalazPretraga(int id, int nalazId, int pretragaId, String izmjereneVrijednosti) {
        this.id = id;
        this.nalazId = nalazId;
        this.pretragaId = pretragaId;
        this.izmjereneVrijednosti = izmjereneVrijednosti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNalazId() {
        return nalazId;
    }

    public void setNalazId(int nalazId) {
        this.nalazId = nalazId;
    }

    public int getPretragaId() {
        return pretragaId;
    }

    public void setPretragaId(int pretragaId) {
        this.pretragaId = pretragaId;
    }

    public String getIzmjereneVrijednosti() {
        return izmjereneVrijednosti;
    }

    public void setIzmjereneVrijednosti(String izmjereneVrijednosti) {
        this.izmjereneVrijednosti = izmjereneVrijednosti;
    }

    @Override
    public String toString() {
        return "ID_Veze=" + id + ", Nalaz_ID=" + nalazId + ", Pretraga_ID=" + pretragaId + ", Vrijednost=" + izmjereneVrijednosti;
    }
}
