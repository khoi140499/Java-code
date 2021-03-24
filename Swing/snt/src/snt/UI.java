/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snt;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Dang Khoi
 */
public class UI extends JFrame{
    JTextField nhap;
    JButton kq;
    JTextArea xuat;
    ArrayList a=new ArrayList();
    public UI(){
        super("lon");
        add();
        event();
    }
    private void add() {
        Container con=getContentPane();
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel main2=new JPanel();
        main2.setLayout(new FlowLayout());
        JLabel nhapa=new JLabel("Nhap");
        nhap=new JTextField(15);
        main2.add(nhapa);
        main2.add(nhap);
        main.add(main2);
        
        JPanel main3=new JPanel();
        main3.setLayout(new FlowLayout());
        kq=new JButton("Ket qua");
        main3.add(kq);
        main.add(main3);
        
        JPanel main4=new JPanel();
        main4.setLayout(new FlowLayout());
        xuat=new JTextArea(10, 10);
        JScrollPane js=new JScrollPane(xuat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        xuat.setWrapStyleWord(true);
        xuat.setLineWrap(true);
        main4.add(js);
        main.add(main4);
    }
    private void event() {
        kq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 sntt();
            }

            public void sntt() {
                    String s=nhap.getText();
                    int n=Integer.parseInt(s);
                    for(int i=0;i<n;i++){
                        if(snn(i)){
                        a.add(i);
                        xuat.setText(""+a);
                        }
                    }
            }
            public boolean snn(int i) {
                    if(i<2) return false;
                    else if(i>2){
                        if(i%2==0) return false;
                        for(int j=3;j<Math.sqrt(i);j+=2){
                        if(i%j==0) return false;
                    }
                }
                    return true;
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
