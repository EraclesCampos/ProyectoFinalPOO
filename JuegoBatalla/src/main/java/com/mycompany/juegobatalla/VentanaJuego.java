package com.mycompany.juegobatalla;

import java.awt.Image; 
import java.net.URL; 
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */

public class VentanaJuego extends javax.swing.JFrame {
    /**
     * Creates new form VentanaJuego
     */    
    private String turno = "Heroe";
    private List<Heroes> Heroes = new ArrayList<>();
    private List<Bestias> Bestias = new ArrayList<>();
    private List<Icon> imagenHeroes = new ArrayList<>();
    private List<Icon> imagenBestias = new ArrayList<>();
    
//    Constructor del archivo para inicializar componentes, objetos, turnos e informacion
    public VentanaJuego() {
        setTitle("Juego de Batalla");

        initComponents();
        inicializarImagenes();
        mostrarImagenes();
        crearObjetos();
        
        actualizarInformacion();
        setTurno();
    }
    // funcion para crear los objetos y agregarlos a las listas
    private void crearObjetos(){        
        Heroes.add(new Heroes("Caballero",100,20));
        Heroes.add(new Elfos("Elfo",80,10));
        Heroes.add(new Hobbits("Mago",50,40)); 
        
        Bestias.add(new Orcos("Orco",120,15));
        Bestias.add(new Bestias("Bestia",120,30));
        Bestias.add(new Bestias("Slime",50,40));
    }
    //Funcion para cambiar de heroe o bestia
    private void actualizarEjercito() {
        boolean heroeEliminado = false;
        boolean bestiaEliminada = false;

        if (!Heroes.isEmpty() && Heroes.get(0).getPuntosVida() == 0) {
            Heroes.remove(0);
            imagenHeroes.remove(0);
            heroeEliminado = true;
        }
        if (!Bestias.isEmpty() && Bestias.get(0).getPuntosVida() == 0) {
            Bestias.remove(0);
            imagenBestias.remove(0);
            bestiaEliminada = true;
        }

        if (Heroes.isEmpty() || Bestias.isEmpty()) {
            mostrarOpcionesFinJuego();
            return;
        }

        if (heroeEliminado || bestiaEliminada) {
            mostrarImagenes();
        }
        actualizarInformacion();
        setTurno();
    }

//       Fucnion para mostrar el menu al finalizar el juego
    private void mostrarOpcionesFinJuego() {
    String[] opciones = {"Reiniciar", "Salir"};
    
    int seleccion = javax.swing.JOptionPane.showOptionDialog(
        this,
        "¿Qué deseas hacer?",
        "Fin del Juego",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE,
        null,
        opciones,
        opciones[0]
    );

    // Procesar la selección del usuario
    if (seleccion == 0) { // Opción "Reiniciar"
        reiniciarJuego();
    } else if (seleccion == 1) { // Opción "Cerrar"
        System.exit(0); // Cierra la aplicación
    }
}

//Funcion para reiniciar los componentes, listas y demas
private void reiniciarJuego() {
    Heroes.clear();
    Bestias.clear();
    imagenHeroes.clear();
    imagenBestias.clear();
    
    crearObjetos();
    inicializarImagenes();
    mostrarImagenes();
    
    actualizarInformacion();
    
    setTurno();
    
    imagenesMuerte();
    actualizarLabel9("");
}


    
    //funcion para actualizar la informacion de los personajes
    private void actualizarInformacion() {
        if (!Heroes.isEmpty()){
        jLabel1.setText("Nombre: " + Heroes.get(0).getNombre());
        jLabel2.setText("Vida: " + Heroes.get(0).getPuntosVida());
        }
        if (!Bestias.isEmpty()){
        jLabel3.setText("Nombre: " + Bestias.get(0).getNombre());
        jLabel4.setText("Vida: " + Bestias.get(0).getPuntosVida());
        }
    }
    
    //alternar los turnos 
    private void setTurno(){        
        turno = turno.equals("Bestia") ? "Heroe" : "Bestia";
        jLabel6.setText(turno);
    }
    
    
    //buscar las rutas de las imagenes y cargarlas en el label ajustando la imagen al tamaño del label
    //Inicializa todas las imagenes
    private void inicializarImagenes() {
    // Cargar y escalar la imagen del héroe
        URL imgURLHeroe = getClass().getResource("/images/Caballero.jpg");
        ImageIcon imagenHeroe = new ImageIcon(imgURLHeroe);
        Icon icono = new ImageIcon(imagenHeroe.getImage().getScaledInstance(jLabel7.getWidth(),jLabel7.getHeight(), Image.SCALE_DEFAULT));
        imagenHeroes.add(icono);
        URL imgURLHeroe2 = getClass().getResource("/images/Elfo.jpg");
        ImageIcon imagenHeroe2 = new ImageIcon(imgURLHeroe2);
        Icon icono2 = new ImageIcon(imagenHeroe2.getImage().getScaledInstance(jLabel7.getWidth(),jLabel7.getHeight(), Image.SCALE_DEFAULT));
        imagenHeroes.add(icono2);
        URL imgURLHeroe3 = getClass().getResource("/images/Mago.jpg");
        ImageIcon imagenHeroe3 = new ImageIcon(imgURLHeroe3);
        Icon icono3 = new ImageIcon(imagenHeroe3.getImage().getScaledInstance(jLabel7.getWidth(),jLabel7.getHeight(), Image.SCALE_DEFAULT));
        imagenHeroes.add(icono3);
        
        
        URL imgURLBestia = getClass().getResource("/images/Orco.jpg");
        ImageIcon imagenBestia = new ImageIcon(imgURLBestia);
        Icon iconoB = new ImageIcon(imagenBestia.getImage().getScaledInstance(jLabel8.getWidth(),jLabel8.getHeight(), Image.SCALE_DEFAULT));
        imagenBestias.add(iconoB);
        URL imgURLBestia2 = getClass().getResource("/images/Dragon.jpg");
        ImageIcon imagenBestia2 = new ImageIcon(imgURLBestia2);
        Icon iconoB2 = new ImageIcon(imagenBestia2.getImage().getScaledInstance(jLabel8.getWidth(),jLabel8.getHeight(), Image.SCALE_DEFAULT));
        imagenBestias.add(iconoB2);
        URL imgURLBestia3 = getClass().getResource("/images/slime.png");
        ImageIcon imagenBestia3 = new ImageIcon(imgURLBestia3);
        Icon iconoB3 = new ImageIcon(imagenBestia3.getImage().getScaledInstance(jLabel8.getWidth(),jLabel8.getHeight(), Image.SCALE_DEFAULT));
        imagenBestias.add(iconoB3);
}
    //muestra las imagenes en pantalla
    private void mostrarImagenes(){
        jLabel7.setIcon(imagenHeroes.get(0));
        jLabel8.setIcon(imagenBestias.get(0));
    }

    //Imagen de muerte y las muestra
    private void imagenesMuerte(){
        URL imgURLHeroeDead = getClass().getResource("/images/Muerte.jpg");
        ImageIcon muerteHeroe = new ImageIcon(imgURLHeroeDead);
        Icon icono = new ImageIcon(muerteHeroe.getImage().getScaledInstance( jLabel7.getWidth() , jLabel7.getHeight(), Image.SCALE_DEFAULT));
        
        if(Bestias.get(0).getPuntosVida() == 0){
            jLabel8.setIcon(icono);
        }else if(Heroes.get(0).getPuntosVida() == 0){
            jLabel7.setIcon(icono);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego de Batalla");
        setResizable(false);
        setSize(new java.awt.Dimension(790, 470));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Atacar");
        jButton1.setActionCommand("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Atacar");
        jButton2.setToolTipText("");
        jButton2.setActionCommand("");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombre: ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Vida: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Vida: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("   Turno");
        jLabel5.setName(""); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        jButton1.getAccessibleContext().setAccessibleName("AtacarHeroes");
        jButton2.getAccessibleContext().setAccessibleName("AtacarBestias");

        pack();
    }// </editor-fold>//GEN-END:initComponents
//    Actualizar el label central para mostrar la informacion del ataque
    public void actualizarLabel9(String mensaje) {
        jLabel9.setText(mensaje); 
    }
    //----manejar el click del boton de ataque del heroe----
    //Funcion para manejar el click del boton de ataque del heroe
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(Heroes.get(0).getPuntosVida() == 0 || Heroes.isEmpty()) return;
        
        if (!Heroes.isEmpty() && !Bestias.isEmpty()) {
            // Realiza la acción de ataque
            if (Bestias.get(0).getPuntosVida() > 0 && turno.equals("Heroe")) {
                int dano = Heroes.get(0).atacar(Bestias.get(0));
                Bestias.get(0).setPuntosVida(Bestias.get(0).getPuntosVida() - dano);
                actualizarLabel9(Heroes.get(0).getNombre()+" hizo "+ dano + " de daño a "+Bestias.get(0).getNombre());
                if (Bestias.get(0).getPuntosVida() <= 0) {
                    Bestias.get(0).setPuntosVida(0); // establecer la vida en 0 para que no haya valores negativos 
                    imagenesMuerte();
                    javax.swing.JOptionPane.showMessageDialog(this, "¡El heroe ha derrotado a la bestia!");
                }
                actualizarEjercito();
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //manejar el click del boton de ataque de la bestia
    //Funcion para manejar el click del boton de ataque de la bestia
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(Bestias.get(0).getPuntosVida() == 0 || Bestias.isEmpty()) return;
        
        if (!Heroes.isEmpty() && !Bestias.isEmpty()){
            if (Heroes.get(0).getPuntosVida() > 0 && turno.equals("Bestia")) {
                int dano = Bestias.get(0).atacar(Heroes.get(0));
                Heroes.get(0).setPuntosVida(Heroes.get(0).getPuntosVida() - dano);
                actualizarLabel9(Bestias.get(0).getNombre()+" hizo "+ dano + " de daño a "+Heroes.get(0).getNombre());

                if (Heroes.get(0).getPuntosVida() <= 0) {
                    Heroes.get(0).setPuntosVida(0);
                    imagenesMuerte();
                    javax.swing.JOptionPane.showMessageDialog(this, "¡La bestia ha derrotado al héroe!");

                }
                actualizarEjercito();
            }    
        }
    }//GEN-LAST:event_jButton2ActionPerformed
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
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
