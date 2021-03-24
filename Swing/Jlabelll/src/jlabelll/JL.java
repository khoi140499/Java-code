package jlabelll;

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

public class JL extends JFrame{
    JButton b1, b2, b3;
    JTextField txtHeso, txt, tx ;
    ActionListener ev=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            xuLiGiaiPhuongTrinh();
        }
        protected void xuLiGiaiPhuongTrinh() {
            String hsa=txtHeso.getText();
            String hsb=txt.getText();
            double a=Double.parseDouble(hsa);
            double b=Double.parseDouble(hsb);
            if(a==0 && b==0){
                tx.setText("Vô số nghiệm");
            }
            else if(a==0){
                tx.setText("Vô nghiệm");
            }
            else{
                double c=-b/a;
                 tx.setText(" "+c);
            }
        }
    };
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    public void addEvent(){
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        b1.addActionListener(ev);
        b3.addActionListener(new Help());
    }
    public void addControl(){
        Container con=getContentPane();
        JPanel jp=new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        con.add(jp);
        
        JPanel tt=new JPanel();
        tt.setLayout(new FlowLayout());
        JLabel tt1=new JLabel("Giải phương trình bậc 1");
        tt.add(tt1);
        jp.add(tt);
        tt1.setForeground(Color.red);
        Font f=new Font("arial", Font.BOLD, 20);
        tt1.setFont(f);
                
        JPanel tt2=new JPanel();
        tt2.setLayout(new FlowLayout());
        JLabel heso=new JLabel("Hệ số a: ");
        txtHeso=new JTextField(15);
        tt2.add(heso);
        tt2.add(txtHeso);
        jp.add(tt2);
        
        JPanel tt3=new JPanel();
        tt2.setLayout(new FlowLayout());
        JLabel heso2=new JLabel("Hệ số b: ");
        txt=new JTextField(15);
        tt3.add(heso2);
        tt3.add(txt);
        jp.add(tt3);
        
        JPanel tt4=new JPanel();
        tt4.setLayout(new FlowLayout());
        b1=new JButton("Giải");
        b2=new JButton("Thoát");
        b3=new JButton("Help");
        tt4.add(b1);
        tt4.add(b2);
        tt4.add(b3);
        jp.add(tt4);
        
        JPanel tt5=new JPanel();
        tt5.setLayout(new FlowLayout());
        JLabel heso4=new JLabel("Kết quả: ");
        tx=new JTextField(15);
        tt5.add(heso4);
        tt5.add(tx);
        jp.add(tt5);
    }
    class Help implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Chi tiết xin liên hệ : 0388618961");   
        }
    }
    public JL(){
      this.setTitle("Test giao dien");
       addControl();
       addEvent();
    }
}
