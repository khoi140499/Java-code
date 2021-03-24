package de2_1;

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
    DefaultTableModel dm1=new DefaultTableModel();
    DefaultTableModel dm2=new DefaultTableModel();
    DefaultTableModel dm3=new DefaultTableModel();
    DefaultTableModel dm4=new DefaultTableModel();
    Vector a1=new Vector();
    Vector a2=new Vector();
    Vector a3=new Vector();
    Vector a4=new Vector();
    Vector a5=new Vector();
    Vector a6=new Vector();
    Vector a7=new Vector();
    Vector a8=new Vector();
    ArrayList<NhanVien> nv=new ArrayList<NhanVien>();
    ArrayList<PhongBan> pb=new ArrayList<PhongBan>();
    ArrayList<Pair<NhanVien, Integer>> cc=new ArrayList<Pair<NhanVien, Integer>>();
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        a1.add("Mã nhân viên");
        a1.add("Tên nhân viên");
        a1.add("Địa chỉ");
        a1.add("Số điện thoại");
        a1.add("Bậc lương");
        dm1=(DefaultTableModel)tb1.getModel();
        dm1.setDataVector(a2, a1);
        a3.add("Mã phòng");
        a3.add("Tên phòng");
        a3.add("Mô tả");
        a3.add("Hệ số công");
        dm2=(DefaultTableModel)tb2.getModel();
        dm2.setDataVector(a4, a3);
        a5.add("Mã nhân viên");
        a5.add("Tên nhân viên");
        a5.add("Bậc lương");
        a5.add("Số ngày làm việc");
        a5.add("Phòng ban");
        dm3=(DefaultTableModel)tb3.getModel();
        dm3.setDataVector(a6, a5);
        a7.add("Mã nhân viên");
        a7.add("Tên nhân viên");
        a7.add("Bậc lương");
        a7.add("Số ngày làm việc");
        a7.add("Phòng ban");
        dm4=(DefaultTableModel)tb4.getModel();
        dm4.setDataVector(a8, a7);
        txtMaNV.setEnabled(false);
        txtMaPhong.setEnabled(false);
        loadNhanVien();
        docPhongBan();
        loadTenNhanVien();
        loaMaPhong();
        txtMNV.setEnabled(false);
        txtBL.setEnabled(false);
        txtTP.setEnabled(false);
    }
    private void loadTenNhanVien(){
        comboTenNhanVien.removeAllItems();
        for(int i=0; i<a2.size();i++){
            Vector v=(Vector)a2.get(i);
            comboTenNhanVien.addItem(v.get(1).toString());
        }
    }
    private void loaMaPhong(){
        comboMaPhong.removeAllItems();
        for(int i=0;i<a4.size();i++){
            Vector v=(Vector)a4.get(i);
            comboMaPhong.addItem(v.get(1).toString());
        }
    }
    private void loadNhanVien(){
        try {
            File f=new File("NhanVien.txt");
            Scanner sc=new Scanner(f);
            int maNV=0, dem=0, kt=0, bacluong=0;
            String tenNV="", diachi="", sdt="";
            while(sc.hasNext()){
                try {
                    dem++;
                    maNV=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(maNV);
                    if(s.length()!=4){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("Nhan vien thu "+dem+" sai thong tin: MA NHAN VIEN KHONG DU 4 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        tenNV=sc.nextLine();
                        if(tenNV.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                        try {
                            throw new Exception("Nhan vien thu "+dem+" sai thong tin: TEN NHAN VIEN KHONG DUOC DE TRONG");
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
                                    throw new Exception("Nhan vien thu "+dem+" sai thong tin: DIA CHI KHONG DUOC DE TRONG");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                                sdt=sc.nextLine();
                                if(sdt.charAt(0)!='0' && sdt.length()!=9 && sdt.length()!=10){
                                    sc.nextLine();
                                    try {
                                        throw new Exception("Nhan vien thu "+dem+" sai thong tin: SAI SO DIEN THOAI");
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }
                                else{
                                    bacluong=Integer.parseInt(sc.nextLine());
                                    if(bacluong<=0 || bacluong >9){
                                        try {
                                            throw new Exception("Nhan vien thu "+dem+" sai thong tin: BAC LUONG TU 1->9");
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                        }
                                    }else kt=1;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException|InputMismatchException e) {
                    JOptionPane.showMessageDialog(null, "Nhan vien thu "+dem+" sai thong tin");
                }
                if(kt==1){
                    NhanVien n=new NhanVien(maNV, tenNV, diachi, sdt, bacluong);
                    nv.add(n);
                    kt=0;
                }
            }
            for(NhanVien a:nv){
                Vector vec=new Vector();
                String ma=String.valueOf(a.getMaVN());
                String bacl=String.valueOf(a.getBacLuong());
                vec.add(ma);
                vec.add(a.getHoTen());
                vec.add(a.getDiaChi());
                vec.add(a.getSdt());
                vec.add(bacl);
                a2.add(vec);
            }tb1.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void docPhongBan(){
        try {
            File f=new File("PhongBan.txt");
            Scanner sc=new Scanner(f);
            int ma=0, dem=0, kt=0;
            String ten="", mota="";
            int hsluong=0;
            while(sc.hasNext()){
                try {
                    dem++;
                    ma=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(ma);
                    if(s.length()!=4){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("Phong ban thu "+dem+" sai thong tin: MA KHONG DU 4 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        ten=sc.nextLine();
                        if(ten.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                            try {
                                throw new Exception("Phong ban thu "+dem+" sai thong tin: TEN PHONG BAN KHONG DUOC DE TRONG");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        }
                        else{
                            mota=sc.nextLine();
                            if(mota.length()==0){
                                sc.nextLine();
                                try {
                                    throw new Exception("Phong ban thu "+dem+" sai thong tin: PHAN MO TA KHONG DUOC DE TRONG");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                               hsluong=Integer.parseInt(sc.nextLine());
                               if(hsluong<=0 | hsluong >20){
                                   try {
                                       throw new Exception("Phong ban thu "+dem+" sai thong tin: SAI HE SO LUONG");
                                   } catch (Exception e) {
                                       JOptionPane.showMessageDialog(null, e.getMessage());
                                   }
                               }else kt=1;
                            }
                        }
                    }
                } catch (NumberFormatException|InputMismatchException e) {
                    JOptionPane.showMessageDialog(null, "Mat hang thu "+dem+" sai thong tin");
                }
                if(kt==1){
                    PhongBan p=new PhongBan(ma, ten, mota, hsluong);
                    pb.add(p);
                    kt=0;
                }
            }
            for(PhongBan as:pb){
                Vector vec=new Vector();
                String s1=String.valueOf(as.getMaPb());
                String s2=as.getTenPhong();
                String s3=as.getMoTa();
                String s4=String.valueOf(as.getHesoCV());
                vec.add(s1);
                vec.add(s2);
                vec.add(s3);
                vec.add(s4);
                a4.add(vec);
            }tb2.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean ktraTrung(int maNV, String tenNV){
        for(int i=0;i<a6.size();i++){
            if(Integer.parseInt(tb3.getValueAt(i, 0).toString())==maNV && tb3.getValueAt(i, 1).toString().equalsIgnoreCase(tenNV))
                return true;
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtMaNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtBacLuong = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtMaPhong = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtTenPhong = new javax.swing.JTextField();
        txtHeSoCV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        comboTenNhanVien = new javax.swing.JComboBox<>();
        txtSoNgayLV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtMNV = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboMaPhong = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtBL = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();

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

        jLabel1.setText("Mã nhân viên");
        jLabel1.setToolTipText("");

        jLabel2.setText("Địa chỉ");

        jLabel3.setText("Bậc lương");

        jLabel4.setText("Tên nhân viên");

        jLabel5.setText("Số điện thoại");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaNV)
                        .addComponent(txtBacLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBacLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân viên", jPanel1);

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

        jLabel6.setText("Mã phòng");

        jLabel7.setText("Mô tả");

        jLabel8.setText("Tên phòng");

        jLabel9.setText("Hệ số CV");

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaPhong)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenPhong)
                    .addComponent(txtHeSoCV, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(54, 54, 54))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHeSoCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phòng ban", jPanel2);

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

        comboTenNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTenNhanVienActionPerformed(evt);
            }
        });

        jLabel10.setText("Tên nhân viên");

        jLabel13.setText("Số ngày LV");

        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sắp xếp");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel14.setText("Mã nhân viên");

        comboMaPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMaPhongActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên phòng");

        jLabel16.setText("Bậc lương");

        jLabel11.setText("Tên phòng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSoNgayLV)
                            .addComponent(txtBL)
                            .addComponent(txtMNV, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton3)
                        .addGap(129, 129, 129)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(txtMNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoNgayLV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)))
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane4)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chấm công", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtMaNV.setText(1000+tb1.getRowCount()+"");
        String s1=txtMaNV.getText();
        String s2=txtTenNV.getText();
        String s3=txtDiaChi.getText();
        String s4=txtSDT.getText();
        String s5=txtBacLuong.getText();
        if(s2.length()==0){
            try {
                throw new StringIndexOutOfBoundsException("ten nhan vien khong duoc de trong");
            } catch (StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(s3.length()==0){
            try {
                throw new StringIndexOutOfBoundsException("dia chi khong duoc de trong");
            } catch (StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(s4.charAt(0)!='0' && s4.length()!=9 | s4.length() !=10){
            try {
                throw new Exception("sai so dien thoai");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        int bacluong=Integer.parseInt(s5);
        if(bacluong<1 | bacluong >9){
            try {
                throw new NumberFormatException("bac luong phai co tu 1->9 ky tu");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            Vector v=new Vector();
            int manv=Integer.parseInt(s1);
            int bluong=Integer.parseInt(s5);
            v.add(s1);
            v.add(s2);
            v.add(s3);
            v.add(s4);
            v.add(s5);
            a2.add(v);
            tb1.updateUI();
            NhanVien m=new NhanVien(manv, s2, s3, s4, bluong);
            nv.add(m);
        }
        try {
            PrintWriter pr=new PrintWriter("NhanVien.txt");
            for(NhanVien a:nv)
                pr.println(a.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtMaPhong.setText(1000+tb2.getRowCount()+"");
        String s1=txtMaPhong.getText();
        String s2=txtTenPhong.getText();
        String s3=txtMoTa.getText();
        String s4=txtHeSoCV.getText();
        if(s2.length()==0){
            try {
                throw new Exception("ten phong khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(s3.length()==0){
            try {
                throw new Exception("phan mo ta khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        int hsl=Integer.parseInt(s4);
        if(hsl<1 | hsl > 20){
            try {
                throw new Exception("he so luong phai co tu 1->20 ky tu");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            Vector v=new Vector();
            int maPB=Integer.parseInt(s1);
            int hsl1=Integer.parseInt(s4);
            v.add(s1);
            v.add(s2);
            v.add(s3);
            v.add(s4);
            a4.add(v);
            tb1.updateUI();
            PhongBan p=new PhongBan(maPB, s2, s3, hsl1);
            pb.add(p);
        }
        try {
            PrintWriter pr=new PrintWriter("PhongBan.txt");
            for(PhongBan a:pb)
                pr.println(a.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        NhanVien vn=new NhanVien();
        PhongBan x=new PhongBan();
        if(!ktraTrung(Integer.parseInt(txtMNV.getText()), comboTenNhanVien.getSelectedItem().toString())){
                int n=Integer.parseInt(txtSoNgayLV.getText());
            if(n < 0 | n > 32){
                try {
                    throw new Exception("so ngay lam viec phai lon hon 0 va nho hon 32");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            else{
                
                for(NhanVien a:nv){
                    if(txtMNV.getText().equals(Integer.toString(a.getMaVN()))){
                        vn=a;
                        break;
                    }
                }
                for(PhongBan b: pb){
                    if(txtTP.getText().equals(Integer.toString(b.getMaPb()))){
                        x=b;
                        break;
                    }
                }
                cc.add(new Pair<>(vn, Integer.parseInt(txtSoNgayLV.getText())));
                Vector<Object> v=new Vector<Object>();
                v.add(vn.getMaVN());
                v.add(vn.getHoTen());
                v.add(vn.getBacLuong());
                v.add(txtSoNgayLV.getText());
                v.add(x.getTenPhong());
                a6.add(v);
                tb3.updateUI();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "B nhap bi trung !! Moi ban nhap lai");
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dm3.setRowCount(0);
        Pair p=new Pair();
        sapxep();
        for(NhanVien as:nv){
            for(Pair a:cc){
                if(a.getKey() == as){
                   Vector<Object> d=new Vector<Object>();
                   d.add(as.getMaVN());
                   d.add(as.getHoTen());
                   d.add(as.getBacLuong());
                   d.add(a.getValue());
                   d.add(as.getB().getTenPhong());
                   a8.add(d);
                }
            }
        }tb4.updateUI();
    }//GEN-LAST:event_jButton4ActionPerformed
    private void sapxep(){
        Collections.sort(nv, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                String m[]=o1.getHoTen().split(" ");
                String n[]=o2.getHoTen().split(" ");
                return m[m.length-1].compareToIgnoreCase(n[n.length-1]);
            }
        });
    }
    private void comboTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenNhanVienActionPerformed
        for(int i=0;i<=comboTenNhanVien.getSelectedIndex();i++){
            int r=comboTenNhanVien.getSelectedIndex();
            txtMNV.setText(tb1.getValueAt(r, 0).toString());
            txtBL.setText(tb1.getValueAt(r, 3).toString());
        }
    }//GEN-LAST:event_comboTenNhanVienActionPerformed

    private void comboMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMaPhongActionPerformed
        for(int i=0;i<=comboMaPhong.getSelectedIndex();i++){
            int r=comboMaPhong.getSelectedIndex();
            txtTP.setText(tb2.getValueAt(r, 0).toString());
        }
    }//GEN-LAST:event_comboMaPhongActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboMaPhong;
    private javax.swing.JComboBox<String> comboTenNhanVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField txtBL;
    private javax.swing.JTextField txtBacLuong;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHeSoCV;
    private javax.swing.JTextField txtMNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoNgayLV;
    private javax.swing.JTextField txtTP;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
