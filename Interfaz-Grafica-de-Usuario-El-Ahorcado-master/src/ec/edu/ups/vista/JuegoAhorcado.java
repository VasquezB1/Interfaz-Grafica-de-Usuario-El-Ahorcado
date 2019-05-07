package ec.edu.ups.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Hecho en la Faculad de Estudios Superiores Cuautitlan
 * Autores:
 * Pablo Alberto Cigarrero Lopez
 * Luis Ghadiel Quintana Levario
 * Carlos Alexis Angeles Gil
 */
public class JuegoAhorcado extends javax.swing.JFrame {

    public ImageIcon imgs[];
    public JButton btns[];
    public String msgs[];
    public int ran;
    public int err;
    public String res[];
    private int random;
    private int cont = 4;

    public JuegoAhorcado() throws IOException {
        initComponents();
        this.setTitle("Juego de Ahorcado");
        //Declaramos un icono nuevo para la calculadora
        setIconImage(new ImageIcon(("src/ec/edu/ups/imagenes/ahorcadoige.png")).getImage());
        //BufferedImage icono = ImageIO.read(new URL(dir2));
        //setIconImage(icono);
        //Posicion de la ventana al centro
        this.setLocationRelativeTo(null);
        //Cambiar tamaÃ±o de la ventana
        setSize(800, 500);
        imgs = new ImageIcon[6];
        btns = new JButton[27];
        msgs = new String[20];

        //imagenes del joven ahorcado lol
        imgs[0] = new ImageIcon("src/ec/edu/ups/imagenes/1fin.png");
        imgs[1] = new ImageIcon("src/ec/edu/ups/imagenes/2fin.png");
        imgs[2] = new ImageIcon("src/ec/edu/ups/imagenes/3fin.png");
        imgs[3] = new ImageIcon("src/ec/edu/ups/imagenes/4fin.png");
        imgs[4] = new ImageIcon("src/ec/edu/ups/imagenes/5fin.png");

        //botones para las letras
        btns[1] = jButton2;
        btns[2] = jButton3;
        btns[3] = jButton4;
        btns[4] = jButton5;
        btns[5] = jButton6;
        btns[6] = jButton7;
        btns[7] = jButton8;
        btns[8] = jButton9;
        btns[9] = jButton10;
        btns[10] = jButton11;
        btns[11] = jButton12;
        btns[12] = jButton13;
        btns[13] = jButton14;
        btns[14] = jButton15;
        btns[15] = jButton16;
        btns[16] = jButton17;
        btns[17] = jButton18;
        btns[18] = jButton19;
        btns[19] = jButton20;
        btns[20] = jButton21;
        btns[21] = jButton22;
        btns[22] = jButton23;
        btns[23] = jButton24;
        btns[24] = jButton25;
        btns[25] = jButton26;
        btns[26] = jButton27;

        //palabras por advinar, para agregar una nueva palabra sera necesario declararla al inicio
        msgs[0] = "Ellanoteama".toUpperCase();
        msgs[1] = "Puma".toUpperCase();
        msgs[2] = "Rinoceronte".toUpperCase();
        msgs[3] = "Guacamayo".toUpperCase();
        msgs[4] = "Tiburon".toUpperCase();
        msgs[5] = "Cama".toUpperCase();
        msgs[6] = "Velador".toUpperCase();
        msgs[7] = "Cartera".toUpperCase();
        msgs[8] = "Celular".toUpperCase();
        msgs[9] = "Computadora".toUpperCase();
        msgs[10] = "Edificio".toUpperCase();
        msgs[11] = "Guerrero".toUpperCase();
        msgs[12] = "Carpintero".toUpperCase();
        msgs[13] = "Champu".toUpperCase();
        msgs[14] = "Dinosaurio".toUpperCase();
        msgs[15] = "Transformacion".toUpperCase();
        msgs[16] = "Bus".toUpperCase();
        msgs[17] = "Carro".toUpperCase();
        msgs[18] = "Computacion".toUpperCase();
        msgs[19] = "Supletorios".toUpperCase();

        //se asigna un evento a cada letra para comprobar que exista en la palabra a adivinar
        for (int i = 1; i < 27; i++) {
            btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checarLetra(e);
                }
            });
        }
        iniciar();
    }

    //funcion para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar() {
        //ERRORES EN 0
        err = 0;
        jButton29.setIcon(imgs[0]);
        jTextPane1.setText("");
        //para activar las letras del tablero
        for (int i = 1; i < 27; i++) {
            btns[i].setEnabled(true);
        }
        //para generar una palabra aleatoriamente xD
        ran = (int) 0 + (int) (Math.random() * ((msgs.length - 1) + 1));

        //SEPARA EL MENSAJE POR PALABRAS
        String pal[] = msgs[ran].split(" ");
        res = new String[msgs[ran].length() + 1];
        int j = 0;
        // seran los guiones que van debajo de las letras como una separacion_
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                jTextPane1.setText(jTextPane1.getText() + "_ ");
                res[j++] = "_";
            }
            jTextPane1.setText(jTextPane1.getText() + "\n");
            res[j++] = " ";
        }
    }

    //al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void checarLetra(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        char c[];

        //busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 27; i++) {

            if (bt == btns[i]) {
                //la tecla es inicializada
                c = Character.toChars(64 + i);
                //busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < msgs[ran].length(); j++) {
                    if (c[0] == msgs[ran].charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
                //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
                if (esta) {
                    jTextPane1.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            jTextPane1.setText(jTextPane1.getText() + "\n");
                        } else {
                            jTextPane1.setText(jTextPane1.getText() + re + " ");

                        }
                    }
                    //hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :D
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    //al ser correcta se muestra un mensaje y se reinicia el juego
                    if (gano) {
                        JOptionPane.showMessageDialog(this, "Ganaste :3 \nReclama tu PS4 :D  !!!");
                        iniciar();
                        return;
                    }
                    //SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
                } else {
                    cont--;
                    errores.setText(Integer.toString(cont));

                    jButton29.setIcon(imgs[++err]);
                    //SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    if (err == 4) {
                        JOptionPane.showMessageDialog(this, "Intenta de nuevo la palabra era: \n" + msgs[ran]);
                        return;
                    }
                }
                //esta es la linea que desactiva las letras despues de ser usadas :3
                bt.setEnabled(false);
                break;
            }
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton29 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpista = new javax.swing.JTextField();
        botonpista1 = new javax.swing.JButton();
        errores = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MexicanHangedPerson By Pear Soft&Games");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Juego del Ahorcado");
        jTextField1.setBorder(null);
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, -1));

        jButton28.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton28.setText("Reiniciar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 227, 177, 40));

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 370, 75));

        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 290, 378));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton2.setText("A");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton9.setText("H");
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton16.setText("O");
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton17.setText("P");
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton10.setText("I");
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton3.setText("B");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton11.setText("J");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton4.setText("C");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton18.setText("Q");
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton23.setText("V");
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jButton24.setBackground(new java.awt.Color(255, 255, 255));
        jButton24.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton24.setText("W");
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton25.setText("X");
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton19.setText("R");
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton12.setText("K");
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton5.setText("D");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton6.setText("E");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton13.setText("L");
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton20.setText("S");
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        jButton26.setBackground(new java.awt.Color(255, 255, 255));
        jButton26.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton26.setText("Y");
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        jButton27.setBackground(new java.awt.Color(255, 255, 255));
        jButton27.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton27.setText("Z");
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton21.setText("T");
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        jButton22.setBackground(new java.awt.Color(255, 255, 255));
        jButton22.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton22.setText("U");
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton15.setText("N");
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton7.setText("F");
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton8.setText("G");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton14.setText("M");
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 155, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/logo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        txtpista.setEditable(false);
        txtpista.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpista.setForeground(new java.awt.Color(0, 0, 255));
        txtpista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpista.setEnabled(false);
        txtpista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpistaActionPerformed(evt);
            }
        });
        getContentPane().add(txtpista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 370, 40));

        botonpista1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonpista1.setText("Pista");
        botonpista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonpista1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonpista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 70, 30));

        errores.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        errores.setText("4");
        errores.setToolTipText("");
        errores.setEnabled(false);
        getContentPane().add(errores, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Errores Restantes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        iniciar();
        cont = 4;
        errores.setText(Integer.toString(cont));
        txtpista.setText(" ");

    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonpista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonpista1ActionPerformed
        // TODO add your handling code here:
        if (msgs[ran] == msgs[0]) {
            txtpista.setText("Ley de vida".toUpperCase());

        }
        if (msgs[ran] == msgs[1]) {
            txtpista.setText("Animal rapido o marca de zapatos".toUpperCase());
        }

        if (msgs[ran] == msgs[2]) {
            txtpista.setText("Animal de gran cuerno".toUpperCase());
        }
        if (msgs[ran] == msgs[3]) {
            txtpista.setText("Aparece en varios cuentos".toUpperCase());
        }
        if (msgs[ran] == msgs[4]) {
            txtpista.setText("Animal de Mar muy peligroso".toUpperCase());
        }
        if (msgs[ran] == msgs[5]) {
            txtpista.setText("En ella puedes tomar siestas o largas noches".toUpperCase());
        }
        if (msgs[random] == msgs[6]) {
            txtpista.setText("Estante de tu cuarto".toUpperCase());
        }
        if (msgs[ran] == msgs[7]) {
            txtpista.setText("Guardas tus cosas en ella".toUpperCase());
        }
        if (msgs[ran] == msgs[8]) {
            txtpista.setText("Lo tienes por algun lado".toUpperCase());
        }
        if (msgs[ran] == msgs[9]) {
            txtpista.setText("Estas jugando en ella".toUpperCase());
        }
        if (msgs[ran] == msgs[10]) {
            txtpista.setText("Hay altos y bajos".toUpperCase());
        }
        if (msgs[ran] == msgs[11]) {
            txtpista.setText("De gran valentia dispuesto a luchar".toUpperCase());
        }
        if (msgs[ran] == msgs[12]) {
            txtpista.setText("Madera Madera".toUpperCase());
        }
        if (msgs[ran] == msgs[13]) {
            txtpista.setText("Lo usan todo el mundo".toUpperCase());
        }
        if (msgs[ran] == msgs[14]) {
            txtpista.setText("Se extinguieron Dios los tenga en su gloria".toUpperCase());
        }
        if (msgs[ran] == msgs[15]) {
            txtpista.setText("Lo usan los transformers".toUpperCase());
        }
        if (msgs[ran] == msgs[16]) {
            txtpista.setText("Muy grande y varias personas caben".toUpperCase());
        }
        if (msgs[ran] == msgs[17]) {
            txtpista.setText("4 llantas y pa donde sea".toUpperCase());
        }
        if (msgs[ran] == msgs[18]) {
            txtpista.setText("Que carrera sigues".toUpperCase());
        }
        if (msgs[ran] == msgs[19]) {
            txtpista.setText("Lo vas a tener este ciclo".toUpperCase());
        }

    }//GEN-LAST:event_botonpista1ActionPerformed

    private void txtpistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpistaActionPerformed

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
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new JuegoAhorcado().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JuegoAhorcado.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonpista1;
    private javax.swing.JTextField errores;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtpista;
    // End of variables declaration//GEN-END:variables
}
