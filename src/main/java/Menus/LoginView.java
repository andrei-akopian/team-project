package Menus;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class LoginView extends JPanel {
    public LoginView() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("LoginView");
        add(title, BorderLayout.NORTH);
    }
}
