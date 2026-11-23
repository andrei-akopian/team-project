package Menus;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PlayMenuView extends JPanel {
    public PlayMenuView() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("PlayMenuView");
        add(title, BorderLayout.NORTH);
    }
}
