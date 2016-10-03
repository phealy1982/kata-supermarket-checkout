package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by peterhealy on 03/10/2016.
 */
public class ReceiptTest {


    @Test public void should_be_able_add_item_to_receipt() throws Exception {

        Receipt receipt = new Receipt();

        Product riceProduct = Product.withName("1kg of Rice").andWithPrice(2.45);

        receipt.addItem(riceProduct);

        assertThat(receipt.items()).contains(riceProduct);

    }

    @Test public void should_know_total_price() throws Exception {

        Receipt receipt = new Receipt();

        Product riceProduct = Product.withName("1kg of Rice").andWithPrice(2.45);

        Product anotherRiceProduct = Product.withName("1kg of Rice").andWithPrice(2.45);

        receipt.addItem(riceProduct);
        receipt.addItem(anotherRiceProduct);

        assertThat(receipt.getTotalPrice()).isEqualTo(4.90);

    }
}
