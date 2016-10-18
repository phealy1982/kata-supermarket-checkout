package net.serenitybdd.dojo.supermarket.model;

import net.serenitybdd.dojo.supermarket.model.receipt.Receipt;
import net.serenitybdd.dojo.supermarket.model.receipt.ReceiptItem;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Teller {

    private final SupermarketCatalog catalog;

    public Teller(SupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {

        Receipt receipt = new Receipt();
        for(LineItem item : aggregate(theCart)){
            receipt.add(ReceiptItem.
                            withLineItem(item).
                            andWithPrice(catalog.priceFor(item)));
        }
        return receipt;
    }

    public List<LineItem> aggregate(ShoppingCart cart) {
        return cart.items().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().map(LineItem::create).collect(Collectors.toList());
    }
}
