package pl.skibahost.tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFileTask implements Runnable{
    protected List<String> lines;
    protected int delayNano;
    protected File file;
    protected long duration;
    protected boolean result;

    AbstractFileTask(File file){
        this.file = file;
        this.lines = loadLines(file);
    }

    AbstractFileTask(File file, int delayNano){
        this.file = file;
        this.delayNano = delayNano;
        this.lines = loadLines(file);
    }

    private List<String> loadLines(File file){
        try(var lines = new BufferedReader(new FileReader(file)).lines()) {
            List<String> list = lines.collect(Collectors.toList());
            Collections.shuffle(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Alternative for Thread.sleep()
     * For very short periods under 1ms for Linux and 10 ms for Windows it's not possible to suspend Thread.
     * Suspension takes longer then that. There for is this method.
     * @param delay delay in nano seconds
     */
    protected void shortSleep(int delay){
        long currentNano = System.nanoTime();
        while (currentNano + delay >= System.nanoTime()){}
    }
}
