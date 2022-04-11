package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> productsSold = new ArrayList<>();

    public List<Product> getProductsSold() {
        return productsSold;
    }

    public void addProduct(Product product) {
        if (product.getDateOfPurchase().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be in the future");
        }
        productsSold.add(product);
    }

    public Path writeProductSoldInMonth(Month month, Path directory) {
        Path path = directory.resolve(month.toString().toLowerCase() + ".csv");
        try {
            Files.write(path, getProductsStringByMonth(month));
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error", ioe);
        }
        return path;
    }

    private List<String> getProductsStringByMonth(Month month) {
        List<String> productsToWrite = new ArrayList<>();
        for (Product product : productsSold) {
            if (product.getDateOfPurchase().getMonth() == month) {
                productsToWrite.add(product.toString());
            }
        }
        return productsToWrite;
    }

}
