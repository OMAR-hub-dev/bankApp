package guis;

import javax.swing.*;
import java.awt.*;

public class RegisterGui extends  BaseFrame{

    public RegisterGui(){
        super("Banking App Register");
    }
    @Override
    protected void addGuiCompenents() {
        JLabel bankingAppLabel = new JLabel("Banking Application Login");
        bankingAppLabel.setBounds(0,20,super.getWidth(),40);
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingAppLabel);

        JLabel  usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20,120,getWidth()-30,24);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(20,160,getWidth()-50,40);
        usernameField.setFont(new Font("Dialog", Font.PLAIN,28));
        add(usernameField);

//        create password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20,220,getWidth()-50,24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

//        create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20,260,getWidth()-50,40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN,28));
        add(passwordField);

//      re-type password label
        JLabel rePasswordLabel= new JLabel("Re-type password");
        rePasswordLabel.setBounds(20,320,getWidth()-50,40);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN,20));
        add(rePasswordLabel);

//        create re-type Pasword field
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(20,360,getWidth()-50,40);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN,28));
        add(rePasswordField);

//      create Login button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20,460,getWidth()-50,40);
        registerButton.setFont(new Font("Dialog", Font.BOLD,20));
        add(registerButton);

//        create register label
        JLabel loginLabel = new JLabel("<html><a href=\"#\">Don't have an account? Sign-in  Here</a></html>");
        loginLabel.setBounds(0,510,getWidth()-10,30);
        loginLabel.setFont(new Font("Dialog", Font.PLAIN,20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

    }
}
