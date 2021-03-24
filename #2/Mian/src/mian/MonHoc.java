package mian;
public class MonHoc{
    private int mamon;
    int sotinchi;
    private String tenmon;
    private String nhommon;
    public MonHoc() {
        super();
    }
    public MonHoc(int mamon, String tenmon,String nhommon ,int sotinchi) {
        super();
        this.mamon = mamon;
        this.sotinchi = sotinchi;
        this.tenmon = tenmon;
        this.nhommon = nhommon;
    }
    public int getMamon() {
        return mamon;
    }
    public void setMamon(int mamon) {
        this.mamon = mamon;
    }
    public int getSotinchi() {
        return sotinchi;
    }
    public void setSotinchi(int sotinchi) {
        this.sotinchi = sotinchi;
    }
    public String getTenmon() {
        return tenmon;
    }
    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }
    public String getNhommon() {
        return nhommon;
    }
    public void setNhommon(String nhommon) {
        this.nhommon = nhommon;
    }
    //@Override
    
    public String toString(){
        return this.mamon+" "+this.tenmon+" "+this.nhommon+" "+this.sotinchi;
    }
}
