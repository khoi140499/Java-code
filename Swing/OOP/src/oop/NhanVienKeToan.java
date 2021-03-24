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
public class NhanVienKeToan extends NhanVien{

    public NhanVienKeToan() {
        super();
    }
    public NhanVienKeToan(String ten, int tuoi, String chucvu){
        super(ten, tuoi, chucvu);
    }
    @Override
    public void luongNhanVien() {
        System.out.println("400$");
    }

    @Override
    public void caLam() {
        System.out.println("ca ngay");
    }
    
}
