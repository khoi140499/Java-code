package de3;

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
    Vector a=new Vector();
    Vector b=new Vector();
    Vector c=new Vector();
    Vector d=new Vector();
    Vector a1=new Vector();
    Vector b1=new Vector();
    Vector c1=new Vector();
    Vector d1=new Vector();
    ArrayList<CongNhan> cn=new ArrayList<CongNhan>();
    ArrayList<SanPham> sp=new ArrayList<SanPham>();
    ArrayList<BangTinhCong> btc=new ArrayList<BangTinhCong>();
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        a.add("Mã công nhân");
        a.add("Tên công nhân");
        a.add("Địa chỉ");
        a.add("Số điện thoại");
        a.add("Ca làm việc");
        dm=(DefaultTableModel)tb1.getModel();
        dm.setDataVector(b, a);
        c.add("Mã sản phẩm");
        c.add("Tên sản phẩm");
        c.add("Loại sản phẩm");
        c.add("Giá");
        dm1=(DefaultTableModel)tb2.getModel();
        dm1.setDataVector(d, c);
        a1.add("Mã bảng");
        a1.add("Tên công nhân");
        a1.add("Nhóm sản phẩm");
        a1.add("Tên sản phẩm");
        dm2=(DefaultTableModel)tb3.getModel();
        dm2.setDataVector(b1, a1);
        c1.add("Mã bảng");
        c1.add("Tên công nhân");
        c1.add("Nhóm sản phẩm");
        c1.add("Tên sản phẩm");
        dm3=(DefaultTableModel)tb4.getModel();
        dm3.setDataVector(d1, c1);
        loadCongNhan();
        loadSanPham();
        txtMaCN.setEnabled(false);
        txtMaSP.setEnabled(false);
        txtMaB.setEnabled(false);
        themCN();
    }
    private void themCN(){
        comboTenCongNhan.removeAllItems();
        for(int i=0;i<b.size();i++){
            Vector v=(Vector)b.get(i);
            comboTenCongNhan.addItem(v.get(1).toString());
        }
    }

    public int getMaCN(){
        return 10000+tb1.getRowCount();
    }
    public int getMaSP(){
        return 10000+tb2.getRowCount();
    }
    public void loadCongNhan(){
        File f=new File("CongNhan.txt");
        try {
            Scanner sc=new Scanner(f);
            int maCN=0, dem=0, kt=0;
            String tenCN="", diaChi="",std="", calv="";
            while(sc.hasNext()){
                try {
                    dem++;
                    maCN=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(maCN);
                    if(s.length()!=5){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("Cong nhan thu "+dem+"sai thong tin :MA PHAI DU 5 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        tenCN=sc.nextLine();
                        if(tenCN.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            try {
                                throw new Exception("Cong nhan thu "+dem+"sai thong tin :TEN KHONG DUOC DE TRONG");
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
                                    throw new Exception("Cong nhan thu "+dem+"sai thong tin :DIA CHI KHONG DUOC DE TRONG");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                                std=sc.nextLine();
                                if(std.length()==0){
                                    sc.nextLine();
                                    try {
                                        throw new Exception("Cong nhan thu "+dem+"sai thong tin :DIA CHI KHONG DUOC DE TRONG");
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }
                                else{
                                    calv=sc.nextLine();
                                    if(calv.length()==0 | calv.equalsIgnoreCase("ca sang")==false &&
                                            calv.equalsIgnoreCase("ca chieu")==false &&
                                            calv.equalsIgnoreCase("ca dem")==false){
                                        try {
                                            throw new Exception("Cong nhan thu "+dem+"sai thong tin :SAI CA LAM VIEC");
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
                    JOptionPane.showMessageDialog(null, "Cong nhan thu "+dem+"sai thong tin");
                }
                if(kt==1){
                    CongNhan c=new CongNhan(maCN, tenCN, diaChi, std, calv);
                    cn.add(c);
                    kt=0;
                }
            }
            for(CongNhan a:cn){
                Vector v=new Vector();
                String s1=String.valueOf(a.getMaCN());
                v.add(s1);
                v.add(a.getHoTen());
                v.add(a.getDiaChi());
                v.add(a.getSdt());
                v.add(a.getCa());
                b.add(v);
            }tb1.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadSanPham(){
        File f=new File("SanPham.INP");
        try {
            Scanner sc=new Scanner(f);
            int maSP=0, dem=0, kt=0;
            double gia=0;
            String tenSP="", nhomSP="";
            while(sc.hasNext()){
                try {
                    dem++;
                    maSP=Integer.parseInt(sc.nextLine());
                    String s=String.valueOf(maSP);
                    if(s.length()!=5){
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        try {
                            throw new Exception("San pham thu "+dem+"sai thong tin: MA SAN PHAM PHAI DU 5 KY TU");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        tenSP=sc.nextLine();
                        if(tenSP.length()==0){
                            sc.nextLine();
                            sc.nextLine();
                            try {
                                throw new Exception("San pham thu "+dem+"sai thong tin: TEN SAN PHAM KHONG DUOC DE TRONG");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        }
                        else{
                            nhomSP=sc.nextLine();
                            if(nhomSP.length()==0 | nhomSP.equalsIgnoreCase("hang tieu dung")==false && 
                                    nhomSP.equalsIgnoreCase("hang thoi trang")==false && nhomSP.equalsIgnoreCase("dien tu - dien lanh")==false){
                                sc.nextLine();
                                try {
                                    throw new Exception("San pham thu "+dem+"sai thong tin: SAI NHOM SAN PHAM");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }else{
                                gia=Double.parseDouble(sc.nextLine());
                                if(gia<0){
                                    try {
                                        throw new Exception("San pham thu "+dem+"sai thong tin: GIA SAN PHAM PHAI LON HON 0");
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }else kt=1;
                            }
                        }
                    }
                } catch (NumberFormatException|InputMismatchException e) {
                    JOptionPane.showMessageDialog(null, "San pham thu "+dem+"sai thong tin");
                }
                if(kt==1){
                    SanPham s=new SanPham(maSP, tenSP, nhomSP, gia);
                    sp.add(s);
                    kt=0;
                }
            }
            for(SanPham a:sp){
                Vector v=new Vector();
                String s1=String.valueOf(a.getMaSP());
                String s2=String.valueOf(a.getDonGia());
                v.add(s1);
                v.add(a.getTenSP());
                v.add(a.getNhomSP());
                v.add(s2);
                d.add(v);
            }tb2.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtMaCN = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTenCN = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboCaLamViec = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtMaSP = new javax.swing.JTextField();
        txtNhomSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtMaB = new javax.swing.JTextField();
        comboTenCongNhan = new javax.swing.JComboBox<>();
        comboLoaiSanPham = new javax.swing.JComboBox<>();
        comboTenSanPham = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField5.setText("jTextField5");

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
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tb1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tb1);

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

        jLabel1.setText("Mã công nhân");

        jLabel2.setText("Tên công nhân");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Ca làm việc");

        comboCaLamViec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ca sang", "ca chieu", "ca dem" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(txtMaCN)
                            .addComponent(txtTenCN))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jButton1)
                        .addGap(158, 158, 158)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSDT)
                    .addComponent(comboCaLamViec, 0, 226, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)))
                .addGap(43, 43, 43))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(comboCaLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Công Nhân", jPanel1);

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
        tb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb2);

        jLabel6.setText("Mã sản phẩm");

        jLabel7.setText("Tên sản phẩm");

        jLabel8.setText("Nhóm sản phẩm");

        jLabel9.setText("Giá sản phẩm");

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txtMaSP))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jButton4)
                        .addGap(155, 155, 155)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNhomSP)
                            .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(175, 175, 175))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhomSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);

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

        comboTenCongNhan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenCongNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTenCongNhanMouseClicked(evt);
            }
        });

        comboLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hang tieu dung", "hang thoi trang", "dien tu - dien lanh" }));
        comboLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLoaiSanPhamActionPerformed(evt);
            }
        });

        comboTenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Mã bảng");

        jLabel11.setText("Tên công nhân");

        jLabel12.setText("Loại sản phẩm");

        jLabel13.setText("Tên sản phẩm");

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
                .addGap(88, 88, 88)
                .addComponent(jButton7)
                .addGap(54, 54, 54)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTenCongNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLoaiSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTenSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTenCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Bảng tính công", jPanel4);

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
        int ma=getMaCN();
        txtMaCN.setText(ma+"");
        if(txtTenCN.getText().length()==0){
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
        if(txtSDT.getText().charAt(0)!='0' | txtSDT.getText().length()!=9 | txtSDT.getText().length()!=10){
            try {
                throw new Exception("sai dinh dang so dien thoai");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            Vector v=new Vector();
            v.add(txtMaCN.getText());
            v.add(txtTenCN.getText());
            v.add(txtDiaChi.getText());
            v.add(txtSDT.getText());
            v.add(comboCaLamViec.getSelectedItem().toString());
            b.add(v);
        }
        tb1.updateUI();
        int mad=Integer.parseInt(txtMaCN.getText());
        CongNhan c=new CongNhan(mad, txtTenCN.getText(), txtDiaChi.getText(), txtSDT.getText(), comboCaLamViec.getSelectedItem().toString());
        cn.add(c);
        try {
            PrintWriter pr=new PrintWriter("CongNhan.txt");
            for(CongNhan a:cn)
                pr.println(a.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row=tb1.getSelectedRow();
        if(row==-1) return;
        tb1.setValueAt(txtTenCN.getText(), row, 1);
        tb1.setValueAt(txtDiaChi.getText(), row, 2);
        tb1.setValueAt(txtSDT.getText(), row, 3);
        tb1.setValueAt(comboCaLamViec.getSelectedItem().toString(), row, 4);
        try{
            PrintWriter pr=new PrintWriter("CongNhan.txt");
        for(int i=0;i<b.size();i++){
            Vector v=(Vector)b.get(i);
            String ma1=v.get(0).toString();
            String ten=v.get(1).toString();
            String dc=v.get(2).toString();
            String sdt=v.get(3).toString();
            String ca=v.get(4).toString();
            pr.println(ma1);
            pr.println(ten);
            pr.println(dc);
            pr.println(sdt);
            pr.println(ca);
            
        }
        pr.close();
        }catch(Exception e){}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        int row=tb1.getSelectedRow();
        if(row==-1) return;
        txtMaCN.setText(tb1.getValueAt(row, 0).toString());
        txtTenCN.setText(tb1.getValueAt(row, 1).toString());
        txtDiaChi.setText(tb1.getValueAt(row, 2).toString());
        txtSDT.setText(tb1.getValueAt(row, 3).toString());
        String cn=tb1.getValueAt(row, 4).toString();
        for (int i = 0; i < comboCaLamViec.getItemCount(); i++) {
            if(comboCaLamViec.getItemAt(i).toString().equals(cn)){
                comboCaLamViec.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tb1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row=tb1.getSelectedRow();
        if(row==-1) return;
        dm.removeRow(row);
        try{
            PrintWriter pr=new PrintWriter("CongNhan.txt");
        for(int i=0;i<b.size();i++){
            Vector v=(Vector)b.get(i);
            String ma1=v.get(0).toString();
            String ten=v.get(1).toString();
            String dc=v.get(2).toString();
            String sdt=v.get(3).toString();
            String ca=v.get(4).toString();
            pr.println(ma1);
            pr.println(ten);
            pr.println(dc);
            pr.println(sdt);
            pr.println(ca);
            
        }
        pr.close();
        }catch(Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int ma=getMaSP();
        txtMaSP.setText(ma+"");
        if(txtTenSP.getText().length()==0){
            try {
                throw new Exception("ten khong duoc de trong");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(txtNhomSP.getText().equalsIgnoreCase("hang tieu dung")==false &&
           txtNhomSP.getText().equalsIgnoreCase("hang thoi trang")==false &&
           txtNhomSP.getText().equalsIgnoreCase("dien tu - dien lanh")==false){
            try {
                throw new Exception("nhom hang phai la 'hang tieu dung', 'hang thoi trang', 'dien tu - dien lanh'");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        double gia=Double.parseDouble(txtGia.getText());
        if(gia<=0){
            try {
                throw new Exception("gia phai lon hon 0");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            Vector v=new Vector();
            v.add(txtMaSP.getText());
            v.add(txtTenSP.getText());
            v.add(txtNhomSP.getText());
            v.add(txtGia.getText());
            d.add(v);
            tb2.updateUI();
        int mad=Integer.parseInt(txtMaSP.getText());
        double gia1=Double.parseDouble(txtGia.getText());
        SanPham s=new SanPham(mad, txtTenSP.getText(), txtNhomSP.getText(), gia1);
        sp.add(s);
        }
        try {
            PrintWriter pr=new PrintWriter("SanPham.INP");
            for(SanPham a:sp)
                pr.println(a.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int row=tb2.getSelectedRow();
        if(row==-1) return;
        tb2.setValueAt(txtTenSP.getText(), row, 1);
        tb2.setValueAt(txtNhomSP.getText(), row, 2);
        tb2.setValueAt(txtGia.getText(), row, 3);
        try{
            PrintWriter pr=new PrintWriter("SanPham.INP");
        for(int i=0;i<d.size();i++){
            Vector v=(Vector)d.get(i);
            String ma1=v.get(0).toString();
            String ten=v.get(1).toString();
            String dc=v.get(2).toString();
            String sdt=v.get(3).toString();
            pr.println(ma1);
            pr.println(ten);
            pr.println(dc);
            pr.println(sdt);
            
        }
        pr.close();
        }catch(Exception e){}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row=tb2.getSelectedRow();
        if(row==-1) return;
        dm1.removeRow(row);
        try{
            PrintWriter pr=new PrintWriter("SanPham.INP");
        for(int i=0;i<d.size();i++){
            Vector v=(Vector)d.get(i);
            String ma1=v.get(0).toString();
            String ten=v.get(1).toString();
            String dc=v.get(2).toString();
            String sdt=v.get(3).toString();
            pr.println(ma1);
            pr.println(ten);
            pr.println(dc);
            pr.println(sdt);
            
        }
        pr.close();
        }catch(Exception e){}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
         int row=tb2.getSelectedRow();
        if(row==-1) return;
        txtMaSP.setText(tb2.getValueAt(row, 0).toString());
        txtTenSP.setText(tb2.getValueAt(row, 1).toString());
        txtNhomSP.setText(tb2.getValueAt(row, 2).toString());
        txtGia.setText(tb2.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tb2MouseClicked

    private void comboLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLoaiSanPhamActionPerformed
        comboTenSanPham.removeAllItems();
        for(int i=0;i<d.size();i++){
            if(tb2.getValueAt(i, 2).toString().equalsIgnoreCase(comboLoaiSanPham.getSelectedItem().toString())==true){
                comboTenSanPham.addItem(tb2.getValueAt(i, 1).toString());
            }
        }
    }//GEN-LAST:event_comboLoaiSanPhamActionPerformed
    private boolean ktraTrung(String tenCN, String loaiSP, String tenSP){
        for(int i=0;i<b1.size();i++){
            if(tb3.getValueAt(i, 1).toString()==tenCN && tb3.getValueAt(i, 2).toString()==loaiSP && tb3.getValueAt(i, 3).toString()==tenSP)
                return true;
                        }
        return false;
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        txtMaB.setText(1000+tb3.getRowCount()+"");
        String tenCN=comboTenCongNhan.getSelectedItem().toString();
        String loaiSP=comboLoaiSanPham.getSelectedItem().toString();
        String tenSP=comboTenSanPham.getSelectedItem().toString();
        if(!ktraTrung(tenCN, loaiSP, tenSP)){
            Vector v=new Vector();
            v.add(txtMaB.getText());
            v.add(tenCN);
            v.add(loaiSP);
            v.add(tenSP);
            BangTinhCong b=new BangTinhCong(Integer.parseInt(txtMaB.getText()), tenCN, loaiSP, tenSP);
            btc.add(b);
            b1.add(v);
            tb3.updateUI();
        }
        else{
            JOptionPane.showMessageDialog(null, "trung!!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dm3.setRowCount(0);
        Collections.sort(btc, new Comparator<BangTinhCong>() {
        @Override
        public int compare(BangTinhCong o1, BangTinhCong o2) {
            String[] s1=o1.getTenCN().split(" ");
            String[] s2=o2.getTenCN().split(" ");
            return s1[s1.length-1].compareToIgnoreCase(s2[s2.length-1]);
        }
    });
    for(BangTinhCong a:btc){
        Vector v=new Vector();
        v.add(String.valueOf(a.getMaTC()));
        v.add(a.getTenCN());
        v.add(a.getLoaiSP());
        v.add(a.getTenSP());
        d1.add(v);
    }tb4.updateUI();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void comboTenCongNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTenCongNhanMouseClicked
        loadCongNhan();
    }//GEN-LAST:event_comboTenCongNhanMouseClicked

    private void tb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tb1MouseEntered

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
    private javax.swing.JComboBox<String> comboCaLamViec;
    private javax.swing.JComboBox<String> comboLoaiSanPham;
    private javax.swing.JComboBox<String> comboTenCongNhan;
    private javax.swing.JComboBox<String> comboTenSanPham;
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
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaB;
    private javax.swing.JTextField txtMaCN;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNhomSP;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenCN;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
