public class OrderItem {
    private String name;
    private double price;

    public OrderItem(String name, double price) {
        this.name = name;
        this.price = Math.max(price, 0);
    }

    public double getPrice() {
        return price;
    }

    public void info() {
        System.out.printf("Товар: %s, цена: %s\n", name, price);
    }
}
