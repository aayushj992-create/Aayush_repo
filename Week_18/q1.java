package Week_18;
import javax.swing.*;
import java.awt.*;

public class q1 extends JFrame {

    public q1() {
        setTitle("Form");
        setSize(900, 600);
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

        JLabel departments = new JLabel("Department:");
        departments.setBounds(50, 200, 100, 30);

        String[] departmentOption = {
            "Human Resources", "Finance & Accounting", "Marketing", "Sales",
            "Information Technology", "Operations", "Customer Service / Support",
            "Research & Development", "Procurement / Purchasing",
            "Legal Department", "Administration", "Public Relations"
        };

        JComboBox<String> department = new JComboBox<>(departmentOption);
        department.setBounds(150, 200, 200, 30);

        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(50, 250, 100, 30);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 250, 80, 30);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(240, 250, 100, 30);

        
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        JLabel hobbies = new JLabel("Hobbies:");
        hobbies.setBounds(50, 300, 100, 30);

        JCheckBox sports = new JCheckBox("Sports");
        sports.setBounds(150, 300, 100, 30);

        JCheckBox cooking = new JCheckBox("Cooking");
        cooking.setBounds(250, 300, 100, 30);

        JCheckBox fishing = new JCheckBox("Fishing");
        fishing.setBounds(350, 300, 100, 30);

        JCheckBox reading = new JCheckBox("Reading");
        reading.setBounds(150, 340, 100, 30);

        JCheckBox playing = new JCheckBox("Playing");
        playing.setBounds(250, 340, 100, 30);


        add(name); 
        add(nameText);
        add(age); 
        add(ageText);
        add(phone); 
        add(phoneText);
        add(departments); 
        add(department);
        add(gender); 
        add(male); 
        add(female);
        add(hobbies);
        add(sports); 
        add(cooking); 
        add(fishing);
        add(reading); 
        add(playing);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new q1();
            }
        });
    }
}