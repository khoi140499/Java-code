package file;
import java.util.ArrayList;

public class FIle {
    public static void main(String[] args) {
        ArrayList<String> dsData=new ArrayList<>();
        dsData.add("Obama");
        dsData.add("Putin");
        dsData.add("Kim Jon Un");
        dsData.add("Tap Can Binh");
        boolean kq=Test.luuFile(dsData, "D:/codejava/dulieutest.txt");
        if(kq==true){
            System.out.println("Luu file thanh cong");
        }
        else System.out.println("Luu file that bai");
    }
    
}
