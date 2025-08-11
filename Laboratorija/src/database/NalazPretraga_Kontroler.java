package database;
import OsnovneKlase.NalazPretraga;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NalazPretraga_Kontroler extends Kontroler {

    public void dodajNalazPretragu(int nalazId, int pretragaId, String izmjerenaVrijednost) {
        String sql = "INSERT INTO Nalaz_Pretraga (Nalaz_ID, Pretraga_ID, IzmjerenaVrijednost) VALUES (?, ?, ?)";

        try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nalazId);
            ps.setInt(2, pretragaId);
            ps.setString(3, izmjerenaVrijednost);
            ps.executeUpdate();
            System.out.println("Uspješno dodana izmjerena vrijednost.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                zatvoriKonekciju();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
        public void obrisiSveZaNalaz(int idNalaza) throws SQLException {
        String sql = "DELETE FROM Nalaz_Pretraga WHERE Nalaza_ID = ?";
        try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idNalaza);
            ps.executeUpdate();
        }
    }
    
    public void dodajNalazPretraga(int idNalaza, String nazivPretrage, String izmjerenaVrijednost) throws SQLException {
    String sql = "INSERT INTO Nalaz_Pretraga (Nalaza_ID, Pretraga_ID, IzmjereneVrijednosti) VALUES (?, ?, ?)";

    try (Connection conn = this.getKon();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idNalaza);
        stmt.setString(2, nazivPretrage); // sad ide naziv umjesto ID-ja
        stmt.setString(3, izmjerenaVrijednost);
        stmt.executeUpdate();
    }
    }
    public List<NalazPretraga> getSveNalazPretrage() {
      List<NalazPretraga> lista = new ArrayList<>();
      String sql = "SELECT rowid AS id, Nalaza_ID, Pretraga_ID, IzmjereneVrijednosti FROM Nalaz_Pretraga";

      try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
          while (rs.next()) {
              NalazPretraga np = new NalazPretraga();
              np.setId(rs.getInt("id"));
              np.setNalazId(rs.getInt("Nalaza_ID"));
              np.setPretragaId(rs.getInt("Pretraga_ID"));
              np.setIzmjereneVrijednosti(rs.getString("IzmjereneVrijednosti"));
              lista.add(np);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          try {
              zatvoriKonekciju();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      return lista;
  }



      // Dohvat svih izmjerenih vrijednosti za dati nalaz
      public List<String> getIzmjereneVrijednostiZaNalaz(int nalazId) throws SQLException {
          List<String> lista = new ArrayList<>();
          String sql = "SELECT Pretraga_ID, IzmjerenaVrijednost FROM Nalaz_Pretraga WHERE Nalaz_ID = ?";

          try (Connection conn = getKon(); PreparedStatement ps = conn.prepareStatement(sql)) {
              ps.setInt(1, nalazId);
              try (ResultSet rs = ps.executeQuery()) {
                  while (rs.next()) {
                      int idPretrage = rs.getInt("Pretraga_ID");
                      String vrijednost = rs.getString("IzmjerenaVrijednost");
                      lista.add("Pretraga ID: " + idPretrage + ", Vrijednost: " + vrijednost);
                  }
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              zatvoriKonekciju();
          }

          return lista;
      }

    public boolean obrisiNalazPretraga(int idVeze) {
    String url = "jdbc:sqlite:C:\\Users\\Korisnik\\OneDrive\\Radna površina\\Laboratorija.db";
    String sql = "DELETE FROM Nalaz_Pretraga WHERE ID_VEZE = ?";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idVeze);
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

}
