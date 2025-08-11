package database;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

public abstract class Kontroler {

    protected static String dbPath; 
    protected Statement stmt; 
    protected PreparedStatement ps; 
    protected Connection kon; 

    public Kontroler() {
        dbPath = "jdbc:sqlite:C:\\Users\\Korisnik\\OneDrive\\Radna površina\\Laboratorija.db";
    }

    public Connection getKon() throws SQLException {
        kon = DriverManager.getConnection(dbPath);
        return kon;
          }

    public void InsDelUpd(String sql) throws SQLException {
        try {
            kon = getKon();
            kon.setAutoCommit(false);
            stmt = kon.createStatement();
            stmt.execute(sql);
            kon.commit();
        } catch (SQLException ex) {
            if (kon != null) {
                kon.rollback();
            }
            throw ex;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {}
            }
            zatvoriKonekciju();
        }
    }

    public void zatvoriKonekciju() throws SQLException {
        if (kon != null && !kon.isClosed()) {
            kon.close();
        }
    }

    public static String PathFromApp() {
        String path = null;
        try {
            path = new File(".").getCanonicalPath();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return path;
    }

    protected String escapeSql(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("'", "''");
    }
   
}
