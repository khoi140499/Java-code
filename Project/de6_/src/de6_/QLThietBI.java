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
public class QLThietBI implements Serializable{
    private String tenTB;
    private String tenPhong;
    private int soLuong;
    private String tinhTrang;

    public QLThietBI(String tenTB, String tenPhong, int soLuong, String tinhTrang) {
        this.tenTB = tenTB;
        this.tenPhong = tenPhong;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public String getTenTB() {
        return tenTB;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

}
