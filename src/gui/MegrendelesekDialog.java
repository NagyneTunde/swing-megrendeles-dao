/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.IModel;
import model.Rendeles;
import model.Szemely;

/**
 *
 * @author nagyg
 */
public class MegrendelesekDialog extends javax.swing.JDialog implements TableModelListener {

    private IModel model;
    private java.awt.Frame parent;
    private List<Szemely> szemelyek;
    private List<Rendeles> rendelesek;
    private DefaultTableModel dtm;// a táblázatnak is van egy adattároló modelje, csak ez két dimenziós

    public MegrendelesekDialog(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();
        this.model = model;
        this.parent = parent;

        //az is a modelben van, h milyen adat van benne: dataVector, ebben vannak,a dataVectorban ujabb vectorok vannak
        dtm = (DefaultTableModel) tblRendelesek.getModel();//elkérem a táblázat modeljét, kasztolni kell def..-re
        dtm.addTableModelListener(this);//ha bármi változik a táblázatban, akkor a model meg fogja hívni a tableChanged metódusát, this = MegrendelesekDialog

        setLocationRelativeTo(parent);
        setTitle("Megrendelések kezelése");
        try {
            szemelyek = model.getAllSzemely();//lekérem sz összes személyt

            //ehelyett a kettő helyett:
            //cbMegrendelo.removeAllItems();//ez kitöröl mindent ami volt benne
            // for (Szemely sz : szemelyek) {//végig megyek a személyeken és egyesével hozzáadom a cbMegrendelőkhöz, de nem törli ki a már benne lévő elemeket, hanem csak hozzáadogat újakat
            //     cbMegrendelo.addItem(sz);//ehhez át kellett állítani a Code: ParameterType-nál kitörölni és üresen hagyni objectre
            // }
            //ez:
            //setModel: beállítja neki a modelt, hogy én milyen modelt akarok h használjon
            //itt EGYSZERRE beletöltök több adatot: DefaultComboBoxModel: ez egy osztály, aminek egy object tömböt vagy egy vectort adhatok meg, mint a listánál a setlistdata-nak
            //a személyek listából tömböt csinálok toArray-el(igy, mert most object van beállítva a parameterTypenál)
            //itt nem kell a remove, mert ez egy új=new modelt hoz létre, lecserél mindent
            cbMegrendelo.setModel(new DefaultComboBoxModel(szemelyek.toArray()));
            btnOsszes.doClick();//csinál egy kattintást az összes gombra, ehelyett meghívhatnám a btnOsszes metódust is, ugyanaz
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
        tblRendelesek = new javax.swing.JTable();
        btnUj = new javax.swing.JButton();
        btnModosit = new javax.swing.JButton();
        btnTorol = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbMegrendelo = new javax.swing.JComboBox();
        btnOsszes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblRendelesek.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblRendelesek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Megrendelő", "Osszeg", "Darabszám", "Teljesítve"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRendelesek);

        btnUj.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUj.setText("Új");
        btnUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjActionPerformed(evt);
            }
        });

        btnModosit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModosit.setText("Módosít");
        btnModosit.setEnabled(false);

        btnTorol.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTorol.setText("Töröl");
        btnTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTorolActionPerformed(evt);
            }
        });

        btnOk.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Megrendelő:");

        cbMegrendelo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbMegrendelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMegrendelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMegrendeloActionPerformed(evt);
            }
        });

        btnOsszes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOsszes.setText("Összes");
        btnOsszes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsszesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMegrendelo, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUj)
                    .addComponent(btnModosit)
                    .addComponent(btnTorol)
                    .addComponent(btnOk))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnModosit, btnOk, btnTorol, btnUj});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMegrendelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOsszes))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUj)
                        .addGap(31, 31, 31)
                        .addComponent(btnModosit)
                        .addGap(45, 45, 45)
                        .addComponent(btnTorol)
                        .addGap(190, 190, 190)
                        .addComponent(btnOk)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsszesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsszesActionPerformed
        cbMegrendelo.setSelectedIndex(-1);//megcsinálja,hogy ne legyen senki kiválasztva
        try {
            rendelesek = model.getAllRendeles();//lekéri az összes rendelést
            tablaFrissit();//a rendelések listából töltse fel a táblázatot az aktuális adatokkal
        } catch (SQLException ex) {
            Foablak.hibaAblak(ex.toString());
        }
    }//GEN-LAST:event_btnOsszesActionPerformed

    private void btnTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTorolActionPerformed
        int sor = tblRendelesek.getSelectedRow();//egy intben megkapjuk, hogy melyik sor van kiválasztva, ezt elmentjük egy sor nevű változóba
        //rendelés törléséhez nincs semmiylen feltételünk, mint pl a személyeket csak akkor lehet törölni, ha nincs ohzzá rendelés
        if (sor > -1) {//tehát ha van kiválasztott sor
            //akkor ekérjük az annyiadik rendelést a rendelések listánkból
            Rendeles kivalasztott = rendelesek.get(sor);//a rendelések lista pont szinkronban van a táblázatunkkal, mert a táblafrissítben azon mentünk végig és raktuk bele  
            Object[] valaszok = {"Igen", "Nem"};
            int valasz = JOptionPane.showOptionDialog(parent, "Biztosan törölni szeretnéd?",
                    "Biztos?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, valaszok, valaszok[1]);
            if (valasz == JOptionPane.YES_OPTION) {
                try {
                    //ha igent nyomott akkor töröljük
                    model.removeRendeles(kivalasztott);//ez az adatbázisból törli
                    rendelesek.remove(sor);//a rendelések listből kitörlöm a soradik elemet
                    tablaFrissit();
                } catch (SQLException ex) {
                    Foablak.hibaAblak(ex.toString());
                }
            }
        } else {
            Foablak.hibaAblak("Válassz ki egy sort");
        }


    }//GEN-LAST:event_btnTorolActionPerformed

    private void cbMegrendeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMegrendeloActionPerformed
        if (cbMegrendelo.getSelectedItem() != null) {//ha a megrendelő ki van választva, tehát nem null
            Szemely szemely = (Szemely) cbMegrendelo.getSelectedItem();// akkor belementem egy szeméyl objetbe
            try {
                rendelesek = model.getAllRendeles(szemely);//ennek a személynek lekérem a megrendeléseit, és azt belementem a rendelesek listába

                //vagy ez
//                dtm.getDataVector().clear();//kitörlöm a tábla adatait
//                for (Rendeles r : rendelesek) {//újra feltöltöm a mostani rendelesek listával
//                    
//                    Vector sor = new Vector();
//                    sor.add(r.getRendeloId());
//                    sor.add(r.getOsszeg());
//                    sor.add(r.getDarabszam());
//                    sor.add(r.isTeljesitve());
//                    dtm.addRow(sor);
//                }
                //vagy ahogy már megírtuk a tábla frissítet csak meghívjuk
                tablaFrissit();
            } catch (SQLException ex) {
                Foablak.hibaAblak(ex.toString());
            }

        }
        //else{//ha meg null, tehát nincs kiválasztva semmi, akkor az összes megrendelést írja ki
        //de ez az összesben benne van, ide is át lehetne tenni de most felesleges, csak dupláznánk
        //}
    }//GEN-LAST:event_cbMegrendeloActionPerformed

    private void btnUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjActionPerformed
        Szemely kivalasztott = (Szemely) cbMegrendelo.getSelectedItem();//először el kell kérnem a kiválasztottat, aztán tudom átadni a madnak
        MegrendelesAdatokDialog mad = new MegrendelesAdatokDialog(parent, szemelyek, kivalasztott);
        mad.setVisible(true);

        if (mad.isMentes()) {
            Rendeles rendeles = mad.getRendeles();
            try {
                model.addRendeles(rendeles);//hozzáadjuk az adatbázishoz, itt kapott id-t
                //majd bele kell tenni a rendelesek listába, visszaolvasom az összes rendelést, frissítjük 
                if (kivalasztott != null) {
                    rendelesek = model.getAllRendeles(kivalasztott);
                } else {
                    rendelesek = model.getAllRendeles();
                }
                tablaFrissit();
            } catch (SQLException ex) {
                Foablak.hibaAblak(ex.toString());
            }

        }

    }//GEN-LAST:event_btnUjActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void tablaFrissit() {//megnézi h mi van a rendelesek listában, és annak az adatait betölti a táblázatba
        //dtm: a táblázatunknak a modelje
        //getDataVector:elkérem az adatokat
        //clear-el kitörlöm az adatait
        dtm.getDataVector().clear();//először kitörlöm az összes elemet
        //ha olyan megrendelő van, h nincsenek rendelései, a rendelések üres, akkor is frissíteni kell a táblát
        dtm.fireTableDataChanged();//értesítjük a táblát arról, h változott az adathalmaza, a model alatta, tehát akkor is frissít
        for (Rendeles r : rendelesek) {//végig megyek a rendeléseken 
            //és minden egyes rendelésből egy sort csinálok
            Vector sor = new Vector();//csinálok egy vectort ami objecteket tartalmaz = Vector<Object> sor...
            Szemely szemely;
            try {
                //ilyen sorrendben lesznek az oszlopok
                szemely = model.getSzemelyByID(r.getRendeloId());//DBModelben megnéztük, null-t ad vissza, ha nincs ilyen személy
                if (szemely != null) {
                    sor.add(szemely.getNev());
                } else {
                    sor.add("Nincs ilyen személy");
                }

                //sor.add(r.getRendeloId());
                sor.add(r.getOsszeg());
                sor.add(r.getDarabszam());
                sor.add(r.isTeljesitve());//ez eddig egy sor
                dtm.addRow(sor);//hozzáadom a táblázathoz
            } catch (SQLException ex) {
                Foablak.hibaAblak(ex.toString());
            }
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModosit;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnOsszes;
    private javax.swing.JButton btnTorol;
    private javax.swing.JButton btnUj;
    private javax.swing.JComboBox cbMegrendelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRendelesek;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {//ez a metódus fog majd lefutni, ha bármi változik a táblázatban
        //a TableModelEvent amit kapunk, ebből az e-ből tudjuk kiszedni, hogyha bármi változott a táblázatban
        int sor = e.getFirstRow();//elkérjük, h melyik sor változott
        int oszlop = e.getColumn();//elkérjük, h melyik oszlop változott
        if (sor >= 0 && oszlop >= 0 && e.getType() == TableModelEvent.UPDATE) {//mert a -1 is lehet, több tipusú változás is történhetett: insert:1, update:0, delete:-1, mert intet ad vissza a type
        Object ujErtek = dtm.getValueAt(sor, oszlop);//a dtm modeltől kérem a sor és oszlop értéket, azért objectben, mert lehet int vagy boolean v String is. a getValueAt is objectet táárol, később kasztoljuk
        
        Rendeles rendeles = rendelesek.get(sor);//elkérem a rendelést a listából, amelyik sorban dolgozunk
        //megnézem melyik oszlop
         switch (oszlop) {
                case 1:
                    rendeles.setOsszeg((int) ujErtek);//itt kasztolom
                    break;
                case 2:
                    rendeles.setDarabszam((int) ujErtek);
                    break;
                case 3:
                    rendeles.setTeljesitve((boolean) ujErtek);
                    break;
            }
            try {
                model.updateRendeles(rendeles);
            } catch (SQLException ex) {
               Foablak.hibaAblak(ex.toString());
            }
        
        }
    }
}
