package Week_18;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class q2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q2 extends JFrame
{
    public q2(){
        setSize(900,600);
        setTitle("Student Record");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 50, 100, 30);
        JTextField nameText = new JTextField();
        nameText.setBounds(150, 50, 200, 30);
        
        JLabel age = new JLabel("Age:");
        age.setBounds(50, 100, 100, 30);
        JTextField ageText = new JTextField();
        ageText.setBounds(150, 100, 200, 30);
    
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 150, 100, 30);
        JTextField phoneText = new JTextField();
        phoneText.setBounds(150, 150, 200, 30);
        
        JButton submit=new JButton("Submit");
        submit.setBounds(50,200,80,30);
        
        
        
        add(name); 
        add(nameText);
        add(age); 
        add(ageText);
        add(phone); 
        add(phoneText);
        add(submit);
        setVisible(true);
        try{
        if(nameText.getText().trim().isEmpty())
        {
           throw new IllegalArgumentException("Invalid name"); 
        }
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"Name cannot be empty");
        return;
        }
        
        try 
        {
            int ageCheck = Integer.parseInt(ageText.getText());
            if (ageCheck < 0 || ageCheck > 120) {
                JOptionPane.showMessageDialog(null, "Age must be between 0 and 120");
                return;
            }
        } 
        catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(null, "Age must be a number");
           return;
        }
        
        
        if (!isValidPhone(phoneText.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Phone must start with 98 or 97 and be 10 digits long");
            return;
        }
        JOptionPane.showMessageDialog(null, "Record submitted successfully!");
    }

    public boolean isValidPhone(String phone) {
        return phone.matches("9[87]\\d{8}");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new q2();
            }
        });
    }
}
