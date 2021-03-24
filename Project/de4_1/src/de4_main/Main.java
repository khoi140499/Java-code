package de4_main;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import javafx.util.Pair;
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
    ArrayList<KhachHang> kh=new ArrayList<KhachHang>();
    ArrayList<DichVu> dv=new ArrayList<DichVu>();
    ArrayList<HoaDon> hd=new ArrayList<HoaDon>();
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        a1.add("Mã khách hàng");
        a1.add("Tên khách hàng");
        a1.add("Địa chỉ");
        a1.add("Số điện thoại");
        a1.add("Loại khách hàng");
        dm=(DefaultTableModel)tb.getModel();
        dm.setDataVector(a2, a1);
        a3.add("Mã dịch vụ");
        a3.add("Tên dịch vụ");
        a3.add("Giá cước");
        a3.add("Đơn vị tính");
        dm1=(DefaultTableModel)tb1.getModel();
        dm1.setDataVector(a4, a3);
        a5.add("Mã hóa đơn");
        a5.add("Tên khách hàng");
        a5.add("Tên dịch vụ");
        a5.add("Giá dịch vụ");
        dm2=(DefaultTableModel)tb2.getModel();
        dm2.setDataVector(a6, a5);
        a7.add("Mã hóa đơn");
        a7.add("Tên khách hàng");
        a7.add("Tên dịch vụ");
        a7.add("Giá dịch vụ");
        dm3=(DefaultTableModel)tb3.getModel();
        dm3.setDataVector(a8, a7);
        txtMaDV.setEnabled(false);
        txtMaKH.setEnabled(false);
        txtMaHD.setEnabled(false);
        txtGiaDV.setEnabled(false);
        loadDichVu();
        loadKhachHang();
        ghep();

    }
    private void ghep(){
        comboTenDV.removeAllItems();
        comboTenKH.removeAllItems();
        for(int i=0;i<a2.size();i++){
            Vector v=(Vector)a2.get(i);
            comboTenKH.addItem(v.get(1).toString());
        }
        for(int i=0;i<a4.size();i++){
            Vector v=(Vector)a4.get(i);
            comboTenDV.addItem(v.get(1).toString());
        }
    }
    private int getMaDV(){
        return 100+tb1.getRowCount();
    }
    private int getMaKH(){
        return 10000+tb.getRowCount();
    }
    private void loadKhachHang(){
        File f=new File("KhachHang.txt");
        try {
            Scanner sc=new Scanner(f);
            int maKH=0,dem=0,kt=0;
            String tenKH="", diaChi="", sdt="", loaiKH="";
            while(sc.hasNext()){
                try {
                    dem++;
                    maKH=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(maKH);
                    if(s.length()!=5){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("Khach hang thu "+dem+" sai thong tin: MA KHACH HANG PHAI DU 5 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        tenKH=sc.nextLine();
                        if(tenKH.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                          try {
                            throw new Exception("Khach hang thu "+dem+" sai thong tin: TEN KHACH HANG KHONG DUOC DE TRONG");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        }
                        else{
                            diaChi=sc.nextLine();
                            if(diaChi.length()==0){
                                sc.nextLine();
                                sc.nextLine();
                                try {
                                    throw new Exception("Khach hang thu "+dem+" sai thong tin: DIA CHI KHONG DUOC DE TRONG");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                                sdt=sc.nextLine();
                                if(sdt.charAt(0)!='0' && sdt.length()!=9 | sdt.length()!=10){
                                    sc.nextLine();
                                    try {
                                        throw new Exception("Khach hang thu "+dem+" sai thong tin: SAI SO DIEN THOAI");
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }
                                else{
                                    loaiKH=sc.nextLine();
                                    if(loaiKH.equalsIgnoreCase("ca nhan")==false && loaiKH.equalsIgnoreCase("dai dien don vi hanh chinh")==false
                                            && loaiKH.equalsIgnoreCase("dai dien don vi kinh doanh")==false){
                                        try {
                                            throw new Exception("Khach hang thu "+dem+" sai thong tin: SAI LOAI KHACH HANG");
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                        }
                                    }
                                    else kt=1;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException|InputMismatchException e){
                    JOptionPane.showMessageDialog(null, "Khach hang thu "+dem+" sai thong tin");
                }
                if(kt==1){
                    KhachHang k=new KhachHang(maKH, tenKH, diaChi, sdt, loaiKH);
                    kh.add(k);
                    kt=0;
                }
            }
            for(KhachHang a: kh){
                Vector v=new Vector();
                String s1=String.valueOf(a.getMaKH());
                v.add(s1);
                v.add(a.getHoTen());
                v.add(a.getDiaChi());
                v.add(a.getSdt());
                v.add(a.getLoaiKH());
                a2.add(v);
            }tb.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadDichVu(){
        File f=new File("DichVu.txt");
        try {
            Scanner sc=new Scanner(f);
            int maDV=0,dem=0,kt=0;
            String tenDV="", donvi="";
            double giaCuoc=0;
            while(sc.hasNext()){
                try {
                    dem++;
                    maDV=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(maDV);
                    if(s.length()!=3){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("Dich vu thu "+dem+" sai thong tin: MA DICH VU PHAI DU 3 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        tenDV=sc.nextLine();
                        if(tenDV.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                          try {
                            throw new Exception("Dich vu thu "+dem+" sai thong tin: TEN DICH VU KHONG DUOC DE TRONG");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        }
                        else{
                            giaCuoc=Double.parseDouble(sc.nextLine());
                            if(giaCuoc<1){
                                sc.nextLine();
                                try {
                                    throw new Exception("Dich vu thu "+dem+" sai thong tin: GIA CUOC PHAI LON HON 1");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                                else{
                                    donvi=sc.nextLine();
                                    if(donvi.equalsIgnoreCase("MB")==false && donvi.equalsIgnoreCase("ngay")==false
                                            && donvi.equalsIgnoreCase("thang")==false && donvi.equalsIgnoreCase("so luot")==false){
                                        try {
                                            throw new Exception("Dich vu thu "+dem+" sai thong tin: DON VI TINH KHONG DUNG");
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                        }
                                    }
                                    else kt=1;
                                }
                            }
                        }
                } catch (NumberFormatException|InputMismatchException e){
                    JOptionPane.showMessageDialog(null, "Dich vu thu "+dem+" sai thong tin");
                }
                if(kt==1){
                    DichVu d=new DichVu(maDV, tenDV, giaCuoc, donvi);
                    dv.add(d);
                    kt=0;
                }
            }
            for(DichVu a: dv){
                Vector v=new Vector();
                String s1=String.valueOf(a.getMaDV());
                v.add(s1);
                v.add(a.getTenDV());
                String s2=String.valueOf(a.getGia());
                v.add(s2);
                v.add(a.getDonVi());
                a4.add(v);
            }tb1.updateUI();
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
        tb = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtMaKH = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        comboLoaiKH = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtMaDV = new javax.swing.JTextField();
        txtGiaCuoc = new javax.swing.JTextField();
        txtTenDV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        comboDonVi = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtMaHD = new javax.swing.JTextField();
        comboTenKH = new javax.swing.JComboBox<>();
        comboTenDV = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGiaDV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb.setModel(new javax.swing.table.DefaultTableModel(
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
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        jLabel1.setText("Mã khách hàng");

        jLabel2.setText("Tên khách hàng");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Loại khách hàng");

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

        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        comboLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ca nhan", "dai dien don vi hanh chinh", "dai dien don vi kinh doanh" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(119, 119, 119)
                .addComponent(jButton2)
                .addGap(218, 218, 218))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(txtMaKH))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(53, 53, 53)
                        .addComponent(comboLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(417, 417, 417))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách hàng", jPanel1);

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
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setText("Mã dịch vụ");

        jLabel7.setText("Tên dịch vụ");

        jLabel8.setText("Giá cước");

        jLabel9.setText("Đơn vị tính");

        jButton4.setText("Thêm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Sửa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        comboDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MB", "ngay", "thang", "so luot" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(124, 124, 124)
                .addComponent(jButton5)
                .addGap(197, 197, 197))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaDV, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtTenDV))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDonVi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiaCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtGiaCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(comboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Dịch vụ", jPanel2);

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
        jScrollPane3.setViewportView(tb2);

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
        jScrollPane4.setViewportView(tb3);

        comboTenKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTenKHMouseClicked(evt);
            }
        });

        comboTenDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTenDVMouseClicked(evt);
            }
        });
        comboTenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTenDVActionPerformed(evt);
            }
        });

        jLabel10.setText("Mã hóa dơn");

        jLabel11.setText("Tên khách hàng");

        jLabel12.setText("Tên dịch vụ ");

        jLabel13.setText("Giá dịch vụ");

        jButton7.setText("Thêm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Sắp xếp");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboTenKH, javax.swing.GroupLayout.Alignment.LEADING, 0, 143, Short.MAX_VALUE)
                            .addComponent(comboTenDV, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiaDV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ghep();
        int ma=getMaKH();
        txtMaKH.setText(ma+"");
        if(txtTenKH.getText().length()==0){
            try {
                throw new Exception("ten khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(txtDiaChi.getText().length()==0){
            try {
                throw new Exception("dia chi khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(txtSDT.getText().charAt(0)!='0' && txtSDT.getText().length()!=9 | txtSDT.getText().length()!=10){
            try {
                throw new Exception("sai so dien thoai");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            int ma1=Integer.parseInt(txtMaKH.getText());
            KhachHang k=new KhachHang(ma1, txtTenKH.getText(), txtDiaChi.getText(), txtSDT.getText(), comboLoaiKH.getSelectedItem().toString());
            kh.add(k);
            Vector vec=new Vector();
            vec.add(txtMaKH.getText());
            vec.add(txtTenKH.getText());
            vec.add(txtDiaChi.getText());
            vec.add(txtSDT.getText());
            vec.add(comboLoaiKH.getSelectedItem().toString());
            a2.add(vec);
        }tb.updateUI();
        try {
            PrintWriter pr=new PrintWriter("KhachHang.txt");
            for(KhachHang a:kh)
                pr.println(a.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
         int row=tb.getSelectedRow();
         if(row==-1) return;
         txtMaKH.setText(tb.getValueAt(row, 0).toString());
         txtTenKH.setText(tb.getValueAt(row, 1).toString());
         txtDiaChi.setText(tb.getValueAt(row, 2).toString());
         txtSDT.setText(tb.getValueAt(row, 3).toString());
         String s=tb.getValueAt(row, 4).toString();
         for (int i = 0; i < comboLoaiKH.getItemCount(); i++) {
            if(comboLoaiKH.getItemAt(i).toString().equals(s)){
                comboLoaiKH.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tbMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row=tb.getSelectedRow();
        if(row==-1) return;
        tb.setValueAt(txtTenKH.getText(), row, 1);
        tb.setValueAt(txtDiaChi.getText(), row, 2);
        tb.setValueAt(txtSDT.getText(), row, 3);
        tb.setValueAt(comboLoaiKH.getSelectedItem().toString(), row, 4);
        int ma=Integer.parseInt(txtMaKH.getText());
        try {
            PrintWriter pr=new PrintWriter("KhachHang.txt");
            for(int i=0;i<a2.size();i++){
                Vector v=(Vector)a2.get(i);
                String s1=v.get(0).toString();
                String s2=v.get(1).toString();
                String s3=v.get(2).toString();
                String s4=v.get(3).toString();
                String s5=v.get(4).toString();
                pr.println(s1);
                pr.println(s2);
                pr.println(s3);
                pr.println(s4);
                pr.println(s5);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row=tb.getSelectedRow();
        if(row==-1) return;
        dm.removeRow(row);
        try {
            PrintWriter pr=new PrintWriter("KhachHang.txt");
            for(int i=0;i<a2.size();i++){
                Vector v=(Vector)a2.get(i);
                String s1=v.get(0).toString();
                String s2=v.get(1).toString();
                String s3=v.get(2).toString();
                String s4=v.get(3).toString();
                String s5=v.get(4).toString();
                pr.println(s1);
                pr.println(s2);
                pr.println(s3);
                pr.println(s4);
                pr.println(s5);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int ma=getMaDV();
        txtMaDV.setText(ma+"");
        Vector v=new Vector();
        v.add(txtMaDV.getText());
        v.add(txtTenDV.getText());
        v.add(txtGiaCuoc.getText());
        v.add(comboDonVi.getSelectedItem().toString());
        a4.add(v);
        tb.updateUI();
        int ma1=Integer.parseInt(txtMaDV.getText());
        double gia=Double.parseDouble(txtGiaCuoc.getText());
        DichVu h=new DichVu(ma1, txtTenDV.getText(), gia, comboDonVi.getSelectedItem().toString());
        dv.add(h);
        try {
            PrintWriter pr=new PrintWriter("DichVu.txt");
            for(DichVu a:dv)
                pr.println(a.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        int row=tb1.getSelectedRow();
        if(row==-1) return;
        txtMaDV.setText(tb1.getValueAt(row, 0).toString());
        txtTenDV.setText(tb1.getValueAt(row, 1).toString());
        txtGiaCuoc.setText(tb1.getValueAt(row, 2).toString());
        String s=tb1.getValueAt(row, 3).toString();
        for(int i=0;i<comboDonVi.getItemCount();i++){
            if(comboDonVi.getItemAt(i).toString().equalsIgnoreCase(s)){
                comboDonVi.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tb1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int row=tb1.getSelectedRow();
        if(row==-1) return;
        tb1.setValueAt(txtTenDV.getText(), row, 1);
        tb1.setValueAt(txtGiaCuoc.getText(), row, 2);
        tb1.setValueAt(comboDonVi.getSelectedItem().toString(), row, 3);
        try {
            PrintWriter pr=new PrintWriter("DichVu.txt");
            for(int i=0;i<a4.size();i++){
                Vector v=(Vector)a4.get(i);
                pr.println(v.get(0).toString());
                pr.println(v.get(1).toString());
                pr.println(v.get(2).toString());
                pr.println(v.get(3).toString());
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row=tb1.getSelectedRow();
        if(row==-1) return;
        dm1.removeRow(row);
        try {
            PrintWriter pr=new PrintWriter("DichVu.txt");
            for(int i=0;i<a4.size();i++){
                Vector v=(Vector)a4.get(i);
                pr.println(v.get(0).toString());
                pr.println(v.get(1).toString());
                pr.println(v.get(2).toString());
                pr.println(v.get(3).toString());
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    private boolean trung(String tenDV, String tenKH){
        for(int i=0;i<tb2.getRowCount();i++){
            if(tb2.getValueAt(i, 2).toString()==tenDV && tb2.getValueAt(i, 1)==tenKH)
                return true;
        }
        return false;
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        int ma=1000+tb2.getRowCount();
        txtMaHD.setText(ma+"");
        Vector vec=new Vector();
        String s=comboTenDV.getSelectedItem().toString();
        String s1=comboTenKH.getSelectedItem().toString();
        if(!trung(s,s1)){
            vec.add(txtMaHD.getText());
            vec.add(comboTenKH.getSelectedItem().toString());
            vec.add(comboTenDV.getSelectedItem().toString());
            vec.add(txtGiaDV.getText());
            a6.add(vec);
            tb2.updateUI();
            HoaDon h=new HoaDon(Integer.parseInt(txtMaHD.getText()), comboTenKH.getSelectedItem().toString(), comboTenDV.getSelectedItem().toString(), Double.parseDouble(txtGiaDV.getText()));
            hd.add(h);
        }
        else{
            JOptionPane.showMessageDialog(null, "Dich vu ban vua chon da xuat hien");
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void comboTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenDVActionPerformed
        for(int i=0;i<=comboTenDV.getSelectedIndex();i++){
            int r=comboTenDV.getSelectedIndex();
            txtGiaDV.setText(tb1.getValueAt(r, 2).toString());
        }
    }//GEN-LAST:event_comboTenDVActionPerformed

    private void comboTenKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTenKHMouseClicked
       ghep();
    }//GEN-LAST:event_comboTenKHMouseClicked

    private void comboTenDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTenDVMouseClicked
        ghep();
    }//GEN-LAST:event_comboTenDVMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dm3.setRowCount(0);
        Collections.sort(hd, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                String[] m1=o1.getTenKH().split(" ");
                String[] m2=o2.getTenKH().split(" ");
                return m1[m1.length-1].compareToIgnoreCase(m2[m2.length-1]);
            }
        });
        for(HoaDon a:hd){
            Vector v=new Vector();
            v.add(String.valueOf(a.getMaHD()));
            v.add(a.getTenKH());
            v.add(a.getTenDV());
            v.add(String.valueOf(a.getGiaDV()));
            a8.add(v);
        }tb3.updateUI();
    }//GEN-LAST:event_jButton8ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDonVi;
    private javax.swing.JComboBox<String> comboLoaiKH;
    private javax.swing.JComboBox<String> comboTenDV;
    private javax.swing.JComboBox<String> comboTenKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tb;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiaCuoc;
    private javax.swing.JTextField txtGiaDV;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDV;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
