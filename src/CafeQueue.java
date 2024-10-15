import java.util.*;

class Order {
    int priority;
    int position;

    public Order(int priority, int position) {
        this.priority = priority;
        this.position = position;
    }
}

public class CafeQueue {

    public static int findServingTime(Queue<Order> queue, int friendPosition) {
        int servedOrders = 0;

        while (!queue.isEmpty()) {
            // Find the highest priority order in the queue
            Order highestPriorityOrder = findHighestPriority(queue);

            // Serve the highest priority order
            servedOrders++;

            // If the highest priority order is Raj's friend's order, return the served count
            if (highestPriorityOrder.position == friendPosition) {
                return servedOrders;
            }

            // Remove the served order from the queue
            queue.remove(highestPriorityOrder);

            // Increase priority of orders that are in the queue before the served order
            increasePriorityBefore(queue, highestPriorityOrder);
        }

        return -1; // If the friend's order is not found (should not happen in valid input)
    }

    // Function to find the highest priority order
    private static Order findHighestPriority(Queue<Order> queue) {
        Order highestPriorityOrder = null;
        for (Order order : queue) {
            if (highestPriorityOrder == null || order.priority > highestPriorityOrder.priority ||
                    (order.priority == highestPriorityOrder.priority && order.position < highestPriorityOrder.position)) {
                highestPriorityOrder = order;
            }
        }
        return highestPriorityOrder;
    }

    // Function to increase priority of all orders before the served order
    private static void increasePriorityBefore(Queue<Order> queue, Order servedOrder) {
        for (Order order : queue) {
            if (order.position < servedOrder.position) {
                order.priority += 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of orders in the queue
        System.out.println("Enter the number of orders:");
        int n = scanner.nextInt();

        // Input the priority of each order and the position of Raj's friend's order
        System.out.println("Enter the priorities of the orders:");
        Queue<Order> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int priority = scanner.nextInt();
            queue.add(new Order(priority, i));
        }

        // Input the position of Raj's friend's order
        System.out.println("Enter the position of Raj's friend's order (0-based index):");
        int friendPosition = scanner.nextInt();

        // Find after how many orders Raj's friend's order will be served
        int result = findServingTime(queue, friendPosition);

        System.out.println("Raj's friend's order will be served after " + result + " orders.");
    }
}

