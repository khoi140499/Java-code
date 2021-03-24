package bai11_b;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class File {
    public static boolean luuFile(ArrayList<KhanhHang> dsKH, String path){
        try{
            FileOutputStream fp=new FileOutputStream(path);
            OutputStreamWriter osw=new OutputStreamWriter(fp, "UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            for(KhanhHang k:dsKH)
            {
                String line =k.getMa()+";"+k.getTen();
                bw.write(line);
                bw.newLine();//luu xong xuong dong de dong tiep theo
            }
            bw.close();
            osw.close();
            fp.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
