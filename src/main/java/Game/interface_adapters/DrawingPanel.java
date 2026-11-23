package Game.interface_adapters;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
