package piechart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

class EvenOddRenderer implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
        Component renderer =
            DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color foreground, background;
        if (isSelected) {
            foreground = Color.YELLOW;
            background = Color.GREEN;
        } else {
            if (row % 2 == 0) {
                foreground = Color.BLUE;
                background = Color.WHITE;
            } else {
                foreground = Color.WHITE;
                background = Color.BLUE;
            }
        }
        renderer.setForeground(foreground);
        renderer.setBackground(background);
        return renderer;
    }
}

public class ResizeTable {
    public static void main(String args[]) {

        final Object rowData[][] = { { "1", "one", "I" }, { "2", "two", "II" }, { "3", "three", "III" } };
        final String columnNames[] = { "#", "English", "Roman" };

        final JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        table.setDefaultRenderer(Object.class, new EvenOddRenderer());

        JFrame frame = new JFrame("Resizing Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(300, 150);
        frame.setVisible(true);

    }
}