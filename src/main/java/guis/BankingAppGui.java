package guis;

import db_objs.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingAppGui extends BaseFrame implements ActionListener {
    private JTextField currentBalanceField;
    public JTextField getCurrentBalanceField(){return currentBalanceField;}
    public BankingAppGui(User user) {
        super("Banking App", user);
    }

    @Override
    protected void addGuiCompenents() {
//        create welcome message
        String welcomeMessage= "<html>"  +
                                "<body style='text-align:center'>"+
                                "<b>Hello " + user.getUsername() + "</b><br>" +
                                "What would you like to do today?</body></html>";
        JLabel welcomeMessageLabel = new JLabel(welcomeMessage);
        welcomeMessageLabel.setBounds(0,20,getWidth()-10,40);
        welcomeMessageLabel.setFont(new Font("Dialog",Font.PLAIN, 16));
        welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeMessageLabel);

//        create current balance label
        JLabel currentBalanceLabel = new JLabel("Current Blance");
        currentBalanceLabel.setBounds(0,80,getWidth()-10,30);
        currentBalanceLabel.setFont(new Font("Dialog",Font.PLAIN, 22));
        currentBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(currentBalanceLabel);

//      create current balance field
        currentBalanceField = new JTextField("$"+user.getCurrentBalance());
        currentBalanceField.setBounds(15,120,getWidth()-50,40);
        currentBalanceField.setFont(new Font("Dialog",Font.BOLD, 28));
        currentBalanceField.setHorizontalAlignment(SwingConstants.RIGHT);
        currentBalanceField.setEditable(false);
        add(currentBalanceField);

//        deposit button
        JButton depositeButton = new JButton("Deposit");
        depositeButton.setBounds(15,180,getWidth()-50,50);
        depositeButton.setFont(new Font("Dialog",Font.BOLD, 22));
        depositeButton.addActionListener(this);
        add(depositeButton);

//        withDraw button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(15,250,getWidth()-50,50);
        withdrawButton.setFont(new Font("Dialog",Font.BOLD, 22));
        withdrawButton.addActionListener(this);
        add(withdrawButton);

//        past transaction button
        JButton pasttransactionButton = new JButton("past Transaction");
        pasttransactionButton.setBounds(15,320,getWidth()-50,50);
        pasttransactionButton.setFont(new Font("Dialog",Font.BOLD, 22));
        pasttransactionButton.addActionListener(this);
        add(pasttransactionButton);

//        transfert button
        JButton transfertButton = new JButton("Transfer");
        transfertButton.setBounds(15,390,getWidth()-50,50);
        transfertButton.setFont(new Font("Dialog",Font.BOLD, 22));
        transfertButton.addActionListener(this);
        add(transfertButton);

//        logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(15,500,getWidth()-50,50);
        logoutButton.setFont(new Font("Dialog",Font.BOLD, 22));
        logoutButton.addActionListener(this);
        add(logoutButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();

        // user pressed logout
        if(buttonPressed.equalsIgnoreCase("Logout")) {
            // return user to the login gui
            new LoginGui().setVisible(true);

            // dispose of this gui
            this.dispose();

            // don't bother running the rest of the code
            return;
        }
        // other functions
        BankingAppDialog bankingAppDialog = new BankingAppDialog(this, user);

        // set the title of the dialog header to the action
        bankingAppDialog.setTitle(buttonPressed);

        // if the button pressed is deposit, withdraw, or transfer
        if(buttonPressed.equalsIgnoreCase("Deposit") || buttonPressed.equalsIgnoreCase("Withdraw")
                || buttonPressed.equalsIgnoreCase("Transfer")){
            // add in the current balance and amount gui components to the dialog
            bankingAppDialog.addCurrentBalanceAndAmount();

            // add action button
            bankingAppDialog.addActionButton(buttonPressed);

            // for the transfer action it will require more components
            if(buttonPressed.equalsIgnoreCase("Transfer")){
                bankingAppDialog.addUserField();
            }

        }else if(buttonPressed.equalsIgnoreCase("Past Transaction")){
            bankingAppDialog.addPastTransactionComponents();
        }

        // make the app dialog visible
        bankingAppDialog.setVisible(true);
    }
}
