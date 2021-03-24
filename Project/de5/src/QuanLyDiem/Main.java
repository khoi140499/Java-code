package QuanLyDiem;

import com.sun.xml.internal.bind.v2.schemagen.Util;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {
    DefaultTableModel dm=new DefaultTableModel();
    DefaultTableModel dm1=new DefaultTableModel();
    DefaultTableModel dm2=new DefaultTableModel();
    DefaultTableModel dm3=new DefaultTableModel();
    Vector a1=new Vector();
    Vector a2=new Vector();
    Vector a3=new Vector();
    Vector a4=new Vector();
    Vector a5=new Vector();
    Vector a6=new Vector();
    Vector a7=new Vector();
    Vector a8=new Vector();
    ArrayList<SinhVien> sv=new ArrayList<SinhVien>();
    ArrayList<MonHoc> mh=new ArrayList<MonHoc>();
    ArrayList<BangDiem> bd=new ArrayList<BangDiem>();
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        txtMaMon.setEnabled(false);
        txtMaSV.setEnabled(false);
        a1.add("Mã sinh viên");
        a1.add("Tên sinh viên");
        a1.add("Địa chỉ");
        a1.add("Số điện thoại");
        a1.add("Lớp");
        dm=(DefaultTableModel)tb1.getModel();
        dm.setDataVector(a2, a1);
        a3.add("Mã môn học");
        a3.add("Tên môn học");
        a3.add("Số tín chỉ");
        a3.add("Nhóm môn");
        dm1=(DefaultTableModel)tb2.getModel();
        dm1.setDataVector(a4, a3);
        a5.add("Stt");
        a5.add("Tên sinh viên");
        a5.add("Tên môn học");
        a5.add("Điểm");
        dm2=(DefaultTableModel)tb3.getModel();
        dm2.setDataVector(a6, a5);
        a7.add("Stt");
        a7.add("Tên sinh viên");
        a7.add("Tên môn học");
        a7.add("Điểm");
        dm3=(DefaultTableModel)tb4.getModel();
        dm3.setDataVector(a8, a7);
        hienSV();
        hienMH();
        loadComBo1();
    }
    private void loadComBo1(){
        comboTenSinhVien.removeAllItems();
        for(int i=0;i<a2.size();i++){
            Vector v=(Vector)a2.get(i);
            comboTenSinhVien.addItem(v.get(1).toString());
        }
    }
    private boolean ktraLop(String s){
        String[] arr=s.split("");
        String s1=arr[1]+arr[2];
        int m=Integer.parseInt(s1);
        String s2=arr[3]+arr[4];
        String s3=arr[5]+arr[6];
        String s4=arr[7]+arr[8];
        int stt=Integer.parseInt(s4);
        if(s.length()!=11 && arr[0].equalsIgnoreCase("d")==false && m>99|m<10 && s2.equalsIgnoreCase("cq")==false && 
                s3.equalsIgnoreCase("vt")==false && s3.equalsIgnoreCase("at")==false && s3.equalsIgnoreCase("cn")==false 
                && s3.equalsIgnoreCase("dt")==false && s3.equalsIgnoreCase("pt")==false && s3.equalsIgnoreCase("kt")==false
                && s3.equalsIgnoreCase("mr")==false && s3.equalsIgnoreCase("tt")==false && s3.equalsIgnoreCase("qt")==false && 
                arr[9].equalsIgnoreCase("-")==false & arr[10].equalsIgnoreCase("b")==false && arr[10].equalsIgnoreCase("n")==false &&
                s4.length()!=2 | stt<99 && stt >10 && s4.equals("00")==false && s4.equals("01")==false && s4.equals("02")==false 
                &&  s4.equals("03")==false && s4.equals("04")==false && s4.equals("05")==false
                &&  s4.equals("06")==false && s4.equals("07")==false && s4.equals("08")==false
                &&  s4.equals("09")==false){
            return true;
        }
        return false;
}
    private boolean ktraTrung(String tenSV, String tenMH){
        for(int i=0;i<tb3.getRowCount();i++){
            if(tb3.getValueAt(i, 1).toString()==tenSV && tb3.getValueAt(i, 2).toString()==tenMH)
                return true;
        }
        return false;
    }
    private void hienSV(){
        File f=new File("SinhVien.txt");
        try {
            Scanner sc=new Scanner(f);
            int maSV=0, dem=0, kt=0;
            String tenSV="", diachi="", sdt="", lop="";
            while(sc.hasNext()){
                try {
                    dem++;
                    maSV=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(maSV);
                    if(s.length()!=5){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("Sinh vien thu "+dem+" sai thong tin: MA SINH VIEN PHAI DU 5 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        tenSV=sc.nextLine();
                        if(tenSV.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            try {
                            throw new Exception("Sinh vien thu "+dem+" sai thong tin: TEN SINH VIEN KHONG DUOC DE TRONG");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        }
                        else{
                            diachi=sc.nextLine();
                            if(diachi.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                                try {
                                    throw new Exception("Sinh vien thu "+dem+" sai thong tin: DIA CHI KHONG DUOC DE TRONG");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                                sdt=sc.nextLine();
                                if(sdt.charAt(0)!='0' && sdt.length()!=9 | sdt.length()!=10){
                                    sc.nextLine();
                                    try {
                                        throw new Exception("Sinh vien thu "+dem+" sai thong tin: SAI SO DIEN THOAI");  
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }
                                else{
                                    lop=sc.nextLine();
                                    if(ktraLop(lop)==true){
                                        try {
                                            throw new Exception("Sinh vien thu "+dem+" sai thong tin: SAI DINH DANG LOP");
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                        }
                                    }
                                    else kt=1;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException|InputMismatchException e) {
                    JOptionPane.showMessageDialog(null, "Sinh vien thu "+dem+" sai thong tin");
                }
                if(kt==1){
                    SinhVien s=new SinhVien(maSV, tenSV, diachi, sdt, lop);
                    sv.add(s);
                    kt=0;
                }
            }
            for(SinhVien as:sv){
                Vector v=new Vector();
                v.add(String.valueOf(as.getMaSV()));
                v.add(as.getTenSV());
                v.add(as.getDiaChi());
                v.add(as.getSdt());
                v.add(as.getLop());
                a2.add(v);
            }tb1.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void hienMH(){
        File f=new File("MonHoc.txt");
        try {
            Scanner sc=new Scanner(f);
            int maMH=0, dem=0, kt=0, stc=0;
            String tenM="", nhomM="";
            while(sc.hasNext()){
                try {
                    dem++;
                    maMH=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(maMH);
                    if(s.length()!=3){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("Mon hoc thu "+dem+" sai thong tin: MA MON HOC PHAI CO 3 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        tenM=sc.nextLine();
                        if(tenM.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                            try {
                                throw new Exception("Mon hoc thu "+dem+" sai thong tin: TEN KHONG DUOC DE TRONG");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        }
                        else{
                            stc=Integer.parseInt(sc.nextLine());
                            if(stc<0 | stc >6){
                                sc.nextLine();
                                try {
                                    throw new Exception("Mon hoc thu "+dem+" sai thong tin: SO TIN CHI PHAI CO TU 1-6");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                                nhomM=sc.nextLine();
                                if(nhomM.equalsIgnoreCase("dai cuong")==false && nhomM.equalsIgnoreCase("co so nghanh")==false && nhomM.equalsIgnoreCase("chuyen nghanh")==false){
                                    try {
                                        throw new Exception("Mon hoc thu "+dem+" sai thong tin: SAI NHOM MON");
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }
                                else kt=1;
                            }
                        }
                    }
                } catch (NumberFormatException | InputMismatchException e) {
                    JOptionPane.showMessageDialog(null, "Mon hoc thu "+dem+" sai thong tin");
                }
                if(kt==1){
                    MonHoc m=new MonHoc(maMH, tenM, stc, nhomM);
                    mh.add(m);
                    kt=0;
                }
            }
            for(MonHoc as:mh){
                Vector v=new Vector();
                v.add(String.valueOf(as.getMaMon()));
                v.add(as.getTenMon());
                v.add(String.valueOf(as.getStc()));
                v.add(as.getLoaiMon());
                a4.add(v);
            }tb2.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtMaSV = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        txtDiaCHi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtLop = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtMaMon = new javax.swing.JTextField();
        txtSoTinCHi = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        comboNhomMon = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        comboTenSinhVien = new javax.swing.JComboBox<>();
        comboTenMonHoc = new javax.swing.JComboBox<>();
        txtDiem = new javax.swing.JTextField();
        txtDIem = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        comboNhomMonHoc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb1);

        jLabel1.setText("Mã sinh viên");

        jLabel2.setText("Tên sinh viên");

        jLabel3.setText("Địac chỉ");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Lớp");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSV)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton1))
                            .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(323, 323, 323))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sinh viên", jPanel1);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tb2);

        comboNhomMon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dai cuong", "co so nghanh", "chuyen nghanh" }));

        jLabel6.setText("Mã môn");

        jLabel7.setText("Tên môn");

        jLabel8.setText("Số tín chỉ");

        jLabel9.setText("Nhóm môn");

        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(228, 643, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(214, 214, 214))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenMon))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(23, 23, 23)
                                .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(20, 20, 20)
                                .addComponent(txtSoTinCHi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboNhomMon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTinCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboNhomMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Môn học", jPanel2);

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tb3);

        tb4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tb4);

        comboTenSinhVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTenSinhVienMouseClicked(evt);
            }
        });

        comboTenMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDIem.setText("Điểm");

        jLabel12.setText("Ten sinh viên");

        jLabel13.setText("Tên môn học");

        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Sắp xếp");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        comboNhomMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dai cuong", "co so nghanh", "chuyen nghanh" }));
        comboNhomMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNhomMonHocActionPerformed(evt);
            }
        });

        jLabel11.setText("Nhóm môn học");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(509, 509, 509)
                        .addComponent(jButton6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDIem)
                            .addComponent(jLabel12))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiem)
                            .addComponent(comboTenSinhVien, 0, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboTenMonHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboNhomMonHoc, 0, 150, Short.MAX_VALUE)))
                            .addComponent(jLabel13)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jButton5)))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(comboNhomMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDIem)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane4)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Bảng điểm", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtMaSV.setText(10000+tb1.getRowCount()+"");
        if(txtTenSV.getText().length()==0){
            try {
                throw new Exception("ten khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(txtDiaCHi.getText().length()==0){
            try {
                throw new Exception("dia chi khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(txtSDT.getText().charAt(0)!='0' && txtSDT.getText().length()!=9 | txtSDT.getText().length()!=10 ){
            try {
                throw new Exception("sai dinh dang so dien thoai");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(ktraLop(txtLop.getText())==true){
            try {
                throw new Exception("sai dinh dang lop");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            Vector v=new Vector();
            v.add(txtMaSV.getText());
            v.add(txtTenSV.getText());
            v.add(txtDiaCHi.getText());
            v.add(txtSDT.getText());
            v.add(txtLop.getText());
            a2.add(v);
            SinhVien v1=new SinhVien(Integer.parseInt(txtMaSV.getText()), txtTenSV.getText(), txtDiaCHi.getText(), txtSDT.getText(), txtLop.getText());
            sv.add(v1);
        }tb1.updateUI();
        try {
            PrintWriter pr=new PrintWriter("SinhVien.txt");
            for(SinhVien as:sv)
                pr.println(as.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row=tb1.getSelectedRow();
        if(row==-1) return;
        dm.removeRow(row);
        try {
            PrintWriter pr=new PrintWriter("SinhVien.txt");
            for(int i=0;i<a2.size();i++){
                Vector v=(Vector)a2.get(i);
                pr.println(v.get(0).toString());
                pr.println(v.get(1).toString());
                pr.println(v.get(2).toString());
                pr.println(v.get(3).toString());
                pr.println(v.get(4).toString());
            }pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtMaMon.setText(100+tb2.getRowCount()+"");
        if(txtTenMon.getText().length()==0){
            try {
                throw new Exception("ten khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(Integer.parseInt(txtSoTinCHi.getText())<1 | Integer.parseInt(txtSoTinCHi.getText()) > 6){
            try {
                throw new Exception("sai so tin chi");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            Vector v=new Vector();
            v.add(txtMaMon.getText());
            v.add(txtTenMon.getText());
            v.add(txtSoTinCHi.getText());
            v.add(comboNhomMon.getSelectedItem().toString());
            a4.add(v);
            tb2.updateUI();
            MonHoc m=new MonHoc(Integer.parseInt(txtMaMon.getText()), txtTenMon.getText(), Integer.parseInt(txtSoTinCHi.getText()), comboNhomMon.getSelectedItem().toString());
            mh.add(m);
        }
        try {
            PrintWriter pr=new PrintWriter("MonHoc.txt");
            for(MonHoc as:mh)
                pr.println(as.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row=tb2.getSelectedRow();
        if(row==-1) return;
        dm1.removeRow(row);
        try {
            PrintWriter pr=new PrintWriter("MonHoc.txt");
            for(int i=0;i<a4.size();i++){
                Vector v=(Vector)a4.get(i);
                pr.println(v.get(0).toString());
                pr.println(v.get(1).toString());
                pr.println(v.get(2).toString());
                pr.println(v.get(3).toString());
            }pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboTenSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTenSinhVienMouseClicked
        loadComBo1();
    }//GEN-LAST:event_comboTenSinhVienMouseClicked

    private void comboNhomMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNhomMonHocActionPerformed
        comboTenMonHoc.removeAllItems();
        for(int i=0;i<a4.size();i++){
            if(tb2.getValueAt(i, 3).toString().equalsIgnoreCase(comboNhomMonHoc.getSelectedItem().toString())==true)
                comboTenMonHoc.addItem(tb2.getValueAt(i, 1).toString());
        }
    }//GEN-LAST:event_comboNhomMonHocActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Vector v=new Vector();
        double s1=Double.parseDouble(txtDiem.getText());
        if(!ktraTrung(comboTenSinhVien.getSelectedItem().toString(), comboTenMonHoc.getSelectedItem().toString())){
           if(s1<0 | s1>10){
            try {
                throw new Exception("diem chi trong khoang 0->10");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
           else{
            v.add(1+tb3.getRowCount()+"");
            v.add(comboTenSinhVien.getSelectedItem().toString());
            v.add(comboTenMonHoc.getSelectedItem().toString());
            v.add(txtDiem.getText());
            a6.add(v);
            BangDiem d=new BangDiem(comboTenSinhVien.getSelectedItem().toString(), comboTenMonHoc.getSelectedItem().toString(), Double.parseDouble(txtDiem.getText()));
            bd.add(d);
            tb3.updateUI();
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "ten sinh vien va mon hoc da co !!!!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dm3.setRowCount(0);
        Collections.sort(bd, new Comparator<BangDiem>() {
            @Override
            public int compare(BangDiem o1, BangDiem o2) {
                return o1.getTenMon().compareToIgnoreCase(o2.getTenMon());
            }
        });
        for(BangDiem as:bd){
            Vector v=new Vector();
            v.add(1+tb4.getRowCount()+"");
            v.add(as.getTenSV());
            v.add(as.getTenMon());
            v.add(as.getDiem());
            a8.add(v);
        }tb4.updateUI();
    }//GEN-LAST:event_jButton6ActionPerformed
 
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboNhomMon;
    private javax.swing.JComboBox<String> comboNhomMonHoc;
    private javax.swing.JComboBox<String> comboTenMonHoc;
    private javax.swing.JComboBox<String> comboTenSinhVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JLabel txtDIem;
    private javax.swing.JTextField txtDiaCHi;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoTinCHi;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
