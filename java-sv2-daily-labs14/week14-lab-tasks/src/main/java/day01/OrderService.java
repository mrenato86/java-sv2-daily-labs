package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public long getNumberOfOrdersWithStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .count();
    }

    public List<Order> findOrdersBetweenDates(LocalDate start, LocalDate end) {
        return orders.stream()
                .filter(o -> o.getOrderDate().isAfter(start) && o.getOrderDate().isBefore(end))
                .collect(Collectors.toList());
    }

    public boolean hasOrderWithLessProduct(int count) {
        return orders.stream()
                .anyMatch(o -> o.getProducts().size() < count);
    }

    public Order getOrderWithMaxProducts() {
        return orders.stream()
                .max(Comparator.comparingInt(o -> o.getProducts().size()))
                .orElseThrow(() -> new IllegalArgumentException("No such order"));
    }

    public List<Order> findOrdersWithProductCategory(String category) {
        return orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equals(category)))
                .collect(Collectors.toList());
    }

    public List<Product> findProductsOverPrice(int price) {
        return orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
    }

}