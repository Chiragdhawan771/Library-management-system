/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;


import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author DHAWA
 */


public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    DefaultTableModel studentmodel;
    public ManageStudents() {
        initComponents();
        setstudentstotable();
    }
    public boolean checkduplicate(){
        String rollno=field_rollno.getText();
   
        try {
             Connection con=dbconnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from student_detail where Rollno=?");
            pst.setString(1,rollno);
            int rowcount=pst.executeUpdate();
            if(rowcount>0){
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this,"errorfound");
           ex.printStackTrace();
        }
        return false;
    }
public void setstudentstotable(){
    try{
        Connection con=dbconnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from Student_detail");
        while(rs.next()){
            String rollno=rs.getString("rollno");
            String name=rs.getString("student_name");
            String course=rs.getString("course");
            String branch=rs.getString("Branch");
            int batch=rs.getInt("batch");
            int lib_card=rs.getInt("lib_card");
            Object [] obj={rollno,name,course,branch,batch,lib_card};
            studentmodel=(DefaultTableModel) tbl_studentdetail.getModel();
            studentmodel.addRow(obj);
        }
    }
    catch(Exception e){
        e.printStackTrace();
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

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        field_rollno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        field_studentname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        field_course = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        field_branch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        field_batch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_studentdetail = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("<- Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 100, 26));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("<- Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("University rollno.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, -1));
        jPanel1.add(field_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 110, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Student Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 100, -1));
        jPanel1.add(field_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 110, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Course");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 80, -1));
        jPanel1.add(field_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 110, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Branch");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 70, -1));
        jPanel1.add(field_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 110, -1));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setText("  Add Student  ");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setText("Update  Student");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, -1, -1));

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setText("Delete Student");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Batch");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 70, -1));
        jPanel1.add(field_batch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 590));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 20, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 50, -1));

        tbl_studentdetail.setAutoCreateRowSorter(true);
        tbl_studentdetail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl_studentdetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "University rollno", "Name", "course", "branch", "batch", "Lib_card"
            }
        ));
        tbl_studentdetail.setToolTipText("");
        tbl_studentdetail.setGridColor(new java.awt.Color(255, 0, 51));
        tbl_studentdetail.setShowGrid(true);
        tbl_studentdetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentdetailMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_studentdetail);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 770, 290));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 100, 26));
        jLabel4.setText("Manage Students");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 220, 40));

        jPanel6.setBackground(new java.awt.Color(255, 100, 26));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 220, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 840, 590));

        setSize(new java.awt.Dimension(1233, 594));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
Homepage pg=new Homepage();
pg.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_studentdetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentdetailMouseClicked
int rowno=tbl_studentdetail.getSelectedRow();
TableModel tempmodel=tbl_studentdetail.getModel();
field_rollno.setText(tempmodel.getValueAt(rowno, 0).toString());
field_studentname.setText(tempmodel.getValueAt(rowno, 1).toString());
field_course.setText(tempmodel.getValueAt(rowno, 2).toString());
field_branch.setText(tempmodel.getValueAt(rowno, 3).toString());
field_batch.setText(tempmodel.getValueAt(rowno,4).toString());
    }//GEN-LAST:event_tbl_studentdetailMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
if(!checkduplicate()){
    String rollno=field_rollno.getText();
    String name=field_studentname.getText();
    String course=field_course.getText();
    String branch=field_branch.getText();
    int batch=Integer.parseInt(field_batch.getText());
    int val=4;
    try{
        Connection con=dbconnection.getConnection();
        PreparedStatement pst=con.prepareStatement("insert into Student_detail(rollno,Student_name,course,branch,batch,lib_card)  values(?,?,?,?,?,?)");
        pst.setString(1, rollno);
        pst.setString(2, name);
        pst.setString(3, course);
        pst.setString(4, branch);
        pst.setInt(5,batch);
        pst.setInt(6,val);
        int updaterow=pst.executeUpdate();
        if(updaterow>0){
            JOptionPane.showMessageDialog(this,"Student has been inserted");
            if(studentmodel!=null){
              studentmodel.setRowCount(0);
            setstudentstotable();
            }
             else{
              setstudentstotable();
            }
      }
           
      
    }
    catch(SQLException e){
        
//            JOptionPane.showMessageDialog(this,"errorfound");
        e.printStackTrace();
    }
    
}
else{
    JOptionPane.showMessageDialog(this,"Student already Exist");
}
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(checkduplicate()){
    String rollno=field_rollno.getText();
    String name=field_studentname.getText();
    String course=field_course.getText();
    String branch=field_branch.getText();
    int batch=Integer.parseInt(field_batch.getText());
    try{
        Connection con=dbconnection.getConnection();
        PreparedStatement pst=con.prepareStatement("update Student_detail set  student_name=?,course=?,branch=?,batch=? where rollno=?");
       
        pst.setString(1, name);
        pst.setString(2, course);
        pst.setString(3,branch);
        pst.setInt(4, batch);
        pst.setString(5, rollno);
        int updaterow=pst.executeUpdate();
        if(updaterow>0){
            JOptionPane.showMessageDialog(this,"student has been Updated");
              studentmodel.setRowCount(0);
            setstudentstotable();
        }
      
    }
    catch(SQLException e){
        
//            JOptionPane.showMessageDialog(this,"errorfound");
        e.printStackTrace();
    }
    
}
else{
    JOptionPane.showMessageDialog(this,"Student Roll NO. NOT FOUND");
}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
    if(checkduplicate()){
    String rollno=field_rollno.getText();
    try{
        Connection con=dbconnection.getConnection();
        PreparedStatement pst=con.prepareStatement("delete from Student_detail where rollno=?");      
        pst.setString(1, rollno);
        int updaterow=pst.executeUpdate();
        if(updaterow>0){
            JOptionPane.showMessageDialog(this,"Student record has been Deleted");
              studentmodel.setRowCount(0);
            setstudentstotable();
        }
      
    }
    catch(SQLException e){
        
//            JOptionPane.showMessageDialog(this,"errorfound");
        e.printStackTrace();
    }
    
}
else{
    JOptionPane.showMessageDialog(this,"Student NOT FOUND");
}// TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field_batch;
    private javax.swing.JTextField field_branch;
    private javax.swing.JTextField field_course;
    private javax.swing.JTextField field_rollno;
    private javax.swing.JTextField field_studentname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_studentdetail;
    // End of variables declaration//GEN-END:variables
}

