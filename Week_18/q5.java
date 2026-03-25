package Week_18;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class q5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q5 extends JFrame
{
    public q5()
    {
    setSize(900,600);
    setTitle("Student Record");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    String[] column={"Roll no","Name","Age"};
    Object[][] data={{1,"Ram",19},{2,"Shyam",21}};
    JTable table = new JTable(data, column);
    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane);
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