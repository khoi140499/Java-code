package jsplipanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class UI extends JFrame{
    public UI(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
    }
    public void addControl(){
        Container con=getContentPane();
        JPanel pnleft=new JPanel();
        pnleft.setPreferredSize(new Dimension(200, 0));
        JPanel pnright=new JPanel();
        pnright.setLayout(new BorderLayout());
        JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnleft, pnright);
        sp.setOneTouchExpandable(true);
        con.add(sp);
        JPanel pp=new JPanel();
        pp.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        JPanel pnright1=new JPanel();
        JPanel pnright2=new JPanel();
        JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnright1, pnright2);
        sp2.setOneTouchExpandable(true);
        pnright.add(sp2);
    }
    public void addEvent(){
        
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
