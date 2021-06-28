package pl.skibahost.gui;

import pl.skibahost.AppState;

import javax.swing.*;
import java.awt.*;

public class DelayPanel extends JPanel {
    private JButton setButton;
    private JTextField textField;
    private JLabel info;

    public DelayPanel() {
        setLayout(new GridLayout(1,3));
        this.info = new JLabel("Opoznienie wyszukiwan [ns]: ");
        add(info);
        this.textField = new JTextField("" + AppState.getInstance().delay);
        this.textField.setSize(100, 20);
        add(textField);
        this.setButton = new JButton("Ustaw");
        this.setButton.addActionListener(e -> AppState.getInstance().delay = Integer.parseInt(textField.getText()));
        add(setButton);
    }
}
