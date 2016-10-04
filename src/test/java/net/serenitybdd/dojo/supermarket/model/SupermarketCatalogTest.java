package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by 66515 on 03/10/2016.
 */
public class SupermarketCatalogTest {

    public static final Product RICE = Product.withName("1kg of Rice").andWithBarcode(new Barcode("123"));
    private static final double PRICE_OF_RICE = 1.23;

    @Test public void should_be_able_to_add_a_product() throws Exception {
        SupermarketCatalog supermarketCatalog  = new SupermarketCatalog();
        supermarketCatalog.add(RICE);

        assertThat(supermarketCatalog.productList()).contains(RICE);
    }

    @Test
    public void should_be_able_to_retrieve_product_price_based_on_barcode() throws Exception {
        SupermarketCatalog supermarketCatalog = catalogWithProducts(RICE);
        assertThat(supermarketCatalog.priceFor(1, RICE.barcode())).isEqualTo(PRICE_OF_RICE);
    }

    private static SupermarketCatalog catalogWithProducts(Product ... products) {
        SupermarketCatalog catalog = new SupermarketCatalog();

        for(Product product : products){
            catalog.add(product);
        }
        return  catalog;
    }
}