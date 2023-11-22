package guis;

import db_objs.MyDBC;
import db_objs.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGui extends BaseFrame{
    public LoginGui(){
        super("Banking App Login");
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
        passwordLabel.setBounds(20,280,getWidth()-50,24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

//        create oassword field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20,320,getWidth()-50,40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN,28));
        add(passwordField);

//create Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20,460,getWidth()-50,40);
        loginButton.setFont(new Font("Dialog", Font.BOLD,20));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                get username
                String username = usernameField.getText();
//                get password
                String password = String.valueOf(passwordField.getPassword());
//                validate login
                User user = MyDBC.valideteLogin(username, password);
//                if user is null it means invalid otherwise it is a valid account
                if (user != null){
//                    dispose this Gui
                    LoginGui.this.dispose();
//                    launch bank app gui
                    BankingAppGui bankingAppGui = new BankingAppGui(user);
                    bankingAppGui.setVisible(true);
//                    show success dialog
                    JOptionPane.showMessageDialog(bankingAppGui,"Login SuccessFully");
                }else{
                    JOptionPane.showMessageDialog(LoginGui.this, "Login field....");
                }
            }
        });
        add(loginButton);

//        create register label
        JLabel registerLabel = new JLabel("<html><a href=\"#\">Don't have an account? Register Here</a></html>");
        registerLabel.setBounds(0,510,getWidth()-10,30);
        registerLabel.setFont(new Font("Dialog", Font.PLAIN,20));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                dispose of this gui
               LoginGui.this.dispose();
//               launch the register gui
                new RegisterGui().setVisible(true);
            }
        });
        add(registerLabel);


    }
}
