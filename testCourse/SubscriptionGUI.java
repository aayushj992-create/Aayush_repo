package testCourse;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;


/**
 * Write a description of class SubscriptionGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubscriptionGUI extends JFrame
{
    private static final Color Button_Color=new Color(45,45,60);
    private static final Color Hover_Color=new Color(30,30,50);
    private static final Color Text_Color=Color.WHITE;
    private JPanel  loginPanel, planPanel,panel;
    private CardLayout cardLayout;
    private JPasswordField passField;
    
    private JLabel userName,password;
    private JTextField userField;
    private JButton loginBtn,resetBtn;
    private ArrayList<AIModel> plan=new ArrayList<>();
    
    public SubscriptionGUI() 
    {
        setTitle("AI Reinforced System");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout= new CardLayout();
        panel=new JPanel(cardLayout);

        loginPanel= new JPanel();
        planPanel= new JPanel(new BorderLayout());
    

        /* ---------------- LOGIN PANEL ---------------- */
        
        
        loginPanel.setBackground(new Color(30,30,30));
        loginPanel.setPreferredSize(new Dimension(500,400));
        JPanel infoPanel=new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.Y_AXIS));
        
        
        
        JPanel buttonPanel=new JPanel(new GridLayout());
        Dimension loginBtnSize=new Dimension(150,40);
        
        JPanel namePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        userName = new JLabel("Username");
        userField = new JTextField(15);
       
        JPanel passPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        
        setVisible(true);
       
    }
    
    public void reset()
    {
        userField.setText("");
        passField.setText("");
    }
    public void check()
    {
        String userText=userField.getText();
        String passText=new String(passField.getPassword());

        if(userText.equals("ai") && passText.equals("ai123"))
        {
            JOptionPane.showMessageDialog(this,"Login Successful");

            userField.setText("");
            passField.setText("");
            setSize(400,300);
            setLocationRelativeTo(null);
            cardLayout.show(planPanel,"Plans");
        }

        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Login");
        }
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
    public void btnDesign(JButton btnName)
    {
        btnName.setBackground(Button_Color);
        btnName.setForeground(Text_Color);
        btnName.setFocusPainted(false);
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