package database;

import OsnovneKlase.Nalaz;
import OsnovneKlase.Pacijent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pacijent_Kontroler extends Kontroler {



public Pacijent nadjiPacijentaPoId(int id) {
    String sql = "SELECT * FROM Pacijent WHERE ID = ?";
    try (Connection conn = getKon();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Pacijent p = new Pacijent(
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("BrojTelefona")
            );
            p.setId(rs.getInt("id"));
            return p;
        }


    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    return null;
}

    public void obrisiPacijentaIPovezanePodatke(int pacijentId) throws SQLException {
        NalazKontroler nalazKontroler = new NalazKontroler();
        NalazPretraga_Kontroler npKontroler = new NalazPretraga_Kontroler();

        List<Nalaz> nalazi = nalazKontroler.getNalaziZaPacijenta(pacijentId);

        for (Nalaz nalaz : nalazi) {
            int idNalaza = nalaz.getIdNalaza();
            npKontroler.obrisiSveZaNalaz(idNalaza);
            nalazKontroler.obrisiNalaz(idNalaza);
        }
    }



    public void azurirajPacijenta(int id, String ime, String prezime, String brojTelefona) throws SQLException {
    String sql = "UPDATE Pacijent SET ime = ?, prezime = ?, BrojTelefona = ? WHERE id = ?";
    try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, ime);
        ps.setString(2, prezime);
        ps.setString(3, brojTelefona);
        ps.setInt(4, id);
        ps.executeUpdate();
    }
}

 
 
    public void obrisiPacijenta(int id) throws SQLException {
        String sql = "DELETE FROM Pacijent WHERE id=?";
        try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Pacijent> pretraziPacijente(String kriterij) throws SQLException {
        List<Pacijent> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pacijent WHERE Ime LIKE ? OR Prezime LIKE ?";
        try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + kriterij + "%");
            ps.setString(2, "%" + kriterij + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            Pacijent p = new Pacijent(
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("BrojTelefona")
            );
            p.setId(rs.getInt("id")); 
            lista.add(p);
}

        }
        return lista;
    }

    public Pacijent getPacijentPoID(int id) throws SQLException {
        String sql = "SELECT * FROM Pacijent WHERE id=?";
        try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            Pacijent p = new Pacijent(
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("BrojTelefona")
            );
            p.setId(rs.getInt("id"));
            return p;
}

        }
        return null;
    }

public void dodajPacijenta(Pacijent p) throws SQLException {
String sql = "INSERT INTO Pacijent (Ime, Prezime, BrojTelefona) VALUES (?, ?, ?)";
try (Connection conn = getKon()) {
    conn.createStatement().execute("PRAGMA busy_timeout = 5000");
    try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, p.getIme());
        ps.setString(2, p.getPrezime());
        ps.setString(3, p.getBrojTelefona());
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                p.setId(generatedId);  
                System.out.println("Pacijent uspješno dodan sa ID: " + generatedId);
            }
        }
    }
}

}


    public void inicijalizujBazu() throws SQLException {
        String sql = "DROP TABLE IF EXISTS Pacijent";  // Brisanje postojeće tabele
        InsDelUpd(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS Pacijent (" +
              "id INTEGER PRIMARY KEY, " +
              "Ime TEXT NOT NULL, " +
              "Prezime TEXT NOT NULL, " +
              "BrojTelefona TEXT)";
        InsDelUpd(sql);
    }
}
