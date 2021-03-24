/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de15;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class DichVu implements Serializable{
    private int maDV;
    private String tenDV;
    private double giaCuoc;
    private String donVi;

    public DichVu(int maDV, String tenDV, double giaCuoc, String donVi) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.giaCuoc = giaCuoc;
        this.donVi = donVi;
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

    public String getDonVi() {
        return donVi;
    }
    
}
