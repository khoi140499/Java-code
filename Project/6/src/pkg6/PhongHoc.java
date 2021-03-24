package pkg6;

import java.io.Serializable;

public class PhongHoc implements Serializable{
    //mã PH, tên phòng, số ghế
    private int maPH;
    private String tenP;
    private int soGhe;

    public PhongHoc() {
    }

    public PhongHoc(int maPH, String tenP, int soGhe) {
        this.maPH = maPH;
        this.tenP = tenP;
        this.soGhe = soGhe;
    }

    public int getMaPH() {
        return maPH;
    }

    public String getTenP() {
        return tenP;
    }

    public int getSoGhe() {
        return soGhe;
    }
    
}
