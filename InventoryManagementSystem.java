import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Integer> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            inventory.put(item, currentQuantity + quantity);
        } else {
            inventory.put(item, quantity);
        }
    }

    public void removeItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            if (currentQuantity >= quantity) {
                inventory.put(item, currentQuantity - quantity);
            } else {
                System.out.println("Insufficient stock for item: " + item);
            }
        } else {
            System.out.println("Item not found: " + item);
        }
    }

    public int getStockLevel(String item) {
        if (inventory.containsKey(item)) {
            return inventory.get(item);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();

        // Example usage
        system.addItem("Product A", 5);
        system.addItem("Product B", 10);

        System.out.println("Initial stock levels:");
        System.out.println("Product A: " + system.getStockLevel("Product A"));
        System.out.println("Product B: " + system.getStockLevel("Product B"));

        system.removeItem("Product A", 2);

        System.out.println("Updated stock levels:");
        System.out.println("Product A: " + system.getStockLevel("Product A"));
        System.out.println("Product B: " + system.getStockLevel("Product B"));
    }
}
