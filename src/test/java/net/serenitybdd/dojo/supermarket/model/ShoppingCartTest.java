package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by peterhealy on 04/10/2016.
 */
public class ShoppingCartTest {

    private static final Product RICE = Product.withName("1kg of Rice").andWithBarcode("123");
    private static final Product TOOTHBRUSH = Product.withName("Colgate").andWithBarcode("456");

    @Test public void should_know_how_many_items_are_in_the_cart() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(RICE).times(5);

        assertThat(shoppingCart.numberOfItems()).isEqualTo(5);

    }

    @Test public void should_know_quantity_of_each_product() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(RICE).times(5);
        shoppingCart.addItem(TOOTHBRUSH);

        assertThat(shoppingCart.numberOf(RICE)).isEqualTo(5);
        assertThat(shoppingCart.numberOf(TOOTHBRUSH)).isEqualTo(1);
    }

    @Test
    public void should_have_grouping_of_items_with_count() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(RICE).times(5);
        shoppingCart.addItem(TOOTHBRUSH);

        assertThat(shoppingCart.getItemsWithCount().get(TOOTHBRUSH)).isEqualTo(1);
        assertThat(shoppingCart.getItemsWithCount().get(RICE)).isEqualTo(5);

    }
}
