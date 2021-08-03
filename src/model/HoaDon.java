/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ductr
 */
public class HoaDon {
    private String maHoaDon;
    private int maKhachHang;
    private String maNV;
    private double tongTien;

    public HoaDon(String maHoaDon, int maKhachHang, String maNV, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNV = maNV;
        this.tongTien=tongTien;

    }

    public HoaDon() {
    }

    /**
     * @return the maHoaDon
     */
    public String getMaHoaDon() {
        return maHoaDon;
    }

    /**
     * @param maHoaDon the maHoaDon to set
     */
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    /**
     * @return the maKhachHang
     */
    public int getMaKhachHang() {
        return maKhachHang;
    }

    /**
     * @param maKhachHang the maKhachHang to set
     */
    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    /**
     * @return the maNV
     */
    public String getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public void setTongTien(double tongTien){
        this.tongTien=tongTien;
    }
    public double getTongTien(){
        return tongTien;
    }
}
