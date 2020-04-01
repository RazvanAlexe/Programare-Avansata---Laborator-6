package lab6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static lab6.DrawingPanel.H;
import static lab6.DrawingPanel.W;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        // asociem fiecarui buton functionalitatea dorita
        saveBtn.addActionListener(this::save);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
        loadBtn.addActionListener(this::load);
        // adaugam butoanele in componenta
        add(resetBtn);
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);
    }

    private void reset(ActionEvent e) {
        // functionalitatea de reset
        // deseneaza un dreptunghi de culoarea backgroundului peste tot canvasul
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, W, H);
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e) {
        // functionalitatea de exit
        // se apeleaza system exit
        System.exit(0);
    }

    private void load(ActionEvent e) {
        // functionalitatea de load
        // se citeste imaginea si se deseneaza pe canvas
        BufferedImage img;

        try {
            img = ImageIO.read(new File("test.png"));
            frame.canvas.graphics.drawImage(img, 0, 0, frame.canvas);
            frame.canvas.repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    private void save(ActionEvent e) {
        // functionalitatea de save
        // se creeaza un fisier de tip png cu imaginea din canvas
        try {
            ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream("test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
