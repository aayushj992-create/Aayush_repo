package week_19;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class AdminCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdminCard extends JFrame
{
    public AdminCard()
    {
        setTitle("Student Admin");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel header=new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icon=new ImageIcon("logo.png");
        Image img=icon.getImage();
        Image scaled=img.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon=new ImageIcon(scaled);
        header.add(new JLabel(scaledIcon));
        header.add(new JLabel("<HTML><H1>Student Admin Panel </H1></HTML>"));
        header.setBackground(Color.LIGHT_GRAY);
        add(header,BorderLayout.NORTH);
        
        JPanel footer=new JPanel(new FlowLayout(FlowLayout.CENTER));
        footer.add(new JLabel("@ 2025 Management System"));
        footer.setBackground(Color.lightGray);
        add(footer,BorderLayout.SOUTH);
        
        JPanel side=new JPanel(new FlowLayout(FlowLayout.LEFT));
        side.setPreferredSize(new Dimension(180,0));
        side.setBackground(new Color(220,220,220));
        Dimension btnSize=new Dimension(150,30);
        JButton addButton=new JButton("Add Button");
        addButton.setPreferredSize(btnSize);
        side.add(addButton);
        JButton viewButton=new JButton("View Button");
        viewButton.setPreferredSize(btnSize);
        side.add(viewButton);
        JButton updateButton=new JButton("Update Button");
        updateButton.setPreferredSize(btnSize);
        side.add(updateButton);
        JButton removeButton=new JButton("Remove Button");
        removeButton.setPreferredSize(btnSize);
        side.add(removeButton);
        add(side,BorderLayout.WEST);
        
        
        JPanel center =new JPanel();
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
        JPanel name= new JPanel(new FlowLayout(FlowLayout.LEFT));
        name.add(new JLabel("Name"));
        name.add(new JTextField(20));
        center.add(name);
        JPanel age=new JPanel(new FlowLayout(FlowLayout.LEFT));
        age.add(new JLabel("Age"));
        age.add(new JTextField(20));
        center.add(age);
        
        JPanel phone=new JPanel(new FlowLayout(FlowLayout.LEFT));
        phone.add(new JLabel("Phone"));
        phone.add(new JTextField(20));
        center.add(phone);
        add(center,BorderLayout.CENTER);
        
        JPanel gender=new JPanel(new FlowLayout(FlowLayout.LEFT));
        gender.add(new JLabel("Gender"));
        JRadioButton male=new JRadioButton("Male");
        JRadioButton female=new JRadioButton("Female");
        gender.add(male);
        gender.add(female);
        center.add(gender);
        
        JPanel skill=new JPanel(new FlowLayout(FlowLayout.LEFT));
        skill.add(new JLabel("Skill"));
        JCheckBox box1=new JCheckBox("Java");
        skill.add(box1);
        JCheckBox box2=new JCheckBox("Python");
        skill.add(box2);
        JCheckBox box3=new JCheckBox("C++");
        skill.add(box3);
        center.add(skill);
        
        JPanel course=new JPanel(new FlowLayout(FlowLayout.LEFT));
        course.add(new JLabel("Course"));
        String[] options = {"B.Tech", "M.Tech", "B.Sc","M.Sc"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        course.add(comboBox);
        center.add(course);
        
        JPanel register=new JPanel(new FlowLayout(FlowLayout.LEFT));
        register.add(new JButton("Register"));
        center.add(register);

        setVisible(true);
    }
    public static void main(String[] args) 
    {
    SwingUtilities.invokeLater(new Runnable(){ 
    public void run(){ 
    new AdminCard(); 
    } 
    }); 
    }
}
