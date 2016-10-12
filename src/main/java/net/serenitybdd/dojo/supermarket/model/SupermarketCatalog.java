package net.serenitybdd.dojo.supermarket.model;

import java.util.HashMap;
import java.util.Map;

public class SupermarketCatalog {

    private final Map<Barcode, Double> prices = new HashMap<>();
    private final Map<Barcode, TwoForOne> offers = new HashMap();

    public Double priceFor(int quantity, Barcode barcode) {
        return priceWithOffersApplied(quantity, barcode);
    }

    private Double priceWithOffersApplied(int quantity, Barcode barcode) {
        if (productOnSpecialOffer(barcode)) {
            return applySpecialOffer(quantity, barcode);
        }
        return priceFor(barcode) * quantity;
    }

    private boolean productOnSpecialOffer(Barcode barcode) {
        return offers.containsKey(barcode);
    }

    private Double priceFor(Barcode barcode) {
        return prices.get(barcode);
    }

    private Double applySpecialOffer(int quantity, Barcode barcode) {
        Double priceForItem = priceFor(barcode);
        Double totalPrice = priceForItem * quantity;

        if(offers.containsKey(barcode)){
            totalPrice = offers.get(barcode).apply(quantity, priceForItem);
        }

        return totalPrice;
    }

    public void addWithPrice(Barcode barcode, Double price) {
        prices.put(barcode, price);
    }

    public void addSpecialOffer(Barcode barcode, TwoForOne offer) {
        offers.put(barcode, offer);
    }

    public Double priceFor(LineItem item) {
        return priceWithOffersApplied(item.quantity().intValue(), item.product().barcode());
    }
}
