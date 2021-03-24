package giaodien;

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
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

public class UI extends JFrame{
    JTextField txtma, txtten, txttuoi, txtquequan;
    JComboBox<LopHoc>combolophoc;
    ArrayList<LopHoc>arlh;
    ArrayList<SinhVien>arsv;
    DefaultTableModel dm;
    JTable tb;
    LopHoc lophoc;
    SinhVien sinhvien;
    JButton btnthem, btnxoa, btnthoat, btnreset;
    public UI(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
        data();
    }
    private void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BorderLayout());
        con.add(main);
        
        JPanel trai=new JPanel();
        trai.setPreferredSize(new Dimension(400, 0));
        trai.setLayout(new BorderLayout());
        
        JPanel phai =new JPanel();
        phai.setLayout(new BoxLayout(phai, BoxLayout.Y_AXIS));
        
        JSplitPane jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,trai, phai);
        main.add(jsp, BorderLayout.CENTER);
        
        dm=new DefaultTableModel();
        dm.addColumn("Ma");
        dm.addColumn("Ten Sinh Vien");
        dm.addColumn("Tuoi");
        dm.addColumn("Que quan");
        
        tb=new JTable(dm);
        JScrollPane js=new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        trai.add(js, BorderLayout.CENTER);
        
        JPanel main2=new JPanel();
        main2.setLayout(new FlowLayout());
        phai.add(main2);
        JLabel chon=new JLabel("Lop");
        combolophoc=new JComboBox<>();
        main2.add(chon);
        combolophoc.setPreferredSize(new Dimension(150, 23));
        main2.add(combolophoc);
        
        JPanel pnma=new JPanel();
        pnma.setLayout(new FlowLayout());
        JLabel ma=new JLabel("Ma");
        txtma=new JTextField(17);
        pnma.add(ma);
        pnma.add(txtma);
        phai.add(pnma);
        
        JPanel pnten=new JPanel();
        pnten.setLayout(new FlowLayout());
        JLabel ten=new JLabel("Ten Sinh Vien");
        txtten=new JTextField(17);
        pnten.add(ten);
        pnten.add(txtten);
        phai.add(pnten);
        
        JPanel pntuoi=new JPanel();
        pnma.setLayout(new FlowLayout());
        JLabel tuoi=new JLabel("Tuoi");
        txttuoi=new JTextField(17);
        pntuoi.add(tuoi);
        pntuoi.add(txttuoi);
        phai.add(pntuoi);
        
        JPanel pnquequan=new JPanel();
        pnquequan.setLayout(new FlowLayout());
        JLabel quequan=new JLabel("Que Quan");
        txtquequan=new JTextField(17);
        pnquequan.add(quequan);
        pnquequan.add(txtquequan);
        phai.add(pnquequan);
        
        ma.setPreferredSize(ten.getPreferredSize());
        tuoi.setPreferredSize(ten.getPreferredSize());
        quequan.setPreferredSize(ten.getPreferredSize());
        
        JPanel buttom=new JPanel();
        buttom.setLayout(new BoxLayout(buttom, BoxLayout.X_AXIS));
        phai.add(buttom);
        
        JPanel bt2=new JPanel();
        bt2.setLayout(new FlowLayout());
        btnthem=new JButton("Them");
        btnreset=new JButton("Reset");
        bt2.add(btnthem);
        bt2.add(btnreset);
        buttom.add(bt2);
        
        JPanel but2=new JPanel();
        but2.setLayout(new FlowLayout(FlowLayout.LEFT));
        main.add(but2, BorderLayout.SOUTH);
        btnxoa=new JButton("Xoa");
        btnthoat=new JButton("Thoat");
        but2.add(btnxoa);
        but2.add(btnthoat);
    }
    private void addEvent() {
        btnthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtma.setText("");
                txtten.setText("");
                txttuoi.setText("");
                txtquequan.setText("");
            }
        });
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tb.getSelectedRow();
                if(row==-1) return;
                dm.removeRow(row);
            }
        });
        btnthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String>b=new Vector<String>();
                String a=txtma.getText();
                String a1=txtten.getText();
                String a2=txttuoi.getText();
                String a3=txtquequan.getText();
                b.add(a);
                 b.add(a1);
                  b.add(a2);
                   b.add(a3);
                if(combolophoc.getSelectedIndex()==-1) return;
                lophoc=(LopHoc) combolophoc.getSelectedItem();
                dm.addRow(lophoc.getSinhvien());
                dm.addRow(b);
            }
        });
        tb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=tb.getSelectedRow();
                String b=tb.getValueAt(row, 0)+"";
                String b1=tb.getValueAt(row, 1)+"";
                String b2=tb.getValueAt(row, 2)+"";
                String b3=tb.getValueAt(row, 3)+"";
                JOptionPane.showMessageDialog(null,"Ma: "+b+"\nTen: "+b1+"\nTuoi: "+b2+"\nQue quan: "+b3);
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
        combolophoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(combolophoc.getSelectedIndex()==-1) return;
                lophoc=(LopHoc) combolophoc.getSelectedItem();
                dm.addRow(lophoc.getSinhvien());
                
            }
        });
    }
        private void data() {
            arlh=new ArrayList<>();
            LopHoc a=new LopHoc();
            a.setMa("MP1");
            a.setTenLop("601A2");
            
            LopHoc b=new LopHoc();
            b.setMa("MP2");
            b.setTenLop("404A2");
            
            LopHoc c=new LopHoc();
            c.setMa("MP3");
            c.setTenLop("501A2");
            
            arlh.add(a);
            arlh.add(b);
            arlh.add(c);
            
            arsv=new ArrayList<>();
            
            a.getSinhvien().add(new SinhVien("SV1", "Hoang Dang Khoi", "20", "Bac Giang"));
            
            for(LopHoc x:arlh){
                combolophoc.addItem(x);
            }
            
    }
    public void showWindow(){
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
