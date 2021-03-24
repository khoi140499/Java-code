package students;
public class Students {
    public static void main(String[] args) {
        SinhVien sv=new SinhVien("Hoang Dang Khoi", "D17CQAT03", 7.9, 8.4, 7.0);
        System.out.println("Diem trung binh: "+sv.dtb());
        sv.xeploai();
    }
    
}
