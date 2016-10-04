package net.serenitybdd.dojo.supermarket.model;

import java.util.HashMap;
import java.util.Map;

public class SupermarketCatalog {

    private static final Map<Barcode, Double> PRODUCTS = new HashMap<>();
    private static final Map<Product, SpecialOffer> OFFERS = new HashMap<>();

    public Double priceFor(int quantity, Product product) {
        if (OFFERS.get(product) == SpecialOffer.TWO_FOR_ONE) {
            return applyTwoForOneOffer(quantity, product);
        }
        return PRODUCTS.get(product.barcode()) * quantity;
    }

    private Double applyTwoForOneOffer(int quantity, Product product) {
        int quantityToPrice = quantity;
        if (quantity > 1 && quantity % 2 == 0) {
            quantityToPrice = quantity / 2;
        } else if (quantity > 1){
            quantityToPrice = (quantity / 2) + 1;
        }
        return PRODUCTS.get(product.barcode()) * quantityToPrice;
    }

    public void addWithPrice(Product product, Double price) {
        PRODUCTS.put(product.barcode(), price);
    }

    public void addSpecialOffer(Product product, SpecialOffer offer) {
        OFFERS.put(product, offer);
    }

    public SpecialOffer specialOfferFor(Product product) {
        return OFFERS.get(product);
    }
}
