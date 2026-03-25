package Week_17;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Font;

/**
 * Write a description of class Q3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q3 extends JFrame
{
    public q3()
    {
        setTitle("Info");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        JLabel name=new JLabel();
        name.setText("Name:Aayush Joshi");
        name.setBounds(30,30,600,45);
        name.setFont(new Font("Arial",Font.BOLD,40));
        add(name);
       
        JLabel module=new JLabel();
        module.setText("Module:Programming");
        module.setBounds(30,90,600,45);
        module.setFont(new Font("Arial",Font.BOLD,40));
        add(module);
       
        JLabel college=new JLabel();
        college.setText("College:Islington");
        college.setBounds(30,120,600,45);
        college.setFont(new Font("Arial",Font.BOLD,40));
        add(college);
       
        setVisible(true);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new q3();
            }
        });
    }
}
