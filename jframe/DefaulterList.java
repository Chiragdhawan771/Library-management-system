/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet();
import java.sql.ResultSet;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DHAWA
 */
public class DefaulterList extends javax.swing.JFrame {

    /**
     * Creates new form DefaulterList
     */
    DefaultTableModel defaulter;
    public DefaulterList() {
        initComponents();
        setdetailtotable1();
        setdetailtotable2();
//        checkdate();

        
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
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_issue_book_list = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 102, 51));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<- Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Defaulter List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 210, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 182, 5));

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -2, 17, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 120));

        tbl_issue_book_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue id", "Book Name", "Student Name", "Issue date", "Due Date", "Status", "Fine"
            }
        ));
        tbl_issue_book_list.setGridColor(new java.awt.Color(255, 51, 51));
        tbl_issue_book_list.setShowGrid(true);
        jScrollPane1.setViewportView(tbl_issue_book_list);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1010, 370));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//public Boolean checkdate(String x){
//    LocalDate date=LocalDate.now();
//    String tempdate=date.toString();
//    DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
//    try{
//        Date d=df.parse(x);
//        Date currdate=df.parse(tempdate);
//        if(currdate.after(d) ){
////        JOptionPane.showMessageDialog(this,d);
//            return true;
//        }
//    }
//    catch(Exception e){
//        e.printStackTrace();
//    }
//    return false;
//}
    public void setdetailtotable1(){
    long l=System.currentTimeMillis();
    Date date=new Date(l);
    java.sql.Date due_date = null;

      try{
        
        Connection con=dbconnection.getConnection();
        PreparedStatement pst=con.prepareStatement("select id,due_date from issue_book_detail where status=? and due_date<?");
        pst.setString(1,"pending");
        pst.setDate(2,  date);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){

            int issueid=rs.getInt("id");
           
            String due=rs.getString("due_date");
            due_date=rs.getDate("Due_date");
            setfine(date,due_date,issueid);
//            String status=rs.getString("status");
//            String fine=rs.getString("fine");
            
        }
    }
    catch(Exception e){
        
        e.printStackTrace();
    }
     
}
public void setdetailtotable2(){
    long l=System.currentTimeMillis();
    Date date=new Date(l);


      try{
        
        Connection con=dbconnection.getConnection();
        PreparedStatement pst=con.prepareStatement("select id,bookname,student_name,issue_date,due_date,status,fine from issue_book_detail where status=? and due_date<?");
        pst.setString(1,"pending");
        pst.setDate(2,  date);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){

            int issueid=rs.getInt("id");
            String bookname=rs.getString("bookname");
            String studentname=rs.getString("Student_name");

            String issue=rs.getString("issue_date");
            String due=rs.getString("due_date");
//            due_date=rs.getDate("Due_date");
//            setfine(date,due_date,issueid);
            String status=rs.getString("status");
            String fine=rs.getString("fine");
            Object [] obj={issueid,bookname,studentname,issue,due,status,fine};
            defaulter=(DefaultTableModel)tbl_issue_book_list.getModel();
            defaulter.addRow(obj);
        }
    }
    catch(Exception e){
        
        e.printStackTrace();
    }
     
}
public void setfine(Date date,Date due_date,int issue_id){
     long diff= TimeUnit.DAYS.convert(date.getTime()-due_date.getTime(),TimeUnit.MILLISECONDS);
//      long diff2=TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
      int fine=(int) diff;
      
      
      try{
           Connection con=dbconnection.getConnection();
        PreparedStatement pst=con.prepareStatement("update  issue_book_detail set fine=? where id=?");
        pst.setInt(1,fine);
        pst.setInt(2,issue_id);
        ResultSet rs=pst.executeQuery();
        if(rs.next()){
            
        }
      }
      catch(Exception e){
          e.printStackTrace();

          
      }
}



    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Homepage page=new Homepage();
        page.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        Homepage page=new Homepage();
        page.setVisible(true);
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        System.exit(0);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        //        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseEntered

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
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefaulterList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_issue_book_list;
    // End of variables declaration//GEN-END:variables
}