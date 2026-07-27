package StrategyDesignPattern.Task1;
import java.util.*;
interface PaymentStrategy {
    void pay(int amount);
}
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;
    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}
class PayPalPayment implements PaymentStrategy {
    private String email;
    public PayPalPayment(String email) {
        this.email = email;
    }
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}
class Item {
    private String name;
    private int price;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public int calculateTotal() {
        int total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void pay(PaymentStrategy strategy) {
        int amount = calculateTotal();
        strategy.pay(amount);
    }
}
public class PaymentStrategyMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Item("Book", 20));
        cart.addItem(new Item("Pen", 10));

        // Paying with Credit Card
        cart.pay(new CreditCardPayment("123456789", "Wajid"));

        // Switching to PayPal
        cart.pay(new PayPalPayment("user@email.com"));
    }
}
