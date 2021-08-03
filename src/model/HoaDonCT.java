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
    private String maHoaDon;
    private int maHoaDonCT;
    private int maHang;
    private int soLuong;

    public HoaDonCT(String maHoaDon, int maHoaDonCT, int maHang, int loHang, int soLuong) {
        this.maHoaDon = maHoaDon;
        this.maHoaDonCT = maHoaDonCT;
        this.maHang = maHang;
        this.soLuong = soLuong;
    }

    public HoaDonCT() {
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

    /**
     * @param loHang the loHang to set


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
