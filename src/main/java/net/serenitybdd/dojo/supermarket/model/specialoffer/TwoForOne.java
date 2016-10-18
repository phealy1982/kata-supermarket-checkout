package net.serenitybdd.dojo.supermarket.model.specialoffer;

/**
 * Created by 66515 on 12/10/2016.
 */
public class TwoForOne implements SpecialOffer {

    @Override
    public Double apply(Long quantity, Double priceForOne) {
        Double totalPrice = 0.0;
        if (isEven(quantity)) {
            totalPrice = (quantity * priceForOne) / 2;
        } else if (quantity > 1) {
            totalPrice = (priceForOne * (quantity / 2)) + priceForOne;
        } else if (quantity == 1) {
            totalPrice = priceForOne;
        }
        return totalPrice;
    }

    private boolean isEven(Long quantity) {
        return quantity > 1 && quantity % 2 == 0;
    }
}
