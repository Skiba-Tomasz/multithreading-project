package pl.skibahost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppState {
    public static class SearchResult{
        public final String keyWord;
        public final Boolean isFound;
        public final Long taskStartTimeMs;
        public final Long taskEndTimeMs;
        public final Long searchDuration;
        public final Integer threadHashCode;

        public SearchResult(String keyWord, Boolean isFound, Long taskStartTimeMs, Long taskEndTimeMs, Long searchDuration, Integer threadHashCode) {
            this.keyWord = keyWord;
            this.isFound = isFound;
            this.taskStartTimeMs = taskStartTimeMs;
            this.taskEndTimeMs = taskEndTimeMs;
            this.searchDuration = searchDuration;
            this.threadHashCode = threadHashCode;
        }
    }
    private static AppState instance;
    public final List<SearchResult> results = Collections.synchronizedList(new ArrayList<SearchResult>());
    public int delay = 20000;

    private AppState(){}

    public static AppState getInstance(){
        if(instance == null)
            instance = new AppState();
        return instance;
    }

    public static AppState reset(){
        instance = new AppState();
        return  instance;
    }


}
