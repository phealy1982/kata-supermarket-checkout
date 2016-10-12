package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by 66515 on 11/10/2016.
 */
public class ReceiptItemTest {

    @Test
    public void should_have_text_quantity_and_total_price() throws Exception {
        ReceiptItem receiptItem = ReceiptItem.withText("ToothBrush").andQuantity(2).andWithPrice(2.34);

        assertThat(receiptItem.text()).isEqualTo("ToothBrush");
        assertThat(receiptItem.quantity()).isEqualTo(2);
        assertThat(receiptItem.price()).isEqualTo(2.34);
    }

    @Test
    public void should_be_able_to_have_special_offer_text() throws Exception {
        ReceiptItem receiptItem = ReceiptItem.withText("ToothBrush").andQuantity(2).andSpecialOfferText("Two For One").andWithPrice(2.34);
        assertThat(receiptItem.specialOfferText()).isEqualTo("Two For One");
    }
}