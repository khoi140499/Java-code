/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music.Class;

/**
 *
 * @author Dang Khoi
 */
public class BaiHat {
    private String tenBai;
    private String duongDan;

    public BaiHat() {
    }

    public BaiHat(String tenBai, String duongDan) {
        this.tenBai = tenBai;
        this.duongDan = duongDan;
    }

    public String getTenBai() {
        return tenBai;
    }

    public String getDuongDan() {
        return duongDan;
    }

    @Override
    public String toString() {
        return this.tenBai+"\r\n"+this.duongDan;
    }
    
}
