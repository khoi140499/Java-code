package bai3_th2;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class UI extends JFrame{
    JTable tb;
    DefaultTableModel dm;
    JButton mo,thoat, sapxept, sapxepn;
    Vector<Sach>sach=new Vector<>();
    public UI(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
    }
    private void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
        con.add(main);
        
        JPanel trai=new JPanel();
        trai.setLayout(new BorderLayout());
        dm=new DefaultTableModel();
        dm.addColumn("Ma Sach");
        dm.addColumn("Ten Sach");
        dm.addColumn("Loai Sach");
        dm.addColumn("Gia Ban");
        
        tb=new JTable(dm);
        JScrollPane js=new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tb.setPreferredSize(new Dimension(500, 400));
        trai.add(js, BorderLayout.CENTER);
        main.add(trai);
        
        JPanel phai=new JPanel();
        phai.setLayout(new BoxLayout(phai, BoxLayout.Y_AXIS));
        main.add(phai);
        
        JPanel a=new JPanel();
        a.setLayout(new FlowLayout());
        mo=new JButton("Mo file");
        a.add(mo);
        phai.add(a);
        
        JPanel b=new JPanel();
        b.setLayout(new FlowLayout());
        sapxept=new JButton("Sap xep theo gia");
        b.add(sapxept);
        phai.add(b);
        
        JPanel c=new JPanel();
        c.setLayout(new FlowLayout());
        sapxepn=new JButton("Sap xep theo chuyen nghanh");
        c.add(sapxepn);
        phai.add(c);
        
        JPanel d=new JPanel();
        d.setLayout(new FlowLayout());
        thoat=new JButton("Thoat");
        d.add(thoat);
        phai.add(d);
    }
    private void addEvent() {
        thoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mofile();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            private void mofile() throws FileNotFoundException {
                JFileChooser mo=new JFileChooser();
                if(mo.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    File file=mo.getSelectedFile();
                    Scanner sc=new Scanner(file);
                    String tenSach="";
                    String loaiSach="";
                    int maSach=0;
                    double giaBan=0;
                    int dem=0, kt=0;
                    while(sc.hasNext()){
                        try{
                            dem++;
                            maSach=Integer.parseInt(sc.nextLine());
                            String s=String.valueOf(maSach);
                            if(s.length()!=4){
                                sc.nextLine();
                                sc.nextLine();
                                sc.nextLine();
                                try{
                                    throw new Exception("Sach thu "+dem+" sai thong tin: NHAP SAI DINH DANG MA SACH");
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                                tenSach=sc.nextLine();
                                if(tenSach.length()==0){
                                    sc.nextLine();
                                    sc.nextLine();
                                    try{
                                        throw new Exception("Sach thu "+dem+" sai thong tin: TEN SACH KHONG DUOC DE TRONG");
                                    }catch(Exception e){
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }else
                                {
                                    loaiSach=sc.nextLine();
                                    if(loaiSach.equalsIgnoreCase("giao khoa")==false && loaiSach.equalsIgnoreCase("ky thuat")==false &&
                                     loaiSach.equalsIgnoreCase("ngoai ngu")==false && loaiSach.equalsIgnoreCase("van hoc")==false &&
                                     loaiSach.equalsIgnoreCase("kinh te")==false && loaiSach.equalsIgnoreCase("thieu nhi")==false &&
                                     loaiSach.equalsIgnoreCase("y hoc")==false && loaiSach.equalsIgnoreCase("lich su")==false &&
                                     loaiSach.equalsIgnoreCase("ky nang song")==false && loaiSach.equalsIgnoreCase("cong nghe thong tin")==false &&
                                     loaiSach.equalsIgnoreCase("truyen tranh")==false && loaiSach.equalsIgnoreCase("chinh tri")==false){
                                        sc.nextLine();
                                        try{
                                            throw new Exception("Sach thu "+dem+" sai thong tin: NHOM SACH KHONG KHONG DUNG");
                                        }catch(Exception e){
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                        }
                                    }else{
                                        giaBan=Double.parseDouble(sc.nextLine());
                                        String b=String.valueOf(giaBan);
                                        if(b.length()==0){
                                            try{
                                                throw new Exception("Sach thu "+dem+" sai thong tin: GIA SACH PHAI LON HON 0");
                                            }catch(Exception e){
                                                JOptionPane.showMessageDialog(null, e.getMessage());
                                            }
                                        }else kt=1;
                                    }
                                }
                            }
                        }catch(NumberFormatException|InputMismatchException e){
                            JOptionPane.showMessageDialog(null, "Sach thu "+dem+" sai thong tin: NHAP SAI DINH DANg");
                        }
                       if(kt==1){
                           Sach sach1=new Sach(maSach, tenSach, loaiSach, giaBan);
                           sach.add(sach1);
                           kt=0;
                       }
                    }
                    for(Sach n:sach){
                        Vector<String> vec=new Vector<>();
                        String a1=String.valueOf(n.getMaSach());
                        String a2=String.valueOf(n.getGiaBan());
                        vec.add(a1);
                        vec.add(n.getTenSach());
                        vec.add(n.getLoaiSach());
                        vec.add(a2);
                        dm.addRow(vec);
                    }
                }
            }
        });
        sapxept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser sx=new JFileChooser();
                if(sx.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    try {
                        PrintWriter pr=new PrintWriter(sx.getSelectedFile());
                        sxg();
                        for(Sach a:sach)
                        pr.println(a.toString());
                        pr.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                
            }
        });
        sapxepn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser sx1=new JFileChooser();
                if(sx1.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    try {
                        PrintWriter pr1=new PrintWriter(sx1.getSelectedFile());
                        sxl();
                        for(Sach a:sach)
                        pr1.println(a.toString());
                        pr1.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    public void sxg(){
        Collections.sort(sach, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (new Double(((Sach)o1).getGiaBan()).compareTo(new Double(((Sach)o2).getGiaBan())));
            }
        });
    }
    public void sxl(){
        Collections.sort(sach, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (new String(((Sach)o1).getTenSach()).compareTo(new String(((Sach)o2).getTenSach())));
            }
        });
        Comparator<Sach> comm=new Comparator<Sach>() {
            @Override
            public int compare(Sach o1, Sach o2) {
                return o1.getLoaiSach().compareToIgnoreCase(o2.getLoaiSach());
            }
        };
           Collections.sort(sach, comm);
    }
    public void showWindow(){
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
