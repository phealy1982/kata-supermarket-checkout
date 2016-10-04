package net.serenitybdd.dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> items = new ArrayList<>();

    public Double getTotalPrice() {
        Double totalPrice=0.00;
        for(Product item : items){
            totalPrice += 0;
        }
        return totalPrice;
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public List<Product> items() {
        return items;
    }
}
