package QuanLyTinhCong;

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
    ArrayList<CongNhan> cn=new ArrayList<CongNhan>();
    ArrayList<SanPham> sp=new ArrayList<SanPham>();
    ArrayList<Pair<CongNhan,SanPham>> cs=new ArrayList<Pair<CongNhan, SanPham>>();
    ArrayList<Pair<CongNhan, Integer>> si=new ArrayList<Pair<CongNhan, Integer>>();
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        a1.add("Mã công nhân");
        a1.add("Tên công nhân");
        a1.add("Địa chỉ");
        a1.add("Số điện thoại");
        a1.add("Ca làm việc");
        dm1=(DefaultTableModel)tb1.getModel();
        dm1.setDataVector(a2, a1);
        a3.add("Mã sản phẩm");
        a3.add("Tên sản phẩm");
        a3.add("Loại sản phẩm");
        a3.add("Giá");
        dm2=(DefaultTableModel)tb2.getModel();
        dm2.setDataVector(a4, a3);
        a5.add("Mã công nhân");
        a5.add("Tên công nhân");
        a5.add("Ca làm việc");
        a5.add("Tên sản phẩm");
        a5.add("Đơn giá");
        a5.add("Số lượng");
        dm3=(DefaultTableModel)tb3.getModel();
        dm3.setDataVector(a6, a5);
        a7.add("Mã công nhân");
        a7.add("Tên công nhân");
        a7.add("Ca làm việc");
        a7.add("Tên sản phẩm");
        a7.add("Đơn giá");
        a7.add("Số lượng");
        dm4=(DefaultTableModel)tb4.getModel();
        dm4.setDataVector(a8, a7);
        txtMaCN.setEnabled(false);
        txtMaSP.setEnabled(false);
        txtCLV.setEnabled(false);
        txtDG.setEnabled(false);
        txtTCN.setEnabled(false);
        loadCongNhan();
        loadSanPham();
        loadComBoMaSP();
        loadComBoTen();
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
                a2.add(v);
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
                a4.add(v);
            }tb2.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadComBoMaSP(){
        comboMaCN.removeAllItems();
        for(int i=0;i<a2.size();i++){
            Vector<String> v=(Vector<String>)a2.get(i);
            comboMaCN.addItem(v.get(0).toString());
        }
    }
    private void loadComBoTen(){
        comboTenSP.removeAllItems();
        for(int i=0;i<a4.size();i++){
            Vector<String> v=(Vector<String>)a4.get(i);
            comboTenSP.addItem(v.get(1).toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaCN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenCN = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtCaSX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtNhomSP = new javax.swing.JTextField();
        txtGiaSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        comboMaCN = new javax.swing.JComboBox<>();
        txtTCN = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCLV = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        comboTenSP = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtSSP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDG = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        jLabel1.setText("Mã CN");

        jLabel2.setText("Tên CN");

        jLabel3.setText("Số DT");

        jLabel4.setText("Ca SX");

        jLabel5.setText("Địa chỉ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenCN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaCN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCaSX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCaSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Công nhân", jPanel1);

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

        jLabel6.setText("Mã SP");

        jLabel7.setText("Tên SP");

        jLabel8.setText("Nhóm SP");

        jLabel9.setText("Giá SP");

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
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSP)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNhomSP)
                    .addComponent(txtGiaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhomSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel10.setText("Mã CN");

        comboMaCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMaCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMaCNActionPerformed(evt);
            }
        });

        jLabel11.setText("Tên CN");

        jLabel12.setText("Ca LV");

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

        jLabel13.setText("Tên SP");

        comboTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTenSPActionPerformed(evt);
            }
        });

        jLabel14.setText("Số SP");

        jLabel15.setText("Đơn giá");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboMaCN, 0, 142, Short.MAX_VALUE)
                            .addComponent(txtTCN)
                            .addComponent(txtCLV))
                        .addGap(151, 151, 151)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTenSP, 0, 141, Short.MAX_VALUE)
                            .addComponent(txtSSP)
                            .addComponent(txtDG)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton3)
                        .addGap(162, 162, 162)
                        .addComponent(jButton4)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboMaCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(txtSSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCLV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane4)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Tính công", jPanel3);

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

    private void comboMaCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMaCNActionPerformed
        for(int i=0;i<=comboMaCN.getSelectedIndex();i++){
            int r=comboMaCN.getSelectedIndex();
            txtTCN.setText(tb1.getValueAt(r, 1).toString());
            txtCLV.setText(tb1.getValueAt(r, 4).toString());
        }
    }//GEN-LAST:event_comboMaCNActionPerformed

    private void comboTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenSPActionPerformed
        for(int i=0;i<=comboTenSP.getSelectedIndex();i++){
            int r=comboTenSP.getSelectedIndex();
            txtDG.setText(tb2.getValueAt(r, 3).toString());
        }
    }//GEN-LAST:event_comboTenSPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtMaCN.setText(10000+tb1.getRowCount()+"");
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
            v.add(txtCaSX.getText());
            a2.add(v);
        }
        tb1.updateUI();
        int mad=Integer.parseInt(txtMaCN.getText());
        CongNhan c=new CongNhan(Integer.parseInt(txtMaCN.getText()), txtTenCN.getText(), txtDiaChi.getText(), txtSDT.getText(),txtCaSX.getText());
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtMaSP.setText(10000+tb2.getRowCount()+"");
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
        double gia=Double.parseDouble(txtGiaSP.getText());
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
            v.add(txtGiaSP.getText());
            a4.add(v);
            tb2.updateUI();
        int mad=Integer.parseInt(txtMaSP.getText());
        double gia1=Double.parseDouble(txtGiaSP.getText());
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
    }//GEN-LAST:event_jButton2ActionPerformed
    private boolean ktrTrung(String tenCN, String tenSP){
        for(int i=0;i<a6.size();i++){
            if(tb3.getValueAt(i, 1).toString().equalsIgnoreCase(tenCN)==true && tb3.getValueAt(i, 3).toString().equalsIgnoreCase(tenSP)==true)
                return true;
        }
        return false;
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CongNhan c=new CongNhan();
        SanPham s=new SanPham();
        if(!ktrTrung(txtTCN.getText(), comboTenSP.getSelectedItem().toString())){
            int n=Integer.parseInt(txtSSP.getText());
            if(txtSSP.getText().length()==0 && n<0){
                try {
                    throw new Exception("si san pham khong hop le");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            else{
                for(CongNhan as:cn){
                    if(txtTCN.getText().equals(as.getHoTen())){
                        c=as;
                        break;
                    }
                }
                for(SanPham as:sp){
                    if(comboTenSP.getSelectedItem().toString().equals(as.getTenSP())){
                        s=as;
                        break;
                    }
                }
                c.setS(s);
                cs.add(new Pair<>(c,s));
                si.add(new Pair<>(c,Integer.parseInt(txtSSP.getText())));
                Vector<Object> v=new Vector<Object>();
                v.add(c.getMaCN());
                v.add(c.getHoTen());
                v.add(c.getCa());
                v.add(s.getTenSP());
                v.add(s.getDonGia());
                v.add(txtSSP.getText());
                a6.add(v);
                tb3.updateUI();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ban nhao da bi trung");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dm4.setRowCount(0);
        sapXep();
        for(CongNhan as:cn){
            for(Pair a:cs){
               for(Pair b:si){
                   if(a.getKey() == as){
                       if(b.getKey() == a.getKey()){
                           Vector<Object> v=new Vector<Object>();
                           v.add(as.getMaCN());
                           v.add(as.getHoTen());
                           v.add(as.getCa());
                           v.add(as.getS().getTenSP());
                           v.add(as.getS().getDonGia());
                           v.add(b.getValue());
                           a8.add(v);
                       }
                   }
               }
            }
        }tb4.updateUI();
    }//GEN-LAST:event_jButton4ActionPerformed
    private void sapXep(){
        Collections.sort(cn, new Comparator<CongNhan>() {
            @Override
            public int compare(CongNhan o1, CongNhan o2) {
                String[] m=o1.getHoTen().split(" ");
                String[] n=o2.getHoTen().split(" ");
                return m[m.length-1].compareToIgnoreCase(n[n.length-1]);
            }
        });
    }
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
    private javax.swing.JComboBox<String> comboMaCN;
    private javax.swing.JComboBox<String> comboTenSP;
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
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JTextField txtCLV;
    private javax.swing.JTextField txtCaSX;
    private javax.swing.JTextField txtDG;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiaSP;
    private javax.swing.JTextField txtMaCN;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNhomSP;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSSP;
    private javax.swing.JTextField txtTCN;
    private javax.swing.JTextField txtTenCN;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
