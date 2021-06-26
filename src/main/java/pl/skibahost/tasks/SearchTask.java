package pl.skibahost.tasks;

import pl.skibahost.AppState;
import pl.skibahost.gui.Window;

import java.io.File;
import java.util.List;

public class SearchTask extends AbstractFileTask {

    protected SearchTaskType type;
    protected InvocationType invocationType;
    protected String keyword;

    public SearchTask(String keyword, List<String>lines, SearchTaskType searchTaskType, InvocationType invocationType, int delay) {
        super(lines, delay);
        this.keyword = keyword;
        this.type = searchTaskType;
        this.invocationType = invocationType;
    }

    @Override
    public void run() {
        System.out.println("Starting task: " + this.hashCode());
        isWorking = true;
        long taskStart = System.currentTimeMillis();
        try {
            for (String line : lines) {
                if (line.equals(keyword)) {
                    this.result = true;
                    break;
                }
                shortSleep(this.delayNano);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long taskEnd = System.currentTimeMillis();
        this.duration = taskEnd - taskStart;
        isWorking = false;
        System.out.println("Finished task: " + Thread.currentThread().hashCode() + " Result: " + result + " Time: " + duration);
        if(result) {
            Window.progressBar.setString("Done (" + duration + ")");
        }
        AppState.getInstance().results.add(new SearchResult(keyword, result, type, invocationType, duration, taskStart, taskEnd, Thread.currentThread().hashCode()));
    }
}
