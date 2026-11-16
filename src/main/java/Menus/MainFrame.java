package Menus;

import Game.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

  private CardLayout cardLayout;
  private JPanel contentPanel;

  public MainFrame() {
    setTitle("My Application");
    setSize(1000, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    cardLayout = new CardLayout();
    contentPanel = new JPanel(cardLayout);

    contentPanel.add(new LoginView(), "LOGINVIEW");
    contentPanel.add(new PlayMenuView(), "PLAYMENUVIEW");

    add(createNavigationPanel(), BorderLayout.WEST);
    add(contentPanel, BorderLayout.CENTER);

    showView("LOGINVIEW");
  }

  public void showView(String viewName) {
    cardLayout.show(contentPanel, viewName);
  }

  private JPanel createNavigationPanel() {
    JPanel panel = new JPanel();

    JButton loginviewButton = new JButton("Login View");
    JButton playmenuviewButton = new JButton("Play Menu View");

    loginviewButton.addActionListener(
            e -> showView("LOGIN VIEW")
    );
    playmenuviewButton.addActionListener(
            e -> showView("PLAYMENUVIEW")
    );

    panel.setLayout(new GridLayout(0, 1));
    panel.add(loginviewButton);
    panel.add(playmenuviewButton);

    return panel;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      MainFrame frame = new MainFrame();
      frame.setVisible(true);
    });
  }
}