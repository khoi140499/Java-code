/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6_;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class ThietBi implements Serializable{
    private int ma;
    private String ten;
    private String xuatSu;
    private int namSX;

    public ThietBi(int ma, String ten, String xuatSu, int namSX) {
        this.ma = ma;
        this.ten = ten;
        this.xuatSu = xuatSu;
        this.namSX = namSX;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getXuatSu() {
        return xuatSu;
    }

    public int getNamSX() {
        return namSX;
    }
    
}
