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
public class KhachHang {
    private int maKH;
    private String tenKH;
    private String dChi;
    private boolean gTinh;
    private String ngSinh;
    private String phone;

    public KhachHang() {
    }

    /**
     * @return the maKH
     */
    public int getMaKH() {
        return maKH;
    }

    /**
     * @param maKH the maKH to set
     */
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    /**
     * @return the tenKH
     */
    public String getTenKH() {
        return tenKH;
    }

    /**
     * @param tenKH the tenKH to set
     */
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    /**
     * @return the dChi
     */
    public String getdChi() {
        return dChi;
    }

    /**
     * @param dChi the dChi to set
     */
    public void setdChi(String dChi) {
        this.dChi = dChi;
    }

    /**
     * @return the gTinh
     */
    public boolean isgTinh() {
        return gTinh;
    }

    /**
     * @param gTinh the gTinh to set
     */
    public void setgTinh(boolean gTinh) {
        this.gTinh = gTinh;
    }

    /**
     * @return the ngSinh
     */
    public String getNgSinh() {
        return ngSinh;
    }

    /**
     * @param ngSinh the ngSinh to set
     */
    public void setNgSinh(String ngSinh) {
        this.ngSinh = ngSinh;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
