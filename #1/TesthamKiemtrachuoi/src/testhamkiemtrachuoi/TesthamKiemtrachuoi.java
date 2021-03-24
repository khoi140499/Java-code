
package testhamkiemtrachuoi;

import java.util.StringTokenizer;

public class TesthamKiemtrachuoi {

    public static void main(String[] args) {
       String s="Học Viện Công Nghệ Bưu Chính Viễn Thông";
       int vtd=s.indexOf("ọ");
        System.out.println("Tìm thấy [ọ] ở vị trí "+vtd);
        int vtc=s.lastIndexOf("n");
        System.out.println("Tìm thấy [n] ở vị trí "+vtc);
        int vtd1=s.indexOf("Viện");
        if(vtd1==-1){
            System.out.println("Không tìm thấy");
        }
        else {
            System.out.println("Tìm thấy");
        }
        if(s.contains("ng"))
            System.out.println("có chữ ng trong chuỗi");
        else 
            System.out.println("không có ng trong chuỗi");
        StringTokenizer token1=new StringTokenizer(s);
        int dem=0;
        while(token1.hasMoreTokens()){
            String value=token1.nextToken();
            if(value.equals("ng")){
                dem++;
            }
        }
        System.out.println("chữ ng xuất hiện " +dem);
    }
    
}
