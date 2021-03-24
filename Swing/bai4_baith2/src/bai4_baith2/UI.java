package bai4_baith2;

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
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class UI extends JFrame{
    JTextArea txtnhap;
    JButton btnmofile, btnluu, btnthoat, btnluusx;
    JList list;
    JTable tb;
    DefaultTableModel dm;
    Vector<Monhoc> monhoc=new Vector<>();
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
        JPanel pntrai=new JPanel(new BorderLayout());
        trai.setLayout(new FlowLayout());
        dm=new DefaultTableModel();
        dm.addColumn("Ma Mon");
        dm.addColumn("Ten Mon");
        dm.addColumn("Nhom Mon");
        dm.addColumn("So Tin Chi");

        tb=new JTable(dm);
        tb.setPreferredSize(new Dimension(400, 300));
        JScrollPane js=new JScrollPane(tb,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pntrai.add(js, BorderLayout.CENTER);
        main.add(trai);
        trai.add(pntrai);
               
        
        JPanel phai=new JPanel();
        phai.setLayout(new FlowLayout());
        JPanel pnphai=new JPanel();
        pnphai.setLayout(new BoxLayout(pnphai, BoxLayout.Y_AXIS));
        phai.add(pnphai);
        main.add(phai);
        
        JPanel but=new JPanel();
        but.setLayout(new FlowLayout());
        btnmofile=new JButton("Mo file");
        but.add(btnmofile);
        pnphai.add(but);
        
        JPanel but1=new JPanel();
        but1.setLayout(new FlowLayout());
        btnluu=new JButton("Sap Xep Theo Nhom Mon Hoc");
        but1.add(btnluu);
        pnphai.add(but1);
        
        JPanel but2=new JPanel();
        but2.setLayout(new FlowLayout());
        btnluusx=new JButton("Sap Xep Theo Tin Chi");
        but2.add(btnluusx);
        pnphai.add(but2);
        
        JPanel but3=new JPanel();
        but3.setLayout(new FlowLayout());
        btnthoat=new JButton("Thoat");
        but3.add(btnthoat);
        pnphai.add(but3);
        
    }
    private void addEvent() {
        btnthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnmofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    moFile();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            private void moFile() throws FileNotFoundException {
                JFileChooser mo=new JFileChooser();
                if(mo.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    File mof=mo.getSelectedFile();
                    Scanner sc=new Scanner(mof);
                    String maMon="";
                    String tenMon="";
                    String soTinChi="";
                    String nhomMon="";
                    int dem=0,kt=0;
                    while(sc.hasNext()){
                        try{
                            dem++;
                            maMon=sc.nextLine();
                            if(maMon.length()!=4){
                                sc.nextLine();
                                sc.nextLine();
                                sc.nextLine();
                                try{
                                    throw new Exception("Mon hoc thu "+dem+"  sai thong tin: NHAP SAI DINH DANG MA MON");
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null, ""+e.getMessage());
                                }
                            }
                            else{
                                tenMon=sc.nextLine();
                                if(tenMon.length()==0){
                                    sc.nextLine();
                                    sc.nextLine();
                                    try{
                                        throw new Exception("Mon hoc thu "+dem+"  sai thong tin: TEN KHONG DUOC DE TRONG");
                                    }catch(Exception e){
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }
                                else{
                                    nhomMon=sc.nextLine();
                                        if(nhomMon.equalsIgnoreCase("co ban")==false &&
                                        nhomMon.equalsIgnoreCase("co so nghanh")==false &&
                                        nhomMon.equalsIgnoreCase("chuyen nghanh")==false &&
                                        nhomMon.equalsIgnoreCase("ky nang mem")==false){
                                            try{
                                                throw new Exception("Mon hoc thu "+dem+"  sai thong tin: SAI TEN NHOM MON HOC");
                                            }catch(Exception e){
                                                JOptionPane.showMessageDialog(null, e.getMessage());
                                            }
                                    }else{
                                        soTinChi=sc.nextLine();
                                    if(soTinChi.equalsIgnoreCase("0")==false &&
                                            soTinChi.equalsIgnoreCase("1")==false &&
                                            soTinChi.equalsIgnoreCase("2")==false &&
                                            soTinChi.equalsIgnoreCase("3")==false &&
                                            soTinChi.equalsIgnoreCase("4")==false &&
                                            soTinChi.equalsIgnoreCase("5")==false &&
                                            soTinChi.equalsIgnoreCase("6")==false &&
                                            soTinChi.equalsIgnoreCase("7")==false){
                                        sc.nextLine();
                                        try{
                                            throw new Exception("Mon hoc thu "+dem+"  sai thong tin: SO TIN CHI PHAI LON HON 0 VA NHO HON 10");
                                        }catch(Exception e){
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                             }
                                        }
                                        else kt=1;
                                    }
                                }
                            }
                        }catch(NumberFormatException|InputMismatchException e){
                            JOptionPane.showMessageDialog(null, "Mon hoc thu "+dem+" sai thong tin: NHAP SAI DINH DANG");
                        }
                        if(kt==1){
                            Monhoc mh=new Monhoc(maMon, tenMon, nhomMon, soTinChi);
                            monhoc.add(mh);
                            kt=0;
                        }
                    }
                    for(Monhoc a:monhoc){
                        Vector<String> vec=new Vector<>();
                        vec.add(a.getMaMon());
                        vec.add(a.getTenMon());
                        vec.add(a.getNhomMon());
                        vec.add(a.getSoTinChi());
                        dm.addRow(vec);
                    }
                }
            }
        });
        btnluu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser luu =new JFileChooser();
                if(luu.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    try {
                        PrintWriter pr=new PrintWriter(luu.getSelectedFile());
                        sapxep1();
                        for(Monhoc a:monhoc)
                            pr.println(a.toString());
                            pr.close();
                            JOptionPane.showMessageDialog(null, "Luu thanh cong");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }); 
        btnluusx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser sx=new JFileChooser();
                if(sx.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    try {
                        PrintWriter pr=new PrintWriter(sx.getSelectedFile());
                        sapxep2();
                        for(Monhoc d:monhoc)
                            pr.println(d.toString());
                            pr.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    public void sapxep2(){
        Collections.sort(monhoc, new Comparator(){
                        @Override
                        public int compare(Object o1, Object o2) {
                            return (new String(((Monhoc)o1).getTenMon()).compareToIgnoreCase(new String(((Monhoc)o2).getTenMon())));
                        }
                        });
        Comparator<Monhoc> com=new Comparator<Monhoc>() {
            @Override
            public int compare(Monhoc o1, Monhoc o2) {
                return o1.getNhomMon().compareToIgnoreCase(o2.getNhomMon());
            }
        };
        Collections.sort(monhoc, com);
    }
    public void sapxep1() {
                    Collections.sort(monhoc, new Comparator<Monhoc>(){
                        @Override
                        public int compare(Monhoc o1, Monhoc o2) {
                            return o1.getSoTinChi().compareTo(o2.getSoTinChi());
                        }
                        });
    }
    public void showWindow(){
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
