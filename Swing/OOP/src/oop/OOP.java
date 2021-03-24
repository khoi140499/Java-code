/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author Dang Khoi
 */
public class OOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NhanVien a=new NhanVienKho();
        a.setTen("Hoang Dang Khoi");
        a.setTuoi(21);
        a.setChucvu("Nhan vien kho");
        System.out.println(a.toString());
        a.luongNhanVien();
        a.caLam();
        
        NhanVien b=new NhanVienKeToan("An Quang Ngoc", 20, "Nhan Vien Ke Toan");
        System.out.println(b.toString());
        b.caLam();
        b.luongNhanVien();
        
    }
    
}
