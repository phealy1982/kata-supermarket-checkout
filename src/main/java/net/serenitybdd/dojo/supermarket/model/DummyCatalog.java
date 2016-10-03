package net.serenitybdd.dojo.supermarket.model;

import java.util.*;

public class DummyCatalog implements SupermarketCatalog {
    private static final Map<String, Product> PRODUCTS = new HashMap<>();

    static{

    }

    @Override
    public static Product productWithName(String name) {
        return PRODUCTS.get(name);
    }

    @Override
    public void addProduct(Product product) {
        PRODUCTS.put(product.name(), product);
    }

    @Override
    public List<Product> listProducts() {
        return new ArrayList<>(PRODUCTS.values());
    }
}
