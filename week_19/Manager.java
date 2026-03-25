package week_19;
import javax.swing.*;
import java.awt.*;
import java.awt.TextField;



/**
 * Write a description of class Manager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Manager extends JFrame
{
    private JTextField text;
    private JPanel taskListPanel;
    private JButton del;
    private JButton done;
    private JPanel row;
    private JCheckBox check;
    public Manager(){
        setSize(900,600);
        setTitle("My ToDo Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel header=new JPanel(new FlowLayout(FlowLayout.CENTER));
        header.add(new JLabel("<HTML> <H1>My ToDo Manager</H1></HTML>"));
        add(header,BorderLayout.NORTH);
        header.setBackground(new Color(135, 206, 235));
        
        JPanel footer=new JPanel(new FlowLayout(FlowLayout.CENTER));
        footer.add(new JLabel("<HTML> <H3>Developed using Java Swing</H3></HTML>"));
        add(footer,BorderLayout.SOUTH);
        
        JPanel side=new JPanel(new FlowLayout(FlowLayout.LEFT));
        side.setPreferredSize(new Dimension(150,0));
        Dimension btnSize=new Dimension(150,30);
        JButton allTasks=new JButton("All Tasks");
        allTasks.setPreferredSize(btnSize);
        side.add(allTasks);
        

        
        JButton completed=new JButton("Completed");
        completed.setPreferredSize(btnSize);
        side.add(completed);
        
        JButton pending=new JButton("Pending");
        pending.setPreferredSize(btnSize);
        side.add(pending);
    
        JButton important =new JButton("Important");
        important.setPreferredSize(btnSize);
        side.add(important);
        add(side,BorderLayout.WEST);
        
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(new JLabel("Task:"));
        text = new JTextField(20);
        toolbar.add(text);
        String[] options = {"High", "Low"};
        JComboBox<String> option = new JComboBox<>(options);
        toolbar.add(option);
        JButton addTask = new JButton("Add Task");
        JButton clearTask=new JButton("Clear");
        addTask.setBackground(Color.GREEN);
        toolbar.add(addTask);
        toolbar.add(clearTask);
        addTask.addActionListener(e->add());
        clearTask.addActionListener(e->clear());
        centerPanel.add(toolbar, BorderLayout.NORTH);  
        
        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));
        
        
           
        centerPanel.add(taskListPanel);
        
        JScrollPane scrollPane = new JScrollPane(taskListPanel);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        
        
        
        setVisible(true);      
    }
    public void clear()
    {
        taskListPanel.remove(row);
    }
    public void add()
        {
            String txt=text.getText();
            if(txt.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Please enter vaild text");
            }
            else
            {
            addTask(txt);
        }
    }
        public void done(String doneTest){
            if(check.isSelected())
            {
                check.setText("<html><strike>"+doneTest+"</strike></html>");
            }
        }
        public void del()
        {
           taskListPanel.remove(row); 
           taskListPanel.revalidate();
            taskListPanel.repaint();
        }
        public void addTask(String test)
        {
                row= new JPanel();
                row.setLayout(new FlowLayout(FlowLayout.LEFT));
                check=new JCheckBox(test);
                del=new JButton("Delete");
                done=new JButton("Done");
                del.setBackground(Color.RED);
                row.add(check);
                row.add(del);
                row.add(done);
                del.addActionListener(e->del());
                done.addActionListener(e->done(test));
                taskListPanel.add(row);
                taskListPanel.revalidate();
                taskListPanel.repaint();
        }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Manager();
            }
        });
    }
}