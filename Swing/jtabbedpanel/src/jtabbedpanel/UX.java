package jtabbedpanel;

import java.awt.Color;
import java.awt.Container;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UX extends JFrame{
    JTabbedPane tab1;
    public UX(){
        super("Giao dien");
        addControl();
        addEvent();
    }
    public void addControl() {
        tab1=new JTabbedPane();
        Container con=getContentPane();
        con.add(tab1);
        
        JPanel pnt1=new JPanel();
        pnt1.setBackground(Color.red);
        pnt1.add(new JButton("Tabbed 1"));
        
        JPanel pnt2=new JPanel();
        pnt2.setBackground(Color.BLUE);
        pnt2.add(new JButton("Tabbed 2"));
        
        JPanel pnt3=new JPanel();
        pnt3.setBackground(Color.PINK);
        pnt3.add(new JButton("Tabbed 2"));
        
        tab1.add(pnt1, "Tab1");
        tab1.add(pnt2, "Tab2");
        tab1.add(pnt3, "Tab3");
    }
    public void addEvent() {
        
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
