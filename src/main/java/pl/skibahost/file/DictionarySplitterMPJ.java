package pl.skibahost.file;

import pl.skibahost.gui.Window;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DictionarySplitterMPJ implements Runnable {

    public static List<List<String>> files;

    private int partsTotal;

    private int part;

    public DictionarySplitterMPJ(int part, int partsTotal) {
        this.part = part;
        this.partsTotal = partsTotal;
    }

    @Override
    public void run() {
        System.out.println(String.format("Parting for [%d/%d]", part, partsTotal));
        if (files != null && files.size() == partsTotal) {
            System.out.println("Parting skipped. Already parted properly.");
            return;
        }
        InputStream resourceAsStream = DictionarySplitterMPJ.class.getClassLoader().getResourceAsStream("slownik.dic");
        if (resourceAsStream == null)
            throw new IllegalArgumentException("Dictionary file not found!");
        files = new ArrayList<>();
        try (var lines = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8)).lines()) {
            List<String> linesList = lines.collect(Collectors.toList());
            int wordsInPart = linesList.size() / partsTotal;
                List<String> linesPartList = new ArrayList<>();
                for (int i = part * wordsInPart; i < (part + 1) * wordsInPart - 1; i++) {
                    linesPartList.add(linesList.get(i));
                }
                files.add(linesPartList);
            System.out.println("Parting done");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
