package net.serenitybdd.dojo.supermarket.model;

import java.util.HashMap;
import java.util.Map;

public class SupermarketCatalog {

    private static final Map<Barcode, Double> PRICES = new HashMap<>();
    private static final Map<Product, SpecialOffer> OFFERS = new HashMap<>();

    public Double priceFor(int quantity, Product product) {
        return priceWithOffersApplied(quantity, product);
    }

    private Double priceWithOffersApplied(int quantity, Product product) {
        if (productOnSpecialOffer(product)) {
            return applySpecialOffer(quantity, product);
        }
        return priceFor(product) * quantity;
    }

    private boolean productOnSpecialOffer(Product product) {
        return OFFERS.get(product) == SpecialOffer.TWO_FOR_ONE;
    }

    private Double priceFor(Product product) {
        return PRICES.get(product.barcode());
    }

    private Double applySpecialOffer(int quantity, Product product) {
        SpecialOffer offer = OFFERS.get(product);
        int quantityToPrice = quantity;

        if (offer.equals(SpecialOffer.TWO_FOR_ONE)) {
            quantityToPrice = applyTwoForOneSpecialOffer(quantity, quantityToPrice);
        }

        return priceFor(product) * quantityToPrice;
    }

    private int applyTwoForOneSpecialOffer(int quantity, int quantityToPrice) {
        if (quantity > 1 && quantity % 2 == 0) {
            quantityToPrice = quantity / 2;
        } else if (quantity > 1) {
            quantityToPrice = (quantity / 2) + 1;
        }
        return quantityToPrice;
    }

    public void addWithPrice(Product product, Double price) {
        PRICES.put(product.barcode(), price);
    }

    public void addSpecialOffer(Product product, SpecialOffer offer) {
        OFFERS.put(product, offer);
    }

    public SpecialOffer specialOfferFor(Product product) {
        return OFFERS.get(product);
    }
}
