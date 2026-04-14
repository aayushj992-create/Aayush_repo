package Week_18;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class q4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q4 extends JFrame
{
    JTable studentTable;
    int row;
    public q4(){
        setSize(900,600);
        setTitle("Student Record");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] column={"Roll no","Name","Age"};
        Object[][] data={{1,"Ram",19},{2,"Shyam",21}};
        JPanel item=new JPanel();
        studentTable=new JTable(data,column);
        JScrollPane scroll=new JScrollPane(studentTable);
        studentTable.setRowHeight(25);
        
        JButton b=new JButton("Click");
        b.addActionListener(e->check());
        
        
        
        item.add(scroll);
        item.add(b);
        add(item);
        setVisible(true);
        
    }
    public void check()
        {
            row =studentTable.getSelectedRow();
        if(row!=-1){
            Object val=studentTable.getValueAt(row,1);
            System.out.print(val);
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new q4();
            }
        });
    }
}