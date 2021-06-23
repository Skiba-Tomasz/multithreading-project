package pl.skibahost.impl;

public class OmpImpl {
    public static void execute(Runnable[] searchTask) {
        // omp parallel for
        for (int i = 0; i < searchTask.length; i++) {
            searchTask[i].run();
        }
    }
}
