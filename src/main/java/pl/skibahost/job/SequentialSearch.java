package pl.skibahost.job;

import pl.skibahost.AppState;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.gui.Window;
import pl.skibahost.tasks.SearchTask;

public class SequentialSearch extends SearchJob{

    private String keyword;

    public SequentialSearch(String keyWord) {
        super(keyWord);
    }

    @Override
    public void execute() {
        new Thread(() -> {
            new DictionarySplitter(1).run();
            Window.progressBar.setString("Work in progress...");
            new SearchTask(
                    keyWord,
                    DictionarySplitter.files.get(0),
                    AppState.getInstance().delay).run();
            Window.progressBar.setString("Done");
        }).start();
    }
}
