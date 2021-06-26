package pl.skibahost.tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFileTask implements Runnable{
    protected List<String> lines;
    protected int delayNano;
    protected long duration;
    protected boolean result;
    protected volatile boolean isWorking;

    AbstractFileTask(List<String> lines, int delayNano){
        this.delayNano = delayNano;
        this.lines = lines;
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

    public boolean isWorking(){
        return isWorking;
    }
}
