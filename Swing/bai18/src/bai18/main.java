package bai18;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame{
    public main(){
        this.setTitle("Test giao dien");
        addControl();
        addEvent();
    }

    public void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel();
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
