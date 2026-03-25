package Week_17;
import javax.swing.JFrame;
import java.awt.Frame;
import javax.swing.JLabel;


/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI extends JFrame
{
    public GUI(){
    setTitle("Library Notice");
    setSize(400,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    
    JLabel label=new JLabel();
    label.setText("Library opens at 7:00am");
    add(label);
    
    
    setVisible(true);
}
public static void main(String[] args)
{
    new GUI();
}   
}