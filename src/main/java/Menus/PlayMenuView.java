package Menus;

import javax.swing.*;
import java.awt.*;

public class PlayMenuView extends JPanel {
  public PlayMenuView() {
    setLayout(new BorderLayout());
    JLabel title = new JLabel("PlayMenuView");
    add(title, BorderLayout.NORTH);
  }
}
