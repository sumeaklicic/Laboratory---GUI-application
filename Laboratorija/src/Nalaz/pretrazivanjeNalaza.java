/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Nalaz;

import OsnovneKlase.Nalaz;
import com.sun.jdi.connect.spi.Connection;
import database.Kontroler;
import database.NalazKontroler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class pretrazivanjeNalaza extends javax.swing.JInternalFrame {

        public pretrazivanjeNalaza() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(230, 245, 255));
        setClosable(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{},
        new String[]{"ID", "Pacijent_ID", "Datum", "Naziv"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 2 || column == 3;
        }
    });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Unesite naziv nalaza kojeg pretrazujete");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TRAZI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Pacijent_ID", "Datum", "Naziv"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("AŽURIRANJE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PREGLED PRETRAGA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                       
    String uneseniNaziv = jTextField1.getText().trim();
    
    if (uneseniNaziv.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Unesite naziv nalaza kojeg trazite.");
        return;
    }

    NalazKontroler nalazKontroler = new NalazKontroler();
    String upit = "SELECT * FROM Nalaz WHERE naziv = ?";

    try (java.sql.Connection conn = nalazKontroler.getKon();
         java.sql.PreparedStatement ps = conn.prepareStatement(upit)) {
        
        ps.setString(1, uneseniNaziv);
        java.sql.ResultSet rs = ps.executeQuery();

        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object[]{"ID", "Pacijent_ID", "Datum", "Naziv"}, 0
        );

        boolean pronadjen = false;
        while (rs.next()) {
            pronadjen = true;
            int id = rs.getInt("id");
            int pacijentId = rs.getInt("pacijent_id");
            String datum = rs.getString("datum");
            String naziv = rs.getString("naziv");

            model.addRow(new Object[]{id, pacijentId, datum, naziv});
        }

        if (!pronadjen) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nijedan nalaz sa tim nazivom nije pronađen.");
        }

        tabela.setModel(model);

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Greška pri pretrazi: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    int selectedRow = tabela.getSelectedRow();
    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Odaberite red koji želite ažurirati.");
        return;
    }

    try {
        int id = Integer.parseInt(tabela.getValueAt(selectedRow, 0).toString());
        String datum = tabela.getValueAt(selectedRow, 2).toString().trim();
        String naziv = tabela.getValueAt(selectedRow, 3).toString().trim();

        NalazKontroler kontroler = new NalazKontroler();
        kontroler.azurirajNalaz(id, naziv, datum);

        javax.swing.JOptionPane.showMessageDialog(this, "Nalaz je uspješno ažuriran.");

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Greška prilikom ažuriranja nalaza.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
        int selectedRow = tabela.getSelectedRow();

       if (selectedRow == -1) {
           javax.swing.JOptionPane.showMessageDialog(this, "Kliknite na red iz kojeg zelite odabrati nalaz.");
           return;
       }

       int nalazId = (int) tabela.getValueAt(selectedRow, 0);

       try {
           java.sql.Connection conn = new NalazKontroler().getKon();
           String sql = "SELECT Pretraga.naziv, Nalaz_Pretraga.IzmjereneVrijednosti FROM Pretraga " +
                        "INNER JOIN Nalaz_Pretraga ON Pretraga.naziv = Nalaz_Pretraga.Pretraga_ID " +
                        "WHERE Nalaz_Pretraga.Nalaza_ID = ?";
           java.sql.PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, nalazId);

           java.sql.ResultSet rs = ps.executeQuery();
           StringBuilder poruka = new StringBuilder();

           while (rs.next()) {
               String naziv = rs.getString("naziv");
               double izmjerena = rs.getDouble("IzmjereneVrijednosti");
               poruka.append("- ").append(naziv).append(": ").append(izmjerena).append("\n");
           }

           if (poruka.length() == 0) {
               poruka.append("Nema pretraga za odabrani nalaz.");
           }

           javax.swing.JOptionPane.showMessageDialog(this, poruka.toString(), "Pretrage nalaza", javax.swing.JOptionPane.INFORMATION_MESSAGE);

           rs.close();
           ps.close();
           conn.close();

       } catch (Exception e) {
           e.printStackTrace();
           javax.swing.JOptionPane.showMessageDialog(this, "Greška: " + e.getMessage());
       }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
