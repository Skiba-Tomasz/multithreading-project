package pl.skibahost.gui;

import pl.skibahost.AppState;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultWindow extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 500;

    private JTable table;
    private JLabel info;
    private Object[] columns = new String[]{"keyWord", "isFound", "searchType", "invocationType", "searchDuration", "taskStartTimeMs", "taskEndTimeMs", "threadHashCode", "delay"};

    public ResultWindow() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        initTable();
        this.info = new JLabel("Wyniki dla ostatnich wyszukiwan");
        add(info, BorderLayout.PAGE_START);
    }

    private void initTable(){
        DefaultTableModel defaultTableColumnModel = new DefaultTableModel(columns, 0);
        this.table = new JTable(defaultTableColumnModel);
        AppState.getInstance().results.forEach(result -> ((DefaultTableModel)table.getModel()).addRow(new Object[]{
                result.keyWord,
                result.isFound,
                result.searchType,
                result.invocationType,
                result.searchDuration,
                result.taskStartTimeMs,
                result.taskEndTimeMs,
                result.threadHashCode,
                result.threadDelay
        }));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
