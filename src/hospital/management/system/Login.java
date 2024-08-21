package  hospital.management.system; //package


import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JTextField textField;
    JPasswordField jPasswordField;


    Login(){

        JLabel nameLabel = new JLabel("UserName");
        nameLabel.setBounds(40,20,100,30);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD,16));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma", Font.PLAIN,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150,20,150,30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN,15));
        jPasswordField.setBackground(new Color(255,179,0));
        add(jPasswordField);



        getContentPane().setBackground(new Color(109,144,170));
        setSize(750,300);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Login();
    }
}

