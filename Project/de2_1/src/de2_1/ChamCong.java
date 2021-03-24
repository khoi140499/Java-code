package de2_1;
public class ChamCong {
    private int maCC;
    private Pair<NhanVien, PhongBan> pair;
    private int soNgay;
    public ChamCong() {
    }
    public ChamCong(int maCC, Pair<NhanVien, PhongBan> pair, int soNgay) {
        this.maCC = maCC;
        this.pair = pair;
        this.soNgay = soNgay;
    }
    public int getMaCC() {
        return maCC;
    }
    public Pair<NhanVien, PhongBan> getPair() {
        return pair;
    }
    public int getSoNgay() {
        return soNgay;
    }
}
