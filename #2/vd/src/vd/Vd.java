package vd;

import java.util.*;

public class Vd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> arr=new ArrayList<String>();
        arr.add("Thứ 2");
        arr.add("Thứ 3");
        arr.add("Thứ 4");
        arr.add("Thứ 5");
        arr.add("Thứ 6");
        arr.add("Thứ 7");
        arr.add("Chủ Nhật");
        Iterator<String> vs=null;
        vs=arr.iterator();
        System.out.println("Danh sách phần tử dùng với Iterator: ");
        while(vs.hasNext()){
            System.out.println(vs.next());
        }
        ListIterator<String> vds=null;
        vds=arr.listIterator();
        System.out.println("Danh sách phần tử dùng với Listiterator: ");
        while(vds.hasNext()){
            System.out.println(vds.next());
        }
        System.out.println("Nhập giá trị cần thay đổi: ");
        String gt=sc.nextLine();
        System.out.println("Nhập vị trí cần thay đổi: ");
        int vt=sc.nextInt();
        arr.set(vt, gt);
        System.out.println("Danh sách sau khi thay đổi giá trị : ");
        for(String st:arr){
            System.out.println(st);
        }
        arr.remove(vt);
        System.out.println("Danh sách sau khi xóa phần tử : ");
        for(String hf:arr){
            System.out.println(hf);
        }
        System.out.println("Danh sách được đảo lại là: ");
        for(int i=arr.size()-1;i>=0;i--){
            System.out.println(arr.get(i)+" ");
    }
    }
}
