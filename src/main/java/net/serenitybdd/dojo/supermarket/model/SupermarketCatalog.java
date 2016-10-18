package net.serenitybdd.dojo.supermarket.model;

import net.serenitybdd.dojo.supermarket.model.specialoffer.NullOffer;
import net.serenitybdd.dojo.supermarket.model.specialoffer.SpecialOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SupermarketCatalog {

    private final Map<Barcode, Double> prices = new HashMap<>();
    private final Map<Barcode, SpecialOffer> offers = new HashMap();

    public Double priceFor(LineItem item) {
        Barcode barcode = item.product().barcode();
        Double priceForItem = priceFor(barcode);
        return Optional.ofNullable(offers.get(barcode)).orElse(new NullOffer()).apply(item.quantity(), priceForItem);
    }

    private Double priceFor(Barcode barcode) {
        return prices.get(barcode);
    }

    public void addWithPrice(Barcode barcode, Double price) {
        prices.put(barcode, price);
    }

    public void addSpecialOffer(Barcode barcode, SpecialOffer offer) {
        offers.put(barcode, offer);
    }
}