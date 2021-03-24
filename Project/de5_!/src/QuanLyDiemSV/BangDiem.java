package QuanLyDiemSV;
public class BangDiem {
    private Pair<SinhVien, MonHoc> pair;
    private double diem;

    public BangDiem() {
    }

    public BangDiem(Pair<SinhVien, MonHoc> pair, double diem) {
        this.pair = pair;
        this.diem = diem;
    }
    
}
