package pl.skibahost.gui;

import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.tasks.SearchTask;

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Button panel GUI
 *
 * @author Tomasz Skiba
 */
class SearchPanel extends JPanel{
    private JTextField searchText;
    private JButton searchBtn;

    public SearchPanel() {
        init();
    }

    private void init() {
        initPanel();
        initComponenets();
        addComponenetsToPanel();
    }

    private void initPanel() {
        this.setLayout(new GridLayout(1,2));
        this.setSize(new Dimension(Window.WIDTH, 80));
    }

    private void initComponenets() {
        searchText = new JTextField();
        this.searchText.setSize(Window.WIDTH, 80);
        searchBtn = new JButton("Szukaj");
        searchBtn.addActionListener(e -> {
            Set<SearchTask> tasks = IntStream.range(0, 10)
                    .mapToObj(i -> new SearchTask(
                            SearchPanel.this.searchText.getText(),
                            DictionarySplitter.files.get(i),
                            10000)
                    ).collect(Collectors.toSet());
            tasks.stream().forEach(task -> new Thread(task).start());
        });
    }

    private void addComponenetsToPanel() {
        add(searchText);
        add(searchBtn);
    }
}
