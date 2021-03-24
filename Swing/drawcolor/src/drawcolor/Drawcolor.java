package drawcolor;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
/**
 *
 * @author Dang Khoi
 */
public class Drawcolor extends JFrame{
    public Drawcolor()
            {
                super("Using color");
                setSize(400,300);
                setVisible(true);
            }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(new Color(255,0,0));
        g.fillRect(25, 25, 100, 20);
        g.drawString("Current RGB: "+g.getColor(),  130 , 40);
        
        g.setColor( new Color( 0.0f, 1.0f, 0.0f ) );
        g.fillRect( 25, 50, 100, 20 );
        g.drawString( "Current RGB: " + g.getColor(), 130, 65 );

        g.setColor( Color.BLUE );
        g.fillRect( 25, 75, 100, 20 );
        g.drawString( "Current RGB: " + g.getColor(), 130, 90 );

        Color color = Color.MAGENTA;
        g.setColor( color );
        g.fillRect( 25, 100, 100, 20 );
        g.drawString( "RGB values: " + color.getRed() + ", " +
        color.getGreen() + ", " + color.getBlue(), 130, 115 );
    }
     public void showWindow(){
         setSize(400, 200);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setVisible(true);
     }    
    public static void main(String[] args){
        Drawcolor vd=new Drawcolor();
        vd.showWindow();
    }
}
