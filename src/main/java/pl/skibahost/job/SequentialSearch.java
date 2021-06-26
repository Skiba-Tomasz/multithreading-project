package pl.skibahost.job;

import pl.skibahost.AppState;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.gui.Window;
import pl.skibahost.tasks.InvocationType;
import pl.skibahost.tasks.SearchTask;
import pl.skibahost.tasks.SearchTaskType;

public class SequentialSearch extends SearchJob{

    private InvocationType invocationType;

    public SequentialSearch(String keyWord, InvocationType invocationType) {
        super(keyWord);
        this.invocationType = invocationType;
    }

    @Override
    public void execute() {
        new Thread(() -> {
            new DictionarySplitter(1).run();
            Window.progressBar.setString("Work in progress...");
            new SearchTask(
                    keyWord,
                    DictionarySplitter.files.get(0),
                    SearchTaskType.SEQUENTIAL,
                    this.invocationType,
                    AppState.getInstance().delay).run();
        }).start();
    }
}
