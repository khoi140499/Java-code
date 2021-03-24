package boxmodel;
import javax.swing.*;
import java.awt.*;
public class BoxModel extends JFrame{
    public static void main(String[] args){
        BoxModel n=new BoxModel();
        n.setSize(500, 400);
        n.setLocationRelativeTo(null);
        n.setVisible(true);
    }
    public BoxModel(){
        super("Test giao dien");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add();
    }
    public void add(){
        Container con=getContentPane();
        JPanel jp=new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
        Button a=new Button("New");
        Button b=new Button("New");
        jp.add(a);jp.add(b);
        con.add(jp);
    }
}
