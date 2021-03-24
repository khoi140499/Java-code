package testgiaodienux;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class UI extends JFrame{
    JTextField txtten, txtmasv, txtkhoa, txtlop;
    JTextArea txtdiachi;
    Button bok, bthoat, bxoa;
    JCheckBox boi, bongda, caulong, bongchuyen;
    JRadioButton nam, nu, khac;
    ButtonGroup bg;
    public UI(){
        this.setTitle("Test giao dien");
        addControl();
        addEvent();
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel main2=new JPanel();
        main2.setLayout(new BoxLayout(main2, BoxLayout.Y_AXIS));
        main.add(main2);
        
        JPanel pnten=new JPanel();
        pnten.setLayout(new FlowLayout());
        JLabel ten=new JLabel("Nhập tên");
        txtten=new JTextField(20);
        pnten.add(ten);
        pnten.add(txtten);
        main2.add(pnten);
        
        JPanel pnmasv=new JPanel();
        pnmasv.setLayout(new FlowLayout());
        JLabel masv=new JLabel("Nhập msv");
        txtmasv=new JTextField(20);
        pnmasv.add(masv);
        pnmasv.add(txtmasv);
        main2.add(pnmasv);
        
        JPanel pnlop=new JPanel();
        pnlop.setLayout(new FlowLayout());
        JLabel lop=new JLabel("Nhập lớp");
        txtlop=new JTextField(20);
        pnlop.add(lop);
        pnlop.add(txtlop);
        main2.add(pnlop);
        
        JPanel pnkhoa=new JPanel();
        pnkhoa.setLayout(new FlowLayout());
        JLabel khoa=new JLabel("Nhập khóa");
        txtkhoa=new JTextField(20);
        pnkhoa.add(khoa);
        pnkhoa.add(txtkhoa);
        main2.add(pnkhoa);
        
        JPanel pndiachi=new JPanel();
        pndiachi.setLayout(new FlowLayout());
        JLabel diachi=new JLabel("Nhập địa chỉ");
        txtdiachi=new JTextArea(5, 20);
        JScrollPane sc=new JScrollPane(txtdiachi,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        txtdiachi.setWrapStyleWord(true);
        txtdiachi.setLineWrap(true);
        pndiachi.add(diachi);
        pndiachi.add(sc);
        main2.add(pndiachi);
        
        Border bor1=BorderFactory.createLineBorder(Color.red);
        TitledBorder order=new TitledBorder(bor1, "Thông tin sinh viên");
        order.setTitleColor(Color.BLUE);
        main2.setBorder(order);
        
        JPanel main3=new JPanel();
        main3.setLayout(new BoxLayout(main3, BoxLayout.X_AXIS));
        main.add(main3);
        
        JPanel pnsothich=new JPanel();
        pnsothich.setLayout(new BoxLayout(pnsothich, BoxLayout.Y_AXIS));
        boi=new JCheckBox("Bơi");
        bongda=new JCheckBox("Bóng đá");
        caulong=new JCheckBox("Cầu lông");
        bongchuyen=new JCheckBox("Bóng chuyền");
        pnsothich.add(boi);
        pnsothich.add(caulong);
        pnsothich.add(bongda);
        pnsothich.add(bongchuyen);
        main3.add(pnsothich);
        
        
        JPanel pngioitinh=new JPanel();
        pngioitinh.setLayout(new BoxLayout(pngioitinh, BoxLayout.Y_AXIS));
        nam=new JRadioButton("Nam");
        nu=new JRadioButton("Nữ");
        khac=new JRadioButton("Khác");
        bg=new ButtonGroup();
        bg.add(nam);
        bg.add(nu);
        bg.add(khac);
        pngioitinh.add(nam);
        pngioitinh.add(nu);
        pngioitinh.add(khac);
        main3.add(pngioitinh);
        
        Border bor2=BorderFactory.createLineBorder(Color.red);
        TitledBorder order2=new TitledBorder(bor2, "Thông tin khác");
        order2.setTitleColor(Color.BLUE);
        main3.setBorder(bor2);
        
        JPanel main4=new JPanel();
        main4.setLayout(new BoxLayout(main4, BoxLayout.X_AXIS));
        main.add(main4);
        
        JPanel ok=new JPanel();
        ok.setLayout(new FlowLayout());
        bok=new Button("Ok");
        bok.setForeground(Color.BLUE);
        ok.add(bok);
        main4.add(ok);
        
        JPanel xoa=new JPanel();
        xoa.setLayout(new FlowLayout());
        bxoa=new Button("Xóa");
        bxoa.setForeground(Color.PINK);
        xoa.add(bxoa);
        main4.add(xoa);
        
        JPanel thoat=new JPanel();
        thoat.setLayout(new FlowLayout());
        bthoat=new Button("Thoát");
        bthoat.setForeground(Color.RED);
        thoat.add(bthoat);
        main4.add(thoat);
    }
    public void addEvent() {
        bthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtten.setText("");
                txtmasv.setText("");
                txtlop.setText("");
                txtkhoa.setText("");
                txtdiachi.setText("");
                caulong.setSelected(false);
                bongda.setSelected(false);
                bongchuyen.setSelected(false);
                boi.setSelected(false);
                nam.setSelected(false);
                nu.setSelected(false);
                khac.setSelected(false);
                
            }
        });
        bok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=txtten.getText()+"\n";
                s+=txtmasv.getText()+"\n";
                s+=txtlop.getText()+"\n";
                s+=txtkhoa.getText()+"\n";
                String k="";
                if(boi.isSelected()){
                    k+=boi.getText()+"\n";
                }
                if(bongda.isSelected()){
                    k+=bongda.getText()+"\n";
                }
                if(bongchuyen.isSelected()){
                    k+=bongchuyen.getText()+"\n";
                }
                if(caulong.isSelected()){
                    k+=caulong.getText()+"\n";
                }
                s+=k;
                String l="";
                if(nam.isSelected()){
                    l+=nam.getText()+"\n";
                }
                if(nu.isSelected()){
                    l+=nu.getText()+"\n";
                }
                if(khac.isSelected()){
                    l+=khac.getText()+"\n";
                }
                s+=l;
                JOptionPane.showMessageDialog(null, s);
            }
        });
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
