package Week_17;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;



/**
 * Write a description of class IDCardWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IDCardWindow extends JFrame 
{
    public IDCardWindow(Student student ){
        setSize(450,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ID Card");
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel label=new JLabel(student.info());
        label.setBounds(150,100,300,100);
        label.setFont(new Font("Times New Roman",Font.BOLD,12));
        add(label);
        
        setResizable(false);
        setVisible(true);
    }
}