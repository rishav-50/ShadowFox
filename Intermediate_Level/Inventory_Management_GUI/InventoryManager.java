import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<InventoryItem> itemList = new ArrayList<>();

    public void addItem(InventoryItem item) {
        itemList.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < itemList.size()) {
            itemList.remove(index);
        }
    }

    public void updateItem(int index, InventoryItem newItem) {
        if (index >= 0 && index < itemList.size()) {
            itemList.set(index, newItem);
        }
    }

    public ArrayList<InventoryItem> getItems() {
        return itemList;
    }
}
