package pl.skibahost.gui;

import javax.swing.*;

class IntroPanel extends JPanel {
    private JLabel info;

    IntroPanel(){
        this.info = new JLabel("Test");
        add(info);
    }
}
