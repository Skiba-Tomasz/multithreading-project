package pl.skibahost.gui;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

class TopPanel extends JPanel {
    private DelayPanel delayPanel;
    private JButton showResults;
    private JButton swaggerButton;

    TopPanel(){
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.delayPanel = new DelayPanel();
        add(delayPanel);
        this.swaggerButton = new JButton("RPC");
        this.swaggerButton.addActionListener(e -> {
            if(!openWebpage())
                JOptionPane.showMessageDialog(this, "Proszę otworzyć w przeglądarce stronę\nhttp://localhost:8080/swagger-ui/index.html");
        });
        add(swaggerButton);
        this.showResults = new JButton("Wyniki");
        this.showResults.addActionListener(e -> new ResultWindow());
        add(showResults);
    }

    private boolean openWebpage() {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URI("http://localhost:8080/swagger-ui/index.html#/remote-invocation"));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
