import java.util.Arrays;

public class Order {
    private static int orderIdMax = 0;
    private final int orderId;
    private OrderItem[] items;
    private double totalPrice;

    public Order() {
        this.orderId = orderIdMax++;
        this.items = new OrderItem[0];
        this.totalPrice = 0;
    }

    public void addItem(String name, double price) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = new OrderItem(name, price);
        totalPrice += items[items.length - 1].getPrice();
    }

    public void getInfo() {
        System.out.printf("Заказ %s\n", orderId);
        for (OrderItem item : items) {
            item.info();
        }
        System.out.printf("Суммарная цена %s\n", totalPrice);
    }
}
