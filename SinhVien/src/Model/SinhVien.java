/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Khoi
 */
public class SinhVien implements Serializable{
    private int ma;
    private String ten;
    private String ngaysinh;
    private int khoa;
    private String quequan;

    public SinhVien() {
    }

    public SinhVien(int ma, String ten, String ngaysinh, int khoa, String quequan) {
        this.ma = ma;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.khoa = khoa;
        this.quequan = quequan;
    }

    public SinhVien( String ten) {
        this.ten = ten;
    }
    
    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public int getKhoa() {
        return khoa;
    }

    public String getQuequan() {
        return quequan;
    }
    
}
