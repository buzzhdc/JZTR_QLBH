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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ductr
 */
public class SanPhamDAO implements SanPhamInterface{
    Connection connec;
    String url;
    public SanPhamDAO(){
        url="jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;userName=QLBanHangAdmin;password=12345";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connec=DriverManager.getConnection(url);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public int themSanPham(SanPham sp) {
        try {
            int kq = 0;
            PreparedStatement ps = connec.prepareStatement(
                    "insert into HangHoa values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, sp.getLoHang());
            ps.setInt(2, sp.getMaLoai());
            ps.setString(3, sp.getTenHang());
            ps.setDouble(4, sp.getGiaNhap());
            ps.setDouble(5, sp.getGiaBan());
            ps.setInt(6, sp.getSoLuong());
            ps.setInt(7, sp.getSoLuongMin());
            ps.setString(8, sp.getNSX());
            ps.setString(9, sp.getHSD());
            ps.setInt(10, sp.getHSDMin());
            kq = ps.executeUpdate();//Trả về 0 đăng nhập thất bại, !=0 thành công
            ps.clearBatch();
            ps.close();
            connec.close();
            //connec.rollback();
            return kq;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            e.printStackTrace();
        }
        return 0;
    }

    //@Override
    public int updateSanPham(SanPham sp) {
        int kq = 0;
        try {
            PreparedStatement ps = connec.prepareStatement(
                    "update HangHoa set LOHANG = ?, MALOAI = ?, TENHANG =?, GIANHAP =?, "
                            + "GIABAN = ?, SOLUONG =?, SOLUONGMIN =?, NSX =?, HSD =?, HSDMIN =? WHERE MAHANG = ?");
            ps.setInt(1, sp.getLoHang());
            ps.setInt(2, sp.getMaLoai());
            ps.setString(3, sp.getTenHang());
            ps.setDouble(4, sp.getGiaNhap());
            ps.setDouble(5, sp.getGiaBan());
            ps.setInt(6, sp.getSoLuong());
            ps.setInt(7, sp.getSoLuongMin());
            ps.setString(8, sp.getNSX());
            ps.setString(9, sp.getHSD());
            ps.setInt(10, sp.getHSDMin());
            ps.setInt(11, sp.getMaHang());
            kq = ps.executeUpdate();
            ps.close();
            connec.close();
            return kq;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            ex.printStackTrace();
        }
        //connec.setAutoCommit(true);
        return 0;
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

    @Override
    public int updateSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
