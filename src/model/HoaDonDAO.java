/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ductr
 */
public class HoaDonDAO implements HoaDonIplm{
    Connection cn;
    String url;
    public HoaDonDAO(){
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
    public int ThemHoaDon(HoaDon hd) {
        int kq=0;
        try{
            PreparedStatement ps= cn.prepareStatement
        ("insert into HoaDon values(?,?,?)");
            ps.setString(1, hd.getMaHoaDon());
            ps.setInt(3, hd.getMaKhachHang());
            ps.setString(2,hd.getMaNV());
            kq=ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            
        }
        return kq;
    }
    
}
