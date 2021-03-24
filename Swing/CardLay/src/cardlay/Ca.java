package cardlay;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ca extends JFrame{
    public void showWindows(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public Ca(){
        this.setTitle("Test giao dien");
        AddControls();
    }
    public void AddControls(){
        Container con=getContentPane();
        JPanel jp=new JPanel();
        
    }
}
