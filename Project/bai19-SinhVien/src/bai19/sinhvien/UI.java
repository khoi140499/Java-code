package bai19.sinhvien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class UI extends JFrame{
    JComboBox<PhongBan>cbphongban;
    JList<NhanVien>lnhanvien;
    JTextField txtMa, txtTen, txtNgay, txtNam;
    JButton btnluu, btnthoat, btnxoa;
    ArrayList<PhongBan>dsPhongBan;
    ArrayList<NhanVien>dsNhanVien;
    PhongBan pbSelected=null;
    NhanVien vcSelected=null;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
    public UI(){
        this.setTitle("giao dien");
        addControl();
        addEvent();
        fakedata();
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel pnmain=new JPanel();
        pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));
        con.add(pnmain);
        JPanel pnPhongban=new JPanel();
        pnPhongban.setLayout(new FlowLayout());
        JLabel lblphongban=new JLabel("Chon phòng ban");
        cbphongban=new JComboBox<PhongBan>();
        pnmain.add(pnPhongban);
        cbphongban.setPreferredSize(new Dimension(200, 25));
        pnPhongban.add(lblphongban); 
        pnPhongban.add(cbphongban);
        
        JPanel pnds=new JPanel();
        pnds.setLayout(new GridLayout(1, 2));
        pnmain.add(pnds);
        JPanel pnDanhsach=new JPanel();
        pnDanhsach.setLayout(new BorderLayout());
                
        Border boderDanhSach=BorderFactory.createLineBorder(Color.blue);
        TitledBorder ttbo=new TitledBorder(boderDanhSach, "Danh Sách");
        ttbo.setTitleJustification(TitledBorder.CENTER);
        ttbo.setTitleColor(Color.red);
        pnDanhsach.setBorder(ttbo);
        
        lnhanvien=new JList<NhanVien>();
        JScrollPane sc=new JScrollPane(lnhanvien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnDanhsach.add(sc, BorderLayout.CENTER);
        pnds.add(pnDanhsach);
        
        JPanel pnChiTiet=new JPanel();
        pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
        pnds.add(pnChiTiet);
        
        JPanel pnma=new JPanel();
        pnma.setLayout(new FlowLayout());
        JLabel ma=new JLabel("Mã");
        txtMa=new JTextField(15);
        pnma.add(ma);
        pnma.add(txtMa);
        pnChiTiet.add(pnma);
        
        JPanel pnten=new JPanel();
        pnten.setLayout(new FlowLayout());
        JLabel ten=new JLabel("Tên");
        txtTen=new JTextField(15);
        pnten.add(ten);
        pnten.add(txtTen);
        pnChiTiet.add(pnten);
       
        JPanel pnngay=new JPanel();
        pnngay.setLayout(new FlowLayout());
        JLabel ngay=new JLabel("Ngày vào");
        txtNgay=new JTextField(15);
        pnngay.add(ngay);
        pnngay.add(txtNgay);
        pnChiTiet.add(pnngay);
        
        JPanel pnnamsinh=new JPanel();
        pnnamsinh.setLayout(new FlowLayout());
        JLabel namsinh=new JLabel("Năm sinh");
        txtNam=new JTextField(15);
        pnnamsinh.add(namsinh);
        pnnamsinh.add(txtNam);
        pnChiTiet.add(pnnamsinh);
        
        JPanel pnBt=new JPanel();
        pnBt.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnluu=new JButton("Lưu");
        btnthoat=new JButton("Thoát");
        btnxoa=new JButton("Xóa");
        pnBt.add(btnluu);
        pnBt.add(btnxoa);
        pnBt.add(btnthoat);
        pnmain.add(pnBt);
        
        Border boderDanhSach3=BorderFactory.createLineBorder(Color.blue);
        TitledBorder ttbo3=new TitledBorder(boderDanhSach, "Chọn chức năng");
        ttbo3.setTitleJustification(TitledBorder.CENTER);
        ttbo3.setTitleColor(Color.red);
        pnBt.setBorder(ttbo3);
        
        ma.setPreferredSize(namsinh.getPreferredSize());
        ngay.setPreferredSize(namsinh.getPreferredSize());
        ten.setPreferredSize(namsinh.getPreferredSize());
       
        Border boderDanhSach2=BorderFactory.createLineBorder(Color.blue);
        TitledBorder ttbo2=new TitledBorder(boderDanhSach, "Thông tin cho tiết");
        ttbo2.setTitleJustification(TitledBorder.CENTER);
        ttbo2.setTitleColor(Color.red);
        pnChiTiet.setBorder(ttbo2);
    }
    public void addEvent() {
        btnthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cbphongban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbphongban.getSelectedIndex()==-1) return ;
                pbSelected=(PhongBan) cbphongban.getSelectedItem();
                lnhanvien.setListData(pbSelected.getNhanVien());
            }
        });
        lnhanvien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(lnhanvien.getSelectedIndex()==-1) return ;
                vcSelected=lnhanvien.getSelectedValue();
                txtMa.setText(vcSelected.getMaNhanVien());
                txtTen.setText(vcSelected.getTenNhanVien());
                txtNam.setText(sdf.format(vcSelected.getNamSinh()));
                txtNgay.setText(sdf.format(vcSelected.getNgayvaolamviec()));
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
               luu();
            }
            private void luu() {
                try{
                    NhanVien nv=new NhanVien(txtMa.getText(), 
                            txtTen.getText(), 
                            sdf.parse(txtNgay.getText()),
                            sdf.parse(txtNam.getText()));
                    if(pbSelected!=null){
                        pbSelected.themNhanVien(nv);
                        lnhanvien.setListData(pbSelected.getNhanVien());
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoa();
            }   
            private void xoa() {
                if(vcSelected!=null){
                    pbSelected.getNhanVien().remove(vcSelected);
                    vcSelected=null;
                    lnhanvien.setListData(pbSelected.getNhanVien());
                }
            }
        });
    }
    public void fakedata(){
        dsPhongBan=new ArrayList<PhongBan>();
        
        PhongBan phtgv=new PhongBan();
        phtgv.setMaPhong("p1");
        phtgv.setTenPhong("Phòng hợp tác sinh viên");
        
        PhongBan pkd=new PhongBan();
        pkd.setMaPhong("p2");
        pkd.setTenPhong("Phòng kinh doanh");
        
        PhongBan pkt=new PhongBan();
        pkt.setMaPhong("p3");
        pkt.setTenPhong("Phòng kế toán");
        
        dsPhongBan.add(pkt);
        dsPhongBan.add(phtgv);
        dsPhongBan.add(pkd);
        
        phtgv.themNhanVien(new NhanVien("NV1", "Hoàng Đăng Khôi",
						new Date(2016, 1, 1), new Date(1990,1, 1)));
        phtgv.themNhanVien(new NhanVien("NV2", "An Quang Ngọc",
				new Date(2015, 1, 1), new Date(1992,1, 1)));
        pkd.themNhanVien(new NhanVien("NV3", "Đinh Thế Vinh",
				new Date(2013, 1, 1), new Date(1989,1, 1)));
        pkd.themNhanVien(new NhanVien("NV4", "Đào Anh Thắng",
				new Date(2014, 1, 1), new Date(1988,1, 1)));
        
        for(PhongBan a:dsPhongBan){
            cbphongban.addItem(a);
        }
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
