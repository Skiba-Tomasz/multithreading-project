package pl.skibahost.file;

import pl.skibahost.gui.Window;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DictionarySplitter implements Runnable {

    private int parts;

    public DictionarySplitter(int parts) {
        this.parts = parts;
    }

    @Override
    public void run() {
        InputStream resourceAsStream = DictionarySplitter.class.getClassLoader().getResourceAsStream("slownik.dic");
        if (resourceAsStream == null)
            throw new IllegalArgumentException("Dictionary file not found!");
        List<File> files = new ArrayList<>();
        try (var lines = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8)).lines()) {
            List<String> linesList = lines.collect(Collectors.toList());
            int wordsInPart = linesList.size() / parts;
            for (int k = 0; k < parts; k++) {
                File file = File.createTempFile("Part-", k + ".dic");
                file.deleteOnExit();
                try (var writer = new BufferedWriter(new FileWriter(file))) {
                    for (int i = k * wordsInPart; i < (k + 1) * wordsInPart -1; i++) {
                        int progres = (i*100)/linesList.size();
                        Window.progressBar.setValue(progres);
                        Window.progressBar.setString(i + "/" + linesList.size() + " (" + progres + "%)");
                        writer.write(linesList.get(i));
                    }
                    files.add(file);
                }
            }
            System.out.println("Parting done");
            Window.progressBar.setString(linesList.size() + "/" + linesList.size() + " (100%)");
            Window.progressBar.setValue(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
