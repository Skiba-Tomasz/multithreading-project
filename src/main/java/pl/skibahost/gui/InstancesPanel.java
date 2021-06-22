package pl.skibahost.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Button panel GUI
 *
 * @author Tomasz Skiba
 */
class InstancesPanel extends JPanel{
    private JTextField countFiled;
    private JPanel upDownPanel;
    private JButton upBtn;
    private JButton downBtn;
    private JButton setBtn;

    public InstancesPanel() {
        init();
    }

    private void init() {
        initPanel();
        initComponenets();
        addComponenetsToPanel();
    }

    private void initPanel() {
        this.setLayout(new GridLayout());
        this.setSize(new Dimension(Window.WIDTH, 80));
    }

    private void initComponenets() {
        this.upDownPanel = new JPanel();
        upDownPanel.setLayout(new GridLayout(2,1));
        countFiled = new JTextField("1");
        upBtn = new JButton("+");
        downBtn = new JButton("-");
        setBtn = new JButton("Podziel dane");
    }

    private void addComponenetsToPanel() {
        upDownPanel.add(upBtn);
        upDownPanel.add(downBtn);
        add(countFiled);
        add(upDownPanel);
        add(setBtn);
    }

    public JButton getUpBtn() {
        return upBtn;
    }

    public JButton getDownBtn() {
        return downBtn;
    }

    public JButton getSetBtn() {
        return setBtn;
    }
}
