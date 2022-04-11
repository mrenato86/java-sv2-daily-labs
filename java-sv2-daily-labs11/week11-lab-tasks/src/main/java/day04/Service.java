package day04;

import java.time.LocalDate;

public class Service extends Item {

    public static final int DEFAULT_EXPIRATION_YEARS = 1;

    public Service(String name, int price) {
        super(name, price);
    }

    @Override
    public Service copy() {
        Service service = new Service(this.getName(), this.getPrice());
        service.setExpirationDate(LocalDate.now().plusYears(DEFAULT_EXPIRATION_YEARS));
        return service;
    }
}
