
package hamdoichuoi;

public class Hamdoichuoi {

    public static void main(String[] args) {
        String s="Xin chào Obama! tôi là Putin đây";
        s=s.replace("Obama", "Kim Jun Un");
        System.out.println(s);
        String s2="Xin chào Obama! tôi mà Michal Obama";
        s2=s2.replaceFirst("Obama", "Putin");
        System.out.println(s2);
    }
    
}
