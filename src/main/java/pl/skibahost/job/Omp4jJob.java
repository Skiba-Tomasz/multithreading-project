package pl.skibahost.job;

import pl.skibahost.AppState;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.gui.Window;
import pl.skibahost.impl.OmpImpl;
import pl.skibahost.tasks.InvocationType;
import pl.skibahost.tasks.SearchTask;
import pl.skibahost.tasks.SearchTaskType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Omp4jJob extends SearchJob{

    private InvocationType invocationType;
    private int threadCount = 1;

    public Omp4jJob(int threadCount, String keyWord, InvocationType invocationType) {
        super(keyWord);
        this.threadCount = threadCount;
        this.invocationType = invocationType;
    }

    @Override
    public void execute() {
        List<Runnable> tasks = prepareTasks();
        Window.progressBar.setString("Work in progress...");
        // Please notice, that there is no manual thread invocation/creation.
        // This is delegated to OMP4J.
        OmpImpl.execute(tasks.toArray(new Runnable[tasks.size()]));
    }

    private List<Runnable> prepareTasks() {
        return IntStream.range(0, threadCount)
                .mapToObj(i -> new SearchTask(
                        keyWord,
                        DictionarySplitter.files.get(i),
                        SearchTaskType.OMP4J,
                        this.invocationType,
                        AppState.getInstance().delay)
                ).collect(Collectors.toList());
    }
}
