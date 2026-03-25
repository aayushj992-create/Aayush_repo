package home;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RegestrationForm extends JFrame {
    private DefaultTableModel tableModel;
    private JTable studentTable;

    public RegestrationForm() {
        setTitle("Department Administration Office");
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // --- Form Components ---
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(20, 50, 80, 30);
        add(idLabel);
        JTextField idText = new JTextField();
        idText.setBounds(110, 50, 150, 30);
        add(idText);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 100, 80, 30);
        add(nameLabel);
        JTextField nameText = new JTextField();
        nameText.setBounds(110, 100, 150, 30);
        add(nameText);

        // --- Table Implementation ---
        String[] columnNames = {"Student ID", "Name", "Course", "Gender", "Skills"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBounds(20, 360, 840, 200);
        add(scrollPane);

        // --- Manually adding data to the table without an Event Listener ---
        // This simulates adding the info as soon as the program runs
        Object[] exampleData = {101, "John Doe", "BIT", "Male", "Java"};
        tableModel.addRow(exampleData);

        // Buttons (Visual only, no functionality)
        JButton submit = new JButton("Submit/Add");
        submit.setBounds(20, 310, 120, 30);
        add(submit);

        JButton delete = new JButton("Delete");
        delete.setBounds(150, 310, 100, 30);
        add(delete);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegestrationForm();
            }
        });
    }
}
