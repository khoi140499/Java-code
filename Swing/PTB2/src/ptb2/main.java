package ptb2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class main extends JFrame{
    JTextField txta, txtb, txtc, txtkq;
    JButton btnok, btnxoa, btnthoat;
    public main(){
        this.setTitle("Giao dien");
        addCOntrol();
        addEvent();
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void addCOntrol() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel a=new JPanel();
        a.setLayout(new FlowLayout());
        JLabel aa=new JLabel("Nhap a");
        txta=new JTextField(20);
        a.add(aa);
        a.add(txta);
        main.add(a);
        
        JPanel b=new JPanel();
        b.setLayout(new FlowLayout());
        JLabel bb=new JLabel("Nhap b");
        txtb=new JTextField(20);
        b.add(bb);
        b.add(txtb);
        main.add(b);
        
        JPanel c=new JPanel();
        c.setLayout(new FlowLayout());
        JLabel cc=new JLabel("Nhap c");
        txtc=new JTextField(20);
        c.add(cc);
        c.add(txtc);
        main.add(c);
        
        JPanel bt=new JPanel();
        bt.setLayout(new FlowLayout());
        btnok=new JButton("Ok");
        btnxoa=new JButton("Xoa");
        btnthoat=new JButton("thoat");
        bt.add(btnok);
        bt.add(btnxoa);
        bt.add(btnthoat);
        main.add(bt);
        
        JPanel pnkq=new JPanel();
        pnkq.setLayout(new FlowLayout());
        JLabel kq=new JLabel("Ket qua");
        txtkq=new JTextField(20);
        pnkq.add(kq);
        pnkq.add(txtkq);
        main.add(pnkq);
        
        Border br=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr=new TitledBorder(br, "Giai phuong trinh bac 2");
        tbr.setTitleColor(Color.BLUE);
        main.setBorder(tbr);
        
    }
    private void addEvent() {
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txta.setText("");
                txtb.setText("");
                txtc.setText("");
                txtkq.setText("");
            }
        });
        btnthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pt();
            }

            private void pt() {
                String s1=txta.getText();
                String s2=txtb.getText();
                String s3=txtc.getText();
                int a=Integer.parseInt(s1);
                int b=Integer.parseInt(s2);
                int c=Integer.parseInt(s3);
                if(a==0){
                    if(b==0){
                        txtkq.setText("Vo nghiem");
                    }
                    else if(b==0){
                        if(c==0){
                            txtkq.setText("Vo so nghiem");
                        }
                        else{
                            txtkq.setText("Vo nghiem");
                        }
                    }
                    else{
                        txtkq.setText(""+(double)-c/b);
                    }
                }
                else{
                    double delta=b*b-4*a*c;
                    if(delta>0){
                        double x1=(-b-Math.sqrt(delta))/(2*a);
                        double x2=(-b+Math.sqrt(delta))/(2*a);
                        txtkq.setText("x1= "+x1+"\n x2= "+x2);
                    }
                    else if(delta==0){
                        double x1=-b/(2*a);
                        txtkq.setText("x1=x2= "+x1);
                    }
                    else{
                        txtkq.setText("Vo nghiem");
                    }
                }
                
            }
        });
    }
    
}
