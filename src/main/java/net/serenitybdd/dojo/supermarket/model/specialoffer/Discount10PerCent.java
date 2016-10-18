package net.serenitybdd.dojo.supermarket.model.specialoffer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by 66515 on 12/10/2016.
 */
public class Discount10PerCent implements SpecialOffer {

    @Override
    public Double apply(Long quantity, Double price) {
        Double totalPrice = quantity * price;
        Double discountedPrice = totalPrice - tenPercentOf(totalPrice);
        return round(discountedPrice, 2);
    }

    private double tenPercentOf(Double totalPrice) {
        return totalPrice * 0.10;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
