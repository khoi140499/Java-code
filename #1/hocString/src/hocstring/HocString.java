
package hocstring;

public class HocString {

    public static void main(String[] args) {
        String s1=new String();
        String s2=new String("OBAMA");
        String s3="OBAMA";
        System.out.println("Chieu dai cua s1 "+s1.length());
        System.out.println("Chieu dai cua s2 "+s2.length());
        System.out.println("Chieu dai cua s3 "+s3.length());
        if(s2==s3)
            System.out.println("S2 bang S3");
        else
            System.out.println("S2 khong bang S3");
        if(s2.equals(s3))
            System.out.println("gia tri s2 bang s3");
        else
            System.out.println("gia tri s2 khong bang s3");
    }
    
}
