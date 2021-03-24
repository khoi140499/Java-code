package bai3_2;

import bai3_2.mathang.MatHang;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Fram extends javax.swing.JFrame {
    DefaultTableModel dm=new DefaultTableModel();
    DefaultTableModel dm1=new DefaultTableModel();
    Vector a=new Vector();
    Vector b=new Vector();
    Vector c=new Vector();
    Vector d=new Vector();
    ArrayList<MatHang> mh=new ArrayList<MatHang>();
    JFileChooser file=new JFileChooser();
    public Fram() {
        initComponents();
        a.add("Mã hàng");
        a.add("Tên hàng");
        a.add("Nhóm hàng");
        a.add("Giá");
        dm=(DefaultTableModel)tb.getModel();
        dm.setDataVector(b, a);
        c.add("Mã hàng");
        c.add("Tên hàng");
        c.add("Nhóm hàng");
        c.add("Giá");
        dm1=(DefaultTableModel)tb1.getModel();
        dm1.setDataVector(d, c);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtNhom = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnMo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jcombo = new javax.swing.JComboBox<>();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnMo.setText("Mở file");
        btnMo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã hàng");

        jLabel2.setText("Tên Hàng");

        jLabel3.setText("Nhóm Hàng");

        jLabel4.setText("Giá");

        jButton5.setText("Thoát");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hang tieu dung", "hang thoi trang", "dien tu - dien lanh" }));
        jcombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMa)
                    .addComponent(txtTen)
                    .addComponent(txtNhom)
                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnMo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addComponent(jButton5)
                        .addGap(33, 33, 33)
                        .addComponent(jcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton5)
                    .addComponent(jcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnThem))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnLuu))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void sapxep(){
        Comparator<MatHang> com=new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return (int) (o2.getGia()-o1.getGia());
            }
        };
        Collections.sort(mh, com);
        Collections.sort(mh, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (new String(((MatHang)o1).getNhomHang()).compareToIgnoreCase(new String(((MatHang)o2).getNhomHang())));
            }
        });
    }
    private void btnMoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoActionPerformed
        if(file.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File f=file.getSelectedFile();
            try {
                Scanner sc=new Scanner(f);
                int maHang=0, kt=0, dem=0;
                double gia=0;
                String tenHang="", nhomHang="";
                while(sc.hasNext()){
                    try {
                        dem++;
                        maHang=Integer.parseInt(sc.nextLine());
                        String s=String.valueOf(maHang);
                        if(s.length()!=4){
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            try {
                                throw new Exception("Mat hang thu "+dem+" sai thong tin: MA MAT HANG QUA HOAC IT HON 4 KY TU");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        }
                        else{
                            tenHang=sc.nextLine();
                            if(tenHang.length()==0){
                                sc.nextLine();
                                sc.nextLine();
                                try {
                                    throw new Exception("Mat hang thu "+dem+" sai thong tin: TEN MAT HANG KHONG DUOC DE TRONG");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                            else{
                                nhomHang=sc.nextLine();
                                if(nhomHang.equalsIgnoreCase("hang tieu dung")==false && nhomHang.equalsIgnoreCase("dien tu - dien lanh")==false 
                                        && nhomHang.equalsIgnoreCase("hang thoi trang")==false){
                                    sc.nextLine();
                                    try {
                                        throw new Exception("Mat hang thu "+dem+" sai thong tin: KHONG DUNG NHOM MAT HANG");
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                }
                                else{
                                    gia=Double.parseDouble(sc.nextLine());
                                    if(gia<=0){
                                        try {
                                            throw new Exception("Mat hang thu "+dem+" sai thong tin: GIA PHAI LON HON 0");
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                        }
                                    }
                                    else kt=1;
                                }
                            }
                        }
                    } catch (NumberFormatException|InputMismatchException e) {
                        JOptionPane.showMessageDialog(null, "Mat hang thu "+dem+" sai thong tin: GIA PHAI LON HON 0");
                    }
                    if(kt==1){
                        MatHang mathang=new MatHang(maHang, tenHang, nhomHang, gia);
                        mh.add(mathang);
                        kt=0;
                    }
                }
                for(MatHang ass:mh){
                        Vector<String> vec=new Vector<String>();
                        String s1=String.valueOf(ass.getMaHang());
                        String s2=ass.getTenHang();
                        String s3=ass.getNhomHang();
                        String s4=String.valueOf(ass.getGia());
                        vec.add(s1);
                        vec.add(s2);
                        vec.add(s3);
                        vec.add(s4);
                        b.add(vec);
                    }
                    tb.updateUI();
                sapxep();
                for(MatHang ass:mh){
                        Vector<String> vec=new Vector<String>();
                        String s1=String.valueOf(ass.getMaHang());
                        String s2=ass.getTenHang();
                        String s3=ass.getNhomHang();
                        String s4=String.valueOf(ass.getGia());
                        vec.add(s1);
                        vec.add(s2);
                        vec.add(s3);
                        vec.add(s4);
                        d.add(vec);
                    }
                tb1.updateUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnMoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row=tb.getSelectedRow();
        if(row==-1) return;
        dm.removeRow(row);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try {
            PrintWriter pr=new PrintWriter(file.getSelectedFile());
            for(MatHang asss:mh)
                pr.println(asss.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLuuActionPerformed
    public void filter(String query){
        TableRowSorter<DefaultTableModel> tbb=new TableRowSorter<DefaultTableModel>(dm1);
        tb1.setRowSorter(tbb);
        tbb.setRowFilter(RowFilter.regexFilter(query));
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Vector<String> v=new Vector<String>();
        String a1=txtMa.getText();
        String a2=txtTen.getText();
        String a3=txtNhom.getText();
        String a4=txtGia.getText();
        int ma=Integer.parseInt(a1);
        double gia=Double.parseDouble(a4);
        v.add(a1);
        v.add(a2);
        v.add(a3);
        v.add(a4);
        b.add(v);
        tb.updateUI();
        MatHang m=new MatHang(ma, a2, a3, gia);
        mh.add(m);
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void jcomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboItemStateChanged
        String query=jcombo.getSelectedItem().toString();
        filter(query);
    }//GEN-LAST:event_jcomboItemStateChanged
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fram().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnMo;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcombo;
    private javax.swing.JTable tb;
    private javax.swing.JTable tb1;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNhom;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
