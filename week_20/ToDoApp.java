package week_20;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Java Swing To-Do List application styled after the provided reference image.
 * Features:
 * - Sidebar for task filtering (Working).
 * - Header with a centered title.
 * - Top input bar with Task description, Priority dropdown, and Add Task button.
 * - Dynamic task list with checkboxes and individual Delete buttons.
 * - Right-side action buttons (Done marks checked items as complete, Clear All).
 */
public class ToDoApp extends JFrame {

    private JTextField taskField;
    private JComboBox<String> priorityBox;
    private JPanel listPanel;
    private List<TaskItem> tasks = new ArrayList<>();
    private String currentFilter = "All Tasks";

    public ToDoApp() {
        setTitle("My ToDo Manager");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- Header Section ---
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(200, 220, 255));
        headerPanel.setPreferredSize(new Dimension(0, 50));
        JLabel titleLabel = new JLabel("My ToDo Manager", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // --- Sidebar (Left) ---
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(150, 0));
        sidebar.setBorder(new EmptyBorder(10, 10, 10, 10));
        sidebar.setBackground(new Color(230, 230, 230));

        String[] filters = {"All Tasks", "Completed", "Pending", "Important"};
        for (String filter : filters) {
            JButton filterBtn = new JButton(filter);
            filterBtn.setMaximumSize(new Dimension(130, 30));
            filterBtn.addActionListener(e -> {
                currentFilter = filter;
                renderList();
            });
            sidebar.add(filterBtn);
            sidebar.add(Box.createVerticalStrut(10));
        }
        add(sidebar, BorderLayout.WEST);

        // --- Main Content (Center) ---
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Top Input Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topBar.setBackground(new Color(240, 240, 240));
        
        topBar.add(new JLabel("Task:"));
        taskField = new JTextField(20);
        topBar.add(taskField);

        String[] priorities = {"High", "Medium", "Low"};
        priorityBox = new JComboBox<>(priorities);
        priorityBox.setSelectedItem("Medium");
        topBar.add(priorityBox);

        JButton addButton = new JButton("Add Task");
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.BLACK);
        addButton.addActionListener(e -> addTask());
        topBar.add(addButton);

        centerPanel.add(topBar, BorderLayout.NORTH);

        // Task List Area
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(235, 235, 235));
        JScrollPane scrollPane = new JScrollPane(listPanel);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // --- Action Sidebar (Right) ---
        JPanel rightBar = new JPanel();
        rightBar.setLayout(new BoxLayout(rightBar, BoxLayout.Y_AXIS));
        rightBar.setPreferredSize(new Dimension(160, 0));
        rightBar.setBorder(new EmptyBorder(10, 10, 10, 10));
        rightBar.setBackground(new Color(230, 230, 230));

        JButton doneBtn = new JButton("Done");
        doneBtn.setBackground(Color.RED);
        doneBtn.setForeground(Color.WHITE);
        doneBtn.setMaximumSize(new Dimension(140, 40));
        doneBtn.setFont(new Font("Arial", Font.BOLD, 14));
        doneBtn.addActionListener(e -> markSelectedAsDone());

        JButton clearAllBtn = new JButton("Clear All");
        clearAllBtn.setBackground(Color.GREEN);
        clearAllBtn.setForeground(Color.BLACK);
        clearAllBtn.setMaximumSize(new Dimension(140, 40));
        clearAllBtn.setFont(new Font("Arial", Font.BOLD, 14));
        clearAllBtn.addActionListener(e -> clearAllTasks());

        rightBar.add(doneBtn);
        rightBar.add(Box.createVerticalStrut(20));
        rightBar.add(clearAllBtn);
        add(rightBar, BorderLayout.EAST);
    }

    private void addTask() {
        String desc = taskField.getText().trim();
        if (!desc.isEmpty()) {
            TaskItem item = new TaskItem(desc, (String) priorityBox.getSelectedItem());
            tasks.add(item);
            renderList();
            taskField.setText("");
        }
    }

    private void markSelectedAsDone() {
        // The Done button typically marks all currently "visible" tasks as completed 
        // or acts on specific logic. Here we refresh based on checkbox state.
        renderList(); 
    }

    private void clearAllTasks() {
        tasks.clear();
        renderList();
    }

    private void renderList() {
        listPanel.removeAll();
        
        // Filter tasks based on sidebar selection
        List<TaskItem> filteredTasks = tasks.stream().filter(t -> {
            switch (currentFilter) {
                case "Completed": return t.isCompleted;
                case "Pending": return !t.isCompleted;
                case "Important": return t.priority.equals("High");
                default: return true;
            }
        }).collect(Collectors.toList());

        for (TaskItem task : filteredTasks) {
            JPanel itemRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
            itemRow.setMaximumSize(new Dimension(1000, 50));
            itemRow.setBackground(new Color(235, 235, 235));

            JCheckBox cb = new JCheckBox(task.description);
            cb.setSelected(task.isCompleted);
            cb.setOpaque(false);
            
            // Priority color coding
            if (task.priority.equals("High")) cb.setForeground(Color.RED);
            else if (task.priority.equals("Medium")) cb.setForeground(new Color(150, 100, 0));
            else cb.setForeground(new Color(0, 100, 0));

            // Update task state when checkbox is clicked
            cb.addActionListener(e -> task.isCompleted = cb.isSelected());

            JButton delBtn = new JButton("Delete");
            delBtn.setBackground(new Color(255, 180, 180));
            delBtn.addActionListener(e -> {
                tasks.remove(task);
                renderList();
            });

            itemRow.add(cb);
            itemRow.add(delBtn);
            listPanel.add(itemRow);
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    private static class TaskItem {
        String description;
        String priority;
        boolean isCompleted = false;

        TaskItem(String d, String p) {
            this.description = d;
            this.priority = p;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new ToDoApp().setVisible(true));
    }
}
