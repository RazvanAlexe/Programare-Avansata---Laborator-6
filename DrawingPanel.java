package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawingPanel extends javax.swing.JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;

    BufferedImage image; //the offscreen image
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        // functia de desenare a backgroundului
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        // setam dimensiunile canvasului
        setPreferredSize(new Dimension(W, H));
        // setam marginea
        setBorder(BorderFactory.createEtchedBorder());
        // asociem evenimentului de mouse click functia de desenare
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        // functia de desenare a unei forme
        // preluam culoarea din combobox
        String color = (String) frame.configPanel.colorCombo.getSelectedItem();
        // daca e random alegem o culoare aleatorie
        if (color.equals("RANDOM")) {
            Random rand = new Random();
            Integer i = rand.nextInt(2);
            if (i == 0) {
                color = "BLACK";
            } else if (i == 1) {
                color = "RED";
            }
        }
        // alegem culoarea formei in functie de culoarea data
        if (color.equals("RED")) {
            graphics.setColor(Color.RED);
        } else if (color.equals("BLACK")) {
            graphics.setColor(Color.BLACK);
        }
        // desenam forma
        graphics.fill(new RegularPolygon(x, y, (Integer) frame.configPanel.radiusField.getValue(), (Integer) frame.configPanel.sidesField.getValue()));
    }

    @Override
    public void update(Graphics g) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
