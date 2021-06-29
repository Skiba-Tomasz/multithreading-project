package pl.skibahost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.gui.Window;

@SpringBootApplication
public class Main {

    public static void main(String[] args){
        new DictionarySplitter(1).run();
        Window window = new Window();
        window.setVisible(true);
        window.pack();
        SpringApplication.run(Main.class, args);
    }
}
