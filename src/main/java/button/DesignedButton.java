package button;

import javax.swing.JButton;
import java.awt.*;

public class DesignedButton extends JButton {
    private static final int ARC_WIDTH = 10; // Radius für die abgerundeten Ecken
    private static final int ARC_HEIGHT = 10;
    private static final int BORDER_THICKNESS = 2; // Dicke des Borders
    private static final Color BORDER_COLOR = Color.BLACK;

    public DesignedButton(String text, Color c) {
        super(text);
        setForeground(c);
        setBackground(new Color(255, 255, 255));
        //setFont(new Font("Arial", Font.BOLD, 14));

        setContentAreaFilled(false); // Mache den Hintergrund transparent
        setFocusPainted(false); // Entferne den Fokus-Rahmen
        setBorderPainted(false); // Entferne den rechteckigen Border um den Button
    }

    public void setColor(Color c) {
        setForeground(c);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isArmed()) {
            g2.setColor(Color.DARK_GRAY); // Farbe bei Mausklick
        } else if (getModel().isRollover()) {
            g2.setColor(Color.LIGHT_GRAY); // Farbe bei Mouseover
        } else {
            g2.setColor(getBackground());
        }

        int borderThickness = BORDER_THICKNESS;
        int halfBorderThickness = borderThickness / 2;
        int adjustedWidth = getWidth() - borderThickness;
        int adjustedHeight = getHeight() - borderThickness;

        g2.fillRoundRect(halfBorderThickness, halfBorderThickness, adjustedWidth, adjustedHeight, ARC_WIDTH, ARC_HEIGHT);

        g2.setColor(BORDER_COLOR);
        g2.setStroke(new BasicStroke(borderThickness));
        g2.drawRoundRect(halfBorderThickness, halfBorderThickness, adjustedWidth, adjustedHeight, ARC_WIDTH, ARC_HEIGHT);

        super.paintComponent(g2);
        g2.dispose();
    }
}



