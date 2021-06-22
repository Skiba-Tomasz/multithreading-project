package pl.skibahost.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Button panel GUI
 *
 * @author Tomasz Skiba
 */
class SearchPanel extends JPanel{
    private JTextField searchText;
    private JButton searchBtn;

    public SearchPanel() {
        init();
    }

    private void init() {
        initPanel();
        initComponenets();
        addComponenetsToPanel();
    }

    private void initPanel() {
        this.setLayout(new GridLayout(1,2));
        this.setSize(new Dimension(Window.WIDTH, 80));
    }

    private void initComponenets() {
        searchText = new JTextField();
        this.searchText.setSize(Window.WIDTH, 80);
        searchBtn = new JButton("Szukaj");
    }

    private void addComponenetsToPanel() {
        add(searchText);
        add(searchBtn);
    }
}
