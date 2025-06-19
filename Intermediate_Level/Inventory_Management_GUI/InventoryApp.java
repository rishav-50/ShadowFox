import java.awt.*;
import javax.swing.*;

public class InventoryApp {
    private InventoryManager manager = new InventoryManager();
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> itemList;

    public InventoryApp() {
        frame = new JFrame("Inventory Management System");
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);

        JTextField nameField = new JTextField(10);
        JTextField qtyField = new JTextField(5);
        JTextField priceField = new JTextField(7);

        JButton addButton = new JButton("Add Item");
        JButton updateButton = new JButton("Update Selected");
        JButton deleteButton = new JButton("Delete Selected");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Qty:"));
        panel.add(qtyField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(itemList), BorderLayout.CENTER);

        // Button Actions
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            double price = Double.parseDouble(priceField.getText());

            InventoryItem item = new InventoryItem(name, qty, price);
            manager.addItem(item);
            listModel.addElement(item.toString());

            nameField.setText("");
            qtyField.setText("");
            priceField.setText("");
        });

        updateButton.addActionListener(e -> {
            int index = itemList.getSelectedIndex();
            if (index != -1) {
                String name = nameField.getText();
                int qty = Integer.parseInt(qtyField.getText());
                double price = Double.parseDouble(priceField.getText());

                InventoryItem item = new InventoryItem(name, qty, price);
                manager.updateItem(index, item);
                listModel.set(index, item.toString());
            }
        });

        deleteButton.addActionListener(e -> {
            int index = itemList.getSelectedIndex();
            if (index != -1) {
                manager.removeItem(index);
                listModel.remove(index);
            }
        });

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new InventoryApp();
    }
}
