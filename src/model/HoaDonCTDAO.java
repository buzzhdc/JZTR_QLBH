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
public class HoaDonCTDAO implements HoaDonCTIplm{
    Connection cn;
    String url;
    public HoaDonCTDAO(){
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
    public int addHoaDonCT(HoaDonCT hd) {
        int kq=0;
        try {
            PreparedStatement ps = cn.prepareStatement
                ("Insert into CHITIETHOADON values(?,?,?)");
            ps.setString(1, hd.getMaHoaDon());
            ps.setInt(2, hd.getMaHang());
            ps.setInt(3, hd.getSoLuong());
            kq=ps.executeUpdate();
        } catch (SQLException ex) {
        }
        return kq;
    }

    @Override
    public int updateSP(HoaDonCT ct) {
        int kq=0;
        try {
            PreparedStatement ps = cn.prepareStatement("");
            
        } catch (SQLException ex) {

        }
        return kq;
    }
    
    
}
