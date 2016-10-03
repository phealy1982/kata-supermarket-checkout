package net.serenitybdd.dojo.supermarket.model;

public class Teller {

    private final SupermarketCatalog catalog;

    public Teller(SupermarketCatalog catalog) {

        this.catalog = catalog;
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {

        Receipt receipt = new Receipt();
        for(Product item : theCart.getItems()){
            receipt.addItem(item);
        }
        return receipt;
    }
}
