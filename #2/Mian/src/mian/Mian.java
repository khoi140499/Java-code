package mian;
import java.io.*;
import java.util.*;
public class Mian {
    public static void main(String[] args) throws IOException {
        File f1=new File("D:\\codejava\\2\\Mian\\MONHOC.INP");
        Scanner sc=new Scanner(f1);
        int mamon=0;
        int sotinchi=0;
        String tenmon=" ";
        String nhommon=" ";
        int kt=0, dem=0;
        ArrayList<MonHoc>ds=new ArrayList<>();
        while(sc.hasNext()){
        try{
            dem++;
            mamon=Integer.parseInt(sc.nextLine());
            String s=String.valueOf(mamon);
            if(s.length()!=4){
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
               try{
                   throw new ngoaile("Mon thu "+dem+" nhap sai ma mon co 4 chu so");
               }catch(ngoaile e){
                   System.out.println(e.getMessage());
               }
            }
            else{
                tenmon=sc.nextLine();
                if(tenmon.length()==0){
                    sc.nextLine();
                    sc.nextLine();
                    try{
                        throw new ngoaile("Mon thu "+dem+"bi loi Khong de trong ten mon");
                    }catch(ngoaile e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    nhommon=sc.nextLine();
                    if(nhommon.equals("Co ban")==false && nhommon.equals("Co so so nghanh")==false
                    && nhommon.equals("Chuyen nghanh")==false && nhommon.equals("Ky nang mem")==false){
                        try{
                            throw new ngoaile("Mon thu "+dem+" bi loi: Ten mon hoc khong ton tai");
                        }catch(ngoaile e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                        sotinchi=Integer.parseInt(sc.nextLine());
                        if(sotinchi<=0 || sotinchi>7){
                            try{
                                throw new ngoaile("Mon hoc thu "+dem+" bi loi : Nhap sai so tin chi phair lon hon 0 vaf nho hon 7");
                            }catch(ngoaile e){
                                System.out.println(e.getMessage());
                            }
                           
                    } else kt=1;
                }
            }
        }catch(NumberFormatException|InputMismatchException e){
            System.out.println("Mon thu "+dem+" bi loi nhap sai: Nhap sai dinh dang");
        }
        if(kt==1){
            MonHoc mh=new MonHoc(mamon, tenmon, nhommon, sotinchi);
            ds.add(mh);
            kt=0;
        }
    }
        for(MonHoc monhoc:ds){
            System.out.println(monhoc.toString());
        }
        PrintWriter pr=new PrintWriter(new File("D:\\codejava\\2\\Mian\\NHOM.OUT"));
        Collections.sort(ds,new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               return (new Integer(((MonHoc)o1).sotinchi).compareTo(new Integer(((MonHoc)o2).sotinchi)));
            }
        });
        System.out.println("Sap xep");
        for(MonHoc monhoc:ds){
            System.out.println(monhoc.toString());
        }
        for(MonHoc monhoc:ds){
            pr.println(sc.toString());
        }
        pr.close();
   }
}
