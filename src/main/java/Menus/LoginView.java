package Menus;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
  public LoginView() {
    setLayout(new BorderLayout());
    JLabel title = new JLabel("LoginView");
    add(title, BorderLayout.NORTH);
  }
}
