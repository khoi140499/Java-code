package onluyennhanvien;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class UX extends JFrame{
    JComboBox<PhongBan>cbophongban;
    JList<NhanVien>lnhanvien;
    JTextField txtma, txtten, txtnamsinh, txtngay, txtcost;
    JButton btnluu, btnxoa, btnthoat, btnreset;
    ArrayList<PhongBan>arpb;
    ArrayList<NhanVien>arnv;
    PhongBan pbse=null;
    NhanVien nvse=null;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
    public UX(){
        this.setTitle("Giao Dien");
        addControl();
        addEvent();
        data();
    }
    public void addControl(){
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel cbo=new JPanel();
        cbo.setLayout(new FlowLayout());
        JLabel lcbo=new JLabel("Chọn phòng ban");
        cbophongban=new JComboBox<PhongBan>();
        cbophongban.setPreferredSize(new Dimension(200, 25));
        cbo.add(lcbo);
        cbo.add(cbophongban);
        main.add(cbo);
        
        JPanel pncenter=new JPanel();
        pncenter.setLayout(new GridLayout(1,2));
        main.add(pncenter);
        
        JPanel pnleft=new JPanel();
        pnleft.setLayout(new FlowLayout());
        lnhanvien=new JList<NhanVien>();
        lnhanvien.setPreferredSize(new Dimension(250, 200));
        JScrollPane js=new JScrollPane(lnhanvien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
        pnleft.add(js);
        pncenter.add(pnleft);
        
        Border br3=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr3=new TitledBorder(br3, "Thông tin chi tiết");
        tbr3.setTitleJustification(TitledBorder.CENTER);
        tbr3.setTitleColor(Color.BLUE);
        pnleft.setBorder(tbr3);
        
        JPanel pnright=new JPanel();
        pnright.setLayout(new BoxLayout(pnright, BoxLayout.Y_AXIS));
        pncenter.add(pnright);
        
        JPanel pnma=new JPanel();
        pnma.setLayout(new FlowLayout());
        JLabel ma=new JLabel("Mã");
        txtma=new JTextField(15);
        pnma.add(ma);
        pnma.add(txtma);
        
        JPanel pnten=new JPanel();
        pnten.setLayout(new FlowLayout());
        JLabel ten=new JLabel("Tên");
        txtten=new JTextField(15);
        pnten.add(ten);
        pnten.add(txtten);
        
        JPanel pnngay=new JPanel();
        pnngay.setLayout(new FlowLayout());
        JLabel ngay=new JLabel("Ngày làm việc");
        txtngay=new JTextField(15);
        pnngay.add(ngay);
        pnngay.add(txtngay);
        
        JPanel pnnamsinh=new JPanel();
        pnnamsinh.setLayout(new FlowLayout());
        JLabel namsinh=new JLabel("Năm sinh");
        txtnamsinh=new JTextField(15);
        pnnamsinh.add(namsinh);
        pnnamsinh.add(txtnamsinh);
        pnright.add(pnma);
        pnright.add(pnten);
        pnright.add(pnnamsinh);
        pnright.add(pnngay);
        ma.setPreferredSize(ngay.getPreferredSize());
        ten.setPreferredSize(ngay.getPreferredSize());
        namsinh.setPreferredSize(ngay.getPreferredSize());
        
        Border br2=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr2=new TitledBorder(br2, "Thông tin chi tiết");
        tbr2.setTitleJustification(TitledBorder.CENTER);
        tbr2.setTitleColor(Color.BLUE);
        pnright.setBorder(tbr2);
        
        JPanel but=new JPanel();
        but.setLayout(new FlowLayout());
        btnluu=new JButton("Lưu");
        btnxoa=new JButton("Xóa");
        btnreset=new JButton("Reset");
        btnthoat=new JButton("Thoát");
        but.add(btnluu);
        but.add(btnxoa);
        but.add(btnreset);
        but.add(btnthoat);
        main.add(but);
        
        Border br=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr=new TitledBorder(br, "Chọn chức năng");
        tbr.setTitleJustification(TitledBorder.CENTER);
        tbr.setTitleColor(Color.BLUE);
        but.setBorder(tbr);
        
        
    }
    public void addEvent() {
        btnreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtma.setText("");
                txtten.setText("");
                txtngay.setText("");
                txtnamsinh.setText("");
            }
        });
        btnthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cbophongban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbophongban.getSelectedIndex()==-1) return;
                pbse=(PhongBan) cbophongban.getSelectedItem();
                lnhanvien.setListData(pbse.getNhanVien());
            }
        });
        lnhanvien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(lnhanvien.getSelectedIndex()==-1)return;
                nvse=lnhanvien.getSelectedValue();
                txtma.setText(nvse.getMaNhanVen());
                txtten.setText(nvse.getTenNhanVien());
                txtnamsinh.setText(sdf.format(nvse.getNgaySinh()));
                txtngay.setText(sdf.format(nvse.getNgayVaoLam()));
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
                try{
                    NhanVien nv=new NhanVien(txtma.getText(), txtten.getText(), sdf.parse(txtnamsinh.getText()), sdf.parse(txtngay.getText()));
                    if(pbse!=null){
                        pbse.themNhanVien(nv);
                        lnhanvien.setListData(pbse.getNhanVien());
                    }
                }catch(Exception t){
                    t.printStackTrace();
                }
            }
        });
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nvse!=null){
                    pbse.getNhanVien().remove(nvse);
                    nvse=null;
                    lnhanvien.setListData(pbse.getNhanVien());
                }
            }
        });
    }
    public void data() {
        arpb=new ArrayList<>();
        PhongBan a=new PhongBan();
        a.setMaPhong("MP1");
        a.setTenPhong("Phòng quản lí sinh viên");
        
        PhongBan b=new PhongBan();
        b.setMaPhong("MP2");
        b.setTenPhong("Phòng bảo vệ");
        
        PhongBan c=new PhongBan();
        c.setMaPhong("MP3");
        c.setTenPhong("Phòng giám đốc");
        
        a.themNhanVien(new NhanVien("NV1", "Hoàng Đăng Khôi", new Date(1999, 14, 4), new Date(2019, 12, 6)));
        b.themNhanVien(new NhanVien("NV2", "An Quang Ngọc", new Date(1999, 7, 11), new Date(2018, 2, 6)));
        b.themNhanVien(new NhanVien("NV3", "Đinh Thế Vinh", new Date(1999, 6, 10), new Date(2019, 5, 2)));
        a.themNhanVien(new NhanVien("NV4", "Đào Anh Thắng", new Date(1999, 20, 11), new Date(2017, 19, 10)));
        c.themNhanVien(new NhanVien("NV5", "Tô Văn Quyền", new Date(1999, 13, 2), new Date(2015, 12, 9)));
        
        
        arpb.add(a);
        arpb.add(b);
        arpb.add(c);
        
        for(PhongBan d:arpb){
            cbophongban.addItem(d);
        }
    }
    public void showWindow(){
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
