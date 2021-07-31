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
    private int maHoaDon;
    private int maKhachHang;
    private int maNV;
    private String ngayMua;

    public HoaDon(int maHoaDon, int maKhachHang, int maNV, String ngayMua) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNV = maNV;
        this.ngayMua = ngayMua;
    }

    public HoaDon() {
    }

    /**
     * @return the maHoaDon
     */
    public int getMaHoaDon() {
        return maHoaDon;
    }

    /**
     * @param maHoaDon the maHoaDon to set
     */
    public void setMaHoaDon(int maHoaDon) {
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
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the ngayMua
     */
    public String getNgayMua() {
        return ngayMua;
    }

    /**
     * @param ngayMua the ngayMua to set
     */
    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
}
