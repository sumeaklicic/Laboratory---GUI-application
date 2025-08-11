/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import OsnovneKlase.Pacijent;
import OsnovneKlase.Pretraga;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Pretraga_Kontroler extends Kontroler {

public void dodajPacijenta(Pacijent p) throws SQLException {
    String sql = "INSERT INTO Pacijent (Ime, Prezime, BrojTelefona) VALUES (?, ?, ?)";
    try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, p.getIme());          
        ps.setString(2, p.getPrezime());     
        ps.setString(3, p.getBrojTelefona()); 
        ps.executeUpdate();
        System.out.println("Pacijent uspješno dodan u bazu.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public boolean obrisiPretraguSaPovezanim(String nazivPretrage) {
    Connection conn = null;
    PreparedStatement stmtNalazPretraga = null;
    PreparedStatement stmtPretraga = null;

    try {
        conn = getKon();
        conn.setAutoCommit(false);

        String deleteNalazPretraga = "DELETE FROM Nalaz_Pretraga WHERE Pretraga_ID = ?";
        stmtNalazPretraga = conn.prepareStatement(deleteNalazPretraga);
        stmtNalazPretraga.setString(1, nazivPretrage);
        stmtNalazPretraga.executeUpdate();

        String deletePretraga = "DELETE FROM Pretraga WHERE Naziv = ?";
        stmtPretraga = conn.prepareStatement(deletePretraga);
        stmtPretraga.setString(1, nazivPretrage);
        stmtPretraga.executeUpdate();

        conn.commit();
        return true;
        
    } 
    catch (Exception e) {
        
    try {
        if (conn != null) conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
        return false;
    } 
    
    finally {
        
        try {
            if (stmtNalazPretraga != null) stmtNalazPretraga.close();
            if (stmtPretraga != null) stmtPretraga.close();
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}


public boolean azurirajReferentnuVrijednost(String naziv, double novaVrijednost) throws SQLException {
    String sql = "UPDATE Pretraga SET ReferentnaVrijednost = ? WHERE Naziv = ?";
    try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setDouble(1, novaVrijednost);
        ps.setString(2, naziv);
        int rows = ps.executeUpdate();
        return rows > 0;
    }
}

    
    public void inicijalizujBazu() throws SQLException {

    String sql = "CREATE TABLE IF NOT EXISTS Pretraga (naziv TEXT PRIMARY KEY, ReferentnaVrijednost REAL)";
    InsDelUpd(sql);
}

    public List<Pretraga> svePretrage() throws SQLException {
        List<Pretraga> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pretraga";
        try (Connection conn = getKon(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String naziv = rs.getString("naziv");
                double ref = rs.getDouble("ReferentnaVrijednost");
                lista.add(new Pretraga(naziv, ref));
            }
        }
        return lista;
    }


    public void obrisiPretragu(String naziv) throws SQLException {
        String sql = "DELETE FROM Pretraga WHERE naziv=?";
        try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, naziv);
            ps.executeUpdate();
            System.out.println("Pretraga obrisana.");
        }
    }
    
    public boolean postojiPretraga(String naziv) throws SQLException {
    String sql = "SELECT COUNT(*) FROM Pretraga WHERE naziv = ?";
    try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, naziv);
        try (ResultSet rs = ps.executeQuery()) {
            return rs.next() && rs.getInt(1) > 0;
        }
    }
}

public void dodajPretragu(Pretraga p) throws SQLException {
    String sql = "INSERT INTO Pretraga (naziv, ReferentnaVrijednost) VALUES (?, ?)";
    try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, p.getNaziv());
        ps.setDouble(2, p.getRefVrijednosti());
        ps.executeUpdate();
        System.out.println("Pretraga uspješno dodana.");
    }
}





}
