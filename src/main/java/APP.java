import db_objs.User;
import guis.BankingAppGui;
import guis.LoginGui;

import javax.swing.*;
import java.math.BigDecimal;

public class APP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGui().setVisible(true);
//                new RegisterGui().setVisible(true);
//                new BankingAppGui(
//                        new User(1,"mike", "password", new BigDecimal("20.00"))
//                ).setVisible(true);
            }
        });
    }
}
