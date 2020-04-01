package lab6;

import javax.swing.*;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

    ConfigPanel configPanel; // componenta de modificare parametrii
    ControlPanel controlPanel; // componenta de functionalitate (butoane save, load ...)
    DrawingPanel canvas; // componenta de desenat

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        // creeam componentele necesare
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);
        // adaugam componentele necesare
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);
        pack();
    }
}
