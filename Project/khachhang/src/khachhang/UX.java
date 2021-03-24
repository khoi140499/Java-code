package khachhang;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
public class UX extends JFrame{
    DefaultMutableTreeNode mt=null;
    DefaultTableModel dm;
    JTable tb;
    JTree jtree;
    JTextField txtma, txtten, txtsdt, txtemail;
    JButton btnxoa, btnluu;
    ArrayList<NhomKH> nhomkh;
    ArrayList<KHang> khang;
    NhomKH nhoms=null;
    public UX(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
        data();
    }
    private void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        JPanel trai=new JPanel();
        trai.setPreferredSize(new Dimension(300, 0));
        JPanel phai=new JPanel();
        JSplitPane js=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, trai , phai);
        con.setLayout(new BorderLayout());
        con.add(js, BorderLayout.CENTER);
        
        phai.setLayout(new BorderLayout());
        JPanel phai1=new JPanel();
        phai1.setPreferredSize(new Dimension(0, 300));
        JPanel phai2=new JPanel();
        JSplitPane js1=new JSplitPane(JSplitPane.VERTICAL_SPLIT, phai1 , phai2);
        phai.add(js1, BorderLayout.CENTER);
         
        trai.setLayout(new BorderLayout());
        mt=new DefaultMutableTreeNode("Quan An");
        jtree=new JTree(mt);
        JScrollPane jsl=new JScrollPane(jtree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        trai.add(jtree, BorderLayout.CENTER);
        
        phai1.setLayout(new BorderLayout());
        dm=new DefaultTableModel();
        dm.addColumn("Ma Khach Hang");
        dm.addColumn("Ten Khach Hang");
        dm.addColumn("So Dien Thoai");
        dm.addColumn("E-Mail");
        
        tb=new JTable(dm);
        JScrollPane jscol=new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        phai1.add(jscol, BorderLayout.CENTER);
        
        phai2.setLayout(new BoxLayout(phai2, BoxLayout.Y_AXIS));
        JPanel main2=new JPanel();
        main2.setLayout(new BoxLayout(main2, BoxLayout.Y_AXIS));
        
        phai2.add(main2);
        
        JPanel ma=new JPanel();
        ma.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel tma=new JLabel("Ma");
        txtma=new JTextField(20);
        ma.add(tma);
        ma.add(txtma);
        main2.add(ma);
        
        JPanel ten=new JPanel();
        ten.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel tten=new JLabel("Ten Khach Hang");
        txtten=new JTextField(20);
        ten.add(tten);
        ten.add(txtten);
        main2.add(ten);
        
        JPanel phone=new JPanel();
        phone.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel tphone=new JLabel("So Dien Thoai");
        txtsdt=new JTextField(20);
        phone.add(tphone);
        phone.add(txtsdt);
        main2.add(phone);
        
        JPanel email=new JPanel();
        email.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel temail=new JLabel("E-Mail");
        txtemail=new JTextField(20);
        email.add(temail);
        email.add(txtemail);
        main2.add(email);
        
        tma.setPreferredSize(tten.getPreferredSize());
        tphone.setPreferredSize(tten.getPreferredSize());
        temail.setPreferredSize(tten.getPreferredSize());
        
        JPanel button=new JPanel();
        main2.add(button);
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
        
        JPanel pnbt=new JPanel();
        pnbt.setLayout(new FlowLayout());
        btnluu=new JButton("Luu");
        btnxoa=new JButton("Xoa");
        pnbt.add(btnluu);
        pnbt.add(btnxoa);
        button.add(pnbt);
    }
    private void addEvent() {
       jtree.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
               DefaultMutableTreeNode nn=(DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();
               if(nn!=null  && nn.getLevel()==1){
                   nhoms=(NhomKH) nn.getUserObject();//lay doi tuong truyen vao
                   hienthitheonhom( );
               }
           }
          @Override
           public void mousePressed(MouseEvent e) {
           }
           @Override
           public void mouseReleased(MouseEvent e) {
           }
           @Override
           public void mouseEntered(MouseEvent e) {
           }
           @Override
           public void mouseExited(MouseEvent e) {
           }
           private void hienthitheonhom() {
               dm.setRowCount(0);
               for(KHang kh:nhoms.getKhang()){
                   Vector<String> vec=new Vector<String>();
                   vec.add(kh.getMa());
                   vec.add(kh.getTen());
                   vec.add(kh.getPhone());
                   vec.add(kh.getEmail());
                   dm.addRow(vec);
               }
           }
       });
       tb.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
                int row=tb.getSelectedRow();
                String ma=tb.getValueAt(row, 0)+"";
                String ten=tb.getValueAt(row, 1)+"";
                String sdt=tb.getValueAt(row, 2)+"";
                String email=tb.getValueAt(row, 3)+"";
                txtma.setText(ma);
                txtten.setText(ten);
                txtsdt.setText(sdt);
                txtemail.setText(email);
           }
           @Override
           public void mousePressed(MouseEvent e) {
           }
           @Override
           public void mouseReleased(MouseEvent e) {
           }
           @Override
           public void mouseEntered(MouseEvent e) {
           }
           @Override
           public void mouseExited(MouseEvent e) {
           }
       });
       btnluu.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            KHang kh=new KHang(txtma.getText(), txtten.getText(), txtsdt.getText(), txtemail.getText());
            nhoms.themKhachHang(kh);
           }
       });
       btnxoa.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int row=tb.getSelectedRow();
               if(row==-1) return;
               dm.removeRow(row);
               jtree.removeSelectionRow(row);
           }
       });
    }
    public void showWindow(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void data() {
        nhomkh=new ArrayList<>();
        NhomKH nv1=new NhomKH("KH1", "Khach Hang Vip");
        NhomKH nv2=new NhomKH("KH2", "Khach Hang Tiem Nang");
        NhomKH nv3=new NhomKH("KH3", "Khach Hang Vip");
        NhomKH nv4=new NhomKH("KH4", "Khach Hang Tiem Nang");
        nhomkh.add(nv1);
        nhomkh.add(nv2);
        nhomkh.add(nv3);
        nhomkh.add(nv4);

        nv1.getKhang().add(new KHang("MP1", "Hoang Dang Khoi", "0388618961", "khoidanghoang144@gmail.com"));
        nv2.getKhang().add(new KHang("MP2", "An Quang Ngoc", "0325531088", "yeuemchungtinh@yahoo.com"));
        nv2.getKhang().add(new KHang("MP31", "Dinh The Vinh", "0332437188", "nangcongchuangutrongrung@gmail.com"));
        nv3.getKhang().add(new KHang("MP4", "Dao Anh Thang", "0334291788", "boynhangheothichanthitheo@yahoo.com"));
        nv3.getKhang().add(new KHang("MP5", "To Van Quyen", "0334537288", "Kiemtuyen@gmail.com"));
        nv1.getKhang().add(new KHang("MP6", "Dao Huy Hoang", "033524988", "nhatkimanh_1993@gmail.com"));
        nv4.getKhang().add(new KHang("MP7", "Nguyen Ha Giang My", "0335746788", "email@webico.vn"));
        for(NhomKH f:nhomkh){
            DefaultMutableTreeNode dmm=new DefaultMutableTreeNode(f);
            mt.add(dmm);
            for(KHang khach : f.getKhang()){
                    DefaultMutableTreeNode nnhom=new DefaultMutableTreeNode(khach);
                    dmm.add(nnhom);
            }
        }  
        jtree.expandRow(0);
        
    }
}
