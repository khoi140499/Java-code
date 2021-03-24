package project1;

import java.util.*;

public class Main {
    static ArrayList<KhachHang>ds =new ArrayList<>();
    public static void menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Nhập khách hàng");
        System.out.println("2. Xuất khách hàng");
        System.out.println("3. Tìm kiếm khách hàng");
        System.out.println("4. Sắp xếp khách hàng");
        System.out.println("5. Lưu khách hàng");
        System.out.println("6. Đọc file");
        System.out.println("7. Thống kê nhà mạng");
        System.out.println("8. Thoát");
        System.out.println("Nhập lựa chọn của bạn: ");
        int n=sc.nextInt();
        switch(n){
            case 1:
                nhap();
                break;
            case 2:
                xuat();
                break;
            case 3:
                timkiem();
                break;
            case 4:
                sapxep();
                break;
            case 5:
                luukh();
                break;
            case 6:
                docfile();
                break;
            case 7:
                thongke();
                break;
            case 8:
                thoat();
                break;
                default:
                    break;
        }
    }
    public static void main(String[] args){
        while(true){
            menu();
            }
   }
    public static void nhap(){
        KhachHang kh=new KhachHang();
        System.out.println("Mời bạn nhập mã: ");
        int ma=(new Scanner(System.in)).nextInt();
        System.out.println("Mời bạn nhập tên: ");
        String ten=(new Scanner(System.in)).nextLine();
        System.out.println("Mời bạn nhập số điện thoại: ");
        String sdt=(new Scanner(System.in)).nextLine();
        kh.setMa(ma);
        kh.setTen(ten);
        kh.setPhone(sdt);
        ds.add(kh);
    }
    public static void xuat(){
        System.out.println("========================================");
        System.out.println("Mã\t   Tên\t\t  Sđt");
        for(KhachHang a:ds)
            System.out.println(a.toString());
        System.out.println("========================================");
    }
    public static void luukh(){
        boolean kt=File.luuFile(ds,"LUU.OUT");
        if(kt==true){
            System.out.println("Lưu file thành công");
        }
        else{
            System.out.println("Lưu file thất bại");
        }
    }
    public static void timkiem(){
        String s="";
        System.out.println("============================");
        System.out.println("Nhập đầu số bạn muốn tìm: ");
        s=(new Scanner(System.in)).nextLine();
        for(KhachHang kh:ds){
            if(kh.getPhone().startsWith(s)){
                System.out.println(kh.toString());
                    }
             }
    }
    public static void sapxep(){
        Collections.sort(ds, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.getPhone().compareTo(o2.getPhone());
            }
        });
        System.out.println("Sắp xếp thành công!!");
    }
    public static void thongke(){
        int n=0;
        for(KhachHang kh:ds){
            if(kh.getPhone().startsWith("038")){
                n++;
            }
        }
        System.out.println("Có "+n+" khách hàng dùng viettel");
    }
    public static void docfile(){
        ds=File.docFile("LUU.OUT");
        System.out.println("Đã đọc file thành công");
    }
    public static void thoat(){
        System.out.println("Cảm ơn bạn đã xử dụng!!!!!");
        System.exit(0);
    }
}
