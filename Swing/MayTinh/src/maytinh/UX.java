/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maytinh;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Dang Khoi
 */
public class UX extends JFrame{
    JButton m,h,b,bon,n,s,bay,t,c,o,cong, tru,nhan, chia,can, ac, bang,C;
    JTextArea tanhap;
    public UX(){
        super("test");
        addControl();
        addEvent();
        
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel text=new JPanel();
        text.setLayout(new FlowLayout());
        tanhap=new JTextArea(5,50);
        tanhap.setWrapStyleWord(true);
        tanhap.setLineWrap(true);
        text.add(tanhap);
        main.add(text);
        
        JPanel so=new JPanel();
        so.setLayout(new GridLayout(4, 4));
        
        m=new JButton("1");
        h=new JButton("2");
        b=new JButton("3");
        bon=new JButton("4");
        n=new JButton("5");
        s=new JButton("6");
        bay=new JButton("7");
        t=new JButton("8");
        c=new JButton("9");
        o=new JButton("0");
        cong=new JButton("+");
        tru=new JButton("-");
        nhan=new JButton("x");
        chia=new JButton("/");
        can=new JButton("can");
        bang=new JButton("=");
        
        
        
        so.add(m);
        so.add(h);
        so.add(b);
        so.add(tru);
        so.add(bon);
        so.add(n);
        so.add(s);
        so.add(cong);
        so.add(bay);
        so.add(t);
        so.add(c);
        so.add(nhan);
        so.add(o);
        so.add(chia);
        so.add(can);
        so.add(bang);
        main.add(so);
    }
    public void addEvent() {
        
    }
    public void showWindow(){
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
