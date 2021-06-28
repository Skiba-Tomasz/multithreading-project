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

    private TopPanel topPanel;
    private JTabbedPane tabbedPane;
    private SequentialPanel sequentialPanel;
    private MultiThreadPanel multiThreadPanel;
    private Omp4jPanel omp4jPanel;

    public Window(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainPanel = new JPanel();
        this.topPanel = new TopPanel();
        this.tabbedPane = new JTabbedPane();
        this.sequentialPanel = new SequentialPanel();
        this.multiThreadPanel = new MultiThreadPanel();
        this.omp4jPanel = new Omp4jPanel();

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Słownik równoległy - Tomasz Skiba");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
//        mainPanel.add(introPanel);
        addTabs();
        mainPanel.add(tabbedPane);
        mainPanel.add(progressBar);

        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.add(topPanel, BorderLayout.PAGE_START);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    private void addTabs(){
        tabbedPane.add("Sekwencyjny", sequentialPanel);
        tabbedPane.add("Wątki", multiThreadPanel);
        tabbedPane.add("OpenMP4J", omp4jPanel);
    }

}
