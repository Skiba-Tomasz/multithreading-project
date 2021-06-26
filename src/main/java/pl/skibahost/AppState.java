package pl.skibahost;

import pl.skibahost.tasks.SearchResult;
import pl.skibahost.tasks.SearchTaskType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppState {
    private static AppState instance;
    public final List<SearchResult> results = Collections.synchronizedList(new ArrayList<SearchResult>());
    public int delay = 20000;

    private AppState() {
    }

    public static AppState getInstance() {
        if (instance == null)
            instance = new AppState();
        return instance;
    }

    public static AppState reset() {
        instance = new AppState();
        return instance;
    }


}
