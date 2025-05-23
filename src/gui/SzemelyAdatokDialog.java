/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.Szemely;

/**
 *
 * @author nagyg
 */
public class SzemelyAdatokDialog extends javax.swing.JDialog {

    private Szemely szemely;
     private boolean mentes;
    
    public SzemelyAdatokDialog(java.awt.Frame parent, boolean modal, Szemely kivalasztott) {
        super(parent, modal);
        initComponents();
        mentes = false;
        this.szemely = kivalasztott;
        setLocationRelativeTo(parent);
        if(szemely==null){
           setTitle("Új személy felvétele"); 
        }else{
            setTitle("Személy módosítása");
            tfNev.setText(szemely.getNev());
            tfEmail.setText(szemely.getEmail());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNev = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        btnMegsem = new javax.swing.JButton();
        btnMentes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Név:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Email:");

        tfNev.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tfEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnMegsem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMegsem.setText("Mégsem");
        btnMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMegsemActionPerformed(evt);
            }
        });

        btnMentes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMentes.setText("Mentés");
        btnMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMentesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMegsem)
                        .addGap(56, 56, 56)
                        .addComponent(btnMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfNev)
                        .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMegsem, btnMentes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMegsem)
                    .addComponent(btnMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, tfEmail, tfNev});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMegsem, btnMentes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMegsemActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnMegsemActionPerformed

    private void btnMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMentesActionPerformed
       if(szemely == null){//ha nincs még az a személy akit létre akar hozni/ha módosítás lesz akkor lesz szemely objectum már
           szemely = new Szemely();//létre hozok egy új személy objektumot
       }
        szemely.setNev(tfNev.getText());
        szemely.setEmail(tfEmail.getText());
        mentes = true;
        setVisible(false);
    }//GEN-LAST:event_btnMentesActionPerformed

    public boolean isMentes() {
        return mentes;
    }

    
    public Szemely getSzemely() {
        return szemely;
    }

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMegsem;
    private javax.swing.JButton btnMentes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNev;
    // End of variables declaration//GEN-END:variables
}
