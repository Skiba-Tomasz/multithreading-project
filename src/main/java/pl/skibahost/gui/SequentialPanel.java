package pl.skibahost.gui;

import pl.skibahost.AppState;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.job.SequentialSearch;
import pl.skibahost.tasks.InvocationType;
import pl.skibahost.tasks.SearchTask;

import javax.swing.*;

public class SequentialPanel extends JPanel {
    private SearchPanel searchPanel;

    public SequentialPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.searchPanel = new SearchPanel(e -> startSequentialSearch());
        add(searchPanel);
    }

    private void startSequentialSearch() {
        SequentialSearch sequentialSearch = new SequentialSearch(searchPanel.getInput(), InvocationType.SWING_GUI);
        sequentialSearch.execute();
    }
}
