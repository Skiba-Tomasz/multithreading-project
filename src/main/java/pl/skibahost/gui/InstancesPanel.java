package pl.skibahost.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        upBtn.addActionListener(e ->incrementCounter(e));
        downBtn = new JButton("-");
        downBtn.addActionListener(e -> decrementCounter(e));
        setBtn = new JButton("Podziel dane");
    }

    private void decrementCounter(ActionEvent e) {
        int count = getCount();
        InstancesPanel.this.countFiled.setText(""+ --count);
    }

    private void incrementCounter(ActionEvent e) {
        int count = getCount();
        InstancesPanel.this.countFiled.setText(""+ ++count);
    }

    private int getCount() {
        String input = InstancesPanel.this.countFiled.getText();
        int count = 0;
        try{
            count = Integer.parseInt(input);
        } catch(NumberFormatException ex){
            System.out.println(String.format("Unable to format number %s as thread count.", input));
        }
        return count;
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
