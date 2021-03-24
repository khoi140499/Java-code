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
public class QLMuonSach implements Serializable{
    private String tenBD;
    private String tenSach;
    private int soLuong;
    private String tinhTrang;

    public QLMuonSach(String tenBD, String tenSach, int soLuong, String tinhTrang) {
        this.tenBD = tenBD;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public String getTenBD() {
        return tenBD;
    }

    public String getTenSach() {
        return tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }
    
}
