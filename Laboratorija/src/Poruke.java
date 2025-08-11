package GUI.korisnik;


import javax.swing.JOptionPane;
import java.awt.Component;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Korisnik
 */
public class Poruke {
    
    public static void greska(Component p, String msg) {
        JOptionPane.showMessageDialog(p, "Greška: " + msg, "Prijava", JOptionPane.ERROR_MESSAGE);
    }

    public static void uspjeh(Component p, String msg) {
        JOptionPane.showMessageDialog(p, msg, "Prijava", JOptionPane.INFORMATION_MESSAGE);
    }
}
