public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        boolean running = true;

        while (running) {
            System.out.println("\n==== Restaurant Order System ====");
            System.out.println("1. Add Order");
            System.out.println("2. View Active Orders");
            System.out.println("3. Complete Order");
            System.out.println("4. View Completed Orders");
            System.out.println("5. Exit and Save");

            int choice = InputValidator.getValidatedInteger("Choose an option: ");

            switch (choice) {
                case 1:
                    manager.addOrder();
                    break;
                case 2:
                    manager.viewActiveOrders();
                    break;
                case 3:
                    manager.completeOrder();
                    break;
                case 4:
                    manager.viewCompletedOrders();
                    break;
                case 5:
                    manager.saveAndExit();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
