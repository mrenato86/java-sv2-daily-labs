package day04;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private final List<Item> boughtItems = new ArrayList<>();
    private int money;

    public User(String userName, int money) {
        this.userName = userName;
        this.money = money;
    }

    public void buy(Item item) {
        if (item instanceof Product && money >= 3 * item.getPrice()) {
            ((Product) item).addExtraGuarantee(3);
            money -= item.getPrice() * 0.1;
        }
        money -= item.getPrice();
        boughtItems.add(item);
    }

    public String getUserName() {
        return userName;
    }

    public List<Item> getBoughtItems() {
        return boughtItems;
    }

    public int getMoney() {
        return money;
    }
}
