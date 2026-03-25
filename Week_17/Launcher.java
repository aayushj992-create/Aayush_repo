package Week_17;
import javax.swing.*;

/**
 * Write a description of class Launcher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Launcher 
{
    public static void main(String[] args)
    {
        Student s1=new Student(1,"Ram Bahadur","Computing"); 
        Student s2=new Student(2,"Sita Lama","Networking");
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                 new IDCardWindow(s1);
                 new IDCardWindow(s2);
            }
        });
    }
}