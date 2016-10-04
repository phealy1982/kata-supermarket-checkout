package net.serenitybdd.dojo.supermarket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by 66515 on 03/10/2016.
 */
public class SupermarketCatalogTest {


    public static final Product RICE = Product.withName("1kg of Rice").andWithPrice(2.45);

    @Test public void should_be_able_to_add_a_product() throws Exception {
        SupermarketCatalog supermarketCatalog  = new SupermarketCatalog();
        supermarketCatalog.add(RICE);

        assertThat(supermarketCatalog.productList()).contains(RICE);

    }

    @Test
    public void should_be_able_to_retrieve_product_details_by_name() throws Exception {
        SupermarketCatalog supermarketCatalog  = new SupermarketCatalog();
        supermarketCatalog.add(RICE);

        assertThat(supermarketCatalog.productWithName("1kg of Rice").name()).isEqualTo("1kg of Rice");
    }

    @Test
    public void should_know_price_of_product() throws Exception {
        SupermarketCatalog supermarketCatalog = catalogWithProducts(RICE);
        assertThat(supermarketCatalog.priceFor(2, RICE)).isEqualTo(RICE.price() * 2);

    }

    private static SupermarketCatalog catalogWithProducts(Product ... products) {
        SupermarketCatalog catalog = new SupermarketCatalog();

        for(Product product : products){
            catalog.add(product);
        }
        return  catalog;
    }
}
