/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DHAWA
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form signup2
     */
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_username = new javax.swing.JTextField();
        label_username = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        button_login = new javax.swing.JButton();
        label_forgotpassword = new javax.swing.JLabel();
        label_newaccount = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 300));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 100, 26));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Amritsar  Group Of Colleges");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 280, 40));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LOGIN PAGE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 120, 40));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 20, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 80));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 140, -1));

        label_username.setText("USERNAME");
        jPanel2.add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 20));

        label_password.setText("Password");
        jPanel2.add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        button_login.setBackground(new java.awt.Color(241, 52, 52));
        button_login.setForeground(new java.awt.Color(255, 255, 255));
        button_login.setText("Login");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });
        button_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_loginKeyPressed(evt);
            }
        });
        jPanel2.add(button_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, 20));

        label_forgotpassword.setText("forgot password?");
        label_forgotpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_forgotpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_forgotpasswordMouseClicked(evt);
            }
        });
        jPanel2.add(label_forgotpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        label_newaccount.setText("create new account?");
        label_newaccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_newaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newaccountMouseClicked(evt);
            }
        });
        jPanel2.add(label_newaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, -1, -1));
        jPanel2.add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 140, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 510, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        String name = txt_username.getText();  // TODO add your handling code here:
        char pwd[] = (txt_Password.getPassword());
        String password = "";
        for (int i = 0; i < pwd.length; i++) {
            password += pwd[i];
        }

//    if(name==""){
//    JOptionPane.showMessageDialog(this,"ENTER NAME");
//    }
//    else  if(password==""){
//    JOptionPane.showMessageDialog(this,"ENTER Password");
//    }
//     else if(name=="" && password==""){
//    JOptionPane.showMessageDialog(this,"ENTER DETAILS");
//    } 
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from userlib where name=? and password=?");
            pst.setString(1, name);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
//                JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFUL");
                Homepage home = new Homepage();
                home.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "ENTER CORRECT DETAILS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
// TODO add your handling code here:

    }//GEN-LAST:event_button_loginActionPerformed

    private void label_newaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newaccountMouseClicked
        signup sign = new signup();
        sign.setVisible(true);
//this.disableEvents(EXIT_ON_CLOSE);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_label_newaccountMouseClicked

    private void button_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_loginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_loginKeyPressed

    private void label_forgotpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_forgotpasswordMouseClicked
        JOptionPane.showMessageDialog(this, "ENTER THE DETAILS TO LOG IN ");       // TODO add your handling code here:
    }//GEN-LAST:event_label_forgotpasswordMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_forgotpassword;
    private javax.swing.JLabel label_newaccount;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_username;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
