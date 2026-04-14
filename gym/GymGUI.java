package gym;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// GymGUI class creates a graphical user interface for managing gym memberships
public class GymGUI implements ActionListener {

    // Declare frames for different pages
    JFrame login_page, member_page, regular_memberpage, premium_memberpage;

    // Declare labels for form fields
    JLabel login, user, password, membertype, r_id, r_name, r_location, r_phone,
           r_email, r_gender, r_DOB, r_membershipStartDate, r_plan,
           r_price, r_referralSource, r_removalReason, p_id, p_name, p_location,
           p_phone, p_email, p_gender, p_DOB, p_membershipStartDate, p_personaltrainer,
           p_price, p_paidamount;

    // Declare text fields for user input
    JTextField userfield, r_idfield, r_namefield, r_locationfield, r_phonefield, r_emailfield, r_pricefield,
               p_idfield, p_namefield, p_locationfield, p_phonefield, p_emailfield,
               p_personaltrainerfield, p_pricefield, p_paidamountfield;

    // Password field for secure login
    JPasswordField passwordfield;

    // Declare buttons for various actions
    JButton loginbutton, regularbutton, premiumbutton, r_activatebutton,
            r_deactivatebutton, r_markattendancebutton, r_submitbutton,
            r_displaybutton, r_resetbutton, r_revertbutton, r_detailbutton, r_backbutton,
            r_upgradebutton, r_savebutton, r_readbutton,
            p_activatebutton, p_deactivatebutton, p_markattendancebutton,
            p_discountbutton, p_payduesbutton, p_submitbutton,
            p_displaybutton, p_resetbutton, p_revertbutton, p_backbutton, p_savebutton, p_readbutton;

    // Panels to organize components
    JPanel regularmember_panel, premiummember_panel;

    // Radio buttons for gender selection
    JRadioButton r_male, r_female, r_other, p_male, p_female, p_other;

    // Groups to ensure single gender selection
    ButtonGroup r_gendergroup, p_gendergroup;

    // Combo boxes for selecting dates, plans, and referral sources
    JComboBox<String> r_day_combobox, r_month_combobox, r_year_combobox,
                      r_startday_combobox, r_startmonth_combobox, r_startyear_combobox, plan_combobox,
                      referralSource_combobox, p_day_combobox, p_month_combobox,
                      p_year_combobox, p_startday_combobox, p_startmonth_combobox, p_startyear_combobox;

    // Text area for removal reason
    JTextArea r_removalReasonarea;

    // ArrayList to store gym members
    ArrayList<GymMember> gym = new ArrayList<GymMember>();

    // Constructor to initialize the GUI
    public GymGUI() {

        // Setup login page
        login_page = new JFrame("GymFit Login");

        login = new JLabel("Login");
        login.setBounds(152, 25, 230, 38);
        login.setFont(new Font("Arial", Font.BOLD, 21));
        login.setForeground(Color.BLACK);
        login.setBackground(new Color(153, 153, 153));

        user = new JLabel("Username: ");
        user.setBounds(70, 78, 190, 22);
        user.setFont(new Font("Arial", Font.BOLD, 14));

        userfield = new JTextField();
        userfield.setBounds(154, 78, 146, 23);

        password = new JLabel("Password: ");
        password.setBounds(70, 130, 190, 22);
        password.setFont(new Font("Arial", Font.BOLD, 14));

        passwordfield = new JPasswordField();
        passwordfield.setBounds(154, 130, 146, 23);

        loginbutton = new JButton("Login");
        loginbutton.setBounds(152, 167, 83, 25);

        // Add components to login page
        login_page.add(login);
        login_page.add(user);
        login_page.add(password);
        login_page.add(userfield);
        login_page.add(passwordfield);
        login_page.add(loginbutton);

        // Register login button listener
        loginbutton.addActionListener(this);

        login_page.setLayout(null);
        login_page.setVisible(true);
        login_page.setBounds(0, 0, 390, 240);
        login_page.setResizable(false);
        login_page.setLocationRelativeTo(null);

        // Setup member type selection page
        member_page = new JFrame("Select Member Type");

        membertype = new JLabel("Choose Member Type");
        membertype.setBounds(95, 14, 170, 33);
        membertype.setFont(new Font("Arial", Font.BOLD, 16));
        membertype.setBackground(new Color(153, 153, 153));

        // Regular and Premium member buttons
        regularbutton = new JButton("Regular Member");
        regularbutton.setBounds(65, 69, 229, 43);
        regularbutton.setBackground(Color.WHITE);

        premiumbutton = new JButton("Premium Member");
        premiumbutton.setBounds(65, 133, 229, 43);
        premiumbutton.setBackground(Color.WHITE);

        member_page.add(membertype);
        member_page.add(regularbutton);
        member_page.add(premiumbutton);

        regularbutton.addActionListener(this);
        premiumbutton.addActionListener(this);

        member_page.setLayout(null);
        member_page.setVisible(false);
        member_page.setBounds(0, 0, 370, 240);
        member_page.setResizable(false);
        member_page.setLocationRelativeTo(null);

        // Setup regular member page
        regular_memberpage = new JFrame("Regular Member");

        regularmember_panel = new JPanel();
        regularmember_panel.setBounds(0, 15, 800, 490);
        regularmember_panel.setBackground(new Color(153, 153, 153));
        regularmember_panel.setLayout(null);

        r_id = new JLabel("ID: ");
        r_id.setBounds(30, 20, 120, 30);
        r_id.setForeground(Color.WHITE);

        r_idfield = new JTextField();
        r_idfield.setBounds(160, 20, 180, 30);

        r_name = new JLabel("Name: ");
        r_name.setBounds(400, 20, 120, 30);
        r_name.setForeground(Color.WHITE);

        r_namefield = new JTextField();
        r_namefield.setBounds(530, 20, 180, 30);

        r_location = new JLabel("Location: ");
        r_location.setBounds(30, 60, 120, 30);
        r_location.setForeground(Color.WHITE);

        r_locationfield = new JTextField();
        r_locationfield.setBounds(160, 60, 180, 30);

        r_phone = new JLabel("Phone: ");
        r_phone.setBounds(30, 110, 120, 30);
        r_phone.setForeground(Color.WHITE);

        r_phonefield = new JTextField();
        r_phonefield.setBounds(160, 110, 180, 30);

        r_email = new JLabel("Email: ");
        r_email.setBounds(30, 150, 120, 30);
        r_email.setForeground(Color.WHITE);

        r_emailfield = new JTextField();
        r_emailfield.setBounds(160, 150, 180, 30);

        r_gender = new JLabel("Gender: ");
        r_gender.setBounds(400, 110, 120, 30);
        r_gender.setForeground(Color.WHITE);

        r_male = new JRadioButton("Male");
        r_male.setBounds(530, 110, 60, 30);
        r_female = new JRadioButton("Female");
        r_female.setBounds(600, 110, 80, 30);
        r_other = new JRadioButton("Other");
        r_other.setBounds(690, 110, 70, 30);

        r_gendergroup = new ButtonGroup();
        r_gendergroup.add(r_male);
        r_gendergroup.add(r_female);
        r_gendergroup.add(r_other);

        r_DOB = new JLabel("Date of Birth: ");
        r_DOB.setBounds(400, 60, 120, 30);
        r_DOB.setForeground(Color.WHITE);

        String[] r_day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                          "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        r_day_combobox = new JComboBox(r_day);
        r_day_combobox.setBounds(530, 60, 50, 30);

        String[] r_month = {"January","February","March","April","May","June","July",
                            "August","September","October","November","December"};
        r_month_combobox = new JComboBox(r_month);
        r_month_combobox.setBounds(590, 60, 100, 30);

        String[] r_year = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
                           "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019",
                           "2020","2021","2022","2023","2024","2025"};
        r_year_combobox = new JComboBox(r_year);
        r_year_combobox.setBounds(700, 60, 80, 30);

        r_membershipStartDate = new JLabel("Start Date: ");
        r_membershipStartDate.setBounds(400, 150, 120, 30);
        r_membershipStartDate.setForeground(Color.WHITE);

        String[] r_days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                           "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        r_startday_combobox = new JComboBox(r_days);
        r_startday_combobox.setBounds(530, 150, 50, 30);

        String[] r_months = {"January","February","March","April","May","June","July",
                             "August","September","October","November","December"};
        r_startmonth_combobox = new JComboBox(r_months);
        r_startmonth_combobox.setBounds(590, 150, 100, 30);

        String[] r_years = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
                            "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019",
                            "2020","2021","2022","2023","2024","2025"};
        r_startyear_combobox = new JComboBox(r_years);
        r_startyear_combobox.setBounds(700, 150, 80, 30);

        r_plan = new JLabel("Plan: ");
        r_plan.setBounds(30, 190, 120, 30);
        r_plan.setForeground(Color.WHITE);

        String[] plans = {"Basic", "Standard", "Deluxe"};
        plan_combobox = new JComboBox(plans);
        plan_combobox.setBounds(160, 190, 180, 30);

        r_price = new JLabel("Price");
        r_price.setBounds(400, 190, 120, 30);
        r_price.setForeground(Color.WHITE);

        r_pricefield = new JTextField("6500");
        r_pricefield.setBounds(530, 190, 180, 30);
        r_pricefield.setEditable(false);

        r_referralSource = new JLabel("Referral Source: ");
        r_referralSource.setBounds(30, 240, 120, 30);
        r_referralSource.setForeground(Color.WHITE);

        String[] r_referralsource = {"Social Media", "Family", "Friend", "Others"};
        referralSource_combobox = new JComboBox(r_referralsource);
        referralSource_combobox.setBounds(150, 242, 180, 30);

        r_removalReason = new JLabel("Removal Reason: ");
        r_removalReason.setBounds(400, 240, 120, 30);
        r_removalReason.setForeground(Color.WHITE);

        r_removalReasonarea = new JTextArea();
        r_removalReasonarea.setBounds(530, 240, 250, 60);
        r_removalReasonarea.setEditable(false);

        r_activatebutton = new JButton("Activate");
        r_activatebutton.setBounds(30, 310, 140, 30);

        r_deactivatebutton = new JButton("Deactivate");
        r_deactivatebutton.setBounds(180, 310, 140, 30);

        r_markattendancebutton = new JButton("Mark Attendance");
        r_markattendancebutton.setBounds(330, 310, 140, 30);

        r_detailbutton = new JButton("Detail");
        r_detailbutton.setBounds(480, 310, 140, 30);

        r_upgradebutton = new JButton("Upgrade Plan");
        r_upgradebutton.setBounds(630, 310, 140, 30);

        r_submitbutton = new JButton("Submit");
        r_submitbutton.setBounds(30, 350, 140, 30);

        r_displaybutton = new JButton("Display");
        r_displaybutton.setBounds(180, 350, 140, 30);

        r_resetbutton = new JButton("Reset");
        r_resetbutton.setBounds(330, 350, 140, 30);

        r_revertbutton = new JButton("Revert");
        r_revertbutton.setBounds(480, 350, 140, 30);

        r_savebutton = new JButton("Save to File");
        r_savebutton.setBounds(30, 390, 140, 30);

        r_readbutton = new JButton("Read from File");
        r_readbutton.setBounds(180, 390, 140, 30);

        r_backbutton = new JButton("Back");
        r_backbutton.setBounds(630, 390, 140, 30);

        regularmember_panel.add(r_id);
        regularmember_panel.add(r_idfield);
        regularmember_panel.add(r_name);
        regularmember_panel.add(r_namefield);
        regularmember_panel.add(r_location);
        regularmember_panel.add(r_locationfield);
        regularmember_panel.add(r_phone);
        regularmember_panel.add(r_phonefield);
        regularmember_panel.add(r_email);
        regularmember_panel.add(r_emailfield);
        regularmember_panel.add(r_gender);
        regularmember_panel.add(r_male);
        regularmember_panel.add(r_female);
        regularmember_panel.add(r_other);
        regularmember_panel.add(r_DOB);
        regularmember_panel.add(r_day_combobox);
        regularmember_panel.add(r_month_combobox);
        regularmember_panel.add(r_year_combobox);
        regularmember_panel.add(r_membershipStartDate);
        regularmember_panel.add(r_startday_combobox);
        regularmember_panel.add(r_startmonth_combobox);
        regularmember_panel.add(r_startyear_combobox);
        regularmember_panel.add(r_plan);
        regularmember_panel.add(plan_combobox);
        regularmember_panel.add(r_price);
        regularmember_panel.add(r_pricefield);
        regularmember_panel.add(r_referralSource);
        regularmember_panel.add(referralSource_combobox);
        regularmember_panel.add(r_removalReason);
        regularmember_panel.add(r_removalReasonarea);
        regularmember_panel.add(r_activatebutton);
        regularmember_panel.add(r_deactivatebutton);
        regularmember_panel.add(r_markattendancebutton);
        regularmember_panel.add(r_detailbutton);
        regularmember_panel.add(r_upgradebutton);
        regularmember_panel.add(r_submitbutton);
        regularmember_panel.add(r_displaybutton);
        regularmember_panel.add(r_resetbutton);
        regularmember_panel.add(r_revertbutton);
        regularmember_panel.add(r_backbutton);
        regularmember_panel.add(r_savebutton);
        regularmember_panel.add(r_readbutton);

        r_activatebutton.addActionListener(this);
        r_deactivatebutton.addActionListener(this);
        r_markattendancebutton.addActionListener(this);
        r_detailbutton.addActionListener(this);
        r_upgradebutton.addActionListener(this);
        r_submitbutton.addActionListener(this);
        r_displaybutton.addActionListener(this);
        r_resetbutton.addActionListener(this);
        r_revertbutton.addActionListener(this);
        r_backbutton.addActionListener(this);
        r_savebutton.addActionListener(this);
        r_readbutton.addActionListener(this);

        regular_memberpage.add(regularmember_panel);
        regular_memberpage.setLayout(null);
        regular_memberpage.setVisible(false);
        regular_memberpage.setBounds(0, 0, 810, 550);
        regular_memberpage.setResizable(false);
        regular_memberpage.setLocationRelativeTo(null);

        // Setup premium member page
        premium_memberpage = new JFrame("Premium Member");

        premiummember_panel = new JPanel();
        premiummember_panel.setBounds(0, 15, 800, 490);
        premiummember_panel.setBackground(new Color(153, 153, 153));
        premiummember_panel.setLayout(null);

        p_id = new JLabel("ID: ");
        p_id.setBounds(30, 20, 120, 30);
        p_id.setForeground(Color.WHITE);

        p_idfield = new JTextField();
        p_idfield.setBounds(160, 20, 180, 30);

        p_name = new JLabel("Name: ");
        p_name.setBounds(400, 20, 120, 30);
        p_name.setForeground(Color.WHITE);

        p_namefield = new JTextField();
        p_namefield.setBounds(530, 20, 180, 30);

        p_location = new JLabel("Location: ");
        p_location.setBounds(30, 60, 120, 30);
        p_location.setForeground(Color.WHITE);

        p_locationfield = new JTextField();
        p_locationfield.setBounds(160, 60, 180, 30);

        p_phone = new JLabel("Phone: ");
        p_phone.setBounds(30, 110, 120, 30);
        p_phone.setForeground(Color.WHITE);

        p_phonefield = new JTextField();
        p_phonefield.setBounds(160, 110, 180, 30);

        p_email = new JLabel("Email: ");
        p_email.setBounds(30, 150, 120, 30);
        p_email.setForeground(Color.WHITE);

        p_emailfield = new JTextField();
        p_emailfield.setBounds(160, 150, 180, 30);

        p_gender = new JLabel("Gender: ");
        p_gender.setBounds(400, 110, 120, 30);
        p_gender.setForeground(Color.WHITE);

        p_male = new JRadioButton("Male");
        p_male.setBounds(530, 110, 60, 30);
        p_female = new JRadioButton("Female");
        p_female.setBounds(600, 110, 80, 30);
        p_other = new JRadioButton("Other");
        p_other.setBounds(690, 110, 70, 30);

        p_gendergroup = new ButtonGroup();
        p_gendergroup.add(p_male);
        p_gendergroup.add(p_female);
        p_gendergroup.add(p_other);

        p_DOB = new JLabel("Date of Birth: ");
        p_DOB.setBounds(400, 60, 120, 30);
        p_DOB.setForeground(Color.WHITE);

        String[] p_day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                          "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        p_day_combobox = new JComboBox(p_day);
        p_day_combobox.setBounds(530, 60, 50, 30);

        String[] p_month = {"January","February","March","April","May","June","July",
                            "August","September","October","November","December"};
        p_month_combobox = new JComboBox(p_month);
        p_month_combobox.setBounds(590, 60, 100, 30);

        String[] p_year = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
                           "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019",
                           "2020","2021","2022","2023","2024","2025"};
        p_year_combobox = new JComboBox(p_year);
        p_year_combobox.setBounds(700, 60, 80, 30);

        p_membershipStartDate = new JLabel("Start Date: ");
        p_membershipStartDate.setBounds(400, 150, 120, 30);
        p_membershipStartDate.setForeground(Color.WHITE);

        String[] p_days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                           "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        p_startday_combobox = new JComboBox(p_days);
        p_startday_combobox.setBounds(530, 150, 50, 30);

        String[] p_months = {"January","February","March","April","May","June","July",
                             "August","September","October","November","December"};
        p_startmonth_combobox = new JComboBox(p_months);
        p_startmonth_combobox.setBounds(590, 150, 100, 30);

        // Note: "2010" was missing from the original p_years array — added back here
        String[] p_years = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
                            "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019",
                            "2020","2021","2022","2023","2024","2025"};
        p_startyear_combobox = new JComboBox(p_years);
        p_startyear_combobox.setBounds(700, 150, 80, 30);

        p_personaltrainer = new JLabel("Personal Trainer: ");
        p_personaltrainer.setBounds(30, 200, 120, 30);
        p_personaltrainer.setForeground(Color.WHITE);

        p_personaltrainerfield = new JTextField();
        p_personaltrainerfield.setBounds(170, 200, 180, 30);

        p_price = new JLabel("Price: ");
        p_price.setBounds(400, 200, 120, 30);
        p_price.setForeground(Color.WHITE);

        p_pricefield = new JTextField();
        p_pricefield.setText("50000");
        p_pricefield.setBounds(530, 200, 90, 30);
        p_pricefield.setFont(new Font("Arial", Font.BOLD, 12));
        p_pricefield.setEditable(false);

        p_paidamount = new JLabel("Paid Amount: ");
        p_paidamount.setBounds(30, 240, 120, 30);
        p_paidamount.setForeground(Color.WHITE);

        p_paidamountfield = new JTextField();
        p_paidamountfield.setBounds(170, 240, 180, 30);

        p_activatebutton = new JButton("Activate");
        p_activatebutton.setBounds(30, 310, 140, 30);

        p_deactivatebutton = new JButton("Deactivate");
        p_deactivatebutton.setBounds(180, 310, 140, 30);

        p_markattendancebutton = new JButton("Mark Attendance");
        p_markattendancebutton.setBounds(330, 310, 140, 30);

        p_discountbutton = new JButton("Discount");
        p_discountbutton.setBounds(480, 310, 140, 30);

        p_payduesbutton = new JButton("Pay Dues");
        p_payduesbutton.setBounds(630, 310, 140, 30);

        p_submitbutton = new JButton("Submit");
        p_submitbutton.setBounds(30, 350, 140, 30);

        p_displaybutton = new JButton("Display");
        p_displaybutton.setBounds(180, 350, 140, 30);

        p_resetbutton = new JButton("Reset");
        p_resetbutton.setBounds(330, 350, 140, 30);

        p_revertbutton = new JButton("Revert");
        p_revertbutton.setBounds(480, 350, 140, 30);

        p_savebutton = new JButton("Save to File");
        p_savebutton.setBounds(30, 390, 140, 30);

        p_readbutton = new JButton("Read from File");
        p_readbutton.setBounds(180, 390, 140, 30);

        p_backbutton = new JButton("Back");
        p_backbutton.setBounds(630, 390, 140, 30);

        premiummember_panel.add(p_id);
        premiummember_panel.add(p_idfield);
        premiummember_panel.add(p_name);
        premiummember_panel.add(p_namefield);
        premiummember_panel.add(p_location);
        premiummember_panel.add(p_locationfield);
        premiummember_panel.add(p_phone);
        premiummember_panel.add(p_phonefield);
        premiummember_panel.add(p_email);
        premiummember_panel.add(p_emailfield);
        premiummember_panel.add(p_gender);
        premiummember_panel.add(p_male);
        premiummember_panel.add(p_female);
        premiummember_panel.add(p_other);
        premiummember_panel.add(p_DOB);
        premiummember_panel.add(p_day_combobox);
        premiummember_panel.add(p_month_combobox);
        premiummember_panel.add(p_year_combobox);
        premiummember_panel.add(p_membershipStartDate);
        premiummember_panel.add(p_startday_combobox);
        premiummember_panel.add(p_startmonth_combobox);
        premiummember_panel.add(p_startyear_combobox);
        premiummember_panel.add(p_personaltrainer);
        premiummember_panel.add(p_personaltrainerfield);
        premiummember_panel.add(p_price);
        premiummember_panel.add(p_pricefield);
        premiummember_panel.add(p_paidamount);
        premiummember_panel.add(p_paidamountfield);
        premiummember_panel.add(p_activatebutton);
        premiummember_panel.add(p_deactivatebutton);
        premiummember_panel.add(p_markattendancebutton);
        premiummember_panel.add(p_discountbutton);
        premiummember_panel.add(p_payduesbutton);
        premiummember_panel.add(p_submitbutton);
        premiummember_panel.add(p_displaybutton);
        premiummember_panel.add(p_resetbutton);
        premiummember_panel.add(p_revertbutton);
        premiummember_panel.add(p_backbutton);
        premiummember_panel.add(p_savebutton);
        premiummember_panel.add(p_readbutton);

        p_activatebutton.addActionListener(this);
        p_deactivatebutton.addActionListener(this);
        p_markattendancebutton.addActionListener(this);
        p_discountbutton.addActionListener(this);
        p_payduesbutton.addActionListener(this);
        p_submitbutton.addActionListener(this);
        p_displaybutton.addActionListener(this);
        p_resetbutton.addActionListener(this);
        p_revertbutton.addActionListener(this);
        p_backbutton.addActionListener(this);
        p_savebutton.addActionListener(this);
        p_readbutton.addActionListener(this);

        premium_memberpage.add(premiummember_panel);
        premium_memberpage.setLayout(null);
        premium_memberpage.setVisible(false);
        premium_memberpage.setBounds(0, 0, 810, 550);
        premium_memberpage.setResizable(false);
        premium_memberpage.setLocationRelativeTo(null);
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent g) {

        // Login button
        if (g.getSource() == loginbutton) {
            String username = userfield.getText();
            String password = new String(passwordfield.getPassword());
            if (username.equals("admin") && password.equals("1234")) {
                login_page.setVisible(false);
                JOptionPane.showMessageDialog(login_page, "Login successfully!");
                member_page.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(login_page, "Invalid credentials!", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Navigate to regular member page
        if (g.getSource() == regularbutton) {
            member_page.setVisible(false);
            JOptionPane.showMessageDialog(member_page, "Regular member selected successfully!");
            regular_memberpage.setVisible(true);
        }

        // Navigate to premium member page
        if (g.getSource() == premiumbutton) {
            member_page.setVisible(false);
            JOptionPane.showMessageDialog(member_page, "Premium member selected successfully!");
            premium_memberpage.setVisible(true);
        }

        // Return to member type selection from regular member page
        if (g.getSource() == r_backbutton) {
            regular_memberpage.setVisible(false);
            member_page.setVisible(true);
        }

        // Return to member type selection from premium member page
        if (g.getSource() == p_backbutton) {
            premium_memberpage.setVisible(false);
            member_page.setVisible(true);
        }

        // Activate regular member
        if (g.getSource() == r_activatebutton) {
            try {
                int id = Integer.parseInt(r_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (i.getActiveStatus()) {
                            JOptionPane.showMessageDialog(regular_memberpage, "Membership is already active!");
                        } else {
                            i.activateMembership();
                            JOptionPane.showMessageDialog(regular_memberpage, "Membership activated successfully!");
                        }
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(regular_memberpage, "Member not found.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Invalid input! Please enter valid number for ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Deactivate regular member
        if (g.getSource() == r_deactivatebutton) {
            try {
                int id = Integer.parseInt(r_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (!i.getActiveStatus()) {
                            JOptionPane.showMessageDialog(regular_memberpage, "Membership is already inactive!");
                        } else {
                            i.deactivateMembership();
                            JOptionPane.showMessageDialog(regular_memberpage, "Membership deactivated successfully!");
                        }
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(regular_memberpage, "Member not found.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Invalid input! Please enter a valid number for ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Mark attendance for regular member
        if (g.getSource() == r_markattendancebutton) {
            try {
                int id = Integer.parseInt(r_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (i instanceof RegularMember) {
                            RegularMember member = (RegularMember) i;
                            if (member.getActiveStatus()) {
                                member.markAttendance();
                                String message = "Attendance marked successfully!\n"
                                        + "Total Attendance: " + member.getAttendance() + "\n"
                                        + "Loyalty Points: " + member.getLoyaltyPoints() + "\n"
                                        + "Eligible for Upgrade: " + (member.getAttendance() < 5);
                                if (member.getAttendance() <5) {
                                    message += "\nMember is now eligible for plan upgrade!";
                                }
                                JOptionPane.showMessageDialog(regular_memberpage, message);
                            } else {
                                JOptionPane.showMessageDialog(regular_memberpage, "Membership inactive. Cannot mark attendance");
                            }
                            break;
                        }
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(regular_memberpage, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Invalid input! Please enter a valid number for ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Something went wrong: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Display plan details
        if (g.getSource() == r_detailbutton) {
            String planDetails = "Regular Member Plans:\n" + "Basic: 6500\n" + "Standard: 12500\n" + "Deluxe: 18500";
            JOptionPane.showMessageDialog(regular_memberpage, planDetails, "Plan Details", JOptionPane.INFORMATION_MESSAGE);
        }

        // Upgrade regular member plan
        if (g.getSource() == r_upgradebutton) {
            try {
                int id = Integer.parseInt(r_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (!(i instanceof RegularMember)) {
                            JOptionPane.showMessageDialog(regular_memberpage, "Member is not a Regular Member!", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        RegularMember member = (RegularMember) i;
                        if (!member.getActiveStatus()) {
                            JOptionPane.showMessageDialog(regular_memberpage, "Cannot upgrade plan. Membership is inactive.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (member.getAttendance() <30) {
                            JOptionPane.showMessageDialog(regular_memberpage, "Cannot upgrade plan. Attendance is less than 30.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        String currentPlan = member.getPlan();
                        String nextPlan = "";
                        if (currentPlan.equals("Basic")) {
                            nextPlan = "Standard";
                        } else if (currentPlan.equals("Standard")) {
                            nextPlan = "Deluxe";
                        } else {
                            JOptionPane.showMessageDialog(regular_memberpage, "Already on the Deluxe plan. No further upgrades available.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        String newPlan = member.upgradePlan(nextPlan);
                        r_pricefield.setText(String.valueOf(member.getPrice()));
                        plan_combobox.setSelectedItem(newPlan);
                        JOptionPane.showMessageDialog(regular_memberpage, "Plan upgraded to " + newPlan + "\nPrice: " + member.getPrice(), "Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(regular_memberpage, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Submit new regular member
        if (g.getSource() == r_submitbutton) {
            try {
                int id = Integer.parseInt(r_idfield.getText());
                boolean memberexists = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberexists = true;
                        break;
                    }
                }
                if (memberexists) {
                    JOptionPane.showMessageDialog(regular_memberpage, "Member already exists.");
                } else {
                    String name = r_namefield.getText();
                    String location = r_locationfield.getText();
                    String phone = r_phonefield.getText();
                    String email = r_emailfield.getText();
                    if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || r_gendergroup.getSelection() == null) {
                        JOptionPane.showMessageDialog(regular_memberpage, "Please fill in all the fields.");
                        return;
                    }
                    if (phone.length() != 10) {
                        JOptionPane.showMessageDialog(regular_memberpage, "Phone must be 10 digits!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String gender = "";
                    if (r_male.isSelected()) {
                        gender = "Male";
                    } else if (r_female.isSelected()) {
                        gender = "Female";
                    } else if (r_other.isSelected()) {
                        gender = "Other";
                    }
                    String r_day = (String) r_day_combobox.getSelectedItem();
                    String r_month = (String) r_month_combobox.getSelectedItem();
                    String r_year = (String) r_year_combobox.getSelectedItem();
                    String DOB = r_day + " " + r_month + " " + r_year;
                    String r_days = (String) r_startday_combobox.getSelectedItem();
                    String r_months = (String) r_startmonth_combobox.getSelectedItem();
                    String r_years = (String) r_startyear_combobox.getSelectedItem();
                    String membershipStartDate = r_days + " " + r_months + " " + r_years;
                    String referralSource = (String) referralSource_combobox.getSelectedItem();
                    RegularMember i = new RegularMember(id, name, location, phone, email, gender, DOB, membershipStartDate, referralSource);
                    gym.add(i);
                    r_removalReasonarea.setText("");
                    JOptionPane.showMessageDialog(regular_memberpage, "Member Added Successfully!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Invalid Input!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Invalid", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Display all regular members
        if (g.getSource() == r_displaybutton) {
            if (gym.isEmpty()) {
                JOptionPane.showMessageDialog(regular_memberpage, "No Members to Display!");
            } else {
                String all = "";
                for (GymMember i : gym) {
                    if (i instanceof RegularMember) {
                        RegularMember member = (RegularMember) i;
                        all += "ID: " + member.getId() + "\n";
                        all += "Name: " + member.getName() + "\n";
                        all += "Location: " + member.getLocation() + "\n";
                        all += "Phone: " + member.getPhone() + "\n";
                        all += "Email: " + member.getEmail() + "\n";
                        all += "Gender: " + member.getGender() + "\n";
                        all += "Date of Birth: " + member.getDOB() + "\n";
                        all += "Membership Start Date: " + member.getMembershipStartDate() + "\n";
                        all += "Attendance: " + member.getAttendance() + "\n";
                        all += "Loyalty Points: " + member.getLoyaltyPoints() + "\n";
                        all += "Active Status: " + member.getActiveStatus() + "\n";
                        all += "Eligible for Upgrade: " + member.getIsEligibleForUpgrade() + "\n";
                        all += "Plan: " + member.getPlan() + "\n";
                        all += "Price: " + member.getPrice() + "\n";
                        all += "Referral Source: " + member.getReferralSource() + "\n";
                        all += "Removal Reason: " + member.getRemovalReason() + "\n";
                        all += "---------------------------\n";
                    }
                }
                JTextArea area = new JTextArea(all);
                area.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(area);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(regular_memberpage, scrollPane, "Regular Member Details", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Reset regular member form
        if (g.getSource() == r_resetbutton) {
            r_idfield.setText("");
            r_namefield.setText("");
            r_locationfield.setText("");
            r_phonefield.setText("");
            r_emailfield.setText("");
            r_gendergroup.clearSelection();
            plan_combobox.setSelectedIndex(0);
            r_pricefield.setText("6500");
            referralSource_combobox.setSelectedIndex(0);
            r_removalReasonarea.setText("");
            r_day_combobox.setSelectedIndex(0);
            r_month_combobox.setSelectedIndex(0);
            r_year_combobox.setSelectedIndex(0);
            r_startday_combobox.setSelectedIndex(0);
            r_startmonth_combobox.setSelectedIndex(0);
            r_startyear_combobox.setSelectedIndex(0);
            JOptionPane.showMessageDialog(regular_memberpage, "Reset Successfully!");
        }

        // Revert regular member
        if (g.getSource() == r_revertbutton) {
            try {
                int id = Integer.parseInt(r_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (i instanceof RegularMember) {
                            RegularMember member = (RegularMember) i;
                            String reason = JOptionPane.showInputDialog(regular_memberpage, "Enter your removal reason");
                            if (reason == null || reason.isEmpty()) {
                                JOptionPane.showMessageDialog(regular_memberpage, "Removal reason cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            member.revertRegularMember(reason);
                            r_pricefield.setText(String.valueOf(member.getPrice()));
                            plan_combobox.setSelectedItem(member.getPlan());
                            referralSource_combobox.setSelectedItem(member.getReferralSource());
                            r_removalReasonarea.setText(reason);
                            JOptionPane.showMessageDialog(regular_memberpage, "Regular member reverted.\nReason: " + reason, "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(regular_memberpage, "No match with type", "ERROR", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(regular_memberpage, "Member not found.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(regular_memberpage, "Please enter a valid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Save regular member details to file
        if (g.getSource() == r_savebutton) {
            String selectedType = "Regular";
            try {
                FileWriter writes = new FileWriter("MemberDetails.txt");
                writes.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-15s%n",
                        "ID", "Name", "Location", "Phone", "Email", "Membership Start Date", "Attendance", "LoyaltyPoints", "ActiveStatus"));
                for (GymMember y1 : gym) {
                    if (selectedType.equalsIgnoreCase("Regular") && y1 instanceof RegularMember) {
                        RegularMember member2 = (RegularMember) y1;
                        writes.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10d %-15.2f %-10s%n",
                                member2.getId(), member2.getName(), member2.getLocation(), member2.getPhone(), member2.getEmail(),
                                member2.getMembershipStartDate(), member2.getAttendance(), member2.getLoyaltyPoints(),
                                member2.getActiveStatus() ? "Activate" : "Deactivate"));
                    }
                }
                writes.close();
                JOptionPane.showMessageDialog(regular_memberpage, "Member Details saved successfully.", "Member Details", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException f) {
                JOptionPane.showMessageDialog(null, "Error in writing to file: " + f.getMessage());
            }
        }

        // Read regular member details from file
        if (g.getSource() == r_readbutton) {
            try {
                FileReader reads = new FileReader("MemberDetails.txt");
                String content = "";
                int character;
                while ((character = reads.read()) != -1) {
                    content += (char) character;
                }
                reads.close();
                if (content.length() == 0) {
                    JOptionPane.showMessageDialog(regular_memberpage, "No Members to Display!");
                    return;
                }
                String[] lines = content.split("\n");
                if (lines.length <= 1) {
                    JOptionPane.showMessageDialog(regular_memberpage, "No Members to Display!");
                    return;
                }
                String displayText = "REGULAR MEMBER DETAILS\n" + "--------------------\n";
                for (int i = 1; i < lines.length; i++) {
                    String line = lines[i];
                    if (line.isEmpty()) continue;
                    String[] fields = line.split("\\s+");
                    if (fields.length < 9) continue;
                    String id = fields[0];
                    String name = fields[1];
                    String location = fields[2];
                    String phone = fields[3];
                    String email = fields[4];
                    String membershipStartDate = fields[5] + " " + fields[6] + " " + fields[7];
                    String attendance = fields[8];
                    String loyaltyPoints = fields[9];
                    String activeStatus = fields[10].equalsIgnoreCase("Activate") ? "true" : "false";
                    displayText += "ID: " + id + "\n";
                    displayText += "NAME: " + name + "\n";
                    displayText += "LOCATION: " + location + "\n";
                    displayText += "PHONE: " + phone + "\n";
                    displayText += "EMAIL: " + email + "\n";
                    displayText += "GENDER: " + "Female" + "\n";
                    displayText += "DOB: " + "1 January 2000" + "\n";
                    displayText += "START DATE: " + membershipStartDate + "\n";
                    displayText += "PLAN: " + "Basic" + "\n";
                    displayText += "PRICE: " + "6500.0" + "\n";
                    displayText += "REFERRAL SOURCE: " + "Others" + "\n";
                    displayText += "REMOVAL REASON: " + "NONE" + "\n";
                    displayText += "ATTENDANCE: " + attendance + "\n";
                    displayText += "LOYALTY POINTS: " + loyaltyPoints + "\n";
                    displayText += "ACTIVE STATUS: " + activeStatus + "\n";
                    displayText += "--------------------\n";
                }
                JTextArea area = new JTextArea(displayText);
                area.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(area);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(regular_memberpage, scrollPane, "Regular Member Details", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException f) {
                JOptionPane.showMessageDialog(null, "Error in reading file: " + f.getMessage());
            }
        }

        // Activate premium member
        if (g.getSource() == p_activatebutton) {
            try {
                int id = Integer.parseInt(p_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (i.getActiveStatus()) {
                            JOptionPane.showMessageDialog(premium_memberpage, "Membership is already active!");
                        } else {
                            i.activateMembership();
                            JOptionPane.showMessageDialog(premium_memberpage, "Membership activated successfully!");
                        }
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(premium_memberpage, "Member not found");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Invalid input! Please enter a valid number for ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Deactivate premium member
        if (g.getSource() == p_deactivatebutton) {
            try {
                int id = Integer.parseInt(p_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (!i.getActiveStatus()) {
                            JOptionPane.showMessageDialog(premium_memberpage, "Membership is already inactive!");
                        } else {
                            i.deactivateMembership();
                            JOptionPane.showMessageDialog(premium_memberpage, "Membership deactivated successfully!");
                        }
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(premium_memberpage, "Member not found");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Invalid input! Please enter a valid number for ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Mark attendance for premium member
        if (g.getSource() == p_markattendancebutton) {
            try {
                int id = Integer.parseInt(p_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (i instanceof PremiumMember) {
                            PremiumMember member = (PremiumMember) i;
                            if (member.getActiveStatus()) {
                                member.markAttendance();
                                JOptionPane.showMessageDialog(premium_memberpage,
                                        "Attendance marked successfully!\n"
                                        + "Total Attendance: " + member.getAttendance() + "\n"
                                        + "Loyalty Points: " + member.getLoyaltyPoints());
                            } else {
                                JOptionPane.showMessageDialog(premium_memberpage, "Membership inactive. Cannot mark attendance");
                            }
                            break;
                        }
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(premium_memberpage, "Member not found");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Invalid input! Please enter a valid number for ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Something went wrong: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Apply discount for premium member
        if (g.getSource() == p_discountbutton) {
            try {
                int id = Integer.parseInt(p_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (i instanceof PremiumMember) {
                            PremiumMember member = (PremiumMember) i;
                            if (!member.getIsFullPayment()) {
                                JOptionPane.showMessageDialog(premium_memberpage, "Full payment of 50000.0 is required before applying discount!", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            member.calculateDiscount();
                            double discount = member.getDiscountAmount();
                            double adjustedPrice = 50000.0 - discount;
                            JOptionPane.showMessageDialog(premium_memberpage,
                                    "Discount Applied!\nDiscount Amount: " + discount + "\nAdjusted Total Price: " + adjustedPrice,
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(premium_memberpage, "Member not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Invalid input! Please enter a valid number for ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Pay dues for premium member
        if (g.getSource() == p_payduesbutton) {
            try {
                int id = Integer.parseInt(p_idfield.getText());
                boolean memberFound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberFound = true;
                        if (i instanceof PremiumMember) {
                            PremiumMember member = (PremiumMember) i;
                            String input = p_paidamountfield.getText();
                            if (input.isEmpty()) {
                                JOptionPane.showMessageDialog(premium_memberpage, "Payment amount cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            double amount = Double.parseDouble(input);
                            if (amount <= 0) {
                                JOptionPane.showMessageDialog(premium_memberpage, "Payment amount must be positive!", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            String result = member.payDueAmount(amount);
                            double newPaid = member.getPaidAmount();
                            double newRemaining = member.getPremiumCharge() - newPaid;
                            String status = member.getIsFullPayment() ? "Yes" : "No";
                            JOptionPane.showMessageDialog(premium_memberpage,
                                    result + "\nTotal Paid: " + newPaid + "\nRemaining Dues: " + newRemaining + "\nFully Paid: " + status,
                                    "Payment Details", JOptionPane.INFORMATION_MESSAGE);
                            p_paidamountfield.setText("");
                        } else {
                            JOptionPane.showMessageDialog(premium_memberpage, "Member is not a Premium Member!", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    }
                }
                if (!memberFound) {
                    JOptionPane.showMessageDialog(premium_memberpage, "Member not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Submit new premium member
        if (g.getSource() == p_submitbutton) {
            try {
                int id = Integer.parseInt(p_idfield.getText());
                boolean memberexists = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberexists = true;
                        break;
                    }
                }
                if (memberexists) {
                    JOptionPane.showMessageDialog(premium_memberpage, "Member already exists.");
                } else {
                    String name = p_namefield.getText();
                    String location = p_locationfield.getText();
                    String phone = p_phonefield.getText();
                    String email = p_emailfield.getText();
                    String personalTrainer = p_personaltrainerfield.getText();
                    if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || personalTrainer.isEmpty() || p_gendergroup.getSelection() == null) {
                        JOptionPane.showMessageDialog(premium_memberpage, "Please fill in all the fields.");
                        return;
                    }
                    if (phone.length() != 10) {
                        JOptionPane.showMessageDialog(premium_memberpage, "Phone must be 10 digits!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String gender = "";
                    if (p_male.isSelected()) {
                        gender = "Male";
                    } else if (p_female.isSelected()) {
                        gender = "Female";
                    } else if (p_other.isSelected()) {
                        gender = "Other";
                    }
                    String p_day = (String) p_day_combobox.getSelectedItem();
                    String p_month = (String) p_month_combobox.getSelectedItem();
                    String p_year = (String) p_year_combobox.getSelectedItem();
                    String DOB = p_day + " " + p_month + " " + p_year;
                    String p_days = (String) p_startday_combobox.getSelectedItem();
                    String p_months = (String) p_startmonth_combobox.getSelectedItem();
                    String p_years = (String) p_startyear_combobox.getSelectedItem();
                    String membershipStartDate = p_days + " " + p_months + " " + p_years;
                    PremiumMember i = new PremiumMember(id, name, location, phone, email, gender, DOB, membershipStartDate, personalTrainer);
                    gym.add(i);
                    JOptionPane.showMessageDialog(premium_memberpage, "Member Added Successfully!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Invalid Input!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Invalid", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Display all premium members
        if (g.getSource() == p_displaybutton) {
            if (gym.isEmpty()) {
                JOptionPane.showMessageDialog(premium_memberpage, "No Members to Display!");
            } else {
                String all = "";
                for (GymMember i : gym) {
                    if (i instanceof PremiumMember) {
                        PremiumMember member = (PremiumMember) i;
                        all += "ID: " + member.getId() + "\n";
                        all += "Name: " + member.getName() + "\n";
                        all += "Location: " + member.getLocation() + "\n";
                        all += "Phone: " + member.getPhone() + "\n";
                        all += "Email: " + member.getEmail() + "\n";
                        all += "Gender: " + member.getGender() + "\n";
                        all += "Date of Birth: " + member.getDOB() + "\n";
                        all += "Membership Start Date: " + member.getMembershipStartDate() + "\n";
                        all += "Attendance: " + member.getAttendance() + "\n";
                        all += "Loyalty Points: " + member.getLoyaltyPoints() + "\n";
                        all += "Active Status: " + member.getActiveStatus() + "\n";
                        all += "Personal Trainer: " + member.getPersonalTrainer() + "\n";
                        all += "Paid Amount: " + member.getPaidAmount() + "\n";
                        all += "Full Payment Status: " + member.getIsFullPayment() + "\n";
                        all += "Discount Amount: " + member.getDiscountAmount() + "\n";
                        all += "---------------------------\n";
                    }
                }
                JTextArea area = new JTextArea(all);
                area.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(area);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(premium_memberpage, scrollPane, "Premium Member Details", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Reset premium member form
        if (g.getSource() == p_resetbutton) {
            p_idfield.setText("");
            p_namefield.setText("");
            p_locationfield.setText("");
            p_phonefield.setText("");
            p_emailfield.setText("");
            p_gendergroup.clearSelection();
            p_pricefield.setText("50000");
            p_day_combobox.setSelectedIndex(0);
            p_month_combobox.setSelectedIndex(0);
            p_year_combobox.setSelectedIndex(0);
            p_startday_combobox.setSelectedIndex(0);
            p_startmonth_combobox.setSelectedIndex(0);
            p_startyear_combobox.setSelectedIndex(0);
            p_personaltrainerfield.setText("");
            JOptionPane.showMessageDialog(premium_memberpage, "Reset Successfully!");
        }

        // Revert premium member
        if (g.getSource() == p_revertbutton) {
            try {
                int id = Integer.parseInt(p_idfield.getText());
                boolean memberfound = false;
                for (GymMember i : gym) {
                    if (i.getId() == id) {
                        memberfound = true;
                        if (i instanceof PremiumMember) {
                            PremiumMember member = (PremiumMember) i;
                            member.revertPremiumMember();
                            p_personaltrainerfield.setText("");
                            JOptionPane.showMessageDialog(premium_memberpage, "Premium member reverted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            JOptionPane.showMessageDialog(premium_memberpage,
                                    "Payment reverted!\nPaid Amount: " + member.getPaidAmount() + "\nDiscount Amount: " + member.getDiscountAmount());
                        } else {
                            JOptionPane.showMessageDialog(premium_memberpage, "No match with type", "ERROR", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    }
                }
                if (!memberfound) {
                    JOptionPane.showMessageDialog(premium_memberpage, "Member not found.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(premium_memberpage, "Please enter a valid ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Save premium member details to file
        if (g.getSource() == p_savebutton) {
            try {
                FileWriter writes = new FileWriter("MemberDetails.txt");
                writes.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-15s %-10s %-15s%n",
                        "ID", "Name", "Location", "Phone", "Email", "Membership Start Date", "Paid Amount", "Attendance", "LoyaltyPoints", "ActiveStatus", "FullPayment"));
                for (GymMember y1 : gym) {
                    if (y1 instanceof PremiumMember) {
                        PremiumMember member3 = (PremiumMember) y1;
                        writes.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10.2f %-10d %-15.2f %-10s %-15s%n",
                                member3.getId(), member3.getName(), member3.getLocation(), member3.getPhone(), member3.getEmail(),
                                member3.getMembershipStartDate(), member3.getPaidAmount(), member3.getAttendance(),
                                member3.getLoyaltyPoints(), member3.getActiveStatus() ? "Activate" : "Deactivate",
                                member3.getIsFullPayment() ? "Yes" : "No"));
                    }
                }
                writes.close();
                JOptionPane.showMessageDialog(premium_memberpage, "Premium Member Details saved successfully.", "Member Details", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException f) {
                JOptionPane.showMessageDialog(null, "Error in writing to file: " + f.getMessage());
            }
        }

        // Read premium member details from file
        if (g.getSource() == p_readbutton) {
            try {
                FileReader reads = new FileReader("MemberDetails.txt");
                String content = "";
                int character;
                while ((character = reads.read()) != -1) {
                    content += (char) character;
                }
                reads.close();
                if (content.length() == 0) {
                    JOptionPane.showMessageDialog(premium_memberpage, "No Members to Display!");
                    return;
                }
                String[] lines = content.split("\n");
                if (lines.length <= 1) {
                    JOptionPane.showMessageDialog(premium_memberpage, "No Members to Display!");
                    return;
                }
                String displayText = "PREMIUM MEMBER DETAILS\n" + "--------------------\n";
                for (int i = 1; i < lines.length; i++) {
                    String line = lines[i];
                    if (line.isEmpty()) continue;
                    String[] fields = line.split("\\s+");
                    if (fields.length < 11) continue;
                    String id = fields[0];
                    String name = fields[1];
                    String location = fields[2];
                    String phone = fields[3];
                    String email = fields[4];
                    String membershipStartDate = fields[5] + " " + fields[6] + " " + fields[7];
                    String paidAmount = fields[8];
                    String attendance = fields[9];
                    String loyaltyPoints = fields[10];
                    String activeStatus = fields[11].equalsIgnoreCase("Activate") ? "true" : "false";
                    String fullPayment = fields[12].equalsIgnoreCase("Yes") ? "true" : "false";
                    displayText += "ID: " + id + "\n";
                    displayText += "NAME: " + name + "\n";
                    displayText += "LOCATION: " + location + "\n";
                    displayText += "PHONE: " + phone + "\n";
                    displayText += "EMAIL: " + email + "\n";
                    displayText += "GENDER: " + "Female" + "\n";
                    displayText += "DOB: " + "1 January 2000" + "\n";
                    displayText += "START DATE: " + membershipStartDate + "\n";
                    displayText += "PERSONAL TRAINER: " + "N/A" + "\n";
                    displayText += "PRICE: " + "50000.0" + "\n";
                    displayText += "PAID AMOUNT: " + paidAmount + "\n";
                    displayText += "DISCOUNT AMOUNT: " + "0.0" + "\n";
                    displayText += "ATTENDANCE: " + attendance + "\n";
                    displayText += "LOYALTY POINTS: " + loyaltyPoints + "\n";
                    displayText += "ACTIVE STATUS: " + activeStatus + "\n";
                    displayText += "FULL PAYMENT: " + fullPayment + "\n";
                    displayText += "--------------------\n";
                }
                JTextArea area = new JTextArea(displayText);
                area.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(area);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(premium_memberpage, scrollPane, "Premium Member Details", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException f) {
                JOptionPane.showMessageDialog(null, "Error in reading file: " + f.getMessage());
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new GymGUI();
    }
}