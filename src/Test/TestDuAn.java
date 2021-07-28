/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import model.SanPham;
import model.SanPhamDAO;

/**
 *
 * @author thanh
 */
public class TestDuAn {
    public static void main(String[] args) throws ParseException {
        System.out.println("Hí anh em");
        
        String date=java.time.LocalDate.now()+"";
        System.out.print(date);
        SanPhamDAO dao = new SanPhamDAO();
        ArrayList<SanPham> list;
        list=dao.getAll();
        boolean a= list.get(list.size()-1).isOutOfDate();
        System.out.print(a);
        //git commit
       
    }
}
