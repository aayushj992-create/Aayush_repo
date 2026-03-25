package Week_18;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class q3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q3 extends JFrame{
    public q3(){
        setTitle("State Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        setLayout(null);
        JLabel name=new JLabel("Name:");
        name.setBounds(20,20,80,30);
        JTextField nameText=new JTextField();
        nameText.setBounds(60,20,100,30);
        JButton submitButton=new JButton("Submit");
        submitButton.setBounds(20,60,80,30);
        
        submitButton.setEnabled(false);
        if(!nameText.getText().trim().isEmpty())
        {
            submitButton.setEnabled(true);
        }
        
        add(name);
        add(nameText);
        add(submitButton);
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
