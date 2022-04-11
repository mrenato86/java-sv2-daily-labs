package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 6, 7));
        o1.addProduct(p1);
        o1.addProduct(p2);
        //o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 6, 7));
        o3.addProduct(p1);
        o3.addProduct(p4);
        //o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o4.addProduct(p3);
        o4.addProduct(p1);


        Order o5 = new Order("pending", LocalDate.of(2021, 6, 7));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p3);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void testFindOrdersByStatus() {
        List<Order> result = orderService.findOrdersByStatus("pending");
        assertEquals("Tv", result.get(0).getProducts().get(0).getName());
        assertEquals(3, result.size());
    }

    @Test
    void testGetNumberOfOrdersWithStatus() {
        long result = orderService.getNumberOfOrdersWithStatus("pending");
        assertEquals(3, result);
    }

    @Test
    void testFindOrdersBetweenDates() {
        List<Order> result = orderService.findOrdersBetweenDates(LocalDate.of(2021, 6, 1),
                LocalDate.of(2021, 6, 8));
        assertEquals(3, result.size());
    }

    @Test
    void testHasOrderWithLessProduct() {
        assertTrue(orderService.hasOrderWithLessProduct(3));
    }

    @Test
    void testGetOrderWithMaxProducts() {
        assertEquals(4, orderService.getOrderWithMaxProducts().getProducts().size());
    }

    @Test
    void testFindOrdersWithProductCategory() {
        List<Order> ordersWithProductCategory = orderService.findOrdersWithProductCategory("Book");
        assertEquals(2, ordersWithProductCategory.size());
    }

}