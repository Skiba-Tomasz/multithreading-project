package pl.skibahost.gui;

import pl.skibahost.AppState;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.impl.OmpImpl;
import pl.skibahost.tasks.SearchTask;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        List<Runnable> tasks = prepareTasks();
        Window.progressBar.setString("Work in progress...");
        OmpImpl.execute(tasks.toArray(new Runnable[tasks.size()]));
    }

    private List<Runnable> prepareTasks() {
        return IntStream.range(0, instancesPanel.getCount())
                .mapToObj(i -> new SearchTask(
                        searchPanel.getInput(),
                        DictionarySplitter.files.get(i),
                        AppState.getInstance().delay)
                ).collect(Collectors.toList());
    }
}
