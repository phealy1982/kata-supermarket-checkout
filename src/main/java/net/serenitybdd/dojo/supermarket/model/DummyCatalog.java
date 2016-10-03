package net.serenitybdd.dojo.supermarket.model;

import java.util.*;

public class DummyCatalog implements SupermarketCatalog {



    private static final Map<String, Product> PRODUCTS = new HashMap<>();

    @Override public void add(Product product) {
        PRODUCTS.put(product.name(), product);
    }

    @Override public List<Product> productList() {
        return new ArrayList<>(PRODUCTS.values());
    }

    @Override public Product productWithName(String name) {
        return PRODUCTS.get(name);
    }
}
