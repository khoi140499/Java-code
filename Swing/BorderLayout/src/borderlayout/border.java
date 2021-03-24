package borderlayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
public class border extends JFrame{
   public border(){
        this.setTitle("Test tieu de");
        addControls();
    }
    public void addControls(){
        Container com=getContentPane();
        JPanel jp=new JPanel();
        jp.setLayout(new BorderLayout());
        JPanel jp1=new JPanel();
        jp1.setBackground(Color.ORANGE);
        jp.add(jp1, BorderLayout.NORTH);
        jp.setPreferredSize(new Dimension(200, HEIGHT));
        JPanel jp2=new JPanel();
        jp2.setBackground(Color.BLACK);
        jp.add(jp2, BorderLayout.EAST);
        JPanel jp3=new JPanel();
        jp3.setBackground(Color.YELLOW);
        jp.add(jp3, BorderLayout.SOUTH);
        JPanel jp4=new JPanel();
        jp1.setBackground(Color.CYAN);
        jp.add(jp4, BorderLayout.CENTER);
        com.add(jp);
    }
    public void showWindows(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
