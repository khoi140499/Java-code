package bai2_tuluyen;
public class SinhVien {
    private int masv;
    private String ten;
    private float lt;
    private float th;

    public SinhVien() {
    }

    public SinhVien(int masv, String ten, float lt, float th) {
        this.masv = masv;
        this.ten = ten;
        this.lt = lt;
        this.th = th;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getLt() {
        return lt;
    }

    public void setLt(float lt) {
        this.lt = lt;
    }

    public float getTh() {
        return th;
    }

    public void setTh(float th) {
        this.th = th;
    }
    public float dtb(){
        return (this.getLt()+this.th)/2;
    }
    public String toString(){
        return this.masv+"\t"+this.ten+"\t  "+this.lt+"\t  "+this.th+"\t  "+dtb();
    }
}
