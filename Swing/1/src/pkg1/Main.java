package pkg1;
import javax.swing.*;
import java.awt.*;
public class Main extends JFrame{
    public static void main(String[] args) {
        Main v=new Main();
        v.setSize(500, 400);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
    public Main(){
        super("Hoc tao cua so");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container com=getContentPane();
        JPanel pc=new JPanel();
        pc.setBackground(Color.red);
        Button bt=new Button("Đây là nút lệnh");
        pc.add(bt);
        com.add(pc);
    }
}
