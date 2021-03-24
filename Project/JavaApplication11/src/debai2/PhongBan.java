/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debai2;

import java.util.ArrayList;

/**
 *
 * @author hiepp
 */
public class PhongBan {
    private int maPb;
    private String tenPhong;
    private String moTa;
    private  int hesoCV;

    public PhongBan() {
    }

    public PhongBan(int maPhong, String tenPhong, String moTa, int hesoCV) {
        this.maPb = maPhong;
        this.tenPhong = tenPhong;
        this.moTa = moTa;
        this.hesoCV = hesoCV;
    }

    public int getMaPb() {
        return maPb;
    }

    public void setMaPhong(int maPhong) {
        this.maPb = maPb;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHesoCV() {
        return hesoCV;
    }

    public void setHesoCV(int hesoCV) {
        this.hesoCV = hesoCV;
    }


    
    
}
