package pl.skibahost.job;

import pl.skibahost.AppState;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.gui.Window;
import pl.skibahost.tasks.SearchTask;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiThreadSearch extends SearchJob{

    private int threadCount = 1;

    public MultiThreadSearch(int threadCount, String keyWord) {
        super(keyWord);
        this.threadCount = threadCount;
    }

    @Override
    public void execute() {
        Set<SearchTask> tasks = prepareTasks();
        Window.progressBar.setString("Work in progress...");
        tasks.stream().forEach(task -> new Thread(task).start());

    }
    private Set<SearchTask> prepareTasks() {
        return IntStream.range(0, threadCount)
                .mapToObj(i -> new SearchTask(
                        keyWord,
                        DictionarySplitter.files.get(i),
                        AppState.getInstance().delay)
                ).collect(Collectors.toSet());
    }
}
