/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de19;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Khoi
 */
public class Main extends javax.swing.JFrame {
    DefaultTableModel dm1,dm2,dm3;
    ArrayList<SinhVien> sv=new ArrayList<SinhVien>();
    ArrayList<Phong> phong=new ArrayList<Phong>();
    ArrayList<DanhSach> ds=new ArrayList<DanhSach>();
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        createFile();
        setTable();
        hienDL();
        loadTenSV();
        loadTenPhong();
    }
    // tạo 3 file mới - "SV.txt", "Phong.txt", "DS.txt"
    private void createFile(){
        try {
            (new File("SV.txt")).createNewFile();
            (new File("Phong.txt")).createNewFile();
            (new File("DS.txt")).createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // cài đặt bảng 
    private void setTable(){
        // Khởi tạo 3 mảng chuỗi 
        String[] o1={"Ma sv","Ten sv","Dia chi","Ngay sinh","Lop"};
        String[] o2={"Ma phong","Ten phong","Loai phong"};
        String[] o3={"Ten sv","Ten phong","Loai phong","Ngay thue"};
        dm1=new DefaultTableModel(o1, 0);
        dm2=new DefaultTableModel(o2, 0);
        dm3=new DefaultTableModel(o3, 0);
        tb1.setModel(dm1);
        tb2.setModel(dm2);
        tb3.setModel(dm3);
    }
    // hien thi du lieu tu file ra 3 bang 
    private void hienDL(){
        IOFile.read(sv, "SV.txt");
        IOFile.read(phong, "Phong.txt");
        IOFile.read(ds, "DS.txt");
        for(SinhVien as:sv){
            Vector<Object> v=new Vector<Object>();
            v.add(as.getMa());
            v.add(as.getTen());
            v.add(as.getDiaChi());
            v.add(as.getNgaySinh());
            v.add(as.getLop());
            dm1.addRow(v);
        }
        for(Phong as:phong){
            Vector<Object> v=new Vector<Object>();
            v.add(as.getMa());
            v.add(as.getTenPhong());
            v.add(as.getLoaiPhong());
            dm2.addRow(v);
        }
        for(DanhSach as:ds){
            Vector<Object> v=new Vector<Object>();
            v.add(as.getTenSV());
            v.add(as.getTenPhong());
            v.add(as.getLoaiPhong());
            v.add(as.getNgayThue());
            dm3.addRow(v);
        }
    }
    // tải tất cả tên sinh viên từ bảng sinh viên(bảng 1) vào combobox Tên sinh viên
    private void loadTenSV(){
        comboTenSV.removeAllItems();
        for(SinhVien as:sv)
            comboTenSV.addItem(as.getTen());
    }
    // Tương tự đối với tên phòng
    private void loadTenPhong(){
        comboTenPhong.removeAllItems();
        for(Phong as:phong)
            comboTenPhong.addItem(as.getTenPhong());
    }
    // Khởi tạo 1 thông báo đối với lỗi khoảng trống
    private void hienTB(String s){
        try {
            throw new StringIndexOutOfBoundsException(s);
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //Khỏi tạo 1 thông báo đối với số nguyên,...
    private void hienTB1(String s){
            JOptionPane.showMessageDialog(null, "lon hon 0");
    }
    // Kiểm tra lớp
    private boolean ktraLop(String s){
        //khai bao 1 mang de luu tat ca cac chu da tach
        String[] m=s.split("");
        String s1=m[0]; // khoi tao s1 la phan tu 0;
        String s2=m[1]+m[2]; // khoi tao s2 la phan tu 1,2;
        String s3=m[3]+m[4]; // tuong tu
        String s4=m[5]+m[6];
        String s5=m[7]+m[8];
        String s6=m[9]+m[10];
        if(s1.equalsIgnoreCase("b")==true && s1.equalsIgnoreCase("e")==true
          | Integer.parseInt(s2)>0 && s2.length()==2 | s3.equalsIgnoreCase("cq")==true &&
                s3.equalsIgnoreCase("cd")==true |s4.equalsIgnoreCase("cn")==true && 
                s4.equalsIgnoreCase("at")==true | s4.equalsIgnoreCase("vt")==true &&
                s4.equalsIgnoreCase("dt")==true| Integer.parseInt(s5)>0 && s5.length()==2
                | s6.equalsIgnoreCase("-b")==true && s6.equalsIgnoreCase("-n")){
            return false;
        }
        return true;
    }
    //Kiểm tra định dạng ngày
    private boolean ktraNgay(String s){
        // khai bao 1 mang 
        String[] m=s.split("");
        String s1=m[0]+m[1];
        String s2=m[2];
        String s3=m[3]+m[4];
        String s4=m[5];
        String s5=m[6]+m[7]+m[8]+m[9];
        if(s1.length()==2 && Integer.parseInt(s1)>0 | s2.equals("/")==true | s3.length()==2 && Integer.parseInt(s3)>0 |
                s4.endsWith("/")==true |Integer.parseInt(s5)>0 && s5.length()==4){
            return true;
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLop = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        comboTenSV = new javax.swing.JComboBox<>();
        comboTenPhong = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLoaiPhong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNgayThue = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();

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

        jLabel2.setText("Ten SV");

        jLabel3.setText("Dia chi");

        jLabel4.setText("Ngay sinh");

        jLabel5.setText("Lop");

        jButton1.setText("Them");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(96, 96, 96)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sinh vien", jPanel1);

        jLabel7.setText("Ten phong");

        jLabel8.setText("Loai phong");

        jButton2.setText("Them");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "chat luong cao", "thuong" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(jButton2))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(96, 96, 96)
                            .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(79, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGap(117, 117, 117)
                    .addComponent(jButton2)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phong", jPanel2);

        comboTenSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboTenPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTenPhongActionPerformed(evt);
            }
        });

        jLabel9.setText("Ten phong");

        jLabel10.setText("Ten sv");

        jLabel11.setText("Loai phong");

        jLabel12.setText("Ngay thue");

        jButton3.setText("Them");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sap xep theo ten sinh vien");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Sap xep theo ten phong");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayThue)
                    .addComponent(comboTenSV, 0, 161, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLoaiPhong)
                    .addComponent(comboTenPhong, 0, 151, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(36, 36, 36)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(43, 43, 43))
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 495, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sach tro", jPanel3);

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dm3.setRowCount(0);
        Collections.sort(ds, new Comparator<DanhSach>() {
            @Override
            public int compare(DanhSach o1, DanhSach o2) {
                return o1.getTenPhong().compareTo(o2.getTenPhong());
            }
        });
        for(DanhSach as:ds){
            Vector<Object> v=new Vector<Object>();
            v.add(as.getTenSV());
            v.add(as.getTenPhong());
            v.add(as.getLoaiPhong());
            v.add(as.getNgayThue());
            dm3.addRow(v);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dm3.setRowCount(0);
        Collections.sort(ds, new Comparator<DanhSach>() {
            @Override
            public int compare(DanhSach o1, DanhSach o2) {
                String[] m=o1.getTenSV().split(" ");// khai bao 1 mang de luu cac phan tu cua ten sinh vien sau khi tach
                String[] n=o2.getTenSV().split(" "); // tuong tu
                return m[m.length-1].compareTo(n[n.length-1]); // so sanh phan tu cuoi
            }
        });
        for(DanhSach as:ds){
            Vector<Object> v=new Vector<Object>();
            v.add(as.getTenSV());
            v.add(as.getTenPhong());
            v.add(as.getLoaiPhong());
            v.add(as.getNgayThue());
            dm3.addRow(v);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    private boolean ktraTrung(String tenSv, String tenPhong){
        for(int i=0;i<tb3.getRowCount();i++){
            if(tb3.getValueAt(i, 0).toString().equals(tenSv)==true &&
                    tb3.getValueAt(i, 1).toString().equals(tenPhong)==true)
                return true;
        }
        return false;
    }
    // tra ve so sinh cua 1 phong
    private int soSV(String tenPhong){
        int dem=0;
        for(int i=0;i<tb3.getRowCount();i++){
            if(tb3.getValueAt(i, 1).toString().equals(tenPhong)==true)
                dem++;
        }
        return dem;
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if(ktraNgay(txtNgayThue.getText())==false){
                hienTB1("Ngay sai dinh dang : dd/MM/yyyy");
            }
            else{
                if(!ktraTrung(comboTenSV.getSelectedItem().toString(), comboTenPhong.getSelectedItem().toString())){
                    if(soSV(comboTenPhong.getSelectedItem().toString())>7){
                        JOptionPane.showMessageDialog(null, "1 phong chi chua toi da 8 sinh vien");
                    }
                    else{
                        Vector<Object> v=new Vector<Object>();
                        v.add(comboTenSV.getSelectedItem().toString());
                        v.add(comboTenPhong.getSelectedItem().toString());
                        v.add(txtLoaiPhong.getText());
                        v.add(txtNgayThue.getText());
                        DanhSach a=new DanhSach(comboTenSV.getSelectedItem().toString(), comboTenPhong.getSelectedItem().toString(),
                            txtLoaiPhong.getText(), txtNgayThue.getText());
                        ds.add(a);
                        dm3.addRow(v);
                        IOFile.write(ds, "DS.txt");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "trung");
                }
            }
        } catch (ArrayIndexOutOfBoundsException|NumberFormatException|StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Ngay phai co sinh dang: dd/MM/yyyy");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboTenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenPhongActionPerformed
        for(int i=0;i<=comboTenPhong.getSelectedIndex();i++){
            int r=comboTenPhong.getSelectedIndex();
            txtLoaiPhong.setText(tb2.getValueAt(r, 2).toString());
        }
    }//GEN-LAST:event_comboTenPhongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String s=100+tb2.getRowCount()+"";
        try {
            if(txtTenPhong.getText().isEmpty()){
                hienTB("ten k dc de trong");
            }
            else {
                Vector<Object> v=new Vector<Object>();
                v.add(s);
                v.add(txtTenPhong.getText());
                v.add(jComboBox1.getSelectedItem().toString());
                dm2.addRow(v);
                Phong a=new Phong(Integer.parseInt(s), txtTenPhong.getText(), jComboBox1.getSelectedItem().toString());
                phong.add(a);
                IOFile.write(phong, "Phong.txt");
            }
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Khong dc bo trong cac o");
        }
        loadTenPhong();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s=10000+tb1.getRowCount()+"";
        try {
            if(txtTenSV.getText().isEmpty()){
                hienTB("ten k dc de trong");
            }
            else if(txtDiaChi.getText().isEmpty()){
                hienTB("dia chi khong duoc de trong");
            }
            else if(ktraNgay(txtNgaySinh.getText())==false){
                hienTB("Dinh dang ngay dd/MM/yyyy");
            }
            else if(!ktraLop(txtLop.getText())){
                try {
                    throw new Exception("Lop k dung dinh dang");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            else{
                Vector<Object> v=new Vector<Object>();
                v.add(s);
                v.add(txtTenSV.getText());
                v.add(txtDiaChi.getText());
                v.add(txtNgaySinh.getText());
                v.add(txtLop.getText());
                dm1.addRow(v);
                SinhVien a=new SinhVien(Integer.parseInt(s), txtTenSV.getText(),
                    txtDiaChi.getText(), txtNgaySinh.getText(), txtLop.getText());
                sv.add(a);
                IOFile.write(sv, "SV.txt");
            }
        } catch (StringIndexOutOfBoundsException|ArrayIndexOutOfBoundsException|NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lop phai co dung dinh dang; dinh dang ngay dd/MM/yyyy");
        }
        loadTenSV();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox<String> comboTenPhong;
    private javax.swing.JComboBox<String> comboTenSV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgayThue;
    private javax.swing.JTextField txtTenPhong;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
