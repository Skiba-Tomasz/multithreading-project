package pl.skibahost.gui;

import pl.skibahost.job.MultiThreadSearch;

import javax.swing.*;

public class MultiThreadPanel extends JPanel {
    private JLabel splitInfo;
    private JLabel searchInfo;

    private SearchPanel searchPanel;
    private InstancesPanel instancesPanel;

    public MultiThreadPanel() {
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
        MultiThreadSearch multiThreadSearch = new MultiThreadSearch(instancesPanel.getCount(), searchPanel.getInput());
        multiThreadSearch.execute();
    }

}
