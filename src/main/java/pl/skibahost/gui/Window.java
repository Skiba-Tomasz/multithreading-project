package pl.skibahost.gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    static final int WIDTH = 600;
    static final int HEIGHT = 200;

    public static final JProgressBar progressBar = new JProgressBar();

    static {
        progressBar.setStringPainted(true);
    }

    private JPanel mainPanel;
    private SearchPanel searchPanel;
    private InstancesPanel instancesPanel;
    private IntroPanel introPanel;

    public Window(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.mainPanel = new JPanel();
        this.introPanel = new IntroPanel();
        this.instancesPanel = new InstancesPanel();
        this.searchPanel = new SearchPanel();

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Słownik równoległy - Tomasz Skiba");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(introPanel);
        mainPanel.add(instancesPanel);
        mainPanel.add(searchPanel);
        mainPanel.add(progressBar);

        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.add(mainPanel);
    }


}
