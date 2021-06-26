package pl.skibahost.gui;

import pl.skibahost.job.Omp4jJob;

import javax.swing.*;

public class Omp4jPanel extends JPanel {
    private JLabel splitInfo;
    private JLabel searchInfo;

    private SearchPanel searchPanel;
    private InstancesPanel instancesPanel;

    public Omp4jPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.splitInfo = new JLabel("Ilość podziałów i wątków");
        this.searchInfo = new JLabel("Wyszukaj słowo");

        this.instancesPanel = new InstancesPanel();
        this.searchPanel = new SearchPanel(e -> startParallelSearch());

        add(splitInfo);
        add(instancesPanel);
        add(searchInfo);
        add(searchPanel);
    }

    private void startParallelSearch() {
        Omp4jJob omp4jJob = new Omp4jJob(instancesPanel.getCount(), searchPanel.getInput());
        omp4jJob.execute();
    }

}
