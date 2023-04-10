
package Vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import photousac.Cola;
import photousac.NodoDoble;
import photousac.NodoS;
import photousac.PhotoUsac;


/**
 *
 * @author telma
 */
public class JFEditor extends javax.swing.JFrame {

    /**
     * Creates new form JFEditor
     */
    public JFEditor() {
        initComponents();
        mostrar();
        jComboBox2.removeAllItems();
        mostrar2();
        jList1.removeAll();
        mostrar3();
    }

    public void mostrar() {
        photousac.PhotoUsac.ListaGeneral.rellenarComboConductores(jComboBox1);
    }

    public void mostrar2() {
        try {
            ((NodoS) PhotoUsac.ListaGeneral.find(jComboBox1.getSelectedItem().toString())).categoria.listar2(jComboBox2);
        } catch (Exception e) {
        }

    }

    public void mostrar3() {
        try {
            ((NodoDoble) ((NodoS) PhotoUsac.ListaGeneral.find(jComboBox1.getSelectedItem().toString())).categoria.find(jComboBox2.getSelectedItem().toString())).Imagenes.listar(jList1);

        } catch (Exception e) {
        }

    }
    
    public class Paraleo extends Thread{
        Cola temp;
        public Paraleo(Cola p){
        this.temp =  p;
        
        }
        @Override
        public void run(){
        if (chkjpegtobmp.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGTOBMP();
                jTextField1.setText("-----------"+"Conversion finalizada JPEG TO BMP"+"----------"+"\\n");
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        if (chkmbptojpeg.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.BMPTOJPEG();
                 jTextField1.setText("-----------"+"Conversion finalizada BMP TO JPEG"+"----------"+"\\n");
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (chkjpegcopy.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGCOPY();
                 jTextField1.setText("-----------"+"COPIA FINALIZADA "+"----------"+"\\n");
                 
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (chkcolors.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGCOLORS();
                 jTextField1.setText("-----------"+"ROJO, VERDE, AZUL y SEPHIA GENERADAS "+"----------"+"\\n");
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (chkrotar.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGROTED();
                
                 jTextField1.setText("-----------"+"Imagen rotada Vertil Horizontal "+"----------"+"\\n");
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (chkblanconegro.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEBW();
                 jTextField1.setText("-----------"+"Imagen blanco y negro finalizada"+"----------"+"\\n");
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        PhotoUsac.ConversorC.deleteall();
        
        jTextField1.setText("-------PROCESO FINALIZAO--------");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        chkjpegtobmp = new javax.swing.JCheckBox();
        chkmbptojpeg = new javax.swing.JCheckBox();
        chkjpegcopy = new javax.swing.JCheckBox();
        chkcolors = new javax.swing.JCheckBox();
        chkrotar = new javax.swing.JCheckBox();
        chkblanconegro = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria");

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jButton1.setText("Agregar");

        jScrollPane1.setViewportView(jList1);

        jLabel3.setText("Cola de  Procesamiento");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        chkjpegtobmp.setText("JPEG TO BMP");

        chkmbptojpeg.setText("BMP to JPEG");

        chkjpegcopy.setText("COPY JPEG");

        chkcolors.setText("ROJO, VERDE, AZUL, Sephia");

        chkrotar.setText("Rotar");

        chkblanconegro.setText("Blanco y Negro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkblanconegro)
                    .addComponent(chkrotar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(chkcolors)
                        .addComponent(chkjpegtobmp, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkmbptojpeg, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkjpegcopy, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(chkjpegtobmp)
                .addGap(18, 18, 18)
                .addComponent(chkmbptojpeg)
                .addGap(18, 18, 18)
                .addComponent(chkjpegcopy)
                .addGap(18, 18, 18)
                .addComponent(chkcolors)
                .addGap(27, 27, 27)
                .addComponent(chkrotar)
                .addGap(31, 31, 31)
                .addComponent(chkblanconegro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Ejecutar en paralelo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ejecutar en secuencia FIFO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ejecutar en secuencia LIFO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(jButton5)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //aqui no va nada//
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        jComboBox2.removeAllItems();
        mostrar2();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        jList1.removeAll();
        mostrar3();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//LIFO METODO

        ((NodoDoble) ((NodoS) PhotoUsac.ListaGeneral.find(jComboBox1.getSelectedItem().toString())).categoria.find(jComboBox2.getSelectedItem().toString())).Imagenes.imprimir2();

        if (chkjpegtobmp.isSelected() == true) {
            try {
                PhotoUsac.Conversor.printJPEGtoBMP();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (chkjpegtobmp.isSelected() == true) {

            try {
                PhotoUsac.Conversor.printBMPtoJPEG();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (chkjpegcopy.isSelected() == true) {
            try {
                PhotoUsac.Conversor.printJPEGCOPY();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (chkcolors.isSelected() == true) {
            try {
                PhotoUsac.Conversor.printCOLORS();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (chkrotar.isSelected() == true) {
            try {
                PhotoUsac.Conversor.printROTED();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (chkblanconegro.isSelected() == true) {
            try {
                PhotoUsac.Conversor.printBW();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        PhotoUsac.Conversor.deleteall();


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // METODO FIFO

        ((NodoDoble) ((NodoS) PhotoUsac.ListaGeneral.find(jComboBox1.getSelectedItem().toString())).categoria.find(jComboBox2.getSelectedItem().toString())).Imagenes.ColaFotos();
        if (chkjpegtobmp.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGTOBMP();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (chkmbptojpeg.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.BMPTOJPEG();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (chkjpegcopy.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGCOPY();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (chkcolors.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGCOLORS();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (chkrotar.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEGROTED();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (chkblanconegro.isSelected() == true) {
            try {
                PhotoUsac.ConversorC.JPEBW();
            } catch (Exception ex) {
                Logger.getLogger(JFEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        PhotoUsac.ConversorC.deleteall();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //SEcuencia paralela 
         ((NodoDoble) ((NodoS) PhotoUsac.ListaGeneral.find(jComboBox1.getSelectedItem().toString())).categoria.find(jComboBox2.getSelectedItem().toString())).Imagenes.ColaFotos();
    Paraleo p = new Paraleo(PhotoUsac.ConversorC);
    p.start();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    JFPrincipal p = new JFPrincipal();
    p.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkblanconegro;
    private javax.swing.JCheckBox chkcolors;
    private javax.swing.JCheckBox chkjpegcopy;
    private javax.swing.JCheckBox chkjpegtobmp;
    private javax.swing.JCheckBox chkmbptojpeg;
    private javax.swing.JCheckBox chkrotar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
