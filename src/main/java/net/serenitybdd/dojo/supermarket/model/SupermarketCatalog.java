package net.serenitybdd.dojo.supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupermarketCatalog {

    private static final Map<Barcode, Product> PRODUCTS = new HashMap<>();

     public void add(Product product) {
        PRODUCTS.put(product.barcode(), product);
    }

     public List<Product> productList() {
        return new ArrayList<>(PRODUCTS.values());
    }

     public Product productWithName(String name) {
        return PRODUCTS.get(name);
    }

    public Double priceFor(int quantity, Barcode barcode) {
        return PRODUCTS.get(barcode).price()  * quantity;
    }
}