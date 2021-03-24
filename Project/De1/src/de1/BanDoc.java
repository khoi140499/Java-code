/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class BanDoc implements Serializable{
    private int maBD;
    private String tenBD;
    private String diaChi;
    private int sdt;

    public BanDoc(int maBD, String tenBD, String diaChi, int sdt) {
        this.maBD = maBD;
        this.tenBD = tenBD;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public int getMaBD() {
        return maBD;
    }

    public String getTenBD() {
        return tenBD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getSdt() {
        return sdt;
    }
    
}
