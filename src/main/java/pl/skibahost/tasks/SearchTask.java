package pl.skibahost.tasks;

import java.io.File;

public class SearchTask extends AbstractFileTask {

    private String keyword;

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
        isWorking = false;
        this.duration = System.currentTimeMillis() - taskStart;
        System.out.println("Finished task: " + this.hashCode() + " Result: " + result + " Time: " + duration);
    }
}
