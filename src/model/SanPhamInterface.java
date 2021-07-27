/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ductr
 */
public interface SanPhamInterface {
    public int themSanPham(SanPham sp);
    public int updateSanPham();
    public int themLoaiSP();
    ArrayList getAll();
    ArrayList search();
    
}
