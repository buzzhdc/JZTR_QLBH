/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ductr
 */
public class SanPhamDAO implements SanPhamInterface{
    Connection cn;
    String url;
    public SanPhamDAO(){
        url="jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;userName=sa;password=123";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public int themSanPham(SanPham sp) {
        
        int kq=0;
        return kq;
    }

    @Override
    public int updateSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int themLoaiSP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
