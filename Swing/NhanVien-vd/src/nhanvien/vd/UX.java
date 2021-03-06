package nhanvien.vd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class UX extends JFrame{
    JButton btnthem, btnluu, btnxoa, btnthoat;
    JComboBox<PhongBan>combopb;
    JList<NhanVien>listnv;
    JTextField txtma, txtten, txtnvl, txtns;
    ArrayList<PhongBan>arpb;
    ArrayList<NhanVien>arnv;
    PhongBan pnselect=null;
    NhanVien nvselect=null;
    DefaultTableModel tb;
    SimpleDateFormat sdf=new SimpleDateFormat();
    JTable tb1;
    public UX(){
        super("Test giao dien");
        addControl();
        addEvent();
        data();
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BorderLayout());
        
        JPanel trai=new JPanel();
        trai.setPreferredSize(new Dimension(450, 0));
        JPanel phai=new JPanel();
        phai.setLayout(new BoxLayout(phai, BoxLayout.Y_AXIS));
        
        JSplitPane jplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, trai, phai);
        main.add(jplit);
        con.add(main);
        
        JPanel phai1=new JPanel();
        phai1.setLayout(new BoxLayout(phai1, BoxLayout.Y_AXIS));
        
        JPanel pncbo=new JPanel();
        pncbo.setLayout(new FlowLayout());
        JLabel chon=new JLabel("Ch???n ph??ng ban");
        combopb=new JComboBox<PhongBan>();
        combopb.setPreferredSize(new Dimension(200, 25));
        pncbo.add(chon);
        pncbo.add(combopb);
        phai.add(pncbo);
        phai.add(phai1);
        
        JPanel pnma=new JPanel();
        pnma.setLayout(new FlowLayout());
        JLabel ma=new JLabel("M??");
        txtma=new JTextField(12);
        pnma.add(ma);
        pnma.add(txtma);
        phai1.add(pnma);
        
        JPanel pnten=new JPanel();
        pnten.setLayout(new FlowLayout());
        JLabel ten=new JLabel("T??n");
        txtten=new JTextField(12);
        pnten.add(ten);
        pnten.add(txtten);
        phai1.add(pnten);
        
        JPanel pnns=new JPanel();
        pnns.setLayout(new FlowLayout());
        JLabel ns=new JLabel("Ng??y Sinh");
        txtns=new JTextField(12);
        pnns.add(ns);
        pnns.add(txtns);
        phai1.add(pnns);
        
        JPanel pnnvl=new JPanel();
        pnnvl.setLayout(new FlowLayout());
        JLabel nvl=new JLabel("Ng??y V??o L??m");
        txtnvl=new JTextField(12);
        pnnvl.add(nvl);
        pnnvl.add(txtnvl);
        phai1.add(pnnvl);
        
        ma.setPreferredSize(ns.getPreferredSize());
        ten.setPreferredSize(ns.getPreferredSize());
        nvl.setPreferredSize(ns.getPreferredSize());
        
        Border br=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr=new TitledBorder(br, "Th??ng tin chi ti???t");
        tbr.setTitleColor(Color.BLUE);
        tbr.setTitleJustification(TitledBorder.CENTER);
        phai1.setBorder(tbr);
        
        
        tb=new DefaultTableModel();
        tb.addColumn("M??");
        tb.addColumn("T??n");
        tb.addColumn("Ng??y Sinh");
        tb.addColumn("Ng??y V??o L??m");
        
        tb1=new JTable(tb);
        tb.addRow(new String[]{"d "," d"," dd"," d"});
        JScrollPane js=new JScrollPane(tb1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        trai.setLayout(new BorderLayout());
        trai.add(js, BorderLayout.CENTER);
        
        JPanel butuom=new JPanel();
        butuom.setLayout(new BoxLayout(butuom, BoxLayout.X_AXIS));
        
        JPanel bn=new JPanel();
        bn.setLayout(new FlowLayout());
        butuom.add(bn);
        
        btnluu=new JButton("L??u");
        btnthem=new JButton("Th??m");
        btnxoa=new JButton("X??a");
        btnthoat=new JButton("Tho??t");
        bn.add(btnluu);
        bn.add(btnthem);
        bn.add(btnxoa);
        bn.add(btnthoat);
        butuom.add(bn);
        main.add(butuom, BorderLayout.SOUTH);
        
    }
    public void addEvent() {
        btnthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnluu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "L??u th??nh c??ng");
            }
        });
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tb1.getSelectedRow();
                tb.removeRow(row);
            }
        });
        tb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=tb1.getSelectedRow();
                String ma=tb1.getValueAt(row, 0)+"";
                String ten=tb1.getValueAt(row, 1)+"";
                String ns=tb1.getValueAt(row, 2)+"";
                String nv=tb1.getValueAt(row, 3)+"";
                JOptionPane.showMessageDialog(null, "Ma: "+ma+"\nTen: "+ten+"\nNgay Sinh: "+ns+"\nNgay Vao Lam: "+nv);
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
        btnthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> a=new Vector<>();
                a.add(txtma.getText());
                a.add(txtten.getText());
                a.add(txtns.getText());
                a.add(txtnvl.getText());
                tb.addRow(a);
            }
        });
    }
    public void showWindow(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void data() {
        arpb=new ArrayList<>();
        
        PhongBan a=new PhongBan();
        a.setMaPhong("MP1");
        a.setTenPhong("Ph??ng Gi??o V???");
        
        PhongBan b=new PhongBan();
        b.setMaPhong("MP2");
        b.setTenPhong("Ph??ng Qu???n L??");
        
        PhongBan c=new PhongBan();
        c.setMaPhong("MP3");
        c.setTenPhong("Ph??ng Sinh Vi??n");
        
        arpb.add(a);
        arpb.add(b);
        arpb.add(c);
        
       /* a.themNhanVien(new NhanVien("NV1", "Ho??ng ????ng Kh??i", new Date(1999-1900, 14, 04), new Date(2019-1900, 11, 12)));
        c.themNhanVien(new NhanVien("NV2", "An Quang Ng???c", new Date(1999-1900, 12, 02), new Date(2019-1900, 12, 2)));
        c.themNhanVien(new NhanVien("NV3", "??inh Th??? Vinh", new Date(1999-1900, 14, 01), new Date(2019-1900, 2, 12)));
        c.themNhanVien(new NhanVien("NV4", "T?? V??n Quy???n", new Date(1999-1900, 9, 04), new Date(2019-1900, 1, 3)));
        a.themNhanVien(new NhanVien("NV5", "D??o Anh Th???ng", new Date(1999-1900, 22, 07), new Date(2019-1900, 8, 12)));
        b.themNhanVien(new NhanVien("NV5", "D??o Anh Th???ng", new Date(1999-1900, 22, 07), new Date(2019-1900, 8, 12)));*/
        
        for(PhongBan f:arpb){
            combopb.addItem(f);
        }
    }
}
