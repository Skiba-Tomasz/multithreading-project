package pl.skibahost.gui;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class RPCPanel extends JPanel {
    private JLabel info;
    private JButton swaggerButton;

    public RPCPanel() {
        setLayout(new GridLayout(2, 1));
        this.info = new JLabel("Uruchom Swagger UI w dymyślnej przeglądarce.");
        add(info);
        this.swaggerButton = new JButton("Uruchom");
        this.swaggerButton.addActionListener(e -> {
            if (!openWebpage())
                JOptionPane.showMessageDialog(this, "Proszę otworzyć w przeglądarce stronę\nhttp://localhost:8080/swagger-ui/index.html");
        });
        add(swaggerButton);
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