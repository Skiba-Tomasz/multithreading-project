package pl.skibahost.file;

import pl.skibahost.gui.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DictionarySplitter implements Runnable {

    public static List<List<String>> files;

    private int parts;

    public DictionarySplitter(int parts) {
        this.parts = parts;
    }

    @Override
    public void run() {
        if(files != null && files.size() == parts){
            System.out.println("Parting skipped. Already parted properly.");
            return;
        }
        InputStream resourceAsStream = DictionarySplitter.class.getClassLoader().getResourceAsStream("slownik.dic");
        if (resourceAsStream == null)
            throw new IllegalArgumentException("Dictionary file not found!");
        files = new ArrayList<>();
        try (var lines = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8)).lines()) {
            List<String> linesList = lines.collect(Collectors.toList());
            Collections.shuffle(linesList);
            int wordsInPart = linesList.size() / parts;
            for (int k = 0; k < parts; k++) {
//                File file = File.createTempFile("Part-", k + ".dic");
//                file.deleteOnExit();
//                try (var writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), StandardCharsets.UTF_8))) {
//                try(var writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)){
                    List<String> linesPartList = new ArrayList<>();
                    for (int i = k * wordsInPart; i < (k + 1) * wordsInPart -1; i++) {
                        updateProgressBar(linesList, i);
                        linesPartList.add(linesList.get(i));
//                        writer.write(linesList.get(i) + "\n");
                    }
                    files.add(linesPartList);
//                }
            }
            System.out.println("Parting done");
            Window.progressBar.setString(linesList.size() + "/" + linesList.size() + " (100%)");
            Window.progressBar.setValue(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void updateProgressBar(List<String> linesList, int i) {
        int progress = (i *100)/ linesList.size();
        Window.progressBar.setValue(progress);
        Window.progressBar.setString(i + "/" + linesList.size() + " (" + progress + "%)");
    }
}
