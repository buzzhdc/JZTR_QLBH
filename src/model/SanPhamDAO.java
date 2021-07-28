/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ductr
 */
public class SanPhamDAO implements SanPhamInterface{
    Connection connec;
    String url;
    public SanPhamDAO(){
        url="jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;userName=sa;"
                + "password=123";
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
           // ps.clearBatch();
            ps.close();
          //  connec.close();
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
           // ps.close();
           // connec.close();
            return kq;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            ex.printStackTrace();
        }
        //connec.setAutoCommit(true);
        return 0;
    }

    @Override
    public int themLoaiSP(LoaiHang lh) {
        int kq=0;
        try{
            PreparedStatement ps=connec.prepareCall("insert into loaihang values(?,?)");
            ps.setString(1,lh.getTenLoai());
            ps.setInt(2, lh.getMaLoai());
            kq=ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            kq=0;
        }
        return kq;
    }

    @Override
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        Statement stmt;
        try{
            stmt=connec.createStatement();
            ResultSet rs=stmt.executeQuery("select * from hanghoa");
            while(rs.next()){
                SanPham temp= new SanPham();
                temp.setMaHang(rs.getInt(1));
                temp.setLoHang(rs.getInt(2));
                temp.setNSX(rs.getString(9));
                temp.setTenHang(rs.getString(4));
                temp.setHSD(rs.getString(10));
                list.add(temp);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }

    @Override
    public ArrayList search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SanPham getByID(int id) {
        SanPham temp=new SanPham();
        try{
            Statement stmt=connec.createStatement();
            ResultSet  rs=stmt.executeQuery("select * from hanghoa where mahang="+id);
            if(rs.next()){
                temp.setMaHang(rs.getInt(1));
                temp.setLoHang(rs.getInt(2));
                temp.setMaLoai(rs.getInt(3));
                temp.setTenHang(rs.getString(4));
                temp.setGiaNhap(rs.getFloat(5));
                temp.setGiaBan(rs.getFloat(6));
                temp.setSoLuong(rs.getInt(7));
                temp.setSoLuongMin(rs.getInt(8));
                temp.setNSX(rs.getString(9));
                temp.setHSD(rs.getString(10));
                temp.setHSDMin(rs.getInt(11));
                rs.close();
                stmt.close();
            }else{
                return null;
            }
            return temp;
        } catch (SQLException ex) {
            return null;
            }
        
        
    }
    
}
