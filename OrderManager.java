
import java.util.ArrayList;

public class OrderManager {
    private ArrayList<String> activeOrders;
    private String[] completedOrders;
    private int completedIndex = 0;
    private final int MAX_COMPLETED = 100;

    public OrderManager() {
        activeOrders = FileHandler.loadArrayList("active_orders.txt");
        completedOrders = FileHandler.loadArray("completed_orders.txt", MAX_COMPLETED);
        // Initialize completedIndex
        for (String order : completedOrders) {
            if (order != null) completedIndex++;
        }
    }

    public void addOrder() {
        String order = InputValidator.getValidatedString("Enter order details: ");
        activeOrders.add(order);
        System.out.println("Order added.");
    }

    public void viewActiveOrders() {
        if (activeOrders.isEmpty()) {
            System.out.println("No active orders.");
        } else {
            System.out.println("Active Orders:");
            for (int i = 0; i < activeOrders.size(); i++) {
                System.out.println(i + ": " + activeOrders.get(i));
            }
        }
    }

    public void completeOrder() {
        viewActiveOrders();
        if (activeOrders.isEmpty()) return;

        int index = InputValidator.getValidatedInteger("Enter index of order to complete: ");
        try {
            String completed = activeOrders.remove(index);
            if (completedIndex < MAX_COMPLETED) {
                completedOrders[completedIndex++] = completed;
                System.out.println("Order completed.");
            } else {
                System.out.println("Completed orders archive is full!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public void viewCompletedOrders() {
        if (completedIndex == 0) {
            System.out.println("No completed orders.");
        } else {
            System.out.println("Completed Orders:");
            for (int i = 0; i < completedIndex; i++) {
                System.out.println(i + ": " + completedOrders[i]);
            }
        }
    }

    public void saveAndExit() {
        FileHandler.saveArrayList(activeOrders, "active_orders.txt");
        FileHandler.saveArray(completedOrders, "completed_orders.txt");
        System.out.println("Orders saved. Exiting...");
    }
}
