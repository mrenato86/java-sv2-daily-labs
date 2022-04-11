package day05;

import java.time.LocalDate;

public class Product {

    private String name;
    private LocalDate dateOfPurchase;
    private int price;

    public Product(String name, LocalDate dateOfPurchase, int price) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%dFt", name, dateOfPurchase, price);
    }
}
