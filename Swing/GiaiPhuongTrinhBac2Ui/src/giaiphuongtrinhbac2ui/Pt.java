package giaiphuongtrinhbac2ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pt extends JFrame{
    JLabel hesoa,hesob,hesoc,delta,kqx1, kqx2;
    JTextField txthesoa, txthesob, txthesoc, txtdelta, txtkqx1, txtkqx2,kq;
    JButton giai,thoat, help;
    ActionListener action=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Xuli();
        }
        public void Xuli() {
                String xa=txthesoa.getText();
                String xb=txthesoa.getText();
                String xc=txthesoa.getText();
                float a=Float.parseFloat(xa);
                float b=Float.parseFloat(xb);
                float c=Float.parseFloat(xc);
                String kq="";
                main m=new main(a,b,c);
                kq=m.main();
                txtkqx1.setText(kq);
        }  
          };
    public void addEvent(){
       giai.addActionListener(action);
       thoat.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
       help.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "Liên hệ 0388618961");
           }
       });
    }
    public void addControl(){
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel jp=new JPanel();
        jp.setLayout(new FlowLayout());
        JLabel name1=new JLabel("Giải phương trình bậc 2");
        jp.add(name1);
        main.add(jp);
        name1.setForeground(Color.RED);
        Font f=new Font("arial", Font.BOLD, 20);
        name1.setFont(f);
        
        JPanel jp2=new JPanel();
        jp2.setLayout(new FlowLayout());
        hesoa=new JLabel("Nhập a ");
        txthesoa=new JTextField(10);
        jp2.add(hesoa);
        jp2.add(txthesoa);
        main.add(jp2);
        
        JPanel jp3=new JPanel();
        jp3.setLayout(new FlowLayout());
        hesob=new JLabel("Nhập b ");
        txthesob=new JTextField(10);
        jp3.add(hesob);
        jp3.add(txthesob);
        main.add(jp3);
        
        JPanel jp4=new JPanel();
        jp4.setLayout(new FlowLayout());
        hesoc=new JLabel("Nhập c ");
        txthesoc=new JTextField(10);
        jp4.add(hesoc);
        jp4.add(txthesoc);
        main.add(jp4);
        
        JPanel jp6=new JPanel();
        jp6.setLayout(new FlowLayout());
        giai=new JButton("Giải");
        thoat=new JButton("Thoát");
        help=new JButton("Trợ giúp");
        jp6.add(giai);
        jp6.add(thoat);
        jp6.add(help);
        main.add(jp6);

        JPanel x1=new JPanel();
        x1.setLayout(new FlowLayout());
        kqx1=new JLabel("Kết quả");
        txtkqx1=new JTextField(15);
        x1.add(kqx1);
        x1.add(txtkqx1);
        main.add(x1);
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
        public Pt(){
        this.setTitle("Test Giao Dien");
        addControl();
        addEvent();
    }
    }
