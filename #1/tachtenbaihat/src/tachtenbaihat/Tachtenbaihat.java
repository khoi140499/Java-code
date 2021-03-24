
package tachtenbaihat;

public class Tachtenbaihat {
    public static String tenbaihat (String baihat){
        int vtcuoi=baihat.lastIndexOf("/");
        String ten=baihat.substring(vtcuoi+1);
        return ten;
    }
    public static String tenbaihat2 (String baihat){
        int vtcuoi1=baihat.lastIndexOf("/");
        int vtcuoi2=baihat.indexOf(".");
        String ten=baihat.substring(vtcuoi1+1, vtcuoi2);
        return ten;
    }
    public static void main(String[] args) {
        String baihat="/home/khoi/Downloads/longme.mp3";
        String kq=tenbaihat(baihat);
        System.out.println(kq);
        
        String kq2=tenbaihat2(baihat);
        System.out.println(kq2);
    }
    
}
