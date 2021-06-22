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

    private IntroPanel introPanel;
    private JTabbedPane tabbedPane;
    private SequentialPanel sequentialPanel;
    private MultiThreadPanel multiThreadPanel;

    public Window(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainPanel = new JPanel();
        this.introPanel = new IntroPanel();
        this.tabbedPane = new JTabbedPane();
        this.sequentialPanel = new SequentialPanel();
        this.multiThreadPanel = new MultiThreadPanel();

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Słownik równoległy - Tomasz Skiba");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(introPanel);
        addTabs();
        mainPanel.add(tabbedPane);
        mainPanel.add(progressBar);

        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.add(mainPanel);
    }

    private void addTabs(){
        tabbedPane.add("Sekwencyjny", sequentialPanel);
        tabbedPane.add("Wątki", multiThreadPanel);
    }

}
