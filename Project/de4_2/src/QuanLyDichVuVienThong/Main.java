package QuanLyDichVuVienThong;
 
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
    ArrayList<KhachHang> kh=new ArrayList<KhachHang>();
    ArrayList<DichVu> dv=new ArrayList<DichVu>();
    ArrayList<Pair<KhachHang, DichVu>> kd=new ArrayList<Pair<KhachHang, DichVu>>();
    ArrayList<Pair<Integer, KhachHang>> ik=new ArrayList<Pair<Integer, KhachHang>>();
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
        a5.add("Thời gian lập hd");
        dm2=(DefaultTableModel)tb2.getModel();
        dm2.setDataVector(a6, a5);
        a7.add("Mã hóa đơn");
        a7.add("Tên khách hàng");
        a7.add("Tên dịch vụ");
        a7.add("Giá dịch vụ");
        a7.add("Thời gian lập hd");
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
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        comboLoaiKH = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        txtMaDV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboDonVi = new javax.swing.JComboBox<>();
        txtGiaCuoc = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        comboTenKH = new javax.swing.JComboBox<>();
        comboTenDV = new javax.swing.JComboBox<>();
        txtGiaDV = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(tb);

        jLabel1.setText("Mã khách hàng");

        jLabel2.setText("Tên khách hàng");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Số điện thoại");

        comboLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ca nhan", "dai dien don vi hanh chinh", "dai dien don vi kinh doanh" }));

        jLabel5.setText("Loại khách hàng");

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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap(158, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(53, 53, 53)
                            .addComponent(comboLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(189, 189, 189)))
                    .addGap(73, 73, 73)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGap(31, 31, 31)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(comboLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(59, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane2.setViewportView(tb1);

        jLabel6.setText("Mã dịch vụ");

        jLabel7.setText("Tên dịch vụ");

        jLabel8.setText("Giá cước");

        jLabel9.setText("Đơn vị tính");

        comboDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MB", "ngay", "thang", "so luot" }));

        jButton4.setText("Thêm");
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jButton4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(126, 126, 126))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(364, 364, 364)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8))
                    .addContainerGap(268, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel8)
                    .addGap(44, 44, 44)
                    .addComponent(jLabel9)
                    .addContainerGap(70, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel13.setText("Giá dịch vụ");

        jLabel12.setText("Tên dịch vụ ");

        jLabel11.setText("Tên khách hàng");

        jLabel10.setText("Mã hóa dơn");

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

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sắp xếp");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtGiaDV))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTenDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboTenKH, 0, 143, Short.MAX_VALUE))
                        .addGap(59, 59, 59))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel3);

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
        txtMaKH.setText(10000+tb.getRowCount()+"");
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtMaDV.setText(100+tb1.getRowCount()+"");
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

    private void comboTenKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTenKHMouseClicked

    }//GEN-LAST:event_comboTenKHMouseClicked

    private void comboTenDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTenDVMouseClicked

    }//GEN-LAST:event_comboTenDVMouseClicked

    private void comboTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenDVActionPerformed
        for(int i=0;i<=comboTenDV.getSelectedIndex();i++){
            int r=comboTenDV.getSelectedIndex();
            txtGiaDV.setText(tb1.getValueAt(r, 2).toString());
        }
    }//GEN-LAST:event_comboTenDVActionPerformed
    private boolean jtraTrung(String tenKH, String tenDV){
        for(int i=0;i<a6.size();i++){
            if(tb2.getValueAt(i, 1).toString().equalsIgnoreCase(tenKH)==true && 
                    tb2.getValueAt(i, 2).toString().equalsIgnoreCase(tenDV)==true)
                return true;
        }
        return false;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtMaHD.setText(1000+tb2.getRowCount()+"");
        KhachHang k=new KhachHang();
        DichVu v=new DichVu();
        if(!jtraTrung(comboTenKH.getSelectedItem().toString(), comboTenDV.getSelectedItem().toString())){
            String ten=comboTenKH.getSelectedItem().toString();
            String tendv=comboTenDV.getSelectedItem().toString();
            for(KhachHang as:kh){
                if(ten.equals(as.getHoTen())){
                    k=as;
                    break;
                }
            }
            for(DichVu as:dv){
                if(tendv.equals(as.getTenDV())){
                    v=as;
                    break;
                }
            }
            k.setV(v);
            kd.add(new Pair<>(k,v));
            ik.add(new Pair<>(Integer.parseInt(txtMaHD.getText()),k));
            Vector<Object> vec=new Vector<Object>();
            vec.add(txtMaHD.getText());
            vec.add(k.getHoTen());
            vec.add(v.getTenDV());
            vec.add(v.getGia());
            vec.add(java.time.LocalDate.now());
            a6.add(vec);
            tb2.updateUI();
        }
        else{
            JOptionPane.showMessageDialog(null, "Trung !!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dm3.setRowCount(0);
        sapxep();
        for(KhachHang as:kh){
            for(Pair a:kd){
                for(Pair b:ik){
                    if(a.getKey() == as){
                        if(b.getValue() == a.getKey()){
                            Vector<Object> vec=new Vector<Object>();
                            vec.add(b.getKey());
                            vec.add(as.getHoTen());
                            vec.add(as.getV().getTenDV());
                            vec.add(as.getV().getGia());
                            vec.add(java.time.LocalDate.now());
                            a8.add(vec);
                        }
                    }
                }
                
            }
        }
        tb3.updateUI();
    }//GEN-LAST:event_jButton3ActionPerformed
    private void sapxep(){
        Collections.sort(kh, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                String[] m=o1.getHoTen().split(" ");
                String[] n=o2.getHoTen().split(" ");
                return m[m.length-1].compareToIgnoreCase(n[n.length-1]);
            }
        });
    }
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
    private javax.swing.JComboBox<String> comboDonVi;
    private javax.swing.JComboBox<String> comboLoaiKH;
    private javax.swing.JComboBox<String> comboTenDV;
    private javax.swing.JComboBox<String> comboTenKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
