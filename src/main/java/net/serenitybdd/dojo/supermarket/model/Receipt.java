package net.serenitybdd.dojo.supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipt {
    private Map<Product, Double> items = new HashMap<>();

    public Double getTotalPrice() {
        Double totalPrice=0.00;
        for(Double price : items.values()){
            totalPrice += price;
        }
        return totalPrice;
    }

    public void addItem(Product product, Double price) {
        items.put(product, price);
    }

    public List<Product> items() {
        return new ArrayList<>(items.keySet());
    }
}
