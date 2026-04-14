package week_21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentDashboardUI extends JFrame {
    JLabel h;
    JTextField nameField, ageField;
    JRadioButton male, female, other;
    JCheckBox java, python, cpp;
    JComboBox<String> courseBox;
    JTextArea displayArea;
    JLabel charCountLabel;
    ArrayList<Student> students = new ArrayList<>();
    public StudentDashboardUI() {

        setTitle("Student Admin Panel");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== Header =====
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        h = new JLabel("<html><h1>Student Admin Panel</h1></html>");
        header.add(h);
        header.setBackground(Color.LIGHT_GRAY);
        add(header, BorderLayout.NORTH);

        // ===== Sidebar =====
        JPanel sidebar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        sidebar.setPreferredSize(new Dimension(180, 0));

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Student");
        JButton updateBtn = new JButton("Update Student");
        JButton deleteBtn = new JButton("Delete Student");

        sidebar.add(addBtn);
        sidebar.add(viewBtn);
        sidebar.add(updateBtn);
        sidebar.add(deleteBtn);

        add(sidebar, BorderLayout.WEST);

        // ===== Form =====
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        // Name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel name = new JLabel("Name");
        nameField = new JTextField(20);

        namePanel.add(name);
        namePanel.add(nameField);
        form.add(namePanel);

        // Age
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel age = new JLabel("Age");
        ageField = new JTextField(20);

        agePanel.add(age);
        agePanel.add(ageField);
        form.add(agePanel);

        // Gender
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        JPanel gPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        gPanel.add(new JLabel("Gender:"));
        gPanel.add(male);
        gPanel.add(female);
        gPanel.add(other);

        form.add(gPanel);

        // Skills
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        cpp = new JCheckBox("C++");

        JPanel sPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sPanel.add(new JLabel("Skills:"));
        sPanel.add(java);
        sPanel.add(python);
        sPanel.add(cpp);

        form.add(sPanel);

        // Course
        JPanel cPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cPanel.add(new JLabel("Course"));

        String[] courses = {"B.Tech", "M.Tech", "B.Sc", "M.Sc"};
        courseBox = new JComboBox<>(courses);

        cPanel.add(courseBox);
        form.add(cPanel);

        // Buttons
        JButton registerBtn = new JButton("Register");
        JButton clearForm = new JButton("Clear Form");
        JButton clearBtn = new JButton("Clear All");

        JPanel btnPanel = new JPanel();
        btnPanel.add(registerBtn);
        btnPanel.add(clearForm);
        btnPanel.add(clearBtn);

        form.add(btnPanel);

        add(form, BorderLayout.CENTER);

        // ===== Display =====
        displayArea = new JTextArea(20, 25);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        
        add(displayArea, BorderLayout.EAST);

        // ===== Footer =====
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        footer.setBackground(Color.DARK_GRAY);

        charCountLabel = new JLabel("<html><h1>Characters: 0</h1></html>");
        charCountLabel.setForeground(Color.WHITE);

        footer.add(charCountLabel);
        add(footer, BorderLayout.SOUTH);

        // ===== BUTTON ACTIONS =====
        registerBtn.addActionListener(e -> registerStudent());

        clearForm.addActionListener(e -> {
            nameField.setText("");
            ageField.setText("");

            male.setSelected(false);
            female.setSelected(false);
            other.setSelected(false);

            java.setSelected(false);
            python.setSelected(false);
            cpp.setSelected(false);

            courseBox.setSelectedIndex(0);
        });

        clearBtn.addActionListener(e -> {
            displayArea.setText("");
            students.clear();
        });

        pack();
        setVisible(true);
    }

    // ===== Register =====
    private void registerStudent() {

        String name = nameField.getText();
        if (name.equals("Enter Name")) name = "";

        String age = ageField.getText();
        if (age.equals("Enter Age")) age = "";

        String gender =
                male.isSelected() ? "Male" :
                female.isSelected() ? "Female" :
                other.isSelected() ? "Other" : "";

        String skills = "";
        if (java.isSelected()) skills += "Java ";
        if (python.isSelected()) skills += "Python ";
        if (cpp.isSelected()) skills += "C++ ";

        String course = courseBox.getSelectedItem().toString();

        Student s = new Student(name, age, gender, skills, course);
        students.add(s);

        displayArea.append(String.join(", ", s.getStudentData()) + "\n");

        JOptionPane.showMessageDialog(this, "Student Registered!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentDashboardUI());
    }
}
