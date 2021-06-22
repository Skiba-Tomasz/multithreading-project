package pl.skibahost;

public class AppState {
    private static AppState instance;
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
