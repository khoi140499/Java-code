/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de19;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class DanhSach implements Serializable{
    private String tenSV;
    private String tenPhong;
    private String loaiPhong;
    private String ngayThue;

    public DanhSach(String tenSV, String tenPhong, String loaiPhong, String ngayThue) {
        this.tenSV = tenSV;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.ngayThue = ngayThue;
    }

    public String getTenSV() {
        return tenSV;
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
