package Week_17;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Font;
import java.awt.Container;
import java.awt.Color;

/**
 * Write a description of class q5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q5 extends JFrame
{
    public q5(){
    setTitle("Login");
    setSize(600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);
    
    JPanel panel=new JPanel();
    panel.setBackground(new Color(23,23,56));
    panel.setBounds(50,50,400,200);
    add(panel);
    panel.setLayout(null);
    
    
    JLabel label=new JLabel();
    label.setText("Username");
    label.setBounds(10,20,100,50);
    panel.add(label);
   
    JTextField text=new JTextField();
    text.setBounds(80,25,100,30);
    panel.add(text);
    
    JButton button=new JButton();
    button.setText("Submit");
    button.setBounds(10,70,80,40);
    
    panel.add(button);
    
    
    
    
    
    
    
    
    
    setVisible(true);
}
public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new q5();
            }
        });
    }
}