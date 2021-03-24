package jtable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UI extends JFrame{
    DefaultTableModel dm;
    JButton btnthem, btnxoa;
    JTable tb;
    public UI(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel main=new JPanel(new BorderLayout());
        JPanel pntrai=new JPanel();
        pntrai.setPreferredSize(new Dimension(400, 0));
        JPanel pnphai=new JPanel();
        JSplitPane js1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pntrai, pnphai);
        dm=new DefaultTableModel();
        dm.addColumn("Ma");
        dm.addColumn("Ten");
        dm.addColumn("Tuoi");
        
        tb=new JTable(dm);
        dm.addRow(new String[]{"NV1","Hoang Dang Khoi","20"});
        dm.addRow(new String[]{"Nv2","An Quang Ngoc", "20"});
        dm.addRow(new String[]{"Nv3", "Dinh The Vinh", "20"});
        JScrollPane js=new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        pntrai.setLayout(new BorderLayout());
        pntrai.add(js, BorderLayout.CENTER);
        
        main.add(js1);
        con.add(main);
        
        JPanel pnbutton=new JPanel();
        pnbutton.setLayout(new FlowLayout());
        btnthem=new JButton("Them");
        btnxoa=new JButton("Xoa");
        
        pnbutton.add(btnthem);
        pnbutton.add(btnxoa);
        pntrai.add(pnbutton, BorderLayout.SOUTH);
    }
    public void addEvent() {
        btnthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String>vec=new Vector<>();
                vec.add("MMA");
                vec.add("LLM");
                dm.addRow(vec);
            }
        });
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tb.getSelectedRow();
                dm.removeRow(row);
            }
        });
        tb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=tb.getSelectedRow();
                if(row ==-1) return;
                String ma2=tb.getValueAt(row, 0)+"";
                String ten2=tb.getValueAt(row, 1)+"";
                String tuoi2=tb.getValueAt(row, 2)+"";
                JOptionPane.showMessageDialog(null, "ma:" +ma2+"\nten: "+ten2+"\ntuoi: "+tuoi2);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
    public void showWindow(){
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
