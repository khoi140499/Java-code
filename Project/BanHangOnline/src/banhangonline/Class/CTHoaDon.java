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
public class CTHoaDon {
    private int maCT;
    private int maSP;
    private int soluong;

    public CTHoaDon() {
    }

    public CTHoaDon(int maCT, int maSP, int soluong) {
        this.maCT = maCT;
        this.maSP = maSP;
        this.soluong = soluong;
    }

    public int getMaCT() {
        return maCT;
    }

    public int getMaSP() {
        return maSP;
    }

    public int getSoluong() {
        return soluong;
    }
    
}
