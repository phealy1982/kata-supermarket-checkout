package net.serenitybdd.dojo.supermarket.model.specialoffer;

/**
 * Created by peterhealy on 04/10/2016.
 */
public interface SpecialOffer {
    Double apply(Long quantity, Double price);

}
