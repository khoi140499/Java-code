/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de20;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class DSThuePhong implements Serializable{
    private String tenKH;
    private String tenPhong;
    private String loaiPhong;
    private String ngayThue;

    public DSThuePhong(String tenKH, String tenPhong, String loaiPhong, String ngayThue) {
        this.tenKH = tenKH;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.ngayThue = ngayThue;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public String getNgayThue() {
        return ngayThue;
    }
    
}
