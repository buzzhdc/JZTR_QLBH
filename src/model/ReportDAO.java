/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ductr
 */
public class ReportDAO {
    Connection cn;
    String url;
    public Vector<String> head;
    public Vector data;
    public int rowCount,tongSL;
    public double tongTien;
    public ReportDAO(){
        head = new Vector<String>();
        data = new Vector();
        url="jdbc:sqlserver://localhost:1433;"
                + "databaseName=QLBANHANG;userName=sa;password=123";

        rowCount=0;
        tongTien=0;
        tongSL=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void setVector(String min,String max, int role){
        if(role==1){
        try{
            PreparedStatement ps = cn.prepareStatement
        ("select MaHoaDon as'Mã Hóa đơn',TongTien as 'Tổng tiền',MaNV as 'Nhân Viên', "
                + " MaKH as 'Khách hàng' from hoadon \n" +
            "where convert(date,MaHoaDon,120) between ? and ? ");
            ps.setString(1, min);
            ps.setString(2,max);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rmd=rs.getMetaData();
            for(int i=1;i<=rmd.getColumnCount();i++){
                    head.add(rmd.getColumnName(i));   
                }
            while(rs.next()){
                Vector row = new Vector();
                for(int i=1; i<=rmd.getColumnCount();i++){
                    row.add(rs.getString(i));             
                }
                data.add(row);
                rowCount+=1;
            }
                rs.close();
                ps.close();
            PreparedStatement ps2=cn.prepareStatement
        ("select sum(TongTien) from HOADON \n " +
        "where convert(date,MaHoaDon,120) between ? and ? ");
            ps2.setString(1, min);
            ps2.setString(2,max);
            ResultSet rs2=ps2.executeQuery();
            if(rs2.next()){
                tongTien= rs2.getDouble(1);
            }else tongTien=100;
            rs2.close();
            ps2.close();
            
        } catch (SQLException ex) {
        }
        }else{
            try {
                PreparedStatement ps = cn.prepareStatement
                ("select HANGHOA.TENHANG as 'Tên hàng hóa',\n" +
                "CHITIETHOADON.MaHang as'Mã hàng',\n" +
            "sum(CHITIETHOADON.SoLuong) as 'Tổng số lượng bán'\n" +
            "from CHITIETHOADON inner join HANGHOA on"
                        + " HANGHOA.MAHANG=CHITIETHOADON.MaHang\n" +
            "where convert(date,MaHoaDon,120) between ? and ?\n" +
            "group by chitiethoadon.MAHANG,TENHANG\n" +
            "order by sum(CHITIETHOADON.SoLuong) desc");
                ps.setString(1, min);
                ps.setString(2,max);
                ResultSet rs = ps.executeQuery();
            ResultSetMetaData rmd=rs.getMetaData();
            for(int i=1;i<=rmd.getColumnCount();i++){
                    head.add(rmd.getColumnName(i));   
                }
            while(rs.next()){
                Vector row = new Vector();
                for(int i=1; i<=rmd.getColumnCount();i++){
                    row.add(rs.getString(i));             
                }
                data.add(row);
                rowCount+=1;
            }
                rs.close();
                ps.close();
            PreparedStatement ps2=cn.prepareStatement
                     ("select sum(CHITIETHOADON.SoLuong) from CHITIETHOADON \n" +
                "where convert(date,MaHoaDon,120) between ? and ? ");
            ps2.setString(1, min);
            ps2.setString(2,max);
            ResultSet rs2=ps2.executeQuery();
            if(rs2.next()){
                tongSL= rs2.getInt(1);
            }else tongTien=100;
            rs2.close();
            ps2.close();
                
            } catch (SQLException ex) {
            }
        } 
    }
}
