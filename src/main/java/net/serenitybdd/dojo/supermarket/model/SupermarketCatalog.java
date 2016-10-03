package net.serenitybdd.dojo.supermarket.model;

import java.util.List;

public interface SupermarketCatalog {

    static abstract Product productWithName(String name);

    void addProduct(Product product);

    List<Product> listProducts();
}
