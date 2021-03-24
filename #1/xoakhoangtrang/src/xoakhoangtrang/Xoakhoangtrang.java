
package xoakhoangtrang;

public class Xoakhoangtrang {

    public static void main(String[] args) {
       String s1="   Tên tôi là Hoàng Đăng Khôi   ";
        System.out.println(s1);
        System.out.println("Chiều dài = "+s1.length());
        s1=s1.trim();
        System.err.println("Chiều dài = "+s1.length());
        System.out.println(s1);
        String s="  Obama ăn cơm chưa với Putin  ";
        int vtrileft=0;
        int i=0;
        for (i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            if(c==' ') vtrileft=i;
            else break;
        }
        s=s.substring(i);
        System.out.println(s);
    }
    
}
