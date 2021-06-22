package pl.skibahost.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Button panel GUI
 *
 * @author Tomasz Skiba
 */
class SearchPanel extends JPanel{
    private JTextField searchText;
    private JButton searchBtn;
    private ActionListener action;

    public SearchPanel(ActionListener action) {
        this.action = action;

        init();
    }

    private void init() {
        initPanel();
        initComponents();
        addComponenetsToPanel();
    }

    private void initPanel() {
        this.setLayout(new GridLayout(1,2));
        this.setSize(new Dimension(Window.WIDTH, 80));
    }

    private void initComponents() {
        searchText = new JTextField();
        this.searchText.setSize(Window.WIDTH, 80);
        searchBtn = new JButton("Szukaj");
        searchBtn.addActionListener(action);
    }

    private void addComponenetsToPanel() {
        add(searchText);
        add(searchBtn);
    }

    public String getInput(){
        return this.searchText.getText();
    }
}
