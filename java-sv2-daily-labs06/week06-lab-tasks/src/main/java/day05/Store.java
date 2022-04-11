package day05;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<ProductWithPiece> numberOfProductsByType() {
        List<ProductWithPiece> result = new ArrayList<>();
        for (Product actual : products) {
            ProductWithPiece found = containsProduct(actual, result);
            if (found != null) {
                found.incrementCount();
            } else {
                result.add(new ProductWithPiece(actual.getType()));
            }
        }
        return result;
    }

    private ProductWithPiece containsProduct(Product product, List<ProductWithPiece> productsPieceList) {
        for (ProductWithPiece pwp : productsPieceList) {
            if (product.getType() == pwp.getType()) {
                return pwp;
            }
        }
        return null;
    }

}
