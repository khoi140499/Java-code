package flowlayout;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;

public class FlowLayout1 extends JFrame{
    public static void main(String[] args) {
        FlowLayout1 a=new FlowLayout1();
        a.setSize(500, 400);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }
    public FlowLayout1(){
        super("Test giao dien");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel jp=new JPanel();
        jp.setLayout(new FlowLayout());
        jp.setBackground(Color.pink);
        JButton a1=new JButton("New");
        JButton a2=new JButton("New");
        JButton a3=new JButton("New");
        JButton a4=new JButton("New");
        JButton a5=new JButton("New");
        JButton a6=new JButton("New");
        jp.add(a1);jp.add(a2    );
        jp.add(a3);jp.add(a4);
        jp.add(a5);jp.add(a6);
        Container com=getContentPane();
        com.add(jp);
    }
}
