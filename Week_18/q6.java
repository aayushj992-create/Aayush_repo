package Week_18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent; 

public class q6 extends JFrame {

    public q6() {
        setTitle("Form");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

     
        JButton btn = new JButton("Save");
        btn.setBounds(50, 50, 100, 40); 
        btn.setBackground(new Color(76, 175, 80));
        btn.setForeground(Color.WHITE);
        btn.setMnemonic(KeyEvent.VK_S); 
        btn.setToolTipText("Save your work");

        
        add(btn);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new q6(); 
            }
        });
    }
}