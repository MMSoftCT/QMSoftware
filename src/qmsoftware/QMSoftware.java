/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmsoftware;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author micim
 */
public class QMSoftware extends javax.swing.JPanel
{

    // Variables definition
    private javax.swing.JButton btnClose;           // Dialog close Button
    private javax.swing.JButton btnDlgOpen;         // Dialog open Button
    private javax.swing.JComboBox<String> cobDozent;// Auswahl Dozent
    private javax.swing.JComboBox<String> cobModul; // Auswahl Modul
    private javax.swing.JDialog dlgOverview;        // Dialog wit rating table
    private javax.swing.JScrollPane spTable;        // Container für die Tabelle
    private javax.swing.JScrollPane spDlgTable;   // Container for Dialog Table
    private javax.swing.JLabel lblBewertungen;      // Label "Bewertungen"
    private javax.swing.JLabel lblDozent;           // Label "Dozent"
    private javax.swing.JLabel lblModul;            // Label "Modul"
    private javax.swing.JLabel lblNote;             // Label "Note Durchschnitt"
    private javax.swing.JLabel lblNote5_6;          // Label "Note 5 oder 6"
    private javax.swing.JTable tblOverview;         // Table with ratings
    private javax.swing.JTable tblWertung;          // Tabelle der Fragen über Dozenten
    private javax.swing.JLabel txtDlgTitel;         // Dialog title
    private javax.swing.JLabel txtBewertungen;      // Anzahl der Bewertungen
    private javax.swing.JLabel txtNote;             // Ergebnis Note Durchschnitt
    private javax.swing.JLabel txtNote5_6;          // Ergebnis aus Note 5 oder 6
    private javax.swing.JLabel txtPruefen;          // Ergebnis ob Dozent geprüft werden muss
    private javax.swing.JLabel txtTitel;            // Überschrift

    private DefaultTableCellRenderer cellNote;      // Renderer for 3rd table column
    private DefaultTableCellRenderer center;        // Renderer centerd black column
    private DozArray doz;                           // ArrayList of teacher
    private ArrayList<String> dozList;              // Array for cobDoz
    private StringArray modList;                    // Array for cobMod

    public QMSoftware()
    {
        doz = new DozArray();
        dozList = new ArrayList<String>();
        modList = new StringArray();
        cellNote = new DefaultTableCellRenderer();
        cellNote.setHorizontalAlignment(JLabel.RIGHT);
        center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        String[] mod;

        // load data and fill objects
        loadData();

        initComponents();

        // create String[] for cobModul
        mod = new String[modList.toArray().length];
        modList.toArray(mod);

        // fill ComboBoxes
        cobModul.setModel(new javax.swing.DefaultComboBoxModel<>(mod));
        cobModul.setSelectedIndex(0);
        setCobList(0);
        cobDozent.setSelectedIndex(0);
        fillTable();
    }

    /**
     * initialize all graphical objects
     */
    private void initComponents()
    {
        dlgOverview = new javax.swing.JDialog();
        txtDlgTitel = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        spDlgTable = new javax.swing.JScrollPane();
        
        tblOverview = new javax.swing.JTable()
        {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col)
            {
                Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, col);
                if (col > 0 && (value.equals(5) || value.equals(6)))
                {
                    comp.setForeground(Color.white);
                    comp.setBackground(Color.red);
                } else
                {
                    comp.setForeground(Color.black);
                    comp.setBackground(Color.white);
                }
                return comp;
            }

        };
        
        txtTitel = new javax.swing.JLabel();
        lblDozent = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        txtNote = new javax.swing.JLabel();
        lblModul = new javax.swing.JLabel();
        lblNote5_6 = new javax.swing.JLabel();
        txtNote5_6 = new javax.swing.JLabel();
        txtPruefen = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblWertung = new javax.swing.JTable();
        cobDozent = new javax.swing.JComboBox<>();
        cobModul = new javax.swing.JComboBox<>();
        lblBewertungen = new javax.swing.JLabel();
        txtBewertungen = new javax.swing.JLabel();
        btnDlgOpen = new javax.swing.JButton();

        // Overview dialog objects
        
        dlgOverview.setTitle("Bewertungen");
        dlgOverview.setMinimumSize(new java.awt.Dimension(700, 360));
        dlgOverview.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        dlgOverview.setPreferredSize(new java.awt.Dimension(700, 360));
        dlgOverview.setResizable(false);
        dlgOverview.setSize(new java.awt.Dimension(700, 360));

        txtDlgTitel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtDlgTitel.setText("Bewertungs Übersicht");

        btnClose.setText("Schließen");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });

        tblOverview.setAutoCreateRowSorter(true);
        tblOverview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String []
            {
                "Nr", "Fachliche Kompetenz", "Pädagogische Kompetenz", "Verständlichkeit", "Vorbereitung", "Hilfsbereitschaft"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, true, true
            };

            @Override
            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblOverview.setPreferredSize(new java.awt.Dimension(700, 315));
        tblOverview.getTableHeader().setFont(new java.awt.Font("Dialog", 1, 12));
        tblOverview.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblOverview.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblOverview.getColumnModel().getColumn(1).setCellRenderer(center);
        tblOverview.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblOverview.getColumnModel().getColumn(2).setCellRenderer(center);
        tblOverview.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblOverview.getColumnModel().getColumn(3).setCellRenderer(center);
        tblOverview.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblOverview.getColumnModel().getColumn(4).setCellRenderer(center);
        tblOverview.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblOverview.getColumnModel().getColumn(5).setCellRenderer(center);
        spDlgTable.setViewportView(tblOverview);

        javax.swing.GroupLayout dlgOverviewLayout = new javax.swing.GroupLayout(dlgOverview.getContentPane());
        dlgOverview.getContentPane().setLayout(dlgOverviewLayout);
        dlgOverviewLayout.setHorizontalGroup(
            dlgOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgOverviewLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(309, 309, 309))
            .addGroup(dlgOverviewLayout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(txtDlgTitel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dlgOverviewLayout.createSequentialGroup()
                .addComponent(spDlgTable, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgOverviewLayout.setVerticalGroup(
            dlgOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgOverviewLayout.createSequentialGroup()
                .addComponent(txtDlgTitel)
                .addGap(12, 12, 12)
                .addComponent(spDlgTable, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose))
        );

        // Main window objects
        
        txtTitel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTitel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitel.setText("QM-Auswertung");

        lblDozent.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDozent.setText("Dozent");

        lblNote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNote.setText("Note Ø");

        txtNote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNote.setText("2");

        lblModul.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblModul.setText("Modul");

        lblNote5_6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNote5_6.setText("Note 5/6");

        txtNote5_6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtNote5_6.setForeground(new java.awt.Color(255, 0, 0));
        txtNote5_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNote5_6.setText("ja oder nein");

        txtPruefen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtPruefen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPruefen.setText("Dozent muss/muss nicht geprüft werden!");

        tblWertung.setAutoCreateRowSorter(true);
        tblWertung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                { 1, "Fachliche Kompetenz", null},
                { 2, "Pädagogische Kompetenz", null},
                { 3, "Lernstoff Vermittlung", null},
                { 4, "Unterrichtsvorbereitung", null},
                { 5, "Hilfsbereitschaft", null}
            },
            new String []
            {
                "Nr.", "Kriterium", "Note"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblWertung.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblWertung.getTableHeader().setFont(new java.awt.Font("Dialog", 1, 12));
        tblWertung.getColumnModel().getColumn(0).setPreferredWidth(25);
        tblWertung.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblWertung.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblWertung.getColumnModel().getColumn(2).setCellRenderer(cellNote);
        spTable.setViewportView(tblWertung);

        cobDozent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        // EventListener for Dozent
        cobDozent.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent evt)
            {
                if (evt.getStateChange() == ItemEvent.SELECTED)
                {
                    fillTable();
                }
            }
        });

        cobModul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        // EventListener for Modules
        cobModul.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent evt)
            {
                JComboBox cb = (JComboBox) evt.getSource();

                if (evt.getStateChange() == ItemEvent.SELECTED)
                {
                    setCobList(cb.getSelectedIndex());
                    cobDozent.setSelectedIndex(0);
                    fillTable();
                }
            }
        });

        lblBewertungen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBewertungen.setText("Bewertungen");

        txtBewertungen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBewertungen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBewertungen.setText("20");

        btnDlgOpen.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDlgOpen.setText("Bewertungs Übersicht");
        btnDlgOpen.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDlgOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBewertungen)
                        .addGap(18, 18, 18)
                        .addComponent(txtBewertungen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblModul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDozent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDlgOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(cobDozent, 0, 320, Short.MAX_VALUE)
                            .addComponent(cobModul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNote5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNote5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(txtPruefen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(txtTitel, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cobModul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDozent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cobDozent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDlgOpen))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNote5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNote5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBewertungen)
                            .addComponent(txtBewertungen))))
                .addGap(28, 28, 28)
                .addComponent(txtPruefen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }
    
    // Action methodes
    /**
     * close the overview dialog
     * @param evt 
     */
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt)                                         
    {                                             
        dlgOverview.setVisible(false);
    }                                        

    /**
     * open the overview dialog
     * @param evt 
     */
    private void btnDlgOpenActionPerformed(java.awt.event.ActionEvent evt)                                           
    {                                               
        
        dlgOverview.setLocationRelativeTo(null);
        //dlgOverview.setSize(700,360);
        dlgOverview.setVisible(true);
    }                                          
    
    // Class methodes
    /**
     * load data and create all needed objects
     */
    private void loadData()
    {
        ArrayList<String[]> data = new ArrayList<String[]>();
        Dozent cur = new Dozent();
        CSVReader reader = new CSVReader("rating.csv", ";", false);

        if (reader.ReadFile())
        {
            data = reader.getData();
            for (int i = 0; i < data.size(); i++)
            {
                String[] rate = data.get(i);
                if (doz.contains(rate[0]))
                {
                    cur = doz.get(rate[0]);
                } else
                {
                    cur = new Dozent(rate[0]);
                }
                if (cur != null)
                {
                    Bewertung bew = new Bewertung();
                    bew.setModul(rate[1]);
                    bew.setFKompetenz(Integer.parseInt(rate[2]));
                    bew.setPKompetenz(Integer.parseInt(rate[3]));
                    bew.setVerstaendlich(Integer.parseInt(rate[4]));
                    bew.setVorbereitet(Integer.parseInt(rate[5]));
                    bew.setProblem(Integer.parseInt(rate[6]));
                    cur.addBewertung(bew);
                    if (!modList.contains(rate[1]))
                    {
                        modList.add(rate[1]);
                    }
                }
                int idx = doz.indexOf(rate[0]);
                if (idx != -1)
                {
                    doz.set(idx, cur);
                } else
                {
                    doz.add(cur);
                }
            }
        }
    }

    /**
     * create the lis of teachers who are able to teach the modul at the index
     *
     * @param idx int
     */
    private void setCobList(int idx)
    {
        String[] names = new String[doz.getDozenten(modList.get(idx)).toArray().length];
        doz.getDozenten(modList.get(idx)).toArray(names);
        cobDozent.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }

    /**
     * set output parameters and fill the data table
     */
    private void fillTable()
    {
        String name = (String) cobDozent.getSelectedItem();
        String mod = (String) cobModul.getSelectedItem();

        Dozent d = doz.get(name);

        int ratCount = d.rateCount(mod);        // total count of ratings
        int badCount = d.badRate(mod);          // total count of bad ratings > 4
        double avgFK = d.avgFKompetenz(mod);
        double avgPK = d.avgPKompetenz(mod);
        double avgVE = d.avgVerstaendlich(mod);
        double avgV = d.avgVorbereitet(mod);
        double avgP = d.avgProblem(mod);
        // overall averge
        double ratAvg = (avgFK + avgPK + avgVE + avgV + avgP) / 5;

        // update text output
        txtBewertungen.setText(String.valueOf(ratCount));
        txtNote.setText(String.valueOf(ratAvg));
        txtNote5_6.setText(String.valueOf(badCount));

        if(badCount > 0)
        {
            txtPruefen.setText("Dozent muss überprüft werden !");
            txtPruefen.setForeground(new java.awt.Color(255, 0, 0));
        }
        else
        {
            txtPruefen.setText("Dozent muss nicht überprüft werden.");
            txtPruefen.setForeground(new java.awt.Color(0, 0, 0));
        }

        // update table
        tblWertung.setValueAt(String.valueOf(avgFK), 0, 2);
        tblWertung.tableChanged(new TableModelEvent(tblWertung.getModel(), 0));
        tblWertung.setValueAt(String.valueOf(avgPK), 1, 2);
        tblWertung.tableChanged(new TableModelEvent(tblWertung.getModel(), 1));
        tblWertung.setValueAt(String.valueOf(avgVE), 2, 2);
        tblWertung.tableChanged(new TableModelEvent(tblWertung.getModel(), 2));
        tblWertung.setValueAt(String.valueOf(avgV), 3, 2);
        tblWertung.tableChanged(new TableModelEvent(tblWertung.getModel(), 3));
        tblWertung.setValueAt(String.valueOf(avgP), 4, 2);
        tblWertung.tableChanged(new TableModelEvent(tblWertung.getModel(), 4));

        ArrayList<Bewertung> b = d.getBewertung(mod);
      
        for (int i = 0; i < b.size(); i++)
        {
            tblOverview.setValueAt(i+1, i, 0);
            tblOverview.setValueAt(b.get(i).getFKompetenz(), i, 1);
            tblOverview.setValueAt(b.get(i).getPKompetenz(), i, 2);
            tblOverview.setValueAt(b.get(i).getVerstaendlich(), i, 3);
            tblOverview.setValueAt(b.get(i).getVorbereitet(), i, 4);
            tblOverview.setValueAt(b.get(i).getProblem(), i, 5);
            tblOverview.tableChanged(new TableModelEvent(tblOverview.getModel(), i));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFrame grundgerüst = new JFrame("QM Auswertung");
        grundgerüst.add(new QMSoftware());

        grundgerüst.pack(); //grundgerüst.setSize(600,400); //button1.setBounds(10, 10, 100, 50);
        grundgerüst.setLocationRelativeTo(null); // zentriert das Fenster
        grundgerüst.setResizable(false);
        grundgerüst.setVisible(true); //Fenster wird sichtbar
        grundgerüst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Anwendung wird beim Schliesen des Fensters beendet
    }
}
