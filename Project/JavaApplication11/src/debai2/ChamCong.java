/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debai2;

/**
 *
 * @author hiepp
 */
public class ChamCong {
    private int maChamCong;
    private Pair<NhanVien, PhongBan> pair;
    private int soNgayLam;

    public ChamCong() {
    }

    public ChamCong(int maChamCong, Pair<NhanVien, PhongBan> pair, int soNgayLam) {
        this.maChamCong = maChamCong;
        this.pair = pair;
        this.soNgayLam = soNgayLam;
    }

    public int getMaChamCong() {
        return maChamCong;
    }

    public void setMaChamCong(int maChamCong) {
        this.maChamCong = maChamCong;
    }

    public Pair<NhanVien, PhongBan> getPair() {
        return pair;
    }

    public void setPair(Pair<NhanVien, PhongBan> pair) {
        this.pair = pair;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }
    
    
    
    
    
}
