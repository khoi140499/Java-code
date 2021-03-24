package bai2_tuluyen;
public class Bai2_tuluyen {
    public static void main(String[] args) {
        SinhVien a=new SinhVien(123, "Hoang Dang Khoi", 8, 10);
        SinhVien b=new SinhVien(124, "An Quang Ngoc", 2, 10);
        SinhVien c=new SinhVien();
        c.setMasv(134);
        c.setTen("Dinh The Vinh");
        c.setLt(3);
        c.setTh(9);
        System.out.println("MSSV"+"\t    "+"ho ten"+"\t"+"diem lt"+"\t"+"diem th"+"\t"+"diem tb");
        System.out.println("----------------------------------------------");
            System.out.println(a.toString());
            System.out.println(b.toString());
            System.out.println(c.toString());
    }
    
}
