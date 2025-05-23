/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.IModel;
import model.Szemely;

/**
 *
 * @author nagyg
 */
public class SzemelyekDialog extends javax.swing.JDialog {

    private java.awt.Frame parent;
    private IModel model;
    private List<Szemely> szemelyek;

    public SzemelyekDialog(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();
        this.parent = parent;//akkor kell ha ez a dialógus is fog egy újabb dialógust nyitni és ott is szükség lesz a Frame=szülőre
        this.model = model;

        setLocationRelativeTo(parent);//parent a Frame
        setTitle("Személyek nyílvántartása");

        listaFrissit();

    }

    public void listaFrissit() {
        try {
            szemelyek = model.getAllSzemely();//betöltjük az adatbázisból az adatokat
            lstSzemelyek.setListData(szemelyek.toArray(new Szemely[0]));//a listába beletesszük a szemelyeket tartalmazó listát, tömbbé alakítva

        } catch (SQLException ex) {
            Foablak.hibaAblak(ex.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstSzemelyek = new javax.swing.JList<>();
        btnUj = new javax.swing.JButton();
        btnModosit = new javax.swing.JButton();
        btnTorles = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstSzemelyek.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lstSzemelyek.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstSzemelyek);

        btnUj.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUj.setText("Új");
        btnUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjActionPerformed(evt);
            }
        });

        btnModosit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModosit.setText("Módosít");
        btnModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModositActionPerformed(evt);
            }
        });

        btnTorles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTorles.setText("Törlés");
        btnTorles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTorlesActionPerformed(evt);
            }
        });

        btnOk.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModosit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTorles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnModosit, btnOk, btnTorles, btnUj});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUj)
                        .addGap(18, 18, 18)
                        .addComponent(btnModosit)
                        .addGap(28, 28, 28)
                        .addComponent(btnTorles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnTorlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTorlesActionPerformed

        if (lstSzemelyek.isSelectionEmpty()) {
            Foablak.hibaAblak("Válassz ki egy személyt");
        } else {
            try {
                Szemely torolni = lstSzemelyek.getSelectedValue();//nullt ad vissza, ha nincs kiválasztva semmi, ezért van az eredetiben másképp
                Object[] options = {"Igen", "Nem"};
                int valasz = JOptionPane.showOptionDialog(parent, "Biztosan törölni akarod?", "Biztos",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (valasz == 0) {
                    if (model.getAllRendeles(torolni).isEmpty()) {
                        model.removeSzemely(torolni);
                        //vagy a listaFrissít helyett: lstSzemelyek.remove(lstSzemelyek.getSelectedIndex());megkeresi melyik indexű elem lett kiválasztva és csak azt a sort törli
                        listaFrissit();
                    } else {//van rendelés
                        Foablak.hibaAblak("Ennek a személynek van rendelése, ezért nem törölhető");
                    }
                }
            } catch (SQLException ex) {
                Foablak.hibaAblak(ex.toString());
            }
        }

    }//GEN-LAST:event_btnTorlesActionPerformed

    private void btnUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjActionPerformed
        SzemelyAdatokDialog szad = new SzemelyAdatokDialog(parent, true, null);
        szad.setVisible(true);
        if (szad.isMentes()) {
            Szemely szemely = szad.getSzemely();//elkérem a dialógustól a személyt, akit létrehozott, ezért csináltuk a gettert a SzaD-ban
            try {
                model.addSzemely(szemely);
                listaFrissit();
            } catch (SQLException ex) {
                Foablak.hibaAblak(ex.toString());
            }
        }

    }//GEN-LAST:event_btnUjActionPerformed

    private void btnModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModositActionPerformed
        Szemely kivalasztott = lstSzemelyek.getSelectedValue();
        if (kivalasztott != null) {
            SzemelyAdatokDialog szad = new SzemelyAdatokDialog(parent, true, kivalasztott);
            szad.setVisible(true);
            if (szad.isMentes()) {
                
                try {
                    //kivalasztott = szad.getSzemely(); felesleges
                    model.updateSzemely(kivalasztott);
                    listaFrissit();
                } catch (SQLException ex) {
                    Foablak.hibaAblak(ex.toString());
                }
            }
        } else {
            Foablak.hibaAblak("A módosításhoz válassz ki egy személyt!");
        }
    }//GEN-LAST:event_btnModositActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModosit;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnTorles;
    private javax.swing.JButton btnUj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Szemely> lstSzemelyek;
    // End of variables declaration//GEN-END:variables
}
