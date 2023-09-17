 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;


import java.sql.*;
public class dbconnection {
    
    static Connection con=null;
    public static Connection getConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
             DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            System.out.println("Drivers loaded ");
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","chirag");
//            System.out.println("Connection established");
            //TODO WORK
//            con.close();
        }
        catch(Exception e){
            System.out.println("Driver loaded failure");
//          System.out.println(e.printStackTrace());
        }
        
    return con;
    }
    public static void main(String args[]){
        Connection x=getConnection();
        try(x){
                   System.out.println("Established"); }
//                   System.out.println(" "+x); } 
        catch(Exception e){
            System.out.print("failed");
        }
    }
}

