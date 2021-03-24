package QuanLyDiemSV;
public class MonHoc {
    private int maMon;
    private String tenMon;
    private int stc;
    private String loaiMon;
    private SinhVien sv=new SinhVien();
    public MonHoc() {
    }
    public MonHoc(int maMon, String tenMon, int stc, String loaiMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.stc = stc;
        this.loaiMon = loaiMon;
    }
    public int getMaMon() {
        return maMon;
    }
    public String getTenMon() {
        return tenMon;
    }
    public int getStc() {
        return stc;
    }
    public String getLoaiMon() {
        return loaiMon;
    }
    public SinhVien getSv() {
        return sv;
    }
    public void setSv(SinhVien sv) {
        this.sv = sv;
    }
    @Override
    public String toString() {
        return this.maMon+"\r\n"+this.tenMon+"\r\n"+this.stc+"\r\n"+this.loaiMon;
    }
}
