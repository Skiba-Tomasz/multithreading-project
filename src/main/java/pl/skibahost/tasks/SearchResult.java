package pl.skibahost.tasks;

public class SearchResult {
    public final String keyWord;
    public final Boolean isFound;
    public final SearchTaskType searchType;
    public final InvocationType invocationType;
    public final Long searchDuration;
    public final Long taskStartTimeMs;
    public final Long taskEndTimeMs;
    public final Integer threadHashCode;


    public SearchResult(String keyWord, Boolean isFound, SearchTaskType searchType, InvocationType invocationType, Long searchDuration, Long taskStartTimeMs, Long taskEndTimeMs, Integer threadHashCode) {
        this.keyWord = keyWord;
        this.isFound = isFound;
        this.searchType = searchType;
        this.invocationType = invocationType;
        this.searchDuration = searchDuration;
        this.taskStartTimeMs = taskStartTimeMs;
        this.taskEndTimeMs = taskEndTimeMs;
        this.threadHashCode = threadHashCode;
    }
}