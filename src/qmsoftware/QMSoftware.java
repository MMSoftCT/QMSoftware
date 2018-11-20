/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmsoftware;

import javax.swing.JFrame;

/**
 *
 * @author micim
 */
public class QMSoftware extends javax.swing.JPanel 
{
    public QMSoftware () 
    {
        initComponents();
    }

    private void initComponents() 
    {
        jLabel1 = new javax.swing.JLabel();                         // Überschrift
        jLabel2 = new javax.swing.JLabel();                         // Label "Dozent"
        choice1 = new java.awt.Choice();                            // Auswahl von Dozenten
        jLabel3 = new javax.swing.JLabel();                         // Label "Note Durchschnitt"
        jLabel4 = new javax.swing.JLabel();                         // Ergebnis Note Durchschnitt
        jLabel5 = new javax.swing.JLabel();                         // Label "Modul"
        choice2 = new java.awt.Choice();                            // Auswahl von Modulen
        jButton1 = new javax.swing.JButton();                       // Auswertung starten nach Eingabe von Dozent und Modul
        jLabel6 = new javax.swing.JLabel();                         // Label "Note 5 oder 6"
        jLabel7 = new javax.swing.JLabel();                         // Ergebnis aus Note 5 oder 6
        jLabel8 = new javax.swing.JLabel();                         // Ergebnis ob Dozent geprüft werden muss
        jScrollPane3 = new javax.swing.JScrollPane();               
        jTable2 = new javax.swing.JTable();                         // Tabelle der Fragen über Dozenten
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();                         // Ergebnisnoten aus den Fragen

        
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QM-Auswertung");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jLabel2.setText("Dozent");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jLabel3.setText("Note Ø");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("2");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jLabel5.setText("Modul");

        jButton1.setText("Auswertung Starten");
        
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jLabel6.setText("Note 5/6");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ja oder nein");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dozent muss/muss nicht geprüft werden!");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Fachliche Kompetenz"},
                {"Pädagogische Kompetenz"},
                {"Lernstoff Vermittlung"},
                {"Unterrichtsvorbereitung"},
                {"Hilfsbereitschaft"}
            },
            new String [] {
                "Kriterium"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Note"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        
        layout.setHorizontalGroup
        (
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGap(32, 32, 32)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
            .addGap(200, 200, 200)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup
        (
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(28, 28, 28)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(23, Short.MAX_VALUE))
        );
    }                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        // TODO add your handling code here:
    }                     
    
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;   
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        JFrame grundgerüst = new JFrame("QM Auswertung");
        grundgerüst.add(new QMSoftware());
               
        grundgerüst.pack(); //grundgerüst.setSize(600,400); //button1.setBounds(10, 10, 100, 50);
        grundgerüst.setLocationRelativeTo(null); // zentriert das Fenster
        grundgerüst.setVisible(true); //Fenster wird sichtbar
        grundgerüst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Anwendung wird beim Schliesen des Fensters beendet
    } 
}

