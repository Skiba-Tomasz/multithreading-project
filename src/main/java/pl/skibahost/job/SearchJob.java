package pl.skibahost.job;

public abstract class SearchJob {
    protected String keyWord;
    public abstract void execute();

    public SearchJob(String keyWord) {
        this.keyWord = keyWord;
    }
}
