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
public class HoaDon {
    private int mahd;
    private String account;
    private String ngayLap;
    private double tongTien;

    public HoaDon() {
    }

    public HoaDon(int mahd, String account, String ngayLap, double tongTien) {
        this.mahd = mahd;
        this.account = account;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getMahd() {
        return mahd;
    }

    public String getAccount() {
        return account;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }
    
}
