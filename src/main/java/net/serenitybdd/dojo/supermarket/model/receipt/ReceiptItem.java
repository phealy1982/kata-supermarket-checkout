package net.serenitybdd.dojo.supermarket.model.receipt;

import net.serenitybdd.dojo.supermarket.model.LineItem;

/**
 * Created by 66515 on 11/10/2016.
 */
public class ReceiptItem {
    private final String text;
    private final int quantity;
    private String specialOfferText;
    private final double price;

    public ReceiptItem(String text, int quantity, String specialOfferText, double price) {
        this.text = text;
        this.quantity = quantity;
        this.specialOfferText = specialOfferText;
        this.price = price;
    }

    public static ReceiptItemBuilder withText(String text) {
        return new ReceiptItemBuilder(text);
    }

    public String text() {
        return text;
    }

    public int quantity() {
        return quantity;
    }

    public double price() {
        return price;
    }

    public String specialOfferText() {
        return specialOfferText;
    }

    public static ReceiptItemBuilder withLineItem(LineItem item) {
        return new ReceiptItemBuilder(item);
    }

    public static class ReceiptItemBuilder {
        private String text;
        private int quantity;
        private double price;
        private String specialOfferText;

        public ReceiptItemBuilder(String text) {
            this.text = text;
            
        }

        public ReceiptItemBuilder(LineItem item) {
            this.text = item.name();
            this.quantity = item.quantity().intValue();
        }

        public ReceiptItemBuilder andQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ReceiptItem andWithPrice(double price) {
            this.price = price;
            return new ReceiptItem(this.text, this.quantity, this.specialOfferText, this.price);
        }

        public ReceiptItemBuilder andSpecialOfferText(String specialOfferText) {
            this.specialOfferText = specialOfferText;
            return this;
        }
    }
}
