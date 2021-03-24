package pkg6;

import java.io.Serializable;

public class QLThietBi implements Serializable{
    private String tenP;
    private String tenTB;
    private int soLuong;
    private String tinhTrang;

    public QLThietBi() {
    }

    public QLThietBi(String tenP, String tenTB, int soLuong, String tinhTrang) {
        this.tenP = tenP;
        this.tenTB = tenTB;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public String getTenP() {
        return tenP;
    }

    public String getTenTB() {
        return tenTB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }
    
}
