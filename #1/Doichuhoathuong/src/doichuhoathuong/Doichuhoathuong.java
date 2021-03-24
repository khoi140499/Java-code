package doichuhoathuong;

public class Doichuhoathuong {

    public static void main(String[] args) {
       String s="hoàng đăng khôi";
       s=s.toUpperCase();
        System.out.println(s);
        
        s="hoàng đăng khôi";
        s=s.replaceFirst("o", "o".toUpperCase());
        System.out.println(s);
        
         s="hoàng đăng khôi";
         s=s.replaceFirst((s.charAt(0)+""), (s.charAt(0)+"").toUpperCase());
        System.out.println(s);
        
        s="HOÀNG ĐĂNG KHÔI";
        s=s.replaceFirst((s.charAt(1)+""), (s.charAt(1)+"").toLowerCase());
        System.out.println(s);
    }
    
}
