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
public abstract class NhanVien {
    private String ten;
    private int tuoi;
    private String chucvu;

    public NhanVien() {
        super();
    }

    public NhanVien(String ten, int tuoi, String chucvu) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.chucvu = chucvu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    
    public abstract void luongNhanVien();
    public abstract void caLam();

    @Override
    public String toString() {
        return this.ten+" - "+this.tuoi+" - "+this.chucvu;
    }
    
    
}
