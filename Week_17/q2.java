package Week_17;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * Write a description of class q2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q2 extends JFrame
{
    public q2(){
    setTitle("Announcement");
    setSize(800,300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    JLabel label=new JLabel();
    label.setText("Welcome to Orientation Day");
    label.setBounds(30,30,500,40);
    label.setFont(new Font("Arial",Font.BOLD,31));
    add(label);
    
    Container c=getContentPane();
    c.setBackground(new Color(177,200,230));
    
    JTextArea text=new JTextArea(5,30);
    text.setLineWrap(true);
    
    add(text);
    setResizable(false);
    setVisible(true);
    }
    public static void main(String[] args)
    {
        new q2();
    }
}