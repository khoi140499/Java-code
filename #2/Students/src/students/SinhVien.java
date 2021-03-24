package students;
public class SinhVien {
    private String te;
    private String lop;
    private double toan;
    private double li;
    private double hoa;
    public SinhVien() {
        
    }
    public SinhVien(String te, String lop, double toan, double li, double hoa) {
        this.te = te;
        this.lop = lop;
        this.toan = toan;
        this.li = li;
        this.hoa = hoa;
    }

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getLi() {
        return li;
    }

    public void setLi(double li) {
        this.li = li;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }
    private double tong(){
        return this.toan+this.li+this.toan;
    }
    public double dtb(){
        double tb=tong()/3;
        return tb;
    }
    public void xeploai(){
        if(dtb()>8)
            System.out.println("Hoc sinh "+this.te+" dat hoc luc gioi");
        else if(dtb()>7)
            System.out.println("Hoc sinh "+this.te+" dat hoc luc kha");
        else if(dtb()>5)
            System.out.println("Hoc sinh "+this.te+" dat hoc luc trung binh");
        else 
            System.out.println("Hoc sinh "+this.te+" dat hoc luc yeu");
    }
}
