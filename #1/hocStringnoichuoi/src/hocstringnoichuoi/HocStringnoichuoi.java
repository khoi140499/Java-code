package hocstringnoichuoi;

public class HocStringnoichuoi {

    public static void main(String[] args) {
        String s1="Hạnh phúc";
        String s2="Vô thường";
        String s3=s1+" "+s2;
        System.out.println(s3);
        
        String s4="Obama"+1;
        System.out.println(s4);
        String s5="Obama"+1+2;
        System.out.println(s5);
        
        StringBuilder sb=new StringBuilder();
        sb.append(s1);
        sb.append(" ");
        sb.append(s2);
        System.out.println(sb.toString());
    }
    
}
