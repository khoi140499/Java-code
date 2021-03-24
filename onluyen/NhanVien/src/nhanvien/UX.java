package nhanvien;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
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
    JList<NV>listnhanvien;
    JTextArea taxuat;
    JTextField txtma, txtten, txtngayvao, txtnamsinh;
    JButton btnluu, btnxoa, btnthoat;
    ArrayList<PhongBan>dsphongban;
    ArrayList<NV>dsnhanvien;
    PhongBan pbselected=null;
    NV nvselectedd=null;
    DateFormat sdf=new SimpleDateFormat("dd/MM/yy");
    public UX(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
        data();
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel pnchon=new JPanel();
        pnchon.setLayout(new FlowLayout());
        JLabel nhan=new JLabel("Chọn phòng ban");
        cbophongban=new JComboBox<PhongBan>();
        cbophongban.setPreferredSize(new Dimension(200, 20));
        pnchon.add(nhan);
        pnchon.add(cbophongban);
        main.add(pnchon);
        
        JPanel pnthan=new JPanel();
        pnthan.setLayout(new GridLayout(1, 2));
        main.add(pnthan);
        
        JPanel pntrai=new JPanel();
        pntrai.setLayout(new FlowLayout());
        listnhanvien=new JList<NV>();
        JScrollPane js=new JScrollPane(listnhanvien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listnhanvien.setPreferredSize(new Dimension(200, 500));
        pntrai.add(js);
        pnthan.add(pntrai);
        
        Border br2=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr2=new TitledBorder(br2, "Danh sách nhân viên");
        tbr2.setTitleJustification(TitledBorder.CENTER);
        tbr2.setTitleColor(Color.BLUE);
        pntrai.setBorder(tbr2);
        
        JPanel pnphai=new JPanel();
        pnphai.setLayout(new BoxLayout(pnphai, BoxLayout.Y_AXIS));
        pnthan.add(pnphai);
        
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
        JLabel ngayvaolam=new JLabel("Ngày vào làm");
        txtngayvao=new JTextField(15);
        pnngay.add(ngayvaolam);
        pnngay.add(txtngayvao);
        
        JPanel pnnamsinh=new JPanel();
        pnnamsinh.setLayout(new FlowLayout());
        JLabel ngaysinh=new JLabel("Ngày Sinh");
        txtnamsinh=new JTextField(15);
        pnnamsinh.add(ngaysinh);
        pnnamsinh.add(txtnamsinh);
        pnphai.add(pnma);
        pnphai.add(pnten);
        pnphai.add(pnngay);
        pnphai.add(pnnamsinh);
        ma.setPreferredSize(ngayvaolam.getPreferredSize());
        ten.setPreferredSize(ngayvaolam.getPreferredSize());
        ngaysinh.setPreferredSize(ngayvaolam.getPreferredSize());
        
        Border br3=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr3=new TitledBorder(br3, "Thông tin chi tiết");
        tbr3.setTitleJustification(TitledBorder.CENTER);
        tbr3.setTitleColor(Color.BLUE);
        pnphai.setBorder(tbr3);
        
        JPanel main2=new JPanel();
        main2.setLayout(new FlowLayout());
        btnluu=new JButton("Lưu");
        btnxoa=new JButton("Xóa");
        btnthoat=new JButton("Thoát");
        main2.add(btnluu);
        main2.add(btnxoa);
        main2.add(btnthoat);
        main.add(main2);
        
        Border br=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr=new TitledBorder(br, "Chọn chức năng");
        tbr.setTitleJustification(TitledBorder.CENTER);
        tbr.setTitleColor(Color.BLUE);
        main2.setBorder(tbr);
    }
    public void addEvent() {
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
                pbselected=(PhongBan) cbophongban.getSelectedItem();
                listnhanvien.setListData(pbselected.getNhanVien());
            }
        });
        listnhanvien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(listnhanvien.getSelectedIndex()==-1) return;
                nvselectedd=listnhanvien.getSelectedValue();
                txtma.setText(nvselectedd.getMaNV());
                txtten.setText(nvselectedd.getTenNV());
                txtngayvao.setText(sdf.format(nvselectedd.getNgayVaoLamViec()));
                txtnamsinh.setText(sdf.format(nvselectedd.getNamSinh()));
            }
            @Override
            public void mousePressed(MouseEvent e){
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
                luu();
            }
            private void luu() {
                try{
                    NV nv=new NV(txtma.getText(), txtten.getText(), sdf.parse(txtngayvao.getText()), sdf.parse(txtnamsinh.getText()));
                    if(pbselected!=null){
                        pbselected.themNhanVien(nv);
                        listnhanvien.setListData(pbselected.getNhanVien());
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nvselectedd!=null){
                pbselected.getNhanVien().remove(nvselectedd);
                nvselectedd=null;
                listnhanvien.setListData(pbselected.getNhanVien());
            }
            }
        });
    }
    
    public void showWindow(){
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void data() {
        dsphongban=new ArrayList<>();
        
        PhongBan a=new PhongBan();
        a.setMaPhong("MP1");
        a.setTenPhong("Phòng Giáo Vụ");
        
        PhongBan b=new PhongBan();
        b.setMaPhong("MP2");
        b.setTenPhong("Phòng Công Tác Sinh Viên");
        
        PhongBan c=new PhongBan();
        c.setMaPhong("MP3");
        c.setTenPhong("Phòng Quản Lý");
        
        dsphongban.add(a);
        dsphongban.add(b);
        dsphongban.add(c);
        
        a.themNhanVien(new NV("NV1", "Hoàng Đăng Khôi", new Date(2019, 14, 3), new Date(1999, 14, 04)));
        b.themNhanVien(new NV("NV2", "An Quang Ngọc", new Date(2019, 13, 11), new Date(1999, 07, 11)));
        b.themNhanVien(new NV("NV3", "Đinh Thế Vinh", new Date(2019, 11, 2), new Date(1999, 27, 06)));
        b.themNhanVien(new NV("NV4", "Đào Anh Thắng", new Date(2019, 17, 9), new Date(1999, 20, 11)));
        a.themNhanVien(new NV("NV5", "Tô Văn Quyền", new Date(2019, 22, 7), new Date(1999, 3, 04)));
        a.themNhanVien(new NV("NV6", "Đào Huy Hoàng", new Date(2019, 04, 4), new Date(1999, 11, 06)));
        
        for(PhongBan d:dsphongban){
            cbophongban.addItem(d);
        }
    }
}
