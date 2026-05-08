package Coursework;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.BufferedReader;

/**
 * Write a description of class ProPlan here.
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */

public class SubscriptionGUI extends JFrame
{
    private static final Color Button_Color=new Color(45,45,60);
    private static final Color Hover_Color=new Color(30,30,50);
    private static final Color Text_Color=Color.WHITE;
    
    private ArrayList<AIModel> plan = new ArrayList<>();
    
    private JPanel panel, personalMainPanel, loginPanel, planPanel,proMainPanel;
    private CardLayout cardLayout;
    
    private JButton resetBtn, loginBtn;
    
    private DefaultTableModel teamTableModel;
    private JTable teamTable;
    
    private JPasswordField passField;
    
    private JTextField personalModelField, personalPriceField, personalParameterField, personalTokenField,personalContextField, personalPromptField, personalResponseField,
            personalIndexField,availableTokenField,userField;

    private JButton addTeamMember, removeTeamMember, displayAll, clear,personalBtn, proBtn, proCheckType,personalCheckType,proSubmit, back, personalSubmit,export,
            load,personalPromptBtn,proPromptBtn;
        
    private JPanel leftPanel,footerPanel,proRightPanel,proCenterPanel, btnPanel,centerPanel,proCombine,personalCombine;
    
    private ImageIcon icon, scaledIcon;
    private Image img, scaled;
    private JLabel headText,footerText;
    
    private Dimension leftBtnSize;

    private JTextField proModelField, proPriceField, proParameterField, proMemberField, proSlotField,proContextField, proPromptField, proResponseField, proIndexField,
            slotsRemainingField;
    
    public SubscriptionGUI()
    {
        setTitle("AI Reinforced System");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);

        loginPanel = new JPanel();
        planPanel = new JPanel();
        personalMainPanel = new JPanel(new BorderLayout());
        proMainPanel = new JPanel(new BorderLayout());

        /* ---------------- LOGIN PANEL ---------------- */

        loginPanel.setBackground(new Color(30,30,30));
        loginPanel.setPreferredSize(new Dimension(500,400));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        Dimension loginBtnSize = new Dimension(150,40);
        
        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(0,200));
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel userName = new JLabel("Username");
        userField = new JTextField(15);
       
        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel password = new JLabel("Password");
        passField = new JPasswordField(15);

        loginBtn = new JButton("Login");
        loginBtn.setPreferredSize(loginBtnSize);
        loginBtn.setMnemonic(KeyEvent.VK_L);

        resetBtn = new JButton("Reset");
        resetBtn.setPreferredSize(loginBtnSize);
        resetBtn.setMnemonic(KeyEvent.VK_R);
        
        btnDesign(loginBtn);
        btnDesign(resetBtn);

        btnHover(loginBtn);
        btnHover(resetBtn);
        loginBtn.addActionListener(e -> check());
        resetBtn.addActionListener(e -> reset());
        
        loginPanel.add(space);
        namePanel.add(userName);
        namePanel.add(userField);
        passPanel.add(password);
        passPanel.add(passField);
        infoPanel.add(namePanel);
        infoPanel.add(passPanel);
        infoPanel.add(buttonPanel);
        loginPanel.add(infoPanel);
        buttonPanel.add(loginBtn);
        buttonPanel.add(resetBtn);
        loginPanel.add(buttonPanel);

        /* ---------------- PLAN PANEL ---------------- */

        planPanel.setBackground(Color.LIGHT_GRAY);
        planPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        personalBtn = new JButton("Personal Plan");
        proBtn = new JButton("Pro Plan");

        Dimension planBtnSize = new Dimension(150,40);
        JPanel selectSpace = new JPanel();
        selectSpace.setPreferredSize(new Dimension(0,200));

        personalBtn.setPreferredSize(planBtnSize);
        proBtn.setPreferredSize(planBtnSize);

        btnDesign(personalBtn);
        btnDesign(proBtn);

        btnHover(personalBtn);
        btnHover(proBtn);
        
        planPanel.add(selectSpace);
        planPanel.add(personalBtn);
        planPanel.add(proBtn);

        personalBtn.addActionListener(e -> showpersonalDashboard());
        proBtn.addActionListener(e -> showproDashboard());

        /* ---------------- HEADER (PERSONAL) ---------------- */

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setPreferredSize(new Dimension(0,80));
        topPanel.setBackground(new Color(30,30,30));
        ImageIcon icon = new ImageIcon("AiLogo.png");
        Image img = icon.getImage();
        Image scaled = img.getScaledInstance(100,70,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaled);

        JLabel headText = new JLabel("<html><h1>AI-REINFORCED</h1></html>");
        headText.setForeground(Color.WHITE);
        topPanel.add(new JLabel(scaledIcon));
        topPanel.add(headText);

        personalMainPanel.add(topPanel, BorderLayout.NORTH);

        /* ---------------- LEFT PANEL (PERSONAL) ---------------- */

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setPreferredSize(new Dimension(180,0));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        leftBtnSize = new Dimension(170,40);
        personalIndexField = new JTextField(5);
        leftPanel.add(createPanel("Index Number:", personalIndexField));
        personalIndexField.setText("Index");
        focus(personalIndexField, "Index");

        personalCheckType = new JButton("Check Plan Type");
        personalCheckType.addActionListener(e -> personalCheckType(personalIndexField));
        
        
        btnDesign(personalCheckType);
        btnHover(personalCheckType);

        displayAll = new JButton("Display All");
        displayAll.setPreferredSize(leftBtnSize);
        displayAll.addActionListener(e -> personalDisplayAll());
        export= new JButton("Export to File");
        export.addActionListener(e -> exportToFile());
        export.setPreferredSize(leftBtnSize);
        
        load = new JButton("Load from File");
        load.addActionListener(e -> loadToFile());
        load.setPreferredSize(leftBtnSize);

        btnDesign(export);
        btnDesign(load);
        btnHover(export);
        btnHover(load);

        clear = new JButton("Clear");
        clear.setPreferredSize(leftBtnSize);

        btnDesign(displayAll);
        btnDesign(clear);
        btnHover(displayAll);
        btnHover(clear);

        clear.addActionListener(e -> personalClearText());
        leftPanel.add(personalCheckType);
        leftPanel.add(displayAll);
        leftPanel.add(clear);
        leftPanel.add(export);
        leftPanel.add(load);

        personalMainPanel.add(leftPanel, BorderLayout.WEST);

        /* ---------------- CENTER PANEL (PERSONAL) ---------------- */

        centerPanel = new JPanel();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        personalModelField = new JTextField(20);
        personalPriceField = new JTextField(20);
        personalPriceField.setText("2999");
        personalPriceField.setEditable(false);
        personalPriceField.setBackground(Color.WHITE);

        personalParameterField = new JTextField(20);
        personalContextField = new JTextField(20);
        personalTokenField = new JTextField(20);
        personalResponseField = new JTextField(20);

        centerPanel.add(createPanel("Model Name:", personalModelField));
        personalModelField.setText("Enter Model Name");
        focus(personalModelField, "Enter Model Name");
        centerPanel.add(createPanel("Price:", personalPriceField));
        centerPanel.add(createPanel("Parameter Count:", personalParameterField));
        personalParameterField.setText("Enter Parameter Count");
        focus(personalParameterField, "Enter Parameter Count");
        centerPanel.add(createPanel("Context Window:", personalContextField));
        personalContextField.setText("Enter Context Window");
        focus(personalContextField, "Enter Context Window");
        centerPanel.add(createPanel("Available Tokens:", personalTokenField));
        personalTokenField.setText("Enter Available Tokens");
        focus(personalTokenField, "Enter Available Tokens");
        
        
        

        btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(150,30));
        btnDesign(back);
        btnHover(back);
        
        personalSubmit = new JButton("Add Personal Plan");
        personalSubmit.setPreferredSize(new Dimension(150,30));
        personalSubmit.addActionListener(e -> addPersonalMember());
        btnDesign(personalSubmit);
        btnHover(personalSubmit);
        btnPanel.add(back);
        back.addActionListener(e -> back());
        btnPanel.add(Box.createHorizontalStrut(180));
        btnPanel.add(personalSubmit);
        centerPanel.add(btnPanel);
        personalMainPanel.add(centerPanel, BorderLayout.CENTER);

        /* ---------------- RIGHT PANEL (PERSONAL) ---------------- */

        JPanel rightPanel = new JPanel(new FlowLayout());
        rightPanel.setPreferredSize(new Dimension(180,0));
        rightPanel.setBackground(Color.LIGHT_GRAY);

        JLabel availableToken = new JLabel("Available Tokens:");
        availableTokenField = new JTextField(3);
        availableTokenField.setText("");
        availableTokenField.setEditable(false);
        JButton buyPrompt=new JButton("Buy Tokens");
        btnDesign(buyPrompt);
        btnHover(buyPrompt);
        buyPrompt.addActionListener(e->buyPrompt());
        
        buyPrompt.setPreferredSize(new Dimension(150,30));
        
        

        rightPanel.add(availableToken);
        rightPanel.add(availableTokenField);
        rightPanel.add(buyPrompt);
        personalMainPanel.add(rightPanel, BorderLayout.EAST);

        /* ---------------- FOOTER (PERSONAL) ---------------- */

        footerPanel = new JPanel(new FlowLayout());
        footerPanel.setBackground(new Color(30,30,30));
        footerText = new JLabel("@AI-REINFORCED 2026");
        footerText.setForeground(Color.WHITE);
        footerPanel.add(footerText);
        personalMainPanel.add(footerPanel, BorderLayout.SOUTH);

        

        /* ---------------- HEADER  ---------------- */

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setPreferredSize(new Dimension(0,80));
        topPanel.setBackground(new Color(30,30,30));
        icon = new ImageIcon("AiLogo.png");
        img = icon.getImage();
        scaled = img.getScaledInstance(100,70,Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaled);

        headText = new JLabel("<html><h1>AI-REINFORCED</h1></html>");
        headText.setForeground(Color.WHITE);
        topPanel.add(new JLabel(scaledIcon));
        topPanel.add(headText);
        proMainPanel.add(topPanel, BorderLayout.NORTH);

        /* ---------------- LEFT ---------------- */

        leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setPreferredSize(new Dimension(180,0));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        leftBtnSize = new Dimension(170,40);
        proIndexField = new JTextField(5);
        leftPanel.add(createPanel("Index Number:", proIndexField));
        proIndexField.setText("Index");
        focus(proIndexField, "Index");

        proCheckType = new JButton("Check Plan Type");
        proCheckType.addActionListener(e -> proCheckType(proIndexField));
        
        
        
        btnDesign(proCheckType);
        btnHover(proCheckType);

        displayAll = new JButton("Display All");
        displayAll.addActionListener(e -> proDisplayAll());
        displayAll.setPreferredSize(leftBtnSize);
        
        export= new JButton("Export to File");
        export.addActionListener(e -> exportToFile());
        export.setPreferredSize(leftBtnSize);
        
        load = new JButton("Load from File");
        load.addActionListener(e -> loadToFile());
        load.setPreferredSize(leftBtnSize);

        clear = new JButton("Clear");
        clear.setPreferredSize(leftBtnSize);

        btnDesign(displayAll);
        btnDesign(clear);
        btnHover(displayAll);
        btnHover(clear);
        btnDesign(export);
        btnDesign(load);
        btnHover(export);
        btnHover(load);
       

        clear.addActionListener(e -> proClearText());
        leftPanel.add(proCheckType);
        leftPanel.add(displayAll);
        leftPanel.add(clear);
        leftPanel.add(export);
        leftPanel.add(load);
        proMainPanel.add(leftPanel, BorderLayout.WEST);

        /* ---------------- CENTER ---------------- */

        proCenterPanel = new JPanel();
        proCenterPanel.setLayout(new BoxLayout(proCenterPanel, BoxLayout.Y_AXIS));

        proModelField = new JTextField(20);
        proPriceField = new JTextField(20);
        proPriceField.setText("5999");
        proPriceField.setEditable(false);
        proPriceField.setBackground(Color.WHITE);
        proParameterField = new JTextField(20);
        proContextField = new JTextField(20);
        proSlotField = new JTextField(20);
        
        proResponseField = new JTextField(20);

        proCenterPanel.add(createPanel("Model Name:", proModelField));
        proModelField.setText("Enter Model Name");
        focus(proModelField, "Enter Model Name");
        proCenterPanel.add(createPanel("Price:", proPriceField));
        proCenterPanel.add(createPanel("Parameter Count:", proParameterField));
        proParameterField.setText("Enter Parameter Count");
        focus(proParameterField, "Enter Parameter Count");
        proCenterPanel.add(createPanel("Context Window:", proContextField));
        proContextField.setText("Enter Context Window");
        focus(proContextField, "Enter Context Window");
        proCenterPanel.add(createPanel("No of Slots:", proSlotField));
        proSlotField.setText("Enter Slots");
        focus(proSlotField, "Enter Slots");
        
        

        btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        
        back = new JButton("Back");
        btnDesign(back);
        btnHover(back);
        
        proSubmit = new JButton("Add Pro Plan");
        proSubmit.addActionListener(e -> addProMember());
        btnDesign(proSubmit);
        btnHover(proSubmit);
        btnPanel.add(back);
        back.addActionListener(e -> back());
        btnPanel.add(Box.createHorizontalStrut(180));
        btnPanel.add(proSubmit);
        proCenterPanel.add(btnPanel);
        proMainPanel.add(proCenterPanel, BorderLayout.CENTER);

        /* ---------------- RIGHT  ---------------- */

        proRightPanel = new JPanel(new FlowLayout());
        proRightPanel.setPreferredSize(new Dimension(280,0));
        proRightPanel.setBackground(Color.LIGHT_GRAY);
        JLabel slotsRemaining = new JLabel("Slots Remaining");
        slotsRemainingField = new JTextField(3);
        slotsRemainingField.setText("");
        slotsRemainingField.setEditable(false);
        String[] columns = {"S.No", "Team Members"};

        teamTableModel= new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };


        teamTable = new JTable(teamTableModel);
        teamTable.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                int row= teamTable.getSelectedRow();
                if (row!=-1)
                {
                    String name=teamTableModel.getValueAt(row,1).toString();
                    proMemberField.setText(name);
                    proMemberField.setEditable(false);
                }
            }
        });
        
        
        

        JScrollPane scroll = new JScrollPane(teamTable);
        teamTable.setPreferredScrollableViewportSize(new Dimension(200,150));
        
        proMemberField = new JTextField(10);
        proMemberField.setText("Enter Name");
        focus(proMemberField, "Enter Name");
        JPanel memberPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Dimension memberBtn = new Dimension(130,30);
        JButton addMember = new JButton("Add Member");
        addMember.setPreferredSize(memberBtn);
        JButton removeMember = new JButton("Remove Member");
        removeMember.setPreferredSize(memberBtn);
        removeMember.addActionListener(e-> removeTeamMember());
        addMember.addActionListener(e -> addTeamMember());
        
        
        btnDesign(addMember);
        btnHover(addMember);
        btnDesign(removeMember);
        btnHover(removeMember);
        memberPanel.add(addMember);
        memberPanel.add(removeMember);

        proRightPanel.add(slotsRemaining);
        proRightPanel.add(slotsRemainingField);
        proRightPanel.add(scroll);
        proRightPanel.add(createPanel("Team Member Name:", proMemberField));
        proRightPanel.add(memberPanel);

        proMainPanel.add(proRightPanel, BorderLayout.EAST);

        /* ---------------- FOOTER ---------------- */

        footerPanel = new JPanel(new FlowLayout());
        footerPanel.setBackground(new Color(30,30,30));
        footerText = new JLabel("@AI-REINFORCED 2026");
        footerText.setForeground(Color.WHITE);
        footerPanel.add(footerText);
        proMainPanel.add(footerPanel, BorderLayout.SOUTH);

        /* ---------------- CARD LAYOUT ---------------- */

        panel.add(loginPanel, "Login");
        panel.add(planPanel, "Plans");
        panel.add(personalMainPanel, "Personal Plan Setup");
        panel.add(proMainPanel, "Pro Plan Setup");

        add(panel);
        setVisible(true);
    }
    
    
    /* ---------------- LOGIN CHECK ---------------- */

    public void check()
    {
        String userText = userField.getText();
        String passText = new String(passField.getPassword());

        if(userText.equals("ai") && passText.equals("ai123"))
        {
            JOptionPane.showMessageDialog(this, "Login Successful");
            userField.setText("");
            passField.setText("");
            setSize(400,300);
            setLocationRelativeTo(null);
            cardLayout.show(panel, "Plans");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Login");
        }
    }
    
    public int getIndex(JTextField field)
    {
        int index=-1;
        
        try
        {
            if(field.getText().equals("Index") || field.getText().isEmpty())
            {
                throw new Exception("Enter an index");
            }
            int idx = Integer.parseInt(field.getText());
            if(idx < 0)
            {
                throw new Exception("Please Enter valid index");
            }
            else if(idx >= plan.size())
            {
                throw new Exception("Index out of range.");
            }
            return idx;
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Index must be a number");
            return -1;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return -1;
        }
    }
    
    public void prompt(JTextField field)
    {
    int index = getIndex(field);

    if (index != -1)
    {
        AIModel model = plan.get(index);

        if (model instanceof PersonalPlan)
        {
            PersonalPlan personal = (PersonalPlan) model;

            try
            {
                String promptText = personalPromptField.getText();
                if (!promptText.matches("[a-zA-Z0-9 ]+"))
                {
                    throw new Exception("Prompt must contain only letters");
                }
                int expectedLength = Integer.parseInt(personalResponseField.getText());
                if (expectedLength <= 0)
                {
                    throw new Exception("Response length must be positive");
                }

                JOptionPane.showMessageDialog(this,personal.usePrompt(promptText, expectedLength));

                availableTokenField.setText(Integer.toString(personal.getAvailableTokens()));
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this, "Invalid number input!");
            }
             catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }

        else if (model instanceof ProPlan)
        {
            ProPlan pro = (ProPlan) model;

            try
            {
                String promptText = proPromptField.getText();
                if (!promptText.matches("[a-zA-Z0-9 ]+"))
                {
                    throw new Exception("Prompt must contain only letters");
                }

                int expectedLength = Integer.parseInt(proResponseField.getText());

                if (expectedLength <= 0)
                {
                    throw new Exception("Response length must be positive");
                }

                JOptionPane.showMessageDialog(this,pro.usePrompt(promptText, expectedLength));
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this, "Response length must be a number!");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }
    }
    
    public void buyPrompt()
    {
    int idx = getIndex(personalIndexField);
    if (idx == -1)
    {
      return;  
    }

    AIModel ai = plan.get(idx);

    if (ai instanceof PersonalPlan)
    {
        PersonalPlan personal = (PersonalPlan) ai;

        String input = JOptionPane.showInputDialog(this, "Enter tokens you want to buy");

        if (input == null)
        {
        return;
        }

        try
        {
            int buy = Integer.parseInt(input);

            if (buy <= 0)
            {
                JOptionPane.showMessageDialog(this, "Enter positive value");
                return;
            }

            int updated = personal.getAvailableTokens() + buy;
            
            JOptionPane.showMessageDialog(this, personal.purchaseTokens(buy));

            availableTokenField.setText(String.valueOf(updated));
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid number");
        }
    }
    }

    
    
    private void showpersonalDashboard()
    {
        setSize(900, 600);
        setLocationRelativeTo(null);
        cardLayout.show(panel, "Personal Plan Setup");
    }

    private void showproDashboard()
    {
        setSize(900, 600);
        setLocationRelativeTo(null);
        cardLayout.show(panel, "Pro Plan Setup");
    }
    
    
    /* ---------------- BUTTON DESIGN ---------------- */

    public void btnDesign(JButton btnName)
    {
        btnName.setBackground(Button_Color);
        btnName.setForeground(Text_Color);
        btnName.setFocusPainted(false);
    }

    

    public void btnHover(JButton btnName)
    {
        btnName.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e)
            {
                btnName.setBackground(Button_Color);
            }
            public void mouseExited(MouseEvent e)
            {
                btnName.setBackground(Hover_Color);
            }
        });
    }
    
    /* ---------------- RESET ---------------- */

    public void reset()
    {
        userField.setText("");
        passField.setText("");
    }
    
    public void back()
    {
        setSize(400,300);
        setLocationRelativeTo(null);
        cardLayout.show(panel, "Plans");
    }
    
    public void focus(JTextField panelField, String text)
    {
        panelField.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e)
            {
                if(panelField.getText().equals(text))
                {
                    panelField.setText("");
                }
            }
            public void focusLost(FocusEvent e)
            {
                if(panelField.getText().isEmpty())
                {
                    panelField.setText(text);
                }
            }
        });
    }
    
    /* ---------------- PANEL CREATOR ---------------- */

    public JPanel createPanel(String label, JTextField field)
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(field);
        return panel;
    }
    
    /* ---------------- CLEAR TEXTFIELDS ---------------- */
    public void personalClearText()
    {
        personalModelField.setText("Enter Model Name");
        personalParameterField.setText("Enter Parameter Count");
        personalContextField.setText("Enter Context Window");
        personalTokenField.setText("Enter Available Tokens");
        availableTokenField.setText("");
        String idx = personalIndexField.getText();
        if (!idx.equals("Index") && idx.matches("[0-9]"))
        {

            int index = Integer.parseInt(idx);
            if (index <= plan.size()) 
            {
                personalPromptField.setText("Enter Prompt Text");
                personalResponseField.setText("Enter Response Length");
                if (personalCombine != null)
                {
                    centerPanel.remove(personalCombine);
                    centerPanel.revalidate();
                    centerPanel.repaint();
                }
                personalCheckType.setEnabled(true);
                personalModelField.setEditable(true);
                personalParameterField.setEditable(true);
                personalContextField.setEditable(true);
                personalTokenField.setEditable(true);
            }

        }
        personalIndexField.setText("Index");
    }

    public void proClearText()
    {
        proModelField.setText("Enter Model Name");
        proParameterField.setText("Enter Parameter Count");
        proContextField.setText("Enter Context Window");
        proSlotField.setText("Enter Slots");
        slotsRemainingField.setText("");
        String idx = proIndexField.getText();
        if (!idx.equals("Index") && idx.matches("[0-9]"))
        {
            int index = Integer.parseInt(idx);
            if (index <= plan.size()) 
            {
                proPromptField.setText("Enter Prompt Text");
                proResponseField.setText("Enter Response Length");
                if (proCombine != null)
                {
                    proCenterPanel.remove(proCombine);
                    proCenterPanel.revalidate();
                    proCenterPanel.repaint();
                }
                proCheckType.setEnabled(true);
                proModelField.setEditable(true);
                proParameterField.setEditable(true);
                proContextField.setEditable(true);
                proSlotField.setEditable(true);
            }

        }
        while(teamTableModel.getRowCount() > 0)
        {
            teamTableModel.removeRow(0);
        }
        proMemberField.setText("Enter Name");
        proIndexField.setText("Index");
    }
    
    public void personal(int idx)
    {
        if (idx == -1)
        {
            return;
        }
        AIModel ai = plan.get(idx);
        if(ai instanceof PersonalPlan)
        {
            personalPromptField = new JTextField(20);
            personalResponseField = new JTextField(20);
            personalPromptBtn = new JButton();
            personalCombine = createPromptPanel(personalPromptField,personalResponseField,personalPromptBtn,personalIndexField,centerPanel);
            personalCheckType.setEnabled(false);
        }
        else
        {
            return;
        }
        if(ai instanceof PersonalPlan)
        {
        PersonalPlan personal = (PersonalPlan) ai;

        personalModelField.setText(personal.getModelName());
        personalParameterField.setText(String.valueOf(personal.getParameterCount()));
        personalContextField.setText(String.valueOf(personal.getContextWindow()));
        personalTokenField.setText(String.valueOf(personal.getAvailableTokens()));
        availableTokenField.setText(String.valueOf(personal.getAvailableTokens()));

        personalModelField.setEditable(false);
        personalParameterField.setEditable(false);
        personalContextField.setEditable(false);
        personalTokenField.setEditable(false);
        }
    }
    public void pro(int idx)
    {
        if (idx == -1)
        {
        return;
        }
        AIModel ai = plan.get(idx);
        if(ai instanceof ProPlan)
        {
            proPromptField = new JTextField(20);
            proResponseField = new JTextField(20);
            proPromptBtn = new JButton();
            proCombine = createPromptPanel(proPromptField,proResponseField,proPromptBtn,proIndexField,proCenterPanel);
            proCheckType.setEnabled(false);
        }
        else 
        {
            return;
        }

       if(ai instanceof ProPlan)
        {
        ProPlan pro = (ProPlan) ai;

        proModelField.setText(pro.getModelName());
        proParameterField.setText(String.valueOf(pro.getParameterCount()));
        proContextField.setText(String.valueOf(pro.getContextWindow()));
        proSlotField.setText(String.valueOf(pro.getSlots()));
        slotsRemainingField.setText(String.valueOf(pro.getSlots()));

        proModelField.setEditable(false);
        proParameterField.setEditable(false);
        proContextField.setEditable(false);
        proSlotField.setEditable(false);
        }
    }
    
    public JPanel createPromptPanel(JTextField promptField,JTextField responseField,JButton promptBtn,JTextField indexField,JPanel parentPanel)
        {
        JPanel combine = new JPanel();
        combine.setLayout(new BoxLayout(combine, BoxLayout.Y_AXIS));
    
        // Prompt Panel
        JPanel promptPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel promptLabel = new JLabel("Prompt Text:");
        promptField.setText("Enter Prompt Text");
        focus(promptField, "Enter Prompt Text");
    
        promptPanel.add(promptLabel);
        promptPanel.add(promptField);
    
        // Response Panel
        JPanel responsePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel responseLabel = new JLabel("Response Length:");
        responseField.setText("Enter Response Length");
        focus(responseField, "Enter Response Length");
    
        responsePanel.add(responseLabel);
        responsePanel.add(responseField);
    
        // Button Panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        promptBtn.setText("Use Prompt");
    
        btnDesign(promptBtn);
        btnHover(promptBtn);
    
        promptBtn.addActionListener(e -> prompt(indexField));
    
        btnPanel.add(promptBtn);
    
        // Combine
        combine.add(promptPanel);
        combine.add(responsePanel);
        combine.add(btnPanel);
    
        parentPanel.add(combine);
    
        parentPanel.revalidate();
        parentPanel.repaint();
    
        return combine;
    }
    


 
    public void proCheckType(JTextField field)
    {
        int idx = getIndex(field);
        
        if(idx!=-1)
        {
            AIModel ai = plan.get(idx);
            if(ai instanceof ProPlan)
            {
                JOptionPane.showMessageDialog(this, "Pro Plan");
                pro(idx);
            }
            else if(ai instanceof PersonalPlan)
            {
                JOptionPane.showMessageDialog(this, "Personal Plan");
               
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Unknown Plan Type");
            }
        }
    }
    
    public void personalCheckType(JTextField field)
    {
        int idx = getIndex(field);
        
        if(idx!=-1)
        {
            AIModel ai = plan.get(idx);
            if(ai instanceof ProPlan)
            {
                JOptionPane.showMessageDialog(this, "Pro Plan");
            }
            else if(ai instanceof PersonalPlan)
            {
                JOptionPane.showMessageDialog(this, "Personal Plan");
                personal(idx);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Unknown Plan Type");
            }
        }
    }
            
    public boolean isValidInteger(String value)
    {
        return value.matches("^[0-9]+$");
    }
    
    
    public void personalDisplayAll()
    {
        if(plan.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No Members to Display");
        }
        else
        {
            JTextArea textArea = new JTextArea(10,30);
            textArea.setText("");
            for(AIModel ai : plan)
            {
                if(ai instanceof PersonalPlan)
                {
                    PersonalPlan member = (PersonalPlan) ai;
                    int idx = plan.indexOf(ai);
                    textArea.append("Index:" + idx + "\n");
                    textArea.append(member.display());
                    textArea.append("\n-------------------------------------\n");
                }
            }
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scroll = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scroll, "Personal Plan Members", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public void proDisplayAll()
    {
        if(plan.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No Members to Display");
        }
        else
        {
            JTextArea textArea = new JTextArea(10,30);
            textArea.setText("");
            for(AIModel ai : plan)
            {
                if(ai instanceof ProPlan)
                {
                    ProPlan member = (ProPlan) ai;
                    int idx = plan.indexOf(ai);
                    textArea.append("Index:" + idx + "\n");
                    textArea.append(member.display());
                    textArea.append("\n-------------------------------------\n");
                }
            }
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scroll = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scroll, "Pro Plan Members", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public void addTeamMember()
    {
    String name = proMemberField.getText();

    if(name.equals("Enter Name") || name.isEmpty())
    {
        JOptionPane.showMessageDialog(this, "Enter Name of Member");
        return;
    }

    if(proIndexField.getText().equals("Index") || proIndexField.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(this, "Enter valid index");
        return;
    }

    if(slotsRemainingField.getText().equals("0"))
    {
        JOptionPane.showMessageDialog(this, "No more slots available");
        return;
    }

    int index = getIndex(proIndexField);
    if(index == -1)
    {
    return;   
    }

    AIModel model = plan.get(index);

    if(model instanceof ProPlan)
    {
        ProPlan pro = (ProPlan) model;

        teamTableModel.addRow(new Object[]{teamTableModel.getRowCount() + 1, name});

        int slots = Integer.parseInt(slotsRemainingField.getText()) - 1;
        slotsRemainingField.setText(String.valueOf(slots));

        JOptionPane.showMessageDialog(this, pro.addTeamMember(name));
    }
    }
    
    
   public void removeTeamMember()
    {
    String name = proMemberField.getText();

    if(name.equals("Enter Name") || name.isEmpty())
    {
        JOptionPane.showMessageDialog(this, "Enter Name of Member");
        return;
    }

    if(proIndexField.getText().isEmpty() || proIndexField.getText().equals("Index"))
    {
        JOptionPane.showMessageDialog(this, "Enter valid Index");
        return;
    }

    int rowNumber = teamTable.getSelectedRow();
    if(rowNumber == -1)
    {
        JOptionPane.showMessageDialog(this, "Please select a row to remove");
        return;
    }

    try
    {
        int index = getIndex(proIndexField);
        AIModel model = plan.get(index);

        if(model instanceof ProPlan)
        {
            ProPlan proModel = (ProPlan) model;


            teamTableModel.removeRow(rowNumber);
            int slots = Integer.parseInt(slotsRemainingField.getText());
            slotsRemainingField.setText(String.valueOf(slots + 1));
            for(int i = 0; i < teamTableModel.getRowCount(); i++)
            {
                teamTableModel.setValueAt(i + 1, i, 0);
            }
            JOptionPane.showMessageDialog(this,proModel.removeTeamMember(name));
            
            proMemberField.setEditable(true);
            
        }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "Invalid index or operation failed");
    }
    }
    
    public void addPersonalMember()
    {
        String name = personalModelField.getText();
        String price = personalPriceField.getText();
        String parameter = personalParameterField.getText();
        String context = personalContextField.getText();
        String availableTokens = personalTokenField.getText();
        try
        {

            if(name.equals("Enter Model Name") || parameter.equals("Enter Parameter Count") ||
               context.equals("Enter Context Window") || availableTokens.equals("Enter Available Tokens"))
            {
                throw new Exception("Please Enter all fields");
            }
           
            if(name.isEmpty() || !name.matches("[a-zA-Z0-9\\-]+"))
            {
                throw new Exception("Please Enter Model Name");
            }
            if(!isValidInteger(parameter))
            {
                throw new Exception("Parameter must be a positive integer");
            }
            if(!isValidInteger(context))
            {
                throw new Exception("Context window must be a positive integer");
            }
            if(!isValidInteger(availableTokens))
            {
                throw new Exception("Prompts must be a positive integer");
            }
            double personalPrice = Double.parseDouble(price);
            int parameterCount = Integer.parseInt(parameter);
            int contextWindow = Integer.parseInt(context);
            int availableToken = Integer.parseInt(availableTokens);
            AIModel personal = new PersonalPlan(name, personalPrice, parameterCount, contextWindow, availableToken);
            plan.add(personal);
            availableTokenField.setText(String.valueOf(availableToken));
            JOptionPane.showMessageDialog(this, "You have been registered to Personal Plan");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }

    public void addProMember()
    {
        String name = proModelField.getText();
        String price = proPriceField.getText();
        String parameter = proParameterField.getText();
        String context = proContextField.getText();
        String slots = proSlotField.getText();

        try
        {
            if(name.equals("Enter Model Name") || parameter.equals("Enter Parameter Count") ||
               context.equals("Enter Context Window") || slots.equals("Enter Slots"))
            {
                throw new Exception("Please Enter all fields");
            }
           
            if(name.isEmpty() || !name.matches("[a-zA-Z0-9\\-]+"))
            {
                throw new Exception("Please Enter Valid Model Name");
            }
            if(!isValidInteger(parameter))
            {
                throw new Exception("Parameter must be a positive integer");
            }
            if(!isValidInteger(context))
            {
                throw new Exception("Context window must be a positive integer");
            }
            if(!isValidInteger(slots))
            {
                throw new Exception("Slots must be a positive integer");
            }
            double proPrice = Double.parseDouble(price);
            int parameterCount = Integer.parseInt(parameter);
            int contextWindow = Integer.parseInt(context);
            int slotNo = Integer.parseInt(slots);

            AIModel pro = new ProPlan(name, proPrice, parameterCount, contextWindow, slotNo);
            plan.add(pro);
           
            slotsRemainingField.setText(String.valueOf(slotNo));
            JOptionPane.showMessageDialog(this, "You have been registered to Pro Plan");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void exportToFile()
    {
        try(FileWriter writer=new FileWriter("AIModel.txt"))
        {
            if(plan.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "No data to export");
                return;
            }
            for(AIModel ai:plan)
            {
                if(ai instanceof PersonalPlan)
                {
                    PersonalPlan personal=(PersonalPlan) ai;
                    writer.write("PersonalPlan"+","+personal.getModelName()+","+personal.getPrice()+","+personal.getParameterCount()+","+personal.getContextWindow()+","+personal.getAvailableTokens()+"\n");
                }
                else if(ai instanceof ProPlan)
                {
                    ProPlan pro=(ProPlan) ai;
                    writer.write("ProPlan"+","+pro.getModelName()+","+pro.getPrice()+","+pro.getParameterCount()+","+pro.getContextWindow()+","+pro.getSlots()+"\n");
                }
            }
            JOptionPane.showMessageDialog(this,"Data Successfully exported");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "File not Created");
        }
    }
    
    public void loadToFile()
    {  
       plan.clear();
       try
       {
           BufferedReader read=new BufferedReader(new FileReader("AIModel.txt"));
           String line;
           while((line=read.readLine())!=null)
           {
               String[] d=line.split(",");
               if(d[0].equals("PersonalPlan"))
               {
                   plan.add(new PersonalPlan(d[1],Double.parseDouble(d[2]),Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5])));
               }
               else if(d[0].equals("ProPlan"))
               {
                   plan.add(new ProPlan(d[1],Double.parseDouble(d[2]),Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5])));
               }
           }
           JOptionPane.showMessageDialog(this,"Data Sucessfully Loaded");
       }
       catch(FileNotFoundException e)
        {
        JOptionPane.showMessageDialog(this,"File not found");            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"File cannot be read");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run(){
                new SubscriptionGUI();
            }
        });
    }
}
