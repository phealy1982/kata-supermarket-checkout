package net.serenitybdd.dojo.supermarket.model;

import java.util.List;

public interface SupermarketCatalog {

    void add(Product product);

    List<Product> productList();

    Product productWithName(String name);
}
