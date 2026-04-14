package Coursework;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class SubscriptionGUI extends JFrame
{
    private static final Color Button_Color=new Color(45,45,60);
    private static final Color Hover_Color=new Color(30,30,50);
    private static final Color Text_Color=Color.WHITE;
    private JPanel panel, personalmainPanel, loginPanel, planPanel,promainPanel;
    private CardLayout cardLayout;

    private JButton resetBtn, loginBtn;
     
    private DefaultTableModel teamTableModel;
    private JTable teamTable;
    private JLabel userName, password;

    private JPasswordField passField;
    private JTextField userField;

    private JTextField personalModelField, personalPriceField, personalParameterField, personalQuotaField,
            personalContextField, personalPromptTextField, personalResponseField, personalIndexField,promptCount;

    private JButton addTeamMember, removeTeamMember, displayAll, clear,
            personalBtn, proBtn, checkType;
    private JPanel btnPanel;
    private JButton proSubmit, back, personalSubmit;
    private ArrayList<AIModel> plan = new ArrayList<>();
    
    /*head*/
    private ImageIcon icon, scaledIcon;
    private Image img, scaled;
    private JLabel headText;
    
    /*left*/
    private JPanel leftPanel;
    private Dimension leftBtnSize;
    
    private JPanel proCenterPanel;
    
    private JTextField proModelField, proPriceField, proParameterField, proMemberField, proSlotField,
            proContextField, proPromptTextField, proResponseField, proIndexField;
    
    private JTextField slotsRemainingField;
    /*footer*/
    private JPanel footerPanel;
    private JPanel proRightPanel;
    private JLabel footerText;

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
        personalmainPanel = new JPanel(new BorderLayout());
        promainPanel = new JPanel(new BorderLayout());

        /* ---------------- LOGIN PANEL ---------------- */

        loginPanel.setBackground(new Color(30,30,30));
        loginPanel.setPreferredSize(new Dimension(500,400));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel(new GridLayout());
        Dimension loginBtnSize = new Dimension(150,40);
        
        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(0,200));
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userName = new JLabel("Username");
        userField = new JTextField(15);
       
        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        password = new JLabel("Password");
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

        personalmainPanel.add(topPanel, BorderLayout.NORTH);

        /* ---------------- LEFT PANEL (PERSONAL) ---------------- */

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setPreferredSize(new Dimension(180,0));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        leftBtnSize = new Dimension(170,40);
        personalIndexField = new JTextField(5);
        leftPanel.add(createPanel("Index Number:", personalIndexField));
        personalIndexField.setText("Index");
        focus(personalIndexField, "Index");

        checkType = new JButton("Check Plan Type");
        checkType.addActionListener(e -> checkType(personalIndexField.getText()));
        
        btnDesign(checkType);
        btnHover(checkType);

        displayAll = new JButton("Display All");
        displayAll.setPreferredSize(leftBtnSize);
        displayAll.addActionListener(e -> personalDisplayAll());

        clear = new JButton("Clear");
        clear.setPreferredSize(leftBtnSize);

        btnDesign(displayAll);
        btnDesign(clear);
        btnHover(displayAll);
        btnHover(clear);

        clear.addActionListener(e -> personalClearText());
        leftPanel.add(checkType);
        leftPanel.add(displayAll);
        leftPanel.add(clear);

        personalmainPanel.add(leftPanel, BorderLayout.WEST);

        /* ---------------- CENTER PANEL (PERSONAL) ---------------- */

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        personalModelField = new JTextField(20);
        personalPriceField = new JTextField(20);
        personalPriceField.setText("10000");
        personalPriceField.setEditable(false);
        personalPriceField.setBackground(Color.WHITE);

        personalParameterField = new JTextField(20);
        personalContextField = new JTextField(20);
        personalQuotaField = new JTextField(20);
        personalPromptTextField = new JTextField(20);
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
        centerPanel.add(createPanel("Prompt Quota:", personalQuotaField));
        personalQuotaField.setText("Enter Personal Quota");
        focus(personalQuotaField, "Enter Personal Quota");
        centerPanel.add(createPanel("Prompt Text:", personalPromptTextField));
        personalPromptTextField.setText("Enter Prompt Text");
        focus(personalPromptTextField, "Enter Prompt Text");
        centerPanel.add(createPanel("Response Length:", personalResponseField));
        personalResponseField.setText("Enter Response Length");
        focus(personalResponseField, "Enter Response Length");

        btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        
        back = new JButton("Back");
        btnDesign(back);
        btnHover(back);
        
        personalSubmit = new JButton("Submit");
        personalSubmit.addActionListener(e -> addPersonalMember());
        btnDesign(personalSubmit);
        btnHover(personalSubmit);
        btnPanel.add(back);
        back.addActionListener(e -> back());
        btnPanel.add(Box.createHorizontalStrut(180));
        btnPanel.add(personalSubmit);
        centerPanel.add(btnPanel);
        personalmainPanel.add(centerPanel, BorderLayout.CENTER);

        /* ---------------- RIGHT PANEL (PERSONAL) ---------------- */

        JPanel rightPanel = new JPanel(new FlowLayout());
        rightPanel.setPreferredSize(new Dimension(180,0));
        rightPanel.setBackground(Color.LIGHT_GRAY);

        JLabel remainingPrompts = new JLabel("Remaining Prompts:");
        promptCount = new JTextField(3);
        promptCount.setText("");
        promptCount.setEditable(false);

        rightPanel.add(remainingPrompts);
        rightPanel.add(promptCount);
        personalmainPanel.add(rightPanel, BorderLayout.EAST);

        /* ---------------- FOOTER (PERSONAL) ---------------- */

        footerPanel = new JPanel(new FlowLayout());
        footerPanel.setBackground(new Color(30,30,30));
        footerText = new JLabel("@AI-REINFORCED 2026");
        footerText.setForeground(Color.WHITE);
        footerPanel.add(footerText);
        personalmainPanel.add(footerPanel, BorderLayout.SOUTH);

        /* ============ PRO PLAN SETUP ============ */

        /* ---------------- HEADER (PRO) ---------------- */

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
        promainPanel.add(topPanel, BorderLayout.NORTH);

        /* ---------------- LEFT PANEL (PRO) ---------------- */

        leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setPreferredSize(new Dimension(180,0));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        leftBtnSize = new Dimension(170,40);
        proIndexField = new JTextField(5);
        leftPanel.add(createPanel("Index Number:", proIndexField));
        proIndexField.setText("Index");
        focus(proIndexField, "Index");

        checkType = new JButton("Check Plan Type");
        checkType.addActionListener(e -> checkType(proIndexField.getText()));
        
        btnDesign(checkType);
        btnHover(checkType);

        displayAll = new JButton("Display All");
        displayAll.addActionListener(e -> proDisplayAll());
        displayAll.setPreferredSize(leftBtnSize);

        clear = new JButton("Clear");
        clear.setPreferredSize(leftBtnSize);

        btnDesign(displayAll);
        btnDesign(clear);
        btnHover(displayAll);
        btnHover(clear);

        clear.addActionListener(e -> proClearText());
        leftPanel.add(checkType);
        leftPanel.add(displayAll);
        leftPanel.add(clear);
        promainPanel.add(leftPanel, BorderLayout.WEST);

        /* ---------------- CENTER PANEL (PRO) ---------------- */

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
        proPromptTextField = new JTextField(20);
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
        proCenterPanel.add(createPanel("Prompt Text:", proPromptTextField));
        proPromptTextField.setText("Enter Prompt Text");
        focus(proPromptTextField, "Enter Prompt Text");
        proCenterPanel.add(createPanel("Response Length:", proResponseField));
        proResponseField.setText("Enter Response Length");
        focus(proResponseField, "Enter Response Length");

        btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        
        back = new JButton("Back");
        btnDesign(back);
        btnHover(back);
        
        proSubmit = new JButton("Submit");
        proSubmit.addActionListener(e -> addProMember());
        btnDesign(proSubmit);
        btnHover(proSubmit);
        btnPanel.add(back);
        back.addActionListener(e -> back());
        btnPanel.add(Box.createHorizontalStrut(180));
        btnPanel.add(proSubmit);
        proCenterPanel.add(btnPanel);
        promainPanel.add(proCenterPanel, BorderLayout.CENTER);

        /* ---------------- RIGHT PANEL (PRO) ---------------- */

        proRightPanel = new JPanel(new FlowLayout());
        proRightPanel.setPreferredSize(new Dimension(280,0));
        proRightPanel.setBackground(Color.LIGHT_GRAY);
        JLabel slotsRemaining = new JLabel("Slots Remaining");
        slotsRemainingField = new JTextField(3);
        slotsRemainingField.setText("");
        slotsRemainingField.setEditable(false);
        String[] columns = {"S.No", "Team Members"};

        teamTableModel = new DefaultTableModel(columns, 0);
        teamTable = new JTable(teamTableModel);

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

        promainPanel.add(proRightPanel, BorderLayout.EAST);

        /* ---------------- FOOTER (PRO) ---------------- */

        footerPanel = new JPanel(new FlowLayout());
        footerPanel.setBackground(new Color(30,30,30));
        footerText = new JLabel("@AI-REINFORCED 2026");
        footerText.setForeground(Color.WHITE);
        footerPanel.add(footerText);
        promainPanel.add(footerPanel, BorderLayout.SOUTH);

        /* ---------------- CARD LAYOUT ---------------- */

        panel.add(loginPanel, "Login");
        panel.add(planPanel, "Plans");
        panel.add(personalmainPanel, "Personal Plan Setup");
        panel.add(promainPanel, "Pro Plan Setup");

        add(panel);
        setVisible(true);
    }

    public void checkType(String index)
    {
        try
        {
            if(index.isEmpty() || index.equals("Index"))
            {
                JOptionPane.showMessageDialog(this, "Please enter an index number");
                return;
            }
            int idx = Integer.parseInt(index);
            if(idx < 0 || idx >= plan.size())
            {
                JOptionPane.showMessageDialog(this, "Index out of range. Valid range: 0 to " + (plan.size() - 1));
                return;
            }
            AIModel ai = plan.get(idx);
            if(ai instanceof ProPlan)
            {
                JOptionPane.showMessageDialog(this, "Pro Plan");
            }
            else if(ai instanceof PersonalPlan)
            {
                JOptionPane.showMessageDialog(this, "Personal Plan");
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Index must be a valid number");
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

    public void back()
    {
        setSize(400,300);
        setLocationRelativeTo(null);
        cardLayout.show(panel, "Plans");
    }

    public void focus(JTextField panelField, String abc)
    {
        panelField.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e)
            {
                if(panelField.getText().equals(abc))
                {
                    panelField.setText("");
                }
            }
            public void focusLost(FocusEvent e)
            {
                if(panelField.getText().isEmpty())
                {
                    panelField.setText(abc);
                }
            }
        });
    }

    public void addTeamMember()
    {
        String name = proMemberField.getText();
        if(name.equals("Enter Name"))
        {
            JOptionPane.showMessageDialog(this, "Enter Name of Member");
        }
        
        else if(!slotsRemainingField.getText().isEmpty() && !slotsRemainingField.getText().equals("0"))
        {
            int rowNumber = teamTableModel.getRowCount() + 1;
            teamTableModel.addRow(new Object[]{rowNumber, name});
            int slots = Integer.parseInt(slotsRemainingField.getText());
            int newValue = slots - 1;
            slotsRemainingField.setText(Integer.toString(newValue));
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No more slots Available");
        }
    }

    /* ---------------- BUTTON DESIGN ---------------- */

    public void btnDesign(JButton btnName)
    {
        btnName.setBackground(Button_Color);
        btnName.setForeground(Text_Color);
        btnName.setFocusPainted(false);
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

    /* ---------------- RESET ---------------- */

    public void reset()
    {
        userField.setText("");
        passField.setText("");
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
        personalModelField.setText("");
        personalParameterField.setText("");
        personalContextField.setText("");
        personalQuotaField.setText("");
        personalPromptTextField.setText("");
        personalResponseField.setText("");
        promptCount.setText("");
    }

    public void proClearText()
    {
        proModelField.setText("");
        proParameterField.setText("");
        proContextField.setText("");
        proSlotField.setText("");
        proPromptTextField.setText("");
        proResponseField.setText("");
        proMemberField.setText("");
        slotsRemainingField.setText("");
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
            
            if(name.isEmpty())
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
            if(!isValidInteger(slots))
            {
                throw new Exception("Slots must be a positive integer");
            }
            double proPrice = Double.parseDouble(price);
            int parameterCount = Integer.parseInt(parameter);
            int contextWindow = Integer.parseInt(context);
            int slotNo = Integer.parseInt(slots);

            AIModel pro1 = new ProPlan(name, proPrice, parameterCount, contextWindow, slotNo);
            plan.add(pro1);
            
            slotsRemainingField.setText(String.valueOf(slotNo));
            JOptionPane.showMessageDialog(this, "You have been registered to Pro Plan");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public boolean isValidInteger(String value)
    {
        return value.matches("^[0-9]+$");
    }

    public void addPersonalMember()
    {
        String name = personalModelField.getText();
        String price = personalPriceField.getText();
        String parameter = personalParameterField.getText();
        String context = personalContextField.getText();
        String Prompts = personalQuotaField.getText();

        try
        {

            if(name.equals("Enter Model Name") || parameter.equals("Enter Parameter Count") ||
               context.equals("Enter Context Window") || Prompts.equals("Enter Personal Quota"))
            {
                throw new Exception("Please Enter all fields");
            }
            
            if(name.isEmpty())
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
            if(!isValidInteger(Prompts))
            {
                throw new Exception("Prompts must be a positive integer");
            }
            double personalPrice = Double.parseDouble(price);
            int parameterCount = Integer.parseInt(parameter);
            int contextWindow = Integer.parseInt(context);
            int remainingPrompts = Integer.parseInt(Prompts);
            AIModel personal1 = new PersonalPlan(name, personalPrice, parameterCount, contextWindow, remainingPrompts);
            plan.add(personal1);
            promptCount.setText(String.valueOf(remainingPrompts));
            JOptionPane.showMessageDialog(this, "You have been registered to Personal Plan");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    
    public int getIndex(String index)
    {
        try
        {
            int idx = Integer.parseInt(index);
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