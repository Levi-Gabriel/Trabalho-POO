package items;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<Item> getItems() {
        return items;
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Inventário vazio.");
            return;
        }
        System.out.println("--- Inventário ---");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ") " + items.get(i));
        }
    }
}