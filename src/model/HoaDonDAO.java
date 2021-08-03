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
        ("insert into HoaDon values(?,?,?,?)");
            ps.setString(1, hd.getMaHoaDon());
            ps.setInt(3, hd.getMaKhachHang());
            ps.setString(2,hd.getMaNV());
            ps.setDouble(4, hd.getTongTien());
            kq=ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            
        }
        return kq;
    }

    @Override
    public int UpdateHoaDon(HoaDon hd) {
         int kq;
        try{
            PreparedStatement ps= cn.prepareStatement
        ("update HOADON set MaNV = ?, MaKH = ?,TongTien = ? where MaHoaDon like ?");
            
            ps.setString(1, hd.getMaNV());
            ps.setInt(2,hd.getMaKhachHang());
            ps.setDouble(3,  hd.getTongTien());
            ps.setString(4,hd.getMaHoaDon());
            kq=ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            return -1;
            
        }
        return kq;
    }
    
}
