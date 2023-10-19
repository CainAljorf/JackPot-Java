/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jackpot;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Cain
 */
public class JackpotClienteWin extends javax.swing.JFrame {

    /**
     * Creates new form JackpotClientWin
     */
    
     private final static int PORT = 8500;
    /**
    * Host
    * */
    private final static String SERVER = "localhost";
    public  void conexionServer(String request){
         Socket socket;
        
        //control de errores con un try catch
        try {
           
            ///AÃ±adir el menÃº
            
            //Se debe incluir lo necesario para mostrar el menu
           
                //abremos el socket socket
                socket = new Socket(SERVER, PORT);    
                
                //Para leer lo que envie el servidor      
                BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));  
                
                //para imprimir datos del servidor
                PrintStream output = new PrintStream(socket.getOutputStream());   
                
                //Para leer lo que escriba el usuario            
                //BufferedReader brRequest = new BufferedReader(new InputStreamReader(System.in)); 
                 
                String request_a_enviar=creaTrama(request);
                
                //manda peticion al servidor
                output.println(request_a_enviar);
                
                //captura respuesta e imprime
                String st = input.readLine();
                if( st != null ) {
                    procesaRespuesta(st);
                    //System.out.println("Trama del server encriptada = " + st ); 
                }
                if(request.equals("6")){//terminar aplicacion poner el valor de salida
                                      
                    System.out.println("Fin de programa");
                }
                socket.close();
                                         
       } catch (IOException ex) {        
         System.err.println(ex.getMessage());   
       }
    
    }
    public JackpotClienteWin() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        img3 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemIngresar = new javax.swing.JMenuItem();
        jMenuItemJugar = new javax.swing.JMenuItem();
        jMenuItemSaldo = new javax.swing.JMenuItem();
        jMenuItemPremios = new javax.swing.JMenuItem();
        jMenuItemRetirar = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(img2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(img3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jMenu2.setText("Menu Opciones");

        jMenuItemIngresar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, 0));
        jMenuItemIngresar.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItemIngresar.setText("Ingresar Saldo");
        jMenuItemIngresar.setToolTipText("");
        jMenuItemIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIngresarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemIngresar);

        jMenuItemJugar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, 0));
        jMenuItemJugar.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItemJugar.setText("Jugar");
        jMenuItemJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJugarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemJugar);

        jMenuItemSaldo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, 0));
        jMenuItemSaldo.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItemSaldo.setText("Ver Saldo");
        jMenuItemSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaldoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSaldo);

        jMenuItemPremios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, 0));
        jMenuItemPremios.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItemPremios.setText("Ver Premios");
        jMenuItemPremios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPremiosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPremios);

        jMenuItemRetirar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, 0));
        jMenuItemRetirar.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItemRetirar.setText("Retirar Saldo");
        jMenuItemRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRetirarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRetirar);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, 0));
        jMenuItemSalir.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        conexionServer("6");
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemPremiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPremiosActionPerformed
        conexionServer("4");
    }//GEN-LAST:event_jMenuItemPremiosActionPerformed

    private void jMenuItemIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIngresarActionPerformed
        conexionServer("1");
    }//GEN-LAST:event_jMenuItemIngresarActionPerformed

    private void jMenuItemJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJugarActionPerformed
        conexionServer("2");
    }//GEN-LAST:event_jMenuItemJugarActionPerformed

    private void jMenuItemSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaldoActionPerformed
        conexionServer("3");
    }//GEN-LAST:event_jMenuItemSaldoActionPerformed

    private void jMenuItemRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRetirarActionPerformed
        conexionServer("5");
    }//GEN-LAST:event_jMenuItemRetirarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static String creaTrama(String tr) {
        
        String trama="";
       
        trama = tr;
        
        switch(tr){
            case "1":
                String depositar = JOptionPane.showInputDialog("Ingrese cantidad para ingresar:");
                trama = "E1"+depositar;
                break;
                
            case "2":
                trama = "E2";
                break;
                
            case "3":
                trama = "E3";
                break;
                
            case "4":
                trama = "E4";
                break;
                
            case "5":
                String retirar = JOptionPane.showInputDialog("Ingrese cantidad para retirar:");
                trama = "E5"+retirar;                               
                break;
                
            case "6":
                trama = "E6Adiós";
                break;
                
            default:
                trama = "E9";
            }
              
        //Encriptar la trama
        String TramaEncriptada = Criptografia.Encriptar(trama);
        return TramaEncriptada;
    }
       public  void procesaRespuesta(String tr) {
        
        //Desencriptar la trama
        
       try{
            String TramaDesencriptada = Criptografia.Desencriptar(tr);
            String cadenaText = "";
            cadenaText = cadenaText + TramaDesencriptada.substring(2) + "\n";
            
            switch(TramaDesencriptada.substring(0,2)){
            
            case "R1":
                jLabel1.setText(TramaDesencriptada.substring(2));
               
               // jTextArea1.setText(TramaDesencriptada.substring(2));
               // jTextArea1.append(System.getProperty("line.separator"));
                cadenaText = cadenaText + TramaDesencriptada.substring(2) + "\n";
                jTextArea1.setText(cadenaText);
             
                break;
                
            case "R2":
                
                if (TramaDesencriptada.substring(0,4).equals ("R2No")){
                     jLabel1.setText("No tienes saldo para jugar.");
                     
                   
                }else{
                  
                   
                    String letra1 = TramaDesencriptada.substring(2,3);
                    String letra2 = TramaDesencriptada.substring(3,4);
                    String letra3 = TramaDesencriptada.substring(4,5);
                    jLabel1.setText(TramaDesencriptada.substring(2));
                    cadenaText = cadenaText + TramaDesencriptada.substring(2) + "\n";
                    jTextArea1.setText(cadenaText);
                    ImageIcon fotoIcono= new ImageIcon("./png/"+letra1+".png");
                    ImageIcon fotoIcono1= new ImageIcon("./png/"+letra2+".png");
                    ImageIcon fotoIcono2= new ImageIcon("./png/"+letra3+".png");
                    Image foto= fotoIcono.getImage();
                    Image nuevaFoto= foto.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon NuevaFotoIcono= new ImageIcon(nuevaFoto);

                    Image foto1= fotoIcono1.getImage();
                    Image nuevaFoto1= foto1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon NuevaFotoIcono1= new ImageIcon(nuevaFoto1);

                    Image foto2= fotoIcono2.getImage();
                    Image nuevaFoto2= foto2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon NuevaFotoIcono2= new ImageIcon(nuevaFoto2);
                    img1.setIcon(NuevaFotoIcono);
                    img2.setIcon(NuevaFotoIcono1);
                    img3.setIcon(NuevaFotoIcono2);
                    
                  
                    
                }
                 break;
            case "R3":
                jLabel1.setText(TramaDesencriptada.substring(2));
                jTextArea1.setText(TramaDesencriptada.substring(2));
                break;
            
            case "R4":
                String cadena = TramaDesencriptada.substring(2);
                String[] separar = cadena.split(";");   
                for (int i = 0; i < separar.length; i++)    {     
                    jLabel1.setText(separar[i]);   
                } 
                jTextArea1.setText(TramaDesencriptada.substring(2));
                break;
                    
            case "R5":
                jLabel1.setText(TramaDesencriptada.substring(2));
                jTextArea1.setText(TramaDesencriptada.substring(2));
                break;                      
                
            case "R6":
                jLabel1.setText(TramaDesencriptada.substring(2));
                jTextArea1.setText(TramaDesencriptada.substring(2));
                break;
                
            default:
                 jLabel1.setText(TramaDesencriptada.substring(2));
        //Funcion que procesa la respuesta del servidor.
        //Debes añadir todo lo necesario
        //USO Obligatorio de Swith Case
        }
        }
        catch (Exception fallo){
            jLabel1.setText("Fallo en la desencriptación de la trama R.");
            
        }
    }
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
            java.util.logging.Logger.getLogger(JackpotClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JackpotClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JackpotClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JackpotClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JackpotClienteWin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemIngresar;
    private javax.swing.JMenuItem jMenuItemJugar;
    private javax.swing.JMenuItem jMenuItemPremios;
    private javax.swing.JMenuItem jMenuItemRetirar;
    private javax.swing.JMenuItem jMenuItemSaldo;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}