package net.serenitybdd.dojo.supermarket.model;

/**
 * Created by 66515 on 12/10/2016.
 */
public class TwoForOne {

    public Double apply(LineItem item){
        return 0.0;
    }

    public Double apply(int quantity, Double price) {
        Double totalPrice = 0.0;
        if (isEven(quantity)) {
            totalPrice = (quantity * price) / 2;
        } else if (quantity > 1) {
            totalPrice = (price * (quantity / 2)) + price;
        } else if (quantity == 1) {
            totalPrice = price;
        }

        return totalPrice;
    }

    private boolean isEven(int quantity) {
        return quantity > 1 && quantity % 2 == 0;
    }
}
