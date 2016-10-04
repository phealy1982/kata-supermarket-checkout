package net.serenitybdd.dojo.supermarket;

import net.serenitybdd.dojo.supermarket.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.dojo.supermarket.model.SpecialOffer.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class WhenCheckingOutArticlesAtTheSupermarket {

    private static final Product RICE = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));
    private static final Product TOOTHBRUSH = Product.withName("toothbrush").andWithBarcode(new Barcode("456"));
    private static final Double PRICE_OF_TOOTHBRUSH = 1.33;
    private static final Double PRICE_OF_RICE = 1.23;
    private static final Map<Product, Double> PRICES = new HashMap<>();

    static {
        PRICES.put(RICE, PRICE_OF_RICE);
        PRICES.put(TOOTHBRUSH, PRICE_OF_TOOTHBRUSH);
    }

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
        Teller teller = new Teller(catalogWithProducts(RICE, TOOTHBRUSH));
        ShoppingCart theCart = new ShoppingCart();
        theCart.addItem(TOOTHBRUSH);
        theCart.addItem(TOOTHBRUSH);

        // WHEN

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        // THEN
        assertThat(receipt.getTotalPrice(), equalTo(PRICE_OF_TOOTHBRUSH * 2));

    }

    @Test public void should_know_about_special_offers() throws Exception {
        SupermarketCatalog supermarketCatalog = new SupermarketCatalog();
        supermarketCatalog.addWithPrice(RICE, PRICE_OF_RICE);
        supermarketCatalog.addSpecialOffer(RICE, TWO_FOR_ONE);

        Teller teller = new Teller(supermarketCatalog);

        ShoppingCart theCart = new ShoppingCart();
        theCart.add(RICE).times(3);

        Receipt receipt = teller.checksOutArticlesFrom(theCart);

        assertThat(receipt.getTotalPrice(), equalTo(PRICE_OF_RICE * 2));
    }

    private static SupermarketCatalog catalogWithProducts(Product ... products) {
        SupermarketCatalog catalog = new SupermarketCatalog();

        for(Product product : products){
            catalog.addWithPrice(product, PRICES.get(product));
        }
        return  catalog;
    }
}
