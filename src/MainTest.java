import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void walletTest() {
        final String ownerUnknown = "Неизвестный";

        String owner = "Аристотель";
        double money = 3000;
        Wallet wallet = new Wallet(owner, money);
        Assertions.assertEquals(owner, wallet.getOwner());
        Assertions.assertEquals(money, wallet.getMoney());

        owner = "Аристотель";
        wallet = new Wallet(owner);
        Assertions.assertEquals(owner, wallet.getOwner());
        Assertions.assertEquals(0, wallet.getMoney());

        money = 3000;
        wallet = new Wallet(money);
        Assertions.assertEquals(ownerUnknown, wallet.getOwner());
        Assertions.assertEquals(money, wallet.getMoney());

        wallet = new Wallet();
        Assertions.assertEquals(ownerUnknown, wallet.getOwner());
        Assertions.assertEquals(0, wallet.getMoney());

        owner = "Аристотель";
        wallet.setOwner(owner);
        Assertions.assertEquals(owner, wallet.getOwner());

        money = 5000;
        wallet.setMoney(money);
        Assertions.assertEquals(money, wallet.getMoney());

        wallet.setMoney(-150);
        Assertions.assertEquals(money, wallet.getMoney());

        wallet.spend((int)money + 50);
        Assertions.assertEquals(money, wallet.getMoney());

        wallet.spend(-50);
        Assertions.assertEquals(money, wallet.getMoney());

        wallet.spend(20);
        Assertions.assertEquals(money - 20, wallet.getMoney());
    }

    @Test
    void tvTest() {
        TV tv = new TV();
        Assertions.assertEquals(0, tv.getCurrentChannel());
        Assertions.assertEquals(0, tv.getVolume());

        int currentChannel = 15;
        tv.setCurrentChannel(currentChannel);
        Assertions.assertEquals(currentChannel, tv.getCurrentChannel());

        tv.setCurrentChannel(150);
        Assertions.assertEquals(currentChannel, tv.getCurrentChannel());

        tv.setCurrentChannel(-50);
        Assertions.assertEquals(currentChannel, tv.getCurrentChannel());

        currentChannel = 99;
        tv.setCurrentChannel(currentChannel);
        Assertions.assertEquals(currentChannel, tv.getCurrentChannel());

        tv.setCurrentChannel(++currentChannel);
        Assertions.assertEquals(currentChannel, tv.getCurrentChannel());

        tv.nextChannel();
        Assertions.assertEquals(currentChannel, tv.getCurrentChannel());
    }

    @Test
    void orderItemTest() {
        double price = 123;
        OrderItem orderItem = new OrderItem("Какой-то товар", price);

        Assertions.assertEquals(price, orderItem.getPrice());

        orderItem.info();
        Assertions.assertEquals("Товар: Какой-то товар, цена: 123.0", outputStreamCaptor.toString().trim());

        orderItem = new OrderItem("Какой-то другой товар", -321);

        Assertions.assertEquals(0, orderItem.getPrice());

        outputStreamCaptor.reset();
        orderItem.info();
        Assertions.assertEquals("Товар: Какой-то другой товар, цена: 0.0", outputStreamCaptor.toString().trim());
    }

    @Test
    void orderTest() {
        Order order = new Order();

        order.info();
        Assertions.assertEquals("Заказ 0\nСуммарная цена 0.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        order.addItem("Товар", 1000);
        order.info();
        Assertions.assertEquals("Заказ 0\nТовар: Товар, цена: 1000.0\nСуммарная цена 1000.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        order.addItem("Еще товар", -500);
        order.info();
        Assertions.assertEquals("Заказ 0\nТовар: Товар, цена: 1000.0\nТовар: Еще товар, цена: 0.0\nСуммарная цена 1000.0", outputStreamCaptor.toString().trim());
    }
}