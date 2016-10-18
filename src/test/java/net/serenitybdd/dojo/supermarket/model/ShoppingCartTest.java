package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 66515 on 12/10/2016.
 */
public class ShoppingCartTest {
    private Product toothbrush = Product.withName("Toothbrush").andWithBarcode("123");

    @Test
    public void should_be_able_to_add_item_to_cart() throws Exception {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(toothbrush);

        assertThat(cart.items()).contains(toothbrush);
    }
}