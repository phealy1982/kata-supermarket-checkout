package net.serenitybdd.dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> items = new ArrayList<>();

    public Double getTotalPrice() {
        return items.stream().mapToDouble(ReceiptItem::price).sum();
    }

    public void add(ReceiptItem receiptItem) {
        items.add(receiptItem);
    }

    public List<ReceiptItem> items() {
        return items;
    }

    public static Receipt withItemsFrom(ShoppingCart theCart) {
        return new Receipt();
    }
}
