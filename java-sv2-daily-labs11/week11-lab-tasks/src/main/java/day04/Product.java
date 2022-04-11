package day04;

import java.time.LocalDate;

public class Product extends Item {

    public static final int DEFAULT_WARRANTY_MONTHS = 3;

    public Product(String name, int price) {
        super(name, price);
    }

    @Override
    public Product copy() {
        Product product = new Product(this.getName(),this.getPrice());
        product.setExpirationDate(LocalDate.now().plusMonths(DEFAULT_WARRANTY_MONTHS));
        return product;
    }

    public void addExtraGuarantee(int years){
        setExpirationDate(LocalDate.now().plusYears(years));
    }

}
