package pkg6;

import java.io.Serializable;

public class ThietBi implements Serializable{
    //mã TB, Tên, Xuất xứ, Năm sản xuất
    private int maTB;
    private String tenTB;
    private String xuatXu;
    private int namSX;

    public ThietBi() {
    }

    public ThietBi(int maTB, String tenTB, String xuatXu, int namSX) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.xuatXu = xuatXu;
        this.namSX = namSX;
    }

    public int getMaTB() {
        return maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public int getNamSX() {
        return namSX;
    }
    
}
