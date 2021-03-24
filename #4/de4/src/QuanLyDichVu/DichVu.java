/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDichVu;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class DichVu implements Serializable{
    private int maDV;
    private String tenDV;
    private double giaCuoc;
    private String donViTinh;

    public DichVu() {
    }

    public DichVu(int maDV, String tenDV, double giaCuoc, String donViTinh) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.giaCuoc = giaCuoc;
        this.donViTinh = donViTinh;
    }

    public int getMaDV() {
        return maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public double getGiaCuoc() {
        return giaCuoc;
    }

    public String getDonViTinh() {
        return donViTinh;
    }
    
}
