package bordertittle;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class tittle extends JFrame{
    JTextField txtten;
    JTextArea txtdiachi;
    Button btn;
    JCheckBox chkDiBoi, chkDiXemPhim;
    JRadioButton radNam, radNu;
    ButtonGroup groupGioiTinh;
    public tittle(){
        this.setTitle("Test giao dien");
        addControl();
        addEvent();
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void addControl(){
        Container con=getContentPane();
        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        con.add(pnMain);
        
        JPanel pnThongTin=new JPanel();
        pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
        JPanel pnTen=new JPanel();
        pnTen.setLayout(new FlowLayout());
        JLabel lblTen=new JLabel("Nhap ten");
        txtten=new JTextField(20);
        pnMain.add(pnThongTin);
        
        pnTen.add(lblTen);
        pnTen.add(txtten);
        pnThongTin.add(pnTen);
        
        JPanel pnDiaChi=new JPanel();
        pnDiaChi.setLayout(new FlowLayout());
        JLabel lbldiachi=new JLabel("Nhap dia chi");
        txtdiachi=new JTextArea(5, 19);
        JScrollPane sc=new JScrollPane(txtdiachi,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        txtdiachi.setWrapStyleWord(true);//xuong dong
        txtdiachi.setLineWrap(true);
        pnDiaChi.add(lbldiachi);
        pnDiaChi.add(sc);
        pnMain.add(pnDiaChi);
        pnThongTin.add(pnDiaChi);
        
        Border boderthongtin=BorderFactory.createLineBorder(Color.red);
        TitledBorder bodertittleThongTin=new TitledBorder(boderthongtin, "Thong tin");
        pnThongTin.setBorder(bodertittleThongTin);
        bodertittleThongTin.setTitleColor(Color.blue);
        bodertittleThongTin.setTitleJustification(TitledBorder.CENTER);
        
        JPanel pnSoThich=new JPanel();
        pnSoThich.setLayout(new BoxLayout(pnSoThich, BoxLayout.X_AXIS));
        JPanel pnst=new JPanel();
        pnst.setLayout(new BoxLayout(pnst, BoxLayout.Y_AXIS));
        chkDiBoi=new JCheckBox("Di Boi");
        chkDiXemPhim=new JCheckBox("Di Xem Phim");
        pnst.add(chkDiBoi);
        pnst.add(chkDiXemPhim);
        pnSoThich.add(pnst);
        Border st1=BorderFactory.createLineBorder(Color.red);
        TitledBorder tp1=new TitledBorder(st1, "so thich");
        tp1.setTitleColor(Color.cyan);
        pnst.setBorder(tp1);
        
        JPanel pngt=new JPanel();
        pngt.setLayout(new BoxLayout(pngt, BoxLayout.Y_AXIS));
        radNam=new JRadioButton("Nam");
        radNu=new JRadioButton("Nu");
        groupGioiTinh=new ButtonGroup();
        groupGioiTinh.add(radNu);
        groupGioiTinh.add(radNam);
        pngt.add(radNam);
        pngt.add(radNu);
        pnSoThich.add(pngt);
        pnMain.add(pnSoThich);
        Border st=BorderFactory.createLineBorder(Color.red);
        TitledBorder tp=new TitledBorder(st, "gioi tinh");
        tp.setTitleColor(Color.cyan);
        pngt.setBorder(tp);
        
        
        JPanel pnOk=new JPanel();
        pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btn=new Button("Ok");
        pnOk.add(btn);
        pnMain.add(pnOk);
        
        lbldiachi.setPreferredSize(lbldiachi.getPreferredSize());
    }

    public void addEvent() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuli();
            }

            protected void xuli() {
                String k=txtten.getText()+"\n";
                k+=txtdiachi.getText()+"\n";
                String s="";
                if(chkDiBoi.isSelected()){
                    s+=chkDiBoi.getText()+"\n";
                }
                if(chkDiXemPhim.isSelected()){
                    s+=chkDiXemPhim.getText()+"\n";
                }
                k+=s;
                String l="";
                if(radNam.isSelected()){
                    l+=radNam.getText()+"\n";
                }
                if(radNu.isSelected()){
                    l+=radNu.getText()+"\n";
                }
                k+=l;
                JOptionPane.showMessageDialog(null, k);
            }
        });
    }
}
