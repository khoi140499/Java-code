package QuanLyDiem;
public class MonHoc {
    //mã môn, tên môn, số tín chỉ, loại môn
    private int maMon;
    private String tenMon;
    private int stc;
    private String loaiMon;

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

    @Override
    public String toString() {
        return this.maMon+"\r\n"+this.tenMon+"\r\n"+this.stc+"\r\n"+this.loaiMon;
    }
    
}
