package week_23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class VehicleForm extends JFrame implements ActionListener 
{
    private JRadioButton carBtn, bikeBtn;
    private JPanel formPanel, topPanel, bottomPanel, btnPanel, rightPanel;

    private JTextField nameField, speedField, seatsField, fuelField, gearField;
    private JTextField distanceField, tankField, indexField;

    private JCheckBox carrierBox;

    private JButton submitBtn, showInfoBtn, operateBtn, displayAllBtn, checkTypeBtn, clearBtn,loadBtn,clearAllBtn;

    private JTextArea displayArea;

    private String selectedType = "";
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public VehicleForm() 
    {
        setTitle("Vehicle Casting Demo");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TOP PANEL
        topPanel = new JPanel(new FlowLayout());

        carBtn = new JRadioButton("Car");
        bikeBtn = new JRadioButton("Bike");

        ButtonGroup bg = new ButtonGroup();
        bg.add(carBtn);
        bg.add(bikeBtn);

        topPanel.add(new JLabel("Select Vehicle Type:"));
        topPanel.add(carBtn);
        topPanel.add(bikeBtn);

        add(topPanel, BorderLayout.NORTH);

        carBtn.addActionListener(e -> showForm("Car"));
        bikeBtn.addActionListener(e -> showForm("Bike"));

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(formPanel, BorderLayout.CENTER);

        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Controls"));

        JLabel indexLabel = new JLabel("Vehicle Index:");
        indexField = new JTextField(5);
        indexField.setMaximumSize(new Dimension(100,30));

        indexLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        indexField.setAlignmentX(Component.CENTER_ALIGNMENT);

        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(indexLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(indexField);

        add(rightPanel, BorderLayout.EAST);

        bottomPanel = new JPanel(new BorderLayout());
        btnPanel = new JPanel(new FlowLayout());

        submitBtn = new JButton("Submit Vehicle");
        showInfoBtn = new JButton("Show Basic Info");
        operateBtn = new JButton("Run Operation");
        displayAllBtn = new JButton("Display All");
        checkTypeBtn = new JButton("Check Type");
        clearBtn = new JButton("Clear Form");
        loadBtn=new JButton("Load Info");
        clearAllBtn = new JButton("Clear All");

        btnPanel.add(submitBtn);
        btnPanel.add(showInfoBtn);
        btnPanel.add(operateBtn);
        btnPanel.add(displayAllBtn);
        btnPanel.add(checkTypeBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(loadBtn);
        btnPanel.add(clearAllBtn);
        loadBtn.addActionListener(e->loadFromFile());

        displayArea = new JTextArea(10, 70);
        displayArea.setEditable(false);

        bottomPanel.add(btnPanel, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        submitBtn.addActionListener(this);
        clearBtn.addActionListener(e -> clearForm());
        clearAllBtn.addActionListener(e -> clear());
        showInfoBtn.addActionListener(e -> showBasicInfo());
        operateBtn.addActionListener(e -> runVehicleOperation());
        displayAllBtn.addActionListener(e -> displayAllVehicles());
        checkTypeBtn.addActionListener(e -> checkVehicleType());
    }
    public void clear()
    {
        vehicles.clear();
    }
    private void loadFromFile()
    {
        vehicles.clear();
        try
        {
            
            BufferedReader br=new BufferedReader(new FileReader("Vehicle.txt"));
            String line;
            while((line=br.readLine())!=null)
            {
                String[] d=line.split(",");
                if(d[0].equals("Car"))
                {
                    vehicles.add(new Car(d[1],Integer.parseInt(d[2]),Integer.parseInt(d[3]),Double.parseDouble(d[4]),Double.parseDouble(d[5])));
                }
                else if(d[0].equals("Bike"))
                {
                    vehicles.add(new Bike(d[1],Integer.parseInt(d[2]),Boolean.parseBoolean(d[3]),Integer.parseInt(d[4]),Double.parseDouble(d[5])));
                }
            }
            JOptionPane.showMessageDialog(this,"Information Loaded Successfully");
    
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
    private void showForm(String type) 
    {
        selectedType = type;

        formPanel.removeAll();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));

        nameField = new JTextField(15);
        speedField = new JTextField(10);

        formPanel.add(new JLabel(type + " Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Speed (km/h):"));
        formPanel.add(speedField);

        if(type.equals("Car")) 
        {
            seatsField = new JTextField(10);
            fuelField = new JTextField(10);
            tankField = new JTextField(10);

            formPanel.add(new JLabel("Seats:"));
            formPanel.add(seatsField);

            formPanel.add(new JLabel("Fuel Efficiency (km/l):"));
            formPanel.add(fuelField);

            formPanel.add(new JLabel("Tank Capacity (L):"));
            formPanel.add(tankField);
        }
        else if(type.equals("Bike")) 
        {
            gearField = new JTextField(10);
            carrierBox = new JCheckBox("Has Carrier");
            distanceField = new JTextField(10);

            formPanel.add(new JLabel("Gear Count:"));
            formPanel.add(gearField);

            formPanel.add(new JLabel(""));
            formPanel.add(carrierBox);

            formPanel.add(new JLabel("Distance (km):"));
            formPanel.add(distanceField);
        }

        formPanel.revalidate();
        formPanel.repaint();
    }

    private void clearForm() 
    {
        if(nameField != null) { nameField.setText(""); }
        if(speedField != null) { speedField.setText(""); }
        if(seatsField != null) { seatsField.setText(""); }
        if(fuelField != null) { fuelField.setText(""); }
        if(tankField != null) { tankField.setText(""); }
        if(gearField != null) { gearField.setText(""); }
        if(distanceField != null) { distanceField.setText(""); }
        if(carrierBox != null) { carrierBox.setSelected(false); }

        indexField.setText("");
    }

    private int getIndex() 
    {
        int index = -1;

        try 
        {
            index = Integer.parseInt(indexField.getText().trim());

            if(index < 0 || index >= vehicles.size()) 
            {
                JOptionPane.showMessageDialog(this, "Index out of range!");
                index = -1;
            }
        } 
        catch(Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Enter only numbers");
        }

        return index;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // Part 1: Upcasting here !
        try 
        {
            String name = nameField.getText().trim();
            int speed = Integer.parseInt(speedField.getText().trim());
            Vehicle v=null;
            if(selectedType.equals("Car")) 
            {
                int seats=Integer.parseInt(seatsField.getText());
                double fuel=Double.parseDouble(fuelField.getText());
                double tank=Double.parseDouble(tankField.getText());
                v=new Car(name,speed,seats,fuel,tank);
            }
            else if(selectedType.equals("Bike")) 
            {
                boolean box=carrierBox.isSelected();
                int gear=Integer.parseInt(gearField.getText());
                double distance=Double.parseDouble(distanceField.getText());
                v=new Bike(name,speed,box,gear,distance);
            }

            vehicles.add(v);
            displayArea.append("Vehicle Added\n");
            saveToFile();
            clearForm();
        } 
        catch(Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void saveToFile()
    {
        try(FileWriter writer=new FileWriter("Vehicle.txt"))
        {
            for(Vehicle v: vehicles)
            {
                if(v instanceof Car)
                {
                    Car c=(Car) v;
                    writer.write("Car"+","+c.getName()+","+c.getSpeed()+","+c.getSeats()+","+c.getFuelEfficiency()+","+c.getTankCapacity()+"\n");
                }
                else if(v instanceof Bike)
                {
                    Bike b=(Bike) v;
                    writer.write("Bike"+","+b.getName()+","+b.getSpeed()+","+b.getHasCarrier()+","+b.getGearCount()+","+b.getDistance()+"\n");
                }
            }
            String location=new File("Vehicle.txt").getAbsolutePath();
            JOptionPane.showMessageDialog(this, location);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "File cannot be created");
        }
    }
    
    private void showBasicInfo() 
    {
        int index=getIndex();
        if(index>-1)
        {
            Vehicle v=vehicles.get(index);
            displayArea.append(v.getInfo());
        }
        
        

    }

    private void runVehicleOperation() 
    {
        int index=getIndex();
        if(index>-1)
        {
            Vehicle v=vehicles.get(index);
            if(v instanceof Car)
            {
                Car c=(Car) v;
                double s=c.calculateRange();
                displayArea.append("Car Range"+s+"km\n");
            }
            else if(v instanceof Bike)
            {
                Bike b=(Bike) v;
                double calculate=b.calculateTravelTime();
                displayArea.append("Bike Travel Time:"+calculate+"hours\n");
            }
            
        }
    }

    private void displayAllVehicles() 
    {
    if(vehicles.isEmpty())
    {
        displayArea.append("No vehicles");
    }
    else{
        for(int i=0;i<vehicles.size();i++)
        {
            Vehicle v= vehicles.get(i);
            displayArea.append("Index"+i+v.getInfo()+"\n");
        }
    }
}

    private void checkVehicleType() 
    {
        int index=getIndex();
        if(index>-1)
        {
            Vehicle v=vehicles.get(index);
            if(v instanceof Car)
            {
            displayArea.append("This is a car\n");
        }
        else if(v instanceof Bike)
        {
            displayArea.append("This is a bike\n");
        }
        }
        
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new VehicleForm().setVisible(true));
    }
}
