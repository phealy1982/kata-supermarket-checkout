package net.serenitybdd.dojo.supermarket;

import net.serenitybdd.dojo.supermarket.model.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class WhenCheckingOutArticlesAtTheSupermarket {

    public static final Product RICE = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));
    public static final Product TOOTHBRUSH = Product.withName("toothbrush").andWithBarcode(new Barcode("456"));
    private static final Double PRICE_OF_TOOTHBRUSH = 1.33;

    @Test
    public void an_empty_shopping_cart_should_cost_nothing() {
        // GIVEN

        Teller teller = new Teller(catalogWithProducts());
        ShoppingCart theCart = new ShoppingCart();

        // WHEN

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        // THEN
        assertThat(receipt.getTotalPrice(), equalTo(0.00));

    }

    @Test
    public void a_shopping_cart_should_cost_the_sum_of_prices_of_its_contents() throws Exception {

        // GIVEN
        Teller teller = new Teller(catalogWithProducts(RICE));
        ShoppingCart theCart = new ShoppingCart();
        theCart.addItem(RICE);

        // WHEN

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        // THEN
        assertThat(receipt.getTotalPrice(), equalTo(2.45));

    }

    @Test
    public void should_present_a_receipt_with_a_list_of_purchases() throws Exception {
        Teller teller = new Teller(catalogWithProducts(RICE, TOOTHBRUSH));
        ShoppingCart theCart = new ShoppingCart();
        theCart.addItem(RICE);
        theCart.addItem(TOOTHBRUSH);

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        assertThat(receipt.items(), contains(RICE, TOOTHBRUSH));
    }

    @Test
    public void should_apply_special_offer_buy_two_get_one_free() throws Exception {
        Teller teller = new Teller(catalogWithProducts(TOOTHBRUSH));
        ShoppingCart theCart = new ShoppingCart();
        theCart.add(TOOTHBRUSH).times(2);

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        assertThat(receipt.getTotalPrice(), equalTo(PRICE_OF_TOOTHBRUSH));

    }

    private static SupermarketCatalog catalogWithProducts(Product ... products) {
        SupermarketCatalog catalog = new SupermarketCatalog();

        for(Product product : products){
            catalog.add(product);
        }
        return  catalog;
    }
}
