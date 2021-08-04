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

/**
 *
 * @author thanh
 */
public class KhachHangDAO {
    Connection cn;
    String url;

    public KhachHangDAO() {
        url="jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;userName=sa;password=123";
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
    
    public int ThemKhachHang(KhachHang kh) {
        int kq=0;
        try{
            PreparedStatement ps= cn.prepareStatement
        ("insert into KhachHang values(?,?,?,?,?)");
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getdChi());
            ps.setBoolean(3,kh.isgTinh());
            ps.setString(4, kh.getNgSinh());
            ps.setString(5, kh.getPhone());
            kq=ps.executeUpdate();
            ps.clearBatch();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kq;
    }
}
