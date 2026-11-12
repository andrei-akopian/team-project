package Game;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    System.out.println("Painting");
    Graphics2D g2 = (Graphics2D) g.create();

    g2.setColor(Color.RED);
//    g2.fillOval(100, 100, 100, 100);
    g2.drawLine(100, 100, 200, 200);

    g2.dispose();
  }
}
