package database;

import OsnovneKlase.Nalaz;
import OsnovneKlase.Pacijent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class NalazKontroler extends Kontroler {

    public void dodajNalaz(Nalaz nalaz) throws SQLException {
        String sql = "INSERT INTO Nalaz (id, naziv, datum, pacijent_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = getKon()) {
            conn.setAutoCommit(false);
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("PRAGMA busy_timeout = 5000");
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, nalaz.getIdNalaza());
                ps.setString(2, nalaz.getNaziv());
                ps.setString(3, nalaz.getDatum());
                ps.setInt(4, nalaz.getPacijentId());
                ps.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public void obrisiNalazePoPacijentuId(int pacijentId) throws SQLException {
        String sql = "DELETE FROM Nalaz WHERE Pacijent_ID = ?";

        try {
            kon = getKon();
            ps = kon.prepareStatement(sql);
            ps.setInt(1, pacijentId);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {}
            }
            zatvoriKonekciju();
        }
    }

    public boolean postojiNalaz(int idNalaza) throws SQLException {
    Connection conn = getKon(); // koristiš svoju metodu iz apstraktne klase
    String query = "SELECT COUNT(*) FROM nalaz WHERE ID = ?";
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setInt(1, idNalaza);
    ResultSet rs = stmt.executeQuery();

    boolean postoji = false;
    if (rs.next()) {
        postoji = rs.getInt(1) > 0;
    }

    rs.close();
    stmt.close();
    zatvoriKonekciju();

    return postoji;
}



    public int generisiIdNalaza() throws SQLException {
    String sql = "SELECT MAX(id) AS max_id FROM Nalaz";
    try (Connection conn = getKon(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        if (rs.next()) {
            return rs.getInt("max_id") + 1;
        }
    }
    return 1; // ako je tabela prazna
}
    
    public void obrisiNalaz(int idNalaza) throws SQLException {
    Connection conn = getKon();
    try {
        conn.setAutoCommit(false);

        // Prvo obriši iz Nalaz_Pretraga gdje je taj Nalaza_ID
        String sql1 = "DELETE FROM Nalaz_Pretraga WHERE Nalaza_ID = ?";
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ps1.setInt(1, idNalaza);
        ps1.executeUpdate();

        // Onda obriši iz nalaz
        String sql2 = "DELETE FROM nalaz WHERE ID = ?";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setInt(1, idNalaza);
        ps2.executeUpdate();

        conn.commit();
        } catch (SQLException ex) {
            if (conn != null) conn.rollback();
            throw ex;
        } finally {
            if (conn != null) conn.close();
        }
    }

    
    public void azurirajNalaz(int idNalaza, String noviNaziv, String noviDatum) throws SQLException {
    String sql = "UPDATE Nalaz SET naziv = ?, datum = ? WHERE id = ?";
    try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, noviNaziv);
        ps.setString(2, noviDatum);
        ps.setInt(3, idNalaza);
        ps.executeUpdate();
    }
    }

    public Nalaz nadjiNalazPoId(int idNalaza) {
        String sql = "SELECT * FROM Nalaz WHERE id = ?";
        try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idNalaza);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String naziv = rs.getString("naziv");
                String datum = rs.getString("datum");
                int pacijentId = rs.getInt("pacijent_id");
                Nalaz nalaz = new Nalaz(naziv, datum, pacijentId);
                nalaz.setIdNalaza(idNalaza);
                return nalaz;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Nalaz> getSviNalazi() {
        List<Nalaz> lista = new ArrayList<>();
        String sql = "SELECT * FROM Nalaz";
        try (Connection conn = getKon();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                String datum = rs.getString("datum");
                int pacijentId = rs.getInt("pacijent_id");

                Nalaz n = new Nalaz(naziv, datum, pacijentId);
                n.setIdNalaza(id);
                lista.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Nalaz> getNalaziZaPacijenta(int pacijentId) {
        List<Nalaz> lista = new ArrayList<>();
        String sql = "SELECT * FROM Nalaz WHERE pacijent_id = ?";
        try (Connection conn = getKon();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pacijentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                String datum = rs.getString("datum");

                Nalaz n = new Nalaz(naziv, datum, pacijentId);
                n.setIdNalaza(id);
                lista.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }




}


