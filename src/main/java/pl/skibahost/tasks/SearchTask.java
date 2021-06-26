package pl.skibahost.tasks;

import pl.skibahost.AppState;
import pl.skibahost.gui.Window;

import java.io.File;

public class SearchTask extends AbstractFileTask {

    protected String keyword;

    public SearchTask(String keyword, File file) {
        super(file);
        this.keyword = keyword;
    }

    public SearchTask(String keyword, File file, int delay) {
        super(file, delay);
        this.keyword = keyword;
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
        AppState.getInstance().results.add(new AppState.SearchResult(keyword, result, taskStart, taskEnd, duration, Thread.currentThread().hashCode()));
    }
}
