package net.serenitybdd.dojo.supermarket.model.specialoffer;

/**
 * Created by 66515 on 14/10/2016.
 */
public class NullOffer implements SpecialOffer {
    @Override
    public Double apply(Long quantity, Double price) {
        return quantity * price;
    }
}
