    package week_20;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Write a description of class arrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Manager extends JFrame
{
    private ArrayList<JPanel> rows = new ArrayList<>();
    private JTextField text;
    private JPanel taskListPanel;
    private JButton done;
    private JPanel main;
    private ArrayList<JCheckBox> check = new ArrayList<>();
    private ArrayList<String> selectedTasks = new ArrayList<>();
    private JButton clear;
    private JComboBox<String> option;

    public Manager() {
        setSize(900, 600);
        setTitle("My ToDo Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        header.add(new JLabel("<HTML><H1>My ToDo Manager</H1></HTML>"));
        header.setBackground(new Color(135, 206, 235));
        add(header, BorderLayout.NORTH);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footer.add(new JLabel("<HTML><H3>Developed using Java Swing</H3></HTML>"));
        add(footer, BorderLayout.SOUTH);

        JPanel side = new JPanel(new FlowLayout(FlowLayout.LEFT));
        side.setPreferredSize(new Dimension(150, 0));
        Dimension btnSize = new Dimension(140, 30);

        JButton allTasks = new JButton("All Tasks");
        allTasks.setPreferredSize(new Dimension(120, 30));
        allTasks.addActionListener(e -> allTask());
        side.add(allTasks);

        JButton completed = new JButton("Completed");
        completed.setPreferredSize(btnSize);
        completed.addActionListener(e -> completed());
        side.add(completed);

        JButton pending = new JButton("Pending");
        pending.setPreferredSize(new Dimension(120, 30));
        pending.addActionListener(e -> pending());
        side.add(pending);

        JButton important = new JButton("Important");
        important.setPreferredSize(btnSize);
        important.addActionListener(e -> important());
        side.add(important);
        add(side, BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(new JLabel("Task:"));
        text = new JTextField(20);
        toolbar.add(text);
        String[] options = {"High", "Medium", "Low"};
        option = new JComboBox<>(options);
        toolbar.add(option);
        JButton addTask = new JButton("Add Task");
        addTask.setBackground(Color.GREEN);
        addTask.addActionListener(e -> add());
        toolbar.add(addTask);
        centerPanel.add(toolbar, BorderLayout.NORTH);

        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(taskListPanel);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        JPanel eastPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        eastPanel.setBackground(new Color(207, 212, 209));
        eastPanel.setPreferredSize(new Dimension(180, 0));

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(160, 30));
        done.setBackground(Color.red);
        done.addActionListener(e -> done());
        eastPanel.add(done);

        clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(160, 30));
        clear.setBackground(Color.green);
        clear.addActionListener(e -> clear());
        eastPanel.add(clear);

        add(eastPanel, BorderLayout.EAST);

        setVisible(true);
    }

    public void allTask() {
        taskListPanel.removeAll();
        main.removeAll();
        for (JPanel p : rows) {
            main.add(p);
        }
        taskListPanel.add(main);
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    public void completed() {
        taskListPanel.removeAll();
        main.removeAll();
        for (int i = 0; i < check.size(); i++) {
            if (check.get(i).getText().contains("<strike>")) {
                main.add(rows.get(i));
            }
        }
        taskListPanel.add(main);
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    public void pending() {
        taskListPanel.removeAll();
        main.removeAll();
        for (int i = 0; i < check.size(); i++) {
            if (!check.get(i).getText().contains("<strike>")) {
                main.add(rows.get(i));
            }
        }
        taskListPanel.add(main);
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    public void important() {
        taskListPanel.removeAll();
        main.removeAll();
        for (int i = 0; i < check.size(); i++) {
            if (check.get(i).getForeground().equals(Color.red)) {
                main.add(rows.get(i));
            }
        }
        taskListPanel.add(main);
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    public void add() {
        String txt = text.getText().trim();
        if (txt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid text");
        } else {
            addTask(txt);
            text.setText("");
        }
    }

    public void done() {
        for (JCheckBox cb : check) {
            if (cb.isSelected() && !cb.getText().contains("<strike>")) {
                selectedTasks.add(cb.getText());
                cb.setText("<html><strike>" + cb.getText() + "</strike></html>");
            }
        }
    }

    public void clear() {
        main.removeAll();
        rows.clear();
        check.clear();
        selectedTasks.clear();
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    public void addTask(String taskText)
    {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox newCheck = new JCheckBox(taskText);

        if (option.getSelectedItem().equals("High")) {
            newCheck.setForeground(Color.red);
        } else if (option.getSelectedItem().equals("Medium")) {
            newCheck.setForeground(Color.green);
        } else if (option.getSelectedItem().equals("Low")) {
            newCheck.setForeground(Color.yellow);
        }

        JButton delBtn = new JButton("Delete");
        delBtn.setBackground(Color.RED);
        delBtn.addActionListener(e -> {
            main.remove(row);
            rows.remove(row);
            check.remove(newCheck);
            taskListPanel.revalidate();
            taskListPanel.repaint();
        });

        check.add(newCheck);
        row.add(newCheck);
        row.add(delBtn);
        rows.add(row);
        main.add(row);

        if (taskListPanel.getComponentCount() == 0) {
            taskListPanel.add(main);
        }

        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Manager();
            }
        });
    }
}