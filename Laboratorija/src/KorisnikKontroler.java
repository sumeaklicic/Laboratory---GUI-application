
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KorisnikKontroler {
    private static final String URL = "jdbc:sqlite:C:\\Users\\Korisnik\\OneDrive\\Radna površina\\Laboratorija.db";

    public void dodajKorisnika(String korisnickoIme, String lozinka) {
        String sql = "INSERT INTO Korisnik (korisnicko_ime, lozinka) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, korisnickoIme);
            stmt.setString(2, lozinka);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
         
     public KorisnikKontroler() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Korisnik (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "korisnicko_ime TEXT NOT NULL UNIQUE, " +
                         "lozinka TEXT NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

