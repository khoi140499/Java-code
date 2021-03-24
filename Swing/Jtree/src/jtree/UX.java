package jtree;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class UX extends JFrame{
    DefaultMutableTreeNode root=null;
    JTree tree;
    public UX(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();  
    }
    private void addControl() {
        Container con=getContentPane();
        JPanel pntree=new JPanel();
        pntree.setLayout(new BorderLayout());
        root=new DefaultMutableTreeNode("Topica Edumaul");
        tree=new JTree(root);
        DefaultMutableTreeNode vv=new DefaultMutableTreeNode("Helo");
        root.add(vv);
        DefaultMutableTreeNode v1=new DefaultMutableTreeNode("Ha");
        vv.add(v1);
        JScrollPane sc=new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pntree.add(sc, BorderLayout.CENTER);
        con.setLayout(new BorderLayout());
        con.add(pntree, BorderLayout.WEST);
        pntree.setPreferredSize(new Dimension(300,0));
        
        JPanel pnright=new JPanel();
        JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pntree, pnright);
        con.add(sp, BorderLayout.CENTER);
    }
    private void addEvent() {
        tree.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object obj=tree.getLastSelectedPathComponent();
                DefaultMutableTreeNode not=(DefaultMutableTreeNode) obj;
                JOptionPane.showMessageDialog(null, not.getUserObject()+"");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
