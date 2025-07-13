public class Main {
    public static void main(String[] args) {
        {
            System.out.println("1) Класс «Кошелек»:");
            Wallet wallet = new Wallet("Кант", 1000);
            System.out.printf("Владелец: %s, баланс: %s\n", wallet.getOwner(), wallet.getMoney());

            wallet = new Wallet("Локк");
            System.out.printf("Владелец: %s, баланс: %s\n", wallet.getOwner(), wallet.getMoney());

            wallet = new Wallet(2000);
            System.out.printf("Владелец: %s, баланс: %s\n", wallet.getOwner(), wallet.getMoney());

            wallet = new Wallet();
            System.out.printf("Владелец: %s, баланс: %s\n", wallet.getOwner(), wallet.getMoney());

            wallet.setMoney(1500);
            System.out.printf("Владелец: %s, баланс: %s\n", wallet.getOwner(), wallet.getMoney());

            wallet.setOwner("Спиноза");
            System.out.printf("Владелец: %s, баланс: %s\n", wallet.getOwner(), wallet.getMoney());

            wallet.setMoney(-100);
            System.out.printf("Владелец: %s, баланс: %s\n", wallet.getOwner(), wallet.getMoney());
        }

        {
            System.out.println();
            System.out.println("2) Игра «Угадай число»:");
            Game game = new Game();

            int guess = 1;
            System.out.printf("Загадал число %s: %s\n", guess, game.checkGuess(guess));

            guess = 50;
            System.out.printf("Загадал число %s: %s\n", guess, game.checkGuess(guess));

            guess = 100;
            System.out.printf("Загадал число %s: %s\n", guess, game.checkGuess(guess));
        }

        {
            System.out.println();
            System.out.println("3) Класс «Телевизор»:");
            TV tv = new TV();
            System.out.printf("Телевизор. Текущий канал: %s, громкость: %s\n", tv.getCurrentChannel(), tv.getVolume());

            tv.setCurrentChannel(50);
            tv.setVolume(25);
            System.out.printf("Телевизор. Текущий канал: %s, громкость: %s\n", tv.getCurrentChannel(), tv.getVolume());

            tv.setCurrentChannel(99);
            System.out.printf("Телевизор. Текущий канал: %s, громкость: %s\n", tv.getCurrentChannel(), tv.getVolume());

            tv.nextChannel();
            System.out.printf("Телевизор. Текущий канал: %s, громкость: %s\n", tv.getCurrentChannel(), tv.getVolume());

            tv.nextChannel();
            System.out.printf("Телевизор. Текущий канал: %s, громкость: %s\n", tv.getCurrentChannel(), tv.getVolume());
        }

        {
            System.out.println();
            System.out.println("4) Система заказа:");
            Order order = new Order();
            order.info();

            order.addItem("Первый товар", 100);
            order.info();

            order.addItem("Второй товар", 200);
            order.info();

            System.out.println();
            Order order2 = new Order();
            order2.info();

            order2.addItem("Третий товар", 300);
            order2.info();

            order2.addItem("Четвертый товар", 400);
            order2.info();

            order2.addItem("Пятый товар", 500);
            order2.info();

            order2.addItem("Шестой товар", -600);
            order2.info();
        }
    }
}