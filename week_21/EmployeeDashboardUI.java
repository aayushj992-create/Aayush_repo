package week_21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EmployeeDashboardUI extends JFrame {
    JLabel h, charCountLabel, mousePosition, status;
    JTextField nameField;
    JTextField salaryField;

    JRadioButton fullTime, partTime, contract;

    JCheckBox healthInsurance, dentalInsurance, retirementPlan;

    JComboBox<String> departmentBox;

    JPanel details;

    ArrayList<Employee> employees = new ArrayList<>();
    ButtonGroup group;
    public EmployeeDashboardUI() {
        setTitle("Employee Management System");
        setSize(900, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        h = new JLabel("<html><h1>Employee Management System</h1></html>");
        header.add(h);

        header.setBackground(new Color(173, 216, 230));
        h.setForeground(Color.WHITE);

        header.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                h.setText("<html><h1>Employee Record View</h1></html>");
                header.setBackground(Color.ORANGE);
            }

            public void mouseExited(MouseEvent e) {
                h.setText("<html><h1>Employee Management System</h1></html>");
                header.setBackground(new Color(173, 216, 230));
            }
        });

        add(header, BorderLayout.NORTH);

       
        JPanel sidebar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBackground(Color.LIGHT_GRAY);

        JButton addBtn = new JButton("Add Employee");
        JButton viewBtn = new JButton("View Employee");
        JButton updateBtn = new JButton("Update Employee");
        JButton delBtn = new JButton("Delete Employee");
        JButton searchBtn = new JButton("Search Employee");

        sidebar.add(addBtn);
        sidebar.add(viewBtn);
        sidebar.add(updateBtn);
        sidebar.add(delBtn);
        sidebar.add(searchBtn);

        changeBtn(addBtn);
        changeBtn(viewBtn);
        changeBtn(updateBtn);
        changeBtn(delBtn);
        changeBtn(searchBtn);

        add(sidebar, BorderLayout.WEST);

        details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setBackground(Color.WHITE);

        
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel name = new JLabel("Name");

        nameField = new JTextField(20);
        nameField.setText("Enter full name");
        nameField.setForeground(Color.LIGHT_GRAY);

        nameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (nameField.getText().equals("Enter full name")) {
                    nameField.setText("");
                    nameField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (nameField.getText().equals("")) {
                    nameField.setText("Enter full name");
                    nameField.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        namePanel.add(name);
        namePanel.add(nameField);
        details.add(namePanel);

       
        JPanel salaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryPanel.setBackground(Color.LIGHT_GRAY);
        salaryPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        JLabel salary = new JLabel("Salary");
        salaryField = new JTextField(20);

        salaryPanel.add(salary);
        salaryPanel.add(salaryField);
        details.add(salaryPanel);

        
        JPanel employeeTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        employeeTypePanel.setBackground(Color.LIGHT_GRAY);
        employeeTypePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        JLabel employeeType = new JLabel("Employee Type");
        fullTime = new JRadioButton("Full Time");
        partTime = new JRadioButton("Part Time");
        contract = new JRadioButton("Contract");

         group = new ButtonGroup();
        group.add(fullTime);
        group.add(partTime);
        group.add(contract);

        employeeTypePanel.add(employeeType);
        employeeTypePanel.add(fullTime);
        employeeTypePanel.add(partTime);
        employeeTypePanel.add(contract);
        details.add(employeeTypePanel);

       
        JPanel benefitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        benefitPanel.setBackground(Color.LIGHT_GRAY);
        benefitPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        JLabel benefitLabel = new JLabel("Benefits");
        healthInsurance = new JCheckBox("Health Insurance");
        dentalInsurance = new JCheckBox("Dental Insurance");
        retirementPlan = new JCheckBox("Retirement Plan");

        benefitPanel.add(benefitLabel);
        benefitPanel.add(healthInsurance);
        benefitPanel.add(dentalInsurance);
        benefitPanel.add(retirementPlan);
        details.add(benefitPanel);

       
        JPanel departmentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        departmentPanel.setBackground(Color.LIGHT_GRAY);
        departmentPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        JLabel departmentLabel = new JLabel("Department");
        String[] options = {"Please select a department", "IT", "HR", "Operation", "Research"};
        departmentBox = new JComboBox<>(options);

        departmentPanel.add(departmentLabel);
        departmentPanel.add(departmentBox);
        details.add(departmentPanel);

       
        JButton regBtn = new JButton("Register Employee");
        regBtn.addActionListener(e -> registerBtn());

        JButton clearBtn = new JButton("Clear Form");
        clearBtn.addActionListener(e -> clearForm());

        JButton clearAllBtn = new JButton("Clear All Records");
        clearAllBtn.addActionListener(e-> clearRegister());

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.LIGHT_GRAY);
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        btnPanel.add(regBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(clearAllBtn);

        details.add(btnPanel);
        add(details, BorderLayout.CENTER);

       
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        footer.setBackground(Color.BLACK);

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        charCountLabel = new JLabel("<html><h3>Characters: 0</h3></html>");
        mousePosition = new JLabel("<html><h3>Mouse Position: (0,0)</h3></html>");

        left.add(charCountLabel);
        left.add(mousePosition);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        status = new JLabel("<html><h3>Status: Ready</h3></html>");
        right.add(status);

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                mousePosition.setText("<html><h3>Mouse Position: (" + e.getX() + "," + e.getY() + ")</h3></html>");
            }
        });

        footer.add(left);
        footer.add(right);
        add(footer, BorderLayout.SOUTH);

        
        nameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int count = nameField.getText().length();
                charCountLabel.setText("<html><h3>Characters: " + count + "</h3></html>");

                if (count <= 10)
                    charCountLabel.setForeground(Color.GREEN);
                else if (count <= 15)
                    charCountLabel.setForeground(Color.ORANGE);
                else
                    charCountLabel.setForeground(Color.RED);
            }
        });

        setVisible(true);
    }

    public void changeBtn(JButton btnName) {
        btnName.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnName.setBackground(Color.GREEN);
                btnName.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                btnName.setBackground(Color.WHITE);
                btnName.setForeground(Color.BLACK);
            }
        });
    }
    
    
    public void clearRegister()
    {
        for (int i = employees.size() - 1; i >= 0; i--)
        {
        employees.remove(i);
        }
    }
    
    
    public void registerBtn() 
    {
        String name = nameField.getText();
        String salary = salaryField.getText();

        try {
            salCheck(salary);
            if (name.isEmpty() || name.equals("Enter full name"))
                throw new Exception("Name cannot be empty");
            else if (salary.isEmpty())
                throw new Exception("Salary cannot be empty");
            else if (Double.parseDouble(salary) < 0)
                throw new Exception("Salary cannot be less than 0");
            else if (departmentBox.getSelectedItem().equals("Please select a department"))
                throw new Exception("Please select a department");
            else if (!healthInsurance.isSelected() && !dentalInsurance.isSelected() && !retirementPlan.isSelected())
                throw new Exception("Please select at least one benefit");
            else if (!fullTime.isSelected() && !partTime.isSelected() && !contract.isSelected())
                throw new Exception("Please select employee type");

            JOptionPane.showMessageDialog(this, "Employee saved successfully");
            regval();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void salCheck(String s) throws Exception {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            throw new Exception("Salary should be numeric");
        }
    }

    public void clearForm() {
        nameField.setText("Enter full name");
        nameField.setForeground(Color.LIGHT_GRAY);
        salaryField.setText("");
        group.clearSelection();
        healthInsurance.setSelected(false);
        dentalInsurance.setSelected(false);
        retirementPlan.setSelected(false);
        departmentBox.setSelectedIndex(0);
    }

    public void regval() {
        String name = nameField.getText();
        String salary = salaryField.getText();
        String employeeType = "";

        if (fullTime.isSelected()) employeeType = "Full Time";
        else if (partTime.isSelected()) employeeType = "Part Time";
        else if (contract.isSelected()) employeeType = "Contract";

        String benefit = "";
        if (healthInsurance.isSelected()) benefit += "Health ";
        if (dentalInsurance.isSelected()) benefit += "Dental ";
        if (retirementPlan.isSelected()) benefit += "Retirement ";

        String department = departmentBox.getSelectedItem().toString();
        Employee e1 = new Employee(name, salary, employeeType, benefit, department);
        employees.add(e1);

        for (Employee emp : employees) {
            JOptionPane.showMessageDialog(this, emp);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new EmployeeDashboardUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        });
    }
}