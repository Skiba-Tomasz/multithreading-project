package pl.skibahost.gui;

import pl.skibahost.file.DictionarySplitter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Collections;
import java.util.Random;

class TopPanel extends JPanel {
    private DelayPanel delayPanel;
    private JButton addWordButton;
    private JButton showResults;


    TopPanel(){
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.delayPanel = new DelayPanel();
        add(delayPanel);
        this.addWordButton = new JButton("Dodaj slowo");
        this.addWordButton.addActionListener(this::addWord);
        add(addWordButton);

        this.showResults = new JButton("Wyniki");
        this.showResults.addActionListener(ResultWindow::new);
        add(showResults);
    }

    private void addWord(ActionEvent e) {
        String word = (String)JOptionPane.showInputDialog(
                TopPanel.this,
                "Słowo należy dodać PO UPRZEDNIM PODZIELENIU danych wejściowych.\n" +
                        "Po ponownym rozdzieleniu, słowo zniknie z listy",
                "Podaj słowo",
                JOptionPane.PLAIN_MESSAGE);
        int listIndex = new Random().nextInt(DictionarySplitter.files.size());
        DictionarySplitter.files.get(listIndex).add(word);
        Collections.shuffle(DictionarySplitter.files.get(listIndex));
        JOptionPane.showMessageDialog(this, String.format("Słowo %s zostało dodane do słownika %d", word, listIndex));
    }


}
