package QuanLyDiemSV;

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
    ArrayList<Pair<SinhVien, MonHoc>> sm=new ArrayList<Pair<SinhVien, MonHoc>>();
    ArrayList<Pair<MonHoc, Double>> md=new ArrayList<Pair<MonHoc, Double>>();
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        txtMaMon.setEnabled(false);
        txtMaSV.setEnabled(false);
        txtL.setEnabled(false);
        txtN.setEnabled(false);
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
        a5.add("Tên sinh viên");
        a5.add("Lớp");
        a5.add("Nhóm môn học");
        a5.add("Tên môn học");
        a5.add("Điểm");
        dm2=(DefaultTableModel)tb3.getModel();
        dm2.setDataVector(a6, a5);
        a7.add("Tên sinh viên");
        a7.add("Lớp");
        a7.add("Nhóm môn học");
        a7.add("Tên môn học");
        a7.add("Điểm");
        dm3=(DefaultTableModel)tb4.getModel();
        dm3.setDataVector(a8, a7);
        hienSV();
        hienMH();
        loadComBo1();
        load();
    }
    private void loadComBo1(){
        comboTenSinhVien.removeAllItems();
        for(int i=0;i<a2.size();i++){
            Vector v=(Vector)a2.get(i);
            comboTenSinhVien.addItem(v.get(1).toString());
        }
    }
    private void load(){
        comboTenMonHoc.removeAllItems();
        for(int i=0;i<a4.size();i++){
            Vector v=(Vector)a4.get(i);
            comboTenMonHoc.addItem(v.get(1).toString());
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtDiaCHi = new javax.swing.JTextField();
        txtLop = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSoTinCHi = new javax.swing.JTextField();
        comboNhomMon = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtDIem = new javax.swing.JLabel();
        comboTenSinhVien = new javax.swing.JComboBox<>();
        txtDiem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboTenMonHoc = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtL = new javax.swing.JTextField();
        txtN = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
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
        jScrollPane3.setViewportView(tb1);

        jLabel1.setText("Mã sinh viên");

        jLabel2.setText("Tên sinh viên");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Lớp");

        jButton1.setText("Thêm");
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
                        .addGap(55, 55, 55)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(348, 348, 348)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(35, 35, 35)
                            .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(87, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(74, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, Short.MAX_VALUE))
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
        jScrollPane4.setViewportView(tb2);

        jLabel6.setText("Mã môn");

        jLabel7.setText("Tên môn");

        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Nhóm môn");

        jLabel8.setText("Số tín chỉ");

        comboNhomMon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dai cuong", "co so nghanh", "chuyen nghanh" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenMon))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(23, 23, 23)
                                .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(20, 20, 20)
                                .addComponent(txtSoTinCHi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboNhomMon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButton3)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTinCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboNhomMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jScrollPane1.setViewportView(tb3);

        jLabel12.setText("Ten sinh viên");

        txtDIem.setText("Điểm");

        comboTenSinhVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTenSinhVienMouseClicked(evt);
            }
        });
        comboTenSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTenSinhVienActionPerformed(evt);
            }
        });

        jLabel11.setText("Nhóm môn học");

        jLabel13.setText("Tên môn học");

        comboTenMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTenMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTenMonHocActionPerformed(evt);
            }
        });

        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("Sắp xếp");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Lớp");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(144, 144, 144))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDIem)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiem)
                    .addComponent(comboTenSinhVien, 0, 150, Short.MAX_VALUE)
                    .addComponent(txtL))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDIem)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2)))
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
        jScrollPane2.setViewportView(tb4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void comboTenSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTenSinhVienMouseClicked

    }//GEN-LAST:event_comboTenSinhVienMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SinhVien s=new SinhVien();
        MonHoc m=new MonHoc();
        if(Double.parseDouble(txtDiem.getText()) < 0){
            try {
                throw new Exception("sai diem");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            String tensv=comboTenSinhVien.getSelectedItem().toString();
            String tenm=comboTenMonHoc.getSelectedItem().toString();
            for(SinhVien as:sv){
                if(tensv.equals(as.getTenSV())){
                    s=as;
                    break;
                }
            }
            for(MonHoc as:mh){
                if(tenm.equals(as.getTenMon())){
                    m=as;
                    break;
                }
            }
            m.setSv(s);
            sm.add(new Pair<>(s,m));
            md.add(new Pair<>(m,Double.parseDouble(txtDiem.getText())));
            Vector<Object> vec=new Vector<Object>();
            vec.add(s.getTenSV());
            vec.add(s.getLop());
            vec.add(m.getLoaiMon());
            vec.add(m.getTenMon());
            vec.add(txtDiem.getText());
            a6.add(vec);
            tb3.updateUI();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void comboTenSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenSinhVienActionPerformed
        for(int i=0;i<=comboTenSinhVien.getSelectedIndex();i++){
            int r=comboTenSinhVien.getSelectedIndex();
            txtL.setText(tb1.getValueAt(r, 4).toString());
        }
    }//GEN-LAST:event_comboTenSinhVienActionPerformed

    private void comboTenMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenMonHocActionPerformed
        for(int i=0;i<=comboTenMonHoc.getSelectedIndex();i++){
            int r=comboTenMonHoc.getSelectedIndex();
            txtN.setText(tb2.getValueAt(r, 3).toString());
        }
    }//GEN-LAST:event_comboTenMonHocActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dm3.setRowCount(0);
        sapxep();
        for(MonHoc as:mh){
            for(Pair a:sm){
                for(Pair b:md){
                    if(a.getValue() == as){
                        if(b.getKey() == a.getValue()){
                            Vector<Object> vec=new Vector<Object>();
                            vec.add(as.getSv().getTenSV());
                            vec.add(as.getSv().getLop());
                            vec.add(as.getLoaiMon());
                            vec.add(as.getTenMon());
                            vec.add(b.getValue());
                            a8.add(vec);
                        }
                    }
                }
            }
        }tb4.updateUI();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void sapxep(){
        Collections.sort(mh, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return o1.getTenMon().compareToIgnoreCase(o2.getTenMon());
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
    private javax.swing.JComboBox<String> comboNhomMon;
    private javax.swing.JComboBox<String> comboTenMonHoc;
    private javax.swing.JComboBox<String> comboTenSinhVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTextField txtL;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoTinCHi;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
