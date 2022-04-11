package day04;

import java.util.ArrayList;
import java.util.List;

public class WebShop {

    private final List<Item> items = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void buyItem(String userName, String itemName) {
        User user = searchUser(userName);
        Item item = searchItem(itemName);
        if (user.getMoney() >= item.getPrice()) {
            user.buy(item.copy());
        }
    }

    private Item searchItem(String itemName) {
        for (Item item : items) {
            if (itemName.equals(item.getName())) {
                return item;
            }
        }
        throw new IllegalArgumentException("Cannot find item!");
    }

    private User searchUser(String userName) {
        for (User user : users) {
            if (userName.equals(user.getUserName())) {
                return user;
            }
        }
        throw new IllegalArgumentException("Cannot find user!");
    }

}
