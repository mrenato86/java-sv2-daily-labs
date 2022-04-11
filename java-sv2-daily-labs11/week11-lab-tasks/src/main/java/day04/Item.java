package day04;

import java.time.LocalDate;

public abstract class Item {

    private String name;
    private int price;
    private LocalDate expirationDate;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getExpirationDate() {
        if (expirationDate == null) {
            throw new IllegalStateException("Depends from the date of purchase!");
        }
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public abstract Item copy();

}
