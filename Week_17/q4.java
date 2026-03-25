package Week_17;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class q4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q4 extends JFrame
{
    public q4(){
        setTitle("library Notice Window");
        setSize(900,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);      
        setLayout(null);
       
        getContentPane().setBackground(new Color(11,23,90));
        setResizable(false);
        String info = "<html>"+
        "<div style = 'text-align : center;'>"+
        "name : Aayush Joshi<br>"+
        "class : Programming<br>"+
        "College : Islington<br>"+
        "</div>"+
        "</html>";
       
       
        JLabel label1 = new JLabel(info);
       
        label1.setBounds(250,100,300,80);
        label1.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(label1);
        setVisible(true);
    }
    public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            new q4();
        }});
    }
}
