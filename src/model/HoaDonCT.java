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
public class HoaDonCT {
    private int maHoaDon;
    private int maHoaDonCT;
    private int maHang;
    private int loHang;
    private int soLuong;

    public HoaDonCT(int maHoaDon, int maHoaDonCT, int maHang, int loHang, int soLuong) {
        this.maHoaDon = maHoaDon;
        this.maHoaDonCT = maHoaDonCT;
        this.maHang = maHang;
        this.loHang = loHang;
        this.soLuong = soLuong;
    }

    public HoaDonCT() {
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
     * @return the maHoaDonCT
     */
    public int getMaHoaDonCT() {
        return maHoaDonCT;
    }

    /**
     * @param maHoaDonCT the maHoaDonCT to set
     */
    public void setMaHoaDonCT(int maHoaDonCT) {
        this.maHoaDonCT = maHoaDonCT;
    }

    /**
     * @return the maHang
     */
    public int getMaHang() {
        return maHang;
    }

    /**
     * @param maHang the maHang to set
     */
    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    /**
     * @return the loHang
     */
    public int getLoHang() {
        return loHang;
    }

    /**
     * @param loHang the loHang to set
     */
    public void setLoHang(int loHang) {
        this.loHang = loHang;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
