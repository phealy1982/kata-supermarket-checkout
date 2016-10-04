package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by peterhealy on 03/10/2016.
 */
public class ReceiptTest {


    private static final Double PRICE_OF_RICE = 1.23;

    @Test public void should_be_able_add_item_to_receipt() throws Exception {

        Receipt receipt = new Receipt();

        Product riceProduct = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));

        receipt.addItem(riceProduct, PRICE_OF_RICE);

        assertThat(receipt.items()).contains(riceProduct);

    }

    @Test public void should_know_total_price() throws Exception {

        Receipt receipt = new Receipt();

        Product riceProduct = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));

        Product anotherRiceProduct = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));

        receipt.addItem(riceProduct, PRICE_OF_RICE);
        receipt.addItem(anotherRiceProduct, PRICE_OF_RICE);

        assertThat(receipt.getTotalPrice()).isEqualTo(PRICE_OF_RICE * 2);

    }
}
