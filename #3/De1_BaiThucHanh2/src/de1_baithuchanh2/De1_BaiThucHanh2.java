package de1_baithuchanh2;
import java.util.*;
import java.io.*;
public class De1_BaiThucHanh2 {
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<SinhVien> list=new ArrayList<>();
        Scanner sc=new Scanner(new File("VAO.INP"));
        int maSV=0;
        double dtb=0;
        String ten="";
        String lop="";
        int kt=0, dem=0;
        while(sc.hasNext()){
            try{
                dem++;
                maSV=Integer.parseInt(sc.nextLine());
                String s=String.valueOf(maSV);
                if(s.length()!=4){
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                    try{
                        throw new Exception("Sinh vien thu "+dem+" sai thong tin: MA SINH VIEN PHAI CO 4 KY TU");
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    ten=sc.nextLine();
                    if(ten.length()==0){
                        sc.nextLine();
                        sc.nextLine();
                        try{
                            throw new Exception("Sinh vien thu "+dem+" sai thong tin: TEN KHONG DUOC DE TRONG");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        lop=sc.nextLine();
                        if(lop.length()!=9){
                            sc.nextLine();
                            try{
                                throw new Exception("Sinh vien thu "+dem+" sai thong tin: TEN LOP SAI DINH DANG");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else{
                            dtb=Double.parseDouble(sc.nextLine());
                            String a=String.valueOf(dtb);
                            if(dtb<0 || dtb>10){
                                try{
                                    throw new Exception("Sinh vien thu "+dem+" sai thing tin: DIEM TRUNG BINH PHAI LON HON 0 VA NHO HON 10");
                                }catch(Exception e){
                                    System.err.println(e.getMessage());
                                }
                            }else kt=1;
                        }
                    }
                }
            }catch(NumberFormatException|InputMismatchException e){
                System.out.println("SInh vien thu "+dem+" sai thong tin");
            }
            if(kt==1){
                SinhVien sv=new SinhVien(maSV, ten, lop, dtb);
                list.add(sv);
                kt=0;
            }
        }
        for(SinhVien a:list)
            System.out.println(a.toString());
        PrintWriter pr=new PrintWriter("SX.OUT");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (new Double(((SinhVien)o2).getDtb()).compareTo(new Double(((SinhVien)o1).getDtb())));
            }
        });
        Comparator<SinhVien> com=new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                int a= o1.getLop().compareToIgnoreCase(o2.getLop());
                if(o1.getLop().charAt(0)!=o2.getLop().charAt(0)){
                    if(o1.getLop().charAt(1)!=o2.getLop().charAt(1)){
                        if(o1.getLop().charAt(2)!=o2.getLop().charAt(2)){
                            if(o1.getLop().charAt(3)!=o2.getLop().charAt(3)){
                                if(o1.getLop().charAt(4)!=o2.getLop().charAt(4)){
                                    if(o1.getLop().charAt(5)!=o2.getLop().charAt(5)){
                                        if(o1.getLop().charAt(6)!=o2.getLop().charAt(6)){
                                            if(o1.getLop().charAt(7)!=o2.getLop().charAt(7)){
                                                if(o1.getLop().charAt(8)!=o2.getLop().charAt(8))
                                                    return a;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                }
                return o1.getLop().compareToIgnoreCase(o2.getLop());
            }
        };
        Collections.sort(list, com);
        for(SinhVien as:list)
            pr.println(as.toString());
        pr.close();
        PrintWriter pr1=new PrintWriter("SEPLOAI.OUT");
    }
    
}
