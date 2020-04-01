package lab6;

import javax.swing.*;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel sidesLabel;
    JLabel radiusLabel;

    JSpinner sidesField;
    JSpinner radiusField;

    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        // pentru fiecare parametru adaugam un label + componenta necesara (spinner sau combobox)
        // componenta numar margini
        sidesLabel = new JLabel("Number of sides:");

        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        // componenta marime brush
        radiusLabel = new JLabel("Radius of brush:");

        radiusField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        radiusField.setValue(25);
        //componenta culorii alese
        String colors[] = {"BLACK", "RED", "RANDOM"};

        colorCombo = new JComboBox(colors);
        // adaugam componentele
        add(sidesLabel);
        add(sidesField);
        add(radiusLabel);
        add(radiusField);
        add(colorCombo);

    }
}
