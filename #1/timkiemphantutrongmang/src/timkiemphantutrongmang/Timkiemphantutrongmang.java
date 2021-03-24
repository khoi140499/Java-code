package timkiemphantutrongmang;

import java.util.Scanner;

public class Timkiemphantutrongmang {
    public static void nhap(int n, int[] m){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        n=sc.nextInt();
        m=new int[n];
        for(int i=0;i<m.length;i++){
            System.out.print("M["+i+"]: ");
            m[i]=sc.nextInt();
        }
        System.out.println("Mảng đã nhập là: ");
        for(int i=0;i<m.length;i++){
            System.out.print(m[i]+"\t");
        }
         System.out.println("nhập phẩnf tử cần tìm kiếm: ");
         int k=sc.nextInt();
        boolean timkiem=false;
        for(int i=0;i<m.length;i++){
            if(m[i]==k) {
                timkiem = true;
                break;
            }
        }
        if(timkiem==true) {
            System.out.println("phần tử "+k+" có xuất hiện trong mảng");
        }
        else {
            System.out.println("Không tìm thấy");
        }
        int dem=0;
        String s="";
        System.out.println("Nhập phần tử cần tìm :");
        int o=sc.nextInt();
        for(int i=0;i<m.length;i++){
            if(m[i]==o){
                s=s+i+" ; ";
                dem++;
            }
        }
        System.out.print("Phần tử "+k+" ở các vị trí: "+ s);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = 0;
        int[] m=new int[n];
        nhap(n,m); 
    }
    
}
