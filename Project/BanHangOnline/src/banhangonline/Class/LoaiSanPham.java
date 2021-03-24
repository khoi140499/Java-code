/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banhangonline.Class;

/**
 *
 * @author Dang Khoi
 */
public class LoaiSanPham {
    private String maLoai;
    private String tenLoai;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }
    
}
