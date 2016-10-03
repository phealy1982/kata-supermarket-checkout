package net.serenitybdd.dojo.supermarket;

import net.serenitybdd.dojo.supermarket.model.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenCheckingOutArticlesAtTheSupermarket {

    @Test
    public void an_empty_shopping_cart_should_cost_nothing() {
        // GIVEN
        SupermarketCatalog catalog = new DummyCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart theCart = new ShoppingCart();

        // WHEN

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        // THEN
        assertThat(receipt.getTotalPrice(), equalTo(0.00));

    }

    @Test
    public void a_shopping_cart_should_cost_the_sum_of_prices_of_its_contents() throws Exception {
        // GIVEN
        SupermarketCatalog catalog = new DummyCatalog();
        catalog.add(Product.withName("1kg of Rice").andWithPrice(2.45));
        Teller teller = new Teller(catalog);
        ShoppingCart theCart = new ShoppingCart();
        theCart.addItem(catalog.productWithName("1kg of Rice"));

        // WHEN

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        // THEN
        assertThat(receipt.getTotalPrice(), equalTo(2.45));

    }
}
