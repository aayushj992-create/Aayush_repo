package Week_18;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class RegestrationForm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RegestrationForm extends JFrame
{
    public RegestrationForm(){
    setTitle("Department Administration Office");
    setSize(900,600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);
    
    JLabel id= new JLabel("Student ID:");
    id.setBounds(20,50,80,30);
    add(id);
    
    JTextField idText=new JTextField();
    idText.setBounds(82,50,100,30);
    add(idText);
    
    JLabel name=new JLabel("Name:");
    name.setBounds(20,100,80,30);
    add(name);

    JTextField nameText=new JTextField();
    nameText.setBounds(80,100,100,30);
    add(nameText);
    
    JLabel courseText=new JLabel("Course");
    courseText.setBounds(20,150,80,30);
    add(courseText);
    String[] courseOptions={"Bsc","BBA","BIT"};
    JComboBox<String> course=new JComboBox<>(courseOptions);
    course.setBounds(80,150,100,30);
    add(course);
    
    
    JLabel gender=new JLabel("Gender");
    gender.setBounds(20,200,80,30);
    add(gender);
    
    JRadioButton male=new JRadioButton("Male");
    male.setBounds(80,190,60,50);
    add(male);
    
    JRadioButton female=new JRadioButton("Female");
    add(female);
    female.setBounds(180,190,80,50);
    
    JRadioButton other=new JRadioButton("Other");
    add(other);
    other.setBounds(270,190,80,50);
    
    ButtonGroup group=new ButtonGroup();
    group.add(male);
    group.add(female);
    group.add(other);
    
    JLabel skills=new JLabel("Skills");
    skills.setBounds(20,250,60,30);
    add(skills);
    
    JCheckBox java=new JCheckBox("Java");
    java.setBounds(80,240,80,50);
    add(java);
    
    JCheckBox python=new JCheckBox("Python");
    python.setBounds(140,240,80,50);
    add(python);
    
    JCheckBox c=new JCheckBox("C-program");
    c.setBounds(220,240,100,50);
    add(c);
    
    JCheckBox sql=new JCheckBox("SQL");
    sql.setBounds(320,240,80,50);
    add(sql);
    
    JCheckBox nodeJS=new JCheckBox("nodeJS");
    nodeJS.setBounds(400,240,80,50);
    add(nodeJS);
    
    
    JButton submit=new JButton("Submit/Add");
    submit.setBounds(20,300,80,30);
    add(submit);
    
    JButton reset=new JButton("Reset");
    reset.setBounds(130,300,80,30);
    add(reset);
    
    JButton search=new JButton("Search");
    search.setBounds(250,300,80,30);
    add(search);
    
    JButton delete=new JButton("Delete");
    delete.setBounds(370,300,80,30);
    add(delete);
    
    String[] column={"ID","Name","Gender","Skill","Course"};
    Object[][] data = {{"101", "John Doe", "Male", "Java", "BIT"},{"102", "Jane Smith", "Female", "Python", "Bsc"}};
       
    JTable table=new JTable(data,column);
    JScrollPane scroll=new JScrollPane(table);
    scroll.setBounds(20, 360, 840, 200);
    add(scroll);
    
    
    setVisible(true);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new RegestrationForm();
            }
        });
    }
}