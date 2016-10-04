package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static net.serenitybdd.dojo.supermarket.model.SpecialOffer.*;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by 66515 on 03/10/2016.
 */
public class SupermarketCatalogTest {

    public static final Product RICE = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));
    private static final double PRICE_OF_RICE = 1.23;

    @Test public void should_be_able_to_add_a_product_with_its_price() throws Exception {
        SupermarketCatalog supermarketCatalog  = new SupermarketCatalog();
        supermarketCatalog.addWithPrice(RICE, PRICE_OF_RICE);

        assertThat(supermarketCatalog.priceFor(1, RICE)).isEqualTo(PRICE_OF_RICE);
    }



    @Test public void should_be_able_to_apply_special_offer() throws Exception {
        SupermarketCatalog supermarketCatalog  = new SupermarketCatalog();
        supermarketCatalog.addWithPrice(RICE, PRICE_OF_RICE);

        supermarketCatalog.addSpecialOffer(RICE, TWO_FOR_ONE);

        assertThat(supermarketCatalog.specialOfferFor(RICE)).isEqualTo(TWO_FOR_ONE);

    }
}
