package songuyento;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class main extends JFrame{
    JTextField txtnhap;
    JButton btnnhap, btnxoa, btnthoat;
    JTextArea tanhap;
    ArrayList ist=new ArrayList();
    public main(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel pnnhap=new JPanel();
        pnnhap.setLayout(new FlowLayout());
        JLabel nhap=new JLabel("Nhập số");
        txtnhap=new JTextField(15);
        pnnhap.add(nhap);
        pnnhap.add(txtnhap);
        main.add(pnnhap);
        
        JPanel pnnhan=new JPanel();
        pnnhan.setLayout(new FlowLayout());
        btnnhap=new JButton("Ok");
        btnxoa=new JButton("Xóa");
        btnthoat=new JButton("Thoát");
        pnnhan.add(btnnhap);
        pnnhan.add(btnxoa);
        pnnhan.add(btnthoat);
        main.add(pnnhan);
        
        JPanel pnxuat=new JPanel();
        pnxuat.setLayout(new FlowLayout());
        JLabel kq=new JLabel("Kết Quả");
        tanhap=new JTextArea(8, 15);
        JScrollPane jp=new JScrollPane(tanhap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tanhap.setWrapStyleWord(true);
        tanhap.setLineWrap(true);
        pnxuat.add(kq);
        pnxuat.add(jp);
        main.add(pnxuat);
        
        Border br=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr=new TitledBorder(br, "Số nguyên tố");
        tbr.setTitleColor(Color.BLUE);
        tbr.setTitlePosition(TitledBorder.CENTER);
        main.setBorder(tbr);
    }
    public void addEvent() {
        btnnhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snt();
            }
            private void snt() {
                String s=txtnhap.getText();
                int n=Integer.parseInt(s);
                for(int i=0;i<n;i++){
                    if(snn(i)){
                        ist.add(i);
                        tanhap.setText(""+ist);
                        
                    }
                }
            }
            public boolean snn(int n){
                if(n<2) return false;
                else if(n>2){
                    if(n%2==0) return false;
                    for(int i=3;i<=Math.sqrt((float)n);i+=2){
                        if(n%i==0) return false;
                    }
                }
                return true;
            }
        });
        btnthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtnhap.setText("");
                tanhap.setText("");
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
