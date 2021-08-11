/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ductr
 */
public class LoginDAO {
    Connection cn;
    String url;
    public LoginDAO(){
         url="jdbc:sqlserver://localhost:1433;"
                 + "databaseName=QLBANHANG;userName=sa;password=123";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url);
            System.out.println("Connect thành công");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public String[] checkLogin(String id, String pw){
        String [] arr = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery
        ("select * from NHANVIEN WHERE MANV like '"+id+"' and password like '"+pw+"'");
            if(rs.next()){
                arr[0]=rs.getString(2);//id
                arr[1]=rs.getString(7);//nql
                arr[2]=rs.getString(8);//ca lam
                arr[3]=rs.getString(9);//password
            }else{
                arr[0]="null";
                arr[1]="null";
                arr[2]="null";
                arr[3]="null";
            }
            rs.close();
            st.close();
            return arr;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
