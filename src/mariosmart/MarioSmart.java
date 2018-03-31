/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariosmart;

import Algoritmos.BusquedaA;
import Algoritmos.BusquedaAmplitud;
import Algoritmos.BusquedaAvara;
import Algoritmos.BusquedaCostoUniforme;
import Logica.ArchiveManager;
import Vista.Mundo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author user
 */
public class MarioSmart extends javax.swing.JFrame {
    ArchiveManager manejoArchivos;
    Mundo miMundo;
    int[][] tableroDeJuego;
    
    public MarioSmart() {
        super("Mario Smart");
        initComponents();
        manejoArchivos = new ArchiveManager();
        miMundo = new Mundo();
        tableroDeJuego = new int[10][10];
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedor = new javax.swing.JPanel();
        jPanelTablero = new javax.swing.JPanel();
        jLabelSeleccionado = new javax.swing.JLabel();
        jLabelAlgoritmo = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemCargarArchivo = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuBusqueda = new javax.swing.JMenu();
        jMenuNoInformada = new javax.swing.JMenu();
        jMenuItemAmplitud = new javax.swing.JMenuItem();
        jMenuItemCostoUniforme = new javax.swing.JMenuItem();
        jMenuItemProfundidad = new javax.swing.JMenuItem();
        jMenuInformada = new javax.swing.JMenu();
        jMenuItemAVARA = new javax.swing.JMenuItem();
        jMenuItemAEstrella = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane(jLabelSeleccionado);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelTableroLayout = new javax.swing.GroupLayout(jPanelTablero);
        jPanelTablero.setLayout(jPanelTableroLayout);
        jPanelTableroLayout.setHorizontalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        jPanelTableroLayout.setVerticalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jLabelSeleccionado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelAlgoritmo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAlgoritmo.setText("Algoritmo seleccionado:");

        jScrollPane1.setViewportView(jLabelSeleccionado);

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        
        
        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenedorLayout.createSequentialGroup()
                        .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAlgoritmo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenedorLayout.createSequentialGroup()
                        .addComponent(jButtonSalir)
                        .addGap(126, 126, 126))))
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addGap(65, 65, 65))
        );

        jMenuArchivo.setText("Archivo");

        jMenuItemCargarArchivo.setText("Cargar archivo");
        jMenuItemCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarArchivoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemCargarArchivo);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBarPrincipal.add(jMenuArchivo);

        jMenuBusqueda.setText("Busqueda");

        jMenuNoInformada.setText("Busquedas no informadas");

        jMenuItemAmplitud.setText("Amplitud");
        jMenuItemAmplitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAmplitudActionPerformed(evt);
            }
        });
        jMenuNoInformada.add(jMenuItemAmplitud);

        jMenuItemCostoUniforme.setText("Costo uniforme");
        jMenuItemCostoUniforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCostoUniformeActionPerformed(evt);
            }
        });
        jMenuNoInformada.add(jMenuItemCostoUniforme);

        jMenuItemProfundidad.setText("Profundidad evitando ciclos");
        jMenuItemProfundidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProfundidadActionPerformed(evt);
            }
        });
        jMenuNoInformada.add(jMenuItemProfundidad);

        jMenuBusqueda.add(jMenuNoInformada);

        jMenuInformada.setText("Busquedas informadas");

        jMenuItemAVARA.setText("AVARA");
        jMenuItemAVARA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAVARAActionPerformed(evt);
            }
        });
        jMenuInformada.add(jMenuItemAVARA);

        jMenuItemAEstrella.setText("A*");
        jMenuItemAEstrella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAEstrellaActionPerformed(evt);
            }
        });
        jMenuInformada.add(jMenuItemAEstrella);

        jMenuBusqueda.add(jMenuInformada);

        jMenuBarPrincipal.add(jMenuBusqueda);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarTablero() {
        jPanelTablero.removeAll();
        miMundo = new Mundo();
        jPanelTablero.add(miMundo);
        tableroDeJuego = manejoArchivos.getTableroDeJuego();
        miMundo.setTableroDeJuego(manejoArchivos.getTableroDeJuego());
        miMundo.mostrarMundo();
        miMundo.updateUI();
    }
    
    public void actualizarTableroBusquedas(int[][] tablero) {
        
        jPanelTablero.removeAll();
        miMundo = new Mundo();
        jPanelTablero.add(miMundo);
        tableroDeJuego = tablero;
        miMundo.setTableroDeJuego(manejoArchivos.getTableroDeJuego());
        miMundo.mostrarMundo();
        miMundo.updateUI();
        
    }
    
    
    private void jMenuItemCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarArchivoActionPerformed
        try {
            //repintar();
            JFileChooser archivo = new JFileChooser();
            archivo.showOpenDialog(null);
            File arch = archivo.getSelectedFile();
            FileReader frLector = new FileReader(arch);
            this.manejoArchivos.leerArchivoTablero(frLector);
            actualizarTablero();
        } catch (FileNotFoundException ex) {
        }
    }//GEN-LAST:event_jMenuItemCargarArchivoActionPerformed

    private void jMenuItemAEstrellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAEstrellaActionPerformed
        
        BusquedaA buscarEstrella = new BusquedaA(tableroDeJuego);

        String texto = "<html><body><b>Busqueda A*</b><br><br>";

        //si mario no esta en el mapa genero excepcion
        try {
            buscarEstrella.buscarRaiz();
            buscarEstrella.buscarMeta();
        } catch (Exception ex) {
            Logger.getLogger(MarioSmart.class.getName()).log(Level.SEVERE, null, ex);
        }

        int[][] tablerito = buscarEstrella.aplicarBusqueda();
        actualizarTableroBusquedas(tablerito);

        texto += buscarEstrella.getInformacionAgente();
        texto += "<br></body></html>";

        //informacion del agente
        jLabelSeleccionado.setText(texto);
    }//GEN-LAST:event_jMenuItemAEstrellaActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jMenuItemAmplitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAmplitudActionPerformed
        
        BusquedaAmplitud buscarPorAmplitud = new BusquedaAmplitud(tableroDeJuego);
        
        
        String texto = "<html><body><b>Busqueda por amplitud</b><br><br>";
        
        //si mario no esta en el mapa genero excepcion
        try {
            buscarPorAmplitud.buscarRaiz();
        } catch (Exception ex) {
            Logger.getLogger(MarioSmart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int[][] tablerito = buscarPorAmplitud.aplicarBusqueda();
        actualizarTableroBusquedas(tablerito);
                
        texto += buscarPorAmplitud.getInformacionAgente();
        texto += "<br></body></html>";
        
        //informacion del agente
        jLabelSeleccionado.setText(texto);
                
    }//GEN-LAST:event_jMenuItemAmplitudActionPerformed

    private void jMenuItemCostoUniformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCostoUniformeActionPerformed
        
        BusquedaCostoUniforme buscarPorCostoUniforme= new BusquedaCostoUniforme(tableroDeJuego);
        
        String texto = "<html><body><b>Busqueda por costo Uniforme</b><br><br>";

        //si mario no esta en el mapa genero excepcion
        try {
            buscarPorCostoUniforme.buscarRaiz();
        } catch (Exception ex) {
            Logger.getLogger(MarioSmart.class.getName()).log(Level.SEVERE, null, ex);
        }

        int[][] tablerito = buscarPorCostoUniforme.aplicarBusqueda();
        actualizarTableroBusquedas(tablerito);
        
        texto += buscarPorCostoUniforme.getInformacionAgente();
        texto += "<br></body></html>";
        
        //informacion del agente
        jLabelSeleccionado.setText(texto);

    }//GEN-LAST:event_jMenuItemCostoUniformeActionPerformed

    private void jMenuItemProfundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProfundidadActionPerformed

    }//GEN-LAST:event_jMenuItemProfundidadActionPerformed

    private void jMenuItemAVARAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAVARAActionPerformed
        
        BusquedaAvara buscarPorAvara= new BusquedaAvara(tableroDeJuego);
        
        String texto = "<html><body><b>Busqueda AVARA</b><br><br>";

        //si mario no esta en el mapa genero excepcion
        try {
            buscarPorAvara.buscarRaiz();
            buscarPorAvara.buscarMeta();
        } catch (Exception ex) {
            Logger.getLogger(MarioSmart.class.getName()).log(Level.SEVERE, null, ex);
        }

        int[][] tablerito = buscarPorAvara.aplicarBusqueda();
        actualizarTableroBusquedas(tablerito);
        
        texto += buscarPorAvara.getInformacionAgente();
        texto += "<br></body></html>";
        
        //informacion del agente
        jLabelSeleccionado.setText(texto);
        
    }//GEN-LAST:event_jMenuItemAVARAActionPerformed

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
            java.util.logging.Logger.getLogger(MarioSmart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarioSmart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarioSmart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarioSmart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarioSmart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelAlgoritmo;
    private javax.swing.JLabel jLabelSeleccionado;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuBusqueda;
    private javax.swing.JMenu jMenuInformada;
    private javax.swing.JMenuItem jMenuItemAEstrella;
    private javax.swing.JMenuItem jMenuItemAVARA;
    private javax.swing.JMenuItem jMenuItemAmplitud;
    private javax.swing.JMenuItem jMenuItemCargarArchivo;
    private javax.swing.JMenuItem jMenuItemCostoUniforme;
    private javax.swing.JMenuItem jMenuItemProfundidad;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuNoInformada;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelTablero;      
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}