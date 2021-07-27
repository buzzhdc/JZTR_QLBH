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
public class LoaiHang {
    private String tenLoai;
    private int maLoai;

    /**
     * @return the tenLoai
     */
    public String getTenLoai() {
        return tenLoai;
    }

    /**
     * @param tenLoai the tenLoai to set
     */
    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiHang(String tenLoai, int maLoai) {
        this.tenLoai = tenLoai;
        this.maLoai = maLoai;
    }

    /**
     * @return the maLoai
     */
    public int getMaLoai() {
        return maLoai;
    }

    /**
     * @param maLoai the maLoai to set
     */
    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }
    
    
}
