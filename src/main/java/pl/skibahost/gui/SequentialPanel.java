package pl.skibahost.gui;

import pl.skibahost.AppState;
import pl.skibahost.file.DictionarySplitter;
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
        new Thread(() -> {
            new DictionarySplitter(1).run();
            Window.progressBar.setString("Work in progress...");
            new SearchTask(
                    searchPanel.getInput(),
                    DictionarySplitter.files.get(0),
                    AppState.getInstance().delay).run();
            Window.progressBar.setString("Done");
        }).start();
    }
}
