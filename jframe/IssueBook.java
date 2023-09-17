/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author DHAWA
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    static int issue_id = 0;

    public IssueBook() {
        initComponents();
        getIssueid();
//        dateinsert();
    }

    public void getIssueid() {
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select id from issue_book_detail");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                issue_id = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean card_detail() {
        String rollno = label_rollno.getText();

        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select lib_card from student_detail where rollno=?");
            pst.setString(1, rollno);
            ResultSet rs = pst.executeQuery();
            rs.next();
            if (rs.getInt("lib_card") > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
//    Check whether due date is less than issued date
public boolean checkdate(){
    java.util.Date issued_date =  field_issueddate.getDate();
        java.util.Date due_date =   field_duedate.getDate();
       return issued_date.before(due_date);
}

    public boolean issuecheck() {
        String bookid = field_selectedbook.getText();
        String rollno = field_selectedrollno.getText();
        try {

            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from issue_book_detail where bookid=? and rollno=? and status=?");
            pst.setString(1, bookid);
            pst.setString(2, rollno);
            pst.setString(3, "pending");
            ResultSet rs = pst.executeQuery();
//            JOptionPane.showMessageDialog(this,rs);
            if (rs.next()) {
//                JOptionPane.showMessageDialog(this,rs.getString("student_name"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void issue_book() {
//         long l=System.currentTimeMillis();
//       Date date=new Date(l);
        issue_id = issue_id + 1;
        String bookid = label_bookid.getText();
        String bookname = label_bookname.getText();
        String rollno = label_rollno.getText();
        String studentname = label_studentname.getText();
        java.util.Date issued_date =  field_issueddate.getDate();
        

        java.util.Date due_date =   field_duedate.getDate();
        java.sql.Date d1=new java.sql.Date(issued_date.getTime());
        java.sql.Date d2=new java.sql.Date(due_date.getTime());
        String status = "pending";
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into issue_book_detail(id,bookid,bookname,rollno,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, issue_id);
            pst.setString(2, bookid);
            pst.setString(3, bookname);
            pst.setString(4, rollno);
            pst.setString(5, studentname);
            pst.setDate(6,  d1);
            pst.setDate(7, d2);
            pst.setString(8, status);
            int rowcount = pst.executeUpdate();
            if (rowcount > 0) {
                JOptionPane.showMessageDialog(this, "Issued book");
                con.close();
                int rowupdate;
                try (Connection conn = dbconnection.getConnection()) {
                    PreparedStatement npst = conn.prepareStatement("update book_detail set quantity=? where book_id=?");
                    npst.setInt(1, Integer.parseInt(label_quantity.getText()) - 1);
                    npst.setString(2, bookid);
                    rowupdate = npst.executeUpdate();
                        if (rowupdate > 0) {
                    getbookdetail();
                } 

                
                }
            
                catch(Exception ex){
                        ex.printStackTrace();
                        }
                try {
                    Connection scon = dbconnection.getConnection();
                    int cardval = Integer.parseInt(label_batch.getText());
                    PreparedStatement spst = scon.prepareStatement("update student_detail set lib_card=? where rollno=?");
                    spst.setInt(1, cardval - 1);
                    spst.setString(2, rollno);
                    int rowupdate_student = spst.executeUpdate();
                    if (rowupdate_student > 0) {
                        getstudentdetail();
                    }
                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(this ,"inner Error");
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DATE Error");
        
            e.printStackTrace();
        }
    }


    public boolean checkstudent() {
        String rollno = field_selectedrollno.getText();
//          int card=Integer.parseInt(label_batch.getText());

        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_detail where rollno=?");
            pst.setString(1, rollno);
            int rowcount = pst.executeUpdate();
            ResultSet rst = pst.executeQuery();
            rst.next();
            if (rowcount > 0 && rst.getInt("lib_card") > 0) {
                return true;
            } else if (rowcount > 0 && rst.getInt("lib_card") == 0) {
//                JOptionPane.showMessageDialog(this," 0 Library Card left");
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this,"errorfound");
            ex.printStackTrace();
        }
        return false;
    }

    public void getstudentdetail() {
        String rollno = field_selectedrollno.getText();
        if (checkstudent()) {
            try {
                Connection con = dbconnection.getConnection();
                PreparedStatement pst = con.prepareStatement("select * from student_detail where rollno=?");
                pst.setString(1, rollno);
                ResultSet rs = pst.executeQuery();
                rs.next();
                label_rollno.setText(rs.getString("rollno"));
                label_studentname.setText(rs.getString("student_name"));
                label_course.setText(rs.getString("course"));
                label_branch.setText(rs.getString("branch"));
                label_batch.setText(rs.getString("lib_card"));
                label_invalidstudent.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            label_rollno.setText("");
            label_studentname.setText("");
            label_course.setText("");
            label_branch.setText("");
            label_batch.setText("");
            label_invalidstudent.setText("Invalid Rollno");
//            JOptionPane.showMessageDialog(this, "INVALID STUDENT ROLLNO");
        }
    }

    public boolean checkduplicate() {
        String bookid = field_selectedbook.getText();

        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_detail where book_id=?");
            pst.setString(1, bookid);
            int rowcount = pst.executeUpdate();
            if (rowcount > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this,"errorfound");
            ex.printStackTrace();
        }
        return false;
    }

    public void getbookdetail() {
        String bookid = field_selectedbook.getText();

        if (checkduplicate()) {
            try {
                Connection con = dbconnection.getConnection();
                PreparedStatement pst = con.prepareStatement("select * from book_detail where book_id=?");
                pst.setString(1, bookid);
                ResultSet rs = pst.executeQuery();
                rs.next();
                label_bookid.setText(rs.getString("book_id"));
                label_bookname.setText(rs.getString("book_name"));
                label_author.setText(rs.getString("author"));
                label_quantity.setText(rs.getString("quantity"));
                label_invalidbook.setText("");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
//       JOptionPane.showMessageDialog(this,"INVALID BOOK ID");
            label_bookid.setText("");
            label_bookname.setText("");
            label_author.setText("");
            label_quantity.setText("");
            label_invalidbook.setText("Invalid Book");
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

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        extBasicMenuUI1 = new com.jgoodies.plaf.common.ExtBasicMenuUI();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        label_quantity = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        label_bookid = new javax.swing.JLabel();
        label_bookname = new javax.swing.JLabel();
        label_author = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        label_quantity1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        label_bookid1 = new javax.swing.JLabel();
        label_bookname1 = new javax.swing.JLabel();
        label_author1 = new javax.swing.JLabel();
        label_invalidbook = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        label_rollno = new javax.swing.JLabel();
        label_studentname = new javax.swing.JLabel();
        label_batch = new javax.swing.JLabel();
        label_course = new javax.swing.JLabel();
        label_branch = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        label_invalidstudent = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        field_selectedbook = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        field_selectedrollno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        field_duedate = new com.toedter.calendar.JDateChooser();
        field_issueddate = new com.toedter.calendar.JDateChooser();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("<- Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Book Detail");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantity :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 70, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 150, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book Id :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        label_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 160, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Book Name :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Author :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 60, -1));

        label_bookid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_bookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 160, 20));

        label_bookname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, 20));

        label_author.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 160, 20));

        jPanel8.setBackground(new java.awt.Color(255, 102, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(51, 153, 255));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel12.setText("<- Back");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, 20));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Detail");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantity :");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 70, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 150, 5));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book Id :");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        label_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_quantity1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(label_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 160, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Book Name :");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Author :");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 60, -1));

        label_bookid1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_bookid1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(label_bookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 160, 20));

        label_bookname1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_bookname1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(label_bookname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, 20));

        label_author1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_author1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(label_author1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 160, 20));

        label_invalidbook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_invalidbook.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(label_invalidbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 210, 20));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 593));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel2KeyTyped(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student Detail");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 170, 30));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 190, 5));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Name :");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Rollno :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Course :");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 60, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Branch :");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 70, -1));

        label_rollno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_rollno.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 160, 20));

        label_studentname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 160, 20));

        label_batch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_batch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_batch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 160, 20));

        label_course.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 160, 20));

        label_branch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 160, 20));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Lib_Card : ");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 70, -1));

        label_invalidstudent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_invalidstudent.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_invalidstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 210, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 300, 600));

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 30, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 100, 26));
        jLabel3.setText("Issue Books");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 140, -1));

        jPanel5.setBackground(new java.awt.Color(255, 102, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 170, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Book Id");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 100, -1));

        field_selectedbook.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                field_selectedbookFocusLost(evt);
            }
        });
        getContentPane().add(field_selectedbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Student rollno");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 100, -1));

        field_selectedrollno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                field_selectedrollnoFocusLost(evt);
            }
        });
        field_selectedrollno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_selectedrollnoKeyTyped(evt);
            }
        });
        getContentPane().add(field_selectedrollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, 140, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Issue Book");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 120, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Issued date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 100, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Due Date");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 100, -1));
        getContentPane().add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 390, -1, -1));
        getContentPane().add(field_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 160, -1));

        field_issueddate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field_issueddateFocusGained(evt);
            }
        });
        getContentPane().add(field_issueddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 160, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        Homepage page = new Homepage();
        page.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Homepage page = new Homepage();
        page.setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void field_selectedbookFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_selectedbookFocusLost
        getbookdetail();        // TODO add your handling code here:
    }//GEN-LAST:event_field_selectedbookFocusLost

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

    private void field_selectedrollnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_selectedrollnoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_field_selectedrollnoKeyTyped

    private void field_selectedrollnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_selectedrollnoFocusLost
        getstudentdetail();        // TODO add your handling code here:
    }//GEN-LAST:event_field_selectedrollnoFocusLost

    private void jPanel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyTyped

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (checkstudent()) {
            if (checkduplicate()) {
                if (card_detail()) {
                    if (!issuecheck()) {
                        if(checkdate()){
                          issue_book();  
                        }
                        else{
                             JOptionPane.showMessageDialog(this, " Invalid dates");
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(this, " one book can be issued");
                    }
                } else {

                    JOptionPane.showMessageDialog(this, "0 card left ");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid book id");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Invalid student rollno");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void field_issueddateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_issueddateFocusGained
//        dateinsert();        // TODO add your handling code here:
    }//GEN-LAST:event_field_issueddateFocusGained

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private com.jgoodies.plaf.common.ExtBasicMenuUI extBasicMenuUI1;
    private com.toedter.calendar.JDateChooser field_duedate;
    private com.toedter.calendar.JDateChooser field_issueddate;
    private javax.swing.JTextField field_selectedbook;
    private javax.swing.JTextField field_selectedrollno;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel label_author;
    private javax.swing.JLabel label_author1;
    private javax.swing.JLabel label_batch;
    private javax.swing.JLabel label_bookid;
    private javax.swing.JLabel label_bookid1;
    private javax.swing.JLabel label_bookname;
    private javax.swing.JLabel label_bookname1;
    private javax.swing.JLabel label_branch;
    private javax.swing.JLabel label_course;
    private javax.swing.JLabel label_invalidbook;
    private javax.swing.JLabel label_invalidstudent;
    private javax.swing.JLabel label_quantity;
    private javax.swing.JLabel label_quantity1;
    private javax.swing.JLabel label_rollno;
    private javax.swing.JLabel label_studentname;
    // End of variables declaration//GEN-END:variables
}
